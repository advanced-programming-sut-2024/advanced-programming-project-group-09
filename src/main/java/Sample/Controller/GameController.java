package Sample.Controller;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;
import Sample.Model.GameBattleField;
import Sample.Model.User;
import Sample.View.LoginMenu;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
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
    private Label competitorSiegeRowScore;
    @FXML
    private Label competitorRangedRowScore;
    @FXML
    private Label competitorCloseCombatRowScore;
    @FXML
    private Label myCloseCombatRowScore;
    @FXML
    private Label myRangedRowScore;
    @FXML
    private Label mySiegeRowScore;
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
    private StackPane parentPane;
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
    @FXML
    private ImageView bigCardShow;
    @FXML
    private Label numberOfMyDeckCards;
    @FXML
    private Label numberOfCompetitorDeckCards;
    @FXML
    private ImageView imageOfMyFaction;
    @FXML
    private ImageView imageOfCompetitorFaction;
    @FXML
    private ImageView myLastDiscard;
    @FXML
    private ImageView competitorLastDiscard;
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
    private final Image decoyPower = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_special_decoy.png")));
    private final Image spyAnimation = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/anim_spy.png")));
    private final Image medicAnimation = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/anim_medic.png")));
    private final Image bondAnimation = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/anim_bond.png")));
    private final Image musterAnimation = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/anim_muster.png")));
    private final Image moraleAnimation = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/anim_morale.png")));
    private final Image hornAnimation = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/anim_horn.png")));
    private final Image scorchAnimation = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/anim_scorch.png")));
    private final Image profilePng = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/profile.png")));
    private final Image putRainWeather = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/overlay_rain.png")));
    private final Image putFrostWeather = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/overlay_frost.png")));
    private final Image putFogWeather = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/overlay_fog.png")));

    private CommonCard selectedCommonCard = null;
    private SpecialCard selectedSpecialCard = null;

    private boolean isTransitioning = false;
    private boolean isFirstTimeForUser1 = true;
    private boolean isFirstTimeForUser2 = true;
    private int numberOfCardsChanged = 0;
    private HBox allCards;
    private final GameBattleField gameBattleField = User.getUserLoginIn().getLastGameBattleField();
    private GameBattleFieldController gameBattleFieldController;

    public void initialize() {
        gameBattleFieldController = new GameBattleFieldController(gameBattleField);
        gameBattleFieldController.cloneChosenDeckForUsingInGame();
        gameBattleFieldController.giveRandomInitialCards();
        if (isFirstTimeForUser1) {
            isFirstTimeForUser1 = false;
            changeTwoCardsOfDeck();
        }
        updateBoard();
    }

    private void changeTwoCardsOfDeck() {
        GaussianBlur gaussianBlur = new GaussianBlur(10);
        pane.setEffect(gaussianBlur);

        allCards = new HBox(1050);
        allCards.setLayoutX(90);
        allCards.setLayoutY(200);
        allCards.setSpacing(10);
        allCards.setAlignment(Pos.CENTER);
        allCards.setEffect(new GaussianBlur(0));

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            allCards.getChildren().clear();
            for (int i = 0; i < gameBattleField.getSpecialCardsBattleFieldUser1().size(); i++) {
                ImageView imageView = new ImageView(gameBattleField.getSpecialCardsBattleFieldUser1().get(i).getImage());
                imageView.setFitWidth(100);
                imageView.setFitHeight(200);
                imageView.setOnMouseMoved(e -> focusOnImageForStart(imageView));
                imageView.setOnMouseExited(e -> unFocusForStart(imageView));
                imageView.setOnMouseClicked(e -> changeCard(imageView));
                imageView.setId(String.valueOf(i));
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser1().size(); i++) {
                ImageView imageView = new ImageView(gameBattleField.getCommonCardInBattleFieldUser1().get(i).getImage());
                imageView.setFitWidth(100);
                imageView.setFitHeight(200);
                imageView.setOnMouseMoved(e -> focusOnImageForStart(imageView));
                imageView.setOnMouseExited(e -> unFocusForStart(imageView));
                imageView.setOnMouseClicked(e -> changeCard(imageView));
                imageView.setId(String.valueOf(i + gameBattleField.getSpecialCardsBattleFieldUser1().size()));
                allCards.getChildren().add(imageView);
            }
            Button cancelButton = new Button("Cancel Veto");
            cancelButton.setStyle(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("CSS/style.css")).toString());

        } else {
            allCards.getChildren().clear();
            for (int i = 0; i < gameBattleField.getSpecialCardsBattleFieldUser2().size(); i++) {
                ImageView imageView = new ImageView(gameBattleField.getSpecialCardsBattleFieldUser2().get(i).getImage());
                imageView.setFitWidth(100);
                imageView.setFitHeight(200);
                imageView.setOnMouseMoved(e -> focusOnImageForStart(imageView));
                imageView.setOnMouseExited(e -> unFocusForStart(imageView));
                imageView.setOnMouseClicked(e -> changeCard(imageView));
                imageView.setId(String.valueOf(i));
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser2().size(); i++) {
                ImageView imageView = new ImageView(gameBattleField.getCommonCardInBattleFieldUser2().get(i).getImage());
                imageView.setFitWidth(100);
                imageView.setFitHeight(200);
                imageView.setOnMouseMoved(e -> focusOnImageForStart(imageView));
                imageView.setOnMouseExited(e -> unFocusForStart(imageView));
                imageView.setOnMouseClicked(e -> changeCard(imageView));
                imageView.setId(String.valueOf(i + gameBattleField.getSpecialCardsBattleFieldUser2().size()));
                allCards.getChildren().add(imageView);
            }
        }

        Pane overlayPane = new Pane();
        overlayPane.getChildren().add(allCards);

        parentPane.getChildren().add(overlayPane);
    }

    private void changeCard(ImageView imageView) {
        gameBattleFieldController.sort();
        numberOfCardsChanged += 1;
        int number = Integer.parseInt(imageView.getId());
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (number < gameBattleField.getSpecialCardsBattleFieldUser1().size()) {
                SpecialCard specialCard = gameBattleField.getSpecialCardsBattleFieldUser1().get(number);
                gameBattleField.getSpecialCardsBattleFieldUser1().remove(number);
                SpecialCard specialCardGiven = gameBattleFieldController.giveOneRandomSpecialCardToUserPlayed(gameBattleField.getUser1());
                gameBattleField.getSpecialCardsDeckUser1().add(specialCard);
                ((ImageView) allCards.getChildren().get(number)).setImage(specialCardGiven.getImage());
            } else {
                CommonCard commonCard = gameBattleField.getCommonCardInBattleFieldUser1().get(number - gameBattleField.getSpecialCardsBattleFieldUser1().size());
                gameBattleField.getCommonCardInBattleFieldUser1().remove(number - gameBattleField.getSpecialCardsBattleFieldUser1().size());
                CommonCard commonCardGiven = gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser1());
                gameBattleField.getCommonCardInDeckUser1().add(commonCard);
                ((ImageView) allCards.getChildren().get(number)).setImage(commonCardGiven.getImage());
            }
            updateBoard();
        } else {
            if (number < gameBattleField.getSpecialCardsBattleFieldUser2().size()) {
                SpecialCard specialCard = gameBattleField.getSpecialCardsBattleFieldUser2().get(number);
                gameBattleField.getSpecialCardsBattleFieldUser2().remove(number);
                SpecialCard specialCardGiven = gameBattleFieldController.giveOneRandomSpecialCardToUserPlayed(gameBattleField.getUser2());
                gameBattleField.getSpecialCardsDeckUser2().add(specialCard);
                ((ImageView) allCards.getChildren().get(number)).setImage(specialCardGiven.getImage());
            } else {
                CommonCard commonCard = gameBattleField.getCommonCardInBattleFieldUser2().get(number - gameBattleField.getSpecialCardsBattleFieldUser2().size());
                gameBattleField.getCommonCardInBattleFieldUser2().remove(number - gameBattleField.getSpecialCardsBattleFieldUser2().size());
                CommonCard commonCardGiven = gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser2());
                gameBattleField.getCommonCardInDeckUser2().add(commonCard);
                ((ImageView) allCards.getChildren().get(number)).setImage(commonCardGiven.getImage());
            }
            updateBoard();
        }
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < gameBattleField.getSpecialCardsBattleFieldUser1().size(); i++) {
                ((ImageView) allCards.getChildren().get(i)).setImage(gameBattleField.getSpecialCardsBattleFieldUser1().get(i).getImage());
            }
            for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser1().size(); i++) {
                ((ImageView) allCards.getChildren().get(i + gameBattleField.getSpecialCardsBattleFieldUser1().size())).setImage(gameBattleField.getCommonCardInBattleFieldUser1().get(i).getImage());
            }
        } else {
            for (int i = 0; i < gameBattleField.getSpecialCardsBattleFieldUser2().size(); i++) {
                ((ImageView) allCards.getChildren().get(i)).setImage(gameBattleField.getSpecialCardsBattleFieldUser2().get(i).getImage());
            }
            for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser2().size(); i++) {
                ((ImageView) allCards.getChildren().get(i + gameBattleField.getSpecialCardsBattleFieldUser2().size())).setImage(gameBattleField.getCommonCardInBattleFieldUser2().get(i).getImage());
            }
        }
        if (numberOfCardsChanged == 2) {
            allCards.getChildren().clear();
            parentPane.getChildren().removeLast();
            pane.setEffect(null);
        }
    }


    private void updateBoard() {
        gameBattleFieldController.sort();

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
        commonCardInBattleFieldUser2 = gameBattleField.getCommonCardInBattleFieldUser2();
        specialCardsBattleFieldUser2 = gameBattleField.getSpecialCardsBattleFieldUser2();
        closeCombatPlayedUser2 = gameBattleField.getCloseCombatIsPlayedUser2();
        commonCardsInDiscardUser2 = gameBattleField.getCommonCardsInDiscardUser2();
        specialCardsDiscardUser2 = gameBattleField.getSpecialCardsDiscardUser2();
        siegeIsPlayedUser2 = gameBattleField.getSiegeIsPlayedUser2();
        rangedIsPlayedUser2 = gameBattleField.getRangedIsPlayedUser2();
        specialFieldInCloseCombatUser2 = gameBattleField.getSpecialFieldInCloseCombatUser2();
        specialFieldInSiegeUser2 = gameBattleField.getSpecialFieldInSiegeUser2();
        specialFieldInRangedUser2 = gameBattleField.getSpecialFieldInRangedUser2();

        myLeader.setImage(gameBattleField.getWhichUserTurn().getFactionLeader().getImageForGame());
        competitorLeader.setImage(whichUserIsNotTurn().getFactionLeader().getImageForGame());

        firstPlayerFaction.setText(gameBattleField.getWhichUserTurn().getFactionSelected().getFactionName());
        secondPlayerFaction.setText(whichUserIsNotTurn().getFactionSelected().getFactionName());

        firstPlayerUsername.setText(gameBattleField.getWhichUserTurn().getUsername());
        secondPlayerUsername.setText(whichUserIsNotTurn().getUsername());

        if (gameBattleField.isPassedUser1() && gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1()))
            firstPlayerPassedLabel.setVisible(true);
        else if (gameBattleField.isPassedUser1() && !gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1()))
            secondPlayerUsername.setVisible(true);
        if (gameBattleField.isPassedUser2() && gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2()))
            firstPlayerPassedLabel.setVisible(true);
        else if (gameBattleField.isPassedUser2() && !gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2()))
            secondPlayerPassedLabel.setVisible(true);

        putCardsInBoard();

        int firstPlayerScoreInGame;
        int secondPlayerScoreInGame;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            scoreCalculation(closeCombatPlayedUser1, null, null, myCloseCombatRowScore);
            scoreCalculation(null, siegeIsPlayedUser1, null, mySiegeRowScore);
            scoreCalculation(null, null, rangedIsPlayedUser1, myRangedRowScore);
            scoreCalculation(closeCombatPlayedUser2, null, null, competitorCloseCombatRowScore);
            scoreCalculation(null, siegeIsPlayedUser2, null, competitorSiegeRowScore);
            scoreCalculation(null, null, rangedIsPlayedUser2, competitorRangedRowScore);
            firstPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser1, siegeIsPlayedUser1, rangedIsPlayedUser1, firstPlayerScore);
            secondPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser2, siegeIsPlayedUser2, rangedIsPlayedUser2, secondPlayerScore);

            int numberOfMyDeckCard = gameBattleField.getCommonCardInDeckUser1().size() + gameBattleField.getSpecialCardsDeckUser1().size();
            imageOfMyFaction.setImage(gameBattleField.getUser1().getFactionSelected().getImageForGame());
            numberOfMyDeckCards.setText(String.valueOf(numberOfMyDeckCard));
            for (int i = 1; i < Math.min(25, numberOfMyDeckCard); i++) {
                ImageView imageView = new ImageView(gameBattleField.getUser1().getFactionSelected().getImageForGame());
                imageView.setFitHeight(imageOfMyFaction.getFitHeight());
                imageView.setFitWidth(imageOfMyFaction.getFitWidth());
                imageView.setX(imageOfMyFaction.getX() - i * 0.01);
                imageView.setY(imageOfMyFaction.getY() - i * 0.01);
                ((StackPane) imageOfMyFaction.getParent()).getChildren().add(i, imageView);
            }
            int numberOfCompetitorDeckCard = gameBattleField.getCommonCardInDeckUser2().size() + gameBattleField.getSpecialCardsDeckUser2().size();
            imageOfCompetitorFaction.setImage(gameBattleField.getUser2().getFactionSelected().getImageForGame());
            numberOfCompetitorDeckCards.setText(String.valueOf(numberOfCompetitorDeckCard));
            for (int i = 1; i < Math.min(25, numberOfCompetitorDeckCard); i++) {
                ImageView imageView = new ImageView(gameBattleField.getUser2().getFactionSelected().getImageForGame());
                imageView.setFitHeight(imageOfCompetitorFaction.getFitHeight());
                imageView.setFitWidth(imageOfCompetitorFaction.getFitWidth());
                imageView.setX(imageOfCompetitorFaction.getX() - i * 0.01);
                imageView.setY(imageOfCompetitorFaction.getY() - i * 0.01);
                ((StackPane) imageOfCompetitorFaction.getParent()).getChildren().add(i, imageView);
            }

            if (!gameBattleField.getCommonCardsInDiscardUser1().isEmpty())
                myLastDiscard.setImage(gameBattleField.getCommonCardsInDiscardUser1().getLast().getImageForGame());
            else if (!gameBattleField.getSpecialCardsDiscardUser1().isEmpty()) {
                myLastDiscard.setImage(gameBattleField.getSpecialCardsDiscardUser1().getLast().getImageForGame());
            }
            if (!gameBattleField.getCommonCardsInDiscardUser2().isEmpty())
                competitorLastDiscard.setImage(gameBattleField.getCommonCardsInDiscardUser2().getLast().getImageForGame());
            else if (!gameBattleField.getSpecialCardsDiscardUser2().isEmpty()) {
                competitorLastDiscard.setImage(gameBattleField.getSpecialCardsDiscardUser2().getLast().getImageForGame());
            }
        } else {
            scoreCalculation(closeCombatPlayedUser2, null, null, myCloseCombatRowScore);
            scoreCalculation(null, siegeIsPlayedUser2, null, mySiegeRowScore);
            scoreCalculation(null, null, rangedIsPlayedUser2, myRangedRowScore);
            scoreCalculation(closeCombatPlayedUser1, null, null, competitorCloseCombatRowScore);
            scoreCalculation(null, siegeIsPlayedUser1, null, competitorSiegeRowScore);
            scoreCalculation(null, null, rangedIsPlayedUser1, competitorRangedRowScore);
            firstPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser2, siegeIsPlayedUser2, rangedIsPlayedUser2, firstPlayerScore);
            secondPlayerScoreInGame = scoreCalculation(closeCombatPlayedUser1, siegeIsPlayedUser1, rangedIsPlayedUser1, secondPlayerScore);

            int numberOfMyDeckCard = gameBattleField.getCommonCardInDeckUser2().size() + gameBattleField.getSpecialCardsDeckUser2().size();
            imageOfMyFaction.setImage(gameBattleField.getUser2().getFactionSelected().getImageForGame());
            numberOfMyDeckCards.setText(String.valueOf(numberOfMyDeckCard));
            for (int i = 1; i < Math.min(25, numberOfMyDeckCard); i++) {
                ImageView imageView = new ImageView(gameBattleField.getUser2().getFactionSelected().getImageForGame());
                imageView.setFitHeight(imageOfMyFaction.getFitHeight());
                imageView.setFitWidth(imageOfMyFaction.getFitWidth());
                imageView.setX(imageOfMyFaction.getX() - i * 0.01);
                imageView.setY(imageOfMyFaction.getY() - i * 0.01);
                ((StackPane) imageOfMyFaction.getParent()).getChildren().add(i, imageView);
            }
            int numberOfCompetitorDeckCard = gameBattleField.getCommonCardInDeckUser1().size() + gameBattleField.getSpecialCardsDeckUser1().size();
            imageOfCompetitorFaction.setImage(gameBattleField.getUser1().getFactionSelected().getImageForGame());
            numberOfCompetitorDeckCards.setText(String.valueOf(numberOfCompetitorDeckCard));
            for (int i = 1; i < Math.min(25, numberOfCompetitorDeckCard); i++) {
                ImageView imageView = new ImageView(gameBattleField.getUser1().getFactionSelected().getImageForGame());
                imageView.setFitHeight(imageOfCompetitorFaction.getFitHeight());
                imageView.setFitWidth(imageOfCompetitorFaction.getFitWidth());
                imageView.setX(imageOfCompetitorFaction.getX() - i * 0.01);
                imageView.setY(imageOfCompetitorFaction.getY() - i * 0.01);
                ((StackPane) imageOfCompetitorFaction.getParent()).getChildren().add(i, imageView);
            }

            if (!gameBattleField.getCommonCardsInDiscardUser2().isEmpty())
                myLastDiscard.setImage(gameBattleField.getCommonCardsInDiscardUser2().getLast().getImageForGame());
            else if (!gameBattleField.getSpecialCardsDiscardUser2().isEmpty()) {
                myLastDiscard.setImage(gameBattleField.getSpecialCardsDiscardUser2().getLast().getImageForGame());
            }
            if (!gameBattleField.getCommonCardsInDiscardUser1().isEmpty())
                competitorLastDiscard.setImage(gameBattleField.getCommonCardsInDiscardUser1().getLast().getImageForGame());
            else if (!gameBattleField.getSpecialCardsDiscardUser1().isEmpty()) {
                competitorLastDiscard.setImage(gameBattleField.getSpecialCardsDiscardUser1().getLast().getImageForGame());
            }
        }
        System.out.println(gameBattleField.getSpecialCardsDiscardUser1().size());
        System.out.println(gameBattleField.getSpecialCardsDiscardUser2().size());

        if (firstPlayerScoreInGame > secondPlayerScoreInGame) {
            firstPlayerCrown.setVisible(true);
            secondPlayerCrown.setVisible(false);
        } else if (firstPlayerScoreInGame < secondPlayerScoreInGame) {
            secondPlayerCrown.setVisible(true);
            firstPlayerCrown.setVisible(false);
        } else {
            secondPlayerCrown.setVisible(false);
            firstPlayerCrown.setVisible(false);
        }

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

    private void putCardsInBoard() {
        removeAllCards();
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            putMyBattleFieldCards(specialCardsBattleFieldUser1, commonCardInBattleFieldUser1);
            putCommonCardsInRows(closeCombatPlayedUser1, myCloseCombatCardsPlayed);
            putCommonCardsInRows(rangedIsPlayedUser1, myRangedCombatCardsPlayed);
            putCommonCardsInRows(siegeIsPlayedUser1, mySiegeCardsPlayed);

            putSpecialCardInRows(specialFieldInCloseCombatUser1, specialFieldInSiegeUser1, specialFieldInRangedUser1, true);

            putCommonCardsInRows(closeCombatPlayedUser2, competitorCloseCombatCardsPlayed);
            putCommonCardsInRows(rangedIsPlayedUser2, competitorRangedCombatCardsPlayed);
            putCommonCardsInRows(siegeIsPlayedUser2, competitorSiegeCardsPlayed);

            putSpecialCardInRows(specialFieldInCloseCombatUser2, specialFieldInSiegeUser2, specialFieldInRangedUser2, false);
        } else {
            putMyBattleFieldCards(specialCardsBattleFieldUser2, commonCardInBattleFieldUser2);
            putCommonCardsInRows(closeCombatPlayedUser2, myCloseCombatCardsPlayed);
            putCommonCardsInRows(rangedIsPlayedUser2, myRangedCombatCardsPlayed);
            putCommonCardsInRows(siegeIsPlayedUser2, mySiegeCardsPlayed);

            putSpecialCardInRows(specialFieldInCloseCombatUser2, specialFieldInSiegeUser2, specialFieldInRangedUser2, true);

            putCommonCardsInRows(closeCombatPlayedUser1, competitorCloseCombatCardsPlayed);
            putCommonCardsInRows(rangedIsPlayedUser1, competitorRangedCombatCardsPlayed);
            putCommonCardsInRows(siegeIsPlayedUser1, competitorSiegeCardsPlayed);

            putSpecialCardInRows(specialFieldInCloseCombatUser1, specialFieldInSiegeUser1, specialFieldInRangedUser1, false);
        }
        putWeatherCardInWeatherCards();
    }

    private void putWeatherCardInWeatherCards() {
        for (int i = 0; i < gameBattleField.getWeatherCards().size(); i++) {
            StackPane stackPane = (StackPane) weatherCards.getChildren().get(i);
            ((ImageView) stackPane.getChildren().getFirst()).setImage(gameBattleField.getWeatherCards().get(i).getImageForGame());
            ((ImageView) stackPane.getChildren().get(1)).setImage(gameBattleField.getWeatherCards().get(i).getImageForPower());
        }
    }

    private void removeAllCards() {
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
        removeImageOfDeckCards();
        removeImageOfDiscard();
    }

    private void removeImageOfDiscard() {
        myLastDiscard.setImage(null);
        competitorLastDiscard.setImage(null);
    }

    private void removeImageOfDeckCards() {
        imageOfMyFaction.setImage(null);
        imageOfCompetitorFaction.setImage(null);
        ((StackPane) imageOfMyFaction.getParent()).getChildren().removeIf(node -> node instanceof ImageView && !node.equals(((StackPane) imageOfMyFaction.getParent()).getChildren().getFirst()));
        ((StackPane) imageOfCompetitorFaction.getParent()).getChildren().removeIf(node -> node instanceof ImageView && !node.equals(((StackPane) imageOfCompetitorFaction.getParent()).getChildren().getFirst()));
    }

    private void putMyBattleFieldCards(ArrayList<SpecialCard> specialCardsBattleFieldUser1, ArrayList<CommonCard> commonCardInBattleFieldUser1) {
        for (int i = 0; i < specialCardsBattleFieldUser1.size(); i++) {
            StackPane stackPane = (StackPane) myHandCards.getChildren().get(i);
            ((ImageView) stackPane.getChildren().getFirst()).setImage(specialCardsBattleFieldUser1.get(i).getImageForGame());
            ((ImageView) stackPane.getChildren().get(1)).setImage(specialCardsBattleFieldUser1.get(i).getImageForPower());

            stackPane.getChildren().get(2).setVisible(false);
        }
        for (int i = specialCardsBattleFieldUser1.size(); i < specialCardsBattleFieldUser1.size() + commonCardInBattleFieldUser1.size(); i++) {
            String playField = commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getPlayField();
            StackPane stackPane = (StackPane) myHandCards.getChildren().get(i);
            ((ImageView) stackPane.getChildren().getFirst()).setImage(commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getImageForGame());
            if (commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).isHero()) {
                ((ImageView) stackPane.getChildren().get(1)).setImage(powerHeroImage);
                ((Label) stackPane.getChildren().get(2)).setTextFill(Color.WHITE);
            } else if (playField != null) {
                ((ImageView) stackPane.getChildren().get(1)).setImage(powerNormalImage);
                ((Label) stackPane.getChildren().get(2)).setTextFill(Color.BLACK);
            } else {
                ((ImageView) stackPane.getChildren().get(1)).setImage(decoyPower);
            }
            if (playField != null) {
                ((Label) stackPane.getChildren().get(2)).setText(String.valueOf(commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getScore()));
                stackPane.getChildren().get(2).setVisible(true);
            }

            if (playField != null) {
                switch (playField) {
                    case "Close Combat" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowClose);
                    case "Ranged" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowRanged);
                    case "Siege" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowSiege);
                    case "Agile" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowAgile);
                }
            }

            String ability = commonCardInBattleFieldUser1.get(i - specialCardsBattleFieldUser1.size()).getAbility();
            if (ability.contains("Transform"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityAvenger);
            else if (ability.contains("Mardroeme"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMardroeme);
            else if (ability.contains("Muster"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMuster);
            else if (ability.contains("Commander's Horn"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityHorn);
            else if (ability.contains("Morale Boost")) {
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMorale);
            } else if (ability.contains("Tight Bond"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityBond);
            else if (ability.contains("Increase Score By Mardroeme"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityBerserker);
            else if (ability.contains("Scorch")) {
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityScorch);
            } else if (ability.contains("Spy")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilitySpy);
            else if (ability.contains("Medic"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMedic);
        }
    }

    private void putSpecialCardInRows(SpecialCard specialFieldInCloseCombatUser1, SpecialCard specialFieldInSiegeUser1, SpecialCard specialFieldInRangedUser1, boolean isMe) {
        if (isMe) {
            if (specialFieldInCloseCombatUser1 != null) {
                ((ImageView) myCloseCombatSpecialCard.getChildren().getFirst()).setImage(specialFieldInCloseCombatUser1.getImageForGame());
                ((ImageView) myCloseCombatSpecialCard.getChildren().get(1)).setImage(specialFieldInCloseCombatUser1.getImageForPower());
            }
            if (specialFieldInSiegeUser1 != null) {
                ((ImageView) mySiegeSpecialCard.getChildren().getFirst()).setImage(specialFieldInSiegeUser1.getImageForGame());
                ((ImageView) mySiegeSpecialCard.getChildren().get(1)).setImage(specialFieldInSiegeUser1.getImageForPower());
            }
            if (specialFieldInRangedUser1 != null) {
                ((ImageView) myRangedSpecialCard.getChildren().getFirst()).setImage(specialFieldInRangedUser1.getImageForGame());
                ((ImageView) myRangedSpecialCard.getChildren().get(1)).setImage(specialFieldInRangedUser1.getImageForPower());
            }
        } else {
            if (specialFieldInCloseCombatUser1 != null) {
                ((ImageView) competitorCloseCombatSpecialCard.getChildren().getFirst()).setImage(specialFieldInCloseCombatUser1.getImageForGame());
                ((ImageView) competitorCloseCombatSpecialCard.getChildren().get(1)).setImage(specialFieldInCloseCombatUser1.getImageForPower());
            }
            if (specialFieldInSiegeUser1 != null) {
                ((ImageView) competitorSiegeSpecialCard.getChildren().getFirst()).setImage(specialFieldInSiegeUser1.getImageForGame());
                ((ImageView) competitorSiegeSpecialCard.getChildren().get(1)).setImage(specialFieldInSiegeUser1.getImageForPower());
            }
            if (specialFieldInRangedUser1 != null) {
                ((ImageView) competitorRangedSpecialCard.getChildren().getFirst()).setImage(specialFieldInRangedUser1.getImageForGame());
                ((ImageView) competitorRangedSpecialCard.getChildren().get(1)).setImage(specialFieldInRangedUser1.getImageForPower());
            }
        }
    }

    private void putCommonCardsInRows(ArrayList<CommonCard> closeCombatPlayedUser1, HBox myCloseCombatCardsPlayed) {
        for (int i = 0; i < closeCombatPlayedUser1.size(); i++) {
            String playField = closeCombatPlayedUser1.get(i).getPlayField();
            StackPane stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(i);
            ((ImageView) stackPane.getChildren().getFirst()).setImage(closeCombatPlayedUser1.get(i).getImageForGame());
            if (closeCombatPlayedUser1.get(i).isHero()) {
                ((ImageView) stackPane.getChildren().get(1)).setImage(powerHeroImage);
                ((Label) stackPane.getChildren().get(2)).setTextFill(Color.WHITE);
            } else if (playField != null) {
                ((ImageView) stackPane.getChildren().get(1)).setImage(powerNormalImage);
                ((Label) stackPane.getChildren().get(2)).setTextFill(Color.BLACK);
            } else {
                ((ImageView) stackPane.getChildren().get(1)).setImage(powerNormalImage);
                ((Label) stackPane.getChildren().get(2)).setTextFill(Color.BLACK);
            }
            if (playField != null) {
                ((Label) stackPane.getChildren().get(2)).setText(setLabelScores(closeCombatPlayedUser1.get(i), closeCombatPlayedUser1));
                stackPane.getChildren().get(2).setVisible(true);
            }

            if (playField != null) {
                switch (playField) {
                    case "Close Combat" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowClose);
                    case "Ranged" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowRanged);
                    case "Siege" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowSiege);
                    case "Agile" -> ((ImageView) stackPane.getChildren().get(3)).setImage(cardRowAgile);
                }
            }

            String ability = closeCombatPlayedUser1.get(i).getAbility();
            if (ability.contains("Transform"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityAvenger);
            else if (ability.contains("Muster"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMuster);
            else if (ability.contains("Commander's Horn"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityHorn);
            else if (ability.contains("Moral"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMorale);
            else if (ability.contains("Tight Bond"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityBond);
            else if (ability.contains("Increase Score By Mardroeme"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityBerserker);
            else if (ability.contains("Mardroeme"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMardroeme);
            else if (ability.contains("Scorch"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityScorch);
            else if (ability.contains("Spy")) ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilitySpy);
            else if (ability.contains("Medic"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMedic);
        }
    }

    private String setLabelScores(CommonCard commonCard, ArrayList<CommonCard> commonCards) {
        int score = commonCard.getScore();
        String playField = commonCard.getPlayField();
        if (commonCard.isHero()) return String.valueOf(score);
        if (playField.equals("Close Combat") && gameBattleField.getWeatherCards().contains(SpecialCard.BitingFrost)) {
            score = Math.min(1, commonCard.getScore());
        } else if (playField.equals("Ranged") && (gameBattleField.getWeatherCards().contains(SpecialCard.ImpenetrableFog) || gameBattleField.getWeatherCards().contains(SpecialCard.SkelligeStorm))) {
            score = Math.min(1, commonCard.getScore());
        } else if (playField.equals("Siege") && (gameBattleField.getWeatherCards().contains(SpecialCard.TorrentialRain) || gameBattleField.getWeatherCards().contains(SpecialCard.SkelligeStorm))) {
            score = Math.min(1, commonCard.getScore());
        }
        if (commonCard.getAbility().contains("Tight Bond")) {
            int number = 0;
            for (CommonCard card : commonCards) {
                if (card.getCardName().equals(commonCard.getCardName()) && card.getAbility().contains("Tight Bond")) {
                    number += 1;
                }
            }
            score *= number;
        }
        for (CommonCard card : commonCards) {
            if (card.getAbility().contains("Morale")) score += 1;
        }
        if (commonCards == closeCombatPlayedUser1 && specialFieldInCloseCombatUser1 != null && specialFieldInCloseCombatUser1.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        } else if (commonCards == rangedIsPlayedUser1 && specialFieldInRangedUser1 != null && specialFieldInRangedUser1.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        } else if (commonCards == siegeIsPlayedUser1 && specialFieldInSiegeUser1 != null && specialFieldInSiegeUser1.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        }
        if (commonCards == closeCombatPlayedUser2 && specialFieldInCloseCombatUser2 != null && specialFieldInCloseCombatUser2.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        } else if (commonCards == rangedIsPlayedUser2 && specialFieldInRangedUser2 != null && specialFieldInRangedUser2.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        } else if (commonCards == siegeIsPlayedUser2 && specialFieldInSiegeUser2 != null && specialFieldInSiegeUser2.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        }
        return String.valueOf(score);
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
            if (node instanceof StackPane stackPane) {
                for (Node child : stackPane.getChildren()) {
                    if (child instanceof ImageView) ((ImageView) child).setImage(null);
                    else if (child instanceof Label) child.setVisible(false);
                }
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
        if (playerScore.getId().contains("competitor") || playerScore.getId().contains("second")) {
            if (closeCombatPlayedUser != null) {
                for (int i = 0; i < closeCombatPlayedUser.size(); i++) {
                    StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    playerScoreInGame += score;
                }
            }
            if (siegeIsPlayedUser != null) {
                for (int i = 0; i < siegeIsPlayedUser.size(); i++) {
                    StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    playerScoreInGame += score;
                }
            }
            if (rangedIsPlayedUser != null) {
                for (int i = 0; i < rangedIsPlayedUser.size(); i++) {
                    StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    playerScoreInGame += score;
                }
            }
        } else {
            if (closeCombatPlayedUser != null) {
                for (int i = 0; i < closeCombatPlayedUser.size(); i++) {
                    StackPane stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(i);
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    playerScoreInGame += score;
                }
            }
            if (siegeIsPlayedUser != null) {
                for (int i = 0; i < siegeIsPlayedUser.size(); i++) {
                    StackPane stackPane = (StackPane) mySiegeCardsPlayed.getChildren().get(i);
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    playerScoreInGame += score;
                }
            }
            if (rangedIsPlayedUser != null) {
                for (int i = 0; i < rangedIsPlayedUser.size(); i++) {
                    StackPane stackPane = (StackPane) myRangedCombatCardsPlayed.getChildren().get(i);
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    playerScoreInGame += score;
                }
            }
        }
        playerScore.setText(String.valueOf(playerScoreInGame));
        return playerScoreInGame;
    }

    public void changeTurn() {
        if (isTransitioning) {
            return;
        }
        isTransitioning = true;
        gameBattleField.changeTurn();
        ImageView imageView = new ImageView(profilePng);
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        imageView.setX((pane.getWidth() - imageView.getFitWidth()) / 2 - 30);
        imageView.setY((pane.getHeight() - imageView.getFitHeight()) / 2);
        imageView.setOpacity(1.0);

        Label label = new Label(gameBattleField.getWhichUserTurn().getUsername() + " turn");
        label.setLayoutX((pane.getWidth() - label.getWidth()) / 2 + 40);
        label.setLayoutY((pane.getHeight() - label.getHeight()) / 2 - 10);
        label.setOpacity(1.0);
        label.setTextFill(Color.LEMONCHIFFON);
        label.setFont(Font.font(30));

        imageView.setBlendMode(BlendMode.SRC_OVER);
        label.setBlendMode(BlendMode.SRC_OVER);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.8);

        Pane newPane = new Pane();

        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> {
            removeAllCards();
            newPane.getChildren().addAll(imageView, label);
            parentPane.getChildren().add(newPane);
            pane.setEffect(colorAdjust);

            PauseTransition pause2 = new PauseTransition(Duration.seconds(3));
            pause2.setOnFinished(event2 -> {
                newPane.getChildren().removeAll(imageView, label);
                parentPane.getChildren().remove(newPane);
                pane.setEffect(null);

                updateBoard();
                isTransitioning = false;
            });
            pause2.play();
        });

        pause.play();
    }


    public void pass(MouseEvent mouseEvent) {

    }

    public void selectCard(MouseEvent mouseEvent) {
        if (isTransitioning) {
            return;
        }
        int numberOfCardSelected = getNumberOfCardSelected(mouseEvent);
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (numberOfCardSelected <= specialCardsBattleFieldUser1.size() - 1) {
                selectedSpecialCard = specialCardsBattleFieldUser1.get(numberOfCardSelected);
                selectedCommonCard = null;
                bigCardShow.setImage(specialCardsBattleFieldUser1.get(numberOfCardSelected).getImage());
            } else if (numberOfCardSelected <= specialCardsBattleFieldUser1.size() + commonCardInBattleFieldUser1.size() - 1) {
                selectedCommonCard = commonCardInBattleFieldUser1.get(numberOfCardSelected - specialCardsBattleFieldUser1.size());
                selectedSpecialCard = null;
                bigCardShow.setImage(commonCardInBattleFieldUser1.get(numberOfCardSelected - specialCardsBattleFieldUser1.size()).getImage());
            }
        } else {
            if (numberOfCardSelected <= specialCardsBattleFieldUser2.size() - 1) {
                selectedSpecialCard = specialCardsBattleFieldUser2.get(numberOfCardSelected);
                selectedCommonCard = null;
                bigCardShow.setImage(specialCardsBattleFieldUser2.get(numberOfCardSelected).getImage());
            } else if (numberOfCardSelected <= specialCardsBattleFieldUser2.size() + commonCardInBattleFieldUser2.size() - 1) {
                selectedCommonCard = commonCardInBattleFieldUser2.get(numberOfCardSelected - specialCardsBattleFieldUser2.size());
                selectedSpecialCard = null;
                bigCardShow.setImage(commonCardInBattleFieldUser2.get(numberOfCardSelected - specialCardsBattleFieldUser2.size()).getImage());
            }
        }
        if (selectedCommonCard != null) {
            mySiegeSpecialCard.setStyle("-fx-background-color: transparent;");
            myRangedSpecialCard.setStyle("-fx-background-color: transparent;");
            myCloseCombatSpecialCard.setStyle("-fx-background-color: transparent;");
            competitorSiegeSpecialCard.setStyle("-fx-background-color: transparent;");
            competitorRangedSpecialCard.setStyle("-fx-background-color: transparent;");
            competitorCloseCombatSpecialCard.setStyle("-fx-background-color: transparent;");
            weatherCards.setStyle("-fx-background-color: transparent;");
            String playField = selectedCommonCard.getPlayField();
            if (!selectedCommonCard.getAbility().contains("Spy")) {
                if (playField != null) {
                    switch (playField) {
                        case "Close Combat" -> {
                            myCloseCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                            competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                        }
                        case "Ranged" -> {
                            myRangedCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                            myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                        }
                        case "Siege" -> {
                            mySiegeCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                            myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                        }
                        case "Agile" -> {
                            myCloseCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                            myRangedCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                            competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                            mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                            competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                        }
                    }
                } else {
                    if (((ImageView) ((StackPane) myCloseCombatCardsPlayed.getChildren().getFirst()).getChildren().getFirst()).getImage() != null) {
                        myCloseCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                    }
                    if (((ImageView) ((StackPane) myRangedCombatCardsPlayed.getChildren().getFirst()).getChildren().getFirst()).getImage() != null) {
                        myRangedCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                    }
                    if (((ImageView) ((StackPane) mySiegeCardsPlayed.getChildren().getFirst()).getChildren().getFirst()).getImage() != null) {
                        mySiegeCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                    }
                    competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                    competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                    competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                }
            } else {
                switch (playField) {
                    case "Close Combat" -> {
                        competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                        myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                        competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                    }
                    case "Ranged" -> {
                        competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                        myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                        competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                    }
                    case "Siege" -> {
                        competitorSiegeCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                        myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
                        mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
                    }
                }
            }
        } else if (selectedSpecialCard != null) {
            if (selectedSpecialCard.equals(SpecialCard.Scorch)) {
                mySiegeSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                myRangedSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                myCloseCombatSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                competitorSiegeSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                competitorRangedSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                competitorCloseCombatSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                myCloseCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                myRangedCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                mySiegeCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                competitorSiegeCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                weatherCards.setStyle("-fx-background-color: transparent;");
                return;
            }
            myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
            competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
            myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
            competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
            mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
            competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
            weatherCards.setStyle("-fx-background-color: transparent;");
            if (selectedSpecialCard.equals(SpecialCard.CommandersHorn) || selectedSpecialCard.equals(SpecialCard.Mardroeme)) {
                if (((ImageView) myCloseCombatSpecialCard.getChildren().getFirst()).getImage() == null) {
                    myCloseCombatSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                }
                if (((ImageView) myRangedSpecialCard.getChildren().getFirst()).getImage() == null) {
                    myRangedSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                }
                if (((ImageView) mySiegeSpecialCard.getChildren().getFirst()).getImage() == null) {
                    mySiegeSpecialCard.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                }
                competitorRangedSpecialCard.setStyle("-fx-background-color: transparent;");
                competitorCloseCombatSpecialCard.setStyle("-fx-background-color: transparent;");
                competitorSiegeSpecialCard.setStyle("-fx-background-color: transparent;");
            } else if (selectedSpecialCard.equals(SpecialCard.BitingFrost) || selectedSpecialCard.equals(SpecialCard.ClearWeather)
                    || selectedSpecialCard.equals(SpecialCard.SkelligeStorm) || selectedSpecialCard.equals(SpecialCard.ImpenetrableFog)
                    || selectedSpecialCard.equals(SpecialCard.TorrentialRain)) {
                weatherCards.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
            }
        }
    }

    private static int getNumberOfCardSelected(MouseEvent mouseEvent) {
        StackPane stackPane = (StackPane) mouseEvent.getSource();
        String id = stackPane.getId();
        int numberOfCardSelected = -1;
        switch (id) {
            case "card0" -> numberOfCardSelected = 0;
            case "card1" -> numberOfCardSelected = 1;
            case "card2" -> numberOfCardSelected = 2;
            case "card3" -> numberOfCardSelected = 3;
            case "card4" -> numberOfCardSelected = 4;
            case "card5" -> numberOfCardSelected = 5;
            case "card6" -> numberOfCardSelected = 6;
            case "card7" -> numberOfCardSelected = 7;
            case "card8" -> numberOfCardSelected = 8;
            case "card9" -> numberOfCardSelected = 9;
            case "card10" -> numberOfCardSelected = 10;
        }
        return numberOfCardSelected;
    }

    public void unSelectCardWithMouseClick(MouseEvent mouseEvent) {
        if (isTransitioning) {
            return;
        }
        if ((mouseEvent.getX() > 350 && mouseEvent.getX() < 1030) || (mouseEvent.getX() >= 1027 && mouseEvent.getX() <= 1227 && mouseEvent.getY() >= 166 && mouseEvent.getY() <= 526))
            return;
        myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
        competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
        mySiegeSpecialCard.setStyle("-fx-background-color: transparent;");
        myRangedSpecialCard.setStyle("-fx-background-color: transparent;");
        myCloseCombatSpecialCard.setStyle("-fx-background-color: transparent;");
        competitorSiegeSpecialCard.setStyle("-fx-background-color: transparent;");
        competitorRangedSpecialCard.setStyle("-fx-background-color: transparent;");
        competitorCloseCombatSpecialCard.setStyle("-fx-background-color: transparent;");
        weatherCards.setStyle("-fx-background-color: transparent;");

        selectedCommonCard = null;
        selectedSpecialCard = null;
        bigCardShow.setImage(null);
    }

    public void unSelectCard() {
        if (isTransitioning) {
            return;
        }
        myCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        competitorCloseCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        myRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        competitorRangedCombatCardsPlayed.setStyle("-fx-background-color: transparent;");
        mySiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
        competitorSiegeCardsPlayed.setStyle("-fx-background-color: transparent;");
        mySiegeSpecialCard.setStyle("-fx-background-color: transparent;");
        myRangedSpecialCard.setStyle("-fx-background-color: transparent;");
        myCloseCombatSpecialCard.setStyle("-fx-background-color: transparent;");
        competitorSiegeSpecialCard.setStyle("-fx-background-color: transparent;");
        competitorRangedSpecialCard.setStyle("-fx-background-color: transparent;");
        competitorCloseCombatSpecialCard.setStyle("-fx-background-color: transparent;");
        weatherCards.setStyle("-fx-background-color: transparent;");

        selectedCommonCard = null;
        selectedSpecialCard = null;
        bigCardShow.setImage(null);
    }

    public void focusOnImageForStart(ImageView imageView) {
        if (isTransitioning) {
            return;
        }
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(250), imageView);
        translateTransition.setToX(0);
        translateTransition.setToY(-20);
        translateTransition.play();
    }

    public void focusOnImage(MouseEvent mouseEvent) {
        if (isTransitioning) {
            return;
        }
        StackPane stackPane = (StackPane) mouseEvent.getSource();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(250), stackPane);
        translateTransition.setToX(0);
        translateTransition.setToY(-11);
        translateTransition.play();
    }

    public void unFocusForStart(ImageView imageView) {
        if (isTransitioning) {
            return;
        }
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(250), imageView);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.play();
    }

    public void unFocus(MouseEvent mouseEvent) {
        if (isTransitioning) {
            return;
        }
        StackPane stackPane = (StackPane) mouseEvent.getSource();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(250), stackPane);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.play();
    }

    public void putCardInMyCloseCombatRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedCommonCard == null || (!selectedCommonCard.getPlayField().equals("Close Combat") && !selectedCommonCard.getPlayField().equals("Agile")) || selectedCommonCard.getAbility().contains("Spy"))
            return;
        gameBattleFieldController.putCommonCardCloseCombat(selectedCommonCard, false);
        updateBoard();
        if (selectedCommonCard.getAbility().contains("Medic")) {
            setAnimationForCloseCombat(medicAnimation);
        } else if (selectedCommonCard.getAbility().contains("Tight Bond")) {
            setAnimationForCloseCombat(bondAnimation);
        } else if (selectedCommonCard.getAbility().contains("Muster")) {
            gameBattleFieldController.bondAbility(selectedCommonCard);
            setAnimationForCloseCombat(musterAnimation);
        } else if (selectedCommonCard.getAbility().contains("Morale")) {
            setAnimationForCloseCombat(moraleAnimation);
        } else if (selectedCommonCard.getAbility().contains("Commander's Horn")) {
            setAnimationForCloseCombat(hornAnimation);
        } else {
            unSelectCard();
            updateBoard();
            changeTurn();
        }
    }

    public void putCardInMyRangedRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedCommonCard == null || (!selectedCommonCard.getPlayField().equals("Ranged") && !selectedCommonCard.getPlayField().equals("Agile")) || selectedCommonCard.getAbility().contains("Spy"))
            return;
        gameBattleFieldController.putCommonCardRanged(selectedCommonCard, false);
        updateBoard();
        if (selectedCommonCard.getAbility().contains("Medic")) {
            setAnimationForRanged(medicAnimation);
        } else if (selectedCommonCard.getAbility().contains("Tight Bond")) {
            setAnimationForRanged(bondAnimation);
        } else if (selectedCommonCard.getAbility().contains("Muster")) {
            gameBattleFieldController.bondAbility(selectedCommonCard);
            setAnimationForRanged(musterAnimation);
        } else if (selectedCommonCard.getAbility().contains("Morale")) {
            setAnimationForRanged(moraleAnimation);
        } else if (selectedCommonCard.getAbility().contains("Commander's Horn")) {
            setAnimationForRanged(hornAnimation);
        } else {
            unSelectCard();
            updateBoard();
            changeTurn();
        }
    }

    public void putCardInMySiegeRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedCommonCard == null || !selectedCommonCard.getPlayField().equals("Siege") || selectedCommonCard.getAbility().contains("Spy"))
            return;
        gameBattleFieldController.putCommonCardSiege(selectedCommonCard, false);
        updateBoard();
        if (selectedCommonCard.getAbility().contains("Medic")) {
            setAnimationForSiege(medicAnimation);
        } else if (selectedCommonCard.getAbility().contains("Tight Bond")) {
            setAnimationForSiege(bondAnimation);
        } else if (selectedCommonCard.getAbility().contains("Muster")) {
            gameBattleFieldController.bondAbility(selectedCommonCard);
            setAnimationForSiege(musterAnimation);
        } else if (selectedCommonCard.getAbility().contains("Morale")) {
            setAnimationForSiege(moraleAnimation);
        } else if (selectedCommonCard.getAbility().contains("Commander's Horn")) {
            setAnimationForSiege(hornAnimation);
        } else {
            unSelectCard();
            updateBoard();
            changeTurn();
        }
    }

    public void putCardInCompetitorSiegeRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedCommonCard != null && selectedCommonCard.getAbility().contains("Spy") && selectedCommonCard.getPlayField().equals("Close Combat")) {
            StackPane stackPane;
            gameBattleFieldController.putCommonCardSiege(selectedCommonCard, true);
            updateBoard();
            if (whichUserIsNotTurn().equals(gameBattleField.getUser1())) {
                int number = 0;
                for (int i = 0; i < siegeIsPlayedUser1.size(); i++) {
                    if (siegeIsPlayedUser1.get(i).equals(selectedCommonCard)) number = i;
                }
                stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(number);
                ImageView imageView = new ImageView(spyAnimation);
                imageView.setFitWidth(40);
                imageView.setFitHeight(35);
                StackPane.setAlignment(imageView, Pos.CENTER);
                stackPane.getChildren().add(imageView);
            } else {
                int number = 0;
                for (int i = 0; i < siegeIsPlayedUser2.size(); i++) {
                    if (siegeIsPlayedUser2.get(i).equals(selectedCommonCard)) number = i;
                }
                stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(number);
                ImageView imageView = new ImageView(spyAnimation);
                imageView.setFitWidth(40);
                imageView.setFitHeight(35);
                StackPane.setAlignment(imageView, Pos.CENTER);
                stackPane.getChildren().add(imageView);
            }
            unSelectCard();
            gameBattleFieldController.spyAbility();
            isTransitioning = true;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5),
                    event -> {
                        isTransitioning = false;
                        stackPane.getChildren().removeLast();
                        updateBoard();
                        changeTurn();
                    }));
            timeline.play();
        }
    }

    public void putCardInCompetitorCloseCombatRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedCommonCard != null && selectedCommonCard.getAbility().contains("Spy") && selectedCommonCard.getPlayField().equals("Close Combat")) {
            StackPane stackPane;
            gameBattleFieldController.putCommonCardCloseCombat(selectedCommonCard, true);
            updateBoard();
            if (whichUserIsNotTurn().equals(gameBattleField.getUser1())) {
                int number = 0;
                for (int i = 0; i < closeCombatPlayedUser1.size(); i++) {
                    if (closeCombatPlayedUser1.get(i).equals(selectedCommonCard)) number = i;
                }
                stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(number);
                ImageView imageView = new ImageView(spyAnimation);
                imageView.setFitWidth(40);
                imageView.setFitHeight(35);
                StackPane.setAlignment(imageView, Pos.CENTER);
                stackPane.getChildren().add(imageView);
            } else {
                int number = 0;
                for (int i = 0; i < closeCombatPlayedUser2.size(); i++) {
                    if (closeCombatPlayedUser2.get(i).equals(selectedCommonCard)) number = i;
                }
                stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(number);
                ImageView imageView = new ImageView(spyAnimation);
                imageView.setFitWidth(40);
                imageView.setFitHeight(35);
                StackPane.setAlignment(imageView, Pos.CENTER);
                stackPane.getChildren().add(imageView);
            }
            unSelectCard();
            gameBattleFieldController.spyAbility();
            isTransitioning = true;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5),
                    event -> {
                        isTransitioning = false;
                        stackPane.getChildren().removeLast();
                        updateBoard();
                        changeTurn();
                    }));
            timeline.play();
        }
    }

    public void putSpecialCardInSiegeRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.CommandersHorn) && ((ImageView) mySiegeSpecialCard.getChildren().getFirst()).getImage() == null) {
            gameBattleFieldController.putSpecialCardInSpecialFieldSiege(selectedSpecialCard);
            StackPane stackPane = mySiegeSpecialCard;
            updateBoard();
            ImageView imageView = new ImageView(hornAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
            unSelectCard();
            isTransitioning = true;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5),
                    event -> {
                        isTransitioning = false;
                        stackPane.getChildren().removeLast();
                        updateBoard();
                        changeTurn();
                    }));
            timeline.play();
        } else if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Mardroeme) && ((ImageView) mySiegeSpecialCard.getChildren().getFirst()).getImage() == null) {
            gameBattleFieldController.putSpecialCardInSpecialFieldSiege(selectedSpecialCard);
            updateBoard();
            unSelectCard();
            changeTurn();
        }
    }

    public void putSpecialCardInRangedRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.CommandersHorn) && ((ImageView) myRangedSpecialCard.getChildren().getFirst()).getImage() == null) {
            gameBattleFieldController.putSpecialCardInSpecialFieldRanged(selectedSpecialCard);
            StackPane stackPane = myRangedSpecialCard;
            updateBoard();
            ImageView imageView = new ImageView(hornAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
            unSelectCard();
            isTransitioning = true;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5),
                    event -> {
                        isTransitioning = false;
                        stackPane.getChildren().removeLast();
                        updateBoard();
                        changeTurn();
                    }));
            timeline.play();
        } else if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Mardroeme) && ((ImageView) myRangedSpecialCard.getChildren().getFirst()).getImage() == null) {
            gameBattleFieldController.putSpecialCardInSpecialFieldRanged(selectedSpecialCard);
            updateBoard();
            unSelectCard();
            changeTurn();
        }
    }

    public void putSpecialCardInCloseCombatRow() {
        if (isTransitioning) {
            return;
        }
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.CommandersHorn) && ((ImageView) myCloseCombatSpecialCard.getChildren().getFirst()).getImage() == null) {
            gameBattleFieldController.putSpecialCardInSpecialFieldCloseCombat(selectedSpecialCard);
            StackPane stackPane = myCloseCombatSpecialCard;
            updateBoard();
            ImageView imageView = new ImageView(hornAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
            unSelectCard();
            isTransitioning = true;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5),
                    event -> {
                        isTransitioning = false;
                        stackPane.getChildren().removeLast();
                        updateBoard();
                        changeTurn();
                    }));
            timeline.play();
        } else if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Mardroeme) && ((ImageView) myCloseCombatSpecialCard.getChildren().getFirst()).getImage() == null) {
            gameBattleFieldController.putSpecialCardInSpecialFieldCloseCombat(selectedSpecialCard);
            updateBoard();
            unSelectCard();
            changeTurn();
        }
    }

    public boolean isWeatherCard(SpecialCard selectedSpecialCard) {
        return selectedSpecialCard.equals(SpecialCard.BitingFrost) || selectedSpecialCard.equals(SpecialCard.ClearWeather)
                || selectedSpecialCard.equals(SpecialCard.SkelligeStorm) || selectedSpecialCard.equals(SpecialCard.ImpenetrableFog)
                || selectedSpecialCard.equals(SpecialCard.TorrentialRain);
    }

    private void setAnimationForSiege(Image medicAnimation) {
        StackPane stackPane;
        int number = 0;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < siegeIsPlayedUser1.size(); i++) {
                if (siegeIsPlayedUser1.get(i).equals(selectedCommonCard)) {
                    number = i;
                    break;
                }
            }
            stackPane = (StackPane) mySiegeCardsPlayed.getChildren().get(number);
            ImageView imageView = new ImageView(medicAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
        } else {
            for (int i = 0; i < siegeIsPlayedUser2.size(); i++) {
                if (siegeIsPlayedUser2.get(i).equals(selectedCommonCard)) {
                    number = i;
                    break;
                }
            }
            stackPane = (StackPane) mySiegeCardsPlayed.getChildren().get(number);
            ImageView imageView = new ImageView(medicAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
        }
        unSelectCard();
        isTransitioning = true;
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1.5),
                event -> {
                    isTransitioning = false;
                    stackPane.getChildren().removeLast();
                    updateBoard();
                    changeTurn();
                }));
        timeline.play();
    }

    private void setAnimationForCloseCombat(Image medicAnimation) {
        StackPane stackPane;
        int number = 0;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < closeCombatPlayedUser1.size(); i++) {
                if (closeCombatPlayedUser1.get(i).equals(selectedCommonCard)) {
                    number = i;
                    break;
                }
            }
            stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(number);
            ImageView imageView = new ImageView(medicAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
        } else {
            for (int i = 0; i < closeCombatPlayedUser2.size(); i++) {
                if (closeCombatPlayedUser2.get(i).equals(selectedCommonCard)) {
                    number = i;
                    break;
                }
            }
            stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(number);
            ImageView imageView = new ImageView(medicAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
        }
        unSelectCard();
        isTransitioning = true;
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1.5),
                event -> {
                    isTransitioning = false;
                    stackPane.getChildren().removeLast();
                    updateBoard();
                    changeTurn();
                }));
        timeline.play();
    }

    private void setAnimationForRanged(Image medicAnimation) {
        StackPane stackPane;
        int number = 0;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < rangedIsPlayedUser1.size(); i++) {
                if (rangedIsPlayedUser1.get(i).equals(selectedCommonCard)) {
                    number = i;
                    break;
                }
            }
            stackPane = (StackPane) myRangedCombatCardsPlayed.getChildren().get(number);
            ImageView imageView = new ImageView(medicAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
        } else {
            for (int i = 0; i < rangedIsPlayedUser2.size(); i++) {
                if (rangedIsPlayedUser2.get(i).equals(selectedCommonCard)) {
                    number = i;
                    break;
                }
            }
            stackPane = (StackPane) myRangedCombatCardsPlayed.getChildren().get(number);
            ImageView imageView = new ImageView(medicAnimation);
            imageView.setFitWidth(40);
            imageView.setFitHeight(35);
            StackPane.setAlignment(imageView, Pos.CENTER);
            stackPane.getChildren().add(imageView);
        }
        unSelectCard();
        isTransitioning = true;
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1.5),
                event -> {
                    isTransitioning = false;
                    stackPane.getChildren().removeLast();
                    updateBoard();
                    changeTurn();
                }));
        timeline.play();
    }

    public void putWeatherCard() {
        if (isTransitioning) {
            return;
        }
        if (selectedSpecialCard == null || !isWeatherCard(selectedSpecialCard) || gameBattleField.getWeatherCards().size() == 3)
            return;
        gameBattleFieldController.putWeatherCardToSpecialFieldForWeatherCard(selectedSpecialCard);
        if (selectedSpecialCard.equals(SpecialCard.BitingFrost)) {
            ImageView frostImageView = new ImageView(putFrostWeather);
            frostImageView.setFitWidth(myCloseCombatCardsPlayed.getWidth());
            frostImageView.setFitHeight(myCloseCombatCardsPlayed.getHeight() + 5 + 5);
            frostImageView.setX(myCloseCombatCardsPlayed.getLayoutX());
            frostImageView.setY(myCloseCombatCardsPlayed.getLayoutY());
            frostImageView.setOnMouseClicked(e -> putCardInMyCloseCombatRow());
            pane.getChildren().add(frostImageView);

            ImageView frostImageView2 = new ImageView(putFrostWeather);
            frostImageView2.setFitWidth(myCloseCombatCardsPlayed.getWidth());
            frostImageView2.setFitHeight(myCloseCombatCardsPlayed.getHeight() + 5);
            frostImageView2.setX(competitorCloseCombatCardsPlayed.getLayoutX());
            frostImageView2.setY(competitorCloseCombatCardsPlayed.getLayoutY());
            frostImageView2.setOnMouseClicked(e -> putCardInCompetitorCloseCombatRow());
            pane.getChildren().add(frostImageView2);
            unSelectCard();
            updateBoard();
            changeTurn();
        } else if (selectedSpecialCard.equals(SpecialCard.ImpenetrableFog)) {
            ImageView fogImageView = new ImageView(putFogWeather);
            fogImageView.setFitWidth(myRangedCombatCardsPlayed.getWidth());
            fogImageView.setFitHeight(myRangedCombatCardsPlayed.getHeight() + 5);
            fogImageView.setX(myRangedCombatCardsPlayed.getLayoutX());
            fogImageView.setY(myRangedCombatCardsPlayed.getLayoutY());
            fogImageView.setOnMouseClicked(e -> putCardInMyRangedRow());
            pane.getChildren().add(fogImageView);

            ImageView fogImageView2 = new ImageView(putFogWeather);
            fogImageView2.setFitWidth(myRangedCombatCardsPlayed.getWidth());
            fogImageView2.setFitHeight(myRangedCombatCardsPlayed.getHeight() + 5);
            fogImageView2.setX(competitorRangedCombatCardsPlayed.getLayoutX());
            fogImageView2.setY(competitorRangedCombatCardsPlayed.getLayoutY());
            pane.getChildren().add(fogImageView2);
            unSelectCard();
            updateBoard();
            changeTurn();
        } else if (selectedSpecialCard.equals(SpecialCard.TorrentialRain)) {
            ImageView rainImageView = new ImageView(putRainWeather);
            rainImageView.setFitWidth(mySiegeCardsPlayed.getWidth());
            rainImageView.setFitHeight(mySiegeCardsPlayed.getHeight() + 5);
            rainImageView.setX(mySiegeCardsPlayed.getLayoutX());
            rainImageView.setY(mySiegeCardsPlayed.getLayoutY());
            rainImageView.setOnMouseClicked(e -> putCardInMySiegeRow());
            pane.getChildren().add(rainImageView);

            ImageView rainImageView2 = new ImageView(putRainWeather);
            rainImageView2.setFitWidth(mySiegeCardsPlayed.getWidth());
            rainImageView2.setFitHeight(mySiegeCardsPlayed.getHeight() + 5);
            rainImageView2.setX(competitorSiegeCardsPlayed.getLayoutX());
            rainImageView2.setY(competitorSiegeCardsPlayed.getLayoutY());
            rainImageView2.setOnMouseClicked(e -> putCardInCompetitorSiegeRow());
            pane.getChildren().add(rainImageView2);
            unSelectCard();
            updateBoard();
            changeTurn();
        } else if (selectedSpecialCard.equals(SpecialCard.SkelligeStorm)) {
            ImageView fogImageView = new ImageView(putFogWeather);
            fogImageView.setFitWidth(myRangedCombatCardsPlayed.getWidth());
            fogImageView.setFitHeight(myRangedCombatCardsPlayed.getHeight() + 5);
            fogImageView.setX(myRangedCombatCardsPlayed.getLayoutX());
            fogImageView.setY(myRangedCombatCardsPlayed.getLayoutY());
            fogImageView.setOnMouseClicked(e -> putCardInMyRangedRow());
            pane.getChildren().add(fogImageView);

            ImageView fogImageView2 = new ImageView(putFogWeather);
            fogImageView2.setFitWidth(myRangedCombatCardsPlayed.getWidth());
            fogImageView2.setFitHeight(myRangedCombatCardsPlayed.getHeight() + 5);
            fogImageView2.setX(competitorRangedCombatCardsPlayed.getLayoutX());
            fogImageView2.setY(competitorRangedCombatCardsPlayed.getLayoutY());
            pane.getChildren().add(fogImageView2);

            ImageView rainImageView = new ImageView(putRainWeather);
            rainImageView.setFitWidth(mySiegeCardsPlayed.getWidth());
            rainImageView.setFitHeight(mySiegeCardsPlayed.getHeight() + 5);
            rainImageView.setX(mySiegeCardsPlayed.getLayoutX());
            rainImageView.setY(mySiegeCardsPlayed.getLayoutY());
            rainImageView.setOnMouseClicked(e -> putCardInMySiegeRow());
            pane.getChildren().add(rainImageView);

            ImageView rainImageView2 = new ImageView(putRainWeather);
            rainImageView2.setFitWidth(mySiegeCardsPlayed.getWidth());
            rainImageView2.setFitHeight(mySiegeCardsPlayed.getHeight() + 5);
            rainImageView2.setX(competitorSiegeCardsPlayed.getLayoutX());
            rainImageView2.setY(competitorSiegeCardsPlayed.getLayoutY());
            rainImageView2.setOnMouseClicked(e -> putCardInCompetitorSiegeRow());
            pane.getChildren().add(rainImageView2);

            unSelectCard();
            updateBoard();
            changeTurn();
        } else if (selectedSpecialCard.equals(SpecialCard.ClearWeather)) {
            for (int i = pane.getChildren().size() - 8; i < pane.getChildren().size(); i++) {
                Node node = pane.getChildren().get(i);
                if (node instanceof ImageView && node.getId() == null) {
                    pane.getChildren().remove(node);
                    i -= 1;
                }
            }
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                gameBattleField.getSpecialCardsDiscardUser1().add(SpecialCard.ClearWeather);
            } else {
                gameBattleField.getSpecialCardsDiscardUser2().add(SpecialCard.ClearWeather);
            }
            gameBattleField.getWeatherCards().remove(SpecialCard.ClearWeather);

            Collections.shuffle(gameBattleField.getWeatherCards());
            int totalCards = gameBattleField.getWeatherCards().size();
            if (totalCards == 1) {
                if (whichUserIsNotTurn().equals(gameBattleField.getUser1())) {
                    gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getWeatherCards().getFirst());
                } else {
                    gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getWeatherCards().getFirst());
                }
            } else if (totalCards == 2) {
                if (whichUserIsNotTurn().equals(gameBattleField.getUser1())) {
                    gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getWeatherCards().getFirst());
                    gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getWeatherCards().get(1));
                } else {
                    gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getWeatherCards().getFirst());
                    gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getWeatherCards().get(1));
                }
            } else if (totalCards == 3) {
                if (whichUserIsNotTurn().equals(gameBattleField.getUser1())) {
                    gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getWeatherCards().getFirst());
                    gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getWeatherCards().get(1));
                    gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getWeatherCards().get(2));
                } else {
                    gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getWeatherCards().getFirst());
                    gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getWeatherCards().get(1));
                    gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getWeatherCards().get(2));
                }
            }


            gameBattleField.getWeatherCards().clear();
            unSelectCard();
            updateBoard();
            changeTurn();
        }
    }
}
