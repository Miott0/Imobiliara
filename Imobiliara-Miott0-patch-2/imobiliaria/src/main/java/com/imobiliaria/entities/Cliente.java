package com.imobiliaria.entities;

public class Cliente extends Usuario{
    private String senha; 


    public Cliente(String nome, String sobrenome, String email){
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

}