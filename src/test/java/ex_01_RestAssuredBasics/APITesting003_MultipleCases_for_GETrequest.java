package ex_01_RestAssuredBasics;

import io.restassured.RestAssured;

public class APITesting003_MultipleCases_for_GETrequest {
    public static void main(String[] args) {

        //TC#1 - Positive case with valid pincode
        String pincode = "110048";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);

        //TC#2 - Negative case with invalid pincode
        pincode = "#";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);

        //TC#3 - Negative case with invalid pincode
        pincode = "";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);

//here we cannot run each case individually so to overcome this problem we use TestNG where we can run individual testcase
//without running entire main method

    }
}
