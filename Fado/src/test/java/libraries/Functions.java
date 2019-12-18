package libraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

public class Functions {
    public void login(String userName, String password) throws InterruptedException {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://fado.vn/dang-nhap");
        Browser.fill(How.NAME,"email", userName);
        Browser.fill(How.NAME,"password", password);
        Browser.find(How.XPATH, "//button[.='Đăng nhập']").click();
        Thread.sleep(2000);
    }

    public boolean checkSearch (){

        if (Browser.findAll(How.XPATH, "//*[@class='search-result-block']/div//div[contains(text(),'Không tìm thấy sản phẩm')]").size()>0) return true;
        else return false;
    }
}
