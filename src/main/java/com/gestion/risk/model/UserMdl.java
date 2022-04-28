package com.gestion.risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class UserMdl {
    
    @Id
    @Getter @Setter @Column(name = "rut", nullable = false) 
    private String rut;
    @Getter @Setter @Column(name = "email", nullable = false)
    private String email;
    @Getter @Setter @Column(name = "nombre", nullable = false)
    private String nombre;
    @Getter @Setter @Column(name = "contrasena", nullable = false)
    private String contrasena;
    @Getter @Setter @Column(name = "telefono", nullable = false)
    private String telefono;

    public UserMdl() {
    }
    public UserMdl(String rut, String email, String nombre, String contrasena, String telefono) {
        this.rut = rut;
        this.email = email;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }
}