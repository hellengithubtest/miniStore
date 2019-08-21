package com.store.app.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductBean {
    private int productId;
    private String productName;
    private int productCost;

/*    public ProductBean (String productName, int productCost) {
        this.productName = productName;
        this.productCost = productCost;
    }*/
}
