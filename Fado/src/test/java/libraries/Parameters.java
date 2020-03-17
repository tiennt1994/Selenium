package libraries;

import org.testng.annotations.DataProvider;

public class Parameters {
    @DataProvider(name="data_provider")
    public static Object [][] dataProviderMethod(){
        return new Object[][] {{"hot toys"}, {"book"}};
    }
}
