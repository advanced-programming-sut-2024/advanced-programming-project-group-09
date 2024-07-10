package Sample.View;

import Sample.Controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class GameMenu extends Application {
    private static MediaPlayer mediaPlayer = null;
    @Override
    public void start(Stage stage) throws Exception {
        ApplicationController.setStage(stage);
        stage.setResizable(false);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2 - 230);
        stage.setY(bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2 - 50);

        URL url = LoginMenu.class.getResource("FXMl/Game.fxml");
        assert url != null;
        Pane root = FXMLLoader.load(url);
//        if (MainMenu.getMediaPlayer() == null) {
//            Media media = new Media(Objects.requireNonNull(LoginMenu.class.getResource("/Media/MainMenuMedia.mp3")).toExternalForm());
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setOnEndOfMedia(() -> {
//                mediaPlayer.seek(Duration.ZERO);
//                mediaPlayer.play();
//            });
//            mediaPlayer.play();
//        }
        Scene scene = new Scene(root, 1280, 720);
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
        GameMenu.mediaPlayer = mediaPlayer;
    }

}
