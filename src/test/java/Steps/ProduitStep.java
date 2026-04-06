package Steps;

import Pages.Hooks;
import Pages.LoginPage;
import Pages.ProduitPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProduitStep {


    WebDriver driver ;
    ProduitPage produitPage;
    LoginPage loginPage;
    @Given("je suis a la page des produits")
    public void je_suis_a_la_page_des_produits() {
        this.driver  = Hooks.driver;
        loginPage = new LoginPage(this.driver);
        this.driver.get("https://www.saucedemo.com/");
        loginPage.EnterUserName("standard_user");
        loginPage.EnterPassword("secret_sauce");
        loginPage.clickLogin();
        produitPage = new ProduitPage(this.driver);
    }


    @When("Cliquer sur button addcard dun produit")
    public void cliquer_sur_button_addcard_dun_produit() {
        produitPage.addtocard();
    }
    @Then("ajouter ce produit dans le panier")
    public void ajouter_ce_produit_dans_le_panier() {
       produitPage.verifypanier();
    }

    @When("cliquer sur le button remove")
    public void cliquerSurLeButtonRemove() {
       produitPage.removebutton();
    }

    @Then("Supprimer produit")
    public void supprimerProduit() {
       Assert.assertTrue(produitPage.verifyremovebutton());
    }
}
