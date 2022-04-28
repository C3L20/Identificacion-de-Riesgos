
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
@Table(name = "sol_mig")
public class SolMitgMdl {

    @Id
    @Column(name = "IDsol_mig")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter
    private int IDsol_mig ;
    @Column(name = "titulo") @Getter @Setter
    private String titulo ;
    @Column(name = "descripcion") @Getter @Setter
    private String descripcion ;
    @Column(name = "IDrisk") @Getter @Setter
    @JoinTable(name = "risk")
    @JoinColumn(name="IDrisk",referencedColumnName="IDrisk")
    private int IDrisk ;
    
    public SolMitgMdl() {
    }
    public SolMitgMdl(int iDsol_mig, String titulo, String descripcion, int iDrisk) {
        IDsol_mig = iDsol_mig;
        this.titulo = titulo;
        this.descripcion = descripcion;
        IDrisk = iDrisk;
    }
}
