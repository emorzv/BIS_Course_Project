package com.example.demo.products.alcohol;

import jakarta.persistence.*;

@Entity
@Table
@EntityListeners(AlcoholEntityListener.class)
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
    @Column(unique = true)
    private String cipher;
    private String brand;
    private double price;
    private String description;
    private int supplierID;
    private double volume;


    // Constructor

    public Alcohol() {
    }

    public Alcohol(Long productID, String cipher, String brand, double price, String description, int supplierID, double volume) {
        this.productID = productID;
        this.cipher = cipher;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.supplierID = supplierID;
        this.volume = volume;
    }

    public Alcohol(String cipher, String brand, double price, String description, int supplierID, double volume) {
        this.cipher = cipher;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.supplierID = supplierID;
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

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
}
