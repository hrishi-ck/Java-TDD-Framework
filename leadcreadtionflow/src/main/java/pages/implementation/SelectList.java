package pages.implementation;

import org.openqa.selenium.WebElement;

import base.BaseTest;

public class SelectList implements pages.interfaces.SelectList {
    static BaseTest test=new BaseTest();
    @Override
    public void selectFromList(WebElement dropdown, WebElement item) throws InterruptedException{
        dropdown.click();
        Thread.sleep(2000);
        item.click();
        Thread.sleep(500);
    }
    @Override
    public void selectComboBoxItem(WebElement comboboxIcon, WebElement searchBar, WebElement item, String text) throws InterruptedException{
        comboboxIcon.click();
        Thread.sleep(5000);
        searchBar.sendKeys(text);
        item.click();
        Thread.sleep(500);
    }
}
