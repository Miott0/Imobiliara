package com.imobiliaria.apirest.controller;
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

import java.util.List;

import com.imobiliaria.entities.Corretor;
import com.imobiliaria.repository.Corretors;


@RestController
@RequestMapping("/apirest/corretor")
public class CorretorController {

    private Corretors corretors;
    public CorretorController(Corretors corretors){
        this.corretors = corretors;
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Corretor corr) {
        corretors.save(corr);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Corretor retornarId(@PathVariable("id") int id){
        Corretor corr = corretors.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return corr;
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public Corretor atualizar(@RequestParam("id") int id,
                            @RequestParam("nome") String nome,
                            @RequestParam("sobrenome") String sobrenome,
                            @RequestParam("email") String email) {

        Corretor corr = corretors.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        corr.setNome(nome);corr.setSobrenome(sobrenome);corr.setEmail(email);
        corretors.save(corr);

        return corr;
    }

    @PutMapping("/aprovar")
    @ResponseStatus(HttpStatus.OK)
    public Corretor aprovarCorretor(@RequestParam("id") int id) {

        Corretor corr = corretors.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        corr.AprovarCorretor();
        corretors.save(corr);

        return corr;
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Corretor> listarCorretor(){
       List <Corretor> corretores = corretors.findAll();
       return corretores;
    }


    @DeleteMapping("/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void deletar( @RequestParam("id") int id){
        corretors.findById(id).map( corretor -> {
			corretors.delete(corretor);
			return corretor;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Corretor nao encontrado"));
    }

}