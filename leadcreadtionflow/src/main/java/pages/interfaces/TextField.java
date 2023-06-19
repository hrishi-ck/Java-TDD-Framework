package pages.interfaces;

import org.openqa.selenium.By;

public interface TextField {
   void setText(By loc, String text); 
   void clearText(By loc);
}
