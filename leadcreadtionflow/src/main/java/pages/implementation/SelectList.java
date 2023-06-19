package pages.implementation;

import org.openqa.selenium.WebElement;

import base.BaseTest;

public class SelectList implements pages.interfaces.SelectList {
    static BaseTest test=new BaseTest();
    @Override
    public void selectFromList(WebElement dropdown, WebElement item){
     dropdown.click();
     try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     item.click();
     try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
