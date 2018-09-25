import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//hamcrest comes along with TestNG (Assertion Library)
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class Sample {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";

    }

    @Test(enabled = false)
    public void statusVerification() {
        given()
                .param("units", "imperial")
                .param("origins", "Washington,DC")
                .param("destinations", "New+York+City,NY")
                .param("key", "AIzaSyAFNxOzcDNEZ9coJzPc_9N-CA8Euun2fDA")
                .when()
                .get("/distancematrix/json")
                .then()
                .statusCode(200)
                .and()
                .body("rows[0].elements[1].duration.value",equalTo("13943"));

    }

    @Test
    public void getResponseBody() {
        Response response = given()
                .param("units", "imperial")
                .param("origins", "Washington,DC")
                .param("destinations", "New+York+City,NY")
                .param("key", "AIzaSyAFNxOzcDNEZ9coJzPc_9N-CA8Euun2fDA")
                .when()
                .get("/distancematrix/json");
        System.out.println(response.body().prettyPrint());
    }
}
