package pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.DemoSitesPage;
import pages.base.MainMenuPage;

public class IFramePageTests extends BasePageTests {

    DemoSitesPage demoSites;
    IFramePage iFramePage;

    @BeforeMethod
    public void setUpForm(){
        _main = new MainMenuPage(chromeDriver);
        _main.openDemoSites();
        demoSites = new DemoSitesPage(chromeDriver);
        demoSites.goToIFrame();
        iFramePage = new IFramePage(chromeDriver, _main);
    }

    @Test
    public void firstIFrameTest(){
        iFramePage.firstCaseStep();
    }

    @Test
    public void wholeTest(){
        iFramePage.firstCaseStep()
                .secondCaseStep()
                .thirdCaseStep()
                .verifyUrlAfterThirdCase();
    }

}
