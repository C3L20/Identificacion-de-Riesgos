package com.gestion.risk.DaO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.gestion.risk.model.PortafolioMdl;
import com.gestion.risk.model.ProgramaMdl;
import com.gestion.risk.model.ProyectoMdl;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProyDaoImp implements ProyDaO{
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void registrarProy(ProyectoMdl proy) {
        entityManager.merge(proy);
    }

    @Override
    public void registrarPort(PortafolioMdl port) {
        entityManager.merge(port);
    }

    @Override
    public void registrarProg(ProgramaMdl prog) {
        entityManager.merge(prog);
    }

}
