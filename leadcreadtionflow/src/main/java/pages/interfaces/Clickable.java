package pages.interfaces;

import org.openqa.selenium.By;

public interface Clickable {
    void clickOn(By loc) throws InterruptedException;
}
