package com.imobiliaria.entities;

import java.util.Collection;

import org.hibernate.mapping.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.imobiliaria.apirest.annotations.EmailValidation;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private int id;
    
    @Column(name="email", length = 30)
    @NotBlank(message = "campo nao pode esatar vazio")
    @EmailValidation(message = "email invalido")
    private String email;

    @Column(name="senha")
    @NotEmpty(message = "campo nao pode esatar vazio")
    @Size(min=8, max=20)
    private String senha;

    @ManyToMany
    @JoinTable(name="Tabela_Roles_Usuario", 
                joinColumns = @JoinColumn(name="user_id"), 
                inverseJoinColumns = @JoinColumn(name="roler_id"))
    private List<Roles> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
