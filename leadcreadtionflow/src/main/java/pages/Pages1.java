package pages;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

 
public class Pages1{
    public WebDriver getDriver(){
        return null;
    }
    
    static BaseTest test=new BaseTest();
    public static void clickOn(WebElement element) throws InterruptedException{
       //WebDriverWait w = new WebDriverWait(test.getDriver(),30);
        WebDriverWait wait = new WebDriverWait(test.getDriver(), Duration.ofSeconds(30));
        By loc= toByVal(element);
        wait.until(ExpectedConditions.presenceOfElementLocated(loc));
        // Actions actions = new Actions(test.getDriver());

        // // Click on the search input field.
        // actions.click(element).build().perform();
        element.click();
    }

    public static void setText(WebElement element, String text){
        element.sendKeys(text);   
    }

    public static void selectFromList(WebElement dropdown, WebElement item) throws InterruptedException{
     dropdown.click();
     Thread.sleep(2000);
     item.click();
     Thread.sleep(500);
    }
    public static By toByVal1(WebElement we) {
    // By format = "[foundFrom] -> locator: term"
    // see RemoteWebElement toString() implementation
    String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
    String locator = data[0];
    String term = data[1];

    switch (locator) {
    case "xpath":
        return By.xpath(term);
    case "css selector":
        return By.cssSelector(term);
    case "id":
        return By.id(term);
    case "tag name":
        return By.tagName(term);
    case "name":
        return By.name(term);
    case "link text":
        return By.linkText(term);
    case "class name":
        return By.className(term);
    }
    return (By) we;
}


public static By toByVal(WebElement we) {
    String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
    String locator = data[0];
    String term = data[1];

    switch (locator) {
        case "xpath":
            // Check if the term contains indexing
            if (term.matches(".+\\[\\d+\\]$")) {
                // Extract the index using regular expressions
                Pattern pattern = Pattern.compile("\\[(\\d+)\\]$");
                Matcher matcher = pattern.matcher(term);
                if (matcher.find()) {
                    int lastIndex = Integer.parseInt(matcher.group(1));
                    // Increment the index and update the term
                    String updatedTerm = term.replaceFirst("\\[(\\d+)\\]$", "[" + (lastIndex + 1) + "]");
                    return By.xpath(updatedTerm);
                }
            } else {
                // Add indexing for the first occurrence
                return By.xpath(term + "[1]");
            }
            break;
        case "css selector":
            return By.cssSelector(term);
        case "id":
            return By.id(term);
        case "tag name":
            return By.tagName(term);
        case "name":
            return By.name(term);
        case "link text":
            return By.linkText(term);
        case "class name":
            return By.className(term);
    }
    return (By) we;
}



}
