package com.example.demo.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByProductCipher(String productCipher);
    List<Delivery> findByProductCipherContaining(String partialCipher);

    List<Delivery> findByProductCipherAndSupplierCipherContaining(String productCipher, String supplierCipher);
    List<Delivery> findBySupplierCipherContaining(String supplierCipher);
}