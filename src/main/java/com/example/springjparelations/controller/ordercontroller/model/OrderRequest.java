package com.example.springjparelations.controller.ordercontroller.model;

public class OrderRequest {
    private int quantity;
    private Long personId;
    private Long productId;

    public OrderRequest() {
    }

    public OrderRequest(int quantity, Long person_id, Long productId) {
        this.quantity = quantity;
        this.personId = person_id;
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
