package com.example.demo.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
    @RequestMapping(value = "/searchByProductCipher")
    public String searchByProductCipher() {
        return "searchByProductCipher";
    }
}
