package help.controllers;

import help.repositories.ItemCategoryRepository;

public class ItemCategoryController {
    private final ItemCategoryRepository categoryDao;

    public ItemCategoryController(ItemCategoryRepository categoryDao) {
        this.categoryDao = categoryDao;
    }
}
