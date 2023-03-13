package com.imobiliaria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.imobiliaria.entities.Administrador;

public interface Admins extends JpaRepository<Administrador, Integer> {

}
