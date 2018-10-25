package pl.sii.jgeron.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sii.jgeron.BaseSeleniumTest;

import java.io.File;
import java.util.Random;

public class FormTests extends BaseSeleniumTest {

    Random rnd = new Random();

    @BeforeMethod
    public void setUpSpec(){
        chromeDriver.get("http://toolsqa.com/automation-practice-form/");
    }

    @Test
    public void writeAForm(){
        WebElement inputFirtName = chromeDriver.findElement(By.cssSelector("input[name='firstname']"));
        WebElement inputLastName = chromeDriver.findElement(By.cssSelector("input[name='lastname']"));
        WebElement inputDataPicker = chromeDriver.findElement(By.id("datepicker"));
        inputFirtName.click();
        inputFirtName.sendKeys( "Jakub");
        inputLastName.click();
        inputLastName.sendKeys( "Geroń");
        inputDataPicker.click();
        inputDataPicker.sendKeys( "1992-07-07");

        WebElement inputSexRadio = chromeDriver.findElement(By.id("sex-0"));
        inputSexRadio.click();
        WebElement inputRadio = chromeDriver.findElement(By.id("exp-0"));
        inputRadio.click();

        WebElement imageWeb = chromeDriver.findElement(By.id("photo"));
        File loadedFile = loadFile();
        imageWeb.sendKeys(loadedFile.getAbsolutePath()); //tu się krzaczyło

        WebElement inputCheckProf = chromeDriver.findElement(By.id("profession-1"));
        inputCheckProf.click();
        WebElement inputCheck = chromeDriver.findElement(By.id("tool-2"));
        inputCheck.click();

        WebElement selectField = chromeDriver.findElement(By.id("continents"));
        Select selectItem = new Select(selectField);
        selectField.click();
        selectItem.selectByVisibleText("Europe");

        WebElement seleniumCommandsField = chromeDriver.findElement(By.id("selenium_commands"));
        Select selectSeleniumCommands = new Select(seleniumCommandsField);
        selectSeleniumCommands.selectByIndex(rnd.nextInt(5));

        WebElement submitB = chromeDriver.findElement(By.id("submit"));
        submitB.submit();
    }


    private static final String PATH= "src/main/resources/bear.jpg";
    private static final String PATHTWO= "C:\\Users\\jgeron\\Documents\\JavaProjects2018\\SeleniumIntroTask\\src\\test\\java\\bear.jpg";

    public File loadFile(){
        File myFile = new File(PATH);
        if ( myFile.exists())
            return myFile;
        else {
            System.out.println("Plik się nie załadował");
            return null;
        }
    }



}
