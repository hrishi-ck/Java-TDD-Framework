package base;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Assertion extends BaseTest {

    public void softAssert(WebElement element,String expected){
    SoftAssert softassert = new SoftAssert();
    String actualResult=element.getText();

     softassert.assertEquals(actualResult,expected);
     softassert.assertAll();
    }
    
}
