package com.example.demo.products.alcohol;

import com.example.demo.inventory.Inventory;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table
public class Alcohol {
    @Id
    @SequenceGenerator(
            name = "alcohol_sequence",
            sequenceName = "alcohol_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "alcohol_sequence"
    )
    private Long productID;
    private String cipher;
    private String brand;
    private double price;
    private String description;
    private double volume;

    @OneToOne(cascade = ALL, mappedBy="alcohol")
    private Inventory inventory;

    // Constructor

    public Alcohol() {
    }

    public Alcohol(Long productID, String cipher, String brand, double price, String description, double volume) {
        this.productID = productID;
        this.cipher = cipher;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.volume = volume;
    }

    public Alcohol(String cipher, String brand, double price, String description, double volume) {
        this.cipher = cipher;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
