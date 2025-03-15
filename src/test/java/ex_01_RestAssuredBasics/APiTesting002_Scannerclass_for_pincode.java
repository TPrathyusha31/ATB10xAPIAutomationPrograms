package ex_01_RestAssuredBasics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APiTesting002_Scannerclass_for_pincode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the pincode: ");
        String pincode = sc.next();

        RestAssured
                .given()
                   .baseUri("https://api.zippopotam.us")
                   .basePath("/IN/"+pincode)
                .when()
                  .get()
                .then()
                   .log().all().statusCode(200);
    }
}
