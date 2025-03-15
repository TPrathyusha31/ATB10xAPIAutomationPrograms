package ex_03_GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting007_GETrequest_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Description("Verify that the valid pincode returns statusCode 200 OK")
    @Test
    public void test_NonBDDStyleGET_PositiveTC() {
        String pincode = "110048";
        //Part 1 -- Pre Condition - Preparing Request - URL, Headers, Auth...
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //Part 2 -- Making HTTP Request
        response = r.when().get();

        //Part 3 -- Verification Part
        vr = response.then().log().all().statusCode(200);


    }

    @Description("Verify that the invalid pincode returns statusCode 404")
    @Test
    public void test_NonBDDStyleGET_NegativeTC() {
        String pincode = "@";

        //Part 1 -- Pre Condition - Preparing Request - URL, Headers, Auth...
        r = RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/IN/"+pincode); //(we can also write in single line using dot without semicolon)

        //Part 2 -- Making HTTP Request
        response = r.when().log().all().get(); // can also use log all here as it is available everywhere

        //Part 3 -- Verification Part
        vr = response.then().log().all().statusCode(404);


    }

}
