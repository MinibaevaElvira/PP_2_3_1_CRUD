package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> showAllUsers();
    public void createUser (User user);

    public User findUserById (int id);
    public  void  update( User user);
    public void deleteById(int id);

}
