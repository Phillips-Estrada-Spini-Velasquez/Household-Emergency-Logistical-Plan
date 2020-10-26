package help.controllers;

import help.repositories.ChecklistRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ChecklistController {
    private final ChecklistRepository checklistDao;

    public ChecklistController(ChecklistRepository categoryDao) {
        this.checklistDao = categoryDao;
    }
}
