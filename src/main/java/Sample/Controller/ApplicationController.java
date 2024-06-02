package Sample.Controller;

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