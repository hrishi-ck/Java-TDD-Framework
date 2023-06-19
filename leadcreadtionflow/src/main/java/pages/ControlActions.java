package pages;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import base.BaseTest;
import io.netty.handler.timeout.TimeoutException;

 
public class ControlActions{
    public WebDriver getDriver(){
        return null;
    }
   
    static BaseTest test=new BaseTest();

    public void clickOn(By loc) throws InterruptedException{
        try {
        WebDriverWait wait = new WebDriverWait(test.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
        Actions actions = new Actions(test.getDriver());
        actions.click(test.getDriver().findElement(loc)).build().perform();
        } catch (NoSuchElementException e) {
        System.out.println("Element not found");
        } catch (TimeoutException e) {
        System.out.println("Timeout waiting for element");
        }      

    }
   
    public void setText(By loc, String text){
        WebDriverWait wait = new WebDriverWait(test.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
        test.getDriver().findElement(loc).clear(); //clear text
        test.getDriver().findElement(loc).sendKeys(text); 
    }
  
    public void selectFromList(WebElement dropdown, WebElement item) throws InterruptedException{
     dropdown.click();
     Thread.sleep(2000);
     item.click();
     Thread.sleep(500);
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)test.getDriver() ;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getSessionId(){
        return ((RemoteWebDriver)test.getDriver() ).getSessionId().toString();
    }
    
    public static void waitForElementToBeClickable(By loc){
    WebDriverWait wait = new WebDriverWait(test.getDriver(), Duration.ofSeconds(30));
      wait.until(ExpectedConditions.elementToBeClickable(loc));
    }

    public static void waitForElementToBe(By loc,String action) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException{
    WebDriverWait wait = new WebDriverWait(test.getDriver(), Duration.ofSeconds(30));
    Class<?> expectedConditionsClass = ExpectedConditions.class;
    String methodName = "elementToBe"+action;
    Method method = expectedConditionsClass.getMethod(methodName, By.class);
    WebElement element = (WebElement) method.invoke(wait, loc);
    // wait.until(ExpectedConditions.elementToBeClickable(loc));
    if (action.equalsIgnoreCase("click")) {
        element.click();
    } else if (action.equalsIgnoreCase("sendKeys")) {
        element.sendKeys("Some text");
    } else {
        // Add more conditions for other actions as needed
    }
    }
    public static void switchToFrameByWebElement(WebElement frameElement) {
    test.getDriver().switchTo().frame(frameElement);
    }

}

//     public static By toByVal1(WebElement we) {
//     // By format = "[foundFrom] -> locator: term"
//     // see RemoteWebElement toString() implementation
//     String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
//     String locator = data[0];
//     String term=data[1];
//     // data[1].charAt(data[1].length()-1)==']' &&
//     if( Character.isDigit(data[1].charAt(data[1].length()-1)))
//     term = term+"]";


//     switch (locator) {
//     case "xpath":
//         return By.xpath(term);
//     case "css selector":
//         return By.cssSelector(term);
//     case "id":
//         return By.id(term);
//     case "tag name":
//         return By.tagName(term);
//     case "name":
//         return By.name(term);
//     case "link text":
//         return By.linkText(term);
//     case "class name":
//         return By.className(term);
//     }
//     return (By) we;
// }
 
    
    


