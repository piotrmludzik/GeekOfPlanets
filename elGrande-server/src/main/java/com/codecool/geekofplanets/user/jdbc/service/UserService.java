package com.codecool.geekofplanets.user.jdbc.service;

import com.codecool.geekofplanets.user.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User getUserById(String id);
    User getUserByUsername(String username);
    void deleteUserById(int id);
    void addNewUser(User user);
    void changePermissions(String username);
    void changePassword(String newPassword);
}
