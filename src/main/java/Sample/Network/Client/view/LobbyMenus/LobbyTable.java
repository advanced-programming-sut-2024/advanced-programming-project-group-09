package Sample.Network.Client.view.LobbyMenus;

import Sample.Network.Client.controller.GameControllers.LobbyController;
import Sample.Network.Client.controller.UserControllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import Sample.Network.Client.model.Lobby.Lobby;
import Sample.Network.Client.model.Lobby.LobbyManager;
import Sample.Network.Client.model.Lobby.LobbyStatus;
import Sample.Network.Client.model.Television.Television;
import Sample.Network.Client.view.Main;

import java.io.IOException;

public class LobbyTable {
    private final String gameId;
    private final String admin;
    private final String capacity;
    private final Button television = new Button("Live");
    private final Circle avatar = new Circle();
    private final Button join = new Button("join");

    public LobbyTable(Lobby gameRoom) {
        avatar.setFill(new ImagePattern(new Image(gameRoom.getAdmin().getAvatarPath())));
        avatar.setRadius(25);

        gameId = gameRoom.getId();
        admin = gameRoom.getAdmin().getNickname();
        capacity = Integer.valueOf(gameRoom.getPlayersCount()).toString() + "/" +
                Integer.valueOf(gameRoom.getCapacity()).toString();
        join.setOnMouseClicked(e -> {
            try {
                goToGameRoom(gameId);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        television.setOnMousePressed(e -> {
            Television.setGameId(gameId);
            Television.setLive(true);
            try {
                new Television().start(Main.mainStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void goToGameRoom(String gameId) throws Exception {
        Lobby lobby = LobbyManager.getLobby(gameId);
        if (lobby == null || lobby.getCapacity() == lobby.getPlayersCount() || lobby.getLobbyStatus().equals(LobbyStatus.RUNNING)) {
            loadPopUp();
        } else {
            Sample.Network.Client.model.User.Color color = pickColor(lobby);
            lobby.addPlayer(MainController.getCurrentUser(), color);
            GameRoomMenu.setLobbyController(new LobbyController(lobby));
            new GameRoomMenu().start(Main.mainStage);
        }
    }

    public static Sample.Network.Client.model.User.Color pickColor(Lobby lobby) {
        Sample.Network.Client.model.User.Color chosenColor = null;
        for (Sample.Network.Client.model.User.Color color : Sample.Network.Client.model.User.Color.values()) {
            if (!lobby.isColorPicked(color)) return color;
        }
        return null;
    }

    public static void loadPopUp() throws IOException {
        Popup popup = new Popup();
        AnchorPane pane = FXMLLoader.load(LobbyTable.class.getResource("/FXML/Gamefxml/Lobbyfxml/JoiningErrorPopUp.fxml"));
        popup.setAutoHide(true);
        popup.getContent().add(pane);
        popup.setAnchorX(525);
        popup.setAnchorY(250);
        popup.show(Main.mainStage);
    }

    public String getGameId() {
        return gameId;
    }

    public String getAdmin() {
        return admin;
    }

    public String getCapacity() {
        return capacity;
    }

    public Button getTelevision() {
        return television;
    }

    public Button getJoin() {
        return join;
    }

    public Circle getAvatar() {
        return avatar;
    }
}
