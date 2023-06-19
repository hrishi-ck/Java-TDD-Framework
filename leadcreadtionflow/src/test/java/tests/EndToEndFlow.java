package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import base.StandardModal;
import pages.ControlActions;
import pages.Interfaces;
import structure.LeadDetails;
import base.Assertion;

public class EndToEndFlow extends BaseTest {

    @Test
    public void leadCreation() throws InterruptedException {
        LeadDetails data = new LeadDetails();
        Interfaces i=new ControlActions();
        i.clickOn(By.cssSelector(".slds-icon-waffle"));
       
        i.setText(By.xpath("//label[text()=\"Search apps and items...\"]/..//input"), "sales");
        i.clickOn(By.xpath("(//b[text()='Sales'])[3]"));
        i.clickOn(By.xpath(
               "(//span[@class=\"slds-truncate\" and text()=\"Leads\"]/..//following-sibling::one-app-nav-bar-item-dropdown//lightning-primitive-icon)[1]"));

        i.clickOn(By.xpath("//span[text()=\"New Lead\"]/..//lightning-icon//span"));
        // Thread.sleep(10000);
        data.setFirstName("Pavitra");
        data.setLastName("Prabhakar");
        data.setCompanyName("Spiderverse");
        data.setPhoneNumber("3296574765");
        data.setEmail("pavitraprabhakar@yopmail.com");
        // i.setText(driver.findElement(By.xpath("//input[@name=\"firstName\"]")), data.getFirstName());
        i.setText(StandardModal.getLeadElement("firstName"), data.getFirstName());
        i.setText(StandardModal.getLeadElement("lastName"), data.getLastName());
        i.setText(StandardModal.getLeadElement("Company"), data.getCompanyName());
        i.setText(StandardModal.getLeadElement("Phone"), data.getPhoneNumber());
        i.setText(StandardModal.getLeadElement("Email"), data.getEmail());
        i.clickOn(StandardModal.getButtonElement("SaveEdit"));
        // Thread.sleep(3000);
        i.clickOn(By.xpath("//a[@data-tab-value='detailTab']"));



        Assertion softassert = new Assertion();
        String asserttext = data.getFirstName() + " " + data.getLastName();
        softassert.softAssert(driver.findElement(By.xpath("//lightning-formatted-name[@slot=\"outputField\"]")),asserttext);

        Thread.sleep(2000);

    }

}
