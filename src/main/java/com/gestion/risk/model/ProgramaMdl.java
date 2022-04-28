package com.gestion.risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "programa")
public class ProgramaMdl {
    
    @Id
    @Column(name = "IDprog")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int IDprog;

    @Column(name = "titulo", nullable = false)
    @Getter @Setter
    private String titulo;

    @Column(name = "IDport", nullable = false)
    @Getter @Setter
    @JoinTable(name = "portafolio")
    @JoinColumn(name="IDport",referencedColumnName="IDport")
    private int IDport;

    public ProgramaMdl() {
    }
    public ProgramaMdl(int iDport, String titulo,int IDprog) {
        this.IDport = iDport;
        this.titulo = titulo;
        this.IDprog=IDprog;
    }
}
