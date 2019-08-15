package com.store.app.bean;



public class ProductBean {
    private String productName;
    private int productCost;
    private String productDescription;

    public ProductBean(String productName, int productCost, String productDescription) {
        this.productName = productName;
        this.productCost = productCost;
        this.productDescription = productDescription;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCost() {
        return productCost;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
