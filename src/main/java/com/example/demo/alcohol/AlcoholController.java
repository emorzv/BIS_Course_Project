package com.example.demo.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/storage/alcohol")
public class AlcoholController {

    private final AlcoholService alcoholService;

    @Autowired
    public AlcoholController(AlcoholService alcoholService) {
        this.alcoholService = alcoholService;
    }

    public Alcohol searchByCipher(String cipher) {
        return this.alcoholService.searchByCipher(cipher);
    }
}


