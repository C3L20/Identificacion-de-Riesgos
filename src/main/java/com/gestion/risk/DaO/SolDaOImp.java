package com.gestion.risk.DaO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.gestion.risk.model.SolMitgMdl;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SolDaOImp implements SolDaO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<SolMitgMdl> getSoluciones() {
        String query = "FROM SolMitgMdl";
        return entityManager.createQuery(query, SolMitgMdl.class).getResultList();
    }
    
}
