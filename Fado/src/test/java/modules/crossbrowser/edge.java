package modules.crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class edge {
    public static void main(String[] args) {
        //System.setProperty("webdriver.edge.driver","driver/MicrosoftWebDriver.exe");
        //WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
    }
}

