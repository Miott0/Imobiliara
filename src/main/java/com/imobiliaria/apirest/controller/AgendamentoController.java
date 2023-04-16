package com.imobiliaria.apirest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.imobiliaria.entities.Cliente;
import com.imobiliaria.entities.Corretor;
import com.imobiliaria.entities.Imovel;
import com.imobiliaria.entities.Agendamento;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.imobiliaria.repository.Clientes;
import com.imobiliaria.repository.Corretors;
import com.imobiliaria.repository.Imovels;
import com.imobiliaria.repository.Agendamentos;


@RestController
@RequestMapping("/apirest/agendamento")
public class AgendamentoController {

    private Agendamentos agendamentos;
    private Clientes clientes;
    private Corretors corretors;
    private Imovels imovels;

    public AgendamentoController(Imovels imovel, Agendamentos agendamentos, Corretors corretors, Clientes clientes){
        this.agendamentos = agendamentos;
        this.corretors = corretors;
        this.clientes = clientes;
        this.imovels = imovel;

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento agendarVisita(@RequestParam("id_corretor") int id_corretor,
                                        @RequestParam("id_cliente") int id_cliente, 
                                        @RequestParam("id_imovel") int id_imovel){

        Cliente cliente = clientes.findById(id_cliente).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Corretor corretor = corretors.findById(id_corretor).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Imovel imovel = imovels.findById(id_imovel).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Agendamento agendamento = new Agendamento(cliente, corretor, imovel);
        agendamentos.save(agendamento);
        return agendamento;
    }

    @GetMapping("/{id}")
    public Agendamento buscar(@PathVariable("id") int id) {
        Agendamento agen = agendamentos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return agen;
    }
    


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento atualizar(@PathVariable("id_agendamento") int id_agendamento,
                                    @RequestParam("id_corretor") int id_corretor,
                                    @RequestParam("id_cliente") int id_cliente, 
                                    @RequestParam("id_imovel") int id_imovel){

        Cliente cliente = clientes.findById(id_cliente).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Corretor corretor = corretors.findById(id_corretor).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Imovel imovel = imovels.findById(id_imovel).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Agendamento agen = agendamentos.findById(id_agendamento).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        agen = new Agendamento(cliente, corretor, imovel);
        agendamentos.save(agen);
        return agen;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar( @RequestParam("id") int id){
        agendamentos.findById(id).map( agendamento -> {
			agendamentos.delete(agendamento);
			return agendamento;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento nao encontrado"));
    }
}