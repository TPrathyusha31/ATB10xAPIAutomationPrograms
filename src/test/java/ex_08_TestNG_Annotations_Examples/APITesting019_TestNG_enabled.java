package ex_08_TestNG_Annotations_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting019_TestNG_enabled {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test02(){
        Assert.assertTrue(true);
    }
}
