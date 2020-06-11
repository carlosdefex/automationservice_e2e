package com.co.testrappi.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://www.demoblaze.com/")
public class DemoBlazePage extends PageObject {

    @FindBy(xpath = ".//a[@onclick='addToCart(12)']")
    private WebElementFacade btnAgregarCarrito;

    @FindBy(id = "cartur")
    private WebElementFacade lnkCarrito;

    @FindBy(xpath = ".//button[@data-target='#orderModal']")
    private WebElementFacade btnRealizarPedido;

    private String txt_laptos  = ".//div[@class='list-group']//a[contains(.,'replace')]";
    private String txt_producto  = ".//h4[@class='card-title']//a[contains(.,'replace')]";

    public DemoBlazePage(WebDriver driver) {
        super(driver);
    }

    public void navegarCategoria(String categoria) {
        $(txt_laptos.toLowerCase().replace("replace", categoria)).waitUntilClickable()
                .click();
    }

    public void seleccionarProducto(String producto) {
        $(txt_producto.replace("replace", producto)).waitUntilClickable()
                .click();
    }

    public void agregarCarrito(){
        btnAgregarCarrito.waitUntilClickable()
                .click();
    }

    public void aceptarVentanaProductoAgregado() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            MatcherAssert.assertThat("Fallo en la ventana de chrome", alert.getText().contains("Thanks."));
        } catch (Exception e) {
            //exception handling
        }
    }

    public void seleccionarMenuCarrito(){
        lnkCarrito.waitUntilVisible().waitUntilEnabled()
                .waitUntilClickable()
                .click();
    }

    public void ordenarPedido(){
        btnRealizarPedido.waitUntilVisible()
                .waitUntilClickable()
                .click();
    }
}
