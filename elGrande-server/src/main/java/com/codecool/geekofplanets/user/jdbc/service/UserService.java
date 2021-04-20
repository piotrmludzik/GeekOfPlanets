package com.codecool.geekofplanets.user.jdbc.service;

import com.codecool.geekofplanets.user.jdbc.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> findAllUsers();
    UserModel getUserById(String id);
    UserModel getUserByUsername(String username);
    void deleteUserById(int id);
    void addNewUser(UserModel user);
    void changePermissions(String username);
    void changePassword(String newPassword);
}
