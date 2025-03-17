package ex_08_TestNG_Annotations_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting020_TestNG_AlwaysRun {
    @Test(alwaysRun = true)
    public void test01() {
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true, enabled = false)
    public void test02() {
        Assert.assertTrue(true);
    }
}
