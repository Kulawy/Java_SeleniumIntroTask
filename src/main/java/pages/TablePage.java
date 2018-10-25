package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.base.BasePage;
import pages.base.MainMenuPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TablePage extends BasePage {

    protected List<RowItem> columnsList;

    public TablePage(WebDriver driver, MainMenuPage main) {
        super(driver);
        _main = main;
        PageFactory.initElements(_driver, this);
        List<WebElement> elements = Arrays.asList(elementTable);
        waitForElements(elements);
    }

    @FindBy( css = "table[class='tsc_table_s13']")
    private WebElement elementTable;

    @FindAll({@FindBy( css = "table[summary='Sample Table'] tbody tr")})
    private List<WebElement> rowList;

    public TablePage tableRead(){
        columnsList = new ArrayList<RowItem>();
        for(WebElement row: rowList){
            columnsList.add(new RowItem(row));
        }
        for (RowItem oneRow: columnsList){
            System.out.println(oneRow);
        }
        return this;
    }

    public TablePage verifyTableReading(){
        Assert.assertEquals(columnsList.get(0).getHeight(),"829m");
        return this;
    }

}
