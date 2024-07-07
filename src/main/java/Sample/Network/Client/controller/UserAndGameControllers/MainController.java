package Sample.Network.Client.controller.UserAndGameControllers;

import Sample.CardEnums.Faction;
import Sample.Network.Client.model.User.User;
import Sample.Network.Client.view.UserAndGameMenus.ChooseCard.*;
import Sample.Network.Client.view.UserAndGameMenus.LeaderMenu;
import Sample.Network.Client.view.UserAndGameMenus.LoginMenu;
import Sample.Network.Client.view.UserAndGameMenus.ProfileMenu;
import Sample.Network.Client.view.UserAndGameMenus.StartNewGameMenu;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.util.Objects;

public class MainController {
    @FXML
    private Label username;

    public void initialize() {
        username.setText("Hello, " + User.getUserLoginIn().getUsername() + "!");
    }

    public void startNewGame() throws Exception {
        // Perform necessary network checks for the deck before starting a new game
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

    public void setMouseImage() {
        Image cursor = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/cursor.png")));
        username.getScene().setCursor(new ImageCursor(cursor));
    }

    public void goToLeaderMenu() throws Exception {
        LeaderMenu leaderMenu = new LeaderMenu();
        leaderMenu.start(ApplicationController.getStage());
    }

    public void goToDeckMenu() throws Exception {
        Faction factionSelected = User.getUserLoginIn().getFactionSelected();
        switch (factionSelected) {
            case Skellige -> {
                ChooseCardSkelligeTest chooseCardSkelligeTest = new ChooseCardSkelligeTest();
                chooseCardSkelligeTest.start(ApplicationController.getStage());
            }
            case Monsters -> {
                ChooseCardMonsterTest chooseCardMonsterTest = new ChooseCardMonsterTest();
                chooseCardMonsterTest.start(ApplicationController.getStage());
            }
            case NorthernRealms -> {
                ChooseCardNorthernRealmsTest chooseCardNorthernRealmsTest = new ChooseCardNorthernRealmsTest();
                chooseCardNorthernRealmsTest.start(ApplicationController.getStage());
            }
            case Scoiatael -> {
                ChooseCardScoiaTaelTest chooseCardScoiaTaelTest = new ChooseCardScoiaTaelTest();
                chooseCardScoiaTaelTest.start(ApplicationController.getStage());
            }
            case Nilfgaard -> {
                ChooseCardNilfGaardianTest chooseCardNilfGaardianTest = new ChooseCardNilfGaardianTest();
                chooseCardNilfGaardianTest.start(ApplicationController.getStage());
            }
        }
    }

    public static User getCurrentUser() {
        return User.getUserLoginIn();
    }
}
