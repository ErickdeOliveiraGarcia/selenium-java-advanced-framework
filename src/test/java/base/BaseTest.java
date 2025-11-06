// src/test/java/base/BaseTest.java
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Listeners;
import utils.AnnotationTransformer;
import utils.ConfigLoader;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Listeners({AnnotationTransformer.class}) //Register the listener for retry logic
public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    //Variable that will be inherited by all test classes
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        logger.info("Setup start: configuration WebDriver and navigate for application");

        //Configure WebDriverManager for Chrome driver download and setup.
        WebDriverManager.chromedriver().setup();

        //Initial the instance of ChromeDriver
        driver = new ChromeDriver();

        //Basic config
        driver.manage().window().maximize();

        String url = ConfigLoader.getProperty("app.url");
        logger.info("Acess URL: {}", url);
        driver.get(url);
    }

    @AfterMethod
    public void teardown() {
        logger.info("Teardown start: close o browser");
        //Close o browser after each method test
        if (driver != null) {
            driver.quit();
            logger.info("Browser close");
        } else {
            logger.info("No browser found for close");
        }
    }
}
