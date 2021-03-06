package libraries;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.testng.annotations.DataProvider;
import supports.Browser;
import java.util.Random;

public class Functions_Search {
    public boolean isExisted (String element){
        if (Browser.findAll(How.XPATH, element).size()>0) {
            return true;
        }
        else return false;
    }

    public void closePopup () {
        // close banner quang cao
        if (isExisted("//*[@class='close']")){
            Browser.find(How.XPATH,"//*[@class='close']").click();
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

    String[] keywords = {"ssd","laptop","may tinh","tablet","máy tính bảng","đồng hồ","apple watch","vitamin c","airpods","hot toys","mắt kiếng"};

    public int createRandomNumber() {
        Random ran = new Random();
        return ran.nextInt(keywords.length);
    }
    public String randomKeyword() {
        return keywords[createRandomNumber()];
    }

    public void search (String keyWord) throws InterruptedException {
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(6000);
    }
    public void searchUs (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Mỹ')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(6000);
    }
    public void searchJp (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Nhật')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(6000);
    }
    public void searchDe (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Đức')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(6000);
    }
    public void searchUk (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Anh')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(6000);
    }
    public void searchAu (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Úc')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(6000);
    }
    public void searchStore (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//*[@class='search-from-dropdown mz-dropdown']/div[1]").click();
        Browser.find(How.XPATH,"//a[contains(text(),'Từ Gian hàng')]").click();
        Browser.fill(How.CLASS_NAME,"mz-header-vsearch__keyword-input",keyWord);
        Browser.find(How.XPATH,"//i[@class='fal fa-search']").click();
        Thread.sleep(6000);
    }

    public boolean checkSearch (String country) {
        switch (country.toLowerCase()) {
            case "us": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-result-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Mỹ')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__title'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "jp": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-result-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Nhật')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__title'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "de": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-result-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Đức')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__title'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "uk": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-result-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Anh')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__title'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "au":{
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-result-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Úc')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='search-fail-block__title'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "store":{
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-result-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Gian hàng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//*[@class='my-alert__info-col'][contains(text(),'Không tìm thấy')]").size() > 0);
            }
            case "all": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-result-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Mỹ')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Đức')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Nhật')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Anh')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//span[@class='search-country-label'][contains(text(),'Gian hàng')]").size() > 0);
            }
            default:
                throw new IllegalStateException("country ko dung: " + country);
        }
    }

    public boolean checkPrice () {
        return ((Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[1]//*[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[2]//*[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[3]//*[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[4]//*[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[5]//*[contains(text(),'Không hỗ trợ')]").size() > 0) ||
                        (Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[1]//*[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[2]//*[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[3]//*[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[4]//*[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[5]//*[contains(text(),'báo giá')]").size() > 0) ||
                        (Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[1]//*[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[2]//*[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[3]//*[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[4]//*[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='success-search-section']/div[1]//div[@class='search-product-item-row']/div[5]//*[contains(text(),'Đang cập nhật')]").size() > 0));
    }
}



