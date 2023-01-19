package peaksoft.service;

import peaksoft.model.User;

import java.util.List;

public interface UserService {

    String createUsersTable();

    String dropUsersTable();

    String saveUser(String name, String lastName, byte age);

    String removeUserById(long id);

    List<User> getAllUsers();

    String cleanUsersTable();
}

