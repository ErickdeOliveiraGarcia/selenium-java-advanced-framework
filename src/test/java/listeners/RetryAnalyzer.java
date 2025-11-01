package listeners; // Ensure this package matches your structure

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);
    private int counter = 0;
    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < MAX_RETRY_COUNT) {
            counter++;
            logger.warn("Retrying test method [" + result.getName() +
                    "] for the " + counter + " time. Test Status: " + result.getStatus());
            return true; // Re-run the test
        }
        return false; // Stop retrying
    }
}