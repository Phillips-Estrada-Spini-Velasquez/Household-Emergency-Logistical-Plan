package help.controllers;

import help.models.Group;
import help.models.User;
import help.repositories.GroupRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {
    private final GroupRepository groupDao;
    private final UserRepository userDao;

    public GroupController(GroupRepository groupDao, UserRepository userDao) {
        this.groupDao = groupDao;
        this.userDao = userDao;
    }

    @GetMapping("/groups/create")
    public String showSignupForm(Model model) {
        model.addAttribute("group", new Group());
        return "groups/create";
    }

    @PostMapping("/create")
    public String createGroup(@ModelAttribute Group group) {
        // set flag values for a create email
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        group.setOwner(thisAuthor);
        User thisUser = userDao.getOne(group.getOwner().getId());
        thisUser.setGroup(group);
        groupDao.save(group);
        userDao.save(thisUser);
        return "redirect:/profile";
    }
}
