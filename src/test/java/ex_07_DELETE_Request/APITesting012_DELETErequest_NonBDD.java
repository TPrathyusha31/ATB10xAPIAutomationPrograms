package ex_07_DELETE_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_DELETErequest_NonBDD {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_DELETErequest_NonBDDStyle() {
        String token="b7036be6000fa2e";
        String bookingid = "45";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        //can also use basic auth instead of cookie using auth and basic methods
      //  r.auth().basic("admin","password123");

        response = r.when().log().all().delete();


        vr = response.then().log().all().statusCode(201);
    }
}
