package Sample.Network.Client.controller.UserControllers;

import Sample.Network.Client.model.User.User;
import Sample.Network.Client.view.UserMenus.MainMenu;

public class MainController {
    public static User currentUser;
    public MainMenu menu;

    public MainController(User user, MainMenu menu) {
        currentUser = user;
        this.menu = menu;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}