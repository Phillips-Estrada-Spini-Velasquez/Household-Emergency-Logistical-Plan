package help.models;

import help.repositories.UserRepository;

public class User {
    private final UserRepository userDao;

    public User(UserRepository userDao) {
        this.userDao = userDao;
    }
}
