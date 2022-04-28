package com.gestion.risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_proy")
public class UserProyMdl {
    @Id
    @Column(name = "IDproy",nullable = false)
    @Getter @Setter
    @JoinTable(name = "proyecto")
    @JoinColumn(name="IDproy",referencedColumnName="IDproy")
    private int IDproy;
    
    @Getter @Setter
    @JoinTable(name = "users")
    @JoinColumn(name="rut",referencedColumnName="rut")
    @Column(name = "rut",nullable = false)
    private String rut;
    public UserProyMdl() {
    }
    public UserProyMdl(int iDproy, String rut) {
        IDproy = iDproy;
        this.rut = rut;
    }
}
