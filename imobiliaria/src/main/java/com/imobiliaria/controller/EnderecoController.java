package com.imobiliaria.controller;

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

import com.imobiliaria.entities.Endereco;
import com.imobiliaria.repository.Enderecos;

@RestController
@RequestMapping("/apirest/endereco")
public class EnderecoController {

    private Enderecos enderecos;
    public EnderecoController(Enderecos enderecos){
        this.enderecos = enderecos;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Endereco endereco) {
        enderecos.save(endereco);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Endereco retornarId(@PathVariable("id") int id){
        Endereco ender = enderecos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ender;
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarEndereco(@RequestParam("id") int id,
                                    @RequestParam("rua") String rua,
                                    @RequestParam("numero") String numero,
                                    @RequestParam("cidade") String cidade,
                                    @RequestParam("estado") String estado) {
        
        Endereco ender = enderecos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        ender = new Endereco(rua, numero, cidade, estado);
        enderecos.save(ender);
        
    }

    @DeleteMapping("/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void deletar( @RequestParam("id") int id){
        enderecos.findById(id).map( endereco -> {
			enderecos.delete(endereco);
			return endereco;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco nao encontrado"));
    }
}