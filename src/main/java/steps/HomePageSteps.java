package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import utils.ReportFactory;

public class HomePageSteps {
    private HomePage homePage = new HomePage();


    @Dado("que acesso a página inicial da loja")
    public void acessarPaginaInicial(){
        ReportFactory.logMensagemInfo("Acessando página inicial.");
        homePage.acessaPaginaInicial();
        ReportFactory.logMensagemSucessoPrint("Página inicial acessada com sucesso.");
    }

    @E("seleciono os produtos da categoria doces")
    public void selecionarProdutosCategoriaDoces(){
        ReportFactory.logMensagemInfo("Iniciando a seleção da categoria Doces.");
        homePage.clicaSelecioneCategoria();
        ReportFactory.logMensagemInfoPrint("Selecionando categoria Doces.");
        homePage.selecionaCategoriaDoces();
        ReportFactory.logMensagemSucessoPrint("Categoria Doces selecionada corretamente.");
        ReportFactory.logMensagemInfo("Adicionando produtos ao carrinho.");
        homePage.adicionarTodosProdutosAoCarrinho();
        ReportFactory.logMensagemSucessoPrint("Produtos adicionados com sucesso.");
    }
    @E("retorno a categoria todos")
    public void retornarCategoriaTodos(){
        ReportFactory.logMensagemInfo("Iniciando a seleção da categoria Todos");
        homePage.clicaSelecioneCategoria();
        ReportFactory.logMensagemInfoPrint("Selecionando categoria Todos.");
        homePage.selecionaCategoriaTodos();
        ReportFactory.logMensagemSucessoPrint("Categoria Todos selecionada corretamente.");
    }

    @Quando("avanço para o carrinho")
    public void avancarParaCarrinho(){
        ReportFactory.logMensagemInfo("Acessando a página do carrinho.");
        homePage.pressionaBotaoCarrinho();
        ReportFactory.logMensagemSucessoPrint("Carrinho acessado com sucesso.");
    }

    @E("seleciono os produtos da categoria bebidas")
    public void selecionarProdutosCategoriaBebidas(){
        ReportFactory.logMensagemInfo("Iniciando a seleção da categoria Bebidas.");
        homePage.clicaSelecioneCategoria();
        ReportFactory.logMensagemInfoPrint("Selecionando categoria Bebidas.");
        homePage.selecionaCategoriaBebidas();
        ReportFactory.logMensagemSucessoPrint("Categoria Bebidas selecionada corretamente.");
        ReportFactory.logMensagemInfo("Adicionando produtos ao carrinho.");
        homePage.adicionarTodosProdutosAoCarrinho();
        ReportFactory.logMensagemSucessoPrint("Produtos adicionados com sucesso.");
    }

    @E("seleciono o produto {string}")
    public void selecionoProduto(String produto){
        ReportFactory.logMensagemInfo("Selecionando o produto " + produto +".");
        homePage.pressionaAddCarrinho(produto);
        ReportFactory.logMensagemSucessoPrint("Produto " + produto + " selecionado com sucesso.");
    }
}
