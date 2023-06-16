package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StandardModal extends BaseTest {
      public static WebElement getLeadElement(String name){
       return driver.findElement(By.xpath("//input[@name='"+name+"']"));
      }

      public static WebElement getButtonElement(String name){
       return driver.findElement(By.xpath("//button[@name='"+name+"']"));
      }
      

    
}
