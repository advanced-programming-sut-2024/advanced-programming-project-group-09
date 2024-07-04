package Sample.Network.Server.model.chatRoom;

import java.util.ArrayList;

public class Chat {
    public enum ChatMode{
        GLOBAL, PRIVATE, ROOM
    }
    private final String chatId;
    private final ArrayList<String> users;
    private final ArrayList<Message> messages;
    private final ChatMode chatMode;
    private final String owner;
    public Chat(ArrayList<String> users, ChatMode chatMode, String id, String owner){
        this.users = users;
        this.chatMode = chatMode;
        messages = new ArrayList<>();
        chatId = chatMode.name().toLowerCase() + id;
        this.owner = owner;
    }

    public Chat(ArrayList<String> users){
        this.users = users;
        this.chatMode = ChatMode.GLOBAL;
        messages = new ArrayList<>();
        chatId = chatMode.name().toLowerCase() + "Chat";
        this.owner = "";
    }

    public void addMessage(Message msg){
     messages.add(msg);
    }

    public String getChatId() {
        return chatId;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ChatMode getChatMode() {
        return chatMode;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public String getOwner() {
        return owner;
    }
}
