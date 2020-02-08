package libraries;

import org.openqa.selenium.support.How;
import supports.Browser;

public class Functions_Login {
    public boolean isExisted (String x){
        if (Browser.findAll(How.XPATH, x).size()>0) {
            return true;
        }
        else return false;
    }

    public void closePopup () {
        // click icon close banner quang cao
        if (isExisted("//*[@class='close']")){
            Browser.find(How.XPATH,"//*[@class='close']").click();
        }
        // close popup nhan diem
        //if (isExisted("//div[@id='regist-get-point-modal__form-block']/button[1]")){
        //    Browser.find(How.XPATH,"//div[@id='regist-get-point-modal__form-block']/button[1]").click();
        //}
    }

    public void login(String userName, String password) throws InterruptedException {
        Browser.fill(How.NAME,"email", userName);
        Browser.fill(How.NAME,"password", password);
        Browser.find(How.XPATH, "//button[.='Đăng nhập']").click();
        Thread.sleep(2000);
    }
}
