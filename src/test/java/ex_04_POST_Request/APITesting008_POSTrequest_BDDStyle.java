package ex_04_POST_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting008_POSTrequest_BDDStyle {

    @Test
    public void test_POSTrequest_CreateToken_BDDStyle(){
        String payload =
                "{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}";

                RestAssured
                        .given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/auth")
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .when()
                        .log().all()
                        .post()
                        .then()
                        .log().all().statusCode(200);
    }
}
