package com.imobiliaria.apirest.controller;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;

import com.imobiliaria.entities.Imovel;
import com.imobiliaria.entities.TipoImovel;
import com.imobiliaria.entities.Endereco;

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

import com.imobiliaria.entities.Endereco;
import com.imobiliaria.repository.Enderecos;

import com.imobiliaria.entities.Cliente;
import com.imobiliaria.repository.Clientes;

import com.imobiliaria.entities.Corretor;
import com.imobiliaria.repository.Corretors;

import com.imobiliaria.entities.Imovel;
import com.imobiliaria.repository.Imovels;
import com.imobiliaria.services.ImovelService;

@RestController
@RequestMapping("/apirest/imovel")
public class ImovelController {
    
    @Autowired
    private ImovelService service;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void registraImovel(
                                @RequestBody Imovel imovel,
                                @RequestParam("id_endereco") int id_endereco,
                                @RequestParam("id_cliente") int id_cliente){                    
        
        service.ciar(imovel, id_endereco, id_cliente);
        
        
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Imovel buscarImovel(@PathVariable("id") int id){
        return service.buscar(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Imovel>listarImovel(){
        return service.retornarImovels();
        
    }



    @PutMapping("/registrar-corretor")
    @ResponseStatus(HttpStatus.OK)
    public void registrarCorretor(@RequestParam("id_corretor") int id_corretor,
                                    @RequestParam("id_imovel") int id_imovel) {
        
        service.registrarCorretor(id_corretor, id_imovel);
         
    }
    
    @PutMapping("/definir-status")
    @ResponseStatus(HttpStatus.OK)
    public void definirStatus(@RequestParam("id_imovel") int id_imovel) {

        service.definirStatus(id_imovel);
    }

    @PutMapping("/validar")
    @ResponseStatus(HttpStatus.OK)
    public void validarImovel(@RequestParam("id_imovel") int id_imovel) {

        service.validarImovel(id_imovel);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String atualizar(@PathVariable("id") int id) {
        return "x";  
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar( @RequestParam("id") int id){
        service.deletar(id);
    }
}