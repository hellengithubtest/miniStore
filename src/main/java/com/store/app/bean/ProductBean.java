package com.store.app.bean;



public class ProductBean {
    private int productId;
    private String productName;
    private int productCost;

    public ProductBean(int productId, String productName, int productCost) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCost() {
        return productCost;
    }

    public int getProductId() {
        return productId;
    }
}
