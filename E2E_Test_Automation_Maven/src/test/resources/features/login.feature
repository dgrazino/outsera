Feature: Teste de Login

Scenario: Login com credenciais válidas
    Given o usuário está na página de login
    When o usuário insere credenciais válidas e faz login
    Then o usuário deve ver a página de produtos
