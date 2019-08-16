package com.store.app.service;

import com.store.app.bean.ProductBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreService {
    private List<ProductBean> list;

    public StoreService() {
        list = new ArrayList<ProductBean>();
        list.add(new ProductBean(1,"apple",  10));
        list.add(new ProductBean(2, "banana", 10));
        list.add(new ProductBean(3, "orange", 15));
        list.add(new ProductBean(4, "strawberry", 20));
    }

    public List getList() {
        return this.list;
    }

    public ProductBean findId(int id) {
        for (ProductBean productBean : list) {
            if(productBean.getProductId() == id) {
                return productBean;
            }
        }
        throw new RuntimeException();
    }
}
