package Sample.Controller;

import Sample.CardEnums.Faction;
import Sample.Model.GameBattleField;
import Sample.Model.User;
import Sample.View.LeaderMenuForCompetitor;
import Sample.View.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Random;

public class StartNewGameController {
    @FXML
    private TextField usernameInput;

    public void startNewGameWithUsername() throws Exception {
        String competitorUsername = usernameInput.getText();
        if (competitorUsername.equals(User.getUserLoginIn().getUsername())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("You cannot enter the game with yourself");
            alert.setContentText("Please do not enter your username");
            alert.showAndWait();
            return;
        }
        if (User.getUserByUsername(competitorUsername) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("There is no such user in the system");
            alert.setContentText("The absence of such a user");
            alert.showAndWait();
            return;
        }
        User user1 = User.getUserLoginIn();
        User competitor = User.getUserByUsername(competitorUsername);
        User.getUserLoginIn().setCompetitor(competitor);
        assert competitor != null;
        competitor.setCompetitor(User.getUserLoginIn());
        User.setUserLoginIn(competitor);

        Random random = new Random();
        GameBattleField gameBattleField;
        if (user1.getFactionSelected().equals(Faction.Scoiatael) && competitor.getFactionSelected().equals(Faction.Scoiatael)) {
            boolean isFirst = random.nextBoolean();
            if (isFirst) {
                gameBattleField = new GameBattleField(user1, competitor);
            }
            else {
                gameBattleField = new GameBattleField(competitor, user1);
            }
            user1.setLastGameBattleField(gameBattleField);
            competitor.setLastGameBattleField(gameBattleField);
        } else if (user1.getFactionSelected().equals(Faction.Scoiatael)) {
            gameBattleField = new GameBattleField(user1, competitor);
            user1.setLastGameBattleField(gameBattleField);
            competitor.setLastGameBattleField(gameBattleField);
        } else if (competitor.getFactionSelected().equals(Faction.Scoiatael)) {
            gameBattleField = new GameBattleField(competitor, user1);
            user1.setLastGameBattleField(gameBattleField);
            competitor.setLastGameBattleField(gameBattleField);
        } else {
            boolean isFirst = random.nextBoolean();
            if (isFirst) {
                gameBattleField = new GameBattleField(user1, competitor);
            }
            else {
                gameBattleField = new GameBattleField(competitor, user1);
            }
            user1.setLastGameBattleField(gameBattleField);
            competitor.setLastGameBattleField(gameBattleField);
        }
        user1.getAllGameBattleField().add(gameBattleField);
        competitor.getAllGameBattleField().add(gameBattleField);

        LeaderMenuForCompetitor leaderMenuForCompetitor = new LeaderMenuForCompetitor();
        leaderMenuForCompetitor.start(ApplicationController.getStage());
    }

    public void backToMainMenu() throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
    }
}

