package com.example.demo.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/search/cipher")
    public String searchByCipher(@RequestParam String cipher, Model model) {
        Product product = this.productService.searchByCipher(cipher);

        if (product.getProductType().equals(ProductType.ALCOHOL)) {
            model.addAttribute("alcohols", product.getAlcoholList());
            return "alcohols";
        } else if (product.getProductType().equals(ProductType.TOBACCO)) {
            model.addAttribute("tobaccos", product.getTobaccoList());
            return "tobaccos";
        }
        return ""; //TODO: Implement this method

    }
}
