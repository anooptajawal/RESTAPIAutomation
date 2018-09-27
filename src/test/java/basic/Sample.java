package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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

    @Test(enabled = true)
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

                //validate the content from response body
                .body("rows[0].elements[0].distance.value", equalTo(361993))
                .body("rows[0].elements[0].distance.text", equalTo("225 mi"))

                //Validate that the content type is JSON/XML
                .contentType(ContentType.JSON);
    }

    @Test(enabled = false)
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
