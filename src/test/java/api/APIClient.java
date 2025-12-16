package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static io.restassured.RestAssured.baseURI;


public class APIClient {
    // Load API key from multiple sources: env var, system property, or local .env file
    static String apiKey = loadApiKey();

    //Define Base URL and Request Specification centrally
    public static final String BASE_URI = "https://reqres.in/api/";
    protected static RequestSpecification requestSpec;

    //Use TestNG @BeforeSuite to ensure this runs once before any API test
    @BeforeSuite(groups = {"API", "UI"})
    public static void setup(){
        baseURI = BASE_URI; //Set the RestAssured baseURI

        //Configure a common Request Specification
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType("application/json")
                .log(io.restassured.filter.log.LogDetail.ALL); // Log all request details


        // Only add the Authorization header if an API key is found
        if (apiKey != null && !apiKey.isBlank()) {
            builder.addHeader("Authorization", "Bearer " + apiKey);
        }
        requestSpec = builder.build();
    }

    /**
     * Loads the API Key from different sources in a specific order of priority:
     * 1. Environment Variable (API_KEY) - Ideal for CI/CD pipelines.
     * 2. Java System Property (-DAPI_KEY=...) - Useful for command-line execution.
     * 3. .env file in the project root - Ideal for local development.
     *
     * @return The API key as a String, or null if not found in any source.
     */
    private static String loadApiKey() {
        // Chain of responsibility for loading the API key
        return Stream.<Supplier<String>>of(
                        () -> System.getenv("API_KEY"),
                        () -> System.getProperty("API_KEY"),
                        APIClient::loadApiKeyFromFile
                )
                .map(Supplier::get)
                .filter(key -> key != null && !key.isBlank())
                .findFirst()
                .orElse(null);
    }

    private static String loadApiKeyFromFile() {
        Path envPath = Paths.get(".env");
        if (!Files.exists(envPath)) {
            return null;
        }
        try (Stream<String> lines = Files.lines(envPath)) {
            return lines.filter(line -> line.trim().startsWith("API_KEY="))
                    .map(line -> line.substring(line.indexOf('=') + 1).trim())
                    .map(val -> val.startsWith("\"") && val.endsWith("\"") ? val.substring(1, val.length() - 1) : val)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.err.println("Error reading .env file: " + e.getMessage());
            return null;
        }
    }
}
