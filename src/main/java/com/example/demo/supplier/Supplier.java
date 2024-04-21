package com.example.demo.supplier;

import com.example.demo.products.tobacco.TobaccoEntityListener;
import jakarta.persistence.*;

@Entity
@Table
@EntityListeners(SupplierEntityListener.class)
public class Supplier {
    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_sequence"
    )
    private Long supplierId;
    @Column(unique = true)
    private String cipher;
    private String name;

    public Supplier() {
    }

    public Supplier(Long supplierId, String cipher, String name) {
        this.supplierId = supplierId;
        this.cipher = cipher;
        this.name = name;
    }

    public Supplier(String name, String cipher) {
        this.name = name;
        this.cipher = cipher;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", cipher='" + cipher + '\'' +
                '}';
    }
}
