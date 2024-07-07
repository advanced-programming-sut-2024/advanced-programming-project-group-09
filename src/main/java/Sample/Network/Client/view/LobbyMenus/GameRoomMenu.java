package Sample.Network.Client.view.LobbyMenus;

import Sample.Network.Client.controller.UserAndGameControllers.LobbyController;
import Sample.Network.Client.controller.UserAndGameControllers.MainController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import Sample.Network.Client.model.Lobby.LobbyManager;
import Sample.Network.Client.model.Lobby.LobbyStatus;
import Sample.Network.Client.model.User.User;
import Sample.Network.Client.view.Main;
import Sample.Network.Client.view.UserAndGameMenus.ProfileMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class GameRoomMenu extends Application implements Initializable {
    private static LobbyController lobbyController;
    public TableView<GameRoomTable> lobbyTable;
    public TableColumn<GameRoomTable, Circle> avatarColumn;
    public TableColumn<GameRoomTable, String> nameColumn;
    public TableColumn<GameRoomTable, Circle> colorColumn;
    public Button refreshButton;
    public Button newGameButton;
    public CheckBox modifiabilityCheck;
    public Button privacyButton;
    public Button chatButton;
    private boolean editable = false;

    private final ObservableList<GameRoomTable> players = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane rootPane = FXMLLoader.load(LobbyMenu.class.getResource("/FXML/Gamefxml/Lobbyfxml/gameRoom.fxml"));
        stage.setScene(new Scene(rootPane));
        stage.setFullScreen(true);
        rootPane.setBackground(new Background(new BackgroundImage(new Image(
                ProfileMenu.class.getResource("/assets/backgrounds/lobbyBackGround.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false))));

    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        avatarColumn.setCellValueFactory(new PropertyValueFactory<>("avatar"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        refreshButton.setOnMouseClicked(e -> {
            try {
                updateTable();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            newGameButton.setDisable(lobbyController.getPlayersCount() <= 1);
        });
        if (!lobbyController.isAdmin(MainController.getCurrentUser())) {
            modifiabilityCheck.setDisable(true);
            privacyButton.setVisible(false);
        }
        newGameButton.setDisable(lobbyController.getPlayersCount() <= 1);
        try {
            updateTable();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        privacyButton.setOnMouseClicked(e -> {
            if (lobbyController.getLobbyStatus() == LobbyStatus.PRIVATE)
                setGameRoomMode(LobbyStatus.PUBLIC);
            else if (lobbyController.getLobbyStatus() == LobbyStatus.PUBLIC)
                setGameRoomMode(LobbyStatus.PRIVATE);
            privacyButton.setText(lobbyController.getLobbyStatus().toString());
        });

        modifiabilityCheck.selectedProperty().addListener((observable, oldValue, newValue) -> editable = newValue);
    }

    private void setGameRoomMode(LobbyStatus lobbyStatus) {
        lobbyController.setStatus(lobbyStatus);
    }

    private void updateTable() throws Exception {
        players.clear();
        lobbyController.updateGameRoom();
        if (!lobbyController.isLobbyExist()) exitFromRoom();
        else {
            for (User player : lobbyController.getPlayers()) {
                players.add(new GameRoomTable(player, lobbyController.isAdmin(player), lobbyController.getColor(player).toString()));
            }
            lobbyTable.setItems(players);
        }
    }

    public static void setLobbyController(LobbyController lobbyController) {
        GameRoomMenu.lobbyController = lobbyController;
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        exitFromRoom();
    }

    private void exitFromRoom() throws Exception {
        lobbyController.removePlayer(MainController.getCurrentUser());
        if (lobbyController.getPlayersCount() == 0 && lobbyController.isLobbyExist())
            LobbyManager.deleteLobby(lobbyController.getGameId());
        else if (lobbyController.isAdmin(MainController.getCurrentUser()))
            lobbyController.setAdmin(lobbyController.getRandomPlayerForAdmin());
        newGameButton.setDisable(lobbyController.getPlayersCount() <= 1);
        new LobbyMenu().start(Main.mainStage);
    }

    public void goToChat() throws Exception {
        lobbyController.goToChat();
    }
}
