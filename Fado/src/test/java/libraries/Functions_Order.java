package libraries;

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

    public void orderWithLogin () throws InterruptedException {
        Browser.elementToBeClickable(10,"//div[@class='product-detail-block__col-2']//*[@class='mz-btn__label-col']");
        Browser.find(How.XPATH, "//div[@class='product-detail-block__col-2']//*[@class='mz-btn__label-col']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']").click();
        Browser.elementToBeClickable(10,"//*[@class='my-btn -btn-pill -btn-grd-bg']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']").click();
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Thread.sleep(5000);
    }
    public void orderWithoutLogin () throws InterruptedException {
        Browser.elementToBeClickable(10,"//div[@class='product-detail-block__col-2']//*[@class='mz-btn__label-col']");
        Browser.find(How.XPATH, "//div[@class='product-detail-block__col-2']//*[@class='mz-btn__label-col']").click();
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

    public boolean checkOrderSuccess () {
        return (Browser.findAll(How.XPATH,"//div[@class='title-label'][contains(text(),'Quý khách đã tạo đơn hàng thành công')]").size()>0);
    }
}
