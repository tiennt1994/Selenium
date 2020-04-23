package libraries;

import org.openqa.selenium.support.How;
import supports.Browser;

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

    public void order () throws InterruptedException {
        closePopup();
        Browser.elementToBeClickable(10,"//div[@class='product-detail-block__col-2']//*[@class='mz-btn__label-col']");
        Browser.find(How.XPATH, "//div[@class='product-detail-block__col-2']//*[@class='mz-btn__label-col']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg order-step-1-block__submit-vat-form']").click();
        Browser.waitForElement(10,"//*[@class='check-control margin--bottom-15px']//div[@class='check-control__check-icon']");
        Browser.find(How.XPATH, "//*[@class='check-control margin--bottom-15px']//div[@class='check-control__check-icon']").click();
        Browser.waitForElement(10,"//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']");
        Browser.find(How.XPATH, "//*[@class='my-btn -btn -btn-pill -btn-grd-bg margin--left-10px']").click();
        Browser.find(How.XPATH, "//*[@class='my-btn -btn-pill -btn-grd-bg']").click();
        Thread.sleep(5000);
    }

    public boolean checkOrderSuccess () {
        return (Browser.findAll(How.XPATH,"//div[@class='title-label'][contains(text(),'Quý khách đã tạo đơn hàng thành công')]").size()>0);
    }
}
