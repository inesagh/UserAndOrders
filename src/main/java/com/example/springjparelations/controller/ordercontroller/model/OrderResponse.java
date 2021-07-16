package com.example.springjparelations.controller.ordercontroller.model;

import com.example.springjparelations.persistence.model.Person;
import com.example.springjparelations.persistence.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {
    private Long id;
    private int quantity;
    private String trackingNumber;
    private List<Product> products = new ArrayList<>();
    private Person person;

    public OrderResponse() {
    }

    public OrderResponse(Long id, int quantity, String trackingNumber, List<Product> products, Person person) {
        this.id = id;
        this.quantity = quantity;
        this.trackingNumber = trackingNumber;
        this.products = products;
        this.person = person;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
