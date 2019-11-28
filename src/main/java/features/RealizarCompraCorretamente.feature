# language: pt
Funcionalidade: Realizar uma compra

  Cenario: Realizar compra corretamente
    Dado que acesso a página inicial da loja
    E seleciono os produtos da categoria doces
    E retorno a categoria todos
    Quando avanço para o carrinho
    E aumento a quantidade do item 'Brigadeiro' em 4 unidades
    E finalizo a compra
    Entao a compra é realizada com sucesso
    E a página de compra é fechada