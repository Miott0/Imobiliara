package com.imobiliaria.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.imobiliaria.entities.Usuario;

public interface Users extends JpaRepository<User, Integer> {
    
    Optional<Usuario> findByUsername(String username);
}
