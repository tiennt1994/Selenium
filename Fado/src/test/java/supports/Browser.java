package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Browser {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    public static void open(String name) {
        switch (name.toLowerCase()) {
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "chrome_headless": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox_headless": {
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            default:
                throw new IllegalStateException("Browser ko dung: " + name);
        }
    }
    public static void openMobile() {
        WebDriverManager.chromedriver().setup();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");// close notification cua trình duyệt
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    public static void get(String url) {
        driver.get(url);
    }
    public static void navigate(String url) {
        driver.navigate().to(url);
    }
    public static void reloadPage() {
        driver.navigate().refresh();
    }
    public static void backToPreviousPage() {
        driver.navigate().back();
    }
    public static void maximize() {
        driver.manage().window().maximize();
    }
    public static WebElement find(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
    }
    public static void fill(How how, String locator,String withText){
        find(how, locator).clear();
        find(how, locator).sendKeys(withText);
    }
    public static void check(How how, String locator){
        if(!find(how, locator).isSelected()){
            find(how, locator).click();
        }
    }
    public static void uncheck(How how, String locator){
        if(find(how, locator).isSelected()){
            find(how, locator).click();
        }
    }
    public static String getText(How how, String locator) {
        return find(how, locator).getText();
    }

    public static List<WebElement> findAll(How how, String locator) {
        return driver.findElements(how.buildBy(locator));
    }

    public static void doubleClick(How how, String locator){
        Actions dbClick = new Actions(driver);
        dbClick.doubleClick(find(how, locator)).perform();
    }

    public static void hover(How how, String locator){
        Actions hover = new Actions(driver);
        hover.moveToElement(find(how, locator)).perform();
    }

    public static void captureScreenshot(){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("./target/screenshot/screenshot-"+System.currentTimeMillis()+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void waitForElement(int seconds, String waitConditionLocator){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(waitConditionLocator)));
    }

    public static void close(){
        if (driver != null){
            driver.quit();
        }
    }
}


