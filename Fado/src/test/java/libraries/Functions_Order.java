package libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.How;
import supports.Browser;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Functions_Order {
    public boolean isExisted (String x){
        if (Browser.findAll(How.XPATH, x).size()>0) {
            return true;
        }
        else return false;
    }

    public void closePopup () {
        // click icon close banner quang cao
        if (isExisted("//div[@id='bner-center-modal']//button[@class='close-btn']")){
            Browser.find(How.XPATH,"//div[@id='bner-center-modal']//button[@class='close-btn']").click();
        }
        if (isExisted("//div[@id='bner-center-modal']//button[@class='close']")){
            Browser.find(How.XPATH,"//div[@id='bner-center-modal']//button[@class='close']").click();
        }
        // close popup dki nhan thong bao
        if (isExisted("//div[@id='ins-editable-button-1580496456']")){
            Browser.find(How.XPATH,"//div[@id='ins-editable-button-1580496456']").click();
        }
        // close popup nhan diem
        //if (isExisted("//div[@id='regist-get-point-modal__form-block']/button[1]")){
        //    Browser.find(How.XPATH,"//div[@id='regist-get-point-modal__form-block']/button[1]").click();
        //}
    }

    public void orderWithLogin (String method) throws InterruptedException {
        Browser.elementToBeClickable(10,"//button[@class='buy-now-btn mz-grd-btn mz-grd-btn-danger mz-grd-btn-bdr-round']");
        Browser.find(How.XPATH, "//button[@class='buy-now-btn mz-grd-btn mz-grd-btn-danger mz-grd-btn-bdr-round']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']").click();
        Thread.sleep(3000);
        selectPaymentMethod(method);
        Thread.sleep(5000);
        Browser.elementToBeClickable(10,"//*[@class='my-btn -btn-pill -btn-grd-bg']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']").click();
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Thread.sleep(5000);
    }
    public void orderWithoutLogin () throws InterruptedException {
        Browser.elementToBeClickable(10,"//button[@class='buy-now-btn mz-grd-btn mz-grd-btn-danger mz-grd-btn-bdr-round']");
        Browser.find(How.XPATH, "//button[@class='buy-now-btn mz-grd-btn mz-grd-btn-danger mz-grd-btn-bdr-round']").click();
        Browser.waitForElement(10,"//*[@name='buyer_fullname']");
        Browser.fill(How.NAME, "buyer_fullname","Auto Test");
        Browser.fill(How.NAME, "buyer_phone","1234567890");
        Browser.fill(How.NAME, "buyer_email","tiennumber2@gmail.com");
        Select dropCity = new Select(Browser.find(How.NAME,"buyer_city_id"));
        dropCity.selectByVisibleText("Hồ Chí Minh");
        Browser.elementToBeClickable(10,"//*[@name='buyer_district_id']");
        Select dropDistrict = new Select(Browser.find(How.NAME,"buyer_district_id"));
        dropDistrict.selectByValue("640");
        Browser.elementToBeClickable(10,"//*[@name='buyer_ward_id']");
        Select dropWard = new Select(Browser.find(How.NAME,"buyer_ward_id"));
        dropWard.selectByValue("10200");
        Browser.fill(How.NAME, "buyer_address","21b");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']").click();
        Browser.elementToBeClickable(10,"//*[@class='my-btn -btn-pill -btn-grd-bg']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']").click();
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Thread.sleep(5000);
    }
    public void orderAddCart () throws InterruptedException {
        Browser.scrollByElement(How.XPATH,"//*[@class='cart-block__control-th']");
        Browser.elementToBeClickable(10,"//*[@class='my-btn -btn-pill -btn-grd-bg']");
        Browser.find(How.XPATH,"//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Browser.waitForElement(10,"//*[@name='buyer_fullname']");
        Browser.fill(How.NAME, "buyer_fullname","Auto Test");
        Browser.fill(How.NAME, "buyer_phone","1234567890");
        Browser.fill(How.NAME, "buyer_email","tiennumber2@gmail.com");
        Select dropCity = new Select(Browser.find(How.NAME,"buyer_city_id"));
        dropCity.selectByVisibleText("Hồ Chí Minh");
        Browser.elementToBeClickable(10,"//*[@name='buyer_district_id']");
        Select dropDistrict = new Select(Browser.find(How.NAME,"buyer_district_id"));
        dropDistrict.selectByValue("640");
        Browser.elementToBeClickable(10,"//*[@name='buyer_ward_id']");
        Select dropWard = new Select(Browser.find(How.NAME,"buyer_ward_id"));
        dropWard.selectByValue("10200");
        Browser.fill(How.NAME, "buyer_address","21b");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']").click();
        Browser.elementToBeClickable(10,"//*[@class='my-btn -btn-pill -btn-grd-bg']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']").click();
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Thread.sleep(5000);
    }

    public void selectPaymentMethod (String method) {
        switch (method.toLowerCase()) {
            case "fadopay":
                Browser.find(How.XPATH,"//div[contains(text(),'Tài khoản trả trước')]").click();
            case "chuyen khoan":
                Browser.find(How.XPATH,"//div[contains(text(),'Chuyển khoản')]").click();
            case "ATM":
                Browser.find(How.XPATH,"//div[contains(text(),'ATM')]").click();
            case "the tin dung":
                Browser.find(How.XPATH,"//div[contains(text(),'Thẻ tín dụng')]").click();
            case "zalopay":
                Browser.find(How.XPATH,"//div[contains(text(),'ZaloPay')]").click();
            case "van phong":
                Browser.find(How.XPATH,"//div[contains(text(),'Văn phòng')]").click();
            case "nha":
                Browser.scrollByElement(How.XPATH,"//i[@class='svg -svg-32px -svg-payment-home']");
                Browser.find(How.XPATH,"//i[@class='svg -svg-32px -svg-payment-home']").click();
            case "cua hang":
                Browser.scrollByElement(How.XPATH,"//div[contains(text(),'cửa hàng')]");
                Browser.find(How.XPATH,"//div[contains(text(),'cửa hàng')]").click();
            case "COD":
                Browser.find(How.XPATH,"//div[contains(text(),'COD')]").click();

            default:
                throw new IllegalStateException("Khong co phuong thuc thanh toan nay");
        }
    }

    public boolean checkOrderSuccess () {
        return (Browser.findAll(How.XPATH,"//div[@class='title-label'][contains(text(),'Quý khách đã tạo đơn hàng thành công')]").size()>0);
    }
}
