package modules;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://tiki.vn/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='onesignal-slidedown-cancel-button']")));
        driver.findElement(By.xpath("//*[@id='onesignal-slidedown-cancel-button']")).click();
        Thread.sleep(2000);
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("//*[@class='Userstyle__NoWrap-sc-6e6am-11 cbYxcp']"))).perform();
        driver.findElement(By.xpath("//*[@class='Userstyle__UserDropDownButton-sc-6e6am-10 dYkBsI'][contains(text(),'Đăng nhập')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='email']")));
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tiennumber1@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("tien2653084");
        driver.findElement(By.xpath("//*[@class='UserModalstyle__RightButton-tngk37-8 GBpke']")).click();
        Thread.sleep(3000);
        driver.close();
    }
}