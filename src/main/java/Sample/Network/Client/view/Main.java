package Sample.Network.Client.view;

import Sample.Network.Client.controller.UserControllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import Sample.Network.Client.Connection;
import Sample.Network.Client.view.UserMenus.LoginMenu;

import java.io.IOException;

public class Main extends Application {
    public static Stage mainStage;

    public static void main(String[] args) {
        Connection.connect("localhost", 8080);
        ConstantManager.load();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginMenu.setLoginController(new LoginController());
        mainStage = stage;
        stage.setOnCloseRequest(event -> {
            try {
                Connection.getInstance().closeConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        stage.setFullScreen(true);
        new LoginMenu().start(stage);
    }
}
