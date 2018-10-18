import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CheckBoxTests extends BaseSeleniumTest {

    Random rnd = new Random();

    @Test
    public void proffesionCheckBoxsTest(){
        int num = rnd.nextInt(2);
        String inputStringCheckBox;
        if ( num == 0)
            inputStringCheckBox = "profession-0";
        else
            inputStringCheckBox = "profession-1";
        
        WebElement inputCheckProf = chromeDriver.findElement(By.id(inputStringCheckBox));
        inputCheckProf.click();
        String selectedValue = inputCheckProf.getAttribute("value");
        if ( num ==0)
            Assert.assertEquals(selectedValue, "Manual Tester");
        else
            Assert.assertEquals(selectedValue, "Automation Tester");
    }

    @Test
    public void automationToolCheckBoxsTest(){
        int num = rnd.nextInt(3);
        String inputStringCheckBox;
        if ( num == 0)
            inputStringCheckBox = "tool-0";
        else if( num ==1)
            inputStringCheckBox = "tool-1";
        else
            inputStringCheckBox = "tool-2";

        WebElement inputRadio = chromeDriver.findElement(By.id(inputStringCheckBox));
        inputRadio.click();
        String selectedValue = inputRadio.getAttribute("value");
        if ( num ==0)
            Assert.assertEquals(selectedValue, "QTP");
        else if (num == 1)
            Assert.assertEquals(selectedValue, "Selenium IDE");
        else
            Assert.assertEquals(selectedValue, "Selenium Webdriver");
    }

}
