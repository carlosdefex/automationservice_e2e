package com.co.testrappi.definitions;

import com.co.testrappi.steps.DemoBlazeStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

public class DemoBlazeDefinition {

    @Steps
    DemoBlazeStep demoBlazeStep;

    @Dado("que me encuentro en la pagina de demoblaze")
    public void irPaginaDemoBlaze(){
        demoBlazeStep.irPaginaDemoBlaze();
    }

    @Dado("en la seccion de {word}")
    public void navegarCategorias(String categoria){
        demoBlazeStep.irCategoria(categoria);
    }

    @Cuando("selecciono el producto {string}")
    public void seleccionarProducto(String producto){
        demoBlazeStep.seleccionarProducto(producto);
    }

    @Entonces("se comprara el producto seleccionado con los siguientes datos de la tarjeta de credito")
    public void comprarProducto(DataTable datosTarjetaCredito){
        demoBlazeStep.comprarProducto(datosTarjetaCredito);
    }

    @Entonces("se vera el mensaje de confirmacion de la compra {string}")
    public void verificarMensajeCompraExitosa(String mensajeExitoso){
        demoBlazeStep.verificarMensajeExitoso(mensajeExitoso);
    }
}
