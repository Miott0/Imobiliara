package com.imobiliaria.controller;
import java.util.List;

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
import com.imobiliaria.repository.Clientes;


@RestController
@RequestMapping("/apirest/cliente")
public class ClienteController {
    
    private Clientes clientes;
    public ClienteController(Clientes clientes){
        this.clientes = clientes;
    }

    
    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        clientes.save(cliente);         
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente retornarId(@PathVariable("id") int id){
        return clientes.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClientes(){
        List<Cliente> listaClientes = clientes.findAll();
        return listaClientes;
    }


    
    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar( @RequestParam("id") int id,
                            @RequestParam("nome") String nome,
                            @RequestParam("sobrenome") String sobrenome,
                            @RequestParam("email") String email) {
    
        Cliente cliente = clientes.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        cliente.setNome(nome);cliente.setSobrenome(sobrenome);cliente.setEmail(email);
        clientes.save(cliente);  
    }
    
    @DeleteMapping("/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void deletar( @RequestParam("id") int id){
        clientes.findById(id).map( cliente -> {
			clientes.delete(cliente);
			return cliente;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
    }
}