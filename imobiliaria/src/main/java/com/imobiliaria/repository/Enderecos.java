package com.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imobiliaria.entities.Endereco;

public interface Enderecos extends JpaRepository<Endereco, Integer> {
    
}
