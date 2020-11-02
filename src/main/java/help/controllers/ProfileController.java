package help.controllers;

import help.models.Document;
import help.models.Group;
import help.models.User;
import help.repositories.DocumentRepository;
import help.repositories.GroupRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    private final UserRepository userDao;
    private final GroupRepository groupDao;
    private final DocumentRepository documentDao;
    public ProfileController(UserRepository userDao, GroupRepository groupDao, DocumentRepository documentDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.documentDao = documentDao;
    }
    @GetMapping("/profile")
    public String showProfileDetails(Model model) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getOne(thisAuthor.getId()));
        model.addAttribute("documents", documentDao.findAllByOwner(thisAuthor));
        return "users/profile";
    }

    @PostMapping("/profile/submit-document")
    public String submitDocument(@ModelAttribute Document document, @RequestParam String url) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        document.setOwner(thisAuthor);
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group authorGroup = thisUser.getGroup();
        long groupId = authorGroup.getId();
        Group currentGroup = groupDao.getOne(groupId);
        document.setGroup(currentGroup);
        System.out.println();
        document.setUrl(url);
        documentDao.save(document);
        return "redirect:/profile";
    }
}