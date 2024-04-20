package com.example.demo.delivery;

import jakarta.persistence.*;

@Entity
@Table
public class Delivery {
    @Id
    @SequenceGenerator(
            name = "delivery_sequence",
            sequenceName = "delivery_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "delivery_sequence"
    )
    private Long deliveryId;
    private Long supplierId;
    private Long productId;
    private Long quantity;

    public Delivery() {
    }

    public Delivery(Long deliveryId, Long supplierId, Long productId, Long quantity) {
        this.deliveryId = deliveryId;
        this.supplierId = supplierId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Delivery(Long supplierId, Long productId, Long quantity) {
        this.supplierId = supplierId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

