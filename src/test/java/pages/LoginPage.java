// java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //Define Locators
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessageContainer = By.cssSelector("div.error-message-container");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Interaction Methods
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }


    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public InventoryPage login(String username, String password) {
      enterUsername(username);
      enterPassword(password);
      clickLoginButton();

      //Returns the next expect Page Object sucessful login
        return new InventoryPage(driver);
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessageContainer).getText();
    }
}
