package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutPage {
    WebDriver driver;
    WebDriverWait wait;
    By clickMenu = By.id("react-burger-menu-btn");
    By logoutbutton = By.id("logout_sidebar_link");

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)) ;
    }

    public void clickMenu() {
        wait.until(ExpectedConditions.presenceOfElementLocated(clickMenu)).click();
    }
public void logout() {

    wait.until(ExpectedConditions.presenceOfElementLocated(logoutbutton)).click();

}
public void verify() {
        String name= "Swag Labs";
    WebElement nom = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
  String nameExpected =nom.getText();
  Assert.assertEquals(nameExpected,name);

 }
}
