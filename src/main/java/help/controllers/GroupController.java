package help.controllers;

import help.repositories.GroupRepository;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    private final GroupRepository groupDao;

    public GroupController(GroupRepository groupDao) {
        this.groupDao = groupDao;
    }
}
