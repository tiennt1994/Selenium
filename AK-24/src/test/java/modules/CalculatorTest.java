package modules;

import libraries.BmiFunctions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class CalculatorTest {
    public BmiFunctions bmiPage = new BmiFunctions();

    @BeforeMethod
    public void preConditions(){
        Browser.open("chrome");
        Browser.get("https://www.calculator.net/bmi-calculator.html");
    }

    @Test
    public void Test (){
        bmiPage.selectMetricTab();
        bmiPage.fillForm("25","male","178","80");
        bmiPage.shouldHaveResult("BMI = 25.2 kg/m2   (Overweight)");
    }

    @AfterMethod
    public void postConditions (){
        Browser.close();
    }
}
