package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class DeleteMethodTest extends BaseApiTest {
    private void deleteRequest(String s) {
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void deleteUser(){
        deleteRequest("api/users/2");
        assertEquals(204, response.getStatusCode());
    }
}
