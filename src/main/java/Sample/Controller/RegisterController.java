package Sample.Controller;

import java.util.regex.Matcher;

public class RegisterController {
    private static RegisterController controller;

    public String registerUser(Matcher matcher) {
        return null;
    }

    public String enterMenu() {
        return null;
    }

    public String exitMenu() {
        return null;
    }

    public String showCurrentMenu() {
        return "LoginAndRegisterMenu";
    }

    public static RegisterController getInstance() {
        if (controller == null) {
            controller = new RegisterController();
        }
        return controller;
    }
}
