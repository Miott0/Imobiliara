package com.imobiliaria.entities;

public class Corretor extends Usuario{
    private String senha;
    private boolean aprovado = false;

    public Corretor(){

    }

    public Corretor(String nome, String sobrenome, String email){
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