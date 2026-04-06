Feature: Ajouter un produit dans le panier
  Background:    Ajouter un produit
    Given je suis a la page des produits
    When Cliquer sur button addcard dun produit
    Then ajouter ce produit dans le panier

  Scenario: Supprimer produit
    When cliquer sur le button remove
    Then Supprimer produit
