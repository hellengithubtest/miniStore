package com.store.app.dao;

import com.store.app.bean.ProductBean;

import java.util.List;

public interface ProductDao {
    List<ProductBean> findAll();
    List<ProductBean> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(ProductBean productBean);
    void update(ProductBean productBean);
    void delete(Long productId);
}
