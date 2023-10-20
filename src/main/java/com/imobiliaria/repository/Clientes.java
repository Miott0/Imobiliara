package com.imobiliaria.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.imobiliaria.entities.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {
    
}
