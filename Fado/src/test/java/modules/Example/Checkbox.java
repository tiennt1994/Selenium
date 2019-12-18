package modules.Example;

import org.openqa.selenium.support.How;
import supports.Browser;

public class Checkbox {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://the-internet.herokuapp.com/checkboxes");
        Browser.check(How.XPATH, "//form[@id='checkboxes']/input[1]");
        Browser.check(How.XPATH, "//form[@id='checkboxes']/input[2]");
        Browser.uncheck(How.XPATH, "//form[@id='checkboxes']/input[1]");
        Browser.uncheck(How.XPATH, "//form[@id='checkboxes']/input[2]");
    }
}
