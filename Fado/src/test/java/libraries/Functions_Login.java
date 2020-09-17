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

    public void login(String username, String password) {
        Browser.find(How.CLASS_NAME,"login-btn").click();
        Browser.waitForElement(10,"//*[@name='email']");
        Browser.fill(How.NAME,"email", username);
        Browser.fill(How.NAME,"password", password);
        Browser.find(How.XPATH, "//button[.='Đăng nhập']").click();
    }

    public boolean checkLoginSuccess () {
        Browser.waitForElement(10,"//*[@class='user-name-col']");
        return (Browser.findAll(How.XPATH, "//*[@class='user-name-col']").size()>0);
    }
    public boolean checkLoginFailNullData () {
        return (Browser.findAll(How.XPATH,"//*[@id='auth-block__form-group__email-error'][contains(text(),'Vui lòng nhập dữ liệu')]").size()>0 &&
                Browser.findAll(How.XPATH,"//*[@id='password-error'][contains(text(),'Vui lòng nhập dữ liệu')]").size()>0);
    }
    public boolean checkLoginFailNullUsername () {
        return (Browser.findAll(How.XPATH,"//*[@id='auth-block__form-group__email-error'][contains(text(),'Vui lòng nhập dữ liệu')]").size()>0);
    }
    public boolean checkLoginFailNullPassword () {
        return (Browser.findAll(How.XPATH,"//*[@id='password-error'][contains(text(),'Vui lòng nhập dữ liệu')]").size()>0);
    }
    public boolean checkLoginFailWrongUsername () {
        Browser.waitForElement(10,"//div[@class='my-alert -alert-danger'][contains(text(),'Tài khoản không tồn tại')]");
        return (Browser.findAll(How.XPATH,"//div[@class='my-alert -alert-danger'][contains(text(),'Tài khoản không tồn tại')]").size()>0);
    }
    public boolean checkLoginFailWrongPassword () {
        Browser.waitForElement(10,"//div[@class='my-alert -alert-danger'][contains(text(),'Mật khẩu không đúng')]");
        return (Browser.findAll(How.XPATH,"//div[@class='my-alert -alert-danger'][contains(text(),'Mật khẩu không đúng')]").size()>0);
    }
}
