package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public final class DBUtils {

    private static final Logger logger = LogManager.getLogger(DBUtils.class);

    // Simulation value
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";

    private DBUtils() {
        // utils - no instancy
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Successfully connected to the database URL: {}", DB_URL);
            return connection;
        } catch (SQLException e) {
            logger.error("Failed to establish database connection!", e);
            return null;
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            Connection conn = getConnection();
            if (conn == null) {
                logger.warn("executeQuery aborted: connection is null");
                return null;
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Obs: The call need close conn, stmt and ts with closeConnection(...)
            return rs;
        } catch (SQLException e) {
            logger.error("Query execution failed: {}", query, e);
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        closeConnection(conn, null, null);
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.warn("Failed to close ResultSet", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                logger.warn("Failed to close Statement", e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
                logger.info("Database connection closed");
            } catch (SQLException e) {
                logger.warn("Failed to close Connection", e);
            }
        }
    }
}
