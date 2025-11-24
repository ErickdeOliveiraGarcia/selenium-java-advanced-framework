package stepdefs;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
// IMPORT the Log4j2 Logger class
import org.apache.logging.log4j.Logger;

// This class holds shared state
public class TestContext {

    public WebDriver driver;
    public LoginPage loginPage;

    // 💡 FIX 1: DECLARE the Logger field
    public Logger logger;

    // The rest of the class remains the same for now...
    public TestContext() {
        // ...
    }
}