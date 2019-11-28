# language: pt
Funcionalidade: Realizar uma compra

  Cenario: Realizar compra e validar o preço total
    Dado que acesso a página inicial da loja
    E seleciono os produtos da categoria bebidas
    E retorno a categoria todos
    E seleciono o produto 'Rissole médio'
    Quando avanço para o carrinho
    E aumento a quantidade do item 'Rissole médio' em 9 unidades
    E diminuo a quantidade do item 'Rissole médio' em 5 unidades
    Entao o valor total deve ser de 36.00 reais
    E a compra é finalizada com sucesso
    E a página de compra é fechada