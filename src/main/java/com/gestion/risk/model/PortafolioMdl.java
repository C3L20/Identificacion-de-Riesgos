package com.gestion.risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "portafolio")
public class PortafolioMdl {
    
    @Id
    @Column(name = "IDport")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter
    private int IDport;

    @Column(name = "titulo", nullable = false)
    @Getter @Setter
    private String titulo;

    public PortafolioMdl() {
    }

    public PortafolioMdl(int iDport, String titulo) {
        IDport = iDport;
        this.titulo = titulo;
    }
}
