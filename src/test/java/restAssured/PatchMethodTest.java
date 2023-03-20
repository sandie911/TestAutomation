package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class PatchMethodTest extends BaseApiTest{
    private void patchRequest(int userId, String path) {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userPojo)
                .patch(path);

                System.out.println("Response:" + response.asString());
    }
    @Test
    public void patchUpdateUser(){
        userPojo.setName("morpheus");
        userPojo.setJob("zion resident");
        patchRequest(2, "api/users/");
        assertEquals(200, response.getStatusCode());
    }
}

