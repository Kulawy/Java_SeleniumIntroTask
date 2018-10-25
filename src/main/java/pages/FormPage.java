package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;
import pages.base.MainMenuPage;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FormPage extends BasePage {

    private static final String PATH= "src/main/resources/bear.jpg";

    @FindBy( css = "input[name='firstname']")
    private WebElement inputFirstNameElement;
    @FindBy( css = "input[name='lastname']")
    private WebElement inputLastNameElement;
    @FindBy( id = "datepicker")
    private WebElement inputDatePickerElement;
    @FindBy( id = "sex-0")
    private WebElement inputSexRadioZeroElement;
    @FindBy( id = "exp-0")
    private WebElement inputRadioElement;
    @FindBy( id = "photo")
    private WebElement imgWebElement;
    @FindBy( id = "profession-1")
    private WebElement inputCheckProfElement;
    @FindBy( id = "tool-2")
    private WebElement inputCheckElement;
    @FindBy( id = "continents")
    private WebElement selectFieldElement;
    @FindBy( id = "selenium_commands")
    private WebElement seleniumCommandsFieldElement;
    @FindBy( id = "submit")
    private WebElement submitElement;



    public FormPage(WebDriver driver, MainMenuPage main) {
        super(driver);
        _main = main;
        PageFactory.initElements(_driver, this);
        List<WebElement> elements = Arrays.asList(inputCheckElement, inputCheckProfElement, seleniumCommandsFieldElement, selectFieldElement);
        //waitUntilElementsWillVisible(elements);
        waitForElements(elements);
    }

    public FormPage completeTheForm(){

        return this;
    }

    public FormPage firstNameComplete(String val){
        clickElement(inputFirstNameElement).sendKeys(val);
        return this;
    }

    public FormPage lastNameComplete(String val){
        clickElement(inputLastNameElement).sendKeys(val);
        return this;
    }

    public FormPage dateComplete(String val){
        clickElement(inputDatePickerElement).sendKeys(val);
        return this;
    }

    public FormPage inputSexRadioComplete(){
        clickElement(inputSexRadioZeroElement);
        return this;
    }

    public FormPage inputRadioComplete(){
        clickElement(inputRadioElement);
        return this;
    }

    public FormPage imageUploadComplete(){
        File loadedFile = loadFile();
        imgWebElement.sendKeys(loadedFile.getAbsolutePath());
        return this;
    }

    public FormPage inputCheckProfComplete(){
        clickElement(inputCheckProfElement);
        return this;
    }

    public FormPage inputCheckComplete(){
        clickElement(inputCheckElement);
        return this;
    }

    public FormPage selectContinentComplete(){
        Select selectItem = new Select(selectFieldElement);
        clickElement(selectFieldElement);
        selectItem.selectByVisibleText("Europe");
        return this;
    }

    public FormPage selectSeleniumConamdsComplete(int num){
        Select selectItem = new Select(seleniumCommandsFieldElement);
        clickElement(seleniumCommandsFieldElement);
        if ( num > 4)
            num = 4;
        if ( num < 0)
            num = 0;
        selectItem.selectByIndex(num);
        return this;
    }

    public FormPage submitComplete(){
        clickElement(submitElement);
        return this;
    }

    public FormPage verifySucces(){

        return this;
    }



    private File loadFile(){
        File myFile = new File(PATH);
        if ( myFile.exists())
            return myFile;
        else {
            System.out.println("Plik się nie załadował");
            return null;
        }
    }


}
