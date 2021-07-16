package com.example.springjparelations.controller.productcontroller.model;

public class ProductRequest {
    private String name;
    private String price;

    public ProductRequest() {
    }

    public ProductRequest(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
