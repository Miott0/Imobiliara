package com.imobiliaria.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private int id;

    @Column(name="rua", length = 50)
    @NotBlank(message = "campo nao pode ser vazio")
    private String rua;

    @Column(name="numero")
    @NotBlank(message = "campo nao pode ser vazio")
    private String numero;

    @Column(name="cidade", length = 20)
    @NotBlank(message = "campo nao pode ser vazio")
    private String cidade;
    
    @Column(name="estado", length = 20)
    @NotBlank(message = "campo nao pode ser vazio")
    private String estado;


    public Endereco(){

    }

    
    public Endereco(String rua, String numero, String cidade, String estado){
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.rua = rua;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
}