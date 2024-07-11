package Sample.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

import java.net.URL;

public class ChatMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("FXML/ChatMenu.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Chat Menu");
        primaryStage.setScene(scene);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(String.valueOf(ChatMenu.class.getResource("Images/ChatMenu.jpg")), 0, 0, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}