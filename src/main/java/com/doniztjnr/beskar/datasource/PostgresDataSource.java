package com.doniztjnr.beskar.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Hikari is a JDBC DataSource implementation that provides a
* connection pooling mechanism. Compared to other implementations,
* it promises to be lightweight and better performing
* */

@Configuration
public class PostgresDataSource {

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

}
