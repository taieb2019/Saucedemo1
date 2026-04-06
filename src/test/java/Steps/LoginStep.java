package Steps;

import Pages.Hooks;
import Pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep {
  WebDriver driver ;
  LoginPage loginPage;
    @Given("je suis sur la page connexion")
    public void je_suis_sur_la_page_connexion() {
        //driver = new ChromeDriver();
        this.driver  =Hooks.driver;
        loginPage = new LoginPage(this.driver);
        this.driver.get("https://www.saucedemo.com/");
        //driver.manage().window().maximize();


}

    @When("je saisi le nom dutiölisateur {string}")
    public void jeSaisiLeNomDutiölisateur(String name) {
        loginPage.EnterUserName(name);


    }
    @When("je saisi le mot de passe dutilisateur  {string}")
    public void je_saisi_le_mot_de_passe_dutilisateur(String pass) {
        loginPage.EnterPassword(pass);

    }
    @When("je click sur le boutton Login")
    public void je_click_sur_le_boutton_login() {
        loginPage.clickLogin();

    }
    @Then("redirection vers la page Home")
    public void redirection_vers_la_page_home() {
       String expextedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
     Assert.assertEquals(expextedUrl, actualUrl);

    }

   // @Then("message nom dutilisateur invalide")
   // public void messageNomDutilisateurInvalide() {
   //     String expectedMessage ="Epic sadface: Username and password do not match any user in this service";
   //     String actualMessage = loginPage.Returnmessage();
    //    Assert.assertEquals(expectedMessage, actualMessage);

  //  }

    @Then("message Erreur afficher {string}")
    public void messageErreurAfficher(String expectedMessage) {

        String actualMessage = loginPage.Returnmessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        //Assert.assertTrue(actualMessage.contains(expectedMessage));
        //driver.quit();
    }
}
