package com.store.app.service;

import com.store.app.entity.Product;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Service;
import org.hibernate.search.jpa.FullTextEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.search.query.dsl.QueryBuilder;
import org.apache.lucene.search.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchService {

    private final EntityManager entityManager;

    public  SearchService(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }


    public void initializeSearch() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<Product> fuzzySearch(String searchTerm) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("name")
                .matching(searchTerm).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Product.class);

        // execute search

        List<Product> productList = null;
        try {
            productList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            ;// do nothing

        }

        return productList;


    }





}
