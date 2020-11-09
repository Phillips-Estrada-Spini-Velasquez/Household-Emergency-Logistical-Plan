package help.controllers;

import help.models.User;
import help.repositories.GroupRepository;
import help.repositories.UserRepository;
import help.services.EmailService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;


@Controller
public class UserController {
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;
    private final GroupRepository groupDao;
    private final EmailService emailService;



    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, GroupRepository groupDao, EmailService emailService) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.groupDao = groupDao;
        this.emailService = emailService;
    }

    //Admin Registration
    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveAdmin(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setAdmin(true);
        userDao.save(user);
        return "redirect:/profile";
    }


    //Member Registration

    //takes admin group number and sets it as the end url path
    @GetMapping("/member/register")
    public String redirectToMemberReg() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        emailService.prepareAndSendUser(thisUser, "tracyvelasquez@outlook.com",("You have been invited to Join " + thisUser.getFirstName() + "'s"), "Click here to join " + thisUser.getFirstName() + " on HELP. " + "http://localhost:8080/help/" + thisUser.getGroup().getId());
        return "redirect:/profile";
        }

    //shows form
    @GetMapping("/member/register/{id}")
    public String memberRegisterForm(@PathVariable long id, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("group", groupDao.getOne(id).getId());
        model.addAttribute("groupName", groupDao.getOne(id).getName());
        return "users/member-register";
    }

    @PostMapping("/member/register/{id}")
    public String saveMember(@ModelAttribute User member, @PathVariable long id) {
        String hash = passwordEncoder.encode(member.getPassword());
        member.setPassword(hash);
        member.setAdmin(false);
        member.setGroup(groupDao.getOne(id));
        userDao.save(member);
        return "redirect:/profile";
    }
}
