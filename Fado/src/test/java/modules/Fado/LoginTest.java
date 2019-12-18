package modules.Fado;

import libraries.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        //logInSuccess();
        //logInNull();
        logInWrongPassword();
        //logInWrongEmail();
    }
    public static void logInSuccess () throws InterruptedException {
        Functions test = new Functions();
        test.login("tiennt@miczone.vn","tien2653084");
    }
    public static void logInNull () throws InterruptedException {
        Functions test = new Functions();
        test.login("","");
        WebElement message1 = Browser.find(How.ID,"email-error");
        WebElement message2 = Browser.find(How.ID, "password-error");
        //message.isDisplayed();
        if (message1.getText().trim().equals("Vui lòng nhập dữ liệu") && message2.getText().trim().equals("Vui lòng nhập dữ liệu")){
            System.out.println("pass");
        }
        else System.out.println("fail");
    }
    public static void logInWrongPassword () throws InterruptedException {
        Functions test = new Functions();
        test.login("tiennt@miczone.vn","123456");
        WebElement error_message = Browser.find(How.XPATH,"//div[@class='my-alert -alert-danger']");
        if (error_message.getText().trim().equals("Có lỗi xảy ra:\n" +
                "- Mật khẩu không đúng, vui lòng kiểm tra lại")){
            System.out.println("pass");
        }
        else System.out.println("fail");
    }
    public static void logInWrongEmail () throws InterruptedException {
        Functions test = new Functions();
        test.login("tiennt1@miczone.vn","tien2653084");
        WebElement error_message = Browser.find(How.XPATH,"//b[@class='font--size-lg']");
        if (error_message.getText().trim().equals("Có lỗi xảy ra:")){
            System.out.println("pass");
        }
        else System.out.println("fail");
    }
}
