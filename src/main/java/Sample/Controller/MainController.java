package Sample.Controller;

import Sample.Model.User;
import Sample.View.FactionMenu;
import Sample.View.LoginMenu;
import Sample.View.ProfileMenu;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class MainController {
    private GameController gameController = new GameController();
    @FXML
    private Label username;

    public void initialize() {
        username.setText("Hello, " + User.getUserLoginIn().getUsername() + "!");
        gameController.loadGame();
    }

    public void startNewGame() throws Exception {

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

    public void setMouseImage(MouseEvent mouseEvent) {
        Image cursor = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/cursor.png")));
        username.getScene().setCursor(new ImageCursor(cursor));
    }

    public void goToFactionMenu(MouseEvent mouseEvent) throws Exception {
        FactionMenu factionMenu = new FactionMenu();
        factionMenu.start(ApplicationController.getStage());
    }

    public void goToDeckMenu(MouseEvent mouseEvent) {

    }
}

