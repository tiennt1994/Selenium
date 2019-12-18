package modules.crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CocCoc {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
        // Path to the Coccoc browser.
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Tien\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
        WebDriver driver = new ChromeDriver(options);
    }
}
