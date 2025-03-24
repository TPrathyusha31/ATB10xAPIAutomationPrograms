package ex_09_Assertions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting024_TestNG_Assertions {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
     public void test_hardAssertions() {
        //Hard Assertions - 55%
        Boolean is_Married = false;
        System.out.println("Start of the program");
        Assert.assertEquals(is_Married, false);
        Assert.assertEquals("Pramod", "pRAmoD");
        System.out.println("End of the program");
    }

        //Soft Assertions
        @Test
        public void test_softAssertions(){
        SoftAssert softassert = new SoftAssert();
        System.out.println("Start of the program");
        softassert.assertEquals("Pramod","PRAMOD");
        System.out.println("end of the program");
        softassert.assertAll();
    }
}
