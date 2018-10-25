package pl.sii.jgeron;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class SwitchTests extends BaseSeleniumTest{


    @BeforeMethod
    public void setUpSpec(){
        chromeDriver.get("http://toolsqa.com/automation-practice-switch-windows/");
    }

    @Test
    public void firstExTest(){
        WebElement clickElement =chromeDriver.findElement(By.id("button1"));
        String parentWindowHandle = chromeDriver.getWindowHandle();

        for(int i = 0; i < 2; i++)
        {
            clickElement.click();
            mySleep(3000);
        }

        Set<String> allWindowHandles = chromeDriver.getWindowHandles();

        int flag = 0;
        for(String handle : allWindowHandles)
        {
            if ( flag != 0){
                chromeDriver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
                chromeDriver.close();
            }
            flag ++;
        }

        chromeDriver.switchTo().window(parentWindowHandle);

        Actions action = new Actions(chromeDriver);
        WebElement clickElement2 =chromeDriver.findElement(By.id("doubleClick"));
        action.doubleClick(clickElement2).perform();
        mySleep(2000);
        String colorOrange = "color: orange;";
        Assert.assertEquals( clickElement2.getAttribute("style"), colorOrange);

    }

    @Test
    public void secondExTest(){
        WebElement clickElement =chromeDriver.findElement(By.cssSelector("button[onclick='newMsgWin()']"));
        String parentWindowHandle = chromeDriver.getWindowHandle();
        clickElement.click();
        String windowWithStringHandle = chromeDriver.getWindowHandle();

        for(String winHandle : chromeDriver.getWindowHandles()){
            chromeDriver.switchTo().window(winHandle);
        }

        WebElement bodyElem = chromeDriver.findElement(By.cssSelector("body"));
        String textFromBody = bodyElem.getText();
        System.out.println(textFromBody);
        chromeDriver.close();
        chromeDriver.switchTo().window(parentWindowHandle);

        Actions action = new Actions(chromeDriver);
        WebElement clickElement2 =chromeDriver.findElement(By.id("doubleClick"));
        action.doubleClick(clickElement2).perform();
        mySleep(3000);
        String colorOrange = "color: orange;";
        String textThatShuoldBePrinted = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

        Assert.assertEquals(textFromBody, textThatShuoldBePrinted);
        Assert.assertEquals( clickElement2.getAttribute("style"), colorOrange);
    }

    @Test
    public void thirdExTest(){

        String openInNewTabSelected = Keys.chord(Keys.CONTROL, Keys.RETURN);
        //chromeDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");  // otwarcie nowej karty
        //chromeDriver.findElement(By.cssSelector("")).sendKeys(openInNewTabSelected); // otwarcie zaznaczonego linku w nowej karcie
        String parentWindowHandle = chromeDriver.getWindowHandle();

        WebElement clickElement =chromeDriver.findElement(By.cssSelector("button[onclick='newBrwTab()']"));
        clickElement.click();

        ArrayList<String> tabs = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(tabs.get(1));

        mySleep(3000);

        chromeDriver.findElement(By.cssSelector("img[alt='Selenium Tutorial in Java']")).click();

        mySleep( 3000);
        String newUrl = chromeDriver.getCurrentUrl();
        String urlToCheck = "http://toolsqa.com/selenium-tutorial/";
        chromeDriver.close();
        chromeDriver.switchTo().window(parentWindowHandle);
        mySleep(300);

        Actions action = new Actions(chromeDriver);
        WebElement clickElement2 =chromeDriver.findElement(By.id("doubleClick"));
        action.doubleClick(clickElement2).perform();
        mySleep(3000);
        String colorOrange = "color: orange;";

        Assert.assertEquals(newUrl, urlToCheck);
        Assert.assertEquals( clickElement2.getAttribute("style"), colorOrange);

    }





}
