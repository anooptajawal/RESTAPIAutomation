import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestDemo {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";
    }

    @Test
    public void validatePost(){
        given()
                .queryParam("key","AIzaSyCtgOTLQ4fXoRDPSleaw9FPFLxLXmjdeKA\n")
                .body("{\n" +
                        "   \"html_attributions\" : [],\n" +
                        "   \"result\" : {\n" +
                        "      \"address_components\" : [\n" +
                        "         {\n" +
                        "            \"long_name\" : \"5\",\n" +
                        "            \"short_name\" : \"5\",\n" +
                        "            \"types\" : [ \"floor\" ]\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"long_name\" : \"48\",\n" +
                        "            \"short_name\" : \"48\",\n" +
                        "            \"types\" : [ \"street_number\" ]\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"long_name\" : \"Pirrama Road\",\n" +
                        "            \"short_name\" : \"Pirrama Rd\",\n" +
                        "            \"types\" : [ \"route\" ]\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"long_name\" : \"Pyrmont\",\n" +
                        "            \"short_name\" : \"Pyrmont\",\n" +
                        "            \"types\" : [ \"locality\", \"political\" ]\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"long_name\" : \"Council of the City of Sydney\",\n" +
                        "            \"short_name\" : \"Sydney\",\n" +
                        "            \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"long_name\" : \"New South Wales\",\n" +
                        "            \"short_name\" : \"NSW\",\n" +
                        "            \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"long_name\" : \"Australia\",\n" +
                        "            \"short_name\" : \"AU\",\n" +
                        "            \"types\" : [ \"country\", \"political\" ]\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"long_name\" : \"2009\",\n" +
                        "            \"short_name\" : \"2009\",\n" +
                        "            \"types\" : [ \"postal_code\" ]\n" +
                        "         }\n" +
                        "      ],\n" +
                        "      \"adr_address\" : \"5, \\u003cspan class=\\\"street-address\\\"\\u003e48 Pirrama Rd\\u003c/span\\u003e, \\u003cspan class=\\\"locality\\\"\\u003ePyrmont\\u003c/span\\u003e \\u003cspan class=\\\"region\\\"\\u003eNSW\\u003c/span\\u003e \\u003cspan class=\\\"postal-code\\\"\\u003e2009\\u003c/span\\u003e, \\u003cspan class=\\\"country-name\\\"\\u003eAustralia\\u003c/span\\u003e\",\n" +
                        "      \"formatted_address\" : \"5, 48 Pirrama Rd, Pyrmont NSW 2009, Australia\",\n" +
                        "      \"formatted_phone_number\" : \"(02) 9374 4000\",\n" +
                        "      \"geometry\" : {\n" +
                        "         \"location\" : {\n" +
                        "            \"lat\" : -33.866651,\n" +
                        "            \"lng\" : 151.195827\n" +
                        "         },\n" +
                        "         \"viewport\" : {\n" +
                        "            \"northeast\" : {\n" +
                        "               \"lat\" : -33.8653881697085,\n" +
                        "               \"lng\" : 151.1969739802915\n" +
                        "            },\n" +
                        "            \"southwest\" : {\n" +
                        "               \"lat\" : -33.86808613029149,\n" +
                        "               \"lng\" : 151.1942760197085\n" +
                        "            }\n" +
                        "         }\n" +
                        "      },\n" +
                        "      \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png\",\n" +
                        "      \"id\" : \"4f89212bf76dde31f092cfc14d7506555d85b5c7\",\n" +
                        "      \"international_phone_number\" : \"+61 2 9374 4000\",\n" +
                        "      \"name\" : \"Google\",\n" +
                        "      \"place_id\" : \"ChIJN1t_tDeuEmsRUsoyG83frY4\",\n" +
                        "      \"rating\" : 4.5,\n" +
                        "      \"reference\" : \"CmRSAAAAjiEr2_A4yI-DyqGcfsceTv-IBJXHB5-W3ckmGk9QAYk4USgeV8ihBcGBEK5Z1w4ajRZNVAfSbROiKbbuniq0c9rIq_xqkrf_3HpZzX-pFJuJY3cBtG68LSAHzWXB8UzwEhAx04rgN0_WieYLfVp4K0duGhTU58LFaqwcaex73Kcyy0ghYOQTkg\",\n" +
                        "      \"reviews\" : [\n" +
                        "         {\n" +
                        "            \"author_name\" : \"Robert Ardill\",\n" +
                        "            \"author_url\" : \"https://www.google.com/maps/contrib/106422854611155436041/reviews\",\n" +
                        "            \"language\" : \"en\",\n" +
                        "            \"profile_photo_url\" : \"https://lh3.googleusercontent.com/-T47KxWuAoJU/AAAAAAAAAAI/AAAAAAAAAZo/BDmyI12BZAs/s128-c0x00000000-cc-rp-mo-ba1/photo.jpg\",\n" +
                        "            \"rating\" : 5,\n" +
                        "            \"relative_time_description\" : \"a month ago\",\n" +
                        "            \"text\" : \"Awesome offices. Great facilities, location and views. Staff are great hosts\",\n" +
                        "            \"time\" : 1491144016\n" +
                        "         }\n" +
                        "      ],\n" +
                        "      \"scope\" : \"GOOGLE\",\n" +
                        "      \"types\" : [ \"point_of_interest\", \"establishment\" ],\n" +
                        "      \"url\" : \"https://maps.google.com/?cid=10281119596374313554\",\n" +
                        "      \"utc_offset\" : 600,\n" +
                        "      \"vicinity\" : \"5, 48 Pirrama Road, Pyrmont\",\n" +
                        "      \"website\" : \"https://www.google.com.au/about/careers/locations/sydney/\"\n" +
                        "   },\n" +
                        "   \"status\" : \"OK\"\n" +
                        "}")
                .when()
                .post("/place/details/json")
                .then()
                .statusCode(200).and().contentType(ContentType.JSON);
    }
}
