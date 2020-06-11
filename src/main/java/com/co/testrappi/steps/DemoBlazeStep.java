package com.co.testrappi.steps;

import com.co.testrappi.pages.DemoBlazePage;
import com.co.testrappi.pages.FormularioRealizarPedidoPage;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.Map;

public class DemoBlazeStep {

    @Page
    DemoBlazePage demoBlazePage;

    @Page
    FormularioRealizarPedidoPage formularioRealizarPedidoPage;

    @Step
    public void irPaginaDemoBlaze() {
        demoBlazePage.open();

    }

    public void irCategoria(String categoria) {
        demoBlazePage.navegarCategoria(categoria);
    }

    public void seleccionarProducto(String producto) {
        demoBlazePage.seleccionarProducto(producto);
        demoBlazePage.agregarCarrito();
        demoBlazePage.aceptarVentanaProductoAgregado();
    }

    public void comprarProducto(DataTable datosTarjetaCredito) {
        Map<String, String> datosTarjetaMap = datosTarjetaCredito.transpose().asMap(String.class, String.class);
        demoBlazePage.seleccionarMenuCarrito();
        demoBlazePage.ordenarPedido();
        completarFormularioRealizarPedido(datosTarjetaMap);
    }

    private void completarFormularioRealizarPedido(Map<String, String> datosTarjetaCredito){
        formularioRealizarPedidoPage.diligenciarNombre(datosTarjetaCredito.get("Nombre"));
        formularioRealizarPedidoPage.diligenciarPais(datosTarjetaCredito.get("País"));
        formularioRealizarPedidoPage.diligenciarCiudad(datosTarjetaCredito.get("Cíudad"));
        formularioRealizarPedidoPage.diligenciarTarjetaCredito(datosTarjetaCredito.get("TarjetaCredito"));
        formularioRealizarPedidoPage.diligenciarMes(datosTarjetaCredito.get("Mes"));
        formularioRealizarPedidoPage.diligenciarAno(datosTarjetaCredito.get("Año"));
        formularioRealizarPedidoPage.completarPedido();
    }

    public void verificarMensajeExitoso(String mensajeExitoso) {
        MatcherAssert.assertThat("La compra no fue exitosa, por favor revise los datos",
                formularioRealizarPedidoPage.obtenerTextoMensajeExitoso().contains(mensajeExitoso));
    }
}
