package data;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class Data_Login {
    @DataProvider(name="data_login")
    public Object [][] dataProviderMethod(Method method){
        Object [][] data = null;
        if (method.getName().equals("loginSuccess")) {
            data = new Object[][] {{"tiennt@miczone.vn", "tien2653084"},
                    {"tiennumber1@gmail.com", "123456"}};
        }
        else if (method.getName().equals("loginFailNullData")) {
            data = new Object[][] {{"", ""}};
        }
        return data;
    }
}
