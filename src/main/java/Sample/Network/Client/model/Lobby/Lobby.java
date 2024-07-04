package Sample.Network.Client.model.Lobby;

import Sample.Network.Client.model.User.Color;
import Sample.Network.Client.Connection;
import Sample.Network.Client.Request;
import com.google.gson.Gson;
import Sample.Model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Lobby {
    private LobbyStatus lobbyStatus;
    private final int capacity;
    private final String id;
    private User admin;
    private final HashMap<String, Color> players = new HashMap<>();

    public Lobby(String id, User admin, Color color) {
        this.id = id;
        this.admin = admin;
        this.capacity = 4; // Set to default capacity, change as needed
        players.put(admin.getUsername(), color);
        this.lobbyStatus = LobbyStatus.PUBLIC;
    }

    public boolean isColorPicked(Color color) {
        return players.containsValue(color);
    }

    public void addPlayer(User player, Color color) {
        players.put(player.getUsername(), color);
        Request request = new Request();
        request.setType("lobby_change");
        request.setCommand("add_player");
        request.addParameter("id", String.valueOf(id));
        request.addParameter("player", new Gson().toJson(player));
        request.addParameter("color", String.valueOf(color.ordinal()));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Lobby doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removePlayer(User player) {
        players.remove(player.getUsername());
        Request request = new Request();
        request.setType("lobby_change");
        request.setCommand("remove_player");
        request.addParameter("id", id);
        request.addParameter("player", new Gson().toJson(player));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Lobby doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setAdmin(User admin) {
        this.admin = admin;
        Request request = new Request();
        request.setType("lobby_change");
        request.setCommand("set_admin");
        request.addParameter("id", id);
        request.addParameter("player", new Gson().toJson(admin));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Lobby doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setStatus(LobbyStatus lobbyStatus) {
        Request request = new Request();
        request.setType("lobby_change");
        request.setCommand("change_status");
        request.addParameter("status", String.valueOf(lobbyStatus.ordinal()));
        request.addParameter("id", id);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Lobby doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
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

    public Color getColor(User user) {
        return players.get(user.getUsername());
    }

    public int getPlayersCount() {
        return players.size();
    }

    public Set<User> getPlayers() {
        Set<User> users = new HashSet<>();
        for (String username : players.keySet())
            users.add(User.getUserByUsername(username));
        return users;
    }

    public LobbyStatus getLobbyStatus() {
        return lobbyStatus;
    }
}
