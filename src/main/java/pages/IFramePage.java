package pages;

import org.openqa.selenium.JavascriptExecutor;
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

import java.util.Arrays;
import java.util.List;

public class IFramePage extends BasePage {

    MainMenuPage _main;

    public IFramePage(WebDriver driver, MainMenuPage main) {
        super(driver);
        _main = main;
        PageFactory.initElements(_driver, this);
        List<WebElement> elements = Arrays.asList(frameOne, frameTwo);
        waitForElements(elements);
    }

    @FindBy( id = "IF1")
    private WebElement frameOne;
    @FindBy( css = "iframe[name='iframe2']")
    private WebElement frameTwo;
    @FindBy ( css = "button[name='submit']")
    private WebElement submitInFrameOne;
    @FindBy ( css = "p.visible-xs a[rel='bookmark']" )
    private WebElement bookmarkInFrameTwo;
    @FindBy ( css = "li.menu-item-home a[class='ripple']" )
    private WebElement homeMainMenu;

    public IFramePage firstCaseStep(){
        _driver.switchTo().frame(frameOne);
        clickElement(submitInFrameOne);
        _driver.switchTo().defaultContent();
        return this;
    }

    public IFramePage secondCaseStep(){
        _driver.switchTo().frame(frameTwo);
        clickElement(bookmarkInFrameTwo);
        _driver.switchTo().defaultContent();
        return this;
    }

    public IFramePage thirdCaseStep(){
        //_main.openHome();
        ((JavascriptExecutor)_driver).executeScript("window.scrollTo(0, 0)");
        clickElement(homeMainMenu);
        WebDriverWait wait = new WebDriverWait(_driver, 6);
        wait.until(ExpectedConditions.urlToBe("http://toolsqa.com/"));
        return this;
    }

    public IFramePage verifyUrlAfterThirdCase(){
        Assert.assertEquals(_driver.switchTo().defaultContent().getCurrentUrl(), "http://toolsqa.com/");
        return this;
    }




}
