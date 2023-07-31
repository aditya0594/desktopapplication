package Testcases;

import Base.TestBase;
import PagesObjects.HomePage;
import org.testng.annotations.Test;

import java.awt.*;

public class HomaePageTest extends TestBase {
    static HomePage homePage = new HomePage();

    @Test()
    public void Homapagevalid(){
        homePage.homepage_tile();
        homePage.Maximise_window();
    }

    @Test
    public static void Add_Scanner() throws InterruptedException, AWTException {
        homePage.homepage_tile();
        homePage.Maximise_window();
        Thread.sleep(3000);
        homePage.Add_Scanner_Device();
        //homePage.choose_connection_mode();
        homePage.Verfiy_USB_Connection();
        homePage.USB_Connection();
        homePage.USB_Connection_Next();




    }

}
