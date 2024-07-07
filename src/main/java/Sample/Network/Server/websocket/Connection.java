package Sample.Network.Server.websocket;

import Sample.Network.Client.CardEnums.Faction;
import Sample.Network.Client.CardEnums.Leader;
import Sample.Network.Client.model.GameBattleField;
import com.google.gson.Gson;
import Sample.Network.Client.model.User.User;
import Sample.Network.Server.database.ChatManager;
import Sample.Network.Server.database.Database;
import Sample.Network.Server.model.*;
import Sample.Network.Server.model.Television.ResourceManager;
import Sample.Network.Server.model.Television.SaveData;
import Sample.Network.Server.model.chatRoom.Chat;
import com.google.gson.reflect.TypeToken;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class Connection extends Thread {
    private final Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;
    private User loggedInUser;

    public Connection(Socket socket) {
        this.socket = socket;
        System.out.println("Connection from " + socket.getInetAddress() + socket.getPort());
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closedConnection() {
        System.out.println("Disconnected " + socket.getInetAddress() + socket.getPort());
        if (loggedInUser != null) {
            loggedInUser.setCompetitor(null);
            loggedInUser = null;
        }
    }

    @Override
    public void run() {
        Request request;
        try {
            while (true) {
                try {
                    request = new Gson().fromJson(inputStream.readUTF(), Request.class);
                } catch (EOFException e) {
                    closedConnection();
                    return;
                }
                switch (request.getType()) {
                    case "connect":
                        handleConnection(request);
                        break;
                    case "user_query":
                        handleUsersQuery(request);
                        break;
                    case "user_change":
                        handleUsersChange(request);
                        break;
                    case "chat":
                        handleChat(request);
                        break;
                    case "friend":
                        handleFriend(request);
                        break;
                    case "scoreboard":
                        handleScoreboard();
                        break;
                    case "lobby":
                        handleLobby(request);
                        break;
                    case "lobby_change":
                        handleLobbyChange(request);
                        break;
                    case "game":
                        handleGame();
                        break;
                    case "television":
                        handleTelevision(request);
                        break;
                    default:
                        outputStream.writeUTF("400: bad request");
                }
            }
        } catch (SocketException socketException) {
            closedConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void handleConnection(Request request) throws IOException {
        User user = User.getUserByUsername(request.getParameters().get("username"));
        if (user == null) {
            outputStream.writeUTF("400: no_user");
            return;
        }
        switch (request.getCommand()) {
            case "login":
                if (user.getCompetitor() != null) {
                    outputStream.writeUTF("400: Already logged in");
                    return;
                }
                user.setCompetitor(loggedInUser);
                loggedInUser = user;
                outputStream.writeUTF("200: Sign in success");
                break;
            case "logout":
                loggedInUser = null;
                user.setCompetitor(null);
                outputStream.writeUTF("200: Log out success");
                break;
            default:
                outputStream.writeUTF("400: bad request");
        }
    }

    private void handleUsersQuery(Request request) throws IOException {
        switch (request.getCommand()) {
            case "get_user":
                User user = User.getUserByUsername(request.getParameters().get("username"));
                if (user == null) outputStream.writeUTF("400: no_user");
                else outputStream.writeUTF(new Gson().toJson(user));
                break;
            case "user_exists":
                outputStream.writeUTF(String.valueOf(
                        User.getUserByUsername(request.getParameters().get("username")) != null));
                break;
            case "email_exists":
                outputStream.writeUTF(String.valueOf(
                        User.getUsers().stream().anyMatch(u -> u.getEmail().equals(request.getParameters().get("email")))));
                break;
            case "get_users":
                outputStream.writeUTF(new Gson().toJson(User.getUsers()));
                break;
            case "get_rankings":
                // Implement this method based on your ranking logic
                break;
            case "get_user_rank":
                // Implement this method based on your ranking logic
                break;
            case "get_online_users":
                // Implement this method if you have online user tracking
                break;
            case "user_online":
                User userOnline = User.getUserByUsername(request.getParameters().get("username"));
                outputStream.writeUTF(String.valueOf(userOnline != null && userOnline.getCompetitor() != null));
                break;
            default:
                outputStream.writeUTF("400: bad request");
        }
    }

    private void handleUsersChange(Request request) throws IOException {
        if (request.getCommand().equals("add")) {
            new User(request.getParameters().get("username"), request.getParameters().get("password"),
                    request.getParameters().get("email"), request.getParameters().get("nickname"));
            outputStream.writeUTF("200: successfully added");
            return;
        }
        User user = User.getUserByUsername(request.getParameters().get("username"));
        if (user == null) {
            outputStream.writeUTF("400: no_user");
            return;
        }
        switch (request.getCommand()) {
            case "maxScore":
                user.setMaxScore(Double.parseDouble(request.getParameters().get("maxScore")));
                break;
            case "username":
                user.setUsername(request.getParameters().get("new_username"));
                break;
            case "nickname":
                user.setNickname(request.getParameters().get("nickname"));
                break;
            case "email":
                user.setEmail(request.getParameters().get("email"));
                break;
            case "setPassword":
                user.setPassword(request.getParameters().get("password"));
                break;
            case "faction_leader":
                user.setFactionLeader(Leader.valueOf(request.getParameters().get("faction_leader")));
                break;
            case "loses":
                user.setLoses(Integer.parseInt(request.getParameters().get("loses")));
                break;
            case "draws":
                user.setDraws(Integer.parseInt(request.getParameters().get("draws")));
                break;
            case "wins":
                user.setWins(Integer.parseInt(request.getParameters().get("wins")));
                break;
            case "games_played":
                user.setGamesPlayed(Integer.parseInt(request.getParameters().get("games_played")));
                break;
            case "competitor":
                User competitor = new Gson().fromJson(request.getParameters().get("competitor"), User.class);
                user.setCompetitor(competitor);
                break;
            case "last_game_battlefield":
                GameBattleField gameBattleField = new Gson().fromJson(request.getParameters().get("last_game_battlefield"), GameBattleField.class);
                user.setLastGameBattleField(gameBattleField);
                break;
            case "security_questions":
                Type type = new TypeToken<HashMap<String, String>>() {}.getType();
                HashMap<String, String> securityQuestions = new Gson().fromJson(request.getParameters().get("security_questions"), type);
                user.setSecurityQuestionsAndAnswers(securityQuestions);
                break;
            case "faction_selected":
                user.setFactionSelected(Faction.valueOf(request.getParameters().get("faction_selected")));
                break;
            default:
                outputStream.writeUTF("400: bad request");
                return;
        }
        outputStream.writeUTF("200: success");
    }

    private void handleDeck(Request request) throws IOException {
        User user = User.getUserByUsername(request.getParameters().get("username"));
        if (user == null) {
            outputStream.writeUTF("400: no_user");
            return;
        }
        switch (request.getCommand()) {
            case "save":
                String deckPath = request.getParameters().get("deck_path");
                user.saveDeckToFile(deckPath);
                break;
            case "load":
                deckPath = request.getParameters().get("deck_path");
                user.loadDeckFromFile(deckPath);
                break;
            default:
                outputStream.writeUTF("400: bad request");
                return;
        }
        outputStream.writeUTF("200: success");
    }

/*
    private void handleUserData(Request request) throws IOException {
        String userDataListJson = request.getParameters().get("userDataList");
        Type type = new TypeToken<ArrayList<User.UserData>>() {}.getType();
        ArrayList<User.UserData> userDataList = new Gson().fromJson(userDataListJson, type);
        switch (request.getCommand()) {
            case "save":
                User.saveUsers();
                break;
            case "load":
                User.loadUsers();
                break;
            default:
                outputStream.writeUTF("400: bad request");
                return;
        }
        outputStream.writeUTF("200: success");
    }
*/

    private void handleChat(Request request) throws IOException {
        switch (request.getCommand()) {
            case "update_chat":
                Chat chat = new Gson().fromJson(request.getParameters().get("chat"), Chat.class);
                ChatManager.updateChat(chat, chat.getChatMode());
                outputStream.writeUTF("200: successfully updated");
                ChatManager.notifyAllMembers(chat);
                break;
            case "get_global_chat":
                outputStream.writeUTF(new Gson().toJson(ChatManager.loadGlobalChat()));
                break;
            case "get_private_chats":
                outputStream.writeUTF(new Gson().toJson(ChatManager.loadPrivateChats()));
                break;
            case "get_room_chats":
                outputStream.writeUTF(new Gson().toJson(ChatManager.loadRoomChats()));
                break;
            case "load_chat":
                String out1 = new Gson().toJson(ChatManager.loadChat(request.getParameters().get("chat_id"),
                        new Gson().fromJson(request.getParameters().get("chat_type"), Chat.ChatMode.class)));
                outputStream.writeUTF(out1);
                break;
        }
    }

    private void handleFriend(Request request) throws IOException {
        User user = User.getUserByUsername(request.getParameters().get("username"));
        if (user == null) {
            outputStream.writeUTF("400: no_user");
            return;
        }
        User targetUser = User.getUserByUsername(request.getParameters().get("target_username"));
        if (targetUser == null) {
            outputStream.writeUTF("400: no_target_user");
            return;
        }
        switch (request.getCommand()) {
            case "add_friend":
                user.sendFriendRequest(targetUser);
                break;
            case "accept_friend":
                user.acceptFriendRequest(targetUser);
                break;
            case "reject_friend":
                user.rejectFriendRequest(targetUser);
                break;
            case "remove_friend":
                user.removeFriend(targetUser);
                break;
            default:
                outputStream.writeUTF("400: bad request");
        }
        outputStream.writeUTF("200: success");
    }

    private void handleScoreboard() {
        // Implement scoreboard handling logic
    }

    private void handleLobby(Request request) throws IOException {
        Lobby lobby;
        switch (request.getCommand()) {
            case "create_lobby":
                Database.getInstance().addLobby(new Gson().fromJson(request.getParameters().get("lobby"), Lobby.class));
                outputStream.writeUTF("200: success");
                break;
            case "delete_lobby":
                Database.getInstance().removeLobby(request.getParameters().get("id"));
                outputStream.writeUTF("200: success");
                break;
            case "get_lobbies":
                outputStream.writeUTF(new Gson().toJson(Database.getInstance().getAllLobbies()));
                break;
            case "get_lobby":
                lobby = Database.getInstance().getLobby(request.getParameters().get("id"));
                if (lobby == null) outputStream.writeUTF("400: no_lobby");
                else outputStream.writeUTF(new Gson().toJson(lobby));
                break;
            case "lobby_exists":
                lobby = Database.getInstance().getLobby(request.getParameters().get("id"));
                outputStream.writeUTF(String.valueOf(lobby != null));
                break;
            default:
                outputStream.writeUTF("400: bad request");
        }
    }

    private void handleLobbyChange(Request request) throws IOException {
        Map<String, String> parameters = request.getParameters();
        Lobby lobby = Database.getInstance().getLobby(parameters.get("id"));
        if (lobby == null) {
            outputStream.writeUTF("400: no_lobby");
            return;
        }
        switch (request.getCommand()) {
            case "add_player":
                lobby.addPlayer(new Gson().fromJson(parameters.get("player"), User.class),
                        Color.values()[Integer.parseInt(parameters.get("color"))]);
                break;
            case "remove_player":
                lobby.removePlayer(new Gson().fromJson(parameters.get("player"), User.class));
                break;
            case "set_admin":
                lobby.setAdmin(new Gson().fromJson(parameters.get("player"), User.class));
                break;
            case "change_status":
                LobbyStatus newStatus = LobbyStatus.values()[Integer.parseInt(request.getParameters().get("status"))];
                lobby.setLobbyStatus(newStatus);
                break;
            default:
                outputStream.writeUTF("400: bad request");
                break;
        }
        outputStream.writeUTF("200: success");
    }

    private void handleTelevision(Request request) throws Exception {
        String id = new Gson().fromJson(request.getParameters().get("id"), String.class);
        String fileName = new Gson().fromJson(request.getParameters().get("filename"), String.class);
        switch (request.getCommand()) {
            case "save":
                SaveData saveData = new Gson().fromJson(request.getParameters().get("saveData"), SaveData.class);
                ResourceManager.save(saveData, id, fileName);
                outputStream.writeUTF("200: success");
                break;
            case "load":
                SaveData data = (SaveData) ResourceManager.load(id, fileName);
                outputStream.writeUTF(new Gson().toJson(data));
                break;
            default:
                outputStream.writeUTF("400: bad request");
                break;
        }
    }

    private void handleGame() {
        // Implement game handling logic
    }
}
