package com.codecool.elgrande.service;

import com.codecool.elgrande.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User getUserById(int id);
    void deleteUserById(int id);
    void addNewUser(User user);
}
