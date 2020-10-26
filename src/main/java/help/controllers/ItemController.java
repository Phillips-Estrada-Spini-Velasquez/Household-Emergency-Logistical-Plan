package help.controllers;

import help.repositories.ItemRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {
    private final ItemRepository itemDao;

    public ItemController(ItemRepository itemDao) {
        this.itemDao = itemDao;
    }
}
