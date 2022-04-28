package com.gestion.risk.DaO;

import java.util.List;

import com.gestion.risk.model.UserMdl;

public interface UserDaO {
    
    List<UserMdl> getUsers();

    void eliminarUser(String rut);

    void registrarUser(UserMdl user);

    boolean verificarCredenciales(UserMdl user);

    UserMdl getUserByEmail(String email);

}
