package com.store.app.service;

import com.store.app.entity.Product;
import com.store.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class StoreService {
    @Autowired
    private ProductRepository productRepository;
/*
    public Page<Product> findAll() {
        return productRepository.findAll(new PageRequest(0, 15));
    }*/

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product findById(long id) {
        return productRepository.findOne(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public Page<Product> search(String name, Pageable pageable) {
        List<Product> list;
        list = productRepository.findByNameContaining(name);
        System.out.println(list);
        Page<Product> pages = new PageImpl<Product>(list, pageable, list.size());
        return  pages;
    }


}