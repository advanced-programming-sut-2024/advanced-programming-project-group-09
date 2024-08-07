package Sample.Controller;

import Sample.Model.User;
import Sample.View.LeaderMenu;
import Sample.View.LoginMenu;
import Sample.View.ProfileMenu;
import Sample.View.StartNewGameMenu;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class MainController {
    @FXML
    private Label username;

    public void initialize() {
        username.setText("Hello, " + User.getUserLoginIn().getUsername() + "!");
    }

    public void startNewGame() throws Exception {
//        if (ServerUser.getUserLoginIn().getCommonCardsInDeck().size() < 22 || ServerUser.getUserLoginIn().getSpecialCardsInDeck().size() > 10) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Unacceptable deck");
//            alert.setHeaderText("Change your deck via the deck menu");
//            alert.setContentText("This deck is unacceptable for entry into the game");
//            alert.showAndWait();
//            return;
//        }
        StartNewGameMenu startNewGameMenu = new StartNewGameMenu();
        startNewGameMenu.start(ApplicationController.getStage());
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
            alert.showAndWait();
            return;
        }
        ProfileMenu profileMenu = new ProfileMenu();
        profileMenu.start(ApplicationController.getStage());
    }

    public void setMouseImage(MouseEvent mouseEvent) {
        Image cursor = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/cursor.png")));
        username.getScene().setCursor(new ImageCursor(cursor));
    }

    public void goToLeaderMenu(MouseEvent mouseEvent) throws Exception {
        LeaderMenu leaderMenu = new LeaderMenu();
        leaderMenu.start(ApplicationController.getStage());
    }

    public void goToDeckMenu(MouseEvent mouseEvent) {

    }
}

