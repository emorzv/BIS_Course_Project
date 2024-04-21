package com.example.demo.products.tobacco;

import com.example.demo.general.Product;
import com.example.demo.general.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TobaccoService {
    private final TobaccoRepository tobaccoRepository;

    @Autowired
    public TobaccoService(TobaccoRepository tobaccoRepository) {
        this.tobaccoRepository = tobaccoRepository;
    }

    public Product searchByCipher(String cipher) {
        String sql = "SELECT * FROM Tobacco WHERE Cipher = ?";
        System.out.println("Searching for tobacco with cipher: " + cipher);
        List<Tobacco> tobacco = null;
        try {
            tobacco = tobaccoRepository.findByCipherContaining(cipher);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        Product product = new Product();
        product.setProductType(ProductType.TOBACCO);
        product.setTobaccoList(tobacco);

        return product;
    }
}
