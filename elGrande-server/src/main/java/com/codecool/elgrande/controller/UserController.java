package com.codecool.elgrande.controller;

import com.codecool.elgrande.dto.MessageDto;
import com.codecool.elgrande.jdbc.service.user.UserService;
import com.codecool.elgrande.model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// TODO: verify class name
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public MessageDto hello() {
        return new MessageDto("Hello world");
    }

    @GetMapping("/secured")
    public MessageDto helloSecured() {
        return new MessageDto("Hello secured");
    }

    @PostMapping("/register")
    public MessageDto handleUserForm(@RequestBody User user) {
        userService.addNewUser(user);

        return new MessageDto("Hello registered");
    }
}
