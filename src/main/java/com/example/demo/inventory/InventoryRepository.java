package com.example.demo.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    boolean existsByProductCipher(String productCipher);
    boolean existsByAlcoholCipher(String alcoholCipher);

//    List<Inventory> findByProductCipherContaining(String cipher);
    List<Inventory> findByAlcoholCipherContaining(String partialCipher);
    List<Inventory> findByTobaccoCipherContaining(String partialCipher);
    List<Inventory> findBySodaCipherContaining(String partialCipher);

    @Modifying
    @Transactional
    @Query("UPDATE Inventory i SET i.alcohol.cipher = :alcoholCipher WHERE i.productCipher = :alcoholCipher")
    void updateAlcoholCipherInInventory(String alcoholCipher);

//    @Modifying
//    @Transactional
//    @Query("update Inventory i set i.quantity = i.quantity + :newQuantity where i.productCipher = :productCipher")
//    void updateQuantity(@Param("productCipher") String productCipher, @Param("newQuantity") Long newQuantity);

//    @Modifying
//    @Transactional
//    @Query("update Inventory i set i.quantity = i.quantity + :newQuantity where i.productCipher = :alcoholCipher")
//    void updateAlcoholQuantity(@Param("alcoholCipher") String alcoholCipher, @Param("newQuantity") Long newQuantity);

    @Modifying
    @Transactional
    @Query("update Inventory i set i.quantity = i.quantity + :newQuantity where i.productCipher = :cipher")

    void updateQuantity(@Param("cipher") String cipher, @Param("newQuantity") Long newQuantity);

}
