package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testTittleValid() {
        LoginPage loginPage = new LoginPage(driver);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Swag Labs", "The title of this page does not match the expected value.");
    }

    @Test
    public void testSuccessfulLogin() {
        //Use the object 'driver' initialized in BaseTest
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user","secret_sauce");

        String currrentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currrentUrl);

        Assert.assertTrue(currrentUrl.contains("/inventory.html"), "The URL does not contain the expected path ");
        //Assert basic the TestNG to check if navigation worked
    }

    @Test
    public void testInvalidLogin() {
        //Use the object 'driver' initialized in BaseTest
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user","invalid_password");

        String errorMessage = loginPage.getErrorMessage();
        System.out.println("Error Message: " + errorMessage);

        Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"), "The error message is not as expected");
    }

}