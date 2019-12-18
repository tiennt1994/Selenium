package modules.Example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;
import supports.WebTable;

public class Table {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.get("https://the-internet.herokuapp.com/tables");

        WebTable table1 = new WebTable(Browser.find(How.XPATH,"//table[@id='table1']"));
        System.out.println("number of rows : " + table1.getTotalRows());
        System.out.println("number of columns : " + table1.getTotalColumns());

        for (WebElement cell : table1.getColumns(1)){
            System.out.println(cell.getText());
        }
    }
}
