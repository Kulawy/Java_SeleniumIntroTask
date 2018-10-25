package pl.sii.jgeron.form;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sii.jgeron.BaseSeleniumTest;

public class InputTextTests extends BaseSeleniumTest {

    WebElement inputFirtName ;
    WebElement inputLastName ;
    WebElement inputDataPicker;

    @BeforeMethod
    public void setAllUp(){
        chromeDriver.get("http://toolsqa.com/automation-practice-form/");
        inputFirtName = chromeDriver.findElement(By.cssSelector("input[name='firstname']"));
        inputLastName = chromeDriver.findElement(By.cssSelector("input[name='lastname']"));
        inputDataPicker = chromeDriver.findElement(By.id("datepicker"));
    }

    @Test
    public void inputFirstNameTest(){
        String firstNameMock = "Abby";
        //WebElement inputFirtName = chromeDriver.findElement(By.cssSelector("input[name='firstname']"));
        //WebElement inputLastName = chromeDriver.findElement(By.cssSelector("input[name='firstname']"));
        inputFirtName.click();
        inputFirtName.sendKeys( firstNameMock);
        //String textInField = inputFirtName.getText();
        String textInField = inputFirtName.getAttribute("value");
        Assert.assertEquals(firstNameMock, textInField );
    }

    @Test
    public void inputLastNameTest(){
        String lastNameMock = "Flower";
        inputLastName.click();
        inputLastName.sendKeys( lastNameMock);
        //String textInField = inputLastName.getText();
        String textInField = inputLastName.getAttribute("value");
        Assert.assertEquals(lastNameMock, textInField );
    }

    @Test
    public void inputDataPickerTest(){
        String inputDateString = "07-07-1992";
        inputDataPicker.click();
        inputDataPicker.sendKeys( inputDateString + Keys.TAB + Keys.TAB);
        String textInField = inputDataPicker.getAttribute("value");
        Assert.assertEquals(textInField, inputDateString);
    }

}