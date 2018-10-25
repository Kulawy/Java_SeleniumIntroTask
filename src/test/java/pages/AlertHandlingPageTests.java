package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.DemoSitesPage;
import pages.base.MainMenuPage;

public class AlertHandlingPageTests extends BasePageTests {

    DemoSitesPage demoSites;
    AlertHendlingPage alertPage;

    @BeforeMethod
    public void setUpForm(){
        _main = new MainMenuPage(chromeDriver);
        _main.openDemoSites();
        demoSites = new DemoSitesPage(chromeDriver);
        demoSites.goToAlert();
        alertPage = new AlertHendlingPage(chromeDriver, _main);
    }

    @Test
    public void simpleAlertTest(){
        alertPage.simpleAlertInvoke().verifySimpleAlert();

    }

    @Test
    public void confirmAlertTest(){
        alertPage.confirmAlertInvoke().verifyConfirmAlert();


    }

    @Test
    public void promptAlertTest(){
        alertPage.promptAlertInvoke().promptAlertInvoke();
    }

}
