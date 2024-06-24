package Sample;

import Sample.Model.User;
import Sample.View.LoginMenu;

public class Main {
    public static void main(String[] args) {
        User user = new User("tom", "123", "", "");
        LoginMenu.main(args);
    }
}