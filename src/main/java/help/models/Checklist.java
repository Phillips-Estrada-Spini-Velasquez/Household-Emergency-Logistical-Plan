package help.models;

import help.repositories.ChecklistRepository;

public class Checklist {

    private final ChecklistRepository checklistDao;

    public Checklist(ChecklistRepository categoryDao) {
        this.checklistDao = categoryDao;
    }
}
