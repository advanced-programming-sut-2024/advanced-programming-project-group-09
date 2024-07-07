package Sample.Network.Client.view.UserAndGameMenus;

import Sample.Network.Client.controller.UserAndGameControllers.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class StartNewGameMenu extends Application {
    private static MediaPlayer mediaPlayer = null;
    @Override
    public void start(Stage stage) throws Exception {
        ApplicationController.setStage(stage);
        stage.setResizable(false);
        stage.centerOnScreen();
        URL url = LoginMenu.class.getResource("FXMl/StartNewGame.fxml");
        assert url != null;
        BorderPane root = FXMLLoader.load(url);
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(String.valueOf(LoginMenu.class.getResource("Images/Main.jpg")), 0, 0, false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        Background background = new Background(backgroundImage);
        new BackgroundSize(1.0, 1.0, true, true, false, false);
        root.setBackground(background);
        if (LoginMenu.getMediaPlayer() != null) {
            LoginMenu.getMediaPlayer().stop();
            LoginMenu.setMediaPlayer(null);
        }
//        if (MainMenu.getMediaPlayer() == null) {
//            Media media = new Media(Objects.requireNonNull(LoginMenu.class.getResource("/Media/MainMenuMedia.mp3")).toExternalForm());
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setOnEndOfMedia(() -> {
//                mediaPlayer.seek(Duration.ZERO);
//                mediaPlayer.play();
//            });
//            mediaPlayer.play();
//        }
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        Image icon = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icon.jpg")));
//        Image cursor = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/cursor.png")));
//        scene.setCursor(new ImageCursor(cursor));
        stage.getIcons().add(icon);
        stage.show();
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        StartNewGameMenu.mediaPlayer = mediaPlayer;
    }
}