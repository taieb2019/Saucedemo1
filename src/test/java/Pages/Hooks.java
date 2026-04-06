package Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void setup() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // On cast le driver pour prendre la photo
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // On attache l'image au rapport Cucumber
            scenario.attach(screenshot, "image/png", "Screenshot_Erreur");
        }
       // driver.quit();
        driver = null;
    }
}
