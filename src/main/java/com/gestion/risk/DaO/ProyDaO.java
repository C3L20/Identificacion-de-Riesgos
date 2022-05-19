package com.gestion.risk.DaO;

import com.gestion.risk.model.PortafolioMdl;
import com.gestion.risk.model.ProgramaMdl;
import com.gestion.risk.model.ProyectoMdl;

public interface ProyDaO {

    void registrarProy(ProyectoMdl proy);

    void registrarPort(PortafolioMdl port);

    void registrarProg(ProgramaMdl prog);
    
}
