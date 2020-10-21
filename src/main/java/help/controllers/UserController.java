package help.controllers;

import help.repositories.UserRepository;

public class UserController {
    private final UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }
}
