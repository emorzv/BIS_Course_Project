package com.example.demo.general;

import com.example.demo.alcohol.Alcohol;
import com.example.demo.alcohol.AlcoholRepository;
import com.example.demo.alcohol.AlcoholService;
import com.example.demo.tobacco.TobaccoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final AlcoholService alcoholService;
    private final TobaccoService tobaccoService;

    @Autowired
    public ProductService(AlcoholService alcoholService, TobaccoService tobaccoService) {
        this.alcoholService = alcoholService;
        this.tobaccoService = tobaccoService;
    }


    //I want to use Template Method pattern here


    public Product searchByCipher(String cipher) {

        Product products;
        if (cipher.startsWith("A")) {
            products = this.alcoholService.searchByCipher(cipher);
        } else if (cipher.startsWith("T")) {
            products = this.tobaccoService.searchByCipher(cipher);
        } else {
            return null;
        }
        //


        return products;
    }

}
