package com.imobiliaria.entities;

public class Imovel {
    private String tipo_imovel;
    private int area;
    private float valor_venda;
    private float valor_aluguel;
    private int qtd_quartos;
    private String aluguel_venda;
    private boolean negociado;
    private boolean valido;
    private Endereco endereco;
    private Cliente Cliete;
    private Corretor corretor;


    
    public void RegistrarImovel(String aluguel_venda, int valor){
        this.aluguel_venda = aluguel_venda;
        if(this.aluguel_venda == "aluguel e venda"){
            this.valor_venda = valor;
            this.valor_aluguel = valor;
        }
        else if( this.aluguel_venda == "venda"){
            this.valor_venda = valor;
        }
        else{
            this.valor_aluguel = valor;
        }

    }

    public boolean DefinirStatus(){
        return false;
    }

    public boolean ValidarImovel(){
        return false;
    }

    public void BuscarImovel(){
    }
}
