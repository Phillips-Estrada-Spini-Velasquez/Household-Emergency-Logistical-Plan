package help.controllers;

import help.repositories.ItemCategoryRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ItemCategoryController {
    private final ItemCategoryRepository categoryDao;

    public ItemCategoryController(ItemCategoryRepository categoryDao) {
        this.categoryDao = categoryDao;
    }
}
