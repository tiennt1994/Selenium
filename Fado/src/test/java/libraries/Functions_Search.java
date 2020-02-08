package libraries;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

public class Functions_Search {
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

    public void search (String keyWord) throws InterruptedException {
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(4000);
    }

    public void searchUs (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Mỹ')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(4000);
    }
    public void searchJp (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Nhật')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(4000);
    }
    public void searchDe (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Đức')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(4000);
    }
    public void searchUk (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Anh')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(4000);
    }
    public void searchAu (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Úc')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(4000);
    }
    public void searchStore (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Gian hàng')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(4000);
    }

    public boolean checkSearch (String country) {
        switch (country.toLowerCase()) {
            case "us": {
                return (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__head']//div[contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "jp": {
                return (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[2]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[2]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__head'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "de": {
                return (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[3]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[3]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__head'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "uk": {
                return (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[4]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[4]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__head'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "au":{
                return (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[5]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[5]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__head'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "store":{
                return (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[6]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[6]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__head'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "all": {
                return (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[2]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[2]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[3]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[3]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[4]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[4]//div[contains(text(),'Quý khách vui lòng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[6]//div[contains(text(),'Không tìm thấy sản phẩm')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[6]//div[contains(text(),'Quý khách vui lòng')]").size() > 0);
            }
            default:
                throw new IllegalStateException("country ko dung: " + country);
        }
    }

    public boolean checkPrice () {
        return ((Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[1]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[2]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[3]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[4]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[5]//div[contains(text(),'Không hỗ trợ')]").size() > 0) ||
                        (Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[1]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[2]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[3]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[4]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-layout']/section[1]//div[@class='swiper-wrapper']/div[5]//div[contains(text(),'báo giá')]").size() > 0));
    }
}

