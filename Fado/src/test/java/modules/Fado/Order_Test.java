package modules.Fado;

import libraries.Functions_Login;
import libraries.Functions_Order;
import org.omg.CORBA.TIMEOUT;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

import java.util.concurrent.TimeUnit;

public class Order_Test {
    public Functions_Login test_login;
    public Functions_Order test_order;

    @BeforeMethod
    public void setUp(){
        test_login = new Functions_Login();
        test_order = new Functions_Order();
        Browser.open("chrome");
        Browser.get("http://guest:123@staging-v2.fado.vn/");
    }

    @Test
    public void TC01_orderWithLogin () throws InterruptedException {
        test_login.login("tiennt@miczone.vn", "tien2653084");
        // set dk login thanh cong moi navigate qua trang khac
        if (test_login.checkLoginSuccess()){
            Browser.navigate("http://staging-v2.fado.vn/us/amazon/hamile-airpods-case-protective-cover-front-led-visible-shockproof-soft-silicone-case-cover-skin-compatible-for-apple-airpods-2-1-with-keychain-lilac-B07T93ZS8Z.html");
            test_order.closePopup();
            test_order.orderWithLogin();
            boolean isPresent = test_order.checkOrderSuccess();
            Assert.assertTrue(isPresent);
        }
        else {
            System.out.println("login fail");
        }
    }
    @Test
    public void TC02_orderWithoutLogin () throws InterruptedException {
        Browser.navigate("http://staging-v2.fado.vn/us/amazon/hamile-airpods-case-protective-cover-front-led-visible-shockproof-soft-silicone-case-cover-skin-compatible-for-apple-airpods-2-1-with-keychain-lilac-B07T93ZS8Z.html");
        test_order.closePopup();
        test_order.orderWithoutLogin();
        boolean isPresent = test_order.checkOrderSuccess();
        Assert.assertTrue(isPresent);
    }

    @AfterMethod
    public void tearDown(@org.jetbrains.annotations.NotNull ITestResult result) {
        if(!result.isSuccess()) {
            Browser.captureScreenshot();// capture screenshot when test failed
            String failUrl = Browser.getDriver().getCurrentUrl(); // print URL when test failed
            System.out.println("FAIL URL ='" + failUrl + "'");
        }
        Browser.close();
    }
}
