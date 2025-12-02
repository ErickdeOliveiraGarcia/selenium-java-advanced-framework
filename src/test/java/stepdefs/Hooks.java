// src/test/java/stepdefs/Hooks.java

package stepdefs;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.apache.logging.log4j.LogManager;
import pages.LoginPage;

public class Hooks extends BaseTest {

    private TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setupDriver() {
        // 1. Initialize Driver (from BaseTest)
        super.setup();

        // 2. Pass Driver and Page Objects to Context
        this.context.driver = super.driver;
        this.context.loginPage = new LoginPage(this.context.driver);

        // 3. 💡 CRITICAL FIX: INITIALIZE THE LOGGER
        // Assign the Log4j2 Logger instance to the context field.
        this.context.logger = LogManager.getLogger(getClass());
    }

    @After
    public void teardownDriver() {
        super.teardown();
    }
}