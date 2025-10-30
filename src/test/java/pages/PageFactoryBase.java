package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils; // Import the utility class

public class PageFactoryBase {

    protected WebDriver driver;
    protected WaitUtils waitUtils; // NEW: The Wait utility is now available to all pages

    public PageFactoryBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waitUtils = new WaitUtils(driver); // NEW: Initialize WaitUtils
    }
}