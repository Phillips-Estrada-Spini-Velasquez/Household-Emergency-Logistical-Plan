package help.controllers;

import help.repositories.ItemRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {
    private final ItemRepository checklistItemDao;

    public ItemController(ItemRepository checklistItemDao) {
        this.checklistItemDao = checklistItemDao;
    }
}
