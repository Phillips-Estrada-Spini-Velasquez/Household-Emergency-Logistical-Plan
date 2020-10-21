package help.controllers;

import help.repositories.CategoryRepository;

public class CategoryController {
    private final CategoryRepository categoryDao;

    public CategoryController(CategoryRepository categoryDao) {
        this.categoryDao = categoryDao;
    }
}
