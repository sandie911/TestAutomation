package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;


public class PostMethodTest extends BaseApiTest{
        private void postRequest(String s) {
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(userPojo)
                    .post(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Response:" + response.asString());
    }
    @Test
    public void createUser(){
        userPojo.setName("morpheus");
        userPojo.setJob("leader");
        postRequest("api/users");
        assertEquals(201, response.getStatusCode());
    }


    @Test
    public void registerUserSuccessful(){
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("pistol");
        postRequest("api/register");
        assertEquals(200, response.getStatusCode());

    }
    @Test
    public void registerUserUnSuccessful(){
        userPojo.setEmail("sydney@fife");
        postRequest("api/register");
        assertEquals(400, response.getStatusCode());

    }
    @Test
    public void loginUserSuccessful(){
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka");
        postRequest("api/login");
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void loginUserUnSuccessful(){
        userPojo.setEmail("peter@klaven");
        postRequest("api/register");
        assertEquals(400, response.getStatusCode());

    }
}
