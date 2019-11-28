package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarrinhoPage extends BasePage {

    @FindBy(id = "finish-checkout-button")
    private WebElement finalizarCompra;

    @FindBy(xpath = "//*[contains(text(), 'Pedido realizado com sucesso!')]")
    private WebElement mensagemPedidoRealizado;

    @FindBy(xpath = "//*[contains(text(), 'Fechar')]")
    private WebElement botaoFechar;

    @FindBy(id = "subtotal-price")
    private WebElement subtotal;

    public CarrinhoPage(){
        PageFactory.initElements(driver, this);
    }

    private WebElement getBotaoAddQtd(String nomeItem){
        String idBotaoAddQtd = "add-product-" + getAtributoElementoPeloTexto(nomeItem, "id") + "-qtd";
        return driver.findElement(By.id(idBotaoAddQtd));
    }

    private WebElement getBotaoRemoveQtd(String nomeItem){
        String idBotaoRemoveQtd = "remove-product-" + getAtributoElementoPeloTexto(nomeItem, "id") + "-qtd";
        return driver.findElement(By.id(idBotaoRemoveQtd));
    }

    public WebElement getQtdProduto(String nomeItem){
        String idQtd = "product-" + getAtributoElementoPeloTexto(nomeItem, "id") + "-qtd";
        return driver.findElement(By.id(idQtd));
    }

    public WebElement getPrecoProduto(String nomeItem){
        String idpreco = "product-" + getAtributoElementoPeloTexto(nomeItem, "id") + "-price";
        return driver.findElement(By.id(idpreco));
    }

    public void addQtdItem(String item, int qtd){
        WebElement elem = getBotaoAddQtd(item);
        while(qtd > 0){
            pressionaBotao(elem);
            qtd--;
        }
    }

    public void removeQtdItem(String item, int qtd){
        WebElement elem = getBotaoRemoveQtd(item);
        while(qtd > 0){
            pressionaBotao(elem);
            qtd--;
        }
    }

    public void pressionaFinalizarCompra(){
        pressionaBotao(finalizarCompra);
    }

    public boolean verificaRealizacaoCompra(){
        return validaExibicaoElemento(mensagemPedidoRealizado);
    }

    public void pressionaBotaoFechar(){
        pressionaBotao(botaoFechar);
    }

    public boolean validaValorTotal(double total){
        esperaElemento(subtotal);
        String s = subtotal.getText();
        String[] ss = s.split(" ");
        return Double.parseDouble(ss[ss.length - 1].replace(',','.')) == total;
    }
}
