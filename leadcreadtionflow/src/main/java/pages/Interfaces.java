package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Interfaces {
    void clickOn(By loc) throws InterruptedException;
    void setText(By loc, String text);
    void selectFromList(WebElement dropdown, WebElement item) throws InterruptedException;
}
