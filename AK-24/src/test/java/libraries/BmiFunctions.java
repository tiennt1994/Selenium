package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import supports.Browser;

public class BmiFunctions extends LoadableComponent <BmiFunctions> {
    /**
     * Txt --> text field
     * Rad --> radio button
     * Btn --> button
     * Lbl --> label
     */
    private  By metricTab = By.xpath("//a[.='Metric Units']");
    private  By ageTxt = By.xpath("//input[@name='cage']");
    private  By maleRad = By.xpath("//label[.='Male']//span");
    private  By femaleRad = By.xpath("//label[.='Female']//span");
    private  By heightTxt = By.xpath("//input[@name='cheightmeter']");
    private  By weightTxt = By.xpath("//input[@name='ckg']");
    private  By calculatorBtn = By.xpath("//input[@value='Calculate']");
    private  By resultLbl = By.xpath("//div[@class='bigtext']");

    @Override
    protected void load() {
        Browser.open("https://www.calculator.net/bmi-calculator.html");
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void selectMetricTab() {
        Browser.find(metricTab).click();
    }

    public void fillForm (String age, String gender, String height, String weight){
        Browser.fill(ageTxt,age);
        if (gender.equalsIgnoreCase("male")) Browser.find(maleRad).click();
        else Browser.find(femaleRad).click();
        Browser.fill(heightTxt,height);
        Browser.fill(weightTxt,weight);
        Browser.find(calculatorBtn).click();
    }

    public void shouldHaveResult(String expected){
        String result = Browser.getText(resultLbl);
        Assert.assertEquals(result, expected);
    }
}
