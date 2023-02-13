package com.imobiliaria.controller;


import org.springframework.web.bind.annotation.RestController;

import com.imobiliaria.entities.Imovel;
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
@RequestMapping("/apirest/imovel")
public class ImovelController {
    

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestParam("tipo_imovel") String tipo_imovel,
                        @RequestParam("area") int area,
                        @RequestParam("negociado") boolean negociado,
                        @RequestParam("Endereco") Endereco endereco,
                        @RequestParam("id") int id) {
        
        Imovel imovel = new Imovel();
        imovel.setTipo_imovel(tipo_imovel);
        imovel.setArea(area);
        imovel.setId(id);

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