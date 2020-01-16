package modules;
import libraries.TodoFunctions;
import org.apache.http.util.Asserts;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import supports.Browser;

public class TodoMVCTest {
    public static TodoFunctions todoPage;

    @BeforeMethod
    public static void preConditions(){
        Browser.open("chrome");
        //todoPage = new TodoFunctions();
        Browser.get("http://todomvc.com/examples/vanillajs");
    }

    @Test (description = "create new todo")
    public static void addNewTask () throws InterruptedException {
        todoPage.createNewTodo("to do 1");
        String numberTaskAfter = todoPage.countRemain();
        Assert.assertEquals(numberTaskAfter,"1");
        //Thread.sleep(1000);
    }

    @Test (description = "delete todo")
    public static void deleteTask () throws InterruptedException {
        todoPage.createNewTodo("to do 1");
        Thread.sleep(1000);
        todoPage.deleteTodo("to do 1");
        String numberTaskAfter = todoPage.countRemain();
        Assert.assertEquals(numberTaskAfter,"");
        //Thread.sleep(1000);
    }

    @AfterMethod
    public static void postConditions (){
        Browser.close();
    }
}
