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
    private String supplierCipher;
    // This can be changed to cipher
    private String productCipher;
    private Long quantity;

    public Delivery() {
    }

    public Delivery(Long deliveryId, String supplierCipher, String productCipher, Long quantity) {
        this.deliveryId = deliveryId;
        this.supplierCipher = supplierCipher;
        this.productCipher = productCipher;
        this.quantity = quantity;
    }

    public Delivery(String supplierCipher, String productCipher, Long quantity) {
        this.supplierCipher = supplierCipher;
        this.productCipher = productCipher;
        this.quantity = quantity;
    }

    public String getSupplierCipher() {
        return supplierCipher;
    }

    public void setSupplierCipher(String supplierCipher) {
        this.supplierCipher = supplierCipher;
    }

    public String getProductCipher() {
        return productCipher;
    }

    public void setProductCipher(String productCipher) {
        this.productCipher = productCipher;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

