package com.gestion.risk.Controller;

import java.util.ArrayList;
import java.util.List;

import com.gestion.risk.DaO.UserDaO;
import com.gestion.risk.Util.JWTUtil;
import com.gestion.risk.model.UserMdl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UserCtrl {

    @Autowired
    private UserDaO userDaO;

    @Autowired
    private JWTUtil jwtUtil;
    
    @RequestMapping(value = "prueba/{rut}")
    public UserMdl getUser(@PathVariable String rut) {
        UserMdl user = new UserMdl(rut, "email", "nombre", "contrasena", "telefono");
        return user;
    }

    @RequestMapping(value = "getUsers")
    public List<UserMdl> getUsers(@RequestHeader(value = "Authentication") String token) {
        String userId = jwtUtil.getKey(token);
        if (userId.isBlank()) {
            return new ArrayList<>();
        }
        return userDaO.getUsers();
    }

    @RequestMapping(value = "registrarUser", method = RequestMethod.POST)
    public void registrarUser(@RequestBody UserMdl user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        user.setContrasena(argon2.hash(1, 1024, 1, user.getContrasena()));
        userDaO.registrarUser(user);
    }

    @RequestMapping(value = "eliminarUser/{rut}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable String rut) {
        userDaO.eliminarUser(rut);
    }

    @RequestMapping(value = "logIn", method = RequestMethod.POST)
    public String logIn(@RequestBody UserMdl user) {
        if (userDaO.verificarCredenciales(user)) {
            user = userDaO.getUserByEmail(user.getEmail());
            String tokenJWT = jwtUtil.create(user.getRut(), user.getEmail());
            return tokenJWT;
        } else {
            return "Fail";
        }
    }    
}
