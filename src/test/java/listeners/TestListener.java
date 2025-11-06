
package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance == null) {
            return;
        }

        WebDriver driver = extractWebDriver(testInstance);
        if (driver == null) {
            return;
        }

        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            attachScreenshot(screenshot);
        } catch (Exception ignored) {
            //fail silently if screenshot capture fails
        }
    }

    private WebDriver extractWebDriver(Object testInstance) {
        Class<?> clazz = testInstance.getClass();

        //find by fields of type WebDriver
        for (Field field : clazz.getDeclaredFields()) {
            if (WebDriver.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(testInstance);
                    if (value instanceof WebDriver) {
                        return (WebDriver) value;
                    }
                } catch (IllegalAccessException ignored) {
                }
            }
        }

        //find by common field names
        String[] commonNames = {"driver", "webDriver"};
        for (String name : commonNames) {
            try {
                Field f = clazz.getDeclaredField(name);
                if (WebDriver.class.isAssignableFrom(f.getType())) {
                    f.setAccessible(true);
                    Object value = f.get(testInstance);
                    if (value instanceof WebDriver) {
                        return (WebDriver) value;
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException ignored) {
            }
        }

        return null;
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    private byte[] attachScreenshot(byte[] screenShot) {
        return screenShot;
    }
}