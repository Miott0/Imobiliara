package com.imobiliaria.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private int id;

    @Column(name ="senha", nullable = false)
    @NotEmpty(message = "Campo não pode ser vazio")
    @Size(min=8, max=20)
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