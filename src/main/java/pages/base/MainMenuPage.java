package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenuPage extends BasePage{


    @FindBy( xpath = "//ul[@id='primary-menu']//span[contains(@class,'menu-text')][.='DEMO SITES']")
    private WebElement demoSites;

    @FindBy( css = "li.menu-item-home a[class='ripple']")
    private WebElement home;

    public MainMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(_driver, this);
    }

    public MainMenuPage openDemoSites(){
        demoSites.click();
        return this;
    }

    public MainMenuPage openHome(){
        clickElement(home);
        return this;
    }

}
