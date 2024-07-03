package Sample.Controller;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;
import Sample.Model.GameBattleField;
import Sample.Model.User;
import Sample.View.LoginMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Objects;

public class GameController {
    @FXML
    private ImageView myLeader;
    @FXML
    private ImageView competitorLeader;
    @FXML
    private Label secondPlayerPassedLabel;
    @FXML
    private Label firstPlayerPassedLabel;
    @FXML
    private ImageView firstPlayerCrown;
    @FXML
    private ImageView secondPlayerCrown;
    @FXML
    private Label secondPlayerScore;
    @FXML
    private Label firstPlayerScore;
    @FXML
    private ImageView secondPlayerSecondLifeImageView;
    @FXML
    private ImageView firstPlayerSecondLifeImageView;
    @FXML
    private ImageView secondPlayerFirstLifeImageView;
    @FXML
    private ImageView firstPlayerFirstLifeImageView;
    @FXML
    private Label secondPlayerInHand;
    @FXML
    private Label firstPlayerInHand;
    @FXML
    private Label secondPlayerFaction;
    @FXML
    private Label firstPlayerFaction;
    @FXML
    private Label secondPlayerUsername;
    @FXML
    private Label firstPlayerUsername;
    @FXML
    private ImageView secondPlayerShield;
    @FXML
    private ImageView firstPlayerShield;
    @FXML
    private AnchorPane pane;
    @FXML
    private HBox myHandCards;
    @FXML
    private HBox myCloseCombatCardsPlayed;
    @FXML
    private HBox myRangedCombatCardsPlayed;
    @FXML
    private HBox mySiegeCardsPlayed;
    @FXML
    private HBox competitorCloseCombatCardsPlayed;
    @FXML
    private HBox competitorRangedCombatCardsPlayed;
    @FXML
    private HBox competitorSiegeCardsPlayed;
    private final GameBattleField gameBattleField = User.getUserLoginIn().getLastGameBattleField();

    public void initialize() {
        updateBoard();
    }

