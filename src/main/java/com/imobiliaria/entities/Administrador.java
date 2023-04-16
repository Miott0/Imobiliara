package com.imobiliaria.entities;
import jakarta.persistence.*;


@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="id")
    private int id;

    @Column(name ="senha", nullable = false,  length= 12)
    private String senha;
    
    public Administrador(){
    }

    public Administrador( String senha){
        this.senha = senha;
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