package ex_01_RestAssuredBasics;

import io.restassured.RestAssured;



public class APITesting001_FirstRestAssuredCode {
    public static void main(String[] args) {
         RestAssured
                 .given()
                    .baseUri("https://api.zippopotam.us")
                     .basePath("/IN/110048")
                 .when()
                     .get()
                 .then()
                     .log().all().statusCode(200);
    }

}
