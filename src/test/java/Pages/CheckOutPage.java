package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    WebDriver driver;
    WebDriverWait wait;
    By firstname = By.id("first-name");
    By lastname = By.id("last-name");
    By codepostal = By.id("postal-code");
    By checkout = By.id("checkout");
    By continuer = By.id("continue");
    By finish = By.id("finish");
    By message = By.cssSelector("#checkout_complete_container > h2");
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
    }
    public void Firstname(String name) {
        driver.findElement(firstname).sendKeys(name);
    }
    public void Lastname(String name) {
        driver.findElement(lastname).sendKeys(name);  }
    public void codepostal(String name) {
            driver.findElement(codepostal).sendKeys(name);
        }
    public void checkout() {

        driver.findElement(checkout).click();
    }
    public void continuer() {

        driver.findElement(continuer).click();
    }
    public void finish() {

        driver.findElement(finish).click();
    }
    public String Returnmessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }
}



