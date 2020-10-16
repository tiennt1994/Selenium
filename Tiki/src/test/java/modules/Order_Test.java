package modules;

import libraries.Function_Login;
import libraries.Function_Order;
import org.openqa.selenium.support.How;
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
    public void setUp() {
        test_order = new Function_Order();
        test_login = new Function_Login();
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://tiki.vn/usb-kingston-dt100g3-32gb-usb-3-0-hang-chinh-hang-p405243.html?src=search&2hi=0&keyword=usb");
        //test_login.closePopup();
    }

    @Test (enabled = false)
    public void TC01_addCartWithoutLogin () throws InterruptedException {
        test_order.addCart();
        Thread.sleep(2000);
        boolean isPresent = test_order.checkAddCartSuccess();
        Assert.assertTrue(isPresent);
    }
    @Test
    public void TC02_addCartWithLogin () throws InterruptedException {
        test_login.login("tiennumber1@gmail.com","tien2653084");
        if (test_login.checkLoginSuccess()) {
            Browser.navigate("https://tiki.vn/usb-kingston-dt100g3-32gb-usb-3-0-hang-chinh-hang-p405243.html?src=search&2hi=0&keyword=usb");
            test_order.addCart();
            Thread.sleep(2000);
            boolean isPresent = test_order.checkAddCartSuccess();
            Assert.assertTrue(isPresent);
        }
        System.out.println("login fail");
    }

    @Test (enabled = false)
    public void TC02_removeCart () throws InterruptedException {
        test_order.addCart();
        Browser.find(How.XPATH,"//span[@class='cart-products__del']").click();
        Thread.sleep(2000);
        boolean isPresent = test_order.checkAddCartSuccess();
        Assert.assertFalse(isPresent);
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
