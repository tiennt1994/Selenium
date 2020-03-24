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
    public void setUp(){
        test = new Functions_MobileSearch();
        Browser.openMobile();
        //Browser.getDriver().manage().window().maximize();
        Browser.get("https://fado.vn/");
        test.closePopup();
    }

    @Test (invocationCount = 1)
    public void TC17_searchMobile () throws InterruptedException {
        test.searchMobile("qqqqqqqqqqqqqqqqqqqqqqqq ưqeqư eqưe qưe");
        boolean isPresent = test.checkSearchMobile("us");
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
