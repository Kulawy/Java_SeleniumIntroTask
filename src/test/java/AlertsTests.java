import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsTests extends BaseSeleniumTest{

    String buttonId;
    WebElement buttonElement;

    @BeforeMethod
    public void setUpParametrized() {
        chromeDriver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //chromeDriver.switchTo().frame(chromeDriver.findElement(By.tagName("iframe")));
    }

    @Test
    public void simpleAlertTest(){

        buttonId = "datepicker";
        String buttonXpath = "//*[@id='content']/p[4]/button";
        //buttonElement = chromeDriver.findElement(By.id(buttonId));
        buttonElement = chromeDriver.findElement(By.xpath(buttonXpath));
        buttonElement.click();

        Alert simpleAlert = chromeDriver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is " + alertText);
        simpleAlert.accept();

    }

    @Test
    public void confirmationTest(){
        buttonElement = chromeDriver.findElement(By.xpath("//*[@id='content']/p[11]/button"));
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].click()", buttonElement);

        Alert confirmationAlert = chromeDriver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.dismiss();
    }

    @Test
    public void promptAlertTest(){
        buttonElement = chromeDriver.findElement(By.cssSelector("button[onclick='promptConfirm()']"));
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].click()", buttonElement);

        Alert promptAlert  = chromeDriver.switchTo().alert();
        String alertText = promptAlert .getText();
        System.out.println("Alert text is " + alertText);
        //Send some text to the alert
        promptAlert .sendKeys("Accepting the alert");
        try {
            Thread.sleep(4000); //This sleep is not necessary, just for demonstration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        promptAlert .accept();
    }

}