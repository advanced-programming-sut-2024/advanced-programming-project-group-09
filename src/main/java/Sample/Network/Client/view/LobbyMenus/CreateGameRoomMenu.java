package Sample.Network.Client.view.LobbyMenus;

import Sample.Network.Client.controller.GameControllers.LobbyController;
import Sample.Network.Client.controller.UserControllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Sample.Network.Client.model.Lobby.Lobby;
import Sample.Network.Client.model.Lobby.LobbyManager;
import Sample.Network.Client.view.Main;
import Sample.Network.Client.view.UserMenus.ProfileMenu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateGameRoomMenu extends Application implements Initializable {
    public TextField gameID;
    public Text gameIdError;
    public Text colorError;
    public Circle colorCircle;
    public ImageView pickColor;
    public TextField pickedColor;
    public Text capacity;
    public Button createNewGameButton;
    public ArrayList<String> gameIds = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane rootPane = FXMLLoader.load(LobbyMenu.class.getResource("/FXML/Gamefxml/Lobbyfxml/createGameRoom.fxml"));
        stage.setScene(new Scene(rootPane));
        stage.setFullScreen(true);
        rootPane.setBackground(new Background(new BackgroundImage(new Image(
                ProfileMenu.class.getResource("/assets/backgrounds/lobbyBackGround.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false))));
        stage.show();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGameIdsForRooms();
        createNewGameButton.setDisable(true);
        colorCircle.setVisible(false);
        gameID.textProperty().addListener((observableValue, oldText, newText) -> {
            if (gameIds.contains(gameID.getText())) gameIdError.setText("This id already taken");
            else gameIdError.setText("");
        });

        pickColor.setOnMousePressed(e -> addColor());

        createNewGameButton.setOnMouseClicked(e -> {
            try {
                createNewGameRoom();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void initializeGameIdsForRooms() {
        ArrayList<Lobby> lobbies = LobbyManager.getLobbies();
        if (lobbies != null) {
            for (Lobby lobby : lobbies) {
                gameIds.add(lobby.getId());
            }
        }
    }

    private void createNewGameRoom() throws Exception {
        Lobby lobby = new Lobby(gameID.getText(), MainController.getCurrentUser(), Color.valueOf(pickedColor.getText()));
        LobbyManager.createLobby(lobby);
        GameRoomMenu.setLobbyController(new LobbyController(lobby));
        new GameRoomMenu().start(Main.mainStage);
    }

    private void addColor() {
        colorCircle.setVisible(true);
        colorCircle.setFill(Paint.valueOf(pickedColor.getText()));
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        new LobbyMenu().start(Main.mainStage);
    }
}
