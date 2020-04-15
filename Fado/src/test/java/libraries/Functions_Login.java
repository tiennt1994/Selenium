package libraries;

import org.openqa.selenium.support.How;
import supports.Browser;

public class Functions_Login {

    public void login(String userName, String password) {
        Browser.fill(How.NAME,"email", userName);
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
