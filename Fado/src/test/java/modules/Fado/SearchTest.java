package modules.Fado;

import libraries.Functions_Search;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.Browser;

public class SearchTest {
    public Functions_Search test;

    @BeforeMethod
    public void setUp(){
        test = new Functions_Search();
        Browser.open("chrome");
        Browser.get("https://fado.vn/");
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
        test.search("https://www.amazon.co.jp/IPhone-%E6%90%BA%E5%B8%AF%E9%9B%BB%E8%A9%B1%E3%82%AB%E3%83%90%E3%83%BC-%E5%A4%9A%E6%A9%9F%E8%83%BD%E3%82%B9%E3%83%9E%E3%83%9B%E3%82%B1%E3%83%BC%E3%82%B9-%E3%82%AB%E3%83%BC%E3%83%89%E3%83%9B%E3%83%AB%E3%83%80%E3%83%BC-%E3%83%97%E3%83%AC%E3%83%9F%E3%82%A2%E3%83%A0%E3%83%AC%E3%82%B6%E3%83%BC/dp/B07YXJC4DH/ref=sr_1_3?__mk_ja_JP=%E3%82%AB%E3%82%BF%E3%82%AB%E3%83%8A&keywords=iphone&qid=1576742757&sr=8-3");
        boolean isPresent = test.checkSearch("jp");
        Assert.assertFalse(isPresent);
    }
    @Test
    public void TC03_searchLinkAmazonDe () throws InterruptedException {
        test.search("https://www.amazon.de/HUAWEI-Watch-Herzfrequenz-Messung-Wiedergabe-wasserdicht-Matte-Black/dp/B07YNCWPMM/ref=sr_1_1_sspa?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=watch&qid=1576743693&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzQjYyMUdIQ0FWUVomZW5jcnlwdGVkSWQ9QTA1MDI0NTYxMjhJWVhCS1BVSjRPJmVuY3J5cHRlZEFkSWQ9QTAxODg3NDBHTFFFQTUyU1IwQ0kmd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl");
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
        test.search("B07HH7GB87");
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
    @Test
    public void TC16_searchKeywordName () throws InterruptedException {
        test.search("Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin Zero Frame Monitor (HDMI & VGA port)");
        boolean isPresent = test.checkSearch("us");
        Assert.assertFalse(isPresent);
    }

    //search check gia sp
    @Test
    public void searchCheckPrice () throws InterruptedException {
        test.search("g502 se");
        boolean isPresent = test.checkPrice();
        Assert.assertFalse(isPresent);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess()) {
            Browser.captureScreenshot(); // capture screenshot when test failed
            String URL = Browser.getDriver().getCurrentUrl(); // print URL when test failed
            System.out.println("FAIL URL ='" + URL + "'");
        }
        Browser.close();
    }
}
