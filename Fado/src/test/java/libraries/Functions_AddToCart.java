package libraries;

import org.openqa.selenium.support.How;
import supports.Browser;

import java.util.concurrent.TimeUnit;

public class Functions_AddToCart {

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

    private int i;
    public void addToCart () throws InterruptedException {
        String quantityBefore = Browser.getText(How.CLASS_NAME, "cart-btn__quantity");
        // do nếu số sp trong giỏ = 0 thì khi getText sẽ = ""
        if (quantityBefore.equals("")) {
            quantityBefore = "0";
            i = Integer.parseInt(quantityBefore);
        }
        else i = Integer.parseInt(quantityBefore);
        Browser.elementToBeClickable(10,"//div[@class='product-detail-block__col-2']//*[@class='mz-grd-btn__label-col']");
        Browser.find(How.XPATH,"//div[@class='product-detail-block__col-2']//*[@class='mz-grd-btn__label-col']").click();
        Browser.waitForElement(10,"//*[@class='mz-btn__label-col'][contains(text(),'Xem giỏ hàng và thanh toán')]");
        Browser.find(How.XPATH,"//*[@class='mz-btn__label-col'][contains(text(),'Xem giỏ hàng và thanh toán')]").click();
        Thread.sleep(3000);
    }

    public boolean checkAddCartSuccess () {
        //return ((Browser.findAll(How.XPATH,"//*[@class='cart-block__product-info-td']").size()>0)&&(Browser.getText(How.CLASS_NAME, "cart-btn__quantity").equals("1")));
        int quantityAfter = Browser.getNumber(How.CLASS_NAME, "cart-btn__quantity");
        return quantityAfter == i + 1;
    }
}
