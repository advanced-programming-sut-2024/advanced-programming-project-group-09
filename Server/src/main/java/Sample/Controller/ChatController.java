package Sample.Controller;

import Sample.ChatNetworkHandler;
import Sample.Model.Chat;
import Sample.Model.Message;
import Sample.Model.User;
import Sample.database.ChatManager;





public class ChatController {
    private ChatNetworkHandler networkHandler;
    private Chat currentChat;

    public ChatController() {
        this.networkHandler = new ChatNetworkHandler();
    }

    public void setCurrentChat(Chat chat) {
        this.currentChat = chat;
    }

    public Chat getCurrentChat() {
        return currentChat;
    }

    public void sendMessage(String text) {
        Message message = new Message(getCurrentUsername(), text, System.currentTimeMillis());
        networkHandler.sendMessage(currentChat.getChatId(), message);
    }

    public void receiveChatUpdate() {
        Chat chat = networkHandler.receiveChatUpdate();
        if (chat != null) {
            ChatManager.updateChat(chat);
        }
    }

    public void close() {
        networkHandler.closeConnection();
    }

    public String getCurrentUsername() {
        return User.getUserLoginIn().getUsername();
    }
}
