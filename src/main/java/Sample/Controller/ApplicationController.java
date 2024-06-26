package Sample.Controller;

import javafx.stage.Stage;

public class ApplicationController {
    private static Stage stage;
    private GameController gameController = new GameController();

    public static void setStage(Stage stage) {
        ApplicationController.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    public void start() {
        // Your existing start code

        // Add shutdown hook to save game state and user data when the application exits
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            gameController.endGame();
        }));
    }
}
