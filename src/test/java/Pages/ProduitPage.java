package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProduitPage {


    WebDriver driver;
    WebDriverWait wait;

  By addcard = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
  By panier = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
  By remove = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");
  @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
  WebElement title_link;
  @FindBy(xpath ="//*[@id=\"item_4_title_link\"]/div" )
  WebElement title_link2;

    public ProduitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;

    }

    public void addtocard()
    {
     driver.findElement(addcard).click();

    }

    public void verifypanier()

    {
        wait.until(ExpectedConditions.visibilityOf(title_link));
        String name= title_link.getText();
        driver.findElement(panier).click();
        String namepanier  =title_link2.getText();
        Assert.assertEquals(namepanier,name);


        }
    public void removebutton()
    {
        driver.findElement(panier).click();
        driver.findElement(remove).click();
    }
    public boolean verifyremovebutton()
    {
        return  wait.until(ExpectedConditions.invisibilityOf(title_link2));
    }
}
