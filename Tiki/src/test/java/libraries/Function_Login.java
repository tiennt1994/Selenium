package libraries;

import org.openqa.selenium.support.How;
import supports.Browser;

public class Function_Login {
    public boolean isExisted (String x){
        if (Browser.findAll(How.XPATH, x).size()>0) {
            return true;
        }
        else return false;
    }

    public void closePopup () throws InterruptedException {
        // click icon close popup quang cao
        Browser.waitForElement(10,"//*[@id='onesignal-slidedown-cancel-button']");
        if (isExisted("//*[@id='onesignal-slidedown-cancel-button']")){
            Browser.find(How.XPATH,"//*[@id='onesignal-slidedown-cancel-button']").click();
        }
        Thread.sleep(1000);
    }

    public void login (String username, String password) throws InterruptedException {
        Browser.hover(How.XPATH,"//*[@class='Userstyle__NoWrap-sc-6e6am-11 cbYxcp']");
        Browser.find(How.XPATH,"//*[@class='Userstyle__UserDropDownButton-sc-6e6am-10 dYkBsI'][contains(text(),'Đăng nhập')]").click();
        Browser.waitForElement(5,"//input[@id='email']");
        Browser.fill(How.XPATH,"//input[@id='email']",username);
        Browser.fill(How.XPATH,"//input[@id='password']",password);
        Browser.find(How.XPATH,"//*[@class='UserModalstyle__RightButton-tngk37-8 GBpke']").click();
        Thread.sleep(5000);
    }

    public boolean checkLoginSuccess () {
        return (Browser.findAll(How.XPATH, "//*[@class='Userstyle__NoWrap-sc-6e6am-11 cbYxcp'][contains(text(),'Chào')]").size()>0);
    }
    public boolean checkLoginFail () {
        return (Browser.findAll(How.XPATH, "//*[@class='InputError-bdny64-0 gySywm']").size()>0);
    }
}
