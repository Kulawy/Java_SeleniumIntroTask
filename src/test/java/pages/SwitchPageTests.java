package pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.DemoSitesPage;
import pages.base.MainMenuPage;

public class SwitchPageTests extends BasePageTests {

    DemoSitesPage demoSites;
    SwitchPage switchPage;

    @BeforeMethod
    public void setUpSwitch(){
        _main = new MainMenuPage(chromeDriver);
        _main.openDemoSites();
        demoSites = new DemoSitesPage(chromeDriver);
        demoSites.goToSwitch();
        switchPage = new SwitchPage(chromeDriver, _main);
    }

    @Test
    public void firstTest(){
        switchPage.firstPreparation().afterStuff();
    }

    @Test
    public void secondTest(){
        switchPage.secondPreparation().afterStuff();
    }

    @Test
    public void thirdTest(){
        switchPage.thirdPreparation().afterStuff();
    }


}
