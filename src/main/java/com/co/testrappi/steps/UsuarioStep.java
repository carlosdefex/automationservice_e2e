package com.co.testrappi.steps;

import com.co.testrappi.models.RespuestaListaUsuarios;
import com.co.testrappi.models.Usuario;
import com.co.testrappi.models.UsuarioRespuesta;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.MatcherAssert;

public class UsuarioStep {

    UsuarioRespuesta usuarioRespuesta = new UsuarioRespuesta();
    RespuestaListaUsuarios respuestaListaUsuarios = new RespuestaListaUsuarios();

    public void crearUsuario(String nombre, String trabajo) {
        Usuario usuario = new Usuario(nombre,trabajo);
        usuarioRespuesta = SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .baseUri("https://reqres.in/")
                .basePath("api/")
                .body(usuario)
                .when().log().all()
                .post("users")
                .then().log().all()
                .contentType(ContentType.JSON)
                .statusCode(201)
                .extract().as(UsuarioRespuesta.class);
    }

    private void verificarCreacionUsuario(){
        MatcherAssert.assertThat("El usuario no fue creado exitosamente", usuarioRespuesta.getCreatedAt().isEmpty());
    }

    public void verificarUsuario() {
       respuestaListaUsuarios = SerenityRest.given()
                .baseUri("https://reqres.in/")
                .basePath("api/")
                .when().log().all()
                .get("users")
                .then().log().all()
                .statusCode(200)
                .extract().as(RespuestaListaUsuarios.class);
       verificarListaUsuarios();
    }

    private void verificarListaUsuarios(){
        MatcherAssert.assertThat("La lista no contiene usuarios", respuestaListaUsuarios.getData().size() > 0);
    }
}
