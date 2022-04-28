package com.gestion.risk.DaO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gestion.risk.model.UserMdl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Repository
@Transactional
public class UserDaOImp implements UserDaO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserMdl> getUsers() {
        String query = "FROM UserMdl";
        return entityManager.createQuery(query, UserMdl.class).getResultList();
    }

    @Override
    public void eliminarUser(String rut) {
        UserMdl user = entityManager.find(UserMdl.class, rut);
        entityManager.remove(user);
    }

    @Override
    public void registrarUser(UserMdl user) {
        entityManager.merge(user);
    }

    @Override
    public boolean verificarCredenciales(UserMdl user) {
        String query = "FROM UserMdl WHERE email = :email";
        List<UserMdl> res = entityManager.createQuery(query, UserMdl.class)
            .setParameter("email", user.getEmail())
            .getResultList();
        if (res.isEmpty()) {
            return false;
        }
        String contrasenaHash = res.get(0).getContrasena();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        return argon2.verify(contrasenaHash, user.getContrasena());
    }

    @Override
    public UserMdl getUserByEmail(String email) {
        String query = "FROM UserMdl WHERE email = :email";
        List<UserMdl> res = entityManager.createQuery(query, UserMdl.class)
            .setParameter("email", email)
            .getResultList();
        return res.get(0);
    }
    
}
