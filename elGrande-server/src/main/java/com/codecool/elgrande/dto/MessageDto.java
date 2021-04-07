package com.codecool.elgrande.dto;

import org.springframework.stereotype.Component;

@Component
public class MessageDto {

    private String message;

    public MessageDto() {}

    public MessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
