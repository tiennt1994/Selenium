package modules.Fado;

import com.github.javafaker.Faker;
import data.Data_Login;
import libraries.Functions_Login;
import libraries.Functions_MobileSearch;
import libraries.Functions_Search;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class Testing {
    public Functions_Login test;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        test = new Functions_Login();
        Browser.open("firefox");
        Browser.get("http://staging-v2.fado.vn/dang-nhap");
    }

    @Test (dataProvider = "data_login", dataProviderClass = Data_Login.class)
    public void TC01_loginSuccess (String username, String password) {
        test.login(username, password);
        boolean isPresent = test.checkLoginSuccess();
        Assert.assertTrue(isPresent);
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
