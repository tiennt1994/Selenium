package modules.Fado;

import com.github.javafaker.Faker;
import libraries.Functions_MobileSearch;
import libraries.Functions_Search;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class Testing {
    public Functions_MobileSearch test;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        test = new Functions_MobileSearch();
        Browser.openMobile();
        Browser.get("https://fado.vn/");
        test.closePopup();
    }

    @Test (invocationCount = 1, enabled = false)
    public void TC01_searchMobile () throws InterruptedException {
        test.searchMobile("tablet");
        boolean isPresent = test.checkSearchMobile("all");
        Assert.assertFalse(isPresent);
    }

    @Test (description = "search theo tên của item")
    public void TC16_searchKeywordName () throws InterruptedException {
        test.searchMobileStore("Apple MacBook Air (13-inch, 8GB RAM, 256GB Storage, 1.6GHz Intel Core i5) - Space Gray (Previous Model)");
        boolean isPresent = test.checkSearchMobile("store");
        Assert.assertFalse(isPresent);
    }

    @AfterMethod
    public void tearDown(@org.jetbrains.annotations.NotNull ITestResult result) {
        if(!result.isSuccess()) {
            //Browser.captureScreenshot(); // capture screenshot when test failed
            String failUrl = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + failUrl + "'");
        }
        Browser.close();
    }
}
