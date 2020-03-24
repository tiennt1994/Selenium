package libraries;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.How;
import supports.Browser;

public class Functions_MobileSearch {
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
        // close popup nhan diem
        //if (isExisted("//div[@id='regist-get-point-modal__form-block']/button[1]")){
        //    Browser.find(How.XPATH,"//div[@id='regist-get-point-modal__form-block']/button[1]").click();
        //}
    }

    public void searchMobile (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//div[@class='search-segment']//input[@class='search-form__keyword-input']").click();
        Browser.waitForElement(20,"//div[@class='search-segment']//input[@class='search-form__keyword-input']");
        Browser.fill(How.XPATH,"//div[@class='mz-basic-sheet__inner is-show']//input[@class='search-form__keyword-input']",keyWord);
        Browser.find(How.XPATH,"//div[@class='mz-basic-sheet__inner is-show']//input[@class='search-form__keyword-input']").sendKeys(Keys.ENTER);
        Thread.sleep(6000);
    }

    public boolean checkSearchMobile (String country) {
        switch (country.toLowerCase()) {
            case "us": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Mỹ')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='alert-content'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "jp": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Nhật')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='alert-content'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "de": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Đức')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='alert-content'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "uk": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Anh')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='alert-content'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "au":{
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Úc')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='alert-content'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "store":{
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Gian hàng')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='alert-content'][contains(text(),'Rất tiếc')]").size() > 0);
            }
            case "all": {
                return (Browser.findAll(How.XPATH, "//div[@class='all-empty-content']").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Mỹ')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Nhật')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Đức')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Anh')]").size() > 0 ||
                        Browser.findAll(How.XPATH, "//div[@class='empty-country-product-field']//*[contains(text(),'Gian hàng')]").size() > 0);
            }
            default:
                throw new IllegalStateException("country ko dung: " + country);
        }
    }

    public boolean checkPriceMobile () {
        return ((Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[1]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[2]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[3]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[4]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[5]//div[contains(text(),'Không hỗ trợ')]").size() > 0) ||
                        (Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[1]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[2]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[3]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[4]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[5]//div[contains(text(),'báo giá')]").size() > 0) ||
                        (Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[1]//div[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[2]//div[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[3]//div[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[4]//div[contains(text(),'Đang cập nhật')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//div[@class='search-result-section-inner is-show']/div[2]/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[5]//div[contains(text(),'Đang cập nhật')]").size() > 0));
    }
}
