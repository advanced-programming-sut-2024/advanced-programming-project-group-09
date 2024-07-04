package Sample.Network.Server.database;

import Sample.Network.Server.model.Lobby;
import Sample.Network.Server.model.ServerUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Database {
    private static Database instance = null;
    private final HashMap<String, ServerUser> users = new HashMap<>();
    private final ArrayList<ServerUser> userRankings = new ArrayList<>();
    private final HashMap<String, Lobby> lobbies = new HashMap<>();

    private Database() {
    }

    public static void load() {
        if (instance == null) {
            instance = new Database();
            UserManager.load(instance);
        }
    }

    public static Database getInstance() {
        return instance;
    }

    public void updateData() {
        UserManager.updateAllUsers(users.values());
    }

    public ServerUser getUser(String username) {
        if (username == null) return null;
        if (!users.containsKey(username)) return null;
        return users.get(username);
    }

    public void addUser(ServerUser user) {
        users.put(user.getUsername(), user);
        userRankings.add(user);
        updateData();
    }

    public void updateRankings() {
        userRankings.sort((o1, o2) -> Double.compare(o2.getMaxScore(), o1.getMaxScore()));
    }

    public int getUserRank(String username) {
        for (int i = 0; i < userRankings.size(); i++) {
            if (userRankings.get(i).getUsername().equals(username)) return i + 1;
        }
        return 0;
    }

    public boolean emailExists(String email) {
        for (ServerUser user : users.values()) {
            if (user.getEmail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public Collection<ServerUser> getUsers() {
        return users.values();
    }

    public Collection<ServerUser> getOnlineUsers() {
        ArrayList<ServerUser> onlineUsers = new ArrayList<>();
        for (ServerUser user : users.values())
            if (user.isOnline())
                onlineUsers.add(user);
        return onlineUsers;
    }

    public ArrayList<ServerUser> getUserRankings() {
        return userRankings;
    }

    public void addLobby(Lobby lobby) {
        lobbies.put(lobby.getId(), lobby);
        lobby.updateExpireTime();
    }

    public Lobby getLobby(String id) {
        return lobbies.get(id);
    }

    public Collection<Lobby> getAllLobbies() {
        return lobbies.values();
    }

    public void removeLobby(String id) {
        lobbies.remove(id);
    }
}
