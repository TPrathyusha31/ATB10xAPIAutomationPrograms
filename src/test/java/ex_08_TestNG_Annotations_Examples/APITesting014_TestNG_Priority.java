package ex_08_TestNG_Annotations_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting014_TestNG_Priority {
    @Test(priority = 1)
        public void test01(){
        System.out.println("Two");
    }
    @Test(priority = 2)
    public void test02(){
        System.out.println("Three");
    }
   @Test //if no priority is set, then default will be 0 and this method will only run first as 0 comes first then 1 and 2.
    public  void test03(){
       System.out.println("One");
   }
}
