package com.imobiliaria.entities;

public class Corretor extends Usuario{
    private String senha;
    private boolean aprovado = false;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAprovado(){
        return aprovado;
    }
    
    public void CadastrarCorretor(){

    }

    public boolean AprovarCorretor(){
        if (aprovado == false) {
            return aprovado = true;
        }
        return true; 
    }

}