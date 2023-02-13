package com.imobiliaria.entities;

public class Imovel {
    private int id;
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

    public Imovel() {

    }


    public String getTipo_imovel() {
        return tipo_imovel;
    }

    public void setTipo_imovel(String tipo_imovel) {
        this.tipo_imovel = tipo_imovel;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    public float getValor_aluguel() {
        return valor_aluguel;
    }

    public void setValor_aluguel(float valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
    }

    public int getQtd_quartos() {
        return qtd_quartos;
    }

    public void setQtd_quartos(int qtd_quartos) {
        this.qtd_quartos = qtd_quartos;
    }

    public String getAluguel_venda() {
        return aluguel_venda;
    }

    public void setAluguel_venda(String aluguel_venda) {
        this.aluguel_venda = aluguel_venda;
    }

    public boolean isNegociado() {
        return negociado;
    }

    public void setNegociado(boolean negociado) {
        this.negociado = negociado;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliete() {
        return Cliete;
    }

    public void setCliete(Cliente cliete) {
        Cliete = cliete;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void RegistrarImovel(String aluguel_venda, int valor) {
        this.aluguel_venda = aluguel_venda;
        if (this.aluguel_venda == "aluguel e venda") {
            this.valor_venda = valor;
            this.valor_aluguel = valor;
        } else if (this.aluguel_venda == "venda") {
            this.valor_venda = valor;
        } else {
            this.valor_aluguel = valor;
        }

    }

    public boolean DefinirStatus() {
        return false;
    }

    public boolean ValidarImovel() {
        return false;
    }

    public void BuscarImovel() {
    }

}
