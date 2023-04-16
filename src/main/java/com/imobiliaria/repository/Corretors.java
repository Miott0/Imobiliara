package com.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imobiliaria.entities.Corretor;

public interface Corretors extends JpaRepository<Corretor, Integer> {
    
}
