Feature: confirmation de checkout
  Background:    Ajouter un produit
    Given je suis a la page des produits
    When Cliquer sur button addcard dun produit
    Then ajouter ce produit dans le panier

  Scenario: Confirmer le checkout de produit

    When je clique sur le button chekout
    And je saisie le first name "QQ"
    And  je saisie le last name  "WW"
    And je saisie le code postal "4040"
    And je clique sur le button continuer
    And je clique sue le button finish
    Then message recue de checkout

