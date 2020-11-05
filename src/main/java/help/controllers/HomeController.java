package help.controllers;

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
public class HomeController {
    private final DocRepository documentDao;
    private final UserRepository userDao;
    private final GroupRepository groupDao;
    private final ItemRepository itemDao;

    public HomeController(DocRepository documentDao, UserRepository userDao, GroupRepository groupDao, ItemRepository itemDao) {
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



    @GetMapping("/the-checklist")
    public String showTheChecklist() {
        return "the-plan/the-checklist";
    }

}
