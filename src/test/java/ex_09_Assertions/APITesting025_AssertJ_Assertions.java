package ex_09_Assertions;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class APITesting025_AssertJ_Assertions {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST() {
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
        r = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("/booking");
        r.contentType(ContentType.JSON).body(payload);

        response = r.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);

        //Method 1 --> Restassured assertions
        vr.body("booking.firstname", Matchers.equalTo("Pramod"));
        vr.body("bookingid", Matchers.notNullValue());

        //to verify using testNG or assertJ assertions, first we need to extract the required fields which we want to validate
        Integer bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        //Method 2 --> TestNG Assertions
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "Pramod");
        Assert.assertEquals(lastname, "Dutta");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstname,"PRAMOD");

        //Method 3 --> AssertJ Assertions
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Pramod");
    }
}

