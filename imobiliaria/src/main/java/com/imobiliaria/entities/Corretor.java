package com.imobiliaria.entities;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Corretor{

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

    @Column(name="aprovado")
    private boolean aprovado = false;

    @OneToMany
    private List<Imovel> listaImovel;

    public Corretor(){
    }

    public Corretor(String nome, String sobrenome, String email){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Imovel> getImovel() {
        return listaImovel;
    }

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAprovado(){
        return aprovado;
    }

    public int getId() {
        return id;
    }

    public void AprovarCorretor(){
        if (this.aprovado == false) {
            this.aprovado = true;
        }
        
    }

    public void cadastrarImovel(Imovel imovel){
        listaImovel.add(imovel);
    }

}