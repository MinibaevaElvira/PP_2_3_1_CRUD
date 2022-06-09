package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> showAllUsers();
    public void createUser (User user);

    public User findUserById (int id);
    public List<User> update(int id, User user);
    public void deleteById(int id);

}
