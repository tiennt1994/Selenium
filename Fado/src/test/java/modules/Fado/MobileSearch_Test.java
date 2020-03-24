package modules.Fado;

import libraries.Functions_MobileSearch;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class MobileSearch_Test {
    public Functions_MobileSearch test;

    @BeforeMethod
    public void setUp(){
        test = new Functions_MobileSearch();
        Browser.openMobile();
        //Browser.getDriver().manage().window().maximize();
        Browser.get("https://fado.vn/");
        test.closePopup();
    }

    //search theo link amazon
    @Test
    public void TC01_searchLinkAmazonUs() throws InterruptedException {
        test.searchMobile("https://www.amazon.com/Timex-Unisex-T2N649-Weekender-Slip-Thru/dp/B008T9QG7K/ref=sr_1_2?keywords=watch&qid=1581414128&sr=8-2");
        boolean isPresent = test.checkSearchMobile("us");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC02_searchLinkAmazonJp() throws InterruptedException {
        test.searchMobile("https://www.amazon.co.jp/EXIO-%E3%82%A8%E3%82%AF%E3%82%B7%E3%82%AA-%E3%83%8D%E3%83%83%E3%82%AF%E3%82%A6%E3%82%A9%E3%83%BC%E3%83%9E%E3%83%BC-%E3%83%95%E3%83%AA%E3%83%BC%E3%82%B5%E3%82%A4%E3%82%BA-%E3%82%B9%E3%83%9D%E3%83%BC%E3%83%84/dp/B01MA3T26V?pf_rd_p=cf6e6bc6-ce13-5241-a523-b5d90e1db0ef&pf_rd_r=W266EXG54VC849PANE9G&pd_rd_wg=CP3mg&ref_=pd_gw_ri&pd_rd_w=3OQsb&pd_rd_r=75dc50d4-5f97-45be-a8dd-4e6e0269aee0");
        boolean isPresent = test.checkSearchMobile("jp");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC03_searchLinkAmazonDe() throws InterruptedException {
        test.searchMobile("https://www.amazon.de/LOGITECH-Wireless-Mouse-Occident-Packaging/dp/B00552K0GM?pf_rd_p=ab33a85f-3159-4678-be68-012eba10049c&pd_rd_wg=hFsSH&pf_rd_r=87TGQYF09NWV9XE21DY6&ref_=pd_gw_bia_d0&pd_rd_w=7pMwQ&pd_rd_r=7005b955-642a-466b-8568-07299467bc95");
        boolean isPresent = test.checkSearchMobile("de");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC04_searchLinkAmazonUk() throws InterruptedException {
        test.searchMobile("https://www.amazon.co.uk/WH-1000XM3-Wireless-Cancelling-Headphones-Headset-Black/dp/B07S7B176B?pf_rd_p=f1020222-8e09-43a5-82b9-cc1288900c75&pd_rd_wg=7bv2u&pf_rd_r=ZJJG336VN1DNWTPBE91N&ref_=pd_gw_cr_simh&pd_rd_w=P8Xnr&pd_rd_r=7cf40036-816d-42c6-a786-d69b5ad368da");
        boolean isPresent = test.checkSearchMobile("uk");
        Assert.assertFalse(isPresent);
    }

    //search theo asin
    @Test
    public void TC01_searchAsinUs() throws InterruptedException {
        test.searchMobile("B07PXGQC1Q");
        boolean isPresent = test.checkSearchMobile("us");
        Assert.assertFalse(isPresent);
    }

    //search check gia sp
    @Test
    public void searchPrice () throws InterruptedException {
        test.searchMobile("ssd");
        boolean isPresent = test.checkPriceMobile();
        Assert.assertFalse(isPresent);
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
