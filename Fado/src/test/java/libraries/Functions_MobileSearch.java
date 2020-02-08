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

    public void search (String keyWord) throws InterruptedException {
        Browser.find(How.XPATH,"//div[@class='search-segment']//input[@class='search-form__keyword-input']").click();
        Thread.sleep(1000);
        Browser.fill(How.XPATH,"//div[@class='mz-basic-sheet__inner is-show']//input[@class='search-form__keyword-input']",keyWord);
        Browser.find(How.XPATH,"//div[@class='mz-basic-sheet__inner is-show']//input[@class='search-form__keyword-input']").sendKeys(Keys.ENTER);
        Thread.sleep(4000);
    }

    public boolean checkPrice () {
        return ((Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[1]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[2]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[3]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[4]//div[contains(text(),'Không hỗ trợ')]").size() > 0 &&
                Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[5]//div[contains(text(),'Không hỗ trợ')]").size() > 0) ||
                (Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[1]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[2]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[3]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[4]//div[contains(text(),'báo giá')]").size() > 0 &&
                        Browser.findAll(How.XPATH, "//*[@class='search-result-section']/div/div[1]//div[@class='mz-slider-grid-row mz-slider-grid-row-full-container']/div[5]//div[contains(text(),'báo giá')]").size() > 0));
    }
}
