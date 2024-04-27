package com.example.demo.products.soda;

import jakarta.persistence.*;

@Entity
@Table
@EntityListeners(SodaEntityListener.class)
public class Soda {
    @Id
    @SequenceGenerator(
            name = "soda_sequence",
            sequenceName = "soda_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "soda_sequence"
    )
    private Long productID;
    @Column(unique = true)
    private String cipher;
    private String brand;
    private double price;
    private String description;
    private double volume;

    public Soda() {
    }

    public Soda(Long productID, String cipher, String brand, double price, String description, double volume) {
        this.productID = productID;
        this.cipher = cipher;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.volume = volume;
    }

    public Soda(String cipher, String brand, double price, String description, double volume) {
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
