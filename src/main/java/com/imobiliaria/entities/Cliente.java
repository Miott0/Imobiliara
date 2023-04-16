package com.imobiliaria.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="nome", length = 20)
    private String nome;
    @Column(name="sobrenome", length = 30)
    private String sobrenome;
    @Column(name="email", length = 30)
    private String email;
    @Column(name="senha")
    private String senha;

    @OneToMany
    private List<Imovel> imovel;

    public Cliente(){

    }

    public Cliente(String nome, String sobrenome, String email){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public List<Imovel> getImovel() {
        return imovel;
    }

    public void setImovel(List<Imovel> imovel) {
        this.imovel = imovel;
    }

    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
