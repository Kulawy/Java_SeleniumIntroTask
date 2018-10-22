import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RadioInputTest extends BaseSeleniumTest {

    Random rnd = new Random();

    @BeforeMethod
    public void setUpSpec(){
        chromeDriver.get("http://toolsqa.com/automation-practice-form/");
    }

    @Test
    public void sexRadioButtonMaleTest(){
        WebElement inputSexRadio = chromeDriver.findElement(By.id("sex-0"));
        inputSexRadio.click();
        boolean isMale = inputSexRadio.isSelected();
        Assert.assertTrue(isMale);
    }

    @Test
    public void sexRadioButtonFemaleTest(){
        WebElement inputSexRadio = chromeDriver.findElement(By.id("sex-1"));
        inputSexRadio.click();
        boolean isFemale = inputSexRadio.isSelected();
        Assert.assertTrue(isFemale);
    }

    @Test
    public void yearsOfExperienceSelectedTest(){
        int number = rnd.nextInt(7);
        String numS = String.valueOf(number+1);
        String selectedId = "exp-" + number;
        WebElement inputRadio = chromeDriver.findElement(By.id(selectedId));
        inputRadio.click();
        String selectedValue = inputRadio.getAttribute("value");
        Assert.assertEquals(selectedValue, numS);
    }

}
