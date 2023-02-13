package com.imobiliaria.entities;

import java.util.Date;

public class Agendamento {
    private Date data = new Date();
    private Corretor corretor;
    private Cliente cliente;
    private int id;

    public Agendamento(){

    }

    public Agendamento(Date data, Corretor corretor, Cliente cliente){
        this.data = data;
        this.corretor = corretor;
        this.cliente = cliente;
    }


    public void AgendarVisita(Corretor cor, Cliente cli, Imovel imo){
        
    }
}
