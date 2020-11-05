package help.controllers;

import help.models.Doc;
import help.models.Group;
import help.models.User;
import help.repositories.DocRepository;
import help.repositories.GroupRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    private final UserRepository userDao;
    private final GroupRepository groupDao;
    private final DocRepository docDao;

    public ProfileController(UserRepository userDao, GroupRepository groupDao, DocRepository docDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.docDao = docDao;
    }
    @GetMapping("/profile")
    public String showProfileDetails(Model model) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getOne(thisAuthor.getId()));
        return "users/profile";
    }

}