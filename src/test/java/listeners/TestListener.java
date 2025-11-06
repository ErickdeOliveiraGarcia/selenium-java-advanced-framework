
package listeners;

import base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getName(), result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = null;

        // Use the public getter instead of accessing the protected field directly
        if (testClass instanceof BaseTest) {
            driver = ((BaseTest) testClass).getDriver();
        }

        if (driver != null) {
            saveScreenshot(driver);
            logger.info("Screenshot captured and attached for failed test: " + result.getName());
        }
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override public void onTestStart(ITestResult result) { /* not used */ }
    @Override public void onTestSuccess(ITestResult result) { /* not used */ }
    @Override public void onTestSkipped(ITestResult result) { /* not used */ }
    // other ITestListener methods can be added if needed
}
