package com.gestion.risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserMdl {
    
    @Id
    @Column(name = "rut", nullable = false) 
    private String rut;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    @Column(name = "telefono", nullable = false)
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
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}