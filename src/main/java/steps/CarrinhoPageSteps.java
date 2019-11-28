package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.junit.jupiter.api.Assertions;
import pages.CarrinhoPage;
import utils.ReportFactory;

public class CarrinhoPageSteps {
    private CarrinhoPage carrinhoPage = new CarrinhoPage();

    @E("aumento a quantidade do item {string} em {int} unidades")
    public void adicionarQunatidadeItem(String item, int qtd){
        ReportFactory.logMensagemInfo("Aumentando a quantidade do item " + item + ".");
        carrinhoPage.addQtdItem(item, qtd);
        ReportFactory.logMensagemSucessoPrint("Quantidade do item " + item + " aumentada.");
    }

    @E("finalizo a compra")
    public void finalizarCompra(){
        ReportFactory.logMensagemInfo("Pressionando o botão Finalizar Compra.");
        carrinhoPage.pressionaFinalizarCompra();
        ReportFactory.logMensagemSucessoPrint("Botão Finalizar Compra pressionado com sucesso.");
    }

    @Entao("a compra é realizada com sucesso")
    public void validarRealizacaoCompra(){
        ReportFactory.logMensagemInfo("Verificando a finalização da compra.");
        boolean isDisplayed = (carrinhoPage.verificaRealizacaoCompra());
        if (isDisplayed) {
            ReportFactory.logMensagemSucessoPrint("A compra realizada com sucesso.");
        } else {
            ReportFactory.logMensagemFalhaPrint("A compra não foi realizada!");
        }
        Assertions.assertTrue(isDisplayed);
    }

    @E("a página de compra é fechada")
    public void pressionarBotaoFechar(){
        ReportFactory.logMensagemInfo("Fechando a página de compra.");
        carrinhoPage.pressionaBotaoFechar();
        ReportFactory.logMensagemSucessoPrint("Sistema retornou para a página inicial.");
    }

    @E("diminuo a quantidade do item {string} em {int} unidades")
    public void diminuirQunatidadeItem(String item, int qtd){
        ReportFactory.logMensagemInfo("Diminuindo a quantidade do item " + item + ".");
        carrinhoPage.removeQtdItem(item, qtd);
        ReportFactory.logMensagemSucessoPrint("Quantidade do item " + item + " reduzida.");
    }

    @Entao("o valor total deve ser de {double} reais")
    public void validarValorTotal(double total){
        ReportFactory.logMensagemInfo("Validar valor total da compra.");
        boolean isValid = carrinhoPage.validaValorTotal(total);
        if (isValid) {
            ReportFactory.logMensagemSucessoPrint("Valor total calculado corretamente.");
        } else {
            ReportFactory.logMensagemFalhaPrint("Valor total foi calculado incorretamente!");
        }
        Assertions.assertTrue(isValid);
    }

    @E("a compra é finalizada com sucesso")
    public void finalizarCompra2(){
        ReportFactory.logMensagemInfo("Pressionando o botão Finalizar Compra.");
        carrinhoPage.pressionaFinalizarCompra();
        ReportFactory.logMensagemSucessoPrint("Botão Finalizar Compra pressionado com sucesso.");
        ReportFactory.logMensagemInfo("Verificando a finalização da compra.");
        boolean isDisplayed = (carrinhoPage.verificaRealizacaoCompra());
        if (isDisplayed) {
            ReportFactory.logMensagemSucessoPrint("A compra realizada com sucesso.");
        } else {
            ReportFactory.logMensagemFalhaPrint("A compra não foi realizada!");
        }
        Assertions.assertTrue(isDisplayed);
    }
}
