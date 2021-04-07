package com.codecool.elgrande.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class JsonObjectAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<String> origins = Arrays.asList("http://localhost:4200");

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader bufferedReader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            UserCredentials user = objectMapper.readValue(sb.toString(), UserCredentials.class);
            System.out.println("Date: " + LocalDateTime.now() + ", " + user);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            setDetails(request, token);

            String originHeader = request.getHeader("Origin");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Origin", origins.contains(originHeader) ? originHeader : "");
            response.setHeader("Vary", "Origin");

            return this.getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
