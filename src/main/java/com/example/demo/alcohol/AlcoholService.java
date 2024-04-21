package com.example.demo.alcohol;

import com.example.demo.general.Product;
import com.example.demo.general.ProductType;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcoholService {
    private final AlcoholRepository alcoholRepository;
    @Autowired
    public AlcoholService(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository; 
    }

    public Product searchByCipher(String cipher) {
        String sql = "SELECT * FROM Alcohol WHERE Cipher = ?";
        System.out.println("Searching for alcohol with cipher: " + cipher);
        List<Alcohol> alcohol = null;
        try {
            alcohol = alcoholRepository.findByCipherContaining(cipher);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        Product product = new Product();
        product.setProductType(ProductType.ALCOHOL);
        product.setAlcoholList(alcohol);

        return product;
    }




}
