package com.codecool.geekofplanets.game.config;

import com.codecool.geekofplanets.game.config.qualifier.BoardHeight;
import com.codecool.geekofplanets.game.config.qualifier.BoardWidth;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:game.properties")
public class GameConfig {
    @Value("${game.boardHeight}")
    private int boardHeight;

    @Value("${game.boardWidth}")
    private int boardWidth;

    @Value("1000")
    private int initialMetalResource;

    @Value("500")
    private int initialHydrateResource;

    @Value("200")
    private int initialEtherResource;

    @Value("0")
    private int initialAntimaterResource;

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
