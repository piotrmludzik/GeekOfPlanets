package com.codecool.geekofplanets.network.security.authentication;

import com.codecool.geekofplanets.game.controller.GameController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final GameController gameController;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RestAuthenticationSuccessHandler(@Lazy GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        gameController.setPlayer(user.getUsername());

        clearAuthenticationAttributes(request);
    }
}
