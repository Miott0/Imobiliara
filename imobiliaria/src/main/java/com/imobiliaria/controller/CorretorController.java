package com.imobiliaria.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CorretorController {
    @GetMapping("/imobiliaria/corretor/{nome}&{sobrenome}")
    public String page(@PathVariable("nome") String nome, @PathVariable("sobrenome") String sobrenome) {
        return "Corretor " + nome +" " + sobrenome;
    }
}