package com.example.warehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "items";
    }
    @GetMapping("/category")
    public String category() {
        return "category";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
