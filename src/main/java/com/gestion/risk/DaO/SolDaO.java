package com.gestion.risk.DaO;

import java.util.List;

import com.gestion.risk.model.SolMitgMdl;

public interface SolDaO {

    List<SolMitgMdl> getSoluciones();

    void registrarSol(SolMitgMdl sol);
    
}
