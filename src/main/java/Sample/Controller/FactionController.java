package Sample.Controller;

import Sample.CardEnums.Faction;
import Sample.CardEnums.Leader;
import Sample.Model.User;
import Sample.View.LoginMenu;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Objects;

public class FactionController {
    @FXML
    private StackPane border1;
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

    public void initialize() {
        setWidthAndHeight();
        User user = User.getUserLoginIn();
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.01), event -> {
                    checkFactionLeader();
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Image monsterLeader1 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_bronze.jpg")));
        Image monsterLeader2 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_copper.jpg")));
        Image monsterLeader3 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_gold.jpg")));
        Image monsterLeader4 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_silver.jpg")));
        Image monsterLeader5 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_the_treacherous.jpg")));
        if (user.getFactionSelected().equals(Faction.Monsters)) {
            image1.setImage(monsterLeader1);
            image2.setImage(monsterLeader2);
            image3.setImage(monsterLeader3);
            image4.setImage(monsterLeader4);
            image5.setImage(monsterLeader5);
        }
    }

    private void checkFactionLeader() {
        User user = User.getUserLoginIn();
        if (user.getFactionSelected().equals(Faction.Monsters)) {
            if (user.getFactionLeader().equals(Leader.KingOfTheWildHunt)) {
                addBorder(1);
            } else if (user.getFactionLeader().equals(Leader.CommanderOfTheRedRiders)) {
                addBorder(2);
            } else if (user.getFactionLeader().equals(Leader.DestroyerOfWorlds)) {
                addBorder(3);
            } else if (user.getFactionLeader().equals(Leader.BringerOfDeath)) {
                addBorder(4);
            } else if (user.getFactionLeader().equals(Leader.TheTreacherous)) {
                addBorder(5);
            }
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
        image1.setFitHeight(260);
        image1.setFitWidth(130);
        image2.setFitHeight(260);
        image2.setFitWidth(130);
        image3.setFitHeight(260);
        image3.setFitWidth(130);
        image4.setFitHeight(260);
        image4.setFitWidth(130);
        image5.setFitHeight(260);
        image5.setFitWidth(130);
    }

    public void changeFaction(MouseEvent mouseEvent) {

    }

    public void focusOnImage(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        scaleTransition = new ScaleTransition(Duration.millis(500), imageView);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        translateTransition = new TranslateTransition(Duration.millis(500), imageView);
        translateTransition.setToX((imageView.getFitWidth() - imageView.getLayoutBounds().getWidth()) / 2);
        translateTransition.setToY((imageView.getFitHeight() - imageView.getLayoutBounds().getHeight()) / 2 + 100);
        translateTransition.play();
    }

    public void unFocus(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
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
    public void unFocusAfterChooseLeader(ImageView imageView) {
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




    public void changeLeader(MouseEvent mouseEvent) {
        User user = User.getUserLoginIn();
        ImageView source = (ImageView) mouseEvent.getSource();
        String id = source.getId();

        switch (id) {
            case "image1" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.KingOfTheWildHunt);

                unFocusAfterChooseLeader(image1);
            }
            case "image2" -> {
                if (user.getFactionSelected().equals(Faction.Monsters))
                    user.setFactionLeader(Leader.CommanderOfTheRedRiders);
                unFocusAfterChooseLeader(image2);
            }
            case "image3" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.DestroyerOfWorlds);
                unFocusAfterChooseLeader(image3);
            }
            case "image4" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.BringerOfDeath);
                unFocusAfterChooseLeader(image4);
            }
            case "image5" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.TheTreacherous);
                unFocusAfterChooseLeader(image5);
            }
        }

    }

}

