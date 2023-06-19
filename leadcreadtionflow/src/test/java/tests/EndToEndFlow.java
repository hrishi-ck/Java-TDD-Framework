package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import base.StandardModal;
import pages.ControlActions;
import pages.implementation.ClickOn;
import pages.implementation.SetText;
import pages.interfaces.Clickable;
import pages.interfaces.TextField;
import structure.LeadDetails;
import base.Assertion;

public class EndToEndFlow extends BaseTest {

    @Test
    public void leadCreation() throws InterruptedException {
        LeadDetails data = new LeadDetails();
        Clickable click = new ClickOn();
        TextField set =new SetText();
        //Interfaces i=new ControlActions();
        click.clickOn(By.cssSelector(".slds-icon-waffle"));
       
        set.setText(By.xpath("//label[text()=\"Search apps and items...\"]/..//input"), "sales");
        click.clickOn(By.xpath("(//b[text()='Sales'])[3]"));
        click.clickOn(By.xpath(
               "(//span[@class=\"slds-truncate\" and text()=\"Leads\"]/..//following-sibling::one-app-nav-bar-item-dropdown//lightning-primitive-icon)[1]"));

        click.clickOn(By.xpath("//span[text()=\"New Lead\"]/..//lightning-icon//span"));
        // Thread.sleep(10000);
        data.setFirstName("Pavitra");
        data.setLastName("Prabhakar");
        data.setCompanyName("Spiderverse");
        data.setPhoneNumber("3296574765");
        data.setEmail("pavitraprabhakar@yopmail.com");
        // set.setText(driver.findElement(By.xpath("//input[@name=\"firstName\"]")), data.getFirstName());
        set.setText(StandardModal.getLeadElement("firstName"), data.getFirstName());
        set.setText(StandardModal.getLeadElement("lastName"), data.getLastName());
        set.setText(StandardModal.getLeadElement("Company"), data.getCompanyName());
        set.setText(StandardModal.getLeadElement("Phone"), data.getPhoneNumber());
        set.setText(StandardModal.getLeadElement("Email"), data.getEmail());
        click.clickOn(StandardModal.getButtonElement("SaveEdit"));
        // Thread.sleep(3000);
        click.clickOn(By.xpath("//a[@data-tab-value='detailTab']"));



        Assertion softassert = new Assertion();
        String asserttext = data.getFirstName() + " " + data.getLastName();
        softassert.softAssert(driver.findElement(By.xpath("//lightning-formatted-name[@slot=\"outputField\"]")),asserttext);

        Thread.sleep(2000);

    }

}
