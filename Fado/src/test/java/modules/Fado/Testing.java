package modules.Fado;

import libraries.Functions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class Testing {
    public Functions test;

    @BeforeMethod
    public void setUp(){
        test = new Functions();
        Browser.open("chrome");
        Browser.get("https://fado.vn/");
    }

    @Test
    public void searchKeywordMy () throws InterruptedException {
        test.searchUs("ssd");
        boolean isPresent = test.checkSearch("us");
        Assert.assertFalse(isPresent);
        Thread.sleep(1000);
    }

    @Test
    public void searchKeywordMy2 () throws InterruptedException {
        test.searchUs("ssd ahihi");
        boolean isPresent = test.checkSearch("us");
        Assert.assertFalse(isPresent);
        Thread.sleep(1000);
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
