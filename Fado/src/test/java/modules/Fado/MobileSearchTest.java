package modules.Fado;

import libraries.Functions_MobileSearch;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class MobileSearchTest {
    public Functions_MobileSearch test;

    @BeforeMethod
    public void setUp(){
        test = new Functions_MobileSearch();
        Browser.openMobile();
        //Browser.getDriver().manage().window().maximize();
        Browser.get("https://fado.vn/");
        test.closePopup();
    }

    @Test
    public void searchPrice () throws InterruptedException {
        test.search("ssd");
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
