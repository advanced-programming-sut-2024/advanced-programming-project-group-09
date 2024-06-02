package Sample.View;

import Sample.Controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Scanner;


public class ProfileMenu extends Application {
    public static void run(Scanner scanner) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("/FXML/Profile.fxml");
        BorderPane root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        ApplicationController.getStage().centerOnScreen();
        ApplicationController.getStage().setTitle("Profile Menu");
        ApplicationController.getStage().setScene(scene);
        ApplicationController.getStage().show();
    }
}
