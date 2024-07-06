package Sample.View.ChooseCard;

import Sample.Controller.ApplicationController;
import Sample.View.LoginMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class ChooseCardNilfGaardianTest extends Application {

    private static MediaPlayer mediaPlayer = LoginMenu.getMediaPlayer();

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationController.setStage(stage);
        stage.centerOnScreen();
        URL url = LoginMenu.class.getResource("FXMl/ChooseCardNilfGaardian.fxml");
        assert url != null;
        VBox root = FXMLLoader.load(url);
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(String.valueOf(LoginMenu.class.getResource("Images/Faction.jpg")), 0, 0, false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        Background background = new Background(backgroundImage);
        new BackgroundSize(1.0, 1.0, true, true, false, false);
        root.setBackground(background);
//        if (LeaderMenu.getMediaPlayer() == null) {
//            Media media = new Media(Objects.requireNonNull(LoginMenu.class.getResource("Media/LoginAndRegisterMenuMedia.mp3")).toExternalForm());
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setOnEndOfMedia(() -> {
//                mediaPlayer.seek(Duration.ZERO);
//                mediaPlayer.play();
//            });
//            mediaPlayer.play();
//        }
        Scene scene = new Scene(root, 950, 700);
        stage.setScene(scene);
        Image icon = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icon.jpg")));
        stage.getIcons().add(icon);
        stage.show();
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        ChooseCardNilfGaardianTest.mediaPlayer = mediaPlayer;
    }
}
