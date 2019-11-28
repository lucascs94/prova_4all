package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.TestRule;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "open-categories-btn")
    private WebElement selecioneCategoria;

    @FindBy(xpath = "//*[contains(text(), 'Doces')]")
    private WebElement categoriaDoces;

    @FindBy(xpath = "//*[contains(text(), 'Bebidas')]")
    private WebElement categoriaBebidas;

    @FindBy(id = "category-all")
    private WebElement categoriaTodos;

    @FindBy(id = "cart-btn")
    private WebElement botaoCarrinho;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public void acessaPaginaInicial() {
        driver.navigate().to(TestRule.getRunProperties().getProperty("baseWebUrl"));
        esperaElemento(selecioneCategoria);
    }

    private List<WebElement> getBotoesAddCarrinho(){
        return driver.findElements(By.xpath("//*[contains(text(), 'Adicionar ao carrinho')]"));
    }

    public void clicaSelecioneCategoria(){
        pressionaBotao(selecioneCategoria);
    }

    public void selecionaCategoriaDoces(){
        pressionaBotao(categoriaDoces);
    }

    public void selecionaCategoriaBebidas(){
        pressionaBotao(categoriaBebidas);
    }

    public void adicionarTodosProdutosAoCarrinho(){
        List<WebElement> botoes = getBotoesAddCarrinho();
        for(WebElement e: botoes){
            pressionaBotao(e);
        }
    }

    public void selecionaCategoriaTodos(){
        pressionaBotao(categoriaTodos);
    }

    public void pressionaBotaoCarrinho(){
        pressionaBotao(botaoCarrinho);
    }

    private WebElement getBotaoAddCarrinho(String nomeItem){
        String idBotaoAddCarrinho = "add-product-" + getAtributoElementoPeloTexto(nomeItem, "data-id") + "-btn";
        return driver.findElement(By.id(idBotaoAddCarrinho));
    }

    public void pressionaAddCarrinho(String produto){
        pressionaBotao(getBotaoAddCarrinho(produto));
    }
}
