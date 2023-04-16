package com.imobiliaria.controller;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;

import com.imobiliaria.entities.Imovel;
import com.imobiliaria.entities.TipoImovel;
import com.imobiliaria.entities.Endereco;

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

@RestController
@RequestMapping("/apirest/imovel")
public class ImovelController {
    
    private Imovels imovels;
    private Enderecos enderecos;
    private Clientes clientes;
    private Corretors corretors;
    public ImovelController(Imovels imovels, Enderecos enderecos, Clientes clientes, Corretors corretors){
        this.imovels = imovels;
        this.enderecos = enderecos;
        this.clientes = clientes;
        this.corretors = corretors;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void registraImovel(
                                @RequestParam("area") int area,
                                @RequestParam("id_endereco") int id_endereco,
                                @RequestParam("id_cliente") int id_cliente) {
         
                                    
        Endereco endereco = enderecos.findById(id_endereco).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Cliente cliente = clientes.findById(id_cliente).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));                        
        
        Imovel imovel = new Imovel();
        imovel.setArea(area);
        imovel.setCliente(cliente);
        imovel.setEndereco(endereco);

        imovels.save(imovel);
        
        
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Imovel buscarImovel(@PathVariable("id") int id){
        Imovel imovel = imovels.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return imovel;
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Imovel>listarImovel(){
        List<Imovel> listaImovel = imovels.findAll();
        return listaImovel;
        
    }

    @PutMapping("/registrar-corretor")
    @ResponseStatus(HttpStatus.OK)
    public Imovel registrarCorretor(@RequestParam("id_corretor") int id_corretor,
                                    @RequestParam("id_imovel") int id_imovel) {

        Imovel imovel= imovels.findById(id_imovel).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Corretor corretor = corretors.findById(id_corretor).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if(corretor.getAprovado()==true){
            imovel.setCorretor(corretor);
            imovels.save(imovel);
            return imovel; 
        }
        return imovel;
        
         
    }
    
    @PutMapping("/definir-status")
    @ResponseStatus(HttpStatus.OK)
    public Imovel definirStatus(@RequestParam("id_imovel") int id_imovel) {

        Imovel imovel= imovels.findById(id_imovel).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        imovel.DefinirStatus();
        imovels.save(imovel);
        return imovel;  
    }

    @PutMapping("/validar")
    @ResponseStatus(HttpStatus.OK)
    public Imovel validarImovel(@RequestParam("id_imovel") int id_imovel) {

        Imovel imovel= imovels.findById(id_imovel).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        imovel.ValidarImovel();
        imovels.save(imovel);
        return imovel;  
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String atualizar(@PathVariable("id") int id) {
        return "x";  
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar( @RequestParam("id") int id){
        imovels.findById(id).map( imovel -> {
			imovels.delete(imovel);
			return imovel;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imovel nao encontrado"));
    }
}