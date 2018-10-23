import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrameTests extends BaseSeleniumTest{


    @BeforeMethod
    public void setUpSpec(){
        chromeDriver.get("http://toolsqa.com/iframe-practice-page/");
        chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mySleep(2000);

    }

    @Test
    public void mainIFrameTest(){

        chromeDriver.switchTo().frame("IF1");
        chromeDriver.findElement(By.cssSelector("button[name='submit']")).click();
        mySleep(3000);

        chromeDriver.switchTo().defaultContent();
        WebElement frame2 = chromeDriver.findElement(By.cssSelector("iframe[name='iframe2']"));
        chromeDriver.switchTo().frame(frame2);
        chromeDriver.findElement(By.cssSelector("p.visible-xs a[rel='bookmark']")).click();
        mySleep(3000);

        chromeDriver.switchTo().defaultContent();
        mySleep(1000);
        ((JavascriptExecutor)chromeDriver).executeScript("window.scrollTo(0, 0)");
        mySleep(1000);
        chromeDriver.findElement(By.cssSelector("li.menu-item a[href='http://toolsqa.com/']  span[class='menu-text']")).click();
        //chromeDriver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[1]/a/span[1]/span/span")).click();
        mySleep(3000);

        Assert.assertEquals(chromeDriver.switchTo().defaultContent().getCurrentUrl(), "http://toolsqa.com/");
    }

    @Test
    public void frameFirstTest(){
        chromeDriver.switchTo().frame("IF1");
        chromeDriver.findElement(By.cssSelector("button[name='submit']")).click();


    }

    @Test
    public void frameSecondTest(){
        WebElement frame2 = chromeDriver.findElement(By.cssSelector("iframe[name='iframe2']"));
        chromeDriver.switchTo().frame(frame2);
        chromeDriver.findElement(By.cssSelector("p.visible-xs a[rel='bookmark']")).click();

    }

    @Test
    public void frameThirdTest(){
        chromeDriver.switchTo().defaultContent();
        chromeDriver.findElement(By.cssSelector("li.menu-item a[href='http://toolsqa.com/']  span[class='menu-text']")).click();
        mySleep(3000);

        Assert.assertEquals(chromeDriver.switchTo().defaultContent().getCurrentUrl(), "http://toolsqa.com/");
    }


}
