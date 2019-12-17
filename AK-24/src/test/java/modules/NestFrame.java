package modules;

import org.openqa.selenium.support.How;
import supports.Browser;

public class NestFrame {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://the-internet.herokuapp.com/nested_frames");
        String text = "";

        //Browser.getDriver().switchTo().frame("frame-top");
        Browser.getDriver().switchTo().frame(0);
        Browser.getDriver().switchTo().frame("frame-left");
        text = Browser.getText(How.XPATH,"html/body");
        System.out.println(text);

        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().frame("frame-middle");
        text = Browser.getText(How.XPATH,"html/body");
        System.out.println(text);

        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().frame("frame-right");
        text = Browser.getText(How.XPATH,"html/body");
        System.out.println(text);

        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().parentFrame();
        Browser.getDriver().switchTo().frame("frame-bottom");
        text = Browser.getText(How.XPATH,"html/body");
        System.out.println(text);
    }
}
