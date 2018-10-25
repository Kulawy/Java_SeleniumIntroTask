package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class DemoSitesPage extends BasePage {

    @FindBy( xpath = "//a[contains(@class,'ripple')][.='Automation Practice Form']")
    private WebElement practiceFormLink;

    @FindBy( xpath = "//a[contains(@class,'ripple')][.='Automation Practice Switch Windows']")
    private WebElement practiceSwitchLink;

    @FindBy( xpath = "//a[contains(@class,'ripple')][.='Automation Practice Table']")
    private WebElement practiceTableLink;

    @FindBy( xpath = "//a[contains(@class,'ripple')][.='Handling Alerts using Selenium WebDriver']")
    private WebElement practiceAlertHandlingLink;

    @FindBy( xpath ="//a[contains(@class,'ripple')][.='IFrame practice page']")
    private WebElement practiceIFrameLink;


    public DemoSitesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(_driver, this);
        List<WebElement> elements = Arrays.asList(practiceAlertHandlingLink, practiceFormLink, practiceIFrameLink, practiceSwitchLink, practiceTableLink);
        waitForElements(elements);
    }

    public void goToForm(){
        clickElement(practiceFormLink);
    }

    public void goToAlert(){
        clickElement(practiceAlertHandlingLink);
    }

    public void goToIFrame(){
        clickElement(practiceIFrameLink);
    }

    public void goToSwitch(){
        clickElement(practiceSwitchLink);
    }

    public void goToTable(){
        clickElement(practiceTableLink);
    }

   // public void waitUntilElementsWillVisible(){
     //   List<WebElement> elements = Arrays.asList(practiceAlertHandlingLink, practiceFormLink, practiceIFrameLink, practiceSwitchLink, practiceTableLink);
       // waitForElements(elements);
    //}


}
