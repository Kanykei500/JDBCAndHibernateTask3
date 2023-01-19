package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoJdbcImpl();

    public String createUsersTable() {
        userDao.createUsersTable();
        return "Successfully created";
    }

    public String dropUsersTable() {
        userDao.dropUsersTable();
        return "Successfully deleted";
    }

    public String saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name,lastName,age);
        return "Successfully added";
    }

    public String removeUserById(long id) {
        userDao.removeUserById(id);
        return "Successfully deleted ";
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public String cleanUsersTable() {
        userDao.cleanUsersTable();
        return "Successfully truncated";
    }
}
