package com.store.app.service;

import com.store.app.bean.ProductBean;

import java.util.List;

public interface ProductService {
    List<ProductBean> findAll();
    ProductBean findById(int id);

}
