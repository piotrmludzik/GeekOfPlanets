package com.codecool.elgrande.jdbc.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(basePackages="com.codecool.elgrande.model.user")
public class UsersDatabaseConfig {
    @Bean(name="usersDB")
    @ConfigurationProperties(prefix="spring.users-datasource")
    public DataSource usersDataSource() {
        return DataSourceBuilder.create().build();
    }
}
