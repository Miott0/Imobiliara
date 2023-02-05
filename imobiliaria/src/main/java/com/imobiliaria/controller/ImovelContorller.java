package com.imobiliaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImovelContorller {
    
    @GetMapping("/imobiliaria/imovel/{area}&{negociado}")
    public String page(@PathVariable("area") int area,
                        @PathVariable("negociado") boolean negociado){
    
        return "O imovel tem " + area + "m² de area. Situação: " + (negociado? "negociado":"diposnivel");
    }
}
