package Sample.Network.Client.view.UserAndGameMenus.ChooseCard;

import Sample.Network.Client.view.UserAndGameMenus.LoginMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class ChooseCardNorthernRealmsTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(Objects.requireNonNull(LoginMenu.class.getResource("FXMl/ChooseCard/ChooseCardNorthernRealms.fxml")));
        primaryStage.setTitle("Card Selection");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
