
package base;

import listeners.TestListener;
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

@Listeners({AnnotationTransformer.class, TestListener.class})
public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        logger.info("Setup start: configuration WebDriver and navigate for application");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = ConfigLoader.getProperty("app.url");
        logger.info("Acess URL: {}", url);
        driver.get(url);
    }

    @AfterMethod
    public void teardown() {
        logger.info("Teardown start: close o browser");
        if (driver != null) {
            driver.quit();
            logger.info("Browser close");
        } else {
            logger.info("No browser found for close");
        }
    }

    // Public getter to allow listeners to access the WebDriver instance
    public WebDriver getDriver() {
        return this.driver;
    }
}