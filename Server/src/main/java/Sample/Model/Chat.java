package Sample.Model;

import java.util.ArrayList;

public class Chat {
    private final String chatId;
    private final ArrayList<String> users;
    private final ArrayList<Message> messages;
    private final String owner;

    public Chat(String chatId, ArrayList<String> users, String owner) {
        this.chatId = chatId;
        this.users = users;
        this.messages = new ArrayList<>();
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
