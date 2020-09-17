package modules.Fado;

import com.github.javafaker.Faker;
import data.Data_Login;
import data.Data_Login_csv;
import libraries.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.BasicCsvReader;
import supports.Browser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testing {
    private Functions_AddToCart test_add;
    private Functions_Login test_login;
    private Functions_Order test_order;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        test_add = new Functions_AddToCart();
        test_login = new Functions_Login();
        test_order = new Functions_Order();
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
        test_add.closePopup();
    }

    @Test
    public void TC01_loginSuccess () throws InterruptedException {
        //Alert Pop up Handling.
        Browser.find(How.XPATH,"//input[@value='Show Me Alert']").click();
        //To locate alert.
        Thread.sleep(2000);
        Alert A1 = Browser.getDriver().switchTo().alert();
        //To read the text from alert popup.

        //To accept/Click Ok on alert popup.
        A1.accept();
        Browser.find(How.XPATH,"//button[@onclick='myFunction()']").click();
        //To locate alert.
        Alert A2 = Browser.getDriver().switchTo().alert();
        A2.dismiss();
        String text = Browser.find(How.XPATH, "//*[@id='demo'][contains(text(),'You press')]").getText();
        System.out.println(text);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(@org.jetbrains.annotations.NotNull ITestResult result) {
        if(!result.isSuccess()) {
            //Browser.captureScreenshot(result.getName()); // capture screenshot when test failed
            String failUrl = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + failUrl + "'");
        }
        Browser.close();
    }
}
