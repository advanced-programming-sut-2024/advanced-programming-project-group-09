package Sample.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Message {
    public enum Reaction {
        LIKE, DISLIKE, HEART, FIRE
    }

    private final String senderUsername;
    private String text;
    private final long timestamp;
    private boolean seenStatus = false;
    private final ArrayList<String> invisibleFor;
    private final HashMap<String, Reaction> reactions;

    public Message(String senderUsername, String text, long timestamp) {
        this.senderUsername = senderUsername;
        this.text = text;
        this.timestamp = timestamp;
        this.reactions = new HashMap<>();
        this.invisibleFor = new ArrayList<>();
    }

    public long getTimestamp() {
        return timestamp;
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

    public boolean isSeenStatus() {
        return seenStatus;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addReaction(String username, Reaction reaction) {
        reactions.put(username, reaction);
    }

    public HashMap<String, Reaction> getReactions() {
        return reactions;
    }

    public boolean isVisibleForUser(String username) {
        return !invisibleFor.contains(username);
    }

    public void addInvisibleFor(String username) {
        invisibleFor.add(username);
    }

    public ArrayList<String> getInvisibleFor() {
        return invisibleFor;
    }

    public int getHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        return calendar.get(Calendar.MINUTE);
    }

    public String getFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(timestamp);
    }
}