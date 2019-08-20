package com.store.app;

import com.store.app.dao.ProductDao;
import com.store.app.dao.ProductDaoImpl;
import com.store.app.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    public ProductDao getProductService() {
        return new ProductDaoImpl(getJdbcTemplate());
    }
}
