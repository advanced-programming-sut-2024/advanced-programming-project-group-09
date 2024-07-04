package Sample.Network.Server.model.chatRoom;

import java.util.ArrayList;
import java.util.HashMap;

public class Message {
    public enum Reaction {
        LIKE, DISLIKE, HEART, FIRE
    }

    private final String senderUsername;
    private String text;
    private final int hour;
    private final int minute;
    private boolean seenStatus = false;
    private final ArrayList<String> invisibleFor;
    private final HashMap<String, Reaction> reactions;

    public Message(String senderUsername, String text, int hour, int minute) {
        this.senderUsername = senderUsername;
        this.text = text;
        this.hour = hour;
        this.minute = minute;
        reactions = new HashMap<>();
        invisibleFor = new ArrayList<>();
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getText() {
        return text;
    }

    public void setSeenStatus(boolean seenStatus) {
        this.seenStatus = seenStatus;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addReaction(String username, Reaction reaction) {
        reactions.put(username, reaction);
    }
}
