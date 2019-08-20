package com.store.app.service;

import com.store.app.bean.ProductBean;
import com.store.app.dao.ProductDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements ProductService{
    @Autowired
    private ProductDaoImpl productDao;

    @Override
    public List<ProductBean> findAll() {
        return productDao.findAll();
    }

    @Override
    public ProductBean findById(int id) {
        return productDao.findById(id);
    }
}