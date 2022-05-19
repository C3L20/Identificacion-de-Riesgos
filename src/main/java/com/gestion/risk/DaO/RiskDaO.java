package com.gestion.risk.DaO;

import java.util.List;

import com.gestion.risk.model.RiskMdl;

public interface RiskDaO {
    List<RiskMdl> getRisks();

    void registrarRisk(RiskMdl risk);

    void eliminarRisk(int idRisk);

    void eliminarSol(int idSol);
}
