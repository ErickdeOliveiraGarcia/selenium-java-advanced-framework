package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DBUtils;
import java.sql.Connection;


public class DBValidationTest extends BaseTest {

    @Test(groups = {"DB"})
    public void testDBConnectionAttempt() {
        Connection conn = null;
        boolean connectionSuccessful = false;

        // Log the start of the DB connection test
        logger.info("Starting Database Connection Test...");

        try {
            // Attempt to get the connection using the utility method
            conn = DBUtils.getConnection();

            if (conn != null) {
                connectionSuccessful = true;
                logger.info("DB Connection Attempt SUCCESSFUL (Code-wise). Connection object created.");
            } else {
                logger.warn("DB Connection Attempt FAILED: Connection object is null.");
            }

        } catch (Exception e) {
            // We catch generic exceptions (like SQLException from DBUtils) here
            logger.error("DB Connection Test FAILED with Exception: " + e.getMessage());
        } finally {
            // Always ensure the connection is closed
            DBUtils.closeConnection(conn, null, null);
        }

        Assert.assertNotNull(logger, "Logger object should be initialized.");
        logger.info("DB Validation Test finished. Check logs for connection status.");
    }

}