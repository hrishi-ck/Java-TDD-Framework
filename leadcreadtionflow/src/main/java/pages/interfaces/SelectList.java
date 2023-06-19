package pages.interfaces;

import org.openqa.selenium.WebElement;

public interface SelectList {
    void selectFromList (WebElement dropdown, WebElement item) throws InterruptedException;
    void selectComboBoxItem(WebElement comboboxIcon, WebElement searchBar, WebElement item, String text) throws InterruptedException;
}
