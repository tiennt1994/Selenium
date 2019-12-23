package modules;
import libraries.TodoFunctions;
import org.apache.http.util.Asserts;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import supports.Browser;

public class TodoMVCTest {
    public static TodoFunctions todoPage;

    @BeforeClass
    public static void setUp(){
        Browser.open("chrome");
    }

    @BeforeMethod
    public static void preConditions(){
        todoPage = new TodoFunctions();
        Browser.get("http://todomvc.com/examples/vanillajs/");
    }

    @Test(description = "create new todo")
    public static void addNewTask () {
        //TodoFunctions todoPage = new TodoFunctions();
        todoPage.createNewTodo("to do 1");
        int numberTaskAfter = todoPage.countRemain();
        Assert.assertEquals(numberTaskAfter,1);

    }

    @AfterClass
    public static void postConditions (){
        Browser.close();
    }
}
