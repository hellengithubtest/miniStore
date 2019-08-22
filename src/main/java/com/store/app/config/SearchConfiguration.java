package com.store.app.config;

import com.store.app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@EnableAutoConfiguration
@Configuration
public class SearchConfiguration {

    @Autowired
    private EntityManager entityManager;

    @Bean
    SearchService searchService() {
        SearchService searchService = new SearchService(entityManager);
        searchService.initializeSearch();
        return searchService;
    }
}
