package modules.Fado;

import libraries.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import supports.Browser;

public class SearchTest {
    public static void main(String[] args) throws InterruptedException {
        //searchLinkAmazon();
        searchAsin();
    }

    public static void searchLinkAmazon () throws InterruptedException{
        Functions test = new Functions();
        //amazon My
        test.search("https://fado.vn/", "https://www.amazon.com/Samsung-Inch-Internal-MZ-76E1T0B-AM/dp/B078DPCY3T/ref=sr_1_1?keywords=ssd&qid=1576739385&sr=8-1");
        if (test.checkSearch("us")) {
            Browser.captureScreenshot();
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        else System.out.println("PASS");
        Browser.close();
        //amazon Nhat
        test.search("https://fado.vn/", "https://www.amazon.co.jp/IPhone-%E6%90%BA%E5%B8%AF%E9%9B%BB%E8%A9%B1%E3%82%AB%E3%83%90%E3%83%BC-%E5%A4%9A%E6%A9%9F%E8%83%BD%E3%82%B9%E3%83%9E%E3%83%9B%E3%82%B1%E3%83%BC%E3%82%B9-%E3%82%AB%E3%83%BC%E3%83%89%E3%83%9B%E3%83%AB%E3%83%80%E3%83%BC-%E3%83%97%E3%83%AC%E3%83%9F%E3%82%A2%E3%83%A0%E3%83%AC%E3%82%B6%E3%83%BC/dp/B07YXJC4DH/ref=sr_1_3?__mk_ja_JP=%E3%82%AB%E3%82%BF%E3%82%AB%E3%83%8A&keywords=iphone&qid=1576742757&sr=8-3");
        if (test.checkSearch("jp")) {
            Browser.captureScreenshot();
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        else System.out.println("PASS");
        Browser.close();
        //amazon Duc
        test.search("https://fado.vn/", "https://www.amazon.de/HUAWEI-Watch-Herzfrequenz-Messung-Wiedergabe-wasserdicht-Matte-Black/dp/B07YNCWPMM/ref=sr_1_1_sspa?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=watch&qid=1576743693&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzQjYyMUdIQ0FWUVomZW5jcnlwdGVkSWQ9QTA1MDI0NTYxMjhJWVhCS1BVSjRPJmVuY3J5cHRlZEFkSWQ9QTAxODg3NDBHTFFFQTUyU1IwQ0kmd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl");
        if (test.checkSearch("de")) {
            Browser.captureScreenshot();
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        else System.out.println("PASS");
        Browser.close();
        //amazon Anh
        test.search("https://fado.vn/", "https://www.amazon.co.uk/Dicstorets-Tablet-Computer-Android-Camera/dp/B07YWVTN3Y/ref=sr_1_1?keywords=tablet&qid=1576743790&sr=8-1");
        if (test.checkSearch("uk")) {
            Browser.captureScreenshot();
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        else System.out.println("PASS");
        Browser.close();
    }

    public static void searchAsin () throws InterruptedException {
        Functions test = new Functions();
        //asin amazon My
        test.search("https://fado.vn/","B07211W6X2");
        if (test.checkSearch("us")) {
            Browser.captureScreenshot();
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        else System.out.println("PASS");
        Thread.sleep(2000);
        Browser.close();
    }

}
