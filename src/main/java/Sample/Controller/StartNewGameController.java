package Sample.Controller;

import Sample.Model.GameBattleField;
import Sample.Model.User;
import Sample.View.GameMenu;
import Sample.View.LeaderMenu;
import Sample.View.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class StartNewGameController {
    @FXML
    private TextField usernameInput;

    public void startNewGameWithUsername(MouseEvent mouseEvent) throws Exception {
        String competitorUsername = usernameInput.getText();
//        if (competitorUsername.equals(User.getUserLoginIn().getUsername())) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Invalid username");
//            alert.setHeaderText("You cannot enter the game with yourself");
//            alert.setContentText("Please do not enter your username");
//            alert.showAndWait();
//            return;
//        }
//        if (User.getUserByUsername(competitorUsername) == null) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Invalid username");
//            alert.setHeaderText("There is no such user in the system");
//            alert.setContentText("The absence of such a user");
//            alert.showAndWait();
//            return;
//        }
//        User competitor = User.getUserByUsername(competitorUsername);
//        User.getUserLoginIn().setCompetitor(competitor);
//        assert competitor != null;
//        competitor.setCompetitor(User.getUserLoginIn());
//        User.setUserLoginIn(competitor);
        User user1 = User.getUserByUsername("tom");
        User user2 = User.getUserByUsername("alex");
        GameBattleField gameBattleField = new GameBattleField(user2, user1);
        user1.setLastGameBattleField(gameBattleField);
        user2.setLastGameBattleField(gameBattleField);
        GameMenu gameMenu = new GameMenu();
        gameMenu.start(ApplicationController.getStage());
//        LeaderMenu leaderMenu = new LeaderMenu();
//        leaderMenu.start(ApplicationController.getStage());
    }

    public void backToMainMenu() throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
    }
}

