package com.store.app.service;

import com.store.app.bean.ProductBean;
import com.store.app.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository repo;

    public ProductBean getCurrentId(int id) {
        for (ProductBean productBean : repo.getList()) {
            if(productBean.getProductId() == id) {
                return productBean;
            }
        }
        throw new RuntimeException();
    }

    public List<ProductBean> getAll() {
        return repo.getList();
    }
}
