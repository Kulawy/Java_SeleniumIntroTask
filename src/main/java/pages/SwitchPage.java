package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;
import pages.base.MainMenuPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SwitchPage extends BasePage {

    public SwitchPage(WebDriver driver, MainMenuPage main) {
        super(driver);
        _main = main;
        PageFactory.initElements(_driver, this);
        List<WebElement> elements = Arrays.asList(elementButtonOne, elementDoubleClick);
        waitForElements(elements);
        _actionsBuilder = new Actions(_driver);
    }

    @FindBy( id = "button1")
    private  WebElement elementButtonOne;

    @FindBy( id = "doubleClick")
    private  WebElement elementDoubleClick;

    @FindBy( css = "button[onclick='newMsgWin()']")
    private  WebElement elementNewMsg;

    @FindBy( css = "body")
    private  WebElement elementBody;

    @FindBy( css = "img[alt='Selenium Tutorial in Java']")
    private WebElement elementImage;

    @FindBy( css = "button[onclick='newBrwTab()']")
    private WebElement elementNewBrwTab;

    public SwitchPage firstPreparation(){
        String parentWindowHandle = _driver.getWindowHandle();
        for(int i = 0; i < 2; i++)
        {
            clickElement(elementButtonOne);
        }

        Set<String> allWindowHandles = _driver.getWindowHandles();
        int flag = 0;
        for(String handle : allWindowHandles)
        {
            if ( flag != 0){
                _driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
                _driver.close();
            }
            flag ++;
        }
        _driver.switchTo().window(parentWindowHandle);
        return this;
    }

    public SwitchPage secondPreparation(){

        String parentWindowHandle = _driver.getWindowHandle();
        elementNewMsg.click();

        for(String winHandle : _driver.getWindowHandles()){
            _driver.switchTo().window(winHandle);
        }

        String textFromBody =elementBody.getText();
        System.out.println(textFromBody);
        _driver.close();
        _driver.switchTo().window(parentWindowHandle);
        return this;
    }

    public SwitchPage thirdPreparation(){

        String parentWindowHandle = _driver.getWindowHandle();
        clickElement(elementNewBrwTab);

        ArrayList<String> tabs = new ArrayList<String>(_driver.getWindowHandles());
        _driver.switchTo().window(tabs.get(1));

        clickElement(elementImage);

        String newUrl = _driver.getCurrentUrl();
        String urlToCheck = "http://toolsqa.com/selenium-tutorial/";
        _driver.close();
        _driver.switchTo().window(parentWindowHandle);
        return this;
    }



    public SwitchPage afterStuff(){
        _actionsBuilder.doubleClick(elementDoubleClick).perform();
        String colorOrange = "color: orange;";
        Assert.assertEquals( elementDoubleClick.getAttribute("style"), colorOrange);
        return this;
    }

    public void waitForColorOrange(){
        String colorOrange = "color: orange;";
        WebDriverWait wait = new WebDriverWait(_driver, 6);
        wait.until(ExpectedConditions.attributeToBe(elementDoubleClick, "style", colorOrange));
    }




}
