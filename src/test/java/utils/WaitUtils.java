package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriver driver;

    public WaitUtils(WebDriver driver){

        this.driver = driver;
    }

    //Method to wait for an element to be visible
    public WebElement waitForElementToBeVsisible(By locator, int timeoutInSecods){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecods));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Method to wait for an element to be clickable
    public WebElement waitForElmentToBeClickable(By locator, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
}
