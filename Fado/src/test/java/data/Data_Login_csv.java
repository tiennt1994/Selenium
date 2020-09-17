package data;

import org.testng.annotations.DataProvider;
import supports.BasicCsvReader;

import java.io.IOException;
import java.lang.reflect.Method;


public class Data_Login_csv {

    @DataProvider(name="data_login1")
    public Object [][] dataProviderMethod(String username, String password) {

        Object[][] data = null;
        data = new Object[][]{{username, password}};
        return data;
    }
}
