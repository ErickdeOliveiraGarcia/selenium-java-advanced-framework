// java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageFactoryBase{

    //Define Locators
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private  WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "div.error-message-container")
    private WebElement errorMessageContainer;


    //Constructor calls the parent constructor which handle PageFactory initialization
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Interaction Methods
    public void enterUsername(String username) {
        // No need for driver.findElement() anymore, just use the initialized field
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        // Use the inherited waitUtils object
        waitUtils.waitForElementToBeClickable(By.id("login-button"), 10).click();

    }

    public void login(String username, String password) {
      enterUsername(username);
      enterPassword(password);
      clickLoginButton();

    }

    public String getErrorMessage() {
        waitUtils.waitForElementToBeVisible(By.cssSelector("div.error-message-container"), 5);
        return errorMessageContainer.getText();
    }

}
