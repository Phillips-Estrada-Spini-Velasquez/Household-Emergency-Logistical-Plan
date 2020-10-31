package help.controllers;

import help.models.User;
import help.repositories.DocumentRepository;
import help.repositories.GroupRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final DocumentRepository documentDao;

    private final UserRepository userDao;
    private final GroupRepository groupDao;

    public HomeController(DocumentRepository documentDao, UserRepository userDao, GroupRepository groupDao) {
        this.documentDao = documentDao;
        this.userDao = userDao;
        this.groupDao = groupDao;
    }


    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    @GetMapping("/the-plan")
    public String showThePlan() {
        return "the-plan/the-plan";
    }

//    @GetMapping("/the-plan")
//    public String redirectToGroupPlan() {
//        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User thisUser = userDao.getOne(thisAuthor.getId());
//        return "redirect:/the-plan/" + thisUser.getGroup().getId();
//    }
//
//    @GetMapping("/the-plan/{id}")
//    public String showThePlan(@PathVariable long id, Model model) {
//        User getUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User thisUser = userDao.getOne(getUser.getId());
//        model.addAttribute("user", thisUser);
//        model.addAttribute("group", groupDao.getOne(id).getId());
////        model.addAttribute("user", userDao.getOne(getUser.getId()).getDocuments());
////        model.addAttribute("documentUrl", userDao.getOne(getUser.getId()).getDocuments());
//        return "/the-plan/the-plan";
//    }


//    @PostMapping("/uploaded-document")
//    public String saveDocuments(@RequestParam long documentId, @RequestParam String url, @ModelAttribute Document document) {
//        Document saveDocument = documentDao.getOne(documentId);
//        saveProfile.setProfilePic(url);
//        userDao.save(saveProfile);
//        return "redirect:/profile";
//    }

    @GetMapping("/the-checklist")
    public String showTheChecklist() {
        return "the-plan/the-checklist";
    }

}
