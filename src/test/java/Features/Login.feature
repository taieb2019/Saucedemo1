Feature: Connecxion au saucedemo
  Background: Connexion aves des identifiants valides
    Given je suis sur la page connexion
    When je saisi le nom dutiölisateur "standard_user"
    And je saisi le mot de passe dutilisateur  "secret_sauce"
    And je click sur le boutton Login
    Then redirection vers la page Home
    @Invalideconnexion
  Scenario Outline: Tentative de connexion invalide
    Given je suis sur la page connexion
    When je saisi le nom dutiölisateur "<Username>"
    And je saisi le mot de passe dutilisateur  "<password>"
    And je click sur le boutton Login
    Then message Erreur afficher "<Messageattendue>"
    Examples:
    |Username|password|Messageattendue|
    |qqqq|secret_sauce|Epic sadface: Username and password do not match any user in this service|
    |standard_user|sslsls  |Epic sadface: Username and password do not match any user in this service|
    |    |secret_sauce | Epic sadface: Username is required                                          |
    |  locked_out_user  |   secret_sauce          |Epic sadface: Sorry, this user has been locked out.|
      Scenario: Deconnexion
        When  Cliquer sur le button menu
        And cliquer sur le button looout
        Then retourner a la page connexion