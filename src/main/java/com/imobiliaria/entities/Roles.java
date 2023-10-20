package com.imobiliaria.entities;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique=true)
    private RoleName roleName;



    @Override
    public String getAuthority() {
       return this.roleName.toString();
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public RoleName getRoleName() {
        return roleName;
    }



    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
    
}
