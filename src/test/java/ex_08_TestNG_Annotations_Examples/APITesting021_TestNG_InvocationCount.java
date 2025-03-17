package ex_08_TestNG_Annotations_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_TestNG_InvocationCount {

    @Test(invocationCount = 10)
    public void test01(){
        System.out.println("Count");
        Assert.assertTrue(true);
    }

}
