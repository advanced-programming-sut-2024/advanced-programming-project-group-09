package Sample.Network.Client.controller.UserAndGameControllers;

import Sample.Network.Client.CardEnums.Faction;
import Sample.Network.Client.CardEnums.Leader;
import Sample.Network.Client.model.Gwent;
import Sample.Network.Client.model.User.User;
import Sample.Network.Client.view.UserAndGameMenus.LeaderMenu;
import Sample.Network.Client.view.UserAndGameMenus.LoginMenu;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Objects;

public class FactionController {
    @FXML
    private Label faction;
    @FXML
    private Label sentence;
    @FXML
    private StackPane border1;
    @FXML
    private HBox allImages;
    @FXML
    private ImageView image1;
    @FXML
    private StackPane border2;
    @FXML
    private ImageView image2;
    @FXML
    private StackPane border3;
    @FXML
    private ImageView image3;
    @FXML
    private StackPane border4;
    @FXML
    private ImageView image4;
    @FXML
    private StackPane border5;
    @FXML
    private ImageView image5;
    private TranslateTransition translateTransition;
    private ScaleTransition scaleTransition;
    private Timeline timeline;
    private static Alert currentAlert;

    public void initialize() {
        setWidthAndHeight();
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.01), event -> {
                    checkFactionLeader();
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Image factionMonster = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_back_monsters.jpg")));
        Image factionNilfgaardian = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_back_nilfgaard.jpg")));
        Image factionNorthern = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_back_realms.jpg")));
        Image factionScoiatael = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_back_scoiatael.jpg")));
        Image factionSkellige = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_back_skellige.jpg")));

        image1.setImage(factionMonster);
        image2.setImage(factionNilfgaardian);
        image3.setImage(factionNorthern);
        image4.setImage(factionScoiatael);
        image5.setImage(factionSkellige);

        Faction factionSelected = Gwent.getInstance().getUserLoginIn().getFactionSelected();
        faction.setText(factionSelected.getFactionName());
        sentence.setText(factionSelected.getAbility());
    }

