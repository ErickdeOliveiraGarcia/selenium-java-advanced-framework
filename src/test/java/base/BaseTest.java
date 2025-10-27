package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigLoader;

public class BaseTest {

    //Variable that will be inherited by all test classes
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        //Configure WebDriverManager for Chrome driver download and setup.
        WebDriverManager.chromedriver().setup();

        //Initial the instance of ChromeDriver
        driver = new ChromeDriver();

        //Basic config
        driver.manage().window().maximize();

        driver.get(ConfigLoader.getProperty("app.url"));
    }

    @AfterMethod
    public void teardown() {
        //Close o browser after each method test
        if (driver != null) {
            driver.quit();
        }
    }
}