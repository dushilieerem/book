package service;

import pojo.User;

public interface userservice {
    public int registUser(User user);
    public User login(User user);
    public boolean existsUsername(String name);
}
