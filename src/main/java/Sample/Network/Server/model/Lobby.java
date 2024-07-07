package Sample.Network.Server.model;

import Sample.Network.Client.model.User.User;
import Sample.Network.Server.database.Database;

import java.util.*;

public class Lobby {
    private LobbyStatus lobbyStatus;
    private int capacity;
    private String id;
    private User admin;
    private final HashMap<String, Color> players = new HashMap<>();
    private transient Timer expireTimer;

    public Lobby(String id, User admin, int capacity) {
        this.id = id;
        this.admin = admin;
        this.capacity = capacity;
        this.lobbyStatus = LobbyStatus.PUBLIC; // Assuming default status as PUBLIC
    }

    public boolean isColorPicked(Color color) {
        return players.containsValue(color);
    }

    public void addPlayer(User player, Color color) {
        players.put(player.getUsername(), color);
        updateExpireTime();
    }

    public void removePlayer(User player) {
        players.remove(player.getUsername());
        updateExpireTime();
    }

    public void setAdmin(User admin) {
        this.admin = admin;
        updateExpireTime();
    }

    public void setLobbyStatus(LobbyStatus lobbyStatus) {
        this.lobbyStatus = lobbyStatus;
        updateExpireTime();
    }

    public void updateExpireTime() {
        if (expireTimer != null)
            expireTimer.cancel();
        if (lobbyStatus == LobbyStatus.RUNNING)
            return;
        expireTimer = new Timer(true);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Database.getInstance().removeLobby(id);
                System.out.println("Removed lobby:" + id);
            }
        };
        expireTimer.schedule(timerTask, 60000);
    }

    public String getId() {
        return id;
    }

    public User getAdmin() {
        return admin;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public Set<User> getPlayers() {
        Set<User> users = new HashSet<>();
        for (String username : players.keySet()) {
            User user = User.getUserByUsername(username);
            if (user != null) {
                users.add(user);
            }
        }
        return users;
    }

    public LobbyStatus getLobbyStatus() {
        return lobbyStatus;
    }
}
