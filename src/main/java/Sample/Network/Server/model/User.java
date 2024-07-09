package Sample.Network.Server.model;

import Sample.Network.Client.model.GameBattleField;
import Sample.Network.Client.Settings.Settings;
import Sample.Network.Server.database.Database;
import Sample.Network.Client.CardEnums.CommonCard;
import Sample.Network.Client.CardEnums.Faction;
import Sample.Network.Client.CardEnums.Leader;
import Sample.Network.Client.CardEnums.SpecialCard;

import java.net.Socket;

import Sample.Network.Server.database.UserManager;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@SuppressWarnings({"FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
public class User {
    private String username;
    private String password;
    private String email;
    private String nickname;
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
    private ArrayList<String> friends = new ArrayList<>();
    private static final String DECKS_DIR = "decks/";
    private static final Map<String, String> savedDecks = new HashMap<>();
    private static final String FILE_PATH = "users.json";
    private static final Gson gson = new Gson();

    static {
        loadUsers();
    }

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
        Database.getInstance().addUser(this);
    }

    public static ArrayList<User> getUsers() {
        return allUsers;
    }

    public static User getUserByUsername(String username) {
        return Database.getInstance().getUser(username);
    }

    public static User getUserLoginIn() {
        return userLoginIn;
    }

    public static void setUserLoginIn(User userLoginIn) {
        User.userLoginIn = userLoginIn;
    }

    public void setFactionLeader(Leader factionLeader) {
        this.factionLeader = factionLeader;
        Database.getInstance().updateData();
    }

    public Leader getFactionLeader() {
        return factionLeader;
    }

    public void setUsername(String username) {
        this.username = username;
        Database.getInstance().updateData();
    }

    public void setPassword(String password) {
        this.password = password;
        Database.getInstance().updateData();
    }

    public void setEmail(String email) {
        this.email = email;
        Database.getInstance().updateData();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        Database.getInstance().updateData();
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

    public void addFriend(User user) {
        friends.add(user.getUsername());
        Database.getInstance().updateData();
    }

    public void addSender(User user) {
        senders.add(user.getUsername());
        Database.getInstance().updateData();
    }

    public void removeFriend(User user) {
        friends.remove(user.getUsername());
        Database.getInstance().updateData();
    }

    public void removeSender(User user) {
        senders.remove(user.getUsername());
        Database.getInstance().updateData();
    }

    public void updateLastOnline() {
        lastOnlineTime = System.currentTimeMillis();
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

    public void setSecurityQuestionsAndAnswers(HashMap<String, String> securityQuestionsAndAnswers) {
        this.securityQuestionsAndAnswers = securityQuestionsAndAnswers;
        Database.getInstance().updateData();
    }

    public HashMap<String, String> getSecurityQuestionsAndAnswers() {
        return securityQuestionsAndAnswers;
    }

    public void setFactionSelected(Faction factionSelected) {
        this.factionSelected = factionSelected;
        Database.getInstance().updateData();
    }

    public Faction getFactionSelected() {
        return factionSelected;
    }

    public ArrayList<CommonCard> getCommonCardsInDeck() {
        return commonCardsInDeck;
    }

    public ArrayList<SpecialCard> getSpecialCardsInDeck() {
        return specialCardsInDeck;
    }

    public void addCardToCommonCardsInDeck(CommonCard commonCard) {
        commonCardsInDeck.add(commonCard);
        Database.getInstance().updateData();
    }

    public void addCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.add(specialCard);
        Database.getInstance().updateData();
    }

    public void removeCardFromCommonCardsInDeck(CommonCard commonCard) {
        commonCardsInDeck.remove(commonCard);
        Database.getInstance().updateData();
    }

    public void removeCardFromSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.remove(specialCard);
        Database.getInstance().updateData();
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
        Database.getInstance().updateData();
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
        Database.getInstance().updateData();
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
        Database.getInstance().updateData();
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
        Database.getInstance().updateData();
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
        Database.getInstance().updateData();
    }

    public int getRank() {
        allUsers.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Double.compare(o2.getMaxScore(), o1.getMaxScore());
            }
        });
        return allUsers.indexOf(this) + 1;
    }

    public User getCompetitor() {
        return competitor;
    }

    public void setCompetitor(User competitor) {
        this.competitor = competitor;
        Database.getInstance().updateData();
    }

    public GameBattleField getLastGameBattleField() {
        return lastGameBattleField;
    }

    public void setLastGameBattleField(GameBattleField lastGameBattleField) {
        this.lastGameBattleField = lastGameBattleField;
        Database.getInstance().updateData();
    }

    public ArrayList<GameBattleField> getAllGameBattleField() {
        return allGameBattleField;
    }

    public void addToAllGameBattleField(GameBattleField gameBattleField) {
        allGameBattleField.add(gameBattleField);
        Database.getInstance().updateData();
    }

    public static void saveUsers() {
        Database.getInstance().updateData();
    }

    public static void loadUsers() {
        UserManager.load(Database.getInstance());
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
    }

    public void saveDeckByName(String name) {
        if (savedDecks.containsKey(name)) {
            throw new RuntimeException("Deck name already exists.");
        }
        String filePath = DECKS_DIR + name + ".json";
        savedDecks.put(name, filePath);
        saveDeckToFile(filePath);
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
    }

    public void loadDeckByName(String name) {
        if (!savedDecks.containsKey(name)) {
            throw new RuntimeException("No deck saved with this name.");
        }
        String filePath = savedDecks.get(name);
        loadDeckFromFile(filePath);
    }

    public static class UserData {
        private String username;
        private String password;
        private String email;
        private String nickname;
        private Faction factionSelected;
        private Leader factionLeader;
        private List<CommonCard> commonCardsInDeck;
        private List<SpecialCard> specialCardsInDeck;

        public UserData(String username, String password, String email, String nickname, Faction factionSelected, Leader factionLeader,
                        List<CommonCard> commonCardsInDeck, List<SpecialCard> specialCardsInDeck) {
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
