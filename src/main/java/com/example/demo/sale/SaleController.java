package com.example.demo.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SaleController {
    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/addSale")
    public String addDelivery(
            @RequestParam("productCipher") String productCipher,
            @RequestParam("quantity") Long quantity,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Create and save the new delivery
        boolean isSuccess = saleService.addSale(productCipher, quantity);

        if (isSuccess) {
            // Add a flash attribute to indicate that delivery was added
            model.addAttribute("saleAdded", "Sale made!");
        } else {
            // If delivery was not added successfully, add an error message to the model
            model.addAttribute("errorMessage", "Not enough in inventory");
        }

        // Redirect to the same page
        return "addSaleForm";
//        return "redirect:/addSaleForm";
    }
}
