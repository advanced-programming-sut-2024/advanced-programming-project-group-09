package Sample.Controller;

import Sample.Client;
import Sample.Model.User;
import Sample.View.FriendMenu;
import Sample.View.LoginMenu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;

public class FriendsController {

    public TextField searchField;
    public VBox friendsListVbox;
    Timeline timeline;

    public ArrayList<Button> friends = new ArrayList<>();

    public void createTimeLineForUpdateUsers() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(15), event -> {
            updateLastMessageFromServer();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateLastMessageFromServer() {
        String cmd = new Client().tryToConnectToServer("updateLastFriendReqFromServer");
        if (cmd.equals("")) return;
        else {
            String[] commands = cmd.split("~");
            String originUsername = commands[2];
            User originUser = User.getUserByUsername(originUsername);
            if (originUser == null) {
                showWarningAlert("wrong name", "", "no such user with specified username send you friend req");
                return;
            }
            Alert alert = showConfirmationAlert("Friend Req", "confirm freind req", "you have friend req from" + originUser.getUsername() + "\naccept or deny?");
            if (alert.getResult().equals(ButtonType.OK)) {
                originUser.addFriend(User.getUserLoginIn());
                updateFriendsList();
            }
        }
    }

    private void updateFriendsList() {
        User currentUser = User.getUserLoginIn();
        friends.clear();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (User friend : currentUser.getFriends()) {
            Button friendButton = new Button(friend.getUsername() + "\ncalled: " + friend.getNickname());
            friends.add(friendButton);
        }
        friends.add(new Button("friend for test: mmd"));

    }

    public void searchForFriendRequest(MouseEvent mouseEvent) {
        NetworkController.updateUsersFromServer();
        User destinationUSer = User.getUserByUsername(searchField.getText());
        if (destinationUSer == null) {
            showWarningAlert("wrong name", "", "no such user with specified username");
            return;
        }
        Alert alert = showConfirmationAlert("confirmation", "send req", "Are you sure to send friend req?");
        if (alert.getResult().equals(ButtonType.OK)) {
            sendFriendRequest(searchField.getText());
            showWarningAlert("friend req", "done", "friend req sent successfully!");
        }


    }

    private Alert showConfirmationAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
        return alert;
    }

    private void sendFriendRequest(String username) {
        Client.getInstance().tryToConnectToServer("sendFriendReq~" + username + "~" + User.getUserLoginIn().getUsername());

    }

    private void showWarningAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void showFriendsList(MouseEvent mouseEvent) {
        updateFriendsList();
        for (Button friendButton : friends) {
            friendsListVbox.getChildren().add(friendButton);
        }
    }

    public void back(MouseEvent mouseEvent) throws Exception {
        FriendMenu friendmenu = new FriendMenu();
        friendmenu.start(ApplicationController.getStage());
    }
}
