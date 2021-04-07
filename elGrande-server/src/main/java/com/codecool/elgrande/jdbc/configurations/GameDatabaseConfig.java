package com.codecool.elgrande.jdbc.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@Primary
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(basePackages="com.codecool.elgrande.model.game")
public class GameDatabaseConfig {
    @Bean(name="gameDB")
    @ConfigurationProperties(prefix="spring.game-datasource")
    public DataSource gameDataSource() {
        return DataSourceBuilder.create().build();
    }
}
