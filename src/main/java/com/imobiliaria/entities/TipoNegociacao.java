package com.imobiliaria.entities;

public enum TipoNegociacao {

    VENDA{

        @Override
        public String getTipoNegociacao(){
            String tipoNegociacao = "venda";
            return  tipoNegociacao;
        }
    },

    ALUGUEL{
        @Override
        public String getTipoNegociacao(){
            String tipoNegociacao = "aluguel";
            return  tipoNegociacao;
        }
    },

    ALUGUEL_VENDA{
        @Override
        public String getTipoNegociacao(){
            String tipoNegociacao = "aluguel_venda";
            return  tipoNegociacao;
        }
    };

    public abstract String getTipoNegociacao();
}