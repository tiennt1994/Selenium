package modules.Fado;

import com.github.javafaker.Faker;
import libraries.Functions_MobileSearch;
import libraries.Functions_Search;
import libraries.Parameters;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class Testing {
    public Functions_Search test;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        test = new Functions_Search();
        Browser.open("chrome");
        Browser.get("https://fado.vn/");
    }

    @Test (dataProvider = "data_provider", dataProviderClass = Parameters.class)
    public void TC01_searchLinkAmazonUs (String data) throws InterruptedException {
        test.search(data);
        boolean isPresent = test.checkSearch("all");
        Assert.assertFalse(isPresent);
    }
    @Test (enabled = false)
    public void TC02_searchLinkAmazonUs () throws InterruptedException {
        test.search(test.randomKeyword());
        boolean isPresent = test.checkSearch("all");
        Assert.assertFalse(isPresent);
    }

    @AfterMethod
    public void tearDown(@org.jetbrains.annotations.NotNull ITestResult result) {
        if(!result.isSuccess()) {
            //Browser.captureScreenshot();// capture screenshot when test failed
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        Browser.close();
    }
}
