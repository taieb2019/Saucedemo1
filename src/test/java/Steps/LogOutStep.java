package Steps;

import Pages.Hooks;
import Pages.LogOutPage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LogOutStep {
    WebDriver driver ;
    LoginPage loginPage;
    LogOutPage logOutPage;
    @Given("je suis sur la page Home")
    public void je_suis_sur_la_page_home() {

        //driver = new ChromeDriver();
        this.driver  = Hooks.driver;
        loginPage = new LoginPage(this.driver);
        logOutPage = new LogOutPage(this.driver);
        this.driver.get("https://www.saucedemo.com/");
        loginPage.EnterUserName("standard_user");
        loginPage.EnterPassword("secret_sauce");
        loginPage.clickLogin();
    }
    @When("Cliquer sur le button menu")
    public void cliquer_sur_le_button_menu() {
      logOutPage.clickMenu();
    }
       @When("cliquer sur le button looout")
    public void cliquer_sur_le_button_looout() {
        logOutPage.logout();
    }
    @Then("retourner a la page connexion")
    public void retourner_a_la_page_connexion() {
    /*  String expextedUrl = "https://www.saucedemo.com/";
      String actualUrl = driver.getCurrentUrl();
      Assert.assertEquals(expextedUrl, actualUrl);
     */
        logOutPage.verify();

    }

}
