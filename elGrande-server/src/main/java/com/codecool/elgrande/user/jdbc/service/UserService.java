package com.codecool.elgrande.user.jdbc.service;

import com.codecool.elgrande.user.model.user.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User getUserById(int id);
    User getUserByUsername(String username);
    void deleteUserById(int id);
    void addNewUser(User user);
    void changePermissions(String username);
    void changePassword(String newPassword);
}
