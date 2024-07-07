package Sample;

import Sample.Network.Server.model.User;
import Sample.Network.Client.view.UserAndGameMenus.LoginMenu;

public class Main {
    public static void main(String[] args) {
        User.loadUsers();

        if (User.getUsers().isEmpty()) {
            User user = new User("tom", "123", "", "");
            User.saveUsers();
        }

        LoginMenu.main(args);
    }
}
