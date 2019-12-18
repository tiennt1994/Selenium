package modules.Example;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropdownBox {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(Browser.find(How.ID, "dropdown"));
        //select.selectByValue("1");
        //select.selectByVisibleText("Option 1");
        select.selectByIndex(3);
    }
}
