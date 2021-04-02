package com.codecool.elgrande.configuration;

import com.codecool.elgrande.configuration.qualifier.BoardHeight;
import com.codecool.elgrande.configuration.qualifier.BoardWidth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:game.properties")
public class GameConfiguration {
    @Value("${game.boardHeight}")
    private int boardHeight;

    @Value("${game.boardWidth}")
    private int boardWidth;

    @Bean
    @BoardHeight
    public int getBoardHeight() {
        return boardHeight;
    }

    @Bean
    @BoardWidth
    public int getBoardWidth() {
        return boardWidth;
    }
}
