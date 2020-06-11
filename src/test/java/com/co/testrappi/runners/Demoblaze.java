package com.co.testrappi.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/demoblaze/comprar_laptop.feature",
        glue = {"com.co.testrappi.definitions"}
        //tags = ""
)
public class Demoblaze {
}
