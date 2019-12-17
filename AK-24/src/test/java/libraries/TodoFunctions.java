package libraries;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browser;

import java.util.List;

public class TodoFunctions {
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

    public void createNewTodo (String taskName){
        Browser.fill(How.CLASS_NAME,"new-todo",taskName + "\n");
    }
    public void editTodoName (String oldName, String newName){
        String todo = String.format("//label[.='%s']",oldName);
        if (isTodoExisted(oldName)) {
        Browser.doubleClick(How.XPATH,todo);
        Browser.fill(How.XPATH,todo + "/../../input",newName + "\n");
        }
        else System.out.println("ko co " + oldName);
    }
    public void deleteTodo(String taskName){
        String todo = String.format("//label[.='%s']",taskName);
        if (isTodoExisted(taskName)) {
            Browser.hover(How.XPATH, todo);
            Browser.find(How.XPATH, todo + "/following-sibling::button").click();
        }
        else System.out.println("ko co " + taskName);
    }
    public boolean isTodoExisted (String taskName){
        String todo = String.format("//label[.='%s']",taskName);
        if (Browser.findall(How.XPATH, todo).size()>0) return true;
        else return false;
    }
    public List<WebElement> getTodo(String taskName){
        return Browser.findall(How.XPATH,String.format("//label[.='%s']", taskName));
    }
}
