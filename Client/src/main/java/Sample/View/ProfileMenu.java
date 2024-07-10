package Sample.View;

import Sample.Controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;


public class ProfileMenu extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("FXML/Profile.fxml");
        BorderPane root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 800, 600);
        ApplicationController.getStage().centerOnScreen();
        ApplicationController.getStage().setTitle("Profile Menu");
        ApplicationController.getStage().setScene(scene);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(String.valueOf(ProfileMenu.class.getResource("Images/Profile.jpg")), 0, 0, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background background = new Background(backgroundImage);
        root.setBackground(background);
        new BackgroundSize(1.0, 1.0, true, true, false, false);


        ApplicationController.getStage().show();
    }
}
