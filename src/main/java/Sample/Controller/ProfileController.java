package Sample.Controller;

import java.util.regex.Matcher;

public class ProfileController {
    private static ProfileController controller;

    public static ProfileController getInstance() {
        if (controller == null) {
            controller = new ProfileController();
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
        return "ProfileMenu";
    }

    public String changeUsername(Matcher matcher) {
        return null;
    }

    public String changeNickName(Matcher matcher) {
        return null;
    }

    public String changeEmail(Matcher matcher) {
        return null;
    }

    public String changePassword(Matcher matcher) {
        return null;
    }

    public String displayUserInfo() {
        // Display user's current information
        return null;
    }

    public String displayGameHistory(Matcher matcher) {
        // Validate number and display last n games
        return null;
    }
}
