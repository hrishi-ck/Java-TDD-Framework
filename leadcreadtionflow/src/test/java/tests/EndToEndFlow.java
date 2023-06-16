package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import base.StandardModal;
import pages.ControlActions;
import structure.LeadDetails;
import base.Assertion;

public class EndToEndFlow extends BaseTest {

    @Test
    public void leadCreation() throws InterruptedException {
        LeadDetails data = new LeadDetails();
        ControlActions.clickOn(By.cssSelector(".slds-icon-waffle"));
       
        ControlActions.setText(driver.findElement(By.xpath("//label[text()=\"Search apps and items...\"]/..//input")), "sales");
        ControlActions.clickOn(By.xpath("(//b[text()='Sales'])[3]"));
        ControlActions.clickOn(By.xpath(
               "(//span[@class=\"slds-truncate\" and text()=\"Leads\"]/..//following-sibling::one-app-nav-bar-item-dropdown//lightning-primitive-icon)[1]"));

        ControlActions.clickOn(By.xpath("//span[text()=\"New Lead\"]/..//lightning-icon//span"));
        // Thread.sleep(10000);
        data.setFirstName("Pavitra");
        data.setLastName("Prabhakar");
        data.setCompanyName("Spiderverse");
        data.setPhoneNumber("3296574765");
        data.setEmail("pavitraprabhakar@yopmail.com");
        // ControlActions.setText(driver.findElement(By.xpath("//input[@name=\"firstName\"]")), data.getFirstName());
        ControlActions.setText(StandardModal.getLeadElement("firstName"), data.getFirstName());
        ControlActions.setText(StandardModal.getLeadElement("lastName"), data.getLastName());
        ControlActions.setText(StandardModal.getLeadElement("Company"), data.getCompanyName());
        ControlActions.setText(StandardModal.getLeadElement("Phone"), data.getPhoneNumber());
        ControlActions.setText(StandardModal.getLeadElement("Email"), data.getEmail());
        ControlActions.clickOn(StandardModal.getButtonElement("SaveEdit"));
        // Thread.sleep(3000);
        ControlActions.clickOn(By.xpath("//a[@data-tab-value='detailTab']"));



        Assertion softassert = new Assertion();
        String asserttext = data.getFirstName() + " " + data.getLastName();
        softassert.softAssert(driver.findElement(By.xpath("//lightning-formatted-name[@slot=\"outputField\"]")),asserttext);

        Thread.sleep(2000);

    }

}
