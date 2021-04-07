package com.codecool.elgrande.controller;

import com.codecool.elgrande.dto.MessageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: verify class name
@RestController
public class LoginController {

    @GetMapping("/")
    public MessageDto hello() {
        return new MessageDto("Hello world");
    }

    @GetMapping("/secured")
    public MessageDto helloSecured() {
        return new MessageDto("Hello secured");
    }

}
