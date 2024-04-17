package com.example.demo.alcohol;

public class Alcohol {
    private int alcoholID;
    private String cipher;
    private String brand;
    private double volume;
    private double price;
    private int stockQuantity;
    private String description;
    private int supplierID;

    // Constructor
    public Alcohol(int alcoholID, String cipher, String brand,
                   double volume, double price, int stockQuantity, String description, int supplierID) {
        this.alcoholID = alcoholID;
        this.cipher = cipher;
        this.brand = brand;
        this.volume = volume;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.supplierID = supplierID;
    }

    public Alcohol(String cipher, String brand, double volume, double price, int stockQuantity, String description) {
        this.cipher = cipher;
        this.brand = brand;
        this.volume = volume;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    // Getters and setters
    public int getAlcoholID() {
        return alcoholID;
    }

    public void setAlcoholID(int alcoholID) {
        this.alcoholID = alcoholID;
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

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
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

    // toString method to display alcohol details
    @Override
    public String toString() {
        return "Alcohol{" +
                "alcoholID=" + alcoholID +
                ", cipher='" + cipher + '\'' +
                ", brand='" + brand + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                ", supplierID=" + supplierID +
                '}';
    }
}
