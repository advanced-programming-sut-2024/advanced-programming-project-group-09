package Sample.Controller;

import Sample.Model.Chat;
import Sample.Model.Message;
import Sample.database.ChatManager;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatMenuController {
    @FXML
    private TextField text;
    @FXML
    private ImageView sendButton;
    @FXML
    private VBox chatPane;
    @FXML
    private ScrollPane chatPaneScroll;
    @FXML
    private HBox emojiBox;

    private ChatController controller;
    private Stage stage;

    public void initialize() {
        controller = new ChatController();
        Chat globalChat = ChatManager.loadChat("global");
        controller.setCurrentChat(globalChat);
        loadChat(globalChat);
        sendWithEnterHandler();
    }

    private void sendWithEnterHandler() {
        if (stage != null && stage.getScene() != null) {
            stage.getScene().setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    try {
                        processSendMessage();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    @FXML
    public void handleSend() {
        try {
            processSendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processSendMessage() throws IOException {
        String content = text.getText();
        text.clear();
        long timestamp = System.currentTimeMillis();
        Message msg = new Message(controller.getCurrentUsername(), content, timestamp);
        sendMessage(msg);
        controller.sendMessage(content);
    }

    public void processReceiveMessage(Message msg) {
        receiveMessage(msg);
        controller.receiveChatUpdate();
    }

    public void loadChat(Chat chat) {
        controller.setCurrentChat(chat);
        chatPane.getChildren().clear();
        if (chat != null) {
            for (Message msg : chat.getMessages()) {
                addMessage(msg);
            }
        }
    }

    public void addMessage(Message msg) {
        if (msg.getSenderUsername().equals(controller.getCurrentUsername())) {
            sendMessage(msg);
        } else {
            receiveMessage(msg);
        }
    }

    public void sendMessage(Message msg) {
        AnchorPane anchorPane = new AnchorPane();
        processMessageBox(msg, anchorPane);
        chatPane.getChildren().add(anchorPane);
    }

    public void receiveMessage(Message msg) {
        AnchorPane anchorPane = new AnchorPane();
        processMessageBox(msg, anchorPane);
        chatPane.getChildren().add(anchorPane);
    }

    private void processMessageBox(Message msg, AnchorPane anchorPane) {
        Label messageLabel = new Label(msg.getText());
        Label timeLabel = new Label(msg.getFormattedTime());

        messageLabel.setWrapText(true);
        messageLabel.setStyle("-fx-background-color: lightgray; -fx-padding: 10px; -fx-background-radius: 5px;");
        timeLabel.setStyle("-fx-text-fill: gray;");

        VBox messageBox = new VBox(messageLabel, timeLabel);
        messageBox.setAlignment(Pos.CENTER_RIGHT);

        anchorPane.getChildren().add(messageBox);
    }

    public void addEmoji(String emoji) {
        text.setText(text.getText() + emoji);
    }

    public void initializeEmojis() {
        // Add emojis to the emoji box
        String[] emojis = {"😀", "😂", "😍", "😎", "😢"};
        for (String emoji : emojis) {
            Label emojiLabel = new Label(emoji);
            emojiLabel.setStyle("-fx-font-size: 24px;");
            emojiLabel.setOnMouseClicked(event -> addEmoji(emoji));
            emojiBox.getChildren().add(emojiLabel);
        }
    }
}
