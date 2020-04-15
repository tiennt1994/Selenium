package data;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class Data_Login {
    @DataProvider(name="data_login")
    public Object [][] dataProviderMethod(Method method){
        Object [][] data = null;
        switch (method.getName()) {
            case "TC01_loginSuccess":
                data = new Object[][]{{"tiennumber1@gmail.com", "123456"}};
                break;
            case "TC02_loginSuccess":
                data = new Object[][]{{" tiennumber1@gmail.com ", "123456"}};
                break;
            case "TC03_loginFailNullData":
                data = new Object[][]{{"", ""}};
                break;
            case "TC04_loginFailNullUsername":
                data = new Object[][]{{"", "123456"}};
                break;
            case "TC05_loginFailNullPassword":
                data = new Object[][]{{"tiennt@miczone.vn", ""}};
                break;
            case "TC06_loginFailWrongUsername":
                data = new Object[][]{{"tiennt12@miczone.vn", "123456"}};
                break;
            case "TC07_loginFailWrongPassword":
                data = new Object[][]{{"tiennumber1@gmail.com", "1234567"}};
                break;
        }
        return data;
    }
}