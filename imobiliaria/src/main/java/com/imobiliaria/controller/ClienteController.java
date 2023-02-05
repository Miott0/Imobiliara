package com.imobiliaria.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ClienteController {
    @GetMapping("/imobiliaria/cliente/{nome}&{sobrenome}")
    public String page(@PathVariable("nome") String nome, @PathVariable("sobrenome") String sobrenome) {
        return "Bem Vindo " + nome +" " + sobrenome;
    }
}





    

    
