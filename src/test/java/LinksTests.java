import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends BaseSeleniumTest{

    @Test
    public void firstLinkClickUrlTest(){
        String pathShouldBe = "http://toolsqa.com/automation-practice-form/";
        WebElement titleHref = chromeDriver.findElement(By.cssSelector("a[title='Automation Practice Form']"));
        titleHref.click();
        String newPath = chromeDriver.getCurrentUrl();
        Assert.assertEquals(newPath, pathShouldBe );
    }

    @Test
    public void  secondLinkClickUrlTest(){
        String pathShouldBe = "http://toolsqa.com/automation-practice-table/";
        WebElement titleHref = chromeDriver.findElement(By.cssSelector("a[title='Automation Practice Table']"));
        titleHref.click();
        String newPath = chromeDriver.getCurrentUrl();
        Assert.assertEquals(newPath, pathShouldBe );
    }



}
