package Sample.Network.Client.controller.ChatControllers;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Sample.Network.Client.model.chatRoom.Chat;
import Sample.Network.Client.model.chatRoom.ChatManager;
import Sample.Network.Client.model.chatRoom.Message;
import Sample.Network.Client.view.ChatMenus.MainChatMenuController;
import Sample.Network.Client.view.UserAndGameMenus.LoginMenu;
import Sample.Network.Client.view.UserAndGameMenus.MainMenu;

import java.net.URL;
import java.util.HashMap;

public class ReactionManager {
    public static void setReactions(Message msg, AnchorPane anchorPane) {
        int likeCount = 0, heartCount = 0, dislikeCount = 0, fireCount = 0;
        HashMap<String, Message.Reaction> reactions = msg.getReactions();
        for (String person : reactions.keySet()) {
            switch (reactions.get(person)) {
                case FIRE:
                    fireCount++;
                    break;
                case LIKE:
                    likeCount++;
                    break;
                case HEART:
                    heartCount++;
                    break;
                case DISLIKE:
                    dislikeCount++;
                    break;
            }
        }
        ((Label) anchorPane.getChildren().get(8)).setText(Integer.toString(dislikeCount));
        ((Label) anchorPane.getChildren().get(9)).setText(Integer.toString(fireCount));
        ((Label) anchorPane.getChildren().get(10)).setText(Integer.toString(heartCount));
        ((Label) anchorPane.getChildren().get(11)).setText(Integer.toString(likeCount));
    }

    public static void setSeenStatus(Message msg, AnchorPane anchorPane){
        if (msg.isSeenStatus()){
            URL url = LoginMenu.class.getResource("/assets/icons/seen_icn.png");
            ((ImageView) anchorPane.getChildren().get(15)).setImage(new Image(url.toExternalForm()));
        } else if (!msg.getSenderUsername().equals(MainMenu.mainController.currentUser.getUsername())) {
            msg.setSeenStatus(true);
            ChatManager.updateChat(MainChatMenuController.getController().getCurrentChat());
        }
    }

    public static void setUserName(Message msg, AnchorPane anchorPane){
        ((Label) anchorPane.getChildren().get(16)).setText(msg.getSenderUsername());
    }

    public static void setReactionHandling(Message msg, AnchorPane anchorPane) {
        (anchorPane.getChildren().get(8)).setOnMouseClicked(e -> dislike(anchorPane, msg));
        (anchorPane.getChildren().get(9)).setOnMouseClicked(e -> fire(anchorPane, msg));
        (anchorPane.getChildren().get(10)).setOnMouseClicked(e -> heart(anchorPane, msg));
        (anchorPane.getChildren().get(11)).setOnMouseClicked(e -> like(anchorPane, msg));
    }

    public static void like(AnchorPane anchorPane, Message msg) {
        String username = MainMenu.mainController.currentUser.getUsername();
        if (userNotReacted(username, msg)) {
            String text = ((Label) anchorPane.getChildren().get(11)).getText();
            int num = Integer.parseInt(text);
            num++;
            ((Label) anchorPane.getChildren().get(11)).setText(Integer.toString(num));
            msg.addReaction(username, Message.Reaction.LIKE);
            ChatManager.updateChat(MainChatMenuController.getController().getCurrentChat());
        }
    }

    public static void dislike(AnchorPane anchorPane, Message msg) {
        String username = MainMenu.mainController.currentUser.getUsername();
        if (userNotReacted(username, msg)) {
            String text = ((Label) anchorPane.getChildren().get(8)).getText();
            int num = Integer.parseInt(text);
            num++;
            ((Label) anchorPane.getChildren().get(8)).setText(Integer.toString(num));
            msg.addReaction(MainMenu.mainController.currentUser.getUsername(), Message.Reaction.DISLIKE);
            ChatManager.updateChat(MainChatMenuController.getController().getCurrentChat());
        }
    }

    public static void heart(AnchorPane anchorPane, Message msg) {
        String username = MainMenu.currentUser.getUsername();
        if (userNotReacted(username, msg)) {
            String text = ((Label) anchorPane.getChildren().get(10)).getText();
            int num = Integer.parseInt(text);
            num++;
            ((Label) anchorPane.getChildren().get(10)).setText(Integer.toString(num));
            msg.addReaction(MainMenu.mainController.currentUser.getUsername(), Message.Reaction.HEART);
            ChatManager.updateChat(MainChatMenuController.getController().getCurrentChat());
        }
    }

    public static void fire(AnchorPane anchorPane, Message msg) {
        String username = MainMenu.mainController.currentUser.getUsername();
        if (userNotReacted(username, msg)) {
            String text = ((Label) anchorPane.getChildren().get(9)).getText();
            int num = Integer.parseInt(text);
            num++;
            ((Label) anchorPane.getChildren().get(9)).setText(Integer.toString(num));
            msg.addReaction(MainMenu.mainController.currentUser.getUsername(), Message.Reaction.FIRE);
            ChatManager.updateChat(MainChatMenuController.getController().getCurrentChat());
        }
    }

    public static boolean userNotReacted(String username, Message msg) {
        return !msg.getReactions().containsKey(username);
    }

    public static void setEdit(AnchorPane anchorPane, Message msg){
        (anchorPane.getChildren().get(12)).setOnMouseClicked(e -> Platform.runLater(() -> ChatController.currentMenu.showEditingContent(msg)));
    }
    public static void setDelete(AnchorPane anchorPane, Message msg){
        (anchorPane.getChildren().get(13)).setOnMouseClicked(e -> {
            msg.setInvisibleFor(MainMenu.mainController.currentUser.getUsername());
            anchorPane.setManaged(false);
            anchorPane.setVisible(false);
            ChatManager.updateChat(MainChatMenuController.getController().getCurrentChat());
        });
    }

    public static void setTwoWayDelete(AnchorPane anchorPane, Message msg, Chat chat){
        (anchorPane.getChildren().get(14)).setOnMouseClicked(e -> {
            chat.getMessages().remove(msg);
            anchorPane.setVisible(false);
            anchorPane.setManaged(false);
            ChatManager.updateChat(MainChatMenuController.getController().getCurrentChat());
        });
    }
}
