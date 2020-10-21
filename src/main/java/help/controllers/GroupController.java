package help.controllers;

import help.repositories.GroupRepository;

public class GroupController {
    private final GroupRepository groupDao;

    public GroupController(GroupRepository groupDao) {
        this.groupDao = groupDao;
    }
}
