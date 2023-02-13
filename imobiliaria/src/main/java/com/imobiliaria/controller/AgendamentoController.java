package com.imobiliaria.controller;

import org.springframework.web.bind.annotation.RestController;

import com.imobiliaria.entities.Agendamento;
import com.imobiliaria.entities.Cliente;
import com.imobiliaria.entities.Corretor;
import java.sql.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/apirest/agendamento")
public class AgendamentoController {
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestParam("data") Date data,
                        @RequestParam("clinte") Cliente cliente,
                        @RequestParam("corretor") Corretor corretor) { 
        Agendamento agendamento = new Agendamento(data, corretor, cliente);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String retornarId(@PathVariable("id") int id){
        return id + " Ok";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String atualizar(@PathVariable("id") int id) {
        return "X";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletar( @RequestParam("id") int id){
        return id + " Agendamento deletado";
    }
}
