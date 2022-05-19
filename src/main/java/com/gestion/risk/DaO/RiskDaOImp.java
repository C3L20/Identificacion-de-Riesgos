package com.gestion.risk.DaO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.gestion.risk.model.RiskMdl;
import com.gestion.risk.model.SolMitgMdl;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RiskDaOImp implements RiskDaO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<RiskMdl> getRisks() {
        String query = "FROM RiskMdl";
        return entityManager.createQuery(query,RiskMdl.class).getResultList();
    }

    @Override
    public void registrarRisk(RiskMdl risk) {
        entityManager.merge(risk);
    }

    @Override
    public void eliminarRisk(int idRisk) {
        RiskMdl risk = entityManager.find(RiskMdl.class, idRisk);
        entityManager.remove(risk);
    }

    @Override
    public void eliminarSol(int idSol) {
        SolMitgMdl sol = entityManager.find(SolMitgMdl.class, idSol);
        entityManager.remove(sol);
    }

}
