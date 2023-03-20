package restAssured;

import com.hillel.api.UserPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {
    Response response = null;
    UserPojo userPojo = new UserPojo();
    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = "https://reqres.in/";
    }
}