package modules.Fado;

import libraries.Functions_Search;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class Testing {
    public Functions_Search test;

    @BeforeMethod
    public void setUp(){
        test = new Functions_Search();
        Browser.open("chrome");
        Browser.get("https://fado.vn/");
        test.closePopup();
    }

    @Test
    public void searchPrice () throws InterruptedException {
        test.search("g502 se");
        boolean isPresent = test.checkPrice();
        Assert.assertFalse(isPresent);
    }

    @AfterMethod
    public void tearDown(@org.jetbrains.annotations.NotNull ITestResult result) {
        if(!result.isSuccess()) {
            Browser.captureScreenshot();// capture screenshot when test failed
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        Browser.close();
    }
}