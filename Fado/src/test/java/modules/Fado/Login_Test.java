package modules.Fado;

import data.Data_Login;
import libraries.Functions_Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class Login_Test {
    public Functions_Login test;

    @BeforeMethod
    public void setUp(){
        test = new Functions_Login();
        Browser.open("chrome");
        Browser.get("https://fado.vn/dang-nhap");
    }

    @Test (dataProvider = "data_login", dataProviderClass = Data_Login.class, enabled = false)
    public void loginSuccess (String username, String password) {
        test.login(username, password);
        boolean isPresent = test.checkLoginSuccess();
        Assert.assertTrue(isPresent);
    }
    @Test (dataProvider = "data_login", dataProviderClass = Data_Login.class)
    public void loginFailNullData (String username, String password) {
        test.login(username, password);
        boolean isPresent = test.checkLoginFailNullData();
        Assert.assertTrue(isPresent);
    }

    @AfterMethod
    public void tearDown(@org.jetbrains.annotations.NotNull ITestResult result) {
        if(!result.isSuccess()) {
            //Browser.captureScreenshot();// capture screenshot when test failed
            String failUrl = Browser.getDriver().getCurrentUrl(); // print URL when test failed
            System.out.println("FAIL URL ='" + failUrl + "'");
        }
        Browser.close();
    }
}
