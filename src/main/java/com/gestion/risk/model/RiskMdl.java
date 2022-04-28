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
@Table(name = "risk")
public class RiskMdl {

    @Id
    @Column(name = "IDrisk")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter
    private int IDrisk ;
    @Column(name = "titulo") @Getter @Setter
    private String titulo ;
    @Column(name = "dueño") @Getter @Setter
    private String dueño ;
    @Column(name = "categoria") @Getter @Setter
    private String categoria;
    @Column(name = "causa") @Getter @Setter
    private String causa;
    @Column(name = "gatillante") @Getter @Setter
    private String gatillante;
    @Column(name = "fuente") @Getter @Setter
    private String fuente;
    @Column(name = "ocurrencia") @Getter @Setter
    private String ocurrencia ;
    @Column(name = "caducidad") @Getter @Setter
    private String caducidad ;
    @Column(name = "IDproy") @Getter @Setter
    @JoinTable(name = "proyecto")
    @JoinColumn(name="IDproy",referencedColumnName="IDproy")
    private int IDproy ;
    
    public RiskMdl() {
    }
    public RiskMdl(int iDrisk, String titulo, String dueño, String categoria, String causa, String gatillante,
            String fuente, String ocurrencia, String caducidad, int iDproy) {
        IDrisk = iDrisk;
        this.titulo = titulo;
        this.dueño = dueño;
        this.categoria = categoria;
        this.causa = causa;
        this.gatillante = gatillante;
        this.fuente = fuente;
        this.ocurrencia = ocurrencia;
        this.caducidad = caducidad;
        IDproy = iDproy;
    }
}
