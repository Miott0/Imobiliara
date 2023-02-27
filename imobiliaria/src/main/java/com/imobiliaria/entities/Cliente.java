package com.imobiliaria.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="id")
    private int id;

    @Column(name="senha")
    private String senha; 
    
    public Cliente(){

    }

    public Cliente(String nome, String sobrenome, String email){
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

}