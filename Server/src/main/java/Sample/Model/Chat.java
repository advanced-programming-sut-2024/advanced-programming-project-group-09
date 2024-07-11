package Sample.Model;

import java.util.ArrayList;

public class Chat {
    private final String chatId;
    private final ArrayList<String> users;
    private final ArrayList<Message> messages;
    private final String owner;

    public Chat(String id, ArrayList<String> users, String owner) {
        this.users = users;
        this.messages = new ArrayList<>();
        this.chatId = "chat_" + id;
        this.owner = owner;
    }

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    public String getChatId() {
        return chatId;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public String getOwner() {
        return owner;
    }
}
