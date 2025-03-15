package ex_05_PUT_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_PUTrequest_NonBDD {


        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDDStyle(){
        String token = "92c69c3435ff96c";
        String bookingid = "794";
        String payload = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload);

        response=r.when().log().all().put();

        vr=response.then().log().all().statusCode(200);
    }

}
