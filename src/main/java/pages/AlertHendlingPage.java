package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.base.BasePage;
import pages.base.MainMenuPage;

import java.util.Arrays;
import java.util.List;

public class AlertHendlingPage extends BasePage {

    String simpleAlertText;
    String confirmAlertText;
    String promptAlertText;

    public AlertHendlingPage(WebDriver driver, MainMenuPage main) {
        super(driver);
        _main = main;
        PageFactory.initElements(_driver, this);
        List<WebElement> elements = Arrays.asList(elementSimpleAllertButton, elementConfirmationAllertButton, elementPromptAllertButton);
        waitForElements(elements);
    }

    @FindBy( css = "button[onclick='pushAlert()']")
    private WebElement elementSimpleAllertButton;

    @FindBy( css = "button[onclick='pushConfirm()']")
    private WebElement elementConfirmationAllertButton;

    @FindBy( css = "button[onclick='promptConfirm()']")
    private WebElement elementPromptAllertButton;



    public AlertHendlingPage simpleAlertInvoke(){
        clickElement(elementSimpleAllertButton);
        Alert simpleAlert = _driver.switchTo().alert();
        simpleAlertText = simpleAlert.getText();
        simpleAlert.accept();
        return this;
    }

    public AlertHendlingPage confirmAlertInvoke(){

        ((JavascriptExecutor) _driver).executeScript("arguments[0].click()", elementConfirmationAllertButton);
        //clickElement(elementConfirmationAllertButton);
        Alert confirmAlert = _driver.switchTo().alert();
        confirmAlertText = confirmAlert.getText();
        confirmAlert.dismiss();
        return this;
    }

    public AlertHendlingPage promptAlertInvoke(){

        ((JavascriptExecutor) _driver).executeScript("arguments[0].click()", elementPromptAllertButton);
        //clickElement(elementPromptAllertButton);
        Alert promptAlert = _driver.switchTo().alert();
        promptAlertText = promptAlert.getText();
        promptAlert .sendKeys("Yes");
        //waitUntilClickable(elementPromptAllertButton);
        promptAlert.accept();
        return this;
    }


    public AlertHendlingPage verifySimpleAlert(){
        Assert.assertEquals( simpleAlertText, "A simple Alert");
        return this;
    }

    public AlertHendlingPage verifyConfirmAlert(){
        Assert.assertEquals( confirmAlertText, "Confirm pop up with OK and Cancel button");
        return this;
    }

    public AlertHendlingPage verifyPromptAlert(){
        Assert.assertEquals( promptAlertText, "Do you like toolsqa?");
        return this;
    }



}
