package com.imobiliaria.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Imovel")
public class Imovel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name="id")
    private int id;

    @Column(name="tipo_imovel")
    private TipoImovel tipo_imovel;

    @Column(name="area")
    private int area;

    @Column(name="valor_venda")
    private float valor_venda;

    @Column(name="valor_aluguel")
    private float valor_aluguel;

    @Column(name="qtd_quartos")
    private int qtd_quartos;

    @Column(name="aluguel_venda")
    private TipoNegociacao aluguel_venda;

    @Column(name="negociado")
    private boolean negociado;

    @Column(name="valido")
    private boolean valido;

    @Column(name="endereco")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "clinte_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "corretor_id")
    private Corretor corretor;

    
    public Imovel() {

    }


    public TipoImovel getTipo_imovel() {
        return tipo_imovel;
    }

    public void setTipo_imovel(TipoImovel tipo_imovel) {
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

    public TipoNegociacao getAluguel_venda() {
        return aluguel_venda;
    }

    public void setAluguel_venda(TipoNegociacao aluguel_venda) {
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
        return cliente;
    }

    public void setCliete(Cliente cliente) {
        this.cliente = cliente;
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

    public void RegistrarImovel(){
    
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
