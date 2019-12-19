package modules;
import libraries.TodoFunctions;
import org.apache.http.util.Asserts;
import org.openqa.selenium.support.How;
import supports.Browser;

public class TodoMVCTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.get("http://todomvc.com/examples/vanillajs");
        TodoFunctions todoPage = new TodoFunctions();
        todoPage.createNewTodo("to do 1");
        todoPage.createNewTodo("to do 1");
        todoPage.createNewTodo("to do 2");
        todoPage.createNewTodo("to do 3");
        todoPage.createNewTodo("to do 4");
        //todoPage.editTodoName("to do 2","to do moi");
        todoPage.deleteTodo("to do 4");
        todoPage.markDone("to do 1");
        todoPage.showAll();

    }
}
