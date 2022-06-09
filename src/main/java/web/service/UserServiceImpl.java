package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    @Transactional
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
    userDao.createUser(user);
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public List<User> update(int id, User user) {
        return userDao.update(id,user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
    userDao.deleteById(id);
    }
}
