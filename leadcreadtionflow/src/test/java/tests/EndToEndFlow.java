package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import base.StandardModal;
import pages.Pages1;
import structure.LeadDetails;
import base.Assertion;

public class EndToEndFlow extends BaseTest {

    @Test
    public void leadCreation() throws InterruptedException {
        LeadDetails data = new LeadDetails();
        Pages1.clickOn(driver.findElement(By.cssSelector(".slds-icon-waffle")));
       
        Pages1.setText(driver.findElement(By.xpath("//label[text()=\"Search apps and items...\"]/..//input")), "sales");
        Pages1.clickOn(driver.findElement(By.xpath("(//b[text()='Sales'])[3]")));
        Pages1.clickOn(driver.findElement(By.xpath(
               "(//span[@class=\"slds-truncate\" and text()=\"Leads\"]/..//following-sibling::one-app-nav-bar-item-dropdown//lightning-primitive-icon)[1]")));

        Pages1.clickOn(driver.findElement(By.xpath("//span[text()=\"New Lead\"]/..//lightning-icon//span")));
        // Thread.sleep(10000);
        data.setFirstName("Pavitra");
        data.setLastName("Prabhakar");
        data.setCompanyName("Spiderverse");
        data.setPhoneNumber("3296574765");
        data.setEmail("pavitraprabhakar@yopmail.com");
        // Pages1.setText(driver.findElement(By.xpath("//input[@name=\"firstName\"]")), data.getFirstName());
        Pages1.setText(StandardModal.getLeadElement("firstName"), data.getFirstName());
        Pages1.setText(StandardModal.getLeadElement("lastName"), data.getLastName());
        Pages1.setText(StandardModal.getLeadElement("Company"), data.getCompanyName());
        Pages1.setText(StandardModal.getLeadElement("Phone"), data.getPhoneNumber());
        Pages1.setText(StandardModal.getLeadElement("Email"), data.getEmail());
        Pages1.clickOn(StandardModal.getButtonElement("SaveEdit"));
        Thread.sleep(3000);
        Pages1.clickOn(driver.findElement(By.xpath("//a[@data-tab-value='detailTab']")));



        Assertion softassert = new Assertion();
        String asserttext = data.getFirstName() + " " + data.getLastName();
        softassert.softAssert(driver.findElement(By.xpath("//lightning-formatted-name[@slot=\"outputField\"]")),asserttext);

        Thread.sleep(2000);

    }

}
