Feature: Open cv
  Scenario: Verification visuelle de licon panier
    Given je suis a la page des produits
    Then verifier licon panier doit etre graphiquement conforme
  Scenario: Vérification visuelle du succès de commande
    Given je suis a la page des produits
    And je termine un achat complet
    Then la page de confirmation ne doit pas avoir de décalage visuel