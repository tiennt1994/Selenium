package modules.Example;

import org.openqa.selenium.support.How;
import supports.Browser;

public class Redirector {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://the-internet.herokuapp.com/redirector");
        Browser.find(How.LINK_TEXT, "here").click();
        Browser.find(How.LINK_TEXT, "200").click();
        Browser.find(How.LINK_TEXT, "here").click();
        Browser.find(How.LINK_TEXT, "301").click();
        Browser.find(How.LINK_TEXT, "here").click();
        Browser.find(How.LINK_TEXT, "404").click();
        Browser.find(How.LINK_TEXT, "here").click();
        Browser.find(How.LINK_TEXT, "500").click();
        Browser.find(How.LINK_TEXT, "here").click();
        Browser.find(How.LINK_TEXT, "here").click();
    }
}
