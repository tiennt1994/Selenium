package modules.Fado;

import com.github.javafaker.Faker;
import data.Data_Login;
import libraries.*;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

import java.util.concurrent.TimeUnit;

public class Testing {
    private Functions_AddToCart test_add;
    private Functions_Login test_login;
    private Functions_Order test_order;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        test_add = new Functions_AddToCart();
        test_login = new Functions_Login();
        test_order = new Functions_Order();
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("http://guest:123@staging-v2.fado.vn/us/amazon/hamile-airpods-case-protective-cover-front-led-visible-shockproof-soft-silicone-case-cover-skin-compatible-for-apple-airpods-2-1-with-keychain-lilac-B07T93ZS8Z.html");
        test_add.closePopup();
    }

    @Test
    public void TC03_orderAddCart () throws InterruptedException {
        Browser.multipleClick(How.XPATH,"//div[@class='mz-container']/div[@id='product-detail-block']/div[@class='product-detail-block__col-2']/div[@class='cart-segment']/div[@class='quantity-control-group']/button[@class='up-btn']",2);
        Thread.sleep(3000);
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
