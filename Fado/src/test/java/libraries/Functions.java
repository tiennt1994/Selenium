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

    public boolean isExisted (String x){
        if (Browser.findAll(How.XPATH, x).size()>0) {
            return true;
        }
        else return false;
    }

    public void search (String link, String keyWord) throws InterruptedException {
        Browser.open("chrome");
        Browser.get(link);
        // click icon close banner quang cao
        if (isExisted("//*[@class='close']")){
            Browser.find(How.XPATH,"//*[@class='close']").click();
        }
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(3000);
    }

    public boolean checkSearch (String country) {
        switch (country) {
            case "us":
                return Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0;
            case "jp":
                return Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[2]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0;
            case "de":
                return Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[3]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0;
            case "uk":
                return Browser.findAll(How.XPATH, "//*[@class='search-result-layout']//div//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0;
            default:
                throw new IllegalStateException("country ko dung: " + country);
        }
    }
}
