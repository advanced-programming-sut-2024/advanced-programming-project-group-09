package Sample.database;

import Sample.Model.User;
//import model.Lobby;
//import model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Database {
    private static Database instance = null;
    private final HashMap<String, User> users = new HashMap<>();
    private final ArrayList<User> userRankings = new ArrayList<>();
//    private final HashMap<String, Lobby> lobbies = new HashMap<>();

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

    public User getUser(String username) {
        if (username == null) return null;
        if (!users.containsKey(username)) return null;
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
        userRankings.add(user);
        updateData();
    }

    public void updateRankings() {
//        userRankings.sort((o1, o2) -> o2.getHighScore() - o1.getHighScore());
    }

    public int getUserRank(String username) {
        for (int i = 0; i < userRankings.size(); i++) {
            if (userRankings.get(i).getUsername().equals(username)) return i + 1;
        }
        return 0;
    }

    public boolean emailExists(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public Collection<User> getOnlineUsers() {
        ArrayList<User> onlineUsers = new ArrayList<>();
        for (User user : users.values())
            if (user.isOnline())
                onlineUsers.add(user);
        return onlineUsers;
    }

    public ArrayList<User> getUserRankings() {
        return userRankings;
    }
//
//    public void addLobby(Lobby lobby) {
//        lobbies.put(lobby.getId(), lobby);
//        lobby.updateExpireTime();
//    }
//
//    public Lobby getLobby(String id) {
//        return lobbies.get(id);
//    }
//
//    public Collection<Lobby> getAllLobbies() {
//        return lobbies.values();
//    }
//
//    public void removeLobby(String id) {
//        lobbies.remove(id);
//    }
}
