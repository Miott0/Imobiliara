package com.imobiliaria.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.imobiliaria.entities.Usuario;
import com.imobiliaria.repository.Users;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImplement implements UserDetailsService {


    @Autowired
    Users userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByUsername(username).orElseThrow();

        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());

        
    }
    
}
