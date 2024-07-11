package Sample.Controller;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.Faction;
import Sample.CardEnums.Leader;
import Sample.CardEnums.SpecialCard;
import Sample.Model.GameBattleField;
import Sample.Model.User;
import Sample.View.LoginMenu;
import Sample.View.MainMenu;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import static javafx.scene.text.TextAlignment.CENTER;

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
    private StackPane myLastDiscard;
    @FXML
    private StackPane competitorLastDiscard;
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
    private final Image profilePng = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/profile.png")));
    private final Image putRainWeather = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/overlay_rain.png")));
    private final Image putFrostWeather = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/overlay_frost.png")));
    private final Image putFogWeather = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/overlay_fog.png")));

    private CommonCard selectedCommonCard = null;
    private SpecialCard selectedSpecialCard = null;

    private boolean isTransitioning = false;
    private boolean isFirstTimeForUser1 = true;
    private boolean isFirstTimeForUser2 = true;
    private boolean cross2Spy = false;
    private boolean isResistantAgainstWeather = false;
    private int numberOfCardsChanged = 0;
    private HBox allCards;
    private final GameBattleField gameBattleField = User.getUserLoginIn().getLastGameBattleField();
    private GameBattleFieldController gameBattleFieldController;

    public void initialize() {
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> passIfDonNotHaveAnyCard());
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        gameBattleFieldController = new GameBattleFieldController(gameBattleField);
        gameBattleFieldController.cloneChosenDeckForUsingInGame();
        gameBattleFieldController.giveRandomInitialCards();
        if (isFirstTimeForUser1) {
            isFirstTimeForUser1 = false;
            changeTwoCardsOfDeck();
        }
        if (gameBattleField.getUser1().getFactionLeader().equals(Leader.EmperorOfNilfgaard)
                || gameBattleField.getUser2().getFactionLeader().equals(Leader.EmperorOfNilfgaard)) {
            gameBattleField.setExistAbilityUser1(false);
            gameBattleField.setExistAbilityUser2(false);
        }
        Random random = new Random();
        boolean isSpecial;
        if (gameBattleField.getUser1().getFactionLeader().equals(Leader.DaisyOfTheValley)) {
            isSpecial = random.nextBoolean();
            if (isSpecial) {
                SpecialCard specialCard = gameBattleFieldController.giveOneRandomSpecialCardToUserPlayed(gameBattleField.getUser1());
                if (specialCard == null)
                    gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser1());
            } else {
                gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser1());
            }
            gameBattleField.setExistAbilityUser1(false);
        }
        if (gameBattleField.getUser2().getFactionLeader().equals(Leader.DaisyOfTheValley)) {
            isSpecial = random.nextBoolean();
            if (isSpecial) {
                SpecialCard specialCard = gameBattleFieldController.giveOneRandomSpecialCardToUserPlayed(gameBattleField.getUser2());
                if (specialCard == null)
                    gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser2());
            } else {
                gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser2());
            }
            gameBattleField.setExistAbilityUser2(false);
        }
        updateBoard();
    }

    private void passIfDonNotHaveAnyCard() {
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (gameBattleField.getSpecialCardsBattleFieldUser1().isEmpty() && gameBattleField.getCommonCardInBattleFieldUser1().isEmpty()) {
                pass();
            }
        } else {
            if (gameBattleField.getSpecialCardsBattleFieldUser2().isEmpty() && gameBattleField.getCommonCardInBattleFieldUser2().isEmpty()) {
                pass();
            }
        }
    }

    private void changeTwoCardsOfDeck() {
        GaussianBlur gaussianBlur = new GaussianBlur(20);
        pane.setEffect(gaussianBlur);

        allCards = new HBox(1050);
        allCards.setLayoutX(90);
        allCards.setLayoutY(200);
        allCards.setSpacing(10);
        allCards.setAlignment(Pos.CENTER);
        allCards.setEffect(new GaussianBlur(0));

        Button cancelButton = new Button("Cancel Veto");
        cancelButton.setStyle(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("CSS/style.css")).toString());
        cancelButton.setStyle("-fx-background-color: #000000;");
        cancelButton.setLayoutX(580);
        cancelButton.setLayoutY(500);
        cancelButton.setOnMouseClicked(e -> cancelVeto());

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            allCards.getChildren().clear();
            for (int i = 0; i < gameBattleField.getSpecialCardsBattleFieldUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsBattleFieldUser1().get(i).getImage(), i);
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardInBattleFieldUser1().get(i).getImage(), i + gameBattleField.getSpecialCardsBattleFieldUser1().size());
                allCards.getChildren().add(imageView);
            }
        } else {
            allCards.getChildren().clear();
            for (int i = 0; i < gameBattleField.getSpecialCardsBattleFieldUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsBattleFieldUser2().get(i).getImage(), i);
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardInBattleFieldUser2().get(i).getImage(), i + gameBattleField.getSpecialCardsBattleFieldUser2().size());
                allCards.getChildren().add(imageView);
            }
        }

        Pane overlayPane = new Pane();
        overlayPane.getChildren().addAll(allCards, cancelButton);

        parentPane.getChildren().add(overlayPane);
    }

    private ImageView getImageView(Image gameBattleField, int i) {
        ImageView imageView = new ImageView(gameBattleField);
        imageView.setFitWidth(100);
        imageView.setFitHeight(200);
        imageView.setOnMouseMoved(e -> focusOnImageForStart(imageView));
        imageView.setOnMouseExited(e -> unFocusForStart(imageView));
        imageView.setOnMouseClicked(e -> changeCard(imageView));
        imageView.setId(String.valueOf(i));
        return imageView;
    }

    private void cancelVeto() {
        allCards.getChildren().clear();
        parentPane.getChildren().removeLast();
        pane.setEffect(null);
        numberOfCardsChanged = 0;
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
            numberOfCardsChanged = 0;
        }
    }


    private void updateBoard() {
        if (isFirstTimeForUser2 && gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2())) {
            isFirstTimeForUser2 = false;
            changeTwoCardsOfDeck();
        }
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


        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.7);
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            firstPlayerPassedLabel.setVisible(gameBattleField.isPassedUser1());
            secondPlayerPassedLabel.setVisible(gameBattleField.isPassedUser2());

            if (gameBattleField.isExistAbilityUser1()) myLeader.setEffect(null);
            else myLeader.setEffect(colorAdjust);
            if (gameBattleField.isExistAbilityUser2()) competitorLeader.setEffect(null);
            else competitorLeader.setEffect(colorAdjust);
        } else {
            firstPlayerPassedLabel.setVisible(gameBattleField.isPassedUser2());
            secondPlayerPassedLabel.setVisible(gameBattleField.isPassedUser1());

            if (gameBattleField.isExistAbilityUser2()) myLeader.setEffect(null);
            else myLeader.setEffect(colorAdjust);
            if (gameBattleField.isExistAbilityUser1()) competitorLeader.setEffect(null);
            else competitorLeader.setEffect(colorAdjust);
        }

        if (specialFieldInCloseCombatUser1 != null && specialFieldInCloseCombatUser1.equals(SpecialCard.Mardroeme)) {
            for (int i = 0; i < closeCombatPlayedUser1.size(); i++) {
                if (closeCombatPlayedUser1.get(i).equals(CommonCard.Berserker)) {
                    closeCombatPlayedUser1.add(i + 1, CommonCard.TransformedVildkaarl);
                    closeCombatPlayedUser1.remove(CommonCard.Berserker);
                }
            }
        }
        if (specialFieldInRangedUser1 != null && specialFieldInRangedUser1.equals(SpecialCard.Mardroeme) || rangedIsPlayedUser1.contains(CommonCard.Ermion)) {
            for (int i = 0; i < rangedIsPlayedUser1.size(); i++) {
                if (rangedIsPlayedUser1.get(i).equals(CommonCard.YoungBerserker)) {
                    rangedIsPlayedUser1.add(i + 1, CommonCard.TransformedYoungVildkaarl);
                    rangedIsPlayedUser1.remove(CommonCard.YoungBerserker);
                }
            }
        }

        if (specialFieldInCloseCombatUser2 != null && specialFieldInCloseCombatUser2.equals(SpecialCard.Mardroeme)) {
            for (int i = 0; i < closeCombatPlayedUser2.size(); i++) {
                if (closeCombatPlayedUser2.get(i).equals(CommonCard.Berserker)) {
                    closeCombatPlayedUser2.add(i + 1, CommonCard.TransformedVildkaarl);
                    closeCombatPlayedUser2.remove(CommonCard.Berserker);
                }
            }
        }
        if (specialFieldInRangedUser2 != null && specialFieldInRangedUser2.equals(SpecialCard.Mardroeme) || rangedIsPlayedUser2.contains(CommonCard.Ermion)) {
            for (int i = 0; i < rangedIsPlayedUser2.size(); i++) {
                if (rangedIsPlayedUser2.get(i).equals(CommonCard.YoungBerserker)) {
                    rangedIsPlayedUser2.add(i + 1, CommonCard.TransformedYoungVildkaarl);
                    rangedIsPlayedUser2.remove(CommonCard.YoungBerserker);
                }
            }
        }

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

            setImageOfDiscard(gameBattleField.getCommonCardsInDiscardUser1(), myLastDiscard, gameBattleField.getSpecialCardsDiscardUser1());
            setImageOfDiscard(gameBattleField.getCommonCardsInDiscardUser2(), competitorLastDiscard, gameBattleField.getSpecialCardsDiscardUser2());
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

            setImageOfDiscard(gameBattleField.getCommonCardsInDiscardUser2(), myLastDiscard, gameBattleField.getSpecialCardsDiscardUser2());
            setImageOfDiscard(gameBattleField.getCommonCardsInDiscardUser1(), competitorLastDiscard, gameBattleField.getSpecialCardsDiscardUser1());
        }

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

    private void setImageOfDiscard(ArrayList<CommonCard> gameBattleField, StackPane myLastDiscard, ArrayList<SpecialCard> gameBattleField1) {
        if (!gameBattleField.isEmpty()) {
            String playField = gameBattleField.getLast().getPlayField();
            ((ImageView) myLastDiscard.getChildren().getFirst()).setImage(gameBattleField.getLast().getImageForGame());
            if (gameBattleField.getLast().isHero()) {
                ((ImageView) myLastDiscard.getChildren().get(1)).setImage(powerHeroImage);
                ((Label) myLastDiscard.getChildren().get(2)).setTextFill(Color.WHITE);
            } else if (playField != null) {
                ((ImageView) myLastDiscard.getChildren().get(1)).setImage(powerNormalImage);
                ((Label) myLastDiscard.getChildren().get(2)).setTextFill(Color.BLACK);
            } else {
                ((ImageView) myLastDiscard.getChildren().get(1)).setImage(decoyPower);
            }
            if (playField != null) {
                ((Label) myLastDiscard.getChildren().get(2)).setText(String.valueOf(gameBattleField.getLast().getScore()));
                myLastDiscard.getChildren().get(2).setVisible(true);
            }

            if (playField != null) {
                switch (playField) {
                    case "Close Combat" -> ((ImageView) myLastDiscard.getChildren().get(3)).setImage(cardRowClose);
                    case "Ranged" -> ((ImageView) myLastDiscard.getChildren().get(3)).setImage(cardRowRanged);
                    case "Siege" -> ((ImageView) myLastDiscard.getChildren().get(3)).setImage(cardRowSiege);
                    case "Agile" -> ((ImageView) myLastDiscard.getChildren().get(3)).setImage(cardRowAgile);
                }
            }

            String ability = gameBattleField.getLast().getAbility();
            if (ability.contains("Transform"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityAvenger);
            else if (ability.contains("Muster"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityMuster);
            else if (ability.contains("Commander's Horn"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityHorn);
            else if (ability.contains("Morale Boost")) {
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityMorale);
            } else if (ability.contains("Tight Bond"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityBond);
            else if (ability.contains("Increase Score By Mardroeme"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityBerserker);
            else if (ability.contains("Mardroeme"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityMardroeme);
            else if (ability.contains("Scorch")) {
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityScorch);
            } else if (ability.contains("Spy"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilitySpy);
            else if (ability.contains("Medic"))
                ((ImageView) myLastDiscard.getChildren().get(4)).setImage(cardAbilityMedic);

        } else if (!gameBattleField1.isEmpty()) {
            ((ImageView) myLastDiscard.getChildren().getFirst()).setImage(gameBattleField1.getLast().getImageForGame());
            ((ImageView) myLastDiscard.getChildren().get(1)).setImage(gameBattleField1.getLast().getImageForPower());
            myLastDiscard.getChildren().get(2).setVisible(false);
            ((ImageView) myLastDiscard.getChildren().get(3)).setImage(null);
            ((ImageView) myLastDiscard.getChildren().get(4)).setImage(null);
        }
    }

    private void putCardsInBoard() {
        removeAllCards();
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            putMyBattleFieldCards(specialCardsBattleFieldUser1, commonCardInBattleFieldUser1);
            putCommonCardsInRows(closeCombatPlayedUser1, myCloseCombatCardsPlayed, 1);
            putCommonCardsInRows(rangedIsPlayedUser1, myRangedCombatCardsPlayed, 2);
            putCommonCardsInRows(siegeIsPlayedUser1, mySiegeCardsPlayed, 3);

            putSpecialCardInRows(specialFieldInCloseCombatUser1, specialFieldInSiegeUser1, specialFieldInRangedUser1, true);

            putCommonCardsInRows(closeCombatPlayedUser2, competitorCloseCombatCardsPlayed, 1);
            putCommonCardsInRows(rangedIsPlayedUser2, competitorRangedCombatCardsPlayed, 2);
            putCommonCardsInRows(siegeIsPlayedUser2, competitorSiegeCardsPlayed, 3);

            putSpecialCardInRows(specialFieldInCloseCombatUser2, specialFieldInSiegeUser2, specialFieldInRangedUser2, false);
        } else {
            putMyBattleFieldCards(specialCardsBattleFieldUser2, commonCardInBattleFieldUser2);
            putCommonCardsInRows(closeCombatPlayedUser2, myCloseCombatCardsPlayed, 1);
            putCommonCardsInRows(rangedIsPlayedUser2, myRangedCombatCardsPlayed, 2);
            putCommonCardsInRows(siegeIsPlayedUser2, mySiegeCardsPlayed, 3);

            putSpecialCardInRows(specialFieldInCloseCombatUser2, specialFieldInSiegeUser2, specialFieldInRangedUser2, true);

            putCommonCardsInRows(closeCombatPlayedUser1, competitorCloseCombatCardsPlayed, 1);
            putCommonCardsInRows(rangedIsPlayedUser1, competitorRangedCombatCardsPlayed, 2);
            putCommonCardsInRows(siegeIsPlayedUser1, competitorSiegeCardsPlayed, 3);

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
        for (Node child : myLastDiscard.getChildren()) {
            if (child instanceof ImageView) ((ImageView) child).setImage(null);
            else if (child instanceof Label) child.setVisible(false);
        }
        for (Node child : competitorLastDiscard.getChildren()) {
            if (child instanceof ImageView) ((ImageView) child).setImage(null);
            else if (child instanceof Label) child.setVisible(false);
        }
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
            else if (ability.contains("Mardroeme"))
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityMardroeme);
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
            } else {
                ((ImageView) myCloseCombatSpecialCard.getChildren().getFirst()).setImage(null);
                ((ImageView) myCloseCombatSpecialCard.getChildren().get(1)).setImage(null);
            }
            if (specialFieldInSiegeUser1 != null) {
                ((ImageView) mySiegeSpecialCard.getChildren().getFirst()).setImage(specialFieldInSiegeUser1.getImageForGame());
                ((ImageView) mySiegeSpecialCard.getChildren().get(1)).setImage(specialFieldInSiegeUser1.getImageForPower());
            } else {
                ((ImageView) mySiegeSpecialCard.getChildren().getFirst()).setImage(null);
                ((ImageView) mySiegeSpecialCard.getChildren().get(1)).setImage(null);
            }
            if (specialFieldInRangedUser1 != null) {
                ((ImageView) myRangedSpecialCard.getChildren().getFirst()).setImage(specialFieldInRangedUser1.getImageForGame());
                ((ImageView) myRangedSpecialCard.getChildren().get(1)).setImage(specialFieldInRangedUser1.getImageForPower());
            } else {
                ((ImageView) myRangedSpecialCard.getChildren().getFirst()).setImage(null);
                ((ImageView) myRangedSpecialCard.getChildren().get(1)).setImage(null);
            }
        } else {
            if (specialFieldInCloseCombatUser1 != null) {
                ((ImageView) competitorCloseCombatSpecialCard.getChildren().getFirst()).setImage(specialFieldInCloseCombatUser1.getImageForGame());
                ((ImageView) competitorCloseCombatSpecialCard.getChildren().get(1)).setImage(specialFieldInCloseCombatUser1.getImageForPower());
            } else {
                ((ImageView) competitorCloseCombatSpecialCard.getChildren().getFirst()).setImage(null);
                ((ImageView) competitorCloseCombatSpecialCard.getChildren().get(1)).setImage(null);
            }
            if (specialFieldInSiegeUser1 != null) {
                ((ImageView) competitorSiegeSpecialCard.getChildren().getFirst()).setImage(specialFieldInSiegeUser1.getImageForGame());
                ((ImageView) competitorSiegeSpecialCard.getChildren().get(1)).setImage(specialFieldInSiegeUser1.getImageForPower());
            } else {
                ((ImageView) competitorSiegeSpecialCard.getChildren().getFirst()).setImage(null);
                ((ImageView) competitorSiegeSpecialCard.getChildren().get(1)).setImage(null);
            }
            if (specialFieldInRangedUser1 != null) {
                ((ImageView) competitorRangedSpecialCard.getChildren().getFirst()).setImage(specialFieldInRangedUser1.getImageForGame());
                ((ImageView) competitorRangedSpecialCard.getChildren().get(1)).setImage(specialFieldInRangedUser1.getImageForPower());
            } else {
                ((ImageView) competitorRangedSpecialCard.getChildren().getFirst()).setImage(null);
                ((ImageView) competitorRangedSpecialCard.getChildren().get(1)).setImage(null);
            }
        }
    }

    private void putCommonCardsInRows(ArrayList<CommonCard> closeCombatPlayedUser1, HBox myCloseCombatCardsPlayed, int row) {
        for (int i = 0; i < closeCombatPlayedUser1.size(); i++) {
            String playField = closeCombatPlayedUser1.get(i).getPlayField();
            StackPane stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(i);
            ((ImageView) stackPane.getChildren().getFirst()).setImage(closeCombatPlayedUser1.get(i).getImageForGame());
            if (playField != null && row == 1) {
                ((Label) stackPane.getChildren().get(2)).setText(setLabelScores(closeCombatPlayedUser1.get(i), closeCombatPlayedUser1, 1));
                stackPane.getChildren().get(2).setVisible(true);
            } else if (playField != null && row == 2) {
                ((Label) stackPane.getChildren().get(2)).setText(setLabelScores(closeCombatPlayedUser1.get(i), closeCombatPlayedUser1, 2));
                stackPane.getChildren().get(2).setVisible(true);
            } else if (playField != null && row == 3) {
                ((Label) stackPane.getChildren().get(2)).setText(setLabelScores(closeCombatPlayedUser1.get(i), closeCombatPlayedUser1, 3));
                stackPane.getChildren().get(2).setVisible(true);
            }
            if (closeCombatPlayedUser1.get(i).isHero()) {
                ((ImageView) stackPane.getChildren().get(1)).setImage(powerHeroImage);
                ((Label) stackPane.getChildren().get(2)).setTextFill(Color.WHITE);
            } else if (playField != null) {
                ((ImageView) stackPane.getChildren().get(1)).setImage(powerNormalImage);
                if (Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText()) > closeCombatPlayedUser1.get(i).getScore()) {
                    ((Label) stackPane.getChildren().get(2)).setTextFill(Color.GOLDENROD);
                } else if (Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText()) < closeCombatPlayedUser1.get(i).getScore()) {
                    ((Label) stackPane.getChildren().get(2)).setTextFill(Color.RED);
                } else {
                    ((Label) stackPane.getChildren().get(2)).setTextFill(Color.BLACK);
                }
            } else {
                ((ImageView) stackPane.getChildren().get(1)).setImage(decoyPower);
                ((Label) stackPane.getChildren().get(2)).setTextFill(Color.BLACK);
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
            if (ability.contains("Transform")) {
                ((ImageView) stackPane.getChildren().get(4)).setImage(cardAbilityAvenger);
            } else if (ability.contains("Muster"))
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

    private String setLabelScores(CommonCard commonCard, ArrayList<CommonCard> commonCards, int row) {
        int score = commonCard.getScore();
        if (commonCard.isHero()) return String.valueOf(score);
        if (row == 1 && gameBattleField.getWeatherCards().contains(SpecialCard.BitingFrost)) {
            if (!isResistantAgainstWeather) score = Math.min(1, commonCard.getScore());
            else {
                if (score % 2 == 0) score /= 2;
                else score = (score - 1) / 2;
            }
        } else if (row == 2 && (gameBattleField.getWeatherCards().contains(SpecialCard.ImpenetrableFog) || gameBattleField.getWeatherCards().contains(SpecialCard.SkelligeStorm))) {
            if (!isResistantAgainstWeather) score = Math.min(1, commonCard.getScore());
            else {
                if (score % 2 == 0) score /= 2;
                else score = (score - 1) / 2;
            }
        } else if (row == 3 && (gameBattleField.getWeatherCards().contains(SpecialCard.TorrentialRain) || gameBattleField.getWeatherCards().contains(SpecialCard.SkelligeStorm))) {
            if (!isResistantAgainstWeather) score = Math.min(1, commonCard.getScore());
            else {
                if (score % 2 == 0) score /= 2;
                else score = (score - 1) / 2;
            }
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
        if (!commonCard.getAbility().contains("Morale")) {
            for (CommonCard card : commonCards) {
                if (card.getAbility().contains("Morale")) score += 1;
            }
        }
        if (commonCards == closeCombatPlayedUser1 && ((specialFieldInCloseCombatUser1 != null && specialFieldInCloseCombatUser1.equals(SpecialCard.CommandersHorn)) || closeCombatPlayedUser1.contains(CommonCard.Dandelion))) {
            score *= 2;
        } else if (commonCards == rangedIsPlayedUser1 && specialFieldInRangedUser1 != null && specialFieldInRangedUser1.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        } else if (commonCards == siegeIsPlayedUser1 && ((specialFieldInSiegeUser1 != null && specialFieldInSiegeUser1.equals(SpecialCard.CommandersHorn)) || siegeIsPlayedUser1.contains(CommonCard.DraigBonDhu))) {
            score *= 2;
        }
        if (commonCards == closeCombatPlayedUser2 && ((specialFieldInCloseCombatUser2 != null && specialFieldInCloseCombatUser2.equals(SpecialCard.CommandersHorn)) || closeCombatPlayedUser2.contains(CommonCard.Dandelion))) {
            score *= 2;
        } else if (commonCards == rangedIsPlayedUser2 && specialFieldInRangedUser2 != null && specialFieldInRangedUser2.equals(SpecialCard.CommandersHorn)) {
            score *= 2;
        } else if (commonCards == siegeIsPlayedUser2 && ((specialFieldInSiegeUser2 != null && specialFieldInSiegeUser2.equals(SpecialCard.CommandersHorn)) || siegeIsPlayedUser2.contains(CommonCard.DraigBonDhu))) {
            score *= 2;
        }
        if (commonCard.getAbility().contains("Spy") && cross2Spy) score *= 2;
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
        if ((gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1()) && gameBattleField.isPassedUser2())
                || (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2()) && gameBattleField.isPassedUser1())) {
            return;
        }
        isTransitioning = true;
        gameBattleField.changeTurn();
        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/notif_me_turn.png"))));
        imageView.setFitHeight(180);
        imageView.setFitWidth(250);
        imageView.setX((pane.getWidth() - imageView.getFitWidth()) / 2 - 120);
        imageView.setY((pane.getHeight() - imageView.getFitHeight()) / 2 - 10);
        imageView.setOpacity(1.0);

        Label label = new Label(gameBattleField.getWhichUserTurn().getUsername() + " turn");
        label.setLayoutX((pane.getWidth() - label.getWidth()) / 2 - 10);
        label.setLayoutY((pane.getHeight() - label.getHeight()) / 2 - 20);
        label.setOpacity(1.0);
        label.setTextFill(Color.GOLD);
        label.setFont(Font.font("Broadway", 40));

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

    public void changeTurnAfterPass() {
        if (isTransitioning) {
            return;
        }
        isTransitioning = true;
        gameBattleField.changeTurn();
        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/notif_me_turn.png"))));
        imageView.setFitHeight(180);
        imageView.setFitWidth(250);
        imageView.setX((pane.getWidth() - imageView.getFitWidth()) / 2 - 120);
        imageView.setY((pane.getHeight() - imageView.getFitHeight()) / 2 - 10);
        imageView.setOpacity(1.0);

        Label label = new Label(gameBattleField.getWhichUserTurn().getUsername() + " turn");
        label.setLayoutX((pane.getWidth() - label.getWidth()) / 2 - 10);
        label.setLayoutY((pane.getHeight() - label.getHeight()) / 2 - 20);
        label.setOpacity(1.0);
        label.setTextFill(Color.GOLD);
        label.setFont(Font.font("Broadway", 40));

        imageView.setBlendMode(BlendMode.SRC_OVER);
        label.setBlendMode(BlendMode.SRC_OVER);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.8);

        Pane newPane = new Pane();

        PauseTransition pause = new PauseTransition(Duration.seconds(0));
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

    public void pass() {
        if (isTransitioning) {
            return;
        }
        isTransitioning = true;
        selectedSpecialCard = null;
        selectedCommonCard = null;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            gameBattleField.setPassedUser1(true);
        } else {
            gameBattleField.setPassedUser2(true);
        }
        updateBoard();
        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/notif_round_passed.png"))));
        imageView.setFitHeight(240);
        imageView.setFitWidth(320);
        imageView.setLayoutX((parentPane.getWidth() - imageView.getFitWidth()) / 2 - 200);
        imageView.setLayoutY((parentPane.getHeight() - imageView.getFitHeight()) / 2 - 50);

        Label passLabel = new Label();
        passLabel.setText("Round Passed");
        passLabel.setTextFill(Color.GOLD);
        Font font = Font.font("Broadway", 40);
        passLabel.setFont(font);
        passLabel.setLayoutX((parentPane.getWidth() - passLabel.getWidth()) / 2 - 20);
        passLabel.setLayoutY((parentPane.getHeight() - passLabel.getHeight()) / 2 - 30);

        Pane newPane = new Pane(imageView, passLabel);
        parentPane.getChildren().add(newPane);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.8);
        pane.setEffect(colorAdjust);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            isTransitioning = false;
            parentPane.getChildren().remove(newPane);
            pane.setEffect(null);
            if ((whichUserIsNotTurn().equals(gameBattleField.getUser1()) && !gameBattleField.isPassedUser1())
                    || (whichUserIsNotTurn().equals(gameBattleField.getUser2()) && !gameBattleField.isPassedUser2())) {
                changeTurnAfterPass();
            } else {
                endOfTheRound();
            }
        });

        pause.play();
    }

    private void endOfTheRound() {
        if (isTransitioning) {
            return;
        }
        isTransitioning = true;
        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/notif_draw_round.png"))));
        imageView.setFitHeight(240);
        imageView.setFitWidth(320);
        imageView.setLayoutX((parentPane.getWidth() - imageView.getFitWidth()) / 2 - 200);
        imageView.setLayoutY((parentPane.getHeight() - imageView.getFitHeight()) / 2 - 30);

        Label passLabel = new Label();
        passLabel.setText("Round Ended");
        passLabel.setTextFill(Color.GOLD);
        Font font = Font.font("Broadway", 40);
        passLabel.setFont(font);
        passLabel.setLayoutX((parentPane.getWidth() - passLabel.getWidth()) / 2 - 20);
        passLabel.setLayoutY((parentPane.getHeight() - passLabel.getHeight()) / 2 - 40);

        Pane newPane = new Pane();
        newPane.getChildren().addAll(imageView, passLabel);
        parentPane.getChildren().add(newPane);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.8);
        pane.setEffect(colorAdjust);

        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> {
            parentPane.getChildren().remove(newPane);
            startNewRound();
        });
        pause.play();
    }

    private void startNewRound() {
        int scoreFirstPlayer = Integer.parseInt(firstPlayerScore.getText());
        int scoreSecondPlayer = Integer.parseInt(secondPlayerScore.getText());
        String winner;

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (scoreFirstPlayer > scoreSecondPlayer && gameBattleField.getUser1().getFactionSelected().equals(Faction.NorthernRealms)) {
                gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser1());
                gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                winner = gameBattleField.getUser1().getUsername();
            } else if (scoreFirstPlayer < scoreSecondPlayer && gameBattleField.getUser2().getFactionSelected().equals(Faction.NorthernRealms)) {
                gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser2());
                gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                winner = gameBattleField.getUser2().getUsername();
            } else {
                Faction faction1 = gameBattleField.getUser1().getFactionSelected();
                Faction faction2 = gameBattleField.getUser2().getFactionSelected();
                if (faction1.equals(Faction.Nilfgaard) && faction2.equals(Faction.Nilfgaard)) {
                    winner = "draw";
                    gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                    gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                } else if (faction1.equals(Faction.Nilfgaard)) {
                    gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                    winner = gameBattleField.getUser1().getUsername();
                } else if (faction2.equals(Faction.Nilfgaard)) {
                    gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                    winner = gameBattleField.getUser2().getUsername();
                } else {
                    gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                    gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                    winner = "draw";
                }
            }
        } else {
            if (scoreFirstPlayer > scoreSecondPlayer && gameBattleField.getUser2().getFactionSelected().equals(Faction.NorthernRealms)) {
                gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser2());
                gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                winner = gameBattleField.getUser2().getUsername();
            } else if (scoreFirstPlayer < scoreSecondPlayer && gameBattleField.getUser1().getFactionSelected().equals(Faction.NorthernRealms)) {
                gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser1());
                gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                winner = gameBattleField.getUser1().getUsername();
            } else {
                Faction faction1 = gameBattleField.getUser1().getFactionSelected();
                Faction faction2 = gameBattleField.getUser2().getFactionSelected();
                if (faction1.equals(Faction.Nilfgaard) && faction2.equals(Faction.Nilfgaard)) {
                    gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                    gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                    winner = "draw";
                } else if (faction1.equals(Faction.Nilfgaard)) {
                    gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                    winner = gameBattleField.getUser1().getUsername();
                } else if (faction2.equals(Faction.Nilfgaard)) {
                    gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                    winner = gameBattleField.getUser2().getUsername();
                } else {
                    gameBattleField.setHealthUser2(gameBattleField.getHealthUser2() - 1);
                    gameBattleField.setHealthUser1(gameBattleField.getHealthUser1() - 1);
                    winner = "draw";
                }
            }
        }
        updateBoard();
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (gameBattleField.getUser1().getMaxScore() < Integer.parseInt(firstPlayerScore.getText())) {
                gameBattleField.getUser1().setMaxScore(Integer.parseInt(firstPlayerScore.getText()));
            }
            if (gameBattleField.getUser1().getMaxSiegeScore() < Integer.parseInt(mySiegeRowScore.getText())) {
                gameBattleField.getUser1().setMaxSiegeScore(Integer.parseInt(mySiegeRowScore.getText()));
            }
            if (gameBattleField.getUser1().getMaxCloseCombatScore() < Integer.parseInt(myCloseCombatRowScore.getText())) {
                gameBattleField.getUser1().setMaxCloseCombatScore(Integer.parseInt(myCloseCombatRowScore.getText()));
            }
            if (gameBattleField.getUser1().getMaxRangedScore() < Integer.parseInt(myRangedRowScore.getText())) {
                gameBattleField.getUser1().setMaxRangedScore(Integer.parseInt(myRangedRowScore.getText()));
            }

            if (gameBattleField.getUser2().getMaxScore() < Integer.parseInt(secondPlayerScore.getText())) {
                gameBattleField.getUser2().setMaxScore(Integer.parseInt(secondPlayerScore.getText()));
            }
            if (gameBattleField.getUser2().getMaxSiegeScore() < Integer.parseInt(competitorSiegeRowScore.getText())) {
                gameBattleField.getUser2().setMaxSiegeScore(Integer.parseInt(competitorSiegeRowScore.getText()));
            }
            if (gameBattleField.getUser2().getMaxCloseCombatScore() < Integer.parseInt(competitorCloseCombatRowScore.getText())) {
                gameBattleField.getUser2().setMaxCloseCombatScore(Integer.parseInt(competitorCloseCombatRowScore.getText()));
            }
            if (gameBattleField.getUser2().getMaxRangedScore() < Integer.parseInt(competitorRangedRowScore.getText())) {
                gameBattleField.getUser2().setMaxRangedScore(Integer.parseInt(competitorRangedRowScore.getText()));
            }
        }
        else {
            if (gameBattleField.getUser2().getMaxScore() < Integer.parseInt(firstPlayerScore.getText())) {
                gameBattleField.getUser2().setMaxScore(Integer.parseInt(firstPlayerScore.getText()));
            }
            if (gameBattleField.getUser2().getMaxSiegeScore() < Integer.parseInt(mySiegeRowScore.getText())) {
                gameBattleField.getUser2().setMaxSiegeScore(Integer.parseInt(mySiegeRowScore.getText()));
            }
            if (gameBattleField.getUser2().getMaxCloseCombatScore() < Integer.parseInt(myCloseCombatRowScore.getText())) {
                gameBattleField.getUser2().setMaxCloseCombatScore(Integer.parseInt(myCloseCombatRowScore.getText()));
            }
            if (gameBattleField.getUser2().getMaxRangedScore() < Integer.parseInt(myRangedRowScore.getText())) {
                gameBattleField.getUser2().setMaxRangedScore(Integer.parseInt(myRangedRowScore.getText()));
            }

            if (gameBattleField.getUser1().getMaxScore() < Integer.parseInt(secondPlayerScore.getText())) {
                gameBattleField.getUser1().setMaxScore(Integer.parseInt(secondPlayerScore.getText()));
            }
            if (gameBattleField.getUser1().getMaxSiegeScore() < Integer.parseInt(competitorSiegeRowScore.getText())) {
                gameBattleField.getUser1().setMaxSiegeScore(Integer.parseInt(competitorSiegeRowScore.getText()));
            }
            if (gameBattleField.getUser1().getMaxCloseCombatScore() < Integer.parseInt(competitorCloseCombatRowScore.getText())) {
                gameBattleField.getUser1().setMaxCloseCombatScore(Integer.parseInt(competitorCloseCombatRowScore.getText()));
            }
            if (gameBattleField.getUser1().getMaxRangedScore() < Integer.parseInt(competitorRangedRowScore.getText())) {
                gameBattleField.getUser1().setMaxRangedScore(Integer.parseInt(competitorRangedRowScore.getText()));
            }
        }
        ImageView imageView = new ImageView();
        imageView.setImage(profilePng);
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        imageView.setX((pane.getWidth() - imageView.getFitWidth()) / 2 - 135);
        imageView.setY((pane.getHeight() - imageView.getFitHeight()) / 2 - 10);
        imageView.setOpacity(1.0);
        Label label = new Label();
        if (winner.equals("draw")) {
            label.setText("Round tied");
        } else {
            label.setText(winner + " won the round");
        }
        label.setLayoutX((pane.getWidth() - label.getWidth()) / 2 - 70);
        label.setLayoutY((pane.getHeight() - label.getHeight()) / 2 - 40);
        label.setOpacity(1.0);
        label.setTextFill(Color.GOLD);
        label.setFont(Font.font("Broadway", 40));

        imageView.setBlendMode(BlendMode.SRC_OVER);
        label.setBlendMode(BlendMode.SRC_OVER);

        Pane newPane = new Pane(imageView, label);
        parentPane.getChildren().add(newPane);

        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> {
            parentPane.getChildren().remove(newPane);
            updateBoardAfterARound();
        });
        pause.play();
    }

    private void updateBoardAfterARound() {
        if (gameBattleField.getHealthUser1() == 0 || gameBattleField.getHealthUser2() == 0) {
            endOfTheGame();
        } else {
            cross2Spy = false;
            isResistantAgainstWeather = false;
            gameBattleField.setRound(gameBattleField.getRound() + 1);
            gameBattleField.setPassedUser1(false);
            gameBattleField.setPassedUser2(false);
            gameBattleField.changeFirstPlayerInRound();
            User user = gameBattleField.getUserFirstPlay();
            if (!gameBattleField.getWhichUserTurn().equals(user)) {
                gameBattleField.setWhichUserTurn(user);
            }
            addCardsToDiscard();
        }
    }

    private void addCardsToDiscard() {
        for (int i = 0; i < closeCombatPlayedUser1.size(); i++) {
            if (!closeCombatPlayedUser1.get(i).equals(CommonCard.Kambi)) {
                commonCardsInDiscardUser1.add(closeCombatPlayedUser1.get(i));
                closeCombatPlayedUser1.remove(i);
                i -= 1;
            }
        }
        if (gameBattleField.getRound() == 3) {
            for (int i = 0; i < closeCombatPlayedUser1.size(); i++) {
                if (closeCombatPlayedUser1.get(i).equals(CommonCard.Kambi)) {
                    closeCombatPlayedUser1.remove(i);
                    closeCombatPlayedUser1.add(CommonCard.Hemdall);
                    i -= 1;
                }
            }
        }
        if (gameBattleField.getSpecialFieldInCloseCombatUser1() != null) {
            specialCardsDiscardUser1.add(gameBattleField.getSpecialFieldInCloseCombatUser1());
            gameBattleField.setSpecialFieldInCloseCombatUser1(null);
        }
        commonCardsInDiscardUser1.addAll(rangedIsPlayedUser1);
        rangedIsPlayedUser1.clear();
        if (gameBattleField.getSpecialFieldInRangedUser1() != null) {
            specialCardsDiscardUser1.add(gameBattleField.getSpecialFieldInRangedUser1());
            gameBattleField.setSpecialFieldInRangedUser1(null);
        }
        commonCardsInDiscardUser1.addAll(siegeIsPlayedUser1);
        siegeIsPlayedUser1.clear();
        if (gameBattleField.getSpecialFieldInSiegeUser1() != null) {
            specialCardsDiscardUser1.add(gameBattleField.getSpecialFieldInSiegeUser1());
            gameBattleField.setSpecialFieldInSiegeUser1(null);
        }
        for (int i = 0; i < closeCombatPlayedUser2.size(); i++) {
            if (!closeCombatPlayedUser2.get(i).equals(CommonCard.Kambi)) {
                commonCardsInDiscardUser2.add(closeCombatPlayedUser2.get(i));
                closeCombatPlayedUser2.remove(i);
                i -= 1;
            }
        }
        if (gameBattleField.getSpecialFieldInCloseCombatUser2() != null) {
            specialCardsDiscardUser2.add(gameBattleField.getSpecialFieldInCloseCombatUser2());
            gameBattleField.setSpecialFieldInCloseCombatUser2(null);
        }
        if (gameBattleField.getRound() == 3) {
            for (int i = 0; i < closeCombatPlayedUser2.size(); i++) {
                if (closeCombatPlayedUser2.get(i).equals(CommonCard.Kambi)) {
                    closeCombatPlayedUser2.remove(i);
                    closeCombatPlayedUser2.add(CommonCard.Hemdall);
                    i -= 1;
                }
            }
        }
        commonCardsInDiscardUser2.addAll(rangedIsPlayedUser2);
        rangedIsPlayedUser2.clear();
        if (gameBattleField.getSpecialFieldInRangedUser2() != null) {
            specialCardsDiscardUser2.add(gameBattleField.getSpecialFieldInRangedUser2());
            gameBattleField.setSpecialFieldInRangedUser2(null);
        }
        commonCardsInDiscardUser2.addAll(siegeIsPlayedUser2);
        siegeIsPlayedUser2.clear();
        if (gameBattleField.getSpecialFieldInSiegeUser2() != null) {
            specialCardsDiscardUser2.add(gameBattleField.getSpecialFieldInSiegeUser2());
            gameBattleField.setSpecialFieldInSiegeUser2(null);
        }
        Random random = new Random();
        int index;
        if (gameBattleField.getRound() == 3) {
            if (gameBattleField.getUser1().getFactionSelected().equals(Faction.Skellige)) {
                for (int i = 0; i < 2; i++) {
                    index = random.nextInt(gameBattleField.getCommonCardsInDiscardUser1().size());
                    CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser1().get(index);
                    switch (commonCard.getPlayField()) {
                        case "Close Combat" -> closeCombatPlayedUser1.add(commonCard);
                        case "Ranged" -> rangedIsPlayedUser1.add(commonCard);
                        case "Siege" -> siegeIsPlayedUser1.add(commonCard);
                        default -> i -= 1;
                    }
                    gameBattleField.getCommonCardsInDiscardUser1().remove(commonCard);
                }
            }
            if (gameBattleField.getUser2().getFactionSelected().equals(Faction.Skellige)) {
                for (int i = 0; i < 2; i++) {
                    index = random.nextInt(gameBattleField.getCommonCardsInDiscardUser2().size());
                    CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser2().get(index);
                    switch (commonCard.getPlayField()) {
                        case "Close Combat" -> closeCombatPlayedUser2.add(commonCard);
                        case "Ranged" -> rangedIsPlayedUser2.add(commonCard);
                        case "Siege" -> siegeIsPlayedUser2.add(commonCard);
                        default -> i -= 1;
                    }
                    gameBattleField.getCommonCardsInDiscardUser2().remove(commonCard);
                }
            }
        }
        if (gameBattleField.getUser1().getFactionSelected().equals(Faction.Monsters)) {
            for (int i = 0; i < 1; i++) {
                index = random.nextInt(gameBattleField.getCommonCardsInDiscardUser1().size());
                CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser1().get(index);
                switch (commonCard.getPlayField()) {
                    case "Close Combat" -> closeCombatPlayedUser1.add(commonCard);
                    case "Ranged" -> rangedIsPlayedUser1.add(commonCard);
                    case "Siege" -> siegeIsPlayedUser1.add(commonCard);
                    default -> i -= 1;
                }
                gameBattleField.getCommonCardsInDiscardUser1().remove(commonCard);
            }
        }
        if (gameBattleField.getUser2().getFactionSelected().equals(Faction.Monsters)) {
            for (int i = 0; i < 1; i++) {
                index = random.nextInt(gameBattleField.getCommonCardsInDiscardUser2().size());
                CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser2().get(index);
                switch (commonCard.getPlayField()) {
                    case "Close Combat" -> closeCombatPlayedUser2.add(commonCard);
                    case "Ranged" -> rangedIsPlayedUser2.add(commonCard);
                    case "Siege" -> siegeIsPlayedUser2.add(commonCard);
                    default -> i -= 1;
                }
                gameBattleField.getCommonCardsInDiscardUser2().remove(commonCard);
            }
        }
        addWeatherCardsToDiscard();
        updateBoard();

        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/notif_round_start.png"))));
        imageView.setFitHeight(180);
        imageView.setFitWidth(250);
        imageView.setX((pane.getWidth() - imageView.getFitWidth()) / 2 - 120);
        imageView.setY((pane.getHeight() - imageView.getFitHeight()) / 2 - 25);
        imageView.setOpacity(1.0);
        Label label = new Label();
        label.setText("Round start");
        label.setLayoutX((pane.getWidth() - label.getWidth()) / 2 - 40);
        label.setLayoutY((pane.getHeight() - label.getHeight()) / 2 - 40);
        label.setOpacity(1.0);
        label.setTextFill(Color.GOLD);
        label.setFont(Font.font("Broadway", 40));

        imageView.setBlendMode(BlendMode.SRC_OVER);
        label.setBlendMode(BlendMode.SRC_OVER);

        Pane newPane = new Pane(imageView, label);
        parentPane.getChildren().add(newPane);

        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> {
            isTransitioning = false;
            pane.setEffect(null);
            parentPane.getChildren().remove(newPane);
        });
        pause.play();
    }

    private void endOfTheGame() {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(240);
        imageView.setFitWidth(360);
        imageView.setLayoutX((parentPane.getWidth() - imageView.getFitWidth()) / 2);
        imageView.setLayoutY((parentPane.getHeight() - imageView.getFitHeight()) / 2 - 100);

        Label endLabel = new Label();
        endLabel.setTextFill(Color.GOLD);
        Font font = Font.font("Broadway", 40);
        endLabel.setFont(font);
        endLabel.setLayoutX((parentPane.getWidth() - endLabel.getWidth()) / 2 - 200);
        endLabel.setLayoutY((parentPane.getHeight() - endLabel.getHeight()) / 2 + 50);

        Pane newPane = new Pane();
        newPane.getChildren().addAll(imageView, endLabel);
        parentPane.getChildren().add(newPane);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.8);
        pane.setEffect(colorAdjust);

        if (gameBattleField.getHealthUser1() == 0 && gameBattleField.getHealthUser2() == 0) {
            imageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/end_draw.png"))));
            endLabel.setText("The game equalised");
        } else if (gameBattleField.getHealthUser1() > gameBattleField.getHealthUser2()) {
            imageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/end_win.png"))));
            endLabel.setText(gameBattleField.getUser1().getUsername() + " won the game");
        } else {
            imageView.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/end_win.png"))));
            endLabel.setText(gameBattleField.getUser2().getUsername() + " won the game");
        }

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            isTransitioning = false;
            pane.setEffect(null);
            parentPane.getChildren().remove(newPane);
            MainMenu mainMenu = new MainMenu();
            try {
                mainMenu.start(ApplicationController.getStage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        pause.play();
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
                    if (((ImageView) ((StackPane) myCloseCombatCardsPlayed.getChildren().getFirst()).getChildren().getFirst()).getImage() != null) {
                        myCloseCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                    }
                    if (((ImageView) ((StackPane) myRangedCombatCardsPlayed.getChildren().getFirst()).getChildren().getFirst()).getImage() != null) {
                        myRangedCombatCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                    }
                    if (((ImageView) ((StackPane) mySiegeCardsPlayed.getChildren().getFirst()).getChildren().getFirst()).getImage() != null) {
                        mySiegeCardsPlayed.setStyle("-fx-background-color: rgba(255, 255, 0, 0.3);");
                    }
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

    //    @Override
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
            return;
        }
        if (selectedCommonCard != null && selectedCommonCard.equals(CommonCard.Decoy)) {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                if (gameBattleField.getCloseCombatIsPlayedUser1().isEmpty()) return;
                boolean existNonHero = false;
                for (CommonCard commonCard : gameBattleField.getCloseCombatIsPlayedUser1()) {
                    if (!commonCard.isHero()) {
                        existNonHero = true;
                        break;
                    }
                }
                if (!existNonHero) return;
                CommonCard commonCardShouldReplaceWithDecoy = null;
                for (int i = gameBattleField.getCloseCombatIsPlayedUser1().size() - 1; i >= 0; i--) {
                    if (!gameBattleField.getCloseCombatIsPlayedUser1().get(i).isHero()) {
                        commonCardShouldReplaceWithDecoy = gameBattleField.getCloseCombatIsPlayedUser1().get(i);
                        break;
                    }
                }
                if (commonCardShouldReplaceWithDecoy != null) {
                    gameBattleField.getCommonCardInBattleFieldUser1().add(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getCloseCombatIsPlayedUser1().remove(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getCloseCombatIsPlayedUser1().add(CommonCard.Decoy);
                }
            }
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2())) {
                if (gameBattleField.getCloseCombatIsPlayedUser2().isEmpty()) return;
                boolean existNonHero = false;
                for (CommonCard commonCard : gameBattleField.getCloseCombatIsPlayedUser2()) {
                    if (!commonCard.isHero()) {
                        existNonHero = true;
                        break;
                    }
                }
                if (!existNonHero) return;
                CommonCard commonCardShouldReplaceWithDecoy = null;
                for (int i = gameBattleField.getCloseCombatIsPlayedUser2().size() - 1; i >= 0; i--) {
                    if (!gameBattleField.getCloseCombatIsPlayedUser2().get(i).isHero()) {
                        commonCardShouldReplaceWithDecoy = gameBattleField.getCloseCombatIsPlayedUser2().get(i);
                        break;
                    }
                }
                if (commonCardShouldReplaceWithDecoy != null) {
                    gameBattleField.getCommonCardInBattleFieldUser2().add(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getCloseCombatIsPlayedUser2().remove(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getCloseCombatIsPlayedUser2().add(CommonCard.Decoy);
                }
            }
            unSelectCard();
            updateBoard();
            changeTurn();
            return;
        }
        if (selectedCommonCard == null
                || (!selectedCommonCard.getPlayField().equals("Close Combat") && !selectedCommonCard.getPlayField().equals("Agile")) || selectedCommonCard.getAbility().contains("Spy")) {
            return;
        }
        gameBattleFieldController.putCommonCardCloseCombat(selectedCommonCard, false);
        updateBoard();
        if (selectedCommonCard.getAbility().contains("Medic")) {
            gameBattleFieldController.medicAbility();
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
        } else if (selectedCommonCard.getAbility().equals("Scorch Close Combat")) {
            scorchCloseCombatAbility();
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
        }
        if (selectedCommonCard != null && selectedCommonCard.equals(CommonCard.Decoy)) {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                if (gameBattleField.getRangedIsPlayedUser1().isEmpty()) return;
                boolean existNonHero = false;
                for (CommonCard commonCard : gameBattleField.getRangedIsPlayedUser1()) {
                    if (!commonCard.isHero()) {
                        existNonHero = true;
                        break;
                    }
                }
                if (!existNonHero) return;
                CommonCard commonCardShouldReplaceWithDecoy = null;
                for (int i = gameBattleField.getRangedIsPlayedUser1().size() - 1; i >= 0; i--) {
                    if (!gameBattleField.getRangedIsPlayedUser1().get(i).isHero()) {
                        commonCardShouldReplaceWithDecoy = gameBattleField.getRangedIsPlayedUser1().get(i);
                        break;
                    }
                }
                if (commonCardShouldReplaceWithDecoy != null) {
                    gameBattleField.getCommonCardInBattleFieldUser1().add(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getRangedIsPlayedUser1().remove(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getRangedIsPlayedUser1().add(CommonCard.Decoy);
                }
            }
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2())) {
                if (gameBattleField.getRangedIsPlayedUser2().isEmpty()) return;
                boolean existNonHero = false;
                for (CommonCard commonCard : gameBattleField.getRangedIsPlayedUser2()) {
                    if (!commonCard.isHero()) {
                        existNonHero = true;
                        break;
                    }
                }
                if (!existNonHero) return;
                CommonCard commonCardShouldReplaceWithDecoy = null;
                for (int i = gameBattleField.getRangedIsPlayedUser2().size() - 1; i >= 0; i--) {
                    if (!gameBattleField.getRangedIsPlayedUser2().get(i).isHero()) {
                        commonCardShouldReplaceWithDecoy = gameBattleField.getRangedIsPlayedUser2().get(i);
                        break;
                    }
                }
                if (commonCardShouldReplaceWithDecoy != null) {
                    gameBattleField.getCommonCardInBattleFieldUser2().add(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getRangedIsPlayedUser2().remove(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getRangedIsPlayedUser2().add(CommonCard.Decoy);
                }
            }
            unSelectCard();
            updateBoard();
            changeTurn();
            return;
        }
        if (selectedCommonCard == null
                || (!selectedCommonCard.getPlayField().equals("Ranged") && !selectedCommonCard.getPlayField().equals("Agile")) || selectedCommonCard.getAbility().contains("Spy"))
            return;
        gameBattleFieldController.putCommonCardRanged(selectedCommonCard, false);
        updateBoard();
        if (selectedCommonCard.getAbility().contains("Medic")) {
            gameBattleFieldController.medicAbility();
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
        } else if (selectedCommonCard.getAbility().equals("Scorch Ranged")) {
            scorchRangedAbility();
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
        }
        if (selectedCommonCard != null && selectedCommonCard.equals(CommonCard.Decoy)) {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                if (gameBattleField.getSiegeIsPlayedUser1().isEmpty()) return;
                boolean existNonHero = false;
                for (CommonCard commonCard : gameBattleField.getSiegeIsPlayedUser1()) {
                    if (!commonCard.isHero()) {
                        existNonHero = true;
                        break;
                    }
                }
                if (!existNonHero) return;
                CommonCard commonCardShouldReplaceWithDecoy = null;
                for (int i = gameBattleField.getSiegeIsPlayedUser1().size() - 1; i >= 0; i--) {
                    if (!gameBattleField.getSiegeIsPlayedUser1().get(i).isHero()) {
                        commonCardShouldReplaceWithDecoy = gameBattleField.getSiegeIsPlayedUser1().get(i);
                        break;
                    }
                }
                if (commonCardShouldReplaceWithDecoy != null) {
                    gameBattleField.getCommonCardInBattleFieldUser1().add(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getSiegeIsPlayedUser1().remove(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getSiegeIsPlayedUser1().add(CommonCard.Decoy);
                }
            }
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2())) {
                if (gameBattleField.getSiegeIsPlayedUser2().isEmpty()) return;
                boolean existNonHero = false;
                for (CommonCard commonCard : gameBattleField.getSiegeIsPlayedUser2()) {
                    if (!commonCard.isHero()) {
                        existNonHero = true;
                        break;
                    }
                }
                if (!existNonHero) return;
                CommonCard commonCardShouldReplaceWithDecoy = null;
                for (int i = gameBattleField.getSiegeIsPlayedUser2().size() - 1; i >= 0; i--) {
                    if (!gameBattleField.getSiegeIsPlayedUser2().get(i).isHero()) {
                        commonCardShouldReplaceWithDecoy = gameBattleField.getSiegeIsPlayedUser2().get(i);
                        break;
                    }
                }
                if (commonCardShouldReplaceWithDecoy != null) {
                    gameBattleField.getCommonCardInBattleFieldUser2().add(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getSiegeIsPlayedUser2().remove(commonCardShouldReplaceWithDecoy);
                    gameBattleField.getSiegeIsPlayedUser2().add(CommonCard.Decoy);
                }
            }
            unSelectCard();
            updateBoard();
            changeTurn();
            return;
        }
        if (selectedCommonCard == null
                || !selectedCommonCard.getPlayField().equals("Siege") || selectedCommonCard.getAbility().contains("Spy"))
            return;
        gameBattleFieldController.putCommonCardSiege(selectedCommonCard, false);
        updateBoard();
        if (selectedCommonCard.getAbility().contains("Medic")) {
            gameBattleFieldController.medicAbility();
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
        } else if (selectedCommonCard.getAbility().equals("Scorch Siege")) {
            scorchSiegeAbility();
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
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
        if (selectedSpecialCard != null && selectedSpecialCard.equals(SpecialCard.Scorch)) {
            isTransitioning = true;
            scorchAbility();
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

    public void addWeatherCardsToDiscard() {
        for (int i = pane.getChildren().size() - 12; i < pane.getChildren().size(); i++) {
            Node node = pane.getChildren().get(i);
            if (node instanceof ImageView && node.getId() == null) {
                pane.getChildren().remove(node);
                i -= 1;
            }
        }

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

    public void focusOnTheLeaderCard() {
        if (isTransitioning) {
            return;
        }
        focusOnLeadersImages(gameBattleField.getWhichUserTurn(), true, gameBattleField.getWhichUserTurn());
    }

    public void focusOnTheLeaderCardCompetitor() {
        if (isTransitioning) {
            return;
        }
        focusOnLeadersImages(whichUserIsNotTurn(), false, whichUserIsNotTurn());
    }

    private void focusOnLeadersImages(User whichUserIsNotTurn, boolean isMyLeader, User whichUserIsNotTurn1) {
        Pane paneClick = new Pane();
        paneClick.setPrefWidth(1280);
        paneClick.setPrefHeight(720);

        ImageView imageView = new ImageView(whichUserIsNotTurn.getFactionLeader().getImage());
        imageView.setFitWidth(200);
        imageView.setFitHeight(380);
        imageView.setX((pane.getWidth() - imageView.getFitWidth()) / 2);
        imageView.setY((pane.getHeight() - imageView.getFitHeight()) / 2 - 50);
        imageView.setOnMouseClicked(e -> performAbility(isMyLeader));

        Rectangle rectangle = new Rectangle(400, 100, Color.BLACK);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        rectangle.setX((pane.getWidth() - rectangle.getWidth()) / 2);
        rectangle.setY((pane.getHeight() - rectangle.getHeight()) / 2 + 200);
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(1);

        Label label = new Label(whichUserIsNotTurn1.getFactionLeader().getAbility());
        label.setWrapText(true);
        label.setTextFill(Color.BEIGE);
        label.setFont(new Font("Arial", 14));
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(CENTER);
        label.setPadding(new Insets(0, 20, 0, 20));

        StackPane stackPane = new StackPane(rectangle, label);
        stackPane.setMaxWidth(rectangle.getWidth());
        stackPane.setMaxHeight(rectangle.getHeight());
        stackPane.setLayoutX((pane.getWidth() - rectangle.getWidth()) / 2);
        stackPane.setLayoutY((pane.getHeight() - rectangle.getHeight()) / 2 + 200);

        paneClick.getChildren().addAll(imageView, stackPane);
        parentPane.getChildren().add(paneClick);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.8);
        pane.setEffect(colorAdjust);

        paneClick.setOnMouseClicked(e -> {
            pane.setEffect(null);
            parentPane.getChildren().remove(paneClick);
        });
    }

    private void performAbility(boolean isMyLeader) {
        if (isTransitioning) {
            return;
        }
        if (!isMyLeader) return;
        if ((gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1()) && !gameBattleField.isExistAbilityUser1())
                || (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser2()) && !gameBattleField.isExistAbilityUser2())) {
            return;
        }
        Leader leader;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            gameBattleField.setExistAbilityUser1(false);
            leader = gameBattleField.getUser1().getFactionLeader();
        } else {
            gameBattleField.setExistAbilityUser2(false);
            leader = gameBattleField.getUser2().getFactionLeader();
        }
        switch (leader) {
            case Leader.SiegeMaster -> putWeatherCardAbility(SpecialCard.ImpenetrableFog);
            case Leader.SteelForged -> {
                addWeatherCardsToDiscard();
                updateBoard();
                changeTurn();
            }
            case Leader.WhiteFlame -> putWeatherCardAbility(SpecialCard.TorrentialRain);
            case Leader.PurebloodElf, Leader.HopeOfTheAenSeidhe -> putWeatherCardAbility(SpecialCard.BitingFrost);
            case Leader.KingOfTemeria -> kingOfTemeriaAbility();
            case Leader.BringerOfDeath -> BringerOfDeathAbility();
            case Leader.TheBeautiful -> TheBeautifulAbility();
            case Leader.LordCommanderOfTheNorth -> scorchSiegeAbility();
            case Leader.SonOfMedell -> scorchRangedAbility();
            case Leader.QueenOfDolBlathanna -> scorchCloseCombatAbility();
            case Leader.HisImperialMajesty -> seeCompetitorCardsAbility();
            case Leader.TheTreacherous -> {
                cross2Spy = true;
                updateBoard();
                changeTurn();
            }
            case Leader.CrachAnCraite -> {
                gameBattleField.getCommonCardInDeckUser1().addAll(gameBattleField.getCommonCardsInDiscardUser1());
                gameBattleField.getSpecialCardsDeckUser1().addAll(gameBattleField.getSpecialCardsDiscardUser1());
                gameBattleField.getCommonCardsInDiscardUser1().clear();
                gameBattleField.getSpecialCardsDiscardUser1().clear();
                gameBattleField.getCommonCardInDeckUser2().addAll(gameBattleField.getCommonCardsInDiscardUser2());
                gameBattleField.getSpecialCardsDeckUser2().addAll(gameBattleField.getSpecialCardsDiscardUser2());
                gameBattleField.getCommonCardsInDiscardUser2().clear();
                gameBattleField.getSpecialCardsDiscardUser2().clear();
                updateBoard();
                changeTurn();
            }
            case Leader.KingBran -> {
                isResistantAgainstWeather = true;
                updateBoard();
                changeTurn();
            }
            case Leader.InvaderOfTheNorth -> invaderOfTheNorthAbility();
            case Leader.TheRelentless -> theRelentlessAbility();
            case Leader.KingOfTheWildHunt -> theKingOfTheWildHuntAbility();
            case Leader.DestroyerOfWorlds -> deleteTwoBattleFieldCards();
            case Leader.CommanderOfTheRedRiders -> putARandomWeatherCard();
        }
    }

    private void putARandomWeatherCard() {
        Random random = new Random();
        int weatherNumber = random.nextInt(1, 6);
        if (weatherNumber == 1) {
            selectedSpecialCard = SpecialCard.BitingFrost;
        } else if (weatherNumber == 2) {
            selectedSpecialCard = SpecialCard.ImpenetrableFog;
        } else if (weatherNumber == 3) {
            selectedSpecialCard = SpecialCard.TorrentialRain;
        } else if (weatherNumber == 4) {
            selectedSpecialCard = SpecialCard.SkelligeStorm;
        } else if (weatherNumber == 5) {
            selectedSpecialCard = SpecialCard.ClearWeather;
        }
        putWeatherCard();
    }

    private void deleteTwoBattleFieldCards() {
        Random random = new Random();
        boolean isSpecial;
        int index;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (gameBattleField.getCommonCardInBattleFieldUser1().size() + gameBattleField.getSpecialCardsBattleFieldUser1().size() < 2) {
                return;
            }
            for (int i = 0; i < 2; i++) {
                isSpecial = random.nextBoolean();
                if (isSpecial) {
                    if (!gameBattleField.getSpecialCardsBattleFieldUser1().isEmpty()) {
                        index = random.nextInt(gameBattleField.getSpecialCardsBattleFieldUser1().size());
                        gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getSpecialCardsBattleFieldUser1().get(index));
                        gameBattleField.getSpecialCardsBattleFieldUser1().remove(index);
                    } else {
                        index = random.nextInt(gameBattleField.getCommonCardInBattleFieldUser1().size());
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getCommonCardInBattleFieldUser1().get(index));
                        gameBattleField.getCommonCardInBattleFieldUser1().remove(index);
                    }
                } else {
                    if (!gameBattleField.getCommonCardInBattleFieldUser1().isEmpty()) {
                        index = random.nextInt(gameBattleField.getCommonCardInBattleFieldUser1().size());
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getCommonCardInBattleFieldUser1().get(index));
                        gameBattleField.getCommonCardInBattleFieldUser1().remove(index);
                    } else {
                        index = random.nextInt(gameBattleField.getSpecialCardsBattleFieldUser1().size());
                        gameBattleField.getSpecialCardsDiscardUser1().add(gameBattleField.getSpecialCardsBattleFieldUser1().get(index));
                        gameBattleField.getSpecialCardsBattleFieldUser1().remove(index);
                    }
                }
            }
            index = random.nextInt(gameBattleField.getCommonCardInDeckUser1().size());
            gameBattleField.getCommonCardInBattleFieldUser1().add(gameBattleField.getCommonCardInDeckUser1().get(index));
            gameBattleField.getCommonCardInDeckUser1().remove(index);
        } else {
            if (gameBattleField.getCommonCardInBattleFieldUser2().size() + gameBattleField.getSpecialCardsBattleFieldUser2().size() < 2) {
                return;
            }
            for (int i = 0; i < 2; i++) {
                isSpecial = random.nextBoolean();
                if (isSpecial) {
                    if (!gameBattleField.getSpecialCardsBattleFieldUser2().isEmpty()) {
                        index = random.nextInt(gameBattleField.getSpecialCardsBattleFieldUser2().size());
                        gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getSpecialCardsBattleFieldUser2().get(index));
                        gameBattleField.getSpecialCardsBattleFieldUser2().remove(index);
                    } else {
                        index = random.nextInt(gameBattleField.getCommonCardInBattleFieldUser2().size());
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getCommonCardInBattleFieldUser2().get(index));
                        gameBattleField.getCommonCardInBattleFieldUser2().remove(index);
                    }
                } else {
                    if (!gameBattleField.getCommonCardInBattleFieldUser2().isEmpty()) {
                        index = random.nextInt(gameBattleField.getCommonCardInBattleFieldUser2().size());
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getCommonCardInBattleFieldUser2().get(index));
                        gameBattleField.getCommonCardInBattleFieldUser2().remove(index);
                    } else {
                        index = random.nextInt(gameBattleField.getSpecialCardsBattleFieldUser2().size());
                        gameBattleField.getSpecialCardsDiscardUser2().add(gameBattleField.getSpecialCardsBattleFieldUser2().get(index));
                        gameBattleField.getSpecialCardsBattleFieldUser2().remove(index);
                    }
                }
            }
            index = random.nextInt(gameBattleField.getCommonCardInDeckUser2().size());
            gameBattleField.getCommonCardInBattleFieldUser2().add(gameBattleField.getCommonCardInDeckUser2().get(index));
            gameBattleField.getCommonCardInDeckUser2().remove(index);
        }
        updateBoard();
        changeTurn();
    }

    private void theKingOfTheWildHuntAbility() {
        GaussianBlur gaussianBlur = new GaussianBlur(20);
        Platform.runLater(() -> pane.setEffect(gaussianBlur));

        allCards = new HBox(1050);
        allCards.setLayoutX(90);
        allCards.setLayoutY(200);
        allCards.setSpacing(10);
        allCards.setAlignment(Pos.CENTER);
        allCards.setEffect(new GaussianBlur(0));

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser1().size() + gameBattleField.getCommonCardsInDiscardUser1().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                updateBoard();
                changeTurn();
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser1().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromKingOfTheWildHuntAbility(imageView));
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser1().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser1().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromKingOfTheWildHuntAbility(imageView));
                allCards.getChildren().add(imageView);
            }
        } else {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser2().size() + gameBattleField.getCommonCardsInDiscardUser2().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                updateBoard();
                changeTurn();
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser2().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromKingOfTheWildHuntAbility(imageView));
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser2().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser2().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromKingOfTheWildHuntAbility(imageView));
                allCards.getChildren().add(imageView);
            }
        }

        Pane overlayPane = new Pane();
        overlayPane.getChildren().addAll(allCards);

        parentPane.getChildren().add(overlayPane);
    }

    private void changeCardFromKingOfTheWildHuntAbility(ImageView imageView) {
        gameBattleFieldController.sort();
        int number = Integer.parseInt(imageView.getId());
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (number < gameBattleField.getSpecialCardsDiscardUser1().size()) {
                SpecialCard specialCard = gameBattleField.getSpecialCardsDiscardUser1().get(number);
                gameBattleField.getSpecialCardsBattleFieldUser1().add(specialCard);
                gameBattleField.getSpecialCardsDiscardUser1().remove(specialCard);
            } else {
                CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser1().get(number - gameBattleField.getSpecialCardsDiscardUser1().size());
                if (commonCard.isHero()) return;
                gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
                gameBattleField.getCommonCardsInDiscardUser1().remove(commonCard);
            }
        } else {
            if (number < gameBattleField.getSpecialCardsDiscardUser2().size()) {
                SpecialCard specialCard = gameBattleField.getSpecialCardsDiscardUser2().get(number);
                gameBattleField.getSpecialCardsBattleFieldUser2().add(specialCard);
                gameBattleField.getSpecialCardsDiscardUser2().remove(specialCard);
            } else {
                CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser2().get(number - gameBattleField.getSpecialCardsDiscardUser2().size());
                if (commonCard.isHero()) return;
                gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
                gameBattleField.getCommonCardsInDiscardUser2().remove(commonCard);
            }
        }
        Platform.runLater(() -> pane.setEffect(null));
        updateBoard();
        allCards.getChildren().clear();
        parentPane.getChildren().removeLast();
        pane.setEffect(null);
        changeTurn();
    }

    private void theRelentlessAbility() {
        GaussianBlur gaussianBlur = new GaussianBlur(20);
        Platform.runLater(() -> pane.setEffect(gaussianBlur));

        allCards = new HBox(1050);
        allCards.setLayoutX(90);
        allCards.setLayoutY(200);
        allCards.setSpacing(10);
        allCards.setAlignment(Pos.CENTER);
        allCards.setEffect(new GaussianBlur(0));

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser2().size() + gameBattleField.getCommonCardsInDiscardUser2().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                updateBoard();
                changeTurn();
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser2().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromTheRelentlessAbility(imageView));
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser2().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser2().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromTheRelentlessAbility(imageView));
                allCards.getChildren().add(imageView);
            }
        } else {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser1().size() + gameBattleField.getCommonCardsInDiscardUser1().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                updateBoard();
                changeTurn();
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser1().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromTheRelentlessAbility(imageView));
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser1().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser1().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(e -> changeCardFromTheRelentlessAbility(imageView));
                allCards.getChildren().add(imageView);
            }
        }

        Pane overlayPane = new Pane();
        overlayPane.getChildren().addAll(allCards);

        parentPane.getChildren().add(overlayPane);
    }

    private void changeCardFromTheRelentlessAbility(ImageView imageView) {
        gameBattleFieldController.sort();
        int number = Integer.parseInt(imageView.getId());
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (number < gameBattleField.getSpecialCardsDiscardUser2().size()) {
                SpecialCard specialCard = gameBattleField.getSpecialCardsDiscardUser2().get(number);
                gameBattleField.getSpecialCardsBattleFieldUser1().add(specialCard);
                gameBattleField.getSpecialCardsDiscardUser2().remove(specialCard);
            } else {
                CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser2().get(number - gameBattleField.getSpecialCardsDiscardUser2().size());
                if (commonCard.isHero()) return;
                gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
                gameBattleField.getCommonCardsInDiscardUser2().remove(commonCard);
            }
        } else {
            if (number < gameBattleField.getSpecialCardsDiscardUser1().size()) {
                SpecialCard specialCard = gameBattleField.getSpecialCardsDiscardUser1().get(number);
                gameBattleField.getSpecialCardsBattleFieldUser2().add(specialCard);
                gameBattleField.getSpecialCardsDiscardUser1().remove(specialCard);
            } else {
                CommonCard commonCard = gameBattleField.getCommonCardsInDiscardUser1().get(number - gameBattleField.getSpecialCardsDiscardUser1().size());
                if (commonCard.isHero()) return;
                gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
                gameBattleField.getCommonCardsInDiscardUser1().remove(commonCard);
            }
        }
        Platform.runLater(() -> pane.setEffect(null));
        updateBoard();
        allCards.getChildren().clear();
        parentPane.getChildren().removeLast();
        pane.setEffect(null);
        changeTurn();
    }

    private void invaderOfTheNorthAbility() {
        Random random = new Random();
        int index;
        if (!gameBattleField.getCommonCardsInDiscardUser1().isEmpty()) {
            index = random.nextInt(gameBattleField.getCommonCardsInDiscardUser1().size());
            if (gameBattleField.getCommonCardsInDiscardUser1().get(index).isHero()) {
                invaderOfTheNorthAbility();
                return;
            }
            gameBattleField.getCommonCardInBattleFieldUser1().add(gameBattleField.getCommonCardsInDiscardUser1().get(index));
            gameBattleField.getCommonCardsInDiscardUser1().remove(index);
        } else if (!gameBattleField.getSpecialCardsDiscardUser1().isEmpty()) {
            index = random.nextInt(gameBattleField.getSpecialCardsDiscardUser1().size());
            gameBattleField.getSpecialCardsBattleFieldUser1().add(gameBattleField.getSpecialCardsDiscardUser1().get(index));
            gameBattleField.getSpecialCardsDiscardUser1().remove(index);
        }
        if (!gameBattleField.getCommonCardsInDiscardUser2().isEmpty()) {
            index = random.nextInt(gameBattleField.getCommonCardsInDiscardUser2().size());
            if (gameBattleField.getCommonCardsInDiscardUser2().get(index).isHero()) {
                invaderOfTheNorthAbility();
                return;
            }
            gameBattleField.getCommonCardInBattleFieldUser2().add(gameBattleField.getCommonCardsInDiscardUser2().get(index));
            gameBattleField.getCommonCardsInDiscardUser2().remove(index);
        } else if (!gameBattleField.getSpecialCardsDiscardUser2().isEmpty()) {
            index = random.nextInt(gameBattleField.getSpecialCardsDiscardUser2().size());
            gameBattleField.getSpecialCardsBattleFieldUser2().add(gameBattleField.getSpecialCardsDiscardUser2().get(index));
            gameBattleField.getSpecialCardsDiscardUser2().remove(index);
        }
        updateBoard();
        changeTurn();
    }

    private void seeCompetitorCardsAbility() {
        int number;
        Random random = new Random();
        int specialNumber;
        int index;
        ArrayList<Integer> indexes = new ArrayList<>();

        GaussianBlur gaussianBlur = new GaussianBlur(20);
        Platform.runLater(() -> pane.setEffect(gaussianBlur));

        allCards = new HBox(340);
        allCards.setLayoutX(430);
        allCards.setLayoutY(200);
        allCards.setSpacing(50);
        allCards.setAlignment(Pos.CENTER);
        allCards.setEffect(new GaussianBlur(0));
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            allCards.getChildren().clear();
            number = Math.min(3, gameBattleField.getCommonCardInBattleFieldUser2().size() + gameBattleField.getSpecialCardsBattleFieldUser2().size());
            specialNumber = random.nextInt(Math.min(number, gameBattleField.getSpecialCardsBattleFieldUser2().size()));
            for (int i = 0; i < specialNumber; i++) {
                index = random.nextInt(gameBattleField.getSpecialCardsBattleFieldUser2().size());
                if (indexes.contains(index)) {
                    i -= 1;
                    continue;
                }
                indexes.add(index);
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsBattleFieldUser2().get(index).getImage(), index);
                imageView.setId(null);
                imageView.setOnMouseClicked(null);
                imageView.setOnMouseMoved(e -> zoomIn(imageView));
                imageView.setOnMouseExited(e -> zoomOut(imageView));
                allCards.getChildren().add(imageView);
            }
            indexes.clear();
            for (int i = 0; i < number - specialNumber; i++) {
                index = random.nextInt(gameBattleField.getCommonCardInBattleFieldUser2().size());
                if (indexes.contains(index)) {
                    i -= 1;
                    continue;
                }
                indexes.add(index);
                ImageView imageView = getImageView(gameBattleField.getCommonCardInBattleFieldUser2().get(index).getImage(), index);
                imageView.setId(null);
                imageView.setOnMouseClicked(null);
                imageView.setOnMouseMoved(e -> zoomIn(imageView));
                imageView.setOnMouseExited(e -> zoomOut(imageView));
                allCards.getChildren().add(imageView);
            }
        } else {
            allCards.getChildren().clear();
            number = Math.min(3, gameBattleField.getCommonCardInBattleFieldUser1().size() + gameBattleField.getSpecialCardsBattleFieldUser1().size());
            specialNumber = random.nextInt(Math.min(number, gameBattleField.getSpecialCardsBattleFieldUser1().size()));
            for (int i = 0; i < specialNumber; i++) {
                index = random.nextInt(gameBattleField.getSpecialCardsBattleFieldUser1().size());
                if (indexes.contains(index)) {
                    i -= 1;
                    continue;
                }
                indexes.add(index);
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsBattleFieldUser1().get(index).getImage(), index);
                imageView.setId(null);
                imageView.setOnMouseClicked(null);
                imageView.setOnMouseMoved(e -> zoomIn(imageView));
                imageView.setOnMouseExited(e -> zoomOut(imageView));
                allCards.getChildren().add(imageView);
            }
            indexes.clear();
            for (int i = 0; i < number - specialNumber; i++) {
                index = random.nextInt(gameBattleField.getCommonCardInBattleFieldUser1().size());
                if (indexes.contains(index)) {
                    i -= 1;
                    continue;
                }
                indexes.add(index);
                ImageView imageView = getImageView(gameBattleField.getCommonCardInBattleFieldUser1().get(index).getImage(), index);
                imageView.setId(null);
                imageView.setOnMouseClicked(null);
                imageView.setOnMouseMoved(e -> zoomIn(imageView));
                imageView.setOnMouseExited(e -> zoomOut(imageView));
                allCards.getChildren().add(imageView);
            }
        }
        Pane overlayPane = new Pane();
        overlayPane.getChildren().addAll(allCards);
        parentPane.getChildren().add(overlayPane);
        overlayPane.setOnMouseClicked(e -> {
            Platform.runLater(() -> pane.setEffect(null));
            parentPane.getChildren().remove(overlayPane);
            updateBoard();
            changeTurn();
        });

    }

    private void zoomOut(ImageView imageView) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(250), imageView);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    private void zoomIn(ImageView imageView) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(250), imageView);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    private void TheBeautifulAbility() {
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (gameBattleField.getSpecialFieldInRangedUser1() == null) {
                selectedSpecialCard = SpecialCard.CommandersHorn;
                putSpecialCardInRangedRow();
                return;
            }
        } else {
            if (gameBattleField.getSpecialFieldInRangedUser2() == null) {
                selectedSpecialCard = SpecialCard.CommandersHorn;
                putSpecialCardInRangedRow();
                return;
            }
        }
        updateBoard();
        changeTurn();
    }

    private void BringerOfDeathAbility() {
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (gameBattleField.getSpecialFieldInCloseCombatUser1() == null) {
                selectedSpecialCard = SpecialCard.CommandersHorn;
                putSpecialCardInCloseCombatRow();
                return;
            }
        } else {
            if (gameBattleField.getSpecialFieldInCloseCombatUser2() == null) {
                selectedSpecialCard = SpecialCard.CommandersHorn;
                putSpecialCardInCloseCombatRow();
                return;
            }
        }
        updateBoard();
        changeTurn();
    }

    private void kingOfTemeriaAbility() {
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            if (gameBattleField.getSpecialFieldInSiegeUser1() == null) {
                selectedSpecialCard = SpecialCard.CommandersHorn;
                putSpecialCardInSiegeRow();
                return;
            }
        } else {
            if (gameBattleField.getSpecialFieldInSiegeUser2() == null) {
                selectedSpecialCard = SpecialCard.CommandersHorn;
                putSpecialCardInSiegeRow();
                return;
            }
        }
        updateBoard();
        changeTurn();
    }

    private void putWeatherCardAbility(SpecialCard impenetrableFog) {
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (SpecialCard specialCard : gameBattleField.getSpecialCardsBattleFieldUser1()) {
                if (specialCard.equals(impenetrableFog)) {
                    selectedSpecialCard = impenetrableFog;
                    putWeatherCard();
                    return;
                }
            }
        } else {
            for (SpecialCard specialCard : gameBattleField.getSpecialCardsBattleFieldUser2()) {
                if (specialCard.equals(impenetrableFog)) {
                    selectedSpecialCard = impenetrableFog;
                    putWeatherCard();
                    return;
                }
            }
        }
        updateBoard();
        changeTurn();
    }

    private void scorchAbility() {
        int maxScore = 0;
        maxScore = getMaxScore(maxScore);

        if (maxScore != 0) {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getCloseCombatIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getCloseCombatIsPlayedUser1().get(i));
                        gameBattleField.getCloseCombatIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getRangedIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) myRangedCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getRangedIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getRangedIsPlayedUser1().get(i));
                        gameBattleField.getRangedIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) mySiegeCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getSiegeIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getSiegeIsPlayedUser1().get(i));
                        gameBattleField.getSiegeIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getCloseCombatIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getCloseCombatIsPlayedUser2().get(i));
                        gameBattleField.getCloseCombatIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getRangedIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getRangedIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getRangedIsPlayedUser2().get(i));
                        gameBattleField.getRangedIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getSiegeIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getSiegeIsPlayedUser2().get(i));
                        gameBattleField.getSiegeIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                gameBattleField.getSpecialCardsDiscardUser1().add(selectedSpecialCard);
                gameBattleField.getSpecialCardsBattleFieldUser1().remove(selectedSpecialCard);
            } else {
                for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(i);
                    if (((ImageView) stackPane.getChildren().getFirst()).getImage() == null) break;
                    if (gameBattleField.getCloseCombatIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getCloseCombatIsPlayedUser2().get(i));
                        gameBattleField.getCloseCombatIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getRangedIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) myRangedCombatCardsPlayed.getChildren().get(i);
                    if (((ImageView) stackPane.getChildren().getFirst()).getImage() == null) break;
                    if (gameBattleField.getRangedIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getRangedIsPlayedUser2().get(i));
                        gameBattleField.getRangedIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) mySiegeCardsPlayed.getChildren().get(i);
                    if (((ImageView) stackPane.getChildren().getFirst()).getImage() == null) break;
                    if (gameBattleField.getSiegeIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getSiegeIsPlayedUser2().get(i));
                        gameBattleField.getSiegeIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                    if (((ImageView) stackPane.getChildren().getFirst()).getImage() == null) break;
                    if (gameBattleField.getCloseCombatIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getCloseCombatIsPlayedUser1().get(i));
                        gameBattleField.getCloseCombatIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getRangedIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                    if (((ImageView) stackPane.getChildren().getFirst()).getImage() == null) break;
                    if (gameBattleField.getRangedIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getRangedIsPlayedUser1().get(i));
                        gameBattleField.getRangedIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                    if (((ImageView) stackPane.getChildren().getFirst()).getImage() == null) break;
                    if (gameBattleField.getSiegeIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getSiegeIsPlayedUser1().get(i));
                        gameBattleField.getSiegeIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
                gameBattleField.getSpecialCardsDiscardUser2().add(selectedSpecialCard);
                gameBattleField.getSpecialCardsBattleFieldUser2().remove(selectedSpecialCard);
            }
        } else {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                gameBattleField.getSpecialCardsDiscardUser1().add(selectedSpecialCard);
                gameBattleField.getSpecialCardsBattleFieldUser1().remove(selectedSpecialCard);
            } else {
                gameBattleField.getSpecialCardsDiscardUser2().add(selectedSpecialCard);
                gameBattleField.getSpecialCardsBattleFieldUser2().remove(selectedSpecialCard);
            }
        }
        isTransitioning = false;
        unSelectCard();
        updateBoard();
        changeTurn();
    }

    private int getMaxScore(int maxScore) {
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getCloseCombatIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getRangedIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) myRangedCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getRangedIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) mySiegeCardsPlayed.getChildren().get(i);
                if (gameBattleField.getSiegeIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getCloseCombatIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getRangedIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getRangedIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                if (gameBattleField.getSiegeIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
        } else {
            for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) myCloseCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getCloseCombatIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getRangedIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) myRangedCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getRangedIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) mySiegeCardsPlayed.getChildren().get(i);
                if (gameBattleField.getSiegeIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getCloseCombatIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getRangedIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getRangedIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
            for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                if (gameBattleField.getSiegeIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                if (maxScore < score) maxScore = score;
            }
        }
        return maxScore;
    }

    private void scorchCloseCombatAbility() {
        int maxScore = getMaxScoreInCloseCombatRow();
        if (maxScore != 0) {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getCloseCombatIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getCloseCombatIsPlayedUser2().get(i));
                        gameBattleField.getCloseCombatIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
            } else {
                for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getCloseCombatIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getCloseCombatIsPlayedUser1().get(i));
                        gameBattleField.getCloseCombatIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
            }
        }
        unSelectCard();
        updateBoard();
        changeTurn();
    }

    private int getMaxScoreInCloseCombatRow() {
        int maxScore = 0;
        int sum = 0;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getCloseCombatIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                sum += score;
                if (maxScore < score) maxScore = score;
            }
        } else {
            for (int i = 0; i < gameBattleField.getCloseCombatIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) competitorCloseCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getCloseCombatIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                sum += score;
                if (maxScore < score) maxScore = score;
            }
        }
        if (sum < 10) return 0;
        return maxScore;
    }

    private void scorchRangedAbility() {
        int maxScore = getMaxScoreInRangedRow();
        if (maxScore != 0) {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                for (int i = 0; i < gameBattleField.getRangedIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getRangedIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getRangedIsPlayedUser2().get(i));
                        gameBattleField.getRangedIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
            } else {
                for (int i = 0; i < gameBattleField.getRangedIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getRangedIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getRangedIsPlayedUser1().get(i));
                        gameBattleField.getRangedIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
            }
        }
        unSelectCard();
        updateBoard();
        changeTurn();
    }

    private int getMaxScoreInRangedRow() {
        int maxScore = 0;
        int sum = 0;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < gameBattleField.getRangedIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getRangedIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                sum += score;
                if (maxScore < score) maxScore = score;
            }
        } else {
            for (int i = 0; i < gameBattleField.getRangedIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) competitorRangedCombatCardsPlayed.getChildren().get(i);
                if (gameBattleField.getRangedIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                sum += score;
                if (maxScore < score) maxScore = score;
            }
        }
        if (sum < 10) return 0;
        return maxScore;
    }

    private void scorchSiegeAbility() {
        int maxScore = getMaxScoreInSiegeRow();
        if (maxScore != 0) {
            if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
                for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser2().size(); i++) {
                    StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getSiegeIsPlayedUser2().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser2().add(gameBattleField.getSiegeIsPlayedUser2().get(i));
                        gameBattleField.getSiegeIsPlayedUser2().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
            } else {
                for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser1().size(); i++) {
                    StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                    if (gameBattleField.getSiegeIsPlayedUser1().get(i).isHero()) continue;
                    int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                    if (maxScore == score) {
                        gameBattleField.getCommonCardsInDiscardUser1().add(gameBattleField.getSiegeIsPlayedUser1().get(i));
                        gameBattleField.getSiegeIsPlayedUser1().remove(i);
                        i -= 1;
                        updateBoard();
                    }
                }
            }
        }
        unSelectCard();
        updateBoard();
        changeTurn();
    }

    private int getMaxScoreInSiegeRow() {
        int maxScore = 0;
        int sum = 0;
        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser2().size(); i++) {
                StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                if (gameBattleField.getSiegeIsPlayedUser2().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                sum += score;
                if (maxScore < score) maxScore = score;
            }
        } else {
            for (int i = 0; i < gameBattleField.getSiegeIsPlayedUser1().size(); i++) {
                StackPane stackPane = (StackPane) competitorSiegeCardsPlayed.getChildren().get(i);
                if (gameBattleField.getSiegeIsPlayedUser1().get(i).isHero()) continue;
                int score = Integer.parseInt(((Label) stackPane.getChildren().get(2)).getText());
                sum += score;
                if (maxScore < score) maxScore = score;
            }
        }
        if (sum < 10) return 0;
        return maxScore;
    }

    public void showCompetitorDiscardCards() {
        GaussianBlur gaussianBlur = new GaussianBlur(20);
        Platform.runLater(() -> pane.setEffect(gaussianBlur));

        allCards = new HBox(1050);
        allCards.setLayoutX(90);
        allCards.setLayoutY(200);
        allCards.setSpacing(10);
        allCards.setAlignment(Pos.CENTER);
        allCards.setEffect(new GaussianBlur(0));

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser2().size() + gameBattleField.getCommonCardsInDiscardUser2().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser2().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser2().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser2().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
        } else {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser1().size() + gameBattleField.getCommonCardsInDiscardUser1().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser1().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser1().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser1().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
        }

        Pane overlayPane = new Pane();
        overlayPane.getChildren().addAll(allCards);
        overlayPane.setOnMouseClicked(e -> {
            Platform.runLater(() -> pane.setEffect(null));
            parentPane.getChildren().remove(overlayPane);
        });

        parentPane.getChildren().add(overlayPane);
    }

    public void showMyDiscardCards() {
        GaussianBlur gaussianBlur = new GaussianBlur(20);
        Platform.runLater(() -> pane.setEffect(gaussianBlur));

        allCards = new HBox(1050);
        allCards.setLayoutX(90);
        allCards.setLayoutY(200);
        allCards.setSpacing(10);
        allCards.setAlignment(Pos.CENTER);
        allCards.setEffect(new GaussianBlur(0));

        if (gameBattleField.getWhichUserTurn().equals(gameBattleField.getUser1())) {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser1().size() + gameBattleField.getCommonCardsInDiscardUser1().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser1().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser1().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser1().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser1().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
        } else {
            allCards.getChildren().clear();
            if (gameBattleField.getSpecialCardsDiscardUser2().size() + gameBattleField.getCommonCardsInDiscardUser2().size() == 0) {
                Platform.runLater(() -> pane.setEffect(null));
                return;
            }
            for (int i = 0; i < gameBattleField.getSpecialCardsDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getSpecialCardsDiscardUser2().get(i).getImage(), i);
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
            for (int i = 0; i < gameBattleField.getCommonCardsInDiscardUser2().size(); i++) {
                ImageView imageView = getImageView(gameBattleField.getCommonCardsInDiscardUser2().get(i).getImage(), i + gameBattleField.getSpecialCardsDiscardUser2().size());
                imageView.setFitWidth(110);
                imageView.setOnMouseClicked(null);
                imageView.setId(null);
                allCards.getChildren().add(imageView);
            }
        }

        Pane overlayPane = new Pane();
        overlayPane.getChildren().addAll(allCards);
        overlayPane.setOnMouseClicked(e -> {
            Platform.runLater(() -> pane.setEffect(null));
            parentPane.getChildren().remove(overlayPane);
        });

        parentPane.getChildren().add(overlayPane);
    }

    public void cheatCodes(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if (keyCode == KeyCode.C) {
            gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser1());
            gameBattleFieldController.giveOneRandomCommonCardToUserPlayed(gameBattleField.getUser2());
        } else if (keyCode == KeyCode.S) {
            gameBattleFieldController.giveOneRandomSpecialCardToUserPlayed(gameBattleField.getUser1());
            gameBattleFieldController.giveOneRandomSpecialCardToUserPlayed(gameBattleField.getUser2());
        } else if (keyCode == KeyCode.H) {
            gameBattleField.setRound(1);
            gameBattleField.setHealthUser1(2);
            gameBattleField.setHealthUser2(2);
        } else if (keyCode == KeyCode.L) {
            gameBattleField.setExistAbilityUser1(true);
            gameBattleField.setExistAbilityUser2(true);
        } else if (keyCode == KeyCode.M) {
            gameBattleField.getCommonCardInBattleFieldUser1().add(CommonCard.Berserker);
            gameBattleField.getSpecialCardsBattleFieldUser1().add(SpecialCard.Mardroeme);
            gameBattleField.getCommonCardInBattleFieldUser2().add(CommonCard.YoungBerserker);
            gameBattleField.getCommonCardInBattleFieldUser2().add(CommonCard.YoungBerserker);
            gameBattleField.getSpecialCardsBattleFieldUser2().add(SpecialCard.Mardroeme);
        } else if (keyCode == KeyCode.D) {
            gameBattleField.getSpecialCardsBattleFieldUser1().add(SpecialCard.Scorch);
            gameBattleField.getSpecialCardsBattleFieldUser2().add(SpecialCard.Scorch);
        } else if (keyCode == KeyCode.W) {
            Random random = new Random();
            int weatherNumber1 = random.nextInt(1, 6);
            int weatherNumber2 = random.nextInt(1, 6);
            cheatWeatherCard(weatherNumber1, gameBattleField.getSpecialCardsBattleFieldUser1());
            cheatWeatherCard(weatherNumber2, gameBattleField.getSpecialCardsBattleFieldUser2());
        } else if (keyCode == KeyCode.J) {
            gameBattleField.getCommonCardInBattleFieldUser1().add(CommonCard.MysteriousElf);
            gameBattleField.getCommonCardInBattleFieldUser2().add(CommonCard.MysteriousElf);
        } else if (keyCode == KeyCode.F) {
            Random random = new Random();
            int leaderNumber1 = random.nextInt(1, 20);
            int leaderNumber2 = random.nextInt(1, 20);
            cheatChangeLeader(leaderNumber1, gameBattleField.getUser1());
            cheatChangeLeader(leaderNumber2, gameBattleField.getUser2());
        }
        updateBoard();
    }

    private void cheatChangeLeader(int leaderNumber1, User gameBattleField) {
        if (leaderNumber1 == 1) {
            gameBattleField.setFactionSelected(Faction.NorthernRealms);
            gameBattleField.setFactionLeader(Leader.SiegeMaster);
        } else if (leaderNumber1 == 2) {
            gameBattleField.setFactionSelected(Faction.NorthernRealms);
            gameBattleField.setFactionLeader(Leader.SteelForged);
        } else if (leaderNumber1 == 3) {
            gameBattleField.setFactionSelected(Faction.NorthernRealms);
            gameBattleField.setFactionLeader(Leader.KingOfTemeria);
        } else if (leaderNumber1 == 4) {
            gameBattleField.setFactionSelected(Faction.NorthernRealms);
            gameBattleField.setFactionLeader(Leader.LordCommanderOfTheNorth);
        } else if (leaderNumber1 == 5) {
            gameBattleField.setFactionSelected(Faction.NorthernRealms);
            gameBattleField.setFactionLeader(Leader.SonOfMedell);
        } else if (leaderNumber1 == 6) {
            gameBattleField.setFactionSelected(Faction.Nilfgaard);
            gameBattleField.setFactionLeader(Leader.WhiteFlame);
        } else if (leaderNumber1 == 7) {
            gameBattleField.setFactionSelected(Faction.Nilfgaard);
            gameBattleField.setFactionLeader(Leader.HisImperialMajesty);
        } else if (leaderNumber1 == 8) {
            gameBattleField.setFactionSelected(Faction.Nilfgaard);
            gameBattleField.setFactionLeader(Leader.TheRelentless);
        } else if (leaderNumber1 == 9) {
            gameBattleField.setFactionSelected(Faction.Nilfgaard);
            gameBattleField.setFactionLeader(Leader.InvaderOfTheNorth);
        } else if (leaderNumber1 == 10) {
            gameBattleField.setFactionSelected(Faction.Monsters);
            gameBattleField.setFactionLeader(Leader.BringerOfDeath);
        } else if (leaderNumber1 == 11) {
            gameBattleField.setFactionSelected(Faction.Monsters);
            gameBattleField.setFactionLeader(Leader.KingOfTheWildHunt);
        } else if (leaderNumber1 == 12) {
            gameBattleField.setFactionSelected(Faction.Monsters);
            gameBattleField.setFactionLeader(Leader.TheTreacherous);
        } else if (leaderNumber1 == 13) {
            gameBattleField.setFactionSelected(Faction.Scoiatael);
            gameBattleField.setFactionLeader(Leader.QueenOfDolBlathanna);
        } else if (leaderNumber1 == 14) {
            gameBattleField.setFactionSelected(Faction.Scoiatael);
            gameBattleField.setFactionLeader(Leader.TheBeautiful);
        } else if (leaderNumber1 == 15) {
            gameBattleField.setFactionSelected(Faction.Scoiatael);
            gameBattleField.setFactionLeader(Leader.PurebloodElf);
        } else if (leaderNumber1 == 16) {
            gameBattleField.setFactionSelected(Faction.Skellige);
            gameBattleField.setFactionLeader(Leader.KingBran);
        } else if (leaderNumber1 == 17) {
            gameBattleField.setFactionSelected(Faction.Skellige);
            gameBattleField.setFactionLeader(Leader.CrachAnCraite);
        }
    }

    private void cheatWeatherCard(int weatherNumber1, ArrayList<SpecialCard> gameBattleField) {
        if (weatherNumber1 == 1) {
            gameBattleField.add(SpecialCard.BitingFrost);
        } else if (weatherNumber1 == 2) {
            gameBattleField.add(SpecialCard.ImpenetrableFog);
        } else if (weatherNumber1 == 3) {
            gameBattleField.add(SpecialCard.TorrentialRain);
        } else if (weatherNumber1 == 4) {
            gameBattleField.add(SpecialCard.SkelligeStorm);
        } else if (weatherNumber1 == 5) {
            gameBattleField.add(SpecialCard.ClearWeather);
        }
    }
}
