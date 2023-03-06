package com.imobiliaria.entities;

import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="id")
    private int id;

    @Column(name="data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data = new Date();

    @OneToOne
    private Imovel imovel;

    @OneToOne
    private Corretor corretor;

    @OneToOne
    private Cliente cliente;
    

    public Agendamento(){

    }

    public Agendamento( Cliente cli, Corretor cor, Imovel imovel){
        this.cliente = cli;
        this.corretor =  cor;
        this.imovel = imovel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
