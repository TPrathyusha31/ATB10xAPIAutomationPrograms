package ex_09_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting023_RestAssured_Assertions {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    public void test_POST(){
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
        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("/booking");
        r.contentType(ContentType.JSON).body(payload).log().all();

        response = r.when().log().all().post();

        vr=response.then().log().all();
        vr.statusCode(200);

        vr.body("booking.firstname", Matchers.equalTo("Pramod"));
        vr.body("booking.lastname",Matchers.equalTo("Dutta"));
        vr.body("bookingid",Matchers.notNullValue());

    }
}
