package pl.sii.jgeron.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TableTests {

    private static final String _DRIVERPATH= "src/main/resources/chromedriver.exe";

    protected WebDriver chromeDriver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", _DRIVERPATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.get("http://toolsqa.com/automation-practice-table/");
    }

    @AfterMethod
    public void tearDown(){
        chromeDriver.quit();
    }

    @Test
    public void tableTest(){
        List<WebElement> rowsList = chromeDriver.findElements(By.cssSelector("table[summary='Sample Table'] tbody tr"));
        List<RowItem> columnsList = new ArrayList<RowItem>();
        for(WebElement row: rowsList){
            columnsList.add(new RowItem(row));
        }
        for (RowItem oneRow: columnsList){
            System.out.println(oneRow);
        }
        Assert.assertEquals(columnsList.get(0).getHeight(),"829m");

    }

}
