package modules.Example;

import supports.Browser;

public class BasicAuth {
    public static void main(String[] args) {
        Browser.open("chrome");
        //chen username password vao trong url
        Browser.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
