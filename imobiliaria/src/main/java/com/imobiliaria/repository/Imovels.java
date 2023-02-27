package com.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imobiliaria.entities.Imovel;

public interface Imovels  extends JpaRepository<Imovel,Integer> {
}