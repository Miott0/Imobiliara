package com.imobiliaria.entities;

public class Corretor extends Usuario{
    private int id;
	private String senha;
    private boolean aprovado = false;

    public Corretor(){

    }

    public Corretor(String nome, String sobrenome, String email, int id){
    	setId(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}