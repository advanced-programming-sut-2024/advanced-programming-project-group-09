package Sample.Network.Client.model.User;

import Sample.Network.Client.CardEnums.CommonCard;
import Sample.Network.Client.CardEnums.Faction;
import Sample.Network.Client.CardEnums.Leader;
import Sample.Network.Client.CardEnums.SpecialCard;
import Sample.Network.Client.model.GameBattleField;
import Sample.Network.Client.Connection;
import Sample.Network.Client.Request;
import Sample.Network.Client.Settings.Settings;
import Sample.Network.Client.model.Gwent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
public class User {
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String avatarPath;
    private int gamesPlayed;
    private int wins;
    private int draws;
    private int loses;
    private double maxScore;
    private User competitor;
    private GameBattleField lastGameBattleField;
    private long lastOnlineTime;
    private Socket socket;
    private final ArrayList<GameBattleField> allGameBattleField = new ArrayList<>();
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static User userLoginIn;
    private HashMap<String, String> securityQuestionsAndAnswers = new HashMap<>();
    private Faction factionSelected = Faction.NorthernRealms;
    private Leader factionLeader = Leader.KingOfTemeria;
    private final ArrayList<CommonCard> commonCardsInDeck = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsInDeck = new ArrayList<>();
    private ArrayList<String> senders = new ArrayList<>();
    private ArrayList<String> friends;
    private static final String DECKS_DIR = "decks/";
    private static final Map<String, String> savedDecks = new HashMap<>();
    private static final String FILE_PATH = "users.json";
    private static final Gson gson = new Gson();

    static {
        File dir = new File(DECKS_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.avatarPath = User.class.getResource(Settings.DEFAULT_AVATAR).toExternalForm();
        allUsers.add(this);
    }

    public static ArrayList<User> getUsers() {
        return allUsers;
    }

    public static User getUserByUsername(String username) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void setUserLoginIn(User userLoginIn) {
        User.userLoginIn = userLoginIn;
    }

    public static User getUserForTest() {
        return new User("tom", "123", "abcd@gmail.com", "tom");
    }

    public void setFactionLeader(Leader factionLeader) {
        this.factionLeader = factionLeader;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("faction_leader");
        request.addParameter("username", this.username);
        request.addParameter("faction_leader", factionLeader.toString());
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setUsername(String username) {
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("username");
        request.addParameter("username", this.username);
        this.username = username;
        saveUsers();
        request.addParameter("new_username", username);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setPassword(String password) {
        this.password = password;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("setPassword");
        request.addParameter("username", this.username);
        request.addParameter("password", password);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmail(String email) {
        this.email = email;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("email");
        request.addParameter("username", this.username);
        request.addParameter("email", email);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("nickname");
        request.addParameter("username", this.username);
        request.addParameter("nickname", nickname);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("maxScore");
        request.addParameter("username", username);
        request.addParameter("maxScore", String.valueOf(maxScore));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("set_avatar");
        request.addParameter("username", this.username);
        request.addParameter("avatar_path", avatarPath);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addSender(User user) {
        senders.add(user.getUsername());
        Request request = new Request();
        request.setType("friend");
        request.setCommand("add_sender");
        request.addParameter("username", username);
        request.addParameter("user", new Gson().toJson(user));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        saveUsers();
    }

    public void removeSender(User user) {
        senders.remove(user.getUsername());
        Request request = new Request();
        request.setType("friend");
        request.setCommand("remove_sender");
        request.addParameter("username", username);
        request.addParameter("user", new Gson().toJson(user));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        saveUsers();
    }

    public void addFriend(User user) {
        friends.add(user.getUsername());
        Request request = new Request();
        request.setType("friend");
        request.setCommand("add_friend");
        request.addParameter("username", username);
        request.addParameter("user", new Gson().toJson(user));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFriend(User user) {
        friends.remove(user.getUsername());
        Request request = new Request();
        request.setType("friend");
        request.setCommand("remove_friend");
        request.addParameter("username", username);
        request.addParameter("user", new Gson().toJson(user));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) try {
            throw new Exception("User doesn't exist");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setSecurityQuestionsAndAnswers(HashMap<String, String> securityQuestionsAndAnswers) {
        this.securityQuestionsAndAnswers = securityQuestionsAndAnswers;
        saveUsers();
    }

    public void setFactionSelected(Faction factionSelected) {
        this.factionSelected = factionSelected;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("faction_selected");
        request.addParameter("username", this.username);
        request.addParameter("faction_selected", factionSelected.toString());
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoses(int loses) {
        this.loses = loses;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("loses");
        request.addParameter("username", this.username);
        request.addParameter("loses", String.valueOf(loses));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setDraws(int draws) {
        this.draws = draws;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("draws");
        request.addParameter("username", this.username);
        request.addParameter("draws", String.valueOf(draws));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setWins(int wins) {
        this.wins = wins;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("wins");
        request.addParameter("username", this.username);
        request.addParameter("wins", String.valueOf(wins));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("games_played");
        request.addParameter("username", this.username);
        request.addParameter("games_played", String.valueOf(gamesPlayed));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setCompetitor(User competitor) {
        this.competitor = competitor;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("competitor");
        request.addParameter("username", this.username);
        request.addParameter("competitor", new Gson().toJson(competitor));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLastGameBattleField(GameBattleField lastGameBattleField) {
        this.lastGameBattleField = lastGameBattleField;
        saveUsers();
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("last_game_battlefield");
        request.addParameter("username", this.username);
        request.addParameter("last_game_battlefield", new Gson().toJson(lastGameBattleField));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("User doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addToAllGameBattleField(GameBattleField gameBattleField) {
        allGameBattleField.add(gameBattleField);
        saveUsers();
        Request request = new Request();
        request.setType("game");
        request.setCommand("add_game_battle_field");
        request.addParameter("username", this.username);
        request.addParameter("gameBattleField", new Gson().toJson(gameBattleField));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Error adding game battle field");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<CommonCard> getCommonCardsInDeck() {
        return commonCardsInDeck;
    }

    public ArrayList<SpecialCard> getSpecialCardsInDeck() {
        return specialCardsInDeck;
    }

    public void addCardToCommonCardsInDeck(CommonCard commonCard) {
        commonCardsInDeck.add(commonCard);
        saveUsers();
    }

    public void addCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.add(specialCard);
        saveUsers();
    }

    public void removeCardFromCommonCardsInDeck(CommonCard commonCard) {
        commonCardsInDeck.remove(commonCard);
        saveUsers();
    }

    public void removeCardFromSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.remove(specialCard);
        saveUsers();
    }

    public GameBattleField getLastGameBattleField() {
        return lastGameBattleField;
    }

    public ArrayList<GameBattleField> getAllGameBattleField() {
        return allGameBattleField;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public static User getUserLoginIn() {
        return userLoginIn;
    }

    public Leader getFactionLeader() {
        return factionLeader;
    }

    public HashMap<String, String> getSecurityQuestionsAndAnswers() {
        return securityQuestionsAndAnswers;
    }

    public Faction getFactionSelected() {
        return factionSelected;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public int getLoses() {
        return loses;
    }

    public int getDraws() {
        return draws;
    }

    public int getWins() {
        return wins;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getRank() {
        return Gwent.getInstance().getUserRank(this);
    }

    public User getCompetitor() {
        return competitor;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public ArrayList<String> getSenders() {
        return senders;
    }

    public long getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void updateLastOnline() {
        this.lastOnlineTime = System.currentTimeMillis();
        saveUsers();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isOnline() {
        return socket != null;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public boolean isFriend(User user) {
        return friends.contains(user);
    }

    public boolean isHaveRequestFrom(User user) {
        return senders.contains(user.getUsername());
    }

    public void updateLists() {
        User user = Gwent.getInstance().getUser(username);
        if (user != null) {
            friends = user.friends;
            senders = user.senders;
        }
    }

    public static void saveUsers() {
        List<UserData> userDataList = new ArrayList<>();
        for (User user : allUsers) {
            userDataList.add(new UserData(user.getUsername(), user.getPassword(), user.getEmail(), user.getNickname(),
                    user.getFactionSelected(), user.getFactionLeader(), user.getCommonCardsInDeck(), user.getSpecialCardsInDeck()));
        }
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(userDataList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Request request = new Request();
        request.setType("user_data");
        request.setCommand("save");
        request.addParameter("userDataList", new Gson().toJson(userDataList));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Error saving user data");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<ArrayList<UserData>>() {
            }.getType();
            ArrayList<UserData> loadedUsers = gson.fromJson(reader, type);
            allUsers.clear();
            for (UserData userData : loadedUsers) {
                User user = new User(userData.username, userData.password, userData.email, userData.nickname);
                user.setFactionSelected(userData.factionSelected);
                user.setFactionLeader(userData.factionLeader);
                user.commonCardsInDeck.addAll(userData.commonCardsInDeck);
                user.specialCardsInDeck.addAll(userData.specialCardsInDeck);
                allUsers.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Request request = new Request();
        request.setType("user_data");
        request.setCommand("load");
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Error loading user data");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveDeckToFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            throw new RuntimeException("File already exists.");
        }
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error saving deck: " + e.getMessage(), e);
        }
        Request request = new Request();
        request.setType("deck");
        request.setCommand("save");
        request.addParameter("username", this.username);
        request.addParameter("deck_path", filePath);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Error saving deck");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadDeckFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist.");
        }
        try (FileReader reader = new FileReader(file)) {
            User loadedUser = gson.fromJson(reader, User.class);
            this.factionSelected = loadedUser.factionSelected;
            this.factionLeader = loadedUser.factionLeader;
            this.commonCardsInDeck.clear();
            this.commonCardsInDeck.addAll(loadedUser.commonCardsInDeck);
            this.specialCardsInDeck.clear();
            this.specialCardsInDeck.addAll(loadedUser.specialCardsInDeck);
        } catch (IOException e) {
            throw new RuntimeException("Error loading deck: " + e.getMessage(), e);
        }
        Request request = new Request();
        request.setType("deck");
        request.setCommand("load");
        request.addParameter("username", this.username);
        request.addParameter("deck_path", filePath);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("Error loading deck");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadDeckByName(String name) {
        if (!savedDecks.containsKey(name)) {
            throw new RuntimeException("No deck saved with this name.");
        }
        String filePath = savedDecks.get(name);
        loadDeckFromFile(filePath);
    }

    private static class UserData {
        private String username;
        private String password;
        private String email;
        private String nickname;
        private Faction factionSelected;
        private Leader factionLeader;
        private List<CommonCard> commonCardsInDeck;
        private List<SpecialCard> specialCardsInDeck;

        public UserData(String username, String password, String email, String nickname, Faction factionSelected, Leader factionLeader, List<CommonCard> commonCardsInDeck, List<SpecialCard> specialCardsInDeck) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.nickname = nickname;
            this.factionSelected = factionSelected;
            this.factionLeader = factionLeader;
            this.commonCardsInDeck = commonCardsInDeck;
            this.specialCardsInDeck = specialCardsInDeck;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public String getNickname() {
            return nickname;
        }

        public Faction getFactionSelected() {
            return factionSelected;
        }

        public Leader getFactionLeader() {
            return factionLeader;
        }

        public List<CommonCard> getCommonCardsInDeck() {
            return commonCardsInDeck;
        }

        public List<SpecialCard> getSpecialCardsInDeck() {
            return specialCardsInDeck;
        }
    }
}
