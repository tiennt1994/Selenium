package libraries;

import org.openqa.selenium.support.How;
import supports.Browser;

import java.util.Set;

public class Function_Login {
    public boolean isExisted (String x){
        if (Browser.findAll(How.XPATH, x).size()>0) {
            return true;
        }
        else return false;
    }

    public void closePopup () throws InterruptedException {
        // click icon close popup quang cao
        Browser.waitForElement(15,"//*[@id='onesignal-slidedown-cancel-button']");
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
        Thread.sleep(4000);
    }
    public void loginGoogle (String username, String password) throws InterruptedException {
        Browser.hover(How.XPATH,"//*[@class='Userstyle__NoWrap-sc-6e6am-11 cbYxcp']");
        Browser.find(How.XPATH,"//*[@class='Userstyle__UserDropDownButton-sc-6e6am-10 fpkFKZ']").click();
        Thread.sleep(2000);
        Set<String> AllWindowHandles = Browser.getDriver().getWindowHandles();
        String window1 = (String) AllWindowHandles.toArray()[0];
        System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
        String window2 = (String) AllWindowHandles.toArray()[1];
        System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
        Browser.getDriver().switchTo().window(window2);
        Browser.waitForElement(5,"//input[@type='email']");
        Browser.fill(How.XPATH,"//input[@type='email']",username);
        Browser.find(How.XPATH,"//div[@class='VfPpkd-RLmnJb']").click();
        Browser.waitForElement(5,"//input[@type='password']");
        Browser.fill(How.XPATH,"//input[@type='password']",password);
        Browser.find(How.XPATH,"//div[@class='VfPpkd-RLmnJb']").click();
        Thread.sleep(7000);
        Browser.getDriver().switchTo().window(window1);
    }
    public void loginFacebook (String username, String password) throws InterruptedException {
        Browser.hover(How.XPATH,"//*[@class='account-label']");
        Browser.find(How.XPATH,"//*[@class='Userstyle__UserDropDownButton-sc-6e6am-10 eqGBml']").click();
        Thread.sleep(2000);
        Set<String> AllWindowHandles = Browser.getDriver().getWindowHandles();
        String window1 = (String) AllWindowHandles.toArray()[0];
        System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
        String window2 = (String) AllWindowHandles.toArray()[1];
        System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
        Browser.getDriver().switchTo().window(window2);
        Browser.waitForElement(5,"//input[@id='email']");
        Browser.fill(How.XPATH,"//input[@id='email']",username);
        Browser.fill(How.XPATH,"//input[@type='password']",password);
        Browser.find(How.XPATH,"//input[@name='login']").click();
        Thread.sleep(7000);
        Browser.getDriver().switchTo().window(window1);
    }

    public boolean checkLoginSuccess () {
        return (Browser.findAll(How.XPATH, "//*[@class='Userstyle__NoWrap-sc-6e6am-11 gtVgrD']").size()>0);
    }
    public boolean checkLoginFail () {
        return (Browser.findAll(How.XPATH, "//*[@class='InputError-bdny64-0 gySywm']").size()>0);
    }
}
