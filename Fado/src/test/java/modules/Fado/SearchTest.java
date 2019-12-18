package modules.Fado;

import libraries.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import supports.Browser;

public class SearchTest {
    public static void main(String[] args) throws InterruptedException {
        searchLinkAmazon();
    }

    public static void searchLinkAmazon () throws InterruptedException{
        Browser.open("chrome");
        Browser.get("https://fado.vn/");
        // click icon close banner quang cao
        Browser.find(How.XPATH,"//*[@class='close']").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input","https://www.amazon.com/dp/B07PHLBBQR/ref=twister_dp_update?ie=UTF8&m=ATVPDKIKX0DER&th=1");
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(3000);
        Functions test = new Functions();
        if (test.checkSearch()) {
            Browser.captureScreenshot();
            String URL = Browser.getDriver().getCurrentUrl();
            System.out.println("FAIL URL ='" + URL + "'");
        }
        else System.out.println("PASS");
    }
}
