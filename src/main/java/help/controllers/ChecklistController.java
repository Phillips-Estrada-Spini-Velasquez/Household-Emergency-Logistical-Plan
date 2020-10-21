package help.controllers;

import help.repositories.ChecklistRepository;

public class ChecklistController {
    private final ChecklistRepository checklistDao;

    public ChecklistController(ChecklistRepository categoryDao) {
        this.checklistDao = categoryDao;
    }
}
