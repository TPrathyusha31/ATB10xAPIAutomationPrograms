package ex_02_RA_with_testNG_and_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting004_TestCase_with_TestNGandAllure {

    //TC#1 - Positive case with valid pincode
    @Test
    public void test_GET_PositiveTC1(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/110048")
                .when()
                .get()
                .then().log().all().statusCode(200);

    }

    //TC#2 - Negative case with invalid pincode
    @Test
    public void test_GET_NegativeTC2(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/@")
                .when()
                .get()
                .then().log().all().statusCode(404);

    }

    //TC#3 - Negative case with invalid pincode
    @Test
    public void test_GET_NegativeTC3(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/-1")
                .when()
                .get()
                .then().log().all().statusCode(404);

    }


}
