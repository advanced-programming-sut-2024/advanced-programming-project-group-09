package Sample.Controller;

import Sample.Client;
import Sample.Model.User;
import Sample.View.ChatMenu;
import Sample.View.ProfileMenu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

public class FriendsController {

    public TextField searchField;
    public VBox friendsListVbox;
    Timeline timeline = null;

    public ArrayList<Button> friends = new ArrayList<>();
    private static FriendsController instance;

    public static FriendsController getInstance() {
        if (instance == null) instance = new FriendsController();
        return instance;
    }

    public void createTimeLineForUpdateUsers() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            updateLastMessageFromServer();
            System.out.println("updater");
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateLastMessageFromServer() {
        String cmd = new Client().tryToConnectToServer("updateLastFriendReqFromServerForMe~" + User.getUserLoginIn().getUsername());
        String[] commands = cmd.split("~");
        for (String string : commands) {
            System.out.println("commandsssss: " + string);
        }
        if (commands[0] == null || commands[0].equals("No new Friend Req!")) return;
        else {
            String originUsername = commands[0];
            User originUser = User.getUserByUsername(originUsername);
            if (originUser == null) {
                showWarningAlert("wrong name", "", "no such user with specified username send you friend req");
                return;
            }
            Platform.runLater(() -> {
                Alert alert = showConfirmationAlert("Friend Req", "confirm freind req", "you have friend req from '" + originUser.getUsername() + "'\naccept or deny?");
                if (alert.getResult().equals(ButtonType.OK) || !alert.getResult().getButtonData().isCancelButton()) {
                    Objects.requireNonNull(User.getUserByUsername(User.getUserLoginIn().getUsername())).addFriend(originUser);
                    Objects.requireNonNull(User.getUserByUsername(originUsername)).addFriend(User.getUserByUsername(User.getUserLoginIn().getUsername()));
                    System.out.println();
                }
            });
            System.out.println("alert showed");
        }
    }

    private void updateFriendsList() {
        User currentUser = User.getUserByUsername(User.getUserLoginIn().getUsername());
//        friends.clear();

        for (User friend : currentUser.getFriends()) {
            Button friendButton = new Button(friend.getUsername() + "\ncalled: " + friend.getNickname());
            boolean isDuplicated = false;
            for (Button button : friends) {
                if (button.getText().equals(friendButton.getText())) isDuplicated = true;
            }
            if (isDuplicated) continue;
            friends.add(friendButton);
            System.out.println("current user friends:" + friend);
        }
//        friends.add(new Button("friend for test: mmd"));

    }

    public void searchForFriendRequest(MouseEvent mouseEvent) {
        NetworkController.updateUsersFromServer();
        User destinationUSer = User.getUserByUsername(searchField.getText());
        if (destinationUSer == null) {
            showWarningAlert("wrong name", "", "no such user with specified username");
            return;
        }
        Platform.runLater(() -> {


            Alert alert = showConfirmationAlert("confirmation", "send req", "Are you sure to send friend req?");
            if (alert.getResult().equals(ButtonType.OK)) {
                sendFriendRequest(searchField.getText());
                showWarningAlert("friend req", "done", "friend req sent successfully!");
            }
        });
//        sendFriendRequest(searchField.getText());
//        showWarningAlert("friend req", "done", "friend req sent successfully!");


    }

    private Alert showConfirmationAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();

//        PauseTransition pauseTransition = new PauseTransition(Duration.millis(5000));
//        pauseTransition.setOnFinished(event -> {
//
//        });
        return alert;
    }

    private void sendFriendRequest(String username) {
        new Client().tryToConnectToServer("sendFriendReq~" + username + "~" + User.getUserLoginIn().getUsername());
        System.out.println("req send");
    }

    private void showWarningAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void showFriendsList(MouseEvent mouseEvent) {
//        if (timeline == null) createTimeLineForUpdateUsers();
        updateFriendsList();
        System.out.println("friends vbox : " + friends.size());
        System.out.println("current user friends vbox : " + User.getUserByUsername(User.getUserLoginIn().getUsername()).getFriends().size());
        ArrayList<Node> nodes = new ArrayList<>(friendsListVbox.getChildren());
        for (Node child : friendsListVbox.getChildren()) {
            if (child instanceof Label) continue;
            if (child instanceof Button) {
                Button button = (Button) child;
                if (button.getText().startsWith("show friends")) continue;
                nodes.remove(child);
            }
        }
        friendsListVbox.getChildren().clear();
        friendsListVbox.getChildren().addAll(nodes);
        for (Button friendButton : friends) {
            friendsListVbox.getChildren().add(friendButton);
            friendButton.setOnMouseClicked(mouseEvent1 -> {
                new ChatMenuController(User.getUserByUsername(User.getUserLoginIn().getUsername())).createTimeLineForUpdateUsers();
                ChatMenu chatMenu = new ChatMenu();
                try {
                    chatMenu.start(ApplicationController.getStage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            });
        }
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        if (timeline != null) {
            timeline.stop();
            timeline = null;
        }
        ProfileMenu profilemenu = new ProfileMenu();
        profilemenu.start(ApplicationController.getStage());
    }
}
