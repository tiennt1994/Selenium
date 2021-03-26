package modules;

import libraries.Function_Login;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class Login_Test {
    private Function_Login test;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        test = new Function_Login();
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://tiki.vn/");
        test.closePopup();
    }

    @Test (enabled = false)
    public void TC01_loginSuccess () throws InterruptedException {
        test.login("tiennumber1@gmail.com","tien2653084");
        boolean isPresent = test.checkLoginSuccess();
        Assert.assertTrue(isPresent);
    }
    @Test (enabled = false)
    public void TC02_loginFail () throws InterruptedException {
        test.login("tiennumber1@gmail.com","tien");
        boolean isPresent = test.checkLoginFail();
        Assert.assertTrue(isPresent);
    }
    @Test (enabled = false)
    public void TC03_loginGoogle () throws InterruptedException {
        test.loginGoogle("tiennumber1@gmail.com","TungTung0912");
        boolean isPresent = test.checkLoginSuccess();
        Assert.assertTrue(isPresent);
    }
    @Test
    public void TC04_loginFacebook () throws InterruptedException {
        test.loginFacebook("nguyentruongtien1994@gmail.com","tiennumber_035");
        boolean isPresent = test.checkLoginSuccess();
        Assert.assertTrue(isPresent);
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
