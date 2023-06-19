package pages.implementation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pages.interfaces.TextField;

public class SetText implements TextField {
    static BaseTest test=new BaseTest();
    @Override
    public void setText(By loc, String text){
        WebDriverWait wait = new WebDriverWait(test.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
        test.getDriver().findElement(loc).clear(); //clear text
        test.getDriver().findElement(loc).sendKeys(text); 
    }
    @Override
    public void clearText(By loc){
        test.getDriver().findElement(loc).clear(); //clear text
    }
}
