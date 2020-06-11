package com.co.testrappi.steps;

import com.co.testrappi.models.RespuestaLoguin;
import com.co.testrappi.models.Loguin;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.MatcherAssert;

public class LoginStep {

    RespuestaLoguin respuestaLoguin = new RespuestaLoguin();

    public void loguearse(String email, String clave) {
        Loguin loguin = new Loguin(email, clave);
         respuestaLoguin = SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .baseUri("https://reqres.in/")
                .basePath("api/")
                .body(loguin)
                .when().log().all()
                .post("login")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().as(RespuestaLoguin.class);
         verificarRespuestaLoguin();
    }

    public void verificarRespuestaLoguin(){
        MatcherAssert.assertThat("No se creo el link correctamente", respuestaLoguin.getToken() != null);
    }
}
