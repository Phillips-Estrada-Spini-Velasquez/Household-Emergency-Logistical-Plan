package help.controllers;

import help.models.Doc;
import help.models.Group;
import help.models.Item;
import help.models.User;
import help.repositories.DocRepository;
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
public class ThePlanController {

    private final DocRepository docDao;
    private final UserRepository userDao;
    private final GroupRepository groupDao;
    private final ItemRepository itemDao;

    public ThePlanController(DocRepository docDao, UserRepository userDao, GroupRepository groupDao, ItemRepository itemDao) {
        this.docDao = docDao;
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.itemDao = itemDao;
    }


    @GetMapping("/the-plan")
    public String redirectToGroupPlan() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        return "redirect:/the-plan/" + thisUser.getGroup().getId();
    }

    @GetMapping("/the-plan/{id}")
    public String showThePlan(@PathVariable long id, Model model) {
        User getUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(getUser.getId());
        if (thisUser.getGroupID() == id) {
            model.addAttribute("id", thisUser.getGroupID());
            model.addAttribute("rallyPoint", thisUser.getGroup().getRallyPointCoordinates());
            model.addAttribute("item", new Item());
            model.addAttribute("doc", new Doc());
            return "the-plan/the-plan";
        }
        return "/home";
    }


    //ITEMS

    @GetMapping("/items.json")
    public @ResponseBody
    List<Item> viewAllItemsInJSONFormat() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group group = groupDao.findById(thisUser.getGroupID()).orElse(null);
        if (group == null) {
            return new ArrayList<Item>();
        }
        return group.getItems();
    }

    @PostMapping("/items/submit")
    public String createItem(@ModelAttribute Item item) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        item.setOwner(thisAuthor);
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group authorGroup = thisUser.getGroup();
        long groupId = authorGroup.getId();
        Group currentGroup = groupDao.getOne(groupId);
        item.setGroup(currentGroup);
        itemDao.save(item);
        return "redirect:/the-plan#checklist-items";
    }

    //DOCS
    @GetMapping("/docs.json")
    public @ResponseBody
    List<Doc> viewAllDocsInJSONFormat() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group group = groupDao.findById(thisUser.getGroupID()).orElse(null);
        if (group == null) {
            return new ArrayList<Doc>();
        }
        return group.getDocs();
    }

    @PostMapping("/docs/submit")
    public String createDoc(@ModelAttribute Doc doc) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        doc.setOwner(thisAuthor);
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group authorGroup = thisUser.getGroup();
        long groupId = authorGroup.getId();
        Group currentGroup = groupDao.getOne(groupId);
        doc.setGroup(currentGroup);
        docDao.save(doc);
        return "redirect:/the-plan#document-items";
    }


}
