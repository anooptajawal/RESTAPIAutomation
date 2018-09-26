import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.given;

public class PostRequestDemo {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";
    }

    public void validatePost(){
        given()
                .param("key","adads")
                .body("`sdasd`:`dsads`")
                .when()
                .post("/place/details/json")
                .then()
                .statusCode(200);
    }
}
