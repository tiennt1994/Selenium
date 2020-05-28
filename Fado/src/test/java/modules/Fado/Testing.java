package modules.Fado;

import com.github.javafaker.Faker;
import data.Data_Login;
import libraries.Functions_AddToCart;
import libraries.Functions_Login;
import libraries.Functions_MobileSearch;
import libraries.Functions_Search;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class Testing {
    private Functions_AddToCart test_add;
    private Functions_Login test_login;
    Faker faker = new Faker();

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
    public void TC02_addCartWithLogin () throws InterruptedException {
        test_add.addToCart();
        Browser.navigate("https://fado.vn/us/amazon/k-kenzhou-computer-reading-glasses-blue-light-blocking-lightweight-glasses-for-women-2-packblackyellow-35-B07VK3S95P.html");
        test_add.addToCart();
        boolean isPresent = test_add.checkAddCartSameItem();
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
