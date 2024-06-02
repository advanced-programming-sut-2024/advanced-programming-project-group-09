package Sample.Controller;

import java.util.regex.Matcher;

public class MainController {
    private static MainController controller;

    public static MainController getInstance() {
        if (controller == null) {
            controller = new MainController();
        }
        return controller;
    }

    public String enterMenu() {
        return null;
    }

    public String exitMenu() {
        return null;
    }

    public String showCurrentMenu() {
        return "MainMenu";
    }

    public String logout() {
        return null;
    }

    public String goToProfileMenu() {
        return null;
    }

    public String goToGameMenu() {
        return null;
    }

    public String createGame(Matcher matcher) {

        return  null;
    }


}
