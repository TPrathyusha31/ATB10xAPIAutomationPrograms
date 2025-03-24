package ex_10_Payload_Management;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting026_Maps {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST() {
//    String payload = "{\n" +
//            "    \"firstname\" : \"Pramod\",\n" +
//            "    \"lastname\" : \"Dutta\",\n" +
//            "    \"totalprice\" : 111,\n" +
//            "    \"depositpaid\" : false,\n" +
//            "    \"bookingdates\" : {\n" +
//            "        \"checkin\" : \"2024-01-01\",\n" +
//            "        \"checkout\" : \"2024-01-01\"\n" +
//            "    },\n" +
//            "    \"additionalneeds\" : \"Lunch\"\n" +
//            "}";

        //Parent map
        Map<String, Object> jsonbody_booking = new LinkedHashMap<>();
        jsonbody_booking.put("firstname", "Pramod");
        jsonbody_booking.put("lastname", "Dutta");
        jsonbody_booking.put("totalprice", 123);
        jsonbody_booking.put("depositpaid", false);

        //Child map
        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-10");
        bookingDatesMap.put("checkout","2018-01-01");
        jsonbody_booking.put("bookingdates",bookingDatesMap);
        jsonbody_booking.put("additionalneeds","Breakfast");
        System.out.println(jsonbody_booking);
        String payload = jsonbody_booking.toString();

        r= RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("/booking").contentType(ContentType.JSON).body(payload);

        response = r.when().log().all().post();

        vr=response.then().log().all();
        vr.statusCode(200);

    }
}