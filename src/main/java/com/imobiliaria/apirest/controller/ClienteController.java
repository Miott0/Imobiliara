package com.imobiliaria.apirest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.imobiliaria.entities.Cliente;
import com.imobiliaria.services.ClientesService;


@RestController
@RequestMapping("/apirest/cliente")
public class ClienteController {
    
    @Autowired
    private ClientesService service;


    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        service.criar(cliente);         
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente retornarId(@PathVariable("id") int id){
        return service.buscar(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientes(){
        List<Cliente> listaClientes = service.retornarClientes();
        return listaClientes;
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar( @RequestParam("id") int id,
                           @RequestBody Cliente novoCliente) {
                                                      
        service.atualizarCliente(id, novoCliente);
    }
    
    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar( @PathVariable("id") int id){
       service.deletar(id);
    }
}