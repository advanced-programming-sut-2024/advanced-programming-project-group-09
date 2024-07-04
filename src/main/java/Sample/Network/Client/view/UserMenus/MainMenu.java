package Sample.Network.Client.view.UserMenus;

import Sample.Network.Client.controller.ChatControllers.ChatController;
import Sample.Network.Client.controller.UserControllers.MainController;
import Sample.Network.Client.controller.UserControllers.ProfileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Sample.Network.Client.model.Television.Television;
import Sample.Network.Client.model.Television.TelevisionManager;
import Sample.Network.Client.model.User.UserManager;
import Sample.Network.Client.Connection;
import Sample.Network.Client.Request;
import Sample.Network.Client.view.ChatMenus.MainChatMenu;
import Sample.Network.Client.view.ChatMenus.MainChatMenuController;
import Sample.Network.Client.view.LobbyMenus.LobbyMenu;
import Sample.Network.Client.view.Main;

public class MainMenu extends Application {
    public static MainController mainController;
    public ImageView newGameButton, profileMenuButton, aboutButton, logoutButton;
    public ImageView chatroomButton;
    public ImageView FriendMenuButton;
    public ImageView ScoreBoardMenuButton;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Stronghold");
        AnchorPane anchorPane = FXMLLoader.load(MainMenu.class.getResource("/FXML/Userfxml/mainMenu.fxml"));
        anchorPane.setBackground(new Background(new BackgroundImage(new Image(
                MainMenu.class.getResource("/assets/backgrounds/mainMenu.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false))));
        Scene scene = new Scene(anchorPane);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }


    public static void setMainController(MainController mainController) {
        MainMenu.mainController = mainController;
    }

    public void goToLobbyMenu() throws Exception {
        new LobbyMenu().start(Main.mainStage);
    }

    public void goToProfileMenu() throws Exception {
        ProfileMenu.setProfileController(new ProfileController(MainController.currentUser));
        new ProfileMenu().start(Main.mainStage);
    }

    public void logout() throws Exception {
        UserManager.setLoggedInUser(null);
        Request request = new Request();
        request.setType("connect");
        request.setCommand("logout");
        request.addParameter("username", MainController.currentUser.getUsername());
        Connection.getInstance().sendRequest(request);
        new LoginMenu().start(Main.mainStage);
    }

    public void goToChatroom() throws Exception {
        ChatController chatController = new ChatController(MainController.currentUser);
        MainChatMenu chatMenu = new MainChatMenu();
        MainChatMenuController.setController(chatController);
        MainChatMenuController.currentChatMenu = chatMenu;
        chatMenu.start(Main.mainStage);
    }

    public void goToScoreBoard() throws Exception {
        ScoreBoardMenu scoreBoardMenu = new ScoreBoardMenu();
        scoreBoardMenu.start(Main.mainStage);
    }

    public void goToTelevision() throws Exception {
        if (TelevisionManager.load("test", "1.save") == null) return;
        new Television().start(Main.mainStage);
    }
}
