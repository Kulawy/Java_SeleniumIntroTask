package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver _driver;
    protected MainMenuPage _main;
    protected Actions _actionsBuilder;

    public BasePage(WebDriver driver){
        _driver = driver;
    }

    public void waitWhile(WebElement elementToWait, int timeWaiting){

    }

    public WebElement clickElement(WebElement element){
        waitUntilClickable(element);
        element.click();
        return element;
    }

    public void waitUntilClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(_driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElements(List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(_driver, 6);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    //public void waitUntilElementsWillVisible(List<WebElement> elements){
      //  waitForElements(elements);
    //}


}
