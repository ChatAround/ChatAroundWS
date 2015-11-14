package com.chataround.chataroundws.config.persistance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Georgia Grigoriadou
 */
@Configuration
@Profile("Production")
public class PostgresConfig {
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/chataround");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        return dataSource;
    }
}
