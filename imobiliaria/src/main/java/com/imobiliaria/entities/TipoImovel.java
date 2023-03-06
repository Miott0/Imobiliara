package com.imobiliaria.entities;

public enum TipoImovel {
    
    TERRENO{

        @Override
        public String getTipoImovel(){
            String tipoImovel = "terreno";
            return tipoImovel;
        }
    },

    CASA{
        @Override
        public String getTipoImovel(){
            String tipoImovel = "casa";
            return tipoImovel;
        }
    },

    Apartamento{
        @Override
        public String getTipoImovel(){
            String tipoImovel = "apartamento";
            return tipoImovel;
        }
    };

    public abstract String getTipoImovel();
   
}