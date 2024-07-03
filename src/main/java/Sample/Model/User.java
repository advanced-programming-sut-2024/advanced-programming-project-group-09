package Sample.Model;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.Faction;
import Sample.CardEnums.Leader;
import Sample.CardEnums.SpecialCard;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final ArrayList<GameBattleField> allGameBattleField = new ArrayList<>();
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static User userLoginIn;
    private HashMap<String, String> securityQuestionsAndAnswers = new HashMap<>();
    private Faction factionSelected = Faction.NorthernRealms;
    private Leader factionLeader = Leader.KingOfTemeria;
    private final ArrayList<CommonCard> commonCardsInDeck = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsInDeck = new ArrayList<>();

    private static final String DECKS_DIR = "decks/";
    private static final Map<String, String> savedDecks = new HashMap<>();
    private static final String FILE_PATH = "users.json";
    private static final Gson gson = new Gson();

//    static {
//        loadUsers();
//    }

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
        allUsers.add(this);
//        saveUsers();
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

    public static User getUserLoginIn() {
        return userLoginIn;
    }

    public static void setUserLoginIn(User userLoginIn) {
        User.userLoginIn = userLoginIn;
    }

    public static User getUserForTest() {
        return new User("tome", "123", "abcd@gmail.com", "tom");
    }

    public void setFactionLeader(Leader factionLeader) {
        this.factionLeader = factionLeader;
        saveUsers();
    }

    public Leader getFactionLeader() {
        return factionLeader;
    }

    public void setUsername(String username) {
        this.username = username;
        saveUsers();
    }

    public void setPassword(String password) {
        this.password = password;
        saveUsers();
    }

    public void setEmail(String email) {
        this.email = email;
        saveUsers();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        saveUsers();
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

    public void setSecurityQuestionsAndAnswers(HashMap<String, String> securityQuestionsAndAnswers) {
        this.securityQuestionsAndAnswers = securityQuestionsAndAnswers;
        saveUsers();
    }

    public HashMap<String, String> getSecurityQuestionsAndAnswers() {
        return securityQuestionsAndAnswers;
    }

    public void setFactionSelected(Faction factionSelected) {
        this.factionSelected = factionSelected;
        saveUsers();
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
        saveUsers();
    }

    public void addCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.add(specialCard);
        saveUsers();
    }

    public void removeCardToCommonCardsInDeck(CommonCard commonCard) {
        commonCardsInDeck.remove(commonCard);
        saveUsers();
    }

    public void removeCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.remove(specialCard);
        saveUsers();
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
        saveUsers();
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
        saveUsers();
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
        saveUsers();
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
        saveUsers();
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
        saveUsers();
    }

    public int getRank() {
        allUsers.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getRank() - o1.getRank();
            }
        });
        return allUsers.indexOf(this);
    }

    public User getCompetitor() {
        return competitor;
    }

    public void setCompetitor(User competitor) {
        this.competitor = competitor;
        saveUsers();
    }

    public GameBattleField getLastGameBattleField() {
        return lastGameBattleField;
    }

    public void setLastGameBattleField(GameBattleField lastGameBattleField) {
        this.lastGameBattleField = lastGameBattleField;
        saveUsers();
    }

    public ArrayList<GameBattleField> getAllGameBattleField() {
        return allGameBattleField;
    }

    public void addToAllGameBattleField(GameBattleField gameBattleField) {
        allGameBattleField.add(gameBattleField);
        saveUsers();
    }

    public static void saveUsers() {
        List<UserData> userDataList = new ArrayList<>();
        for (User user : allUsers) {
            userDataList.add(new UserData(user.getUsername(), user.getPassword(), user.getEmail(), user.getNickname(), user.getFactionSelected(), user.getFactionLeader(), user.getCommonCardsInDeck(), user.getSpecialCardsInDeck()));
        }
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(userDataList, writer);
        } catch (IOException e) {
            e.printStackTrace();
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
    }
}
