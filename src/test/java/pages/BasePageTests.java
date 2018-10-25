package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.base.MainMenuPage;

public class BasePageTests {

    private static final String _DRIVERPATH= "src/main/resources/chromedriver.exe";
    protected WebDriver chromeDriver;
    protected MainMenuPage _main;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", _DRIVERPATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.get("http://toolsqa.com/");
    }

    @AfterMethod
    public void tearDown(){
        chromeDriver.quit();
    }

}
