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
        list.add(new ProductBean("apple", 2, "green"));
        list.add(new ProductBean("banana", 3, "yellow"));
        list.add(new ProductBean("orange", 4, "orange)"));
        list.add(new ProductBean("apple", 1, "red"));
    }

    public List getList() {
        return this.list;
    }
}
