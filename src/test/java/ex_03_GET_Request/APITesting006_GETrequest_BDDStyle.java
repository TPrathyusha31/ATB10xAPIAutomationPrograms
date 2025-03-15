package ex_03_GET_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting006_GETrequest_BDDStyle {
    @Test
    public void test_GET_Positive() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/110048")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test_GET_Negative() {

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/110048")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}