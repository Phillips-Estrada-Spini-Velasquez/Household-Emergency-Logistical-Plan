package help.controllers;

import help.models.Group;
import help.models.User;
import help.repositories.GroupRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {
    private final GroupRepository groupDao;

    public GroupController(GroupRepository groupDao) {
        this.groupDao = groupDao;
    }

    @GetMapping("/groups/create")
    public String showSignupForm(Model model){
        model.addAttribute("group", new Group());
        return "groups/create";
    }
    @PostMapping("/create")
    public String createGroup(@ModelAttribute Group group){
        // set flag values for a create email
        if (group.getId() == 0) {
            User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            group.setOwner(thisAuthor);
        }
        // set flag values for an edit email
        else {
            group.setOwner(groupDao.getOne(group.getId()).getOwner());
        }
        groupDao.save(group);
        return "redirect:/profile";
    }
}
