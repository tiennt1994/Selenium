package modules.Fado;

import libraries.Functions_Search;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class Search_Test {
    public Functions_Search test;

    @BeforeMethod
    public void setUp(){
        test = new Functions_Search();
        Browser.open("chrome");
        Browser.get("https://fado.vn/");
        test.closePopup();
    }

    //search theo link amazon
    @Test
    public void TC01_searchLinkAmazonUs () throws InterruptedException {
        test.search("https://www.amazon.com/Samsung-Inch-Internal-MZ-76E1T0B-AM/dp/B078DPCY3T/ref=sr_1_1?keywords=ssd&qid=1576739385&sr=8-1");
        boolean isPresent = test.checkSearch("us");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC02_searchLinkAmazonJp () throws InterruptedException {
        test.search("https://www.amazon.co.jp/intime-%E3%82%A2%E3%83%B3%E3%83%86%E3%82%A3%E3%83%BC%E3%83%A0%EF%BC%89-%E7%A2%A7%EF%BC%88SORA%EF%BC%89-2-%E3%83%8F%E3%82%A4%E3%83%AC%E3%82%BE%E5%AF%BE%E5%BF%9C%E3%82%AB%E3%83%8A%E3%83%AB%E5%9E%8B%E3%82%A4%E3%83%A4%E3%83%9B%E3%83%B3/dp/B08434Y22Z/ref=sr_1_15?__mk_ja_JP=%E3%82%AB%E3%82%BF%E3%82%AB%E3%83%8A&dchild=1&keywords=headphones&qid=1584692246&s=electronics&sr=1-15");
        boolean isPresent = test.checkSearch("jp");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC03_searchLinkAmazonDe () throws InterruptedException {
        test.search("https://www.amazon.de/Anker-Datenhub-Ultrabooks-weiteren-kompatiblen/dp/B00Y211AFM?pf_rd_r=KF7EVGWE6MK1X2B4VAX0&pf_rd_p=d9a4a41e-2a85-5b89-9996-2d148a5ad340&pd_rd_r=e18d46a2-09e9-44f8-94f2-b4d6007bb047&pd_rd_w=tVmc1&pd_rd_wg=2H17m&ref_=pd_gw_ri");
        boolean isPresent = test.checkSearch("de");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC04_searchLinkAmazonUk () throws InterruptedException{
        test.search("https://www.amazon.co.uk/Dicstorets-Tablet-Computer-Android-Camera/dp/B07YWVTN3Y/ref=sr_1_1?keywords=tablet&qid=1576743790&sr=8-1");
        boolean isPresent = test.checkSearch("uk");
        Assert.assertFalse(isPresent);
    }

    //search theo asin
    @Test
    public void TC05_searchAsinUs () throws InterruptedException {
        test.search("B07211W6X2");
        boolean isPresent = test.checkSearch("us");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC06_searchAsinJp () throws InterruptedException {
        test.search("B07TXY7GM2");
        boolean isPresent = test.checkSearch("jp");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC07_searchAsinDe () throws InterruptedException {
        test.search("B07SDDX7WX");
        boolean isPresent = test.checkSearch("de");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC08_searchAsinUk () throws InterruptedException {
        test.search("B000795N4W");
        boolean isPresent = test.checkSearch("uk");
        Assert.assertFalse(isPresent);
    }

    //search theo keyword
    @Test
    public void TC09_searchKeywordAll () throws InterruptedException {
        test.search("tablet");
        boolean isPresent = test.checkSearch("all");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC10_searchKeywordUs () throws InterruptedException {
        test.searchUs("Máy tính bảng");
        boolean isPresent = test.checkSearch("us");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC11_searchKeywordJp () throws InterruptedException {
        test.searchJp("iphone");
        boolean isPresent = test.checkSearch("jp");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC12_searchKeywordDe () throws InterruptedException {
        test.searchDe("laptop");
        boolean isPresent = test.checkSearch("de");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC13_searchKeywordUk () throws InterruptedException {
        test.searchUk("apple watch");
        boolean isPresent = test.checkSearch("uk");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC14_searchKeywordAu () throws InterruptedException {
        test.searchAu("vitamin c");
        boolean isPresent = test.checkSearch("au");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC15_searchKeywordStore () throws InterruptedException {
        test.searchStore("giày");
        boolean isPresent = test.checkSearch("store");
        Assert.assertFalse(isPresent);
    }
    @Test (description = "search theo tên của item")
    public void TC16_searchKeywordName () throws InterruptedException {
        test.search("Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin Zero Frame Monitor (HDMI & VGA port)");
        boolean isPresent = test.checkSearch("us");
        Assert.assertFalse(isPresent);
    }

    //search check gia sp
    @Test
    public void TC17_searchCheckPrice () throws InterruptedException {
        test.search("laptop");
        boolean isPresent = test.checkPrice();
        Assert.assertFalse(isPresent);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess()) {
            Browser.captureScreenshot(); // capture screenshot when test failed
            String failUrl = Browser.getDriver().getCurrentUrl(); // print URL when test failed
            System.out.println("FAIL URL ='" + failUrl + "'");
        }
        Browser.close();
    }
}
