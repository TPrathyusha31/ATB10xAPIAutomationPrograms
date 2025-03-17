package ex_08_TestNG_Annotations_Examples;

import org.testng.annotations.Test;

public class APITesting017_TestNG_dependsonMethods {
    @Test(dependsOnMethods = "serverOn")
    public void test_method1(){
        System.out.println("Method 1");
    }
    @Test(dependsOnMethods = "serverOn")
    public void test_method2(){
        System.out.println("Method 2");
    }
    @Test
    public void serverOn(){
        System.out.println("Mandatory to execute first before others");
    }
}
