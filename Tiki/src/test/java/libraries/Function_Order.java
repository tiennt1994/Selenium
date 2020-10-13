package libraries;

import org.openqa.selenium.support.How;
import supports.Browser;

public class Function_Order {
    public void addCart () {
        Browser.scrollByElement(How.XPATH,"//button[@class='btn btn-add-to-cart']");
        Browser.waitForElement(5,"//button[@class='btn btn-add-to-cart']");
        Browser.find(How.XPATH,"//button[@class='btn btn-add-to-cart']").click();
        Browser.waitForElement(5,"//*[@class='btn-view-cart']");
        Browser.find(How.XPATH,"//*[@class='btn-view-cart']").click();
    }

    public boolean checkAddCartSuccess () {
        return (Browser.findAll(How.XPATH, "//li[@class='cart-products__product']").size()>0);
    }
}
