package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    By username = By.id("user-name");
    By password = By.id("password");
    By buttonLogin = By.id("login-button");
    By errorMessage = By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");
    //@FindBy(id = "user-name")
    //WebElement userName;
    //@FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    //WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
    }
    public void EnterUserName(String name) {
        driver.findElement(username).sendKeys(name);
    }
    public void EnterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(buttonLogin).click();
    }
    public String Returnmessage()
    {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    }
