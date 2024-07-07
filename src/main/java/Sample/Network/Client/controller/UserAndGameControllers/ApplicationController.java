package Sample.Network.Client.controller.UserAndGameControllers;

import javafx.stage.Stage;

public class ApplicationController {
    private static Stage stage;

    public static void setStage(Stage stage) {
        ApplicationController.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }
}
