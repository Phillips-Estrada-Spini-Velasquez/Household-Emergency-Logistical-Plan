package help.models;

import help.repositories.GroupRepository;

public class Group {

    private final GroupRepository groupDao;

    public Group(GroupRepository groupDao) {
        this.groupDao = groupDao;
    }
}
