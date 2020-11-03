package help.controllers;

import help.repositories.ChecklistItemRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ChecklistItemController {
    private final ChecklistItemRepository checklistItemDao;

    public ChecklistItemController(ChecklistItemRepository checklistItemDao) {
        this.checklistItemDao = checklistItemDao;
    }
}