    private void checkFactionLeader() {
        User user = Gwent.getInstance().getUserLoginIn();
        if (user.getFactionSelected().equals(Faction.Monsters)) {
            addBorder(1);
        } else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
            addBorder(2);
        } else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
            addBorder(3);
        } else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
            addBorder(4);
        } else if (user.getFactionSelected().equals(Faction.Skellige)) {
            addBorder(5);
        }
    }

    private void addBorder(int i) {
        BorderStroke borderStroke = new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(8));
        Border border = new Border(borderStroke);
        if (i == 1) {
            border1.setBorder(border);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(null);
        } else if (i == 2) {
            border1.setBorder(null);
            border2.setBorder(border);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(null);
        } else if (i == 3) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(border);
            border4.setBorder(null);
            border5.setBorder(null);
        } else if (i == 4) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(border);
            border5.setBorder(null);
        } else if (i == 5) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(border);
        } else if (i == 0) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(null);
        }
    }

    private void setWidthAndHeight() {
        image1.setFitHeight(200);
        image1.setFitWidth(130);
        image2.setFitHeight(200);
        image2.setFitWidth(130);
        image3.setFitHeight(200);
        image3.setFitWidth(130);
        image4.setFitHeight(200);
        image4.setFitWidth(130);
        image5.setFitHeight(200);
        image5.setFitWidth(130);
    }

    public void focusOnImage(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        String id = imageView.getId();

        switch (id) {
            case "image1" -> {
                faction.setText(Faction.Monsters.getFactionName());
                sentence.setText(Faction.Monsters.getAbility());
            }
            case "image2" -> {
                faction.setText(Faction.Nilfgaard.getFactionName());
                sentence.setText(Faction.Nilfgaard.getAbility());
            }
            case "image3" -> {
                faction.setText(Faction.NorthernRealms.getFactionName());
                sentence.setText(Faction.NorthernRealms.getAbility());
            }
            case "image4" -> {
                faction.setText(Faction.Scoiatael.getFactionName());
                sentence.setText(Faction.Scoiatael.getAbility());
            }
            case "image5" -> {
                faction.setText(Faction.Skellige.getFactionName());
                sentence.setText(Faction.Skellige.getAbility());
            }
        }

        scaleTransition = new ScaleTransition(Duration.millis(500), imageView);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        translateTransition = new TranslateTransition(Duration.millis(500), imageView);
        translateTransition.setToX((imageView.getFitWidth() - imageView.getLayoutBounds().getWidth()) / 2);
        translateTransition.setToY((imageView.getFitHeight() - imageView.getLayoutBounds().getHeight()) / 2 + 50);
        translateTransition.play();
    }

    public void unFocus(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();

        Faction factionSelected = Gwent.getInstance().getUserLoginIn().getFactionSelected();
        faction.setText(factionSelected.getFactionName());
        sentence.setText(factionSelected.getAbility());

        scaleTransition = new ScaleTransition(Duration.millis(500), imageView);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        translateTransition = new TranslateTransition(Duration.millis(500), imageView);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.play();
    }

    public void changeLeader(MouseEvent mouseEvent) throws Exception {
        User user = Gwent.getInstance().getUserLoginIn();
        Faction factionSelected = Gwent.getInstance().getUserLoginIn().getFactionSelected();
        ImageView source = (ImageView) mouseEvent.getSource();
        String id = source.getId();

        switch (id) {
            case "image1" -> {
                if (factionSelected.equals(Faction.Monsters)) {
                    backToLeaderMenu();
                    return;
                }
                if (confirmation()) return;
                user.setFactionSelected(Faction.Monsters);
                user.setFactionLeader(Leader.BringerOfDeath);
            }
            case "image2" -> {
                if (factionSelected.equals(Faction.Nilfgaard)) {
                    backToLeaderMenu();
                    return;
                }
                if (confirmation()) return;
                user.setFactionSelected(Faction.Nilfgaard);
                user.setFactionLeader(Leader.WhiteFlame);
            }
            case "image3" -> {
                if (factionSelected.equals(Faction.NorthernRealms)) {
                    backToLeaderMenu();
                    return;
                }
                if (confirmation()) return;
                user.setFactionSelected(Faction.NorthernRealms);
                user.setFactionLeader(Leader.KingOfTemeria);
            }
            case "image4" -> {
                if (factionSelected.equals(Faction.Scoiatael)) {
                    backToLeaderMenu();
                    return;
                }
                if (confirmation()) return;
                user.setFactionSelected(Faction.Scoiatael);
                user.setFactionLeader(Leader.QueenOfDolBlathanna);
            }
            case "image5" -> {
                if (factionSelected.equals(Faction.Skellige)) {
                    backToLeaderMenu();
                    return;
                }
                if (confirmation()) return;
                user.setFactionSelected(Faction.Skellige);
                user.setFactionLeader(Leader.CrachAnCraite);
            }
        }
        backToLeaderMenu();
    }

    private static boolean confirmation() {
        currentAlert = new Alert(Alert.AlertType.CONFIRMATION);
        currentAlert.setContentText("Are you sure to change your faction?");
        currentAlert.showAndWait();
        return currentAlert.getResult().getButtonData().isCancelButton();
    }

    public void backToLeaderMenu() throws Exception {
        timeline.stop();
        LeaderMenu leaderMenu = new LeaderMenu();
        leaderMenu.start(ApplicationController.getStage());
    }

    public void doNotSelectNewFaction(MouseEvent mouseEvent) throws Exception {
        if (currentAlert == null || !currentAlert.isShowing()) {
            if (!allImages.contains(mouseEvent.getX(), mouseEvent.getY())) {
                backToLeaderMenu();
            }
        }
    }
}