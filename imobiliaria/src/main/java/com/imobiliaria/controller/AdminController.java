package com.imobiliaria.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AdminController {
    
    @GetMapping("/imobiliaria/admin")
    public String page(){
        return "Página dedica ao adm";
    }
}
