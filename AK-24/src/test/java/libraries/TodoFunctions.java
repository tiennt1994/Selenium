package libraries;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import objects.TodoObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;
import supports.Browser;

import java.util.List;

public class TodoFunctions extends TodoObjects {
    /**
     * perform manual tests -> define common functions -> get locator objects
     * 1. creat new to do
     * 2. update name
     * 3. mark done
     * 4. delete
     * 5. show all to do
     * 6. show active to do
     * 7. show completed to do
     * 8. clear completed to do
     * 9. count remain active to do
     * 10. check existing to do
     * 11. get to do
     */

    public void createNewTodo(String taskName) {
        Browser.fill(NEW_TODO_TXT, taskName + "\n");
    }

    public void editTodoName(String oldName, String newName) {
        if (isTodoExisted(oldName)) {
            Browser.doubleClick(getTask(oldName));
            Browser.fill(updateTask(oldName),newName + "\n");
        } else System.out.println("ko co " + oldName);
    }

    public void deleteTodo(String taskName) {
        while (isTodoExisted(taskName)) {
            Browser.hover(getTask(taskName));
            Browser.find(deleteTask(taskName)).click();
        }
    }

    public boolean isTodoExisted(String taskName) {
        if (Browser.findAll(getTask(taskName)).size() > 0) return true;
        else return false;
    }

    public List<WebElement> getTodo(String taskName) {
        return Browser.findAll(getTask(taskName));
    }

    public void markDone(String taskName) {
        String todo = String.format("//label[.='%s']", taskName);
        if (isTodoExisted(taskName)) {
            Browser.find(markDoneTask(taskName)).click();
        } else System.out.println("ko co " + taskName);
    }

    public void showAll() {
        Browser.find(SHOW_ALL_LINK).click();
        List<WebElement> todo = Browser.findAll(How.XPATH, "//div[@class='view']//label");
        System.out.println("Tong so todo: " + todo.size());
        for (int i = 0; i < todo.size(); i++) {
            System.out.println(todo.get(i).getText());
        }
    }

    public void showActive() {
        Browser.find(SHOW_ACTIVE_LINK).click();
        List<WebElement> todo = Browser.findAll(How.XPATH, "//div[@class='view']//label");
        System.out.println("Tong so todo: " + todo.size());
        for (int i = 0; i < todo.size(); i++) {
            System.out.println(todo.get(i).getText());
        }
    }

    public void showCompleted() {
        Browser.find(SHOW_COMPLETED_LINK).click();
        List<WebElement> todo = Browser.findAll(How.XPATH, "//div[@class='view']//label");
        System.out.println("Tong so todo: " + todo.size());
        for (int i = 0; i < todo.size(); i++) {
            System.out.println(todo.get(i).getText());
        }
    }

    public void clearCompleted() {
        Browser.find(CLEAR_COMPLETED_TASKS_BTN).click();
    }

    public String countRemain() {
        return Browser.getText(REMAIN_TASK_LBL);
    }
}
