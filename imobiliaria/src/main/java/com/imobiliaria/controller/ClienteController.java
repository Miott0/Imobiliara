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

import com.imobiliaria.entities.Cliente;

@RestController
@RequestMapping("/apirest/cliente")
public class ClienteController {
    
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestParam("nome") String nome,
                        @RequestParam("sobrenome") String sobrenome,
                        @RequestParam("email") String email,
                        @RequestParam("id") int id) {

        Cliente cliente = new Cliente(nome, sobrenome, email);
        cliente.setId(id);
            
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String retornarId(@PathVariable("id") int id){
        return id + " Ok";
    }
    
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public String atualizar(@RequestParam("nome") String nome,
                            @RequestParam("sobrenome") String sobrenome,
                            @RequestParam("email") String email,
                            @RequestParam("id") int id) {
    
        return "Dados do cliente " + id + " foram atualizados";  
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletar(@PathVariable("id") int id){
        return id + " Conta deletada";
    }
}





    

    
