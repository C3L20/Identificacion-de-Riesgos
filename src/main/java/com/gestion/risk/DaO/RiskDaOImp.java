package com.gestion.risk.DaO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.gestion.risk.model.RiskMdl;

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

}
