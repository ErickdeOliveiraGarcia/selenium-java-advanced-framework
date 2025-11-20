package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserAPITest extends APIClient{
    @Test(groups = {"API"})
    public void getUsersListAndValidate() {
        //Use the centrally configured requestSpec
        given()
                .spec(requestSpec)
                .when()
                .get("/users?page=2") // The endpoint
                .then()
                .statusCode(200)//Assert the HTTP Status Code
                .body("per_page", equalTo(6))//Assert 'per_page' value
                .log().all();//Log the entire response details
    }
}
