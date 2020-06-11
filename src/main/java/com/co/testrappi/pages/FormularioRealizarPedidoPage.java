package com.co.testrappi.pages;

import jdk.nashorn.internal.scripts.JD;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

import javax.xml.xpath.XPath;

public class FormularioRealizarPedidoPage extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade txtNombre;

    @FindBy(id = "country")
    private WebElementFacade txtPais;

    @FindBy(id = "city")
    private WebElementFacade txtCiudad;

    @FindBy(id = "card")
    private WebElementFacade txtTarjetaCredito;

    @FindBy(id = "month")
    private WebElementFacade txtMes;

    @FindBy(id = "year")
    private WebElementFacade txtAno;

    @FindBy(xpath = ".//button[@onclick='purchaseOrder()']")
    private WebElementFacade btnComprar;

    @FindBy(xpath = ".//h2[contains(.,'Thank')]")
    private WebElementFacade lblMensajeCompraSatisfactoria;

    public FormularioRealizarPedidoPage(WebDriver driver) {
        super(driver);
    }

    public void diligenciarNombre(String nombre) {
        txtNombre.waitUntilVisible()
                .waitUntilClickable()
                .sendKeys(nombre);
    }

    public void diligenciarPais(String pais) {
        txtPais.waitUntilVisible().sendKeys(pais);
    }

    public void diligenciarCiudad(String ciudad) {
        txtCiudad.waitUntilVisible().sendKeys(ciudad);
    }

    public void diligenciarTarjetaCredito(String tarjetaCredito) {
        txtTarjetaCredito.waitUntilVisible().sendKeys(tarjetaCredito);
    }

    public void diligenciarMes(String mes) {
        txtMes.waitUntilVisible().sendKeys(mes);
    }

    public void diligenciarAno(String ano) {
        txtAno.waitUntilVisible().sendKeys(ano);
    }

    public void completarPedido() {
        btnComprar.click();
    }

    public String obtenerTextoMensajeExitoso(){
        return lblMensajeCompraSatisfactoria.waitUntilVisible()
                .getText();
    }
}
