package com.codecool.elgrande.controller;

import com.codecool.elgrande.dto.MessageDto;
import com.codecool.elgrande.jdbc.service.user.AuthoritiesService;
import com.codecool.elgrande.jdbc.service.user.UserService;
import com.codecool.elgrande.model.user.Authorities;
import com.codecool.elgrande.model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

// TODO: verify class name
@RestController
public class UserController {

    private UserService userService;
    private AuthoritiesService authoritiesService;

    @GetMapping("/")
    public MessageDto hello() {
        return new MessageDto("Hello world");
    }

    @GetMapping("/secured")
    public MessageDto helloSecured() {
        return new MessageDto("Hello secured");
    }

    @GetMapping("/register")
    public ModelAndView addNewUser() {
        return new ModelAndView("register", "user", new User());
    }

    @PostMapping("/register")
    public MessageDto handleGenreForm(@Valid @ModelAttribute("user") User user) {
        userService.addNewUser(user);
        Authorities authorities = new Authorities(user);
        authoritiesService.addNewAuthority(authorities);

        return new MessageDto("Hello registered");
    }

}
