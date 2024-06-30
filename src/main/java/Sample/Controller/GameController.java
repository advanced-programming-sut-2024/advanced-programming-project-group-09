package Sample.Controller;

import Sample.Model.GameBattleField;
import Sample.Model.User;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GameController {
    @FXML
    private AnchorPane pane;
    @FXML
    private GridPane myHandCards;
    @FXML
    private GridPane myCloseCombatCardsPlayed;
    @FXML
    private GridPane myRangedCombatCardsPlayed;
    @FXML
    private GridPane mySiegeCardsPlayed;
    @FXML
    private GridPane competitorCloseCombatCardsPlayed;
    @FXML
    private GridPane competitorRangedCombatCardsPlayed;
    @FXML
    private GridPane competitorSiegeCardsPlayed;
    private GameBattleField gameBattleField;
    private User user;

    public void initialize() {

    }

}
