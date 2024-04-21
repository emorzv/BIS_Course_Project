package com.example.demo.products.soda;

import com.example.demo.general.Product;
import com.example.demo.general.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SodaService {
    private final SodaRepository sodaRepository;

    public SodaService(SodaRepository sodaRepository) {
        this.sodaRepository = sodaRepository;
    }

    public Soda createSoda(Soda soda) {
        return sodaRepository.save(soda);
    }

    public Soda updateSoda(Soda soda) {
        return sodaRepository.save(soda);
    }

    public void deleteSoda(Long id) {
        sodaRepository.deleteById(id);
    }

    public Soda getSoda(Long id) {
        return sodaRepository.findById(id).orElse(null);
    }
    public Product searchByCipher(String cipher) {
        String sql = "SELECT * FROM Tobacco WHERE Cipher = ?";
        System.out.println("Searching for tobacco with cipher: " + cipher);
        List<Soda> soda = null;
        try {
            soda = sodaRepository.findByCipherContaining(cipher);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        Product product = new Product();
        product.setProductType(ProductType.TOBACCO);
        product.setSodaList(soda);

        return product;
    }
}
