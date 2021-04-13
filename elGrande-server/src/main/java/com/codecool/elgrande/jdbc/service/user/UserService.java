package com.codecool.elgrande.jdbc.service.user;

import com.codecool.elgrande.model.user.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User getUserById(int id);
    User getUserByUsername(String username);
    void deleteUserById(int id);
    void addNewUser(User user);
}
