package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class  DeleteMethodTest extends BaseApiTest {
    private void deleteRequest(String path) {

            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete(path);

        }

   @Test
    public void deleteUser(){
        deleteRequest("api/users/2");
        assertEquals(204, response.getStatusCode());
    }
}
