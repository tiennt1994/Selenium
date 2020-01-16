package modules;

import configuration.BaseTest;
import libraries.BmiFunctions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import supports.Browser;

public class CalculatorTest extends BaseTest {
    public BmiFunctions bmiPage;

    @BeforeClass
    public void setUp() {
        bmiPage = new BmiFunctions();
        bmiPage.load();
        bmiPage.selectMetricTab();
    }

    @DataProvider (name = "BmiData")
    public Object[][] testData (){
        return new Object[][] {
                {"25","male","178","80","BMI = 25.2 kg/m2   (Overweight)"},
                //{"25","male","178","70","BMI = 25.2 kg/m2   (Overweight)"},
                //{"25","male","178","60","BMI = 25.2 kg/m2   (Overweight)"},
                //{"25","male","178","50","BMI = 25.2 kg/m2   (Overweight)"},
                //{"25","male","178","40","BMI = 25.2 kg/m2   (Overweight)"},
        };
    }

    @Test(dataProvider = "BmiData")
    public void TC01 (String age, String gender, String height, String weight, String expectedResult){
        bmiPage.selectMetricTab();
        bmiPage.fillForm(age, gender, height, weight);
        bmiPage.shouldHaveResult(expectedResult);
    }

}
