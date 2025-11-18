package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.baseURI;

public class APIClient {

    //Define Base URL and Request Specification centrally
    public static final String BASE_URI = "https://reqres.in/api/";
    protected static RequestSpecification requestSpec;

    //Use TestNG @BeforeSuite to ensure this runs once before any API test
    @BeforeSuite(groups = {"API", "UI"})
    public static void setup(){
        baseURI = BASE_URI; //Set the RestAssured baseURI

        //Configure a common Request Specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType("application/json")
                .log(io.restassured.filter.log.LogDetail.ALL) // Log all request details
                .build();
    }
}
