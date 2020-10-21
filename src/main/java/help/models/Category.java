package help.models;

import help.repositories.CategoryRepository;

public class Category {
    private final CategoryRepository categoryDao;

    public Category(CategoryRepository categoryDao) {
        this.categoryDao = categoryDao;
    }

}
