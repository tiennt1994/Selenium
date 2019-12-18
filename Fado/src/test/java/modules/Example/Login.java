package modules.Example;

import org.openqa.selenium.support.How;
import supports.Browser;

public class Login {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://the-internet.herokuapp.com/login");
        Browser.fill(How.NAME, "username", "tomsmith");
        Browser.fill(How.NAME, "password", "SuperSecretPassword!");
        //driver.findElement(By.name("username")).sendKeys("tomsmith");
        //driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Browser.find(How.XPATH, "//button[@class='radius']").click();

    }
}
