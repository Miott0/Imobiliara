package com.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imobiliaria.entities.Agendamento;

public interface Agendamentos extends JpaRepository<Agendamento, Integer> {
    
}
