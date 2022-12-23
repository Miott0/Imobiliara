package com.imobiliaria.entities;

public class Cliente extends Usuario{
    private String senha; 


    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

}