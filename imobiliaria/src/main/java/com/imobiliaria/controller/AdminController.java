package com.imobiliaria.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imobiliaria.entities.Administrador;

@RestController
@RequestMapping("/apirest/admin")
public class AdminController {
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestParam("id") int id) { 
       Administrador admin = new Administrador(id);
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
    public String deletar(@PathVariable("id") int id){
        return id + " Agendamento deletado";
    }
}