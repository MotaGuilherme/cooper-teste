Feature: Manter Cliente

    Scenario: Realizar a busca de um cliente
        When Realizar uma busca pelo cliente com ID '1'
        Then O cliente é encontrado
        And E o seu nome é 'Nome teste'
