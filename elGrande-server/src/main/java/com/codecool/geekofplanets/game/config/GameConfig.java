package com.codecool.geekofplanets.game.config;

import com.codecool.geekofplanets.game.config.qualifier.BoardHeight;
import com.codecool.geekofplanets.game.config.qualifier.BoardWidth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:game.properties")
public class GameConfig {
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
