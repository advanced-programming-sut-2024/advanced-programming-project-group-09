package Sample.View;

import Sample.Controller.ApplicationController;
import Sample.Controller.LoginController;

import Sample.Controller.NetworkController;
import Sample.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;


public class LoginMenu extends Application {
    LoginController loginController;
    private static MediaPlayer mediaPlayer = null;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationController.setStage(stage);
        stage.centerOnScreen();
        URL url = LoginMenu.class.getResource("FXMl/Login.fxml");
        assert url != null;
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        BorderPane root = fxmlLoader.load();
        loginController = fxmlLoader.getController();
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(String.valueOf(LoginMenu.class.getResource("Images/Login.jpg")), 0, 0, false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        Background background = new Background(backgroundImage);
        new BackgroundSize(1.0, 1.0, true, true, false, false);
        root.setBackground(background);
        if (MainMenu.getMediaPlayer() != null) {
            MainMenu.getMediaPlayer().stop();
            MainMenu.setMediaPlayer(null);
        }
        if (LoginMenu.getMediaPlayer() == null) {
            Media media = new Media(Objects.requireNonNull(LoginMenu.class.getResource("Media/LoginAndRegisterMenuMedia.mp3")).toExternalForm());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.seek(Duration.ZERO);
                mediaPlayer.play();
            });
            mediaPlayer.play();
        }
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        Image icon = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icon.jpg")));
        stage.getIcons().add(icon);
        stage.show();
//        NetworkController.createTimeLineForUpdateUsers();
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        LoginMenu.mediaPlayer = mediaPlayer;
    }
}