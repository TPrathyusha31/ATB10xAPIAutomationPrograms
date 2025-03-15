package ex_06_PATCH_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PATCHrequest_NonBDD {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PATCHrequest_NonBDDstyle(){
        String token="b7036be6000fa2e";
        String bookingid = "10731";
        String payload = "{\n" +
                "    \"firstname\" : \"Pramaya\",\n" +
                "}";
        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload);

        response = r.when().patch();

        vr=response.then().log().all().statusCode(200);
    }
}
