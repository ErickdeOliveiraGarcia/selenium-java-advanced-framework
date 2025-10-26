package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulNavigation() {
        //Use the object 'driver' initialized in BaseTest
        driver.get("https://www.saucedemo.com/");

        //Assert basic the TestNG to check if navigation worked
        String pageTitle = driver.getTitle();
        System.out.println("Título da Página: " + pageTitle);

        Assert.assertEquals(pageTitle, "Swag Labs", "O título da página não corresponde ao esperado.");
    }
}