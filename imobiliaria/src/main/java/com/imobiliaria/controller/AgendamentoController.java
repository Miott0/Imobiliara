package com.imobiliaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgendamentoController {
    
    @GetMapping("/imobiliaria/agenda")
    public String page(){
        return "pagina para agendamento";
    }
}
