package com.imobiliaria.entities;

public class Cliente extends Usuario{
    private String senha; 
    private int id;

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