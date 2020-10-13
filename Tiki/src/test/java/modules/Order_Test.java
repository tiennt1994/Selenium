package modules;

import libraries.Function_Login;
import libraries.Function_Order;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class Order_Test {
    private Function_Order test_order;
    private Function_Login test_login;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        test_order = new Function_Order();
        test_login = new Function_Login();
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://tiki.vn/usb-kingston-dt100g3-32gb-usb-3-0-hang-chinh-hang-p405243.html?src=search&2hi=0&keyword=usb");
        //test_login.closePopup();
    }

    @Test
    public void TC01_addCart () throws InterruptedException {
        test_order.addCart();
        Thread.sleep(3000);
        boolean isPresent = test_order.checkAddCartSuccess();
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
