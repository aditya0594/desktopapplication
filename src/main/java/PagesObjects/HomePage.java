package PagesObjects;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;

public class HomePage extends TestBase {

    public void homepage_tile(){
      String titleName = hpSession.findElementByAccessibilityId("TitleBar").getText();
        System.out.println("this the title of HP Scanner :" + titleName);
        Assert.assertEquals("HP WorkScan", titleName);

    }
    public void Maximise_window(){
        hpSession.findElementByAccessibilityId("Maximize-Restore").click();

    }

    public void ExitAppPopUp(){
        String PopUpText = hpSession.findElementByName("Are you sure you want to close this window?").getText();
        Assert.assertEquals("Are you sure you want to close this window?",PopUpText);
        String YesText  =  hpSession.findElementByName("Yes").getText();
        Assert.assertEquals("Yes",YesText);
        hpSession.findElementByName("Yes").click();
       // System.out.println("YES");
    }
    public void Add_Scanner_Device(){

        //String Add_a_new_scanner =hpSession.findElementByName("Add a new scanner").getText();
        //Assert.assertEquals("Add a new scanner",Add_a_new_scanner);
        hpSession.findElementByName("Add a new scanner").click();

    }
    public void choose_connection_mode(){

        String Choose_COnnection_Mode =hpSession.findElementByName("Choose Connection Mode").getText();
        Assert.assertEquals("Choose Connection Mode",Choose_COnnection_Mode);

        String How_Would_you =hpSession.findElementByName("How would you like to connect your scanner?").getText();
        Assert.assertEquals("How would you like to connect your scanner?",How_Would_you);

        String USB =hpSession.findElementByName("USB Connect your scanner using a USB cable").getText();
        Assert.assertEquals("USB",USB);

        String Wired_Connection =hpSession.findElementByName("Wired Connection").getText();
        Assert.assertEquals("Wired Connection",Wired_Connection);

        String Wireless_Connection =hpSession.findElementByName("Wireless Connection").getText();
        Assert.assertEquals("Wired Connection",Wireless_Connection);
    }


    public boolean USB_Connection() throws AWTException, InterruptedException {
        hpSession.findElementByName("Wired Connection").click();
        click(640,263, "USB Option selection");
        if (hpSession.getPageSource().contains("USB Connect your scanner using a USB cable")) {
            System.out.println("Element is not present.");
            return true;
        } else {
            System.out.println("Element is not present.");
            return false;
        }
    }
    public void USB_Connection_Next() throws InterruptedException, AWTException {
        hpSession.findElementByName("Wired Connection").click();
        click(1000, 610, "USB Option selection");
    }
    public boolean Verfiy_USB_Connection() throws AWTException, InterruptedException {

        if (hpSession.getPageSource().contains("USB")) {
            System.out.println("Element is present.");
            return true;
        } else {
            System.out.println("Element is not present.");
            return false;
        }
    }
    public void Addition()
    {
        hpSession.findElementByName("One").click();
        hpSession.findElementByName("Plus").click();
        hpSession.findElementByName("Seven").click();
        hpSession.findElementByName("Equals").click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

}
