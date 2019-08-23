package com.store.app.service;

import com.store.app.entity.Product;
import com.store.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    @Autowired
    private ProductRepository productRepository;
/*
    public Page<Product> findAll() {
        return productRepository.findAll(new PageRequest(0, 15));
    }*/

    public Page<Product> findAll(int pageNumber, int pageSize) {
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        Page<Product> allProducts = productRepository.findAll(pageable);;
        return allProducts;
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

    public List<Product> search(String name) {
        return  productRepository.findByNameContaining(name);
    }


}