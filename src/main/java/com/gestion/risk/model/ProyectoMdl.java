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
import lombok.ToString;

@Entity
@Table(name = "proyecto")
@ToString
public class ProyectoMdl {
    @Id
    @Column(name = "IDproy",nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter
    private int IDproy;
    @Column(name = "titulo",nullable = false)
    @Getter @Setter
    private String titulo;
    @Column(name = "F_inicio",nullable = false)
    @Getter @Setter
    private String F_inicio;
    @Column(name = "F_termino",nullable = false)
    @Getter @Setter
    private String F_termino;
    @Column(name = "IDprog",nullable = false)
    @Getter @Setter
    @JoinTable(name = "programa")
    @JoinColumn(name="IDprog",referencedColumnName="IDprog")
    private int IDprog;
    
    public ProyectoMdl() {
    }

    public ProyectoMdl(int iDproy, String titulo, String f_inicio, String f_termino, int iDprog) {
        IDproy = iDproy;
        this.titulo = titulo;
        F_inicio = f_inicio;
        F_termino = f_termino;
        IDprog = iDprog;
    }
}
