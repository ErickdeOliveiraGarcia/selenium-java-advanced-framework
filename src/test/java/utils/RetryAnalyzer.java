package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// You should integrate the Log4j2 Logger here as well for better reporting
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
            logger.warn("Retrying test method " + result.getName() + " for the " + counter + " time.");
            return true; // Re-run the test
        }
        return false; // Do not re-run
    }
}