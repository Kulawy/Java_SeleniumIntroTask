import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SelectFieldsTests extends BaseSeleniumTest {

    Random rnd = new Random();

    @Test
    public void continentsSelectFieldTest(){
        String selectFieldId = "continents";
        WebElement selectField = chromeDriver.findElement(By.id(selectFieldId));
        Select selectItem = new Select(selectField);
        selectField.click();
        selectItem.selectByVisibleText("Europe");
        String selectedValue = selectField.getAttribute("value");
        Assert.assertEquals(selectedValue, "Europe");
    }

    @Test
    public void seleniumComandsSelectFieldTest(){
        String selectFieldId = "selenium_commands";
        WebElement selectField = chromeDriver.findElement(By.id(selectFieldId));
        Select selectItem = new Select(selectField);
        selectItem.selectByIndex(3);
        String selectedValue = selectField.getAttribute("value");
        Assert.assertEquals(selectedValue, "Wait Commands");
    }


}
