package modules.crossbrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplore {
    public static void main(String[] args) {
        //System.setProperty("webdriver.ie.driver","driver/IEDriverServer.exe");
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
    }
}
