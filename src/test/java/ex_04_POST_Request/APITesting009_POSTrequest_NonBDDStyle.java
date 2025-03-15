package ex_04_POST_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POSTrequest_NonBDDStyle {
     RequestSpecification r;
     Response response;
     ValidatableResponse vr;

    @Test
    public void test_POSTrequest_CreateToken_NonBDDStyle(){
        String payload =  "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        response = r.when().log().all().post();

        vr=response.then().log().all().statusCode(200);

    }

}
