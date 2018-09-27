package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.POSTRequestMember;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequestDemo {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";
    }

    @Test(enabled = false)
    public void validatePost() {
        given()
                .queryParam("key", "AIzaSyCtgOTLQ4fXoRDPSleaw9FPFLxLXmjdeKA\n")

                //this is the Request Body. location is a map. so consider using hashmap to store the values
                .body("{\n" +
                        "   \"candidates\" : [\n" +
                        "      {\n" +
                        "         \"formatted_address\" : \"140 George St, The Rocks NSW 2000, Australia\",\n" +
                        "         \"geometry\" : {\n" +
                        "            \"location\" : {\n" +
                        "               \"lat\" : -33.8599358,\n" +
                        "               \"lng\" : 151.2090295\n" +
                        "            },\n" +
                        "            \"viewport\" : {\n" +
                        "               \"northeast\" : {\n" +
                        "                  \"lat\" : -33.85824767010727,\n" +
                        "                  \"lng\" : 151.2102470798928\n" +
                        "               },\n" +
                        "               \"southwest\" : {\n" +
                        "                  \"lat\" : -33.86094732989272,\n" +
                        "                  \"lng\" : 151.2075474201073\n" +
                        "               }\n" +
                        "            }\n" +
                        "         },\n" +
                        "         \"name\" : \"Museum of Contemporary Art Australia\",\n" +
                        "         \"opening_hours\" : {\n" +
                        "            \"open_now\" : false,\n" +
                        "            \"weekday_text\" : []\n" +
                        "         },\n" +
                        "         \"photos\" : [\n" +
                        "            {\n" +
                        "               \"height\" : 2268,\n" +
                        "               \"html_attributions\" : [\n" +
                        "                  \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/113202928073475129698/photos\\\"\\u003eEmily Zimny\\u003c/a\\u003e\"\n" +
                        "               ],\n" +
                        "               \"photo_reference\" : \"CmRaAAAAfxSORBfVmhZcERd-9eC5X1x1pKQgbmunjoYdGp4dYADIqC0AXVBCyeDNTHSL6NaG7-UiaqZ8b3BI4qZkFQKpNWTMdxIoRbpHzy-W_fntVxalx1MFNd3xO27KF3pkjYvCEhCd--QtZ-S087Sw5Ja_2O3MGhTr2mPMgeY8M3aP1z4gKPjmyfxolg\",\n" +
                        "               \"width\" : 4032\n" +
                        "            }\n" +
                        "         ],\n" +
                        "         \"rating\" : 4.3\n" +
                        "      }\n" +
                        "   ],\n" +
                        "   \"debug_log\" : {\n" +
                        "      \"line\" : []\n" +
                        "   },\n" +
                        "   \"status\" : \"OK\"\n" +
                        "}")
                .when()
                .post("/place/findplacefromtext/json")
                .then()
                .statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test(enabled = true)
    public void validatePOSTPOJO() {
        POSTRequestMember places = new POSTRequestMember();

        // Defining location using Hashmap - Check Java Collections to know more
        Map<String, Double> locationMap = new HashMap<>();
        locationMap.put("lat", 33.8599358);
        locationMap.put("lng", 151.2090295);

        // For List Objects
        ArrayList<String> type = new ArrayList<>();
        type.add("bla bla");

        POSTRequestMember post = new POSTRequestMember();
        post.setLocation(locationMap);
        post.setFormattedAddress("140 George St, The Rocks NSW 2000, Australia");
        post.setName("Museum of Contemporary Art Australia");
        post.setRating(4.3f);

        given()
                .queryParam("key", "AIzaSyCtgOTLQ4fXoRDPSleaw9FPFLxLXmjdeKA\n")
                .body(post)
                .when()
                .post("/place/findplacefromtext/json")
                .then()
                .statusCode(200).and().contentType(ContentType.JSON);

        //Unable to add body function to the code

    }
}
