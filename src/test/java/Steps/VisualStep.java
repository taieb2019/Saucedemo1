package Steps;

import Pages.CheckOutPage;
import Pages.Hooks;
import Pages.LoginPage;
import Pages.ProduitPage;
import Utils.VisualValidation;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class VisualStep {

    WebDriver driver = Hooks.driver ;
    CheckOutPage checkoutPage;
    ProduitPage produitPage;



    @Then("verifier licon panier doit etre graphiquement conforme")
    public void verifierLiconPanierDoitEtreGraphiquementConforme() throws IOException {
        String screenshotPath = "target/cart_icon_ref.png";
        String referencePath = "src/test/resources/cart_icon_ref.png";

        // ✅ Cible l'élément avec Selenium
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));

        // Prendre la capture d'écran de l'élément spécifique
        File srcFile = cartIcon.getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);
        FileUtils.copyFile(srcFile, destFile);

        // Comparaison avec OpenCV (La logique reste la même)
        boolean isFound = VisualValidation.isElementPresent(screenshotPath, referencePath, 0.9);

        Assert.assertTrue("L'icône du panier est graphiquement différente !", isFound);
    }

    @And("je termine un achat complet")
    public void jeTermineUnAchatComplet() {
        this.driver  = Hooks.driver;
        produitPage = new ProduitPage(this.driver);
        checkoutPage =  new CheckOutPage(this.driver);
       produitPage.addtocard();
       produitPage.verifypanier();
       checkoutPage.checkout();
       checkoutPage.Firstname("AA");
       checkoutPage.Lastname("BB");
       checkoutPage.codepostal("12345");
       checkoutPage.continuer();
       checkoutPage.finish();

    }

    @Then("la page de confirmation ne doit pas avoir de décalage visuel")
    public void laPageDeConfirmationNeDoitPasAvoirDeDécalageVisuel() throws IOException {
        String actualPath = "target/checkout_success_master.png";
        String expectedPath = "src/test/resources/checkout_success_master.png";
        String diffPath = "target/diff_result.png";

        // 1. Capture de l'écran complet
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File(actualPath));

        // 2. Comparaison pixel par pixel via OpenCV
        double diffPercent = VisualValidation.compareImages(expectedPath, actualPath, diffPath);

        // 3. Assertion
        Assert.assertTrue("Décalage visuel détecté : " + diffPercent + "%. Voir : " + diffPath,
                diffPercent < 1.0);
    }

}
