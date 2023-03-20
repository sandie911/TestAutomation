package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class GetMethodTest extends BaseApiTest{
    private void getRequest(String page, int userID, String path) {

            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .when()
                    .queryParam(page, userID)
                    .get(path);

        response.prettyPrint();
    }
    @Test

    public void getListUser() {
        getRequest("page", 2, "api/users");
        assertEquals(200, response.getStatusCode());
    }

    @Test

    public void getSingleUser() {
        getRequest("id", 2, "api/users/");
        assertEquals(200, response.getStatusCode());
    }

    @Test

    public void getSingleUserNotFound() {
        getRequest("id", 23, "api/users/");
        assertEquals(404, response.getStatusCode());
    }
 }
