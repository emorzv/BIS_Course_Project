package com.example.demo.sale;

import jakarta.persistence.*;

@Entity
@Table
public class Sale {
    @Id
    @SequenceGenerator(
            name = "sale_sequence",
            sequenceName = "sale_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sale_sequence"
    )
    private Long saleId;
    private String productCipher;
    private Long quantity;



    public Sale(Long saleId, String productCipher, Long quantity) {
        this.saleId = saleId;
        this.productCipher = productCipher;
        this.quantity = quantity;
    }

    public Sale(String productCipher, Long quantity) {
        this.productCipher = productCipher;
        this.quantity = quantity;
    }

    public Sale() {
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
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
