package com.example.demo.inventory;

import com.example.demo.general.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InventoryController {
    private final InventoryService inventoryService;
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping(path = "/search/cipher")
    public String searchByCipher(@RequestParam String cipher, Model model) {
        List<Inventory> inventoryList = this.inventoryService.searchByCipher(cipher);
        model.addAttribute("inventory", inventoryList);
        return "inventory";
    }
}
