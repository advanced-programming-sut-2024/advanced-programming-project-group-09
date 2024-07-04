package Sample.Network.Server.model;

import Sample.Network.Server.database.Database;
import Sample.Network.Server.utils.Pair;

import java.net.Socket;
import java.util.HashMap;

@SuppressWarnings({"FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
public class ServerUser extends Sample.Model.User {
    private transient Socket socket;

    public ServerUser(String username, String password, String email, String nickname) {
        super(username, password, email, nickname);
    }

    public void updateLastOnline() {
        super.updateLastOnline();
        Database.getInstance().updateData();
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isOnline() {
        return socket != null;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setMaxScore(double maxScore) {
        super.setMaxScore(maxScore);
        Database.getInstance().updateRankings();
        Database.getInstance().updateData();
    }

    public void setUsername(String username) {
        super.setUsername(username);
        Database.getInstance().updateData();
    }

    public void setPassword(String password) {
        super.setPassword(password);
        Database.getInstance().updateData();
    }

    public void setEmail(String email) {
        super.setEmail(email);
        Database.getInstance().updateData();
    }

    public void setNickname(String nickname) {
        super.setNickname(nickname);
        Database.getInstance().updateData();
    }

    public void setPasswordRecovery(Pair passwordRecovery) {
        HashMap<String, String> securityQuestionsAndAnswers = new HashMap<>();
        securityQuestionsAndAnswers.put(passwordRecovery.x, passwordRecovery.y);
        super.setSecurityQuestionsAndAnswers(securityQuestionsAndAnswers);
        Database.getInstance().updateData();
    }

    public void setAvatarPath(String avatarPath) {
        super.setAvatarPath(avatarPath);
        Database.getInstance().updateData();
    }

    public void addFriend(ServerUser serverUser) {
        super.addFriend(serverUser);
        Database.getInstance().updateData();
    }

    public void addSender(ServerUser serverUser) {
        super.addSender(serverUser);
        Database.getInstance().updateData();
    }

    public void removeFriend(ServerUser serverUser) {
        super.removeFriend(serverUser);
        Database.getInstance().updateData();
    }

    public void removeSender(ServerUser serverUser) {
        super.removeSender(serverUser);
        Database.getInstance().updateData();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nonlineStatus : " + (socket != null);
    }
}
