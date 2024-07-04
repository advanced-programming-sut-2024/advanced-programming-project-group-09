package Sample.Controller;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.Leader;
import Sample.CardEnums.SpecialCard;
import Sample.Model.GameBattleField;
import Sample.Model.User;
import Sample.View.LoginMenu;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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
    @FXML
    private StackPane mySiegeSpecialCard;
    @FXML
    private StackPane myRangedSpecialCard;
    @FXML
    private StackPane myCloseCombatSpecialCard;
    @FXML
    private StackPane competitorCloseCombatSpecialCard;
    @FXML
    private StackPane competitorRangedSpecialCard;
    @FXML
    private StackPane competitorSiegeSpecialCard;
    @FXML
    private HBox weatherCards;
    private ArrayList<CommonCard> commonCardInBattleFieldUser1 = new ArrayList<>();
    private ArrayList<SpecialCard> specialCardsBattleFieldUser1 = new ArrayList<>();
    private ArrayList<CommonCard> closeCombatPlayedUser1 = new ArrayList<>();
    private ArrayList<CommonCard> commonCardsInDiscardUser1 = new ArrayList<>();
    private ArrayList<SpecialCard> specialCardsDiscardUser1 = new ArrayList<>();
    private ArrayList<CommonCard> siegeIsPlayedUser1 = new ArrayList<>();
    private ArrayList<CommonCard> rangedIsPlayedUser1 = new ArrayList<>();
    private SpecialCard specialFieldInCloseCombatUser1;
    private SpecialCard specialFieldInSiegeUser1;
    private SpecialCard specialFieldInRangedUser1;
    private ArrayList<CommonCard> commonCardInBattleFieldUser2 = new ArrayList<>();
    private ArrayList<SpecialCard> specialCardsBattleFieldUser2 = new ArrayList<>();
    private ArrayList<CommonCard> closeCombatPlayedUser2 = new ArrayList<>();
    private ArrayList<CommonCard> commonCardsInDiscardUser2 = new ArrayList<>();
    private ArrayList<SpecialCard> specialCardsDiscardUser2 = new ArrayList<>();
    private ArrayList<CommonCard> siegeIsPlayedUser2 = new ArrayList<>();
    private ArrayList<CommonCard> rangedIsPlayedUser2 = new ArrayList<>();
    private SpecialCard specialFieldInCloseCombatUser2;
    private SpecialCard specialFieldInSiegeUser2;
    private SpecialCard specialFieldInRangedUser2;
    private final Image powerHeroImage = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/power_hero.png")));
    private final Image powerNormalImage = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/power_normal.png")));
    private final Image cardRowAgile = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_row_agile.png")));
    private final Image cardRowClose = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_row_close.png")));
    private final Image cardRowRanged = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_row_ranged.png")));
    private final Image cardRowSiege = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_row_siege.png")));
    private final Image cardAbilityAvenger = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_avenger.png")));
    private final Image cardAbilityBerserker = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_berserker.png")));
    private final Image cardAbilityBond = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_bond.png")));
    private final Image cardAbilityMardroeme = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_mardroeme.png")));
    private final Image cardAbilityMedic = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_medic.png")));
    private final Image cardAbilityMorale = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_morale.png")));
    private final Image cardAbilityMuster = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_muster.png")));
    private final Image cardAbilityScorch = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_scorch.png")));
    private final Image cardAbilitySpy = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_spy.png")));
    private final Image cardAbilityHorn = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_ability_horn.png")));


    private final GameBattleField gameBattleField = User.getUserLoginIn().getLastGameBattleField();
    private GameBattleFieldController gameBattleFieldController;

    public void initialize() {
        gameBattleFieldController = new GameBattleFieldController(gameBattleField);
//        StackPane stackPane = (StackPane) myHandCards.getChildren().getFirst();
//        ((ImageView)stackPane.getChildren().get(1)).setImage(powerHeroImage);
//        ((ImageView)stackPane.getChildren().getFirst()).setImage(CommonCard.Geralt.getImageForGame());
//        ((Label) stackPane.getChildren().get(2)).setText(String.valueOf(CommonCard.Geralt.getScore()));
//        ((Label) stackPane.getChildren().get(2)).setTextFill(Color.WHITE);
//        stackPane.getChildren().get(2).setVisible(true);
//        ((ImageView)stackPane.getChildren().get(3)).setImage(cardRowClose);
//        ((ImageView)stackPane.getChildren().get(4)).setImage(cardAbilityMedic);

        gameBattleFieldController.cloneChosenDeckForUsingInGame();
        gameBattleFieldController.giveRandomInitialCards();
        updateBoard();
    }

    private void updateBoard() {
        User user1 = gameBattleField.getUser1();
        commonCardInBattleFieldUser1 = gameBattleField.getCommonCardInBattleFieldUser1();
        specialCardsBattleFieldUser1 = gameBattleField.getSpecialCardsBattleFieldUser1();
        closeCombatPlayedUser1 = gameBattleField.getCloseCombatIsPlayedUser1();
        commonCardsInDiscardUser1 = gameBattleField.getCommonCardsInDiscardUser1();
        specialCardsDiscardUser1 = gameBattleField.getSpecialCardsDiscardUser1();
        siegeIsPlayedUser1 = gameBattleField.getSiegeIsPlayedUser1();
        rangedIsPlayedUser1 = gameBattleField.getRangedIsPlayedUser1();
        specialFieldInCloseCombatUser1 = gameBattleField.getSpecialFieldInCloseCombatUser1();
        specialFieldInSiegeUser1 = gameBattleField.getSpecialFieldInSiegeUser1();
        specialFieldInRangedUser1 = gameBattleField.getSpecialFieldInRangedUser1();

        User user2 = gameBattleField.getUser2();
        commonCardInBattleFieldUser2 = gameBattleField.getCommonCardInBattleFieldUser1();
        specialCardsBattleFieldUser2 = gameBattleField.getSpecialCardsBattleFieldUser1();
        closeCombatPlayedUser2 = gameBattleField.getCloseCombatIsPlayedUser2();
        commonCardsInDiscardUser2 = gameBattleField.getCommonCardsInDiscardUser1();
        specialCardsDiscardUser2 = gameBattleField.getSpecialCardsDiscardUser1();
        siegeIsPlayedUser2 = gameBattleField.getSiegeIsPlayedUser1();
        rangedIsPlayedUser2 = gameBattleField.getRangedIsPlayedUser1();
        specialFieldInCloseCombatUser2 = gameBattleField.getSpecialFieldInCloseCombatUser1();
        specialFieldInSiegeUser2 = gameBattleField.getSpecialFieldInSiegeUser1();
        specialFieldInRangedUser2 = gameBattleField.getSpecialFieldInRangedUser1();

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

        putCardsInBoard();
    }

    private void putCardsInBoard() {
        removeAllCardsFromBoard(myHandCards);
        removeAllCardsFromBoard(myCloseCombatCardsPlayed);
        removeAllCardsFromBoard(myRangedCombatCardsPlayed);
        removeAllCardsFromBoard(mySiegeCardsPlayed);
        removeAllCardsFromBoard(competitorCloseCombatCardsPlayed);
        removeAllCardsFromBoard(competitorRangedCombatCardsPlayed);
        removeAllCardsFromBoard(competitorSiegeCardsPlayed);
        removeSpecialCardsFromBoard(myCloseCombatSpecialCard);
        removeSpecialCardsFromBoard(myRangedSpecialCard);
        removeSpecialCardsFromBoard(mySiegeSpecialCard);
        removeSpecialCardsFromBoard(competitorCloseCombatSpecialCard);
        removeSpecialCardsFromBoard(competitorRangedSpecialCard);
        removeSpecialCardsFromBoard(competitorSiegeSpecialCard);
        removeWeatherCards();
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < specialCardsBattleFieldUser1.size(); i++) {
                StackPane stackPane = (StackPane) myHandCards.getChildren().get(i);
                ((ImageView) stackPane.getChildren().getFirst()).setImage(specialCardsBattleFieldUser1.get(i).getImageForGame());
                ((ImageView) stackPane.getChildren().get(1)).setImage(specialCardsBattleFieldUser1.get(i).getImageForPower());

                stackPane.getChildren().get(2).setVisible(false);
            }
            for (int i = specialCardsBattleFieldUser1.size(); i < specialCardsBattleFieldUser1.size() + commonCardInBattleFieldUser1.size(); i++) {
                StackPane stackPane = (StackPane) myHandCards.getChildren().get(i);
                ((ImageView) stackPane.getChildren().getFirst()).setImage(commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getImageForGame());
                if (commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).isHero()) {
                    ((ImageView) stackPane.getChildren().get(1)).setImage(powerHeroImage);
                    ((Label)stackPane.getChildren().get(2)).setTextFill(Color.WHITE);
                } else {
                    ((ImageView) stackPane.getChildren().get(1)).setImage(powerNormalImage);
                    ((Label)stackPane.getChildren().get(2)).setTextFill(Color.BLACK);
                }
                ((Label)stackPane.getChildren().get(2)).setText(String.valueOf(commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getScore()));
                stackPane.getChildren().get(2).setVisible(true);

                String playField = commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getPlayField();
                switch (playField) {
                    case "Close Combat" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowClose);
                    case "Ranged" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowRanged);
                    case "Siege" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowSiege);
                    case "Agile" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowAgile);
                }

                String ability = commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getAbility();
                if (ability.contains("Transform")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityAvenger);
                else if (ability.contains("Mardroeme")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMardroeme);
                else if (ability.contains("Muster")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMuster);
                else if (ability.contains("Commander's Horn")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityHorn);
                else if (ability.contains("Moral Boost")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMorale);
                else if (ability.contains("Tight Bond")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityBond);
                else if (ability.contains("Increase Score By Mardroeme")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityBerserker);
                else if (ability.contains("Scorch")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityScorch);
                else if (ability.contains("Spy")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilitySpy);
                else if (ability.contains("Medic")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMedic);
            }

            for (int i = 0; i < specialCardsBattleFieldUser1.size(); i++) {
                StackPane stackPane = (StackPane) myHandCards.getChildren().get(i);
                ((ImageView) stackPane.getChildren().getFirst()).setImage(specialCardsBattleFieldUser1.get(i).getImageForGame());
                ((ImageView) stackPane.getChildren().get(1)).setImage(specialCardsBattleFieldUser1.get(i).getImageForPower());

                stackPane.getChildren().get(2).setVisible(false);
            }
        }
    }

    private void removeWeatherCards() {
        for (Node node : weatherCards.getChildren()) {
            StackPane stackPane = (StackPane) node;
            for (Node child : stackPane.getChildren()) {
                if (child instanceof ImageView) ((ImageView) child).setImage(null);
            }
        }
    }

    private void removeSpecialCardsFromBoard(StackPane specialCard) {
        for (Node child : specialCard.getChildren()) {
            if (child instanceof ImageView) ((ImageView) child).setImage(null);
        }
    }

    private void removeAllCardsFromBoard(HBox cards) {
        for (Node node : cards.getChildren()) {
            StackPane stackPane = (StackPane) node;
            for (Node child : stackPane.getChildren()) {
                if (child instanceof ImageView) ((ImageView) child).setImage(null);
                else if (child instanceof Label) child.setVisible(false);
            }
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