    private void updateBoard() {
        User user1 = gameBattleField.getUser1();
        ArrayList<CommonCard> commonCardInBattleFieldUser1 = gameBattleField.getCommonCardInBattleFieldUser1();
        ArrayList<SpecialCard> specialCardsBattleFieldUser1 = gameBattleField.getSpecialCardsBattleFieldUser1();
        ArrayList<CommonCard> closeCombatPlayedUser1 = gameBattleField.getCloseCombatIsPlayedUser1();
        ArrayList<CommonCard> commonCardsInDiscardUser1 = gameBattleField.getCommonCardsInDiscardUser1();
        ArrayList<SpecialCard> specialCardsDiscardUser1 = gameBattleField.getSpecialCardsDiscardUser1();
        ArrayList<CommonCard> siegeIsPlayedUser1 = gameBattleField.getSiegeIsPlayedUser1();
        ArrayList<CommonCard> rangedIsPlayedUser1 = gameBattleField.getRangedIsPlayedUser1();
        SpecialCard specialFieldInCloseCombatUser1 = gameBattleField.getSpecialFieldInCloseCombatUser1();
        SpecialCard specialFieldInSiegeUser1 = gameBattleField.getSpecialFieldInSiegeUser1();
        SpecialCard specialFieldInRangedUser1 = gameBattleField.getSpecialFieldInRangedUser1();

        User user2 = gameBattleField.getUser2();
        ArrayList<CommonCard> commonCardInBattleFieldUser2 = gameBattleField.getCommonCardInBattleFieldUser1();
        ArrayList<SpecialCard> specialCardsBattleFieldUser2 = gameBattleField.getSpecialCardsBattleFieldUser1();
        ArrayList<CommonCard> closeCombatPlayedUser2 = gameBattleField.getCloseCombatIsPlayedUser2();
        ArrayList<CommonCard> commonCardsInDiscardUser2 = gameBattleField.getCommonCardsInDiscardUser1();
        ArrayList<SpecialCard> specialCardsDiscardUser2 = gameBattleField.getSpecialCardsDiscardUser1();
        ArrayList<CommonCard> siegeIsPlayedUser2 = gameBattleField.getSiegeIsPlayedUser1();
        ArrayList<CommonCard> rangedIsPlayedUser2 = gameBattleField.getRangedIsPlayedUser1();
        SpecialCard specialFieldInCloseCombatUser2 = gameBattleField.getSpecialFieldInCloseCombatUser1();
        SpecialCard specialFieldInSiegeUser2 = gameBattleField.getSpecialFieldInSiegeUser1();
        SpecialCard specialFieldInRangedUser2 = gameBattleField.getSpecialFieldInRangedUser1();

        myLeader.setImage(gameBattleField.getWhichUserTurn().getFactionLeader().getImageForGame());
        competitorLeader.setImage(whichUserIsNotTurn().getFactionLeader().getImageForGame());

        firstPlayerFaction.setText(gameBattleField.getWhichUserTurn().getFactionSelected().getFactionName());
        secondPlayerFaction.setText(whichUserIsNotTurn().getFactionSelected().getFactionName());

        firstPlayerUsername.setText(gameBattleField.getWhichUserTurn().getUsername());
        secondPlayerUsername.setText(whichUserIsNotTurn().getUsername());

        int firstPlayerScoreInGame;
        int secondPlayerScoreInGame;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            firstPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser1, siegeIsPlayedUser1, rangedIsPlayedUser1, firstPlayerScore);
            secondPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser2, siegeIsPlayedUser2, rangedIsPlayedUser2, secondPlayerScore);
        } else {
            firstPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser2, siegeIsPlayedUser2, rangedIsPlayedUser2, firstPlayerScore);
            secondPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser1, siegeIsPlayedUser1, rangedIsPlayedUser1, secondPlayerScore);
        }

        if (gameBattleField.isPassedUser1() && gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1()))
            firstPlayerPassedLabel.setVisible(true);
        else if (gameBattleField.isPassedUser1() && !gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1()))
            secondPlayerUsername.setVisible(true);
        if (gameBattleField.isPassedUser2() && gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2()))
            firstPlayerPassedLabel.setVisible(true);
        else if (gameBattleField.isPassedUser2() && !gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2()))
            secondPlayerPassedLabel.setVisible(true);

        if (firstPlayerScoreInGame > secondPlayerScoreInGame) firstPlayerCrown.setVisible(true);
        else if (firstPlayerScoreInGame < secondPlayerScoreInGame) secondPlayerCrown.setVisible(true);

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            setLifeOfPlayers(gameBattleField.getHealthUser1(), firstPlayerFirstLifeImageView, firstPlayerSecondLifeImageView);
            setLifeOfPlayers(gameBattleField.getHealthUser2(), secondPlayerFirstLifeImageView, secondPlayerSecondLifeImageView);
        } else {
            setLifeOfPlayers(gameBattleField.getHealthUser2(), firstPlayerFirstLifeImageView, firstPlayerSecondLifeImageView);
            setLifeOfPlayers(gameBattleField.getHealthUser1(), secondPlayerFirstLifeImageView, secondPlayerSecondLifeImageView);
        }

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            firstPlayerInHand.setText(String.valueOf(commonCardInBattleFieldUser1.size() + specialCardsBattleFieldUser1.size()));
            secondPlayerInHand.setText(String.valueOf(commonCardInBattleFieldUser2.size() + specialCardsBattleFieldUser2.size()));
        } else {
            firstPlayerInHand.setText(String.valueOf(commonCardInBattleFieldUser2.size() + specialCardsBattleFieldUser2.size()));
            secondPlayerInHand.setText(String.valueOf(commonCardInBattleFieldUser1.size() + specialCardsBattleFieldUser1.size()));
        }

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            firstPlayerShield.setImage(user1.getFactionSelected().getImagePath());
            secondPlayerShield.setImage(user2.getFactionSelected().getImagePath());
        } else {
            firstPlayerShield.setImage(user2.getFactionSelected().getImagePath());
            secondPlayerShield.setImage(user1.getFactionSelected().getImagePath());
        }
    }

    private User whichUserIsNotTurn() {
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) return gameBattleField.getUser2();
        return gameBattleField.getUser1();
    }

    private void setLifeOfPlayers(int gameBattleField, ImageView playerFirstLifeImageView, ImageView playerSecondLifeImageView) {
        if (gameBattleField == 2) {
            playerFirstLifeImageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/icon_gem_on.png"))));
            playerSecondLifeImageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/icon_gem_on.png"))));
        } else if (gameBattleField == 1) {
            playerFirstLifeImageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/icon_gem_on.png"))));
            playerSecondLifeImageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/icon_gem_off.png"))));
        } else if (gameBattleField == 0) {
            playerFirstLifeImageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/icon_gem_off.png"))));
            playerSecondLifeImageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/icon_gem_off.png"))));
        }
    }

    private int scoreCalculation(ArrayList<CommonCard> closeCombatPlayedUser, ArrayList<CommonCard> siegeIsPlayedUser, ArrayList<CommonCard> rangedIsPlayedUser, Label playerScore) {
        int playerScoreInGame = 0;
        for (CommonCard commonCard : closeCombatPlayedUser) playerScoreInGame += commonCard.getScore();
        for (CommonCard commonCard : siegeIsPlayedUser) playerScoreInGame += commonCard.getScore();
        for (CommonCard commonCard : rangedIsPlayedUser) playerScoreInGame += commonCard.getScore();
        playerScore.setText(String.valueOf(playerScoreInGame));
        return playerScoreInGame;
    }

    public void changeTurn(MouseEvent mouseEvent) {

    }

    public void pass(MouseEvent mouseEvent) {

    }
}
