package help.controllers;

import com.sun.istack.NotNull;
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
    public String redirectToGroupPlan() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        return "redirect:/the-plan/" + thisUser.getGroup().getId();
    }

    @GetMapping("/info")
    public String showGeneralInfo() {
        return "inside-page";
    }

    @GetMapping("/our-team")
    public String showOurTeam() {
        return "our-team";
    }

  
    @GetMapping("/the-plan/{id}")
    public String showThePlan(@PathVariable long id, Model model) {
        User getUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(getUser.getId());
        model.addAttribute("id", thisUser.getGroupID());
        model.addAttribute("documents", documentDao.findAllByOwner(thisUser));
        if (thisUser.getGroupID() == id) {
            return "the-plan/the-plan";
        }
        return "/home";
    }

    @GetMapping("/the-checklist")
    public String showTheChecklist() {
        return "the-plan/the-checklist";
    }

}
