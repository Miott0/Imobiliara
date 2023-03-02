package com.imobiliaria.entities;
import jakarta.persistence.*;


import java.util.Date;


@Entity
@Table(name = "Agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="id")
    private int id;

    @Column(name="data")
    private Date data = new Date();

    @Column(name="corretor")
    private Corretor corretor;

    @Column(name="cliente")
    private Cliente cliente;
    

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