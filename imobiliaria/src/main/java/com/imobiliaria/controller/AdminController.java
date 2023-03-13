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
import org.springframework.web.server.ResponseStatusException;

import com.imobiliaria.entities.Administrador;
import com.imobiliaria.repository.Admins;


@RestController
@RequestMapping("/apirest/admin")
public class AdminController {

    private Admins admins;
    public AdminController(Admins admins){
        this.admins = admins;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador criar(@RequestParam("senha") String senha) { 
        Administrador adm = new Administrador(senha);
        admins.save(adm);
        return adm;  
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Administrador retornarId(@PathVariable("id") int id){
        return  admins.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String atualizar(@PathVariable("id") int id,
                            @RequestParam("senha") String senha) {

        Administrador adm = admins.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        adm.setSenha(senha);
        admins.save(adm);
        return "x";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable("id") int id){
        admins.deleteById(id);
    }
}