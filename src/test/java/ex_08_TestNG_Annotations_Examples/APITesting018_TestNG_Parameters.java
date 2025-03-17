package ex_08_TestNG_Annotations_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting018_TestNG_Parameters {
    @Parameters("Browser")
    @Test
    public void invokeBrowser(String value){
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Invoke chrome browser");
        } else if (value.equalsIgnoreCase("Firefox")) {
            System.out.println("Invoke firefox browser");
        }

    }
}
