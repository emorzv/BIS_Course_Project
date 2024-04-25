package com.example.demo.delivery;

import com.example.demo.DemoApplication;
import com.example.demo.inventory.Inventory;
import com.example.demo.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final InventoryService inventoryService;
    @Autowired
    public DeliveryController(InventoryService inventoryService, DeliveryService deliveryService) {
        this.inventoryService = inventoryService;
        this.deliveryService = deliveryService;
    }


    @PostMapping("/addDelivery")
    public String addDelivery(
            @RequestParam("supplierCipher") String supplierCipher,
            @RequestParam("productCipher") String productCipher,
            @RequestParam("quantity") Long quantity,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Create and save the new delivery
        boolean isSuccess = deliveryService.addDelivery(supplierCipher, productCipher, quantity);

        if (isSuccess) {
            // Add a flash attribute to indicate that delivery was added
            redirectAttributes.addFlashAttribute("deliveryAdded", true);
        } else {
            // If delivery was not added successfully, add an error message to the model
            model.addAttribute("errorMessage", "Error occurred while adding delivery");
        }

        // Redirect to the same page
        return "redirect:/addDeliveryForm";
    }


    public void deleteDelivery(Long deliveryId) {
        deliveryService.deleteDelivery(deliveryId);
    }

    @GetMapping(path = "/search/productAndSupplier")
    public String getDeliveriesForProductsAndSupplier(@RequestParam String productCipher, @RequestParam String supplierCipher, Model model) {
        List<Delivery> deliveries = this.deliveryService.searchByCipherAndSupplier(productCipher, supplierCipher);
        model.addAttribute("deliveries", deliveries);

        return "listOfDeliveries";
    }

    @GetMapping(path = "/search/deliveries")
    public String getDeliveriesForProducts(@RequestParam String cipher, Model model) {
        List<Delivery> deliveries = this.deliveryService.searchByCipher(cipher);
        model.addAttribute("deliveries", deliveries);


        return "listOfDeliveries";
    }
    @GetMapping(path= "/search/bySupplier")
    public String getDeliveriesForSupplier(@RequestParam String cipher, Model model) {
        List<Delivery> deliveries = this.deliveryService.searchBySupplier(cipher);
        model.addAttribute("deliveries", deliveries);

        return "quantityOfDeliveries";
    }

    @GetMapping(path = "/search/byProductName")
    public String getDeliveriesByProductName(@RequestParam String brand, Model model) {
        List<Delivery> deliveries = this.deliveryService.searchByProductName(brand);
        model.addAttribute("deliveries", deliveries);

        return "listOfSuppliers";
    }

    @GetMapping(path = "/search/productAndSupplierQuantity")
    public String getProductsAndSupplierQuantity(@RequestParam String productCipher, @RequestParam String supplierCipher, Model model) {
        Delivery delivery = this.deliveryService.getQuantity(productCipher, supplierCipher);
        model.addAttribute("delivery", delivery);
        return "quantityCalculation";
    }


}
