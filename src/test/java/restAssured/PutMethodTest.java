package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class PutMethodTest extends BaseApiTest {
    private void putRequest(String page, int x, String s) {
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(userPojo)
                    .put(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Response:" + response.asString());
    }
    @Test
    public void updateUser(){
        userPojo.setName("morpheus");
        userPojo.setJob("zion resident");
        putRequest("id", 2, "api/users/");
        assertEquals(200, response.getStatusCode());
    }
}
