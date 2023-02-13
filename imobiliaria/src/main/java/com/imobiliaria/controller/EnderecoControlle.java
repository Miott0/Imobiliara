package com.imobiliaria.controller;


import org.springframework.web.bind.annotation.RestController;

import com.imobiliaria.entities.Endereco;

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
@RequestMapping("/apirest/endereco")
public class EnderecoControlle {


    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestParam("rua") String rua,
                        @RequestParam("numero") String numero,
                        @RequestParam("cidade") String cidade,
                        @RequestParam("estado") String estado,
                        @RequestParam("id") int id) {
        
        Endereco endereco = new Endereco(rua, numero, cidade, estado);
        endereco.setId(id);
        
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String retornarId(@PathVariable("id") int id){
        return id + " Ok";
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public String atualizar() {
        return "x";  
    }

    @DeleteMapping("/deletar")
    @ResponseStatus(HttpStatus.OK)
    public String deletar( @RequestParam("id") int id){
        return id + " endereco deletada";
    }
}
