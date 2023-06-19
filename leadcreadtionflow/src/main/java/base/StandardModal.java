package base;

import org.openqa.selenium.By;

public class StandardModal extends BaseTest {
      public static By getLeadElement(String name){
       return By.xpath("//input[@name='"+name+"']");
      }

      public static By getButtonElement(String name){
       return By.xpath("//button[@name='"+name+"']");
      }
        
}
