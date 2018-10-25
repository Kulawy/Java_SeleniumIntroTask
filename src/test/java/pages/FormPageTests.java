package pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.DemoSitesPage;
import pages.base.MainMenuPage;

public class FormPageTests extends BasePageTests{

    DemoSitesPage demoSites;
    FormPage formPage;

    @BeforeMethod
    public void setUpForm(){
        _main = new MainMenuPage(chromeDriver);
        _main.openDemoSites();
        demoSites = new DemoSitesPage(chromeDriver);
        demoSites.goToForm();
        formPage = new FormPage(chromeDriver, _main);
    }

    @Test
    public void completeForm(){
        formPage.firstNameComplete("Jakub")
                .lastNameComplete("Gie")
                .dateComplete("1992-07-07")
                .inputSexRadioComplete()
                .inputRadioComplete()
                .imageUploadComplete()
                .inputCheckProfComplete()
                .inputCheckComplete()
                .selectContinentComplete()
                .selectSeleniumConamdsComplete(3)
                .submitComplete();
        //_main.openHome();
        //Assert.assertEquals(chromeDriver.getCurrentUrl(), "http://toolsqa.com/");
    }

}
