package modules;

import org.openqa.selenium.support.How;
import supports.Browser;

public class iFrame {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.get("https://the-internet.herokuapp.com/iframe");
        Browser.getDriver().switchTo().frame(Browser.find(How.ID,"mce_0_ifr"));
        Browser.find(How.TAG_NAME, "p").clear();
        Browser.fill(How.TAG_NAME, "p","test123");
    }

}
