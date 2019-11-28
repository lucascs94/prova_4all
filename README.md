# Instruções para execução dos testes automatizados
• O ambiente para execução dos testes deve conter:
• Uma IDE de preferencia do avaliador (que seja compatível com o plugin do cucumber)
• JDK 1.8 em sua versão mais recente
• O plugin do maven
• O plugin do cucumber instalado na IDE utilizada
• Navegador google chrome na versão 78
• Navegador Mozilla Firefox na versão 70

Os testes devem ser executados localmente de dentro da IDE utilizada pelo avaliador. Os testes estão contidos na pasta ‘prova_4all\src\test\java’

Para seleção do navegador a ser utilizado, deve-se acessar o arquivo ‘configuration/run.properties’ e alterar o parâmetro “driverType” selecionando as opções ‘chrome’ ou ‘firefox’.

Os relatórios de teste são gerados na pasta ‘prova_4all\reports’. Os testes de geram um único relatório html contendo todos os testes marcados para aquela execução e um novo relatório é gerado a cada execução iniciada.
