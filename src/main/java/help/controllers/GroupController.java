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

    @GetMapping("/group/create")
    public String showCreateForm(Model model) {
        model.addAttribute("group", new Group());
        return "groups/create";
    }

    @PostMapping("/create")
    public String createGroup(@ModelAttribute Group group) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        groupDao.save(group);
        thisUser.setGroup(group);
        userDao.save(thisUser);
        return "redirect:/profile";
    }

    @GetMapping("/group/edit")
    public String showEditForm(Model model) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
                model.addAttribute("group", thisUser.getGroup());
        return "edit";
    }


    @PostMapping("/edit")
    public String editGroup(@ModelAttribute Group group) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        groupDao.save(group);
        thisUser.setGroup(group);
        userDao.save(thisUser);
        return "redirect:/profile";
    }

    @GetMapping(path = "/group/delete")
    public String deletePostById(@ModelAttribute Group group) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        groupDao.delete(group);
        userDao.save(thisUser);
        return "redirect:/profile";
    }


}
