package api;

import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CreateUserAPITest extends APIClient {

    @Test(groups = {"API"})
    public void createNewUserAndValidateResponse() {
        //Prepare Request Body using POJO
        CreateUserRequest requestBody = new CreateUserRequest("Erick", "SDET");

        //Perform POST Request and map response to POJO
        CreateUserResponse response = given()
                .spec(requestSpec) //Uses the common configuration
                .body(requestBody) //RestAssured automatically serializes the POJO to JSON
                .when()

                .post("/users")
                .then()
                .statusCode(201) //Assert Status Code 201 (Created)
                .extract().as(CreateUserResponse.class); //Map JSON Response back to POJO

        //Validate the response data using Assertions
        Assert.assertEquals(response.getName(), requestBody.getName(),
                "Name in response does not match the name in the request.");
        Assert.assertNotNull(response.getId(), "User ID should not be null after creation.");
        //Log the creation (using inherited logger from BaseTest if we extend it,
        //or just System.out/LogManager here for API only)
        System.out.println("User created with ID: " + response.getId());
    }
}