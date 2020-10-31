package help.controllers;

import com.sun.istack.NotNull;
import help.models.Document;
import help.models.Group;
import help.models.User;
import help.repositories.DocumentRepository;
import help.repositories.GroupRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DocumentController {
    private final UserRepository userDao;
    private final GroupRepository groupDao;
    private final DocumentRepository documentDao;

    public DocumentController(UserRepository userDao, GroupRepository groupDao, DocumentRepository documentDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.documentDao = documentDao;
    }

    @GetMapping("/filestack")
    public String redirectToGroupPlan() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        return "redirect:/filestack/" + thisUser.getGroup().getId();
    }

    @GetMapping("/filestack/{id}")
    public String showThePlan(@PathVariable long id, Model model) {
        User getUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(getUser.getId());
        model.addAttribute("id", thisUser.getGroupID());
//        model.addAttribute("user", userDao.getOne(thisUser.getId()).getDocuments());
        model.addAttribute("documentUrl", userDao.getOne(thisUser.getId()).getDocuments());
        if (thisUser.getGroupID() == id) {
            model.addAttribute("document", new Document());
            return "filestack";
        }
        return "/home";
    }

    @PostMapping("/filestack/submit-document")
    public String submitDocument(@ModelAttribute Document document) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        document.setOwner(thisAuthor);
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group authorGroup = thisUser.getGroup();
        long groupId = authorGroup.getId();
        Group currentGroup = groupDao.getOne(groupId);
        document.setGroup(currentGroup);
        documentDao.save(document);
        return "redirect:/filestack";
    }

}