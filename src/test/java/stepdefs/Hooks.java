package stepdefs;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.LoginPage;

// This class MUST accept TestContext for DI
public class Hooks extends BaseTest {

    private TestContext context;

    // PicoContainer will instantiate TestContext and inject it here
    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setupDriver() {
        // Initialize the driver using the robust setup from BaseTest
        super.setup();

        // Pass the initialized driver to the shared context
        this.context.driver = super.driver;

        // Initialize the first Page Object and store it in the context
        this.context.loginPage = new LoginPage(this.context.driver);
    }

    @After
    public void teardownDriver() {
        // Use the teardown logic from BaseTest
        super.teardown();
    }
}