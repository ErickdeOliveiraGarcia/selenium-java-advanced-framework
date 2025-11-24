package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    // 1. Dependency Injection (DI): PicoContainer automatically provides the shared context
    private TestContext context;

    /*
      Constructor injected by PicoContainer.
      This ensures all shared objects (like the WebDriver and Page Objects)
      are available via the TestContext object.
     */
    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Verification step: The driver is navigated to the URL in the Hooks setup.
        // We verify the page title or URL to ensure we started correctly.
        Assert.assertTrue(context.driver.getCurrentUrl().contains("saucedemo"),
                "Verification Failed: Driver did not land on the login page.");
        context.logger.info("Given: User is on the login page.");
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        // Use the LoginPage object stored in the shared context
        context.loginPage.login(username, password);
        context.logger.info("When: Logged in with user: " + username);
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected_to_the_inventory_page() {
        // Verification step: Check the resulting URL after the login action
        String currentUrl = context.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/inventory.html"),
                "Then Failed: Expected inventory page but landed on: " + currentUrl);
        context.logger.info("Then: Successfully redirected to inventory page.");
    }
}