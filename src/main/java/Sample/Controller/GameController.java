package Sample.Controller;

import Sample.Model.GameBattleField;
import Sample.Model.User;

import java.util.regex.Matcher;

public class GameController {
    private GameBattleField gameBattleField;
    private User user;
    private static GameController controller;

    public static GameController getInstance() {
        if (controller == null) {
            controller = new GameController();
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
        return "GameMenu";
    }

    public String showFactions() {
        return null;
    }

    public String createGame() {
        return null;
    }


    public String selectFaction(Matcher matcher) {
        return null;
    }

    public String showCards() {
        return null;

    }

    public String showDeck() {
        return null;

    }

    public String showCurrentUserInfo() {
        return null;
    }

    public String saveDeckByFile(Matcher matcher) {
        return null;
    }
    public String saveDeckByName(Matcher matcher) {
        return null;
    }

    public String loadDeckByFile(Matcher matcher) {
        return null;

    }
    public String loadDeckByName(Matcher matcher) {
        return null;

    }

    public String showLeaders() {
        return null;

    }

    public String selectLeader(Matcher matcher) {
        return null;

    }


    public void addToDeck(Matcher matcher) {

    }

    public void deleteFromDeck(Matcher matcher) {
    }

    public String changeTurn() {
        return null;
    }

    public String startGame() {
        return null;

    }
    public void endGame() {
        // Save game state and user data when the game ends
        gameBattleField.saveGameState("src/main/resources/gameState.json");
        user.saveUserData("src/main/resources/userData.json");
    }

    public void loadGame() {
        // Load game state and user data when starting the game
        gameBattleField = GameBattleField.loadGameState("src/main/resources/gameState.json");
        user = User.loadUserData("src/main/resources/userData.json");
    }
}
