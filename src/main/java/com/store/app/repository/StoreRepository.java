package com.store.app.repository;

import com.store.app.bean.ProductBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreRepository {
    private List<ProductBean> list;

    public StoreRepository() {
        list = new ArrayList<ProductBean>();
        list.add(new ProductBean(1,"apple",  10));
        list.add(new ProductBean(2, "banana", 10));
        list.add(new ProductBean(3, "orange", 15));
        list.add(new ProductBean(4, "strawberry", 20));
    }

    public List<ProductBean> getList() {
        return this.list;
    }
}
