package pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.DemoSitesPage;
import pages.base.MainMenuPage;

public class TablePageTests extends BasePageTests {

    DemoSitesPage demoSites;
    TablePage tablePage;

    @BeforeMethod
    public void setUpForm(){
        _main = new MainMenuPage(chromeDriver);
        _main.openDemoSites();
        demoSites = new DemoSitesPage(chromeDriver);
        demoSites.goToTable();
        tablePage = new TablePage(chromeDriver, _main);
    }

    @Test
    public void tableTest(){
        tablePage.tableRead().verifyTableReading();
    }

}
