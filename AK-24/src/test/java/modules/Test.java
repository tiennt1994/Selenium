package modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //logInSuccess();
        //logInNull();
        //logInWrongPassword();
        logInWrongEmail();
    }
    public static void logInSuccess () {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://fado.vn/dang-nhap");
        Browser.fill(How.NAME,"email", "tiennt@miczone.vn");
        Browser.fill(How.NAME,"password", "tien2653084");
        Browser.find(How.XPATH, "//button[.='Đăng nhập']").click();
    }
    public static void logInNull () throws InterruptedException {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://fado.vn/dang-nhap");
        Browser.fill(How.NAME,"email", "");
        Browser.fill(How.NAME,"password", "");
        Browser.find(How.XPATH, "//button[.='Đăng nhập']").click();
        Thread.sleep(2000);
        WebElement message1 = Browser.find(How.ID,"email-error");
        WebElement message2 = Browser.find(How.ID, "password-error");
        //message.isDisplayed();
        if (message1.getText().trim().equals("Vui lòng nhập dữ liệu") && message2.getText().trim().equals("Vui lòng nhập dữ liệu")){
            System.out.println("pass");
        }
        else System.out.println("fail");
    }
    public static void logInWrongPassword () throws InterruptedException {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://fado.vn/dang-nhap");
        Browser.fill(How.NAME,"email", "tiennt@miczone.vn");
        Browser.fill(How.NAME,"password", "2653084");
        Browser.find(How.XPATH, "//button[.='Đăng nhập']").click();
        Thread.sleep(2000);
        WebElement error_message = Browser.find(How.XPATH,"//div[@class='my-alert -alert-danger']");
        if (error_message.getText().trim().equals("Có lỗi xảy ra:\n" +
                "- Mật khẩu không đúng, vui lòng kiểm tra lại")){
            System.out.println("pass");
        }
        else System.out.println("fail");
    }
    public static void logInWrongEmail () throws InterruptedException {
        Browser.open("chrome");
        Browser.maximize();
        Browser.get("https://fado.vn/dang-nhap");
        Browser.fill(How.NAME,"email", "tiennt1@miczone.vn");
        Browser.fill(How.NAME,"password", "tien2653084");
        Browser.find(How.XPATH, "//button[.='Đăng nhập']").click();
        Thread.sleep(2000);
        WebElement error_message = Browser.find(How.XPATH,"//b[@class='font--size-lg']");
        if (error_message.getText().trim().equals("Có lỗi xảy ra:")){
            System.out.println("pass");
        }
        else System.out.println("fail");
    }
}
