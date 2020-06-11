package com.co.testrappi.definitions;

import com.co.testrappi.steps.LoginStep;
import com.co.testrappi.steps.UsuarioStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class ReqresDefinition {

    LoginStep loginStep = new LoginStep();
    UsuarioStep usuarioStep = new UsuarioStep();

    @Dado("que se ingresa en el sistema con email {string} y contraseña {word}")
    public void ingresarSistema(String email, String clave){
        loginStep.loguearse(email, clave);
    }

    @Cuando("creo el usuario con nombre {word} y trabajo {word}")
    public void crearUsuario(String nombre, String trabajo){
        usuarioStep.crearUsuario(nombre, trabajo);
    }

    @Entonces("valido que la lista de usuarios se encuentre poblada")
    public void validarCreacionUsuario(){
        usuarioStep.verificarUsuario();
    }
}
