package com.imobiliaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {
    @GetMapping("/imobiliaria/endereco/{rua}&{numero}&{cidade}&{estado}")
    public String page(@PathVariable("rua") String rua,
                        @PathVariable("numero") String numero, 
                        @PathVariable("cidade") String cidade,
                        @PathVariable("estado") String estado) {
        return "Seu endereco " + rua +" - "+ numero+", " + cidade + "-" + estado ;
    }
}
