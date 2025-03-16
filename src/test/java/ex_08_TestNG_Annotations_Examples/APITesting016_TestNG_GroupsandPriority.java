package ex_08_TestNG_Annotations_Examples;

import org.testng.annotations.Test;

public class APITesting016_TestNG_GroupsandPriority {
    @Test(groups = {"sanity","P1"},priority = 2)
    public void testcase01(){
        System.out.println("Sanity and P1 case");
    }
    @Test(groups={"regression","P1"},priority = -1)
    public  void testcase02(){
        System.out.println("Regression and P1 case");
    }
    @Test(groups = {"sanity"})
    public void testcase03(){
        System.out.println("sanity case");
    }
}

