package modules.Example;

import org.openqa.selenium.support.How;
import supports.Browser;

public class TodoMVC {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.get("http://todomvc.com/examples/vanillajs/");
        Browser.fill(How.CLASS_NAME,"new-todo","to do 1\n");
        Browser.fill(How.CLASS_NAME,"new-todo","to do 2\n");
        Browser.fill(How.CLASS_NAME,"new-todo","to do 3\n");

        Browser.doubleClick(How.XPATH,"//label[.=\"to do 1\"]");
        //Browser.hover(How.XPATH,"//label[.=\"to do 2\"]");
        //Browser.find(How.XPATH,"//label[.=\"to do 2\"]/following-sibling::button").click();
        Browser.fill(How.XPATH,"//label[.=\"to do 1\"]/../../input","task 1\n");
        Browser.captureScreenshot();
    }
}
