package ex_02_RA_with_testNG_and_AllureReport;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting005_Test_n_descriptionAnnotation {

        @Description("Verify that the valid pincode returns statusCode 200 OK")
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

    @Description("Verify that the invalid pincode returns statusCode 404")
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

    @Description("Verify that the invalid pincode returns statusCode 404")
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

