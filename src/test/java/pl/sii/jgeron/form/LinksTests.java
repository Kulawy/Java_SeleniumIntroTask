package pl.sii.jgeron.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sii.jgeron.BaseSeleniumTest;

public class LinksTests extends BaseSeleniumTest {

    @BeforeMethod
    public void setUpSpec(){
        chromeDriver.get("http://toolsqa.com/automation-practice-form/");
    }

    @Test
    public void firstLinkClickUrlTest(){
        String pathShouldBe = "http://toolsqa.com/automation-practice-form/";
        WebElement titleHref = chromeDriver.findElement(By.cssSelector("a[title='Automation Practice pl.aaaaa.form']"));
        titleHref.click();
        String newPath = chromeDriver.getCurrentUrl();
        Assert.assertEquals(newPath, pathShouldBe );
    }

    @Test
    public void  secondLinkClickUrlTest(){
        String pathShouldBe = "http://toolsqa.com/automation-practice-table/";
        WebElement titleHref = chromeDriver.findElement(By.cssSelector("a[title='Automation Practice pl.aaaaa.table']"));
        titleHref.click();
        String newPath = chromeDriver.getCurrentUrl();
        Assert.assertEquals(newPath, pathShouldBe );
    }



}
