package modules;

import org.openqa.selenium.support.How;
import supports.Browser;

public class JSAlert {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.get("https://the-internet.herokuapp.com/javascript_alerts");
        Browser.find(How.XPATH, "//button[.='Click for JS Alert']").click();
        Browser.getDriver().switchTo().alert().dismiss();
        Browser.find(How.XPATH, "//button[.='Click for JS Confirm']").click();
        Browser.getDriver().switchTo().alert().accept();
        Browser.find(How.XPATH, "//button[.='Click for JS Prompt']").click();
        Browser.getDriver().switchTo().alert().sendKeys("hello");
        Browser.getDriver().switchTo().alert().accept();
    }
}
