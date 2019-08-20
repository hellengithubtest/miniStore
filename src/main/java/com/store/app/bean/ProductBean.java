package com.store.app.bean;

import lombok.Data;

@Data
public class ProductBean {
    private int productId;
    private String productName;
    private int productCost;

    public ProductBean() {

    }
    public ProductBean(int productId, String productName, int productCost) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
    }

}
