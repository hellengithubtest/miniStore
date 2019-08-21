package com.store.app.service;

import com.store.app.bean.ProductBean;

import java.util.List;

public interface ProductService {
    List<ProductBean> findAll();
    ProductBean findById(int id);
    void save(ProductBean productBean);
    int delete(int id);
    void update(ProductBean productBean);

}
