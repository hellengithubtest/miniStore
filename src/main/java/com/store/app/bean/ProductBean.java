package com.store.app.bean;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class ProductBean {
    private int productId;
    private String productName;
    private int productCost;

    public ProductBean(int productId, String productName, int productCost) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
    }
}
