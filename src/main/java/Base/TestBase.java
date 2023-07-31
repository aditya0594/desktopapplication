package Base;

import cucumber.api.java.Before;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

      public static WindowsDriver hpSession = null;
     static WebElement CalculatorResult = null;

    @BeforeMethod
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app","C:\\Program Files\\HP WorkScan\\ScannerApp\\hp_workscan.exe");  ///"Microsoft.WindowsCalculator_8wekyb3d8bbwe!App""Microsoft.WindowsCalculator_8wekyb3d8bbwe!App"
            hpSession = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capabilities); //"C:\\Program Files\\HP WorkScan\\ScannerApp\\Main.exe"
            hpSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            CalculatorResult = hpSession.findElementByAccessibilityId("TitleBar");
            Assert.assertNotNull(CalculatorResult);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    @Before
    public void Clear()
    {
        hpSession.findElementByName("Clear").click();
        Assert.assertEquals("0", _GetCalculatorResultText());
    }
    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult.getText().replace("Display is", "").trim();
    }

    @AfterMethod
    public static void TearDown()
    {
        CalculatorResult = null;
        if (hpSession != null) {
          //  hpSession.quit();
        }
        hpSession = null;
    }

    public static By waitForElement(By element) {
        WebDriverWait w = new WebDriverWait(hpSession,3);
        w.until(ExpectedConditions.presenceOfElementLocated ((By) element));
        return element;
    }

    public static void click(int screenX, int screenY,String nameClick ) throws InterruptedException, AWTException {
        Robot robot = new Robot();
// Set the desired coordinates to click on
        // int screenX = 400; // X-coordinate
        // int screenY = 225; // Y-coordinate
// Move the mouse cursor to the specified coordinates
        robot.mouseMove(screenX, screenY);
// Simulate a mouse click at the current cursor position
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("Click event name : "+ nameClick);
    }

}
