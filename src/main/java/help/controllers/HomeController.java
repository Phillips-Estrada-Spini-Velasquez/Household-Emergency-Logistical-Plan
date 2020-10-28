package help.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homepage() {
        return "/home";
    }

    @GetMapping("/the-plan")
    public String showThePlan() {
        return "/the-plan/the-plan";
    }

    @GetMapping("/the-checklist")
    public String showTheChecklist() {
        return "the-plan/the-checklist";
    }

}
