package pages.implementation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import io.netty.handler.timeout.TimeoutException;
import pages.interfaces.Clickable;

public class ClickOn implements Clickable {

    static BaseTest test=new BaseTest();
     @Override
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
    
}
