package com.chataround.chataroundws.config.persistance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;

/**
 * @author Georgia Grigoriadou
 */
@Configuration
@Profile("Development")
public class H2Config {
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        String databasePath = System.getProperty("java.io.tmpdir")
                + File.separator + "chataround"
                + File.separator + "chataround";

        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:" + databasePath + ";MODE=PostgreSQL");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }
}
