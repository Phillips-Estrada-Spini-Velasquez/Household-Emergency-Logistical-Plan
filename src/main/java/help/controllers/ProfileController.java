package help.controllers;

import help.models.User;
import help.repositories.GroupRepository;
import help.repositories.MessageRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final UserRepository userDao;
    private final GroupRepository groupDao;

    public ProfileController(UserRepository userDao, GroupRepository groupDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
    }

    @GetMapping("/profile")
    public String showProfileDetails(Model model) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getOne(thisAuthor.getId()));
        return "users/profile";
    }
}
