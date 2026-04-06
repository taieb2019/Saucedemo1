Feature: Deconnexion Log out
  Scenario: Deconnexion un utilisateur
    Given je suis sur la page Home
    When  Cliquer sur le button menu
    And cliquer sur le button looout
    Then retourner a la page connexion
