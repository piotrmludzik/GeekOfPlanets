package com.codecool.geekofplanets.world.jdbc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.codecool.geekofplanets.world.jdbc.repository",
        entityManagerFactoryRef = "gameEntityManagerFactory",
        transactionManagerRef= "gameTransactionManager")
public class GameDatabaseConfig {
    @Bean
    @Primary
    @ConfigurationProperties("spring.game-datasource")
    public DataSourceProperties gameDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="gameDB")
    @Primary
    @ConfigurationProperties("spring.game-datasource.configuration")
    public DataSource gameDataSource() {
        return gameDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "gameEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean gameEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(gameDataSource())
                .packages("com.codecool.geekofplanets.world.jdbc.model")
                .build();
    }
    @Primary
    @Bean
    public PlatformTransactionManager gameTransactionManager(
            final @Qualifier("gameEntityManagerFactory") LocalContainerEntityManagerFactoryBean gameEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(gameEntityManagerFactory.getObject()));
    }
}
