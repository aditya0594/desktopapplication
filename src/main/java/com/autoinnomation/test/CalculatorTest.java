package com.autoinnomation.test;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends TestBase {

@Test
    public void Addition()
    {
        hpSession.findElementByName("One").click();
        hpSession.findElementByName("Plus").click();
        hpSession.findElementByName("Seven").click();
        hpSession.findElementByName("Equals").click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }


    @Test
    public void Combination()
    {
        hpSession.findElementByName("Seven").click();
        hpSession.findElementByName("Multiply by").click();
        hpSession.findElementByName("Nine").click();
        hpSession.findElementByName("Plus").click();
        hpSession.findElementByName("One").click();
        hpSession.findElementByName("Equals").click();
        hpSession.findElementByName("Divide by").click();
        hpSession.findElementByName("Eight").click();
        hpSession.findElementByName("Equals").click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

    @Test
    public void Division()
    {
        hpSession.findElementByName("Eight").click();
        hpSession.findElementByName("Eight").click();
        hpSession.findElementByName("Divide by").click();
        hpSession.findElementByName("One").click();
        hpSession.findElementByName("One").click();
        hpSession.findElementByName("Equals").click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

    @Test
    public void Multiplication()
    {
        hpSession.findElementByName("Nine").click();
        hpSession.findElementByName("Multiply by").click();
        hpSession.findElementByName("Nine").click();
        hpSession.findElementByName("Equals").click();
        Assert.assertEquals("81", _GetCalculatorResultText());
    }

    @Test
    public void Subtraction()
    {
        hpSession.findElementByName("Nine").click();
        hpSession.findElementByName("Minus").click();
        hpSession.findElementByName("One").click();
        hpSession.findElementByName("Equals").click();
        Assert.assertEquals("8", _GetCalculatorResultText());
    }


}
