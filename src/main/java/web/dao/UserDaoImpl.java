package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;
    @Override
    public List<User> showAllUsers() {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> update(int id, User user) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
