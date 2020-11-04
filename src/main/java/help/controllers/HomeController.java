package help.controllers;

import help.models.Group;
import help.models.Item;
import help.models.Message;
import help.models.User;
import help.repositories.DocumentRepository;
import help.repositories.GroupRepository;
import help.repositories.ItemRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final DocumentRepository documentDao;
    private final UserRepository userDao;
    private final GroupRepository groupDao;
    private final ItemRepository itemDao;

    public HomeController(DocumentRepository documentDao, UserRepository userDao, GroupRepository groupDao, ItemRepository itemDao) {
        this.documentDao = documentDao;
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.itemDao = itemDao;
    }

    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    @GetMapping("/info")
    public String showGeneralInfo() {
        return "inside-page";
    }

    @GetMapping("/our-team")
    public String showOurTeam() {
        return "our-team";
    }

    // This will be moved to THEPLANCONTROLLER when we clean up code
    @GetMapping("/items.json")
    public @ResponseBody List<Item> viewAllItemsInJSONFormat() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group group = groupDao.findById(thisUser.getGroupID()).orElse(null);
        if (group == null) {
            //Returns empty list
            return new ArrayList<Item>();
        }
        return group.getItems();
    }

    // This will be moved to THEPLANCONTROLLER when we clean up code
    @GetMapping("/the-plan")
    public String redirectToGroupPlan() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        return "redirect:/the-plan/" + thisUser.getGroup().getId();
    }

    // This will be moved to THEPLANCONTROLLER when we clean up code
    @GetMapping("/the-plan/{id}")
    public String showThePlan(@PathVariable long id, Model model) {
        User getUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(getUser.getId());
        if (thisUser.getGroupID() == id) {
            model.addAttribute("id", thisUser.getGroupID());
            model.addAttribute("documents", documentDao.findAllByOwner(thisUser));
            model.addAttribute("item", new Item());
            return "the-plan/the-plan";
        }
        return "/home";
    }

    // This will be moved to THEPLANCONTROLLER when we clean up code
    @PostMapping("/items/submit")
    public String createMessage(@ModelAttribute Item item) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        item.setOwner(thisAuthor);
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group authorGroup = thisUser.getGroup();
        long groupId = authorGroup.getId();
        Group currentGroup = groupDao.getOne(groupId);
        item.setGroup(currentGroup);
        itemDao.save(item);
        return "redirect:/the-plan";
    }

    @GetMapping("/the-checklist")
    public String showTheChecklist() {
        return "the-plan/the-checklist";
    }

}
