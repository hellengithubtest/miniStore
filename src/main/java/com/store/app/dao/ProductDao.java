package com.store.app.dao;

import com.store.app.bean.ProductBean;
import java.util.List;

public interface ProductDao {
    List<ProductBean> findAll();
    ProductBean findById(int id);
}
