package com.imobiliaria.entities;

public class Administrador {
    private String senha;
    private int id; 

    public Administrador(){

    }

    public Administrador( int id){
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
