package Steps;

import Pages.CheckOutPage;
import Pages.Hooks;
import Pages.LoginPage;
import Pages.ProduitPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ChekOutStep {
    WebDriver driver = Hooks.driver ;
    CheckOutPage  checkOutPage;

    @When("je clique sur le button chekout")
    public void jeCliqueSurLeButtonChekout() {
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.checkout();
    }

    @And("je saisie le first name {string}")
    public void jeSaisieLeFirstName(String arg0) {

        checkOutPage.Firstname(arg0);

    }
    @When("je saisie le last name  {string}")
    public void je_saisie_le_last_name(String string) {
       checkOutPage.Lastname(string);
    }
    @When("je saisie le code postal {string}")
    public void je_saisie_le_code_postal(String string) {
        checkOutPage.codepostal(string);
    }
    @When("je clique sur le button continuer")
    public void je_clique_sur_le_button_continuer() {
        checkOutPage.continuer();
    }
    @When("je clique sue le button finish")
    public void je_clique_sue_le_button_finish() {
        checkOutPage.finish();
    }
    @Then("message recue de checkout")
    public void message_recue_de_checkout() {
        String expextmessage = "Thank you for your order!";
        String actualmessage = checkOutPage.Returnmessage();
        Assert.assertEquals(expextmessage, actualmessage);
}
}
