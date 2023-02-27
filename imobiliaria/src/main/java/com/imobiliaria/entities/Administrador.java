package com.imobiliaria.entities;
import jakarta.persistence.*;


@Entity
@Table(name = "Administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="id")
    private int id;

    @Column(name ="senha")
    private String senha;
    
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
