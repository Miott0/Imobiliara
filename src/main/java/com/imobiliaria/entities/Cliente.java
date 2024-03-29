package com.imobiliaria.entities;

import java.util.List;

import com.imobiliaria.apirest.annotations.EmailValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", length = 20)
    @NotBlank(message = "campo nao pode esatar vazio")
    private String nome;

    @Column(name="sobrenome", length = 30)
    @NotBlank(message = "campo nao pode esatar vazio")
    private String sobrenome;

    @Column(name="email")
    @NotBlank(message = "campo nao pode esatar vazio")
    @EmailValidation(message = "email invalido")
    private String email;


    @Column(name="senha")
    @NotEmpty(message = "Campo não pode ser vazio")
    @Size(min=8, max=20)
    private String senha;

    @OneToMany
    private List<Imovel> imovel;

    public Cliente(){

    }

    public Cliente(String nome, String sobrenome, String email){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public void setImovel(Imovel imovel) {
        this.imovel.add(imovel);
    }

    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
