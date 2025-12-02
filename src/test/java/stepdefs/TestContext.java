// src/test/java/stepdefs/TestContext.java

package stepdefs;

import org.apache.logging.log4j.Logger; // Crucial Import!
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class TestContext {

    public WebDriver driver;
    public LoginPage loginPage;
    public Logger logger; // ⬅️ THIS FIELD MUST EXIST

    public TestContext() {
        // PicoContainer manages instantiation
    }
}