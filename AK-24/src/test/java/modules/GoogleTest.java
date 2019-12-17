package modules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    public static void main(String[] args) {
        //Browser.open("chrome");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
       // WebDriver driver = Browser.getDriver();
        // driver.findElement(By.name("q")).sendKeys("selenium");
        // driver.findElement(By.tagName("input")).sendKeys("selenium");
        // driver.findElement(By.xpath("//input[@title='Tìm kiếm']")).sendKeys("selenium");
        //driver.findElement(By.cssSelector("input[name=q]")).sendKeys("selenium");
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("selenium");
        //driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
        //driver.findElement(By.xpath("//*[@name='q']")).sendKeys("selenium");
    }
}
