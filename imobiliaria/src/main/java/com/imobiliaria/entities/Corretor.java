package com.imobiliaria.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "Corretor")
public class Corretor extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="id")
    private int id;

    @Column(name="senha")
    private String senha;

    @Column(name="aprovado")
    private boolean aprovado = false;

    public Corretor(){
    }

    public Corretor(String nome, String sobrenome, String email){
        setNome(nome);
        setEmail(email);
        setSobrenome(sobrenome);
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

    public void setId(int id) {
        this.id = id;
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