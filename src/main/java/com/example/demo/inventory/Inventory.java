package com.example.demo.inventory;

import com.example.demo.products.alcohol.Alcohol;
import com.example.demo.products.soda.Soda;
import com.example.demo.products.tobacco.Tobacco;
import jakarta.persistence.*;

@Entity
@Table
public class Inventory {
    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventory_sequence"
    )
    private Long entryId;
    private String productCipher;
    private Long quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alcoholCipher", referencedColumnName = "cipher", insertable = false, updatable = false)
    private Alcohol alcohol;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tobaccoCipher", referencedColumnName = "cipher", insertable = false, updatable = false)
    private Tobacco tobacco;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sodaCipher", referencedColumnName = "cipher", insertable = false, updatable = false)
    private Soda soda;

    public Alcohol getAlcohol() {
        return alcohol;
    }

    public Tobacco getTobacco() {
        return tobacco;
    }

    public Soda getSoda() {
        return soda;
    }

    public Inventory(Long entryId, String productCipher, Long quantity) {
        this.entryId = entryId;
        this.productCipher = productCipher;
        this.quantity = quantity;
    }

    public Inventory(String productCipher, Long quantity) {
        this.productCipher = productCipher;
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
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
