package pl.sii.jgeron.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RowItem {

    private String structure;
    private String country;
    private String city;
    private String height;
    private int build;
    private int rank;

    public RowItem(WebElement tr){
        List<WebElement> columnsTD = tr.findElements(By.cssSelector("td"));
        this.structure = tr.findElement(By.cssSelector("th")).getText();
        this.country = columnsTD.get(0).getText();
        this.city = columnsTD.get(1).getText();
        this.height = columnsTD.get(2).getText();
        this.build = Integer.parseInt(columnsTD.get(3).getText());
        this.rank = Integer.parseInt(columnsTD.get(4).getText());

    }

    @Override
    public String toString(){
        String info = "\nName of building: "+ structure
                        + "\nLocation: "+ city + " in " + country
                        + "\nParameters: " + height + " tall "  + " built in " + build
                        + "\nPlace in highest building list: " + rank;
        return info;
    }

    public String stringName(){

        return ( "Name of building: "+ structure + "Location: "+ city + " in " + country );
    }


    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
