package help.controllers;

import help.models.Document;
import help.models.User;
import help.repositories.DocumentRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final DocumentRepository documentDao;

    private final UserRepository userDao;

    public HomeController(DocumentRepository documentDao, UserRepository userDao) {
        this.documentDao = documentDao;
        this.userDao = userDao;
    }


    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    @GetMapping("/the-plan")
    public String showThePlan(Model model) {
        User getUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getOne(getUser.getId()).getDocuments());
        model.addAttribute("documentUrl", userDao.getOne(getUser.getId()).getDocuments());
        return "/the-plan/the-plan";
    }


    @PostMapping("/uploaded-document")
    public String saveDocuments(@RequestParam long documentId, @RequestParam String url, @ModelAttribute Document document) {
        Document saveDocument = documentDao.getOne(documentId);
        saveProfile.setProfilePic(url);
        userDao.save(saveProfile);
        return "redirect:/profile";
    }

    @GetMapping("/the-checklist")
    public String showTheChecklist() {
        return "the-plan/the-checklist";
    }

}
