package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features/RealizarCompraValidandoValorTotal.feature",
        glue = { "" }, monochrome = true, junit = "--step-notifications")
public class RealizarCompraValidandoValorTotal {
}
