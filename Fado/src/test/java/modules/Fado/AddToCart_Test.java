package modules.Fado;

import libraries.Functions_AddToCart;
import libraries.Functions_Login;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class AddToCart_Test {
    public Functions_AddToCart test_add;
    public Functions_Login test_login;

    @BeforeMethod
    public void setUp(){
        test_add = new Functions_AddToCart();
        test_login = new Functions_Login();
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://fado.vn/us/amazon/k-kenzhou-computer-reading-glasses-blue-light-blocking-lightweight-glasses-for-women-2-packblackyellow-35-B07VK3S95P.html");
        test_add.closePopup();
    }

    @Test
    public void TC01_addCartWithoutLogin () throws InterruptedException {
        test_add.addToCart();
        boolean isPresent = test_add.checkAddCartSuccess();
        Assert.assertTrue(isPresent);
    }
    @Test
    public void TC02_addCartWithLogin () throws InterruptedException {
        test_login.login("tiennt@miczone.vn", "tien2653084");
        if (test_login.checkLoginSuccess()){
            test_add.closePopup();
            test_add.addToCart();
            boolean isPresent = test_add.checkAddCartSuccess();
            Assert.assertTrue(isPresent);
        }
        else {
            System.out.println("login fail");
        }
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
