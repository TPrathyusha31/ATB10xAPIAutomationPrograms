package ex_08_TestNG_Annotations_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting013_TestNG_BeforeTest {
    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingid(){
        System.out.println("2");
    }
    @Test
    public void test_PUT(){
        System.out.println("3");
    }
    @AfterTest
    public void closeAll(){
        System.out.println("close");
    }

}
