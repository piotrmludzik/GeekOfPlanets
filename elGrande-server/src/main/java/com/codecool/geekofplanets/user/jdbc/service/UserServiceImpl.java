package com.codecool.geekofplanets.user.jdbc.service;

import com.codecool.geekofplanets.user.jdbc.repository.UserRepository;
import com.codecool.geekofplanets.user.model.Authorities;
import com.codecool.geekofplanets.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthoritiesService authoritiesService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthoritiesService authoritiesService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesService = authoritiesService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addNewUser(User user) throws IllegalArgumentException {
        if(usernameExists(user.getUsername())) {
            throw new IllegalArgumentException("Username: " + user.getUsername() + " already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Authorities authorities = new Authorities(user);
        authorities.setAuthority("ROLE_USER");
        authoritiesService.addNewAuthority(authorities);
    }

    private boolean usernameExists(String username) {
        return getUserByUsername(username) != null;
    }

    @Override
    public void changePermissions(String username) {
        if(getUserByUsername(username).getEnabled() == 1) {
            userRepository.takeAwayPermissions();
        }
        userRepository.givePermissions();
    }

    @Override
    public void changePassword(String newPassword) {
        userRepository.changePassword(newPassword);
    }
}
