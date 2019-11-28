package setup;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.PropertiesReader;
import utils.ReportFactory;

import java.util.Properties;

public class TestRule {
    private static WebDriver driver;
    private static Properties runProperties;

    @Before
    public void configuraTeste(Scenario cenario) {
        runProperties = PropertiesReader.readPropFile("run");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        ReportFactory.criarReport(cenario);
    }

    @After
    public void finalizaTeste(Scenario cenario) {
        ReportFactory.logMensagemInfoPrint("Finalizando estância do chromeDriver");
        driver.quit();
        ReportFactory.atualizaReport(cenario);
    }

    public static Properties getRunProperties() {
        return runProperties;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
