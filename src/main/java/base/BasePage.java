package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestRule;
import utils.ReportFactory;

public class BasePage {
    protected static WebDriver driver;
    private WebDriverWait wait;

    protected BasePage() {
        driver = TestRule.getDriver();
        wait = new WebDriverWait(driver, 15);
    }

    protected void esperaElemento(WebElement elem) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        } catch (Exception e) {
            ReportFactory.logMensagemErroPrint("Elemento não encontrado!");
        }
    }

    protected void preencheCampo(WebElement elem, String valor) {
        esperaElemento(elem);
        elem.sendKeys(valor);
    }

    protected void pressionaBotao(WebElement elem) {
        esperaElemento(elem);
        elem.click();
    }

    protected boolean validaExibicaoElemento(WebElement elem) {
        esperaElemento(elem);
        return elem.isDisplayed();
    }

    protected String getAtributoElementoPeloTexto(String nomeItem, String atributo){
        WebElement elem = getElementoPeloTexto(nomeItem);
        String id = getAtributoDoElemento(elem, atributo);
        String[] split = id.split("-");
        String numProd = "";
        for (String s: split) {
            if(!s.equals("product") && !s.equals("name") && !s.isEmpty()){
                numProd = s;
            }
        }
        return numProd;
    }

    private WebElement getElementoPeloTexto(String texto){
        return driver.findElement(By.xpath("//*[contains(text(), '" + texto + "')]"));
    }

    private String getAtributoDoElemento(WebElement elem, String atributo){
        return elem.getAttribute(atributo);
    }

    protected WebElement getElementoPeloId(String id){
        return driver.findElement(By.id(id));
    }
}
