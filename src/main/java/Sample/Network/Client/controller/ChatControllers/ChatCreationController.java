package Sample.Network.Client.controller.ChatControllers;

import Sample.Network.Client.model.User.User;
import Sample.Network.Client.model.chatRoom.Chat;
import Sample.Network.Client.model.chatRoom.ChatManager;
import Sample.Network.Client.view.enums.messages.ChatMessage.ChatMessage;

import java.util.ArrayList;

public class ChatCreationController {
    private Chat.ChatMode mode;
    private final ArrayList<String> users;
    private final User currentUser;

    public ChatCreationController(User user){
        this.currentUser = user;
        this.users = new ArrayList<>();
    }

    public void setMode(Chat.ChatMode mode) {
        this.mode = mode;
    }

    public ChatMessage addUser(String username){
        if (User.getUserByUsername(username) == null) return ChatMessage.USER_NOT_FOUND;
        else if (mode == null) return ChatMessage.SELECT_MODE;
        else if (mode.equals(Chat.ChatMode.PRIVATE) && users.size() == 1) return ChatMessage.CHAT_PARTICIPANT_LIMIT;
        else {
            users.add(username);
            return ChatMessage.USER_ADDED_SUCCESSFULLY;
        }
    }

    public ChatMessage CreateChat(String chatID){
        if (mode == null) return ChatMessage.SELECT_MODE;
        else if (users.size() == 0) return ChatMessage.SELECT_PARTICIPANT;
        else if (chatID == null || chatID.equals("")) return ChatMessage.ENTER_CHAT_ID;
        else {
            users.add(currentUser.getUsername());
            Chat chat = new Chat(users, mode, chatID, currentUser.getUsername());
            ChatManager.updateChat(chat);
            return ChatMessage.CHAT_CREATED_SUCCESSFULLY;
        }
    }
}
