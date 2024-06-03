package Sample.Controller;

import Sample.Model.User;
import Sample.View.LoginMenu;
import Sample.View.ProfileMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label username;

    public void initialize() {
        username.setText("Hello, " + User.getUserLoginIn().getUsername() + "!");
    }

    public void startNewGame() throws Exception {

    }

    public void continueGame() throws Exception {

    }

    public void goToScoreBoard() throws Exception {

    }

    public void goToSettingMenu() throws Exception {

    }

    public void backToLoginMenu() throws Exception {
        if (User.getUserLoginIn().getUsername().equals("Guest")) {
            User.getUsers().remove(User.getUserLoginIn());
        }
        User.setUserLoginIn(null);
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(ApplicationController.getStage());
    }

    public void goToProfileMenu() throws Exception {
        if (User.getUserLoginIn().getUsername().equals("Guest")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Impossible action");
            alert.setHeaderText("You do not have an account");
            alert.setContentText("Your entry to the profile menu is not possible");
            alert.show();
            return;
        }
        ProfileMenu profileMenu = new ProfileMenu();
        profileMenu.start(ApplicationController.getStage());
    }
}

