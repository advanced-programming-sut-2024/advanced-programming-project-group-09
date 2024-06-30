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
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static User userLoginIn;
    private HashMap<String, String> securityQuestionsAndAnswers = new HashMap<>();
    private Faction factionSelected = Faction.NorthernRealms;

    private Leader factionLeader = Leader.KingOfTemeria;

    private final ArrayList<CommonCard> commonCardsInDeck = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsInDeck = new ArrayList<>();
    private final ArrayList<CommonCard> commonCardInBattleField = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsBattleField = new ArrayList<>();
    private final ArrayList<CommonCard> closeCombatBattleField = new ArrayList<>();
    private final ArrayList<CommonCard> commonCardsInDiscard = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsDiscard = new ArrayList<>();
    private final ArrayList<CommonCard> siegeIsPlayed = new ArrayList<>();
    private final ArrayList<CommonCard> rangedIsPlayed = new ArrayList<>();
    private SpecialCard specialFieldInCloseCombat = null;
    private SpecialCard specialFieldInSiege = null;
    private SpecialCard specialFieldInRanged = null;

    private static final String DECKS_DIR = "decks/";
    private static final Map<String, String> savedDecks = new HashMap<>();
    private static final String FILE_PATH = "users.json";
    private static final Gson gson = new Gson();

    static {
        loadUsers();
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
        saveUsers(); // Save users whenever a new user is created
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

    public void setFactionLeader(Leader factionLeader) {
        this.factionLeader = factionLeader;
        saveUsers();
    }

    public Leader getFactionLeader() {
        return factionLeader;
    }

    public ArrayList<SpecialCard> getSpecialCardsBattleField() {
        return specialCardsBattleField;
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

    public void setSpecialFieldInCloseCombat(SpecialCard specialFieldInCloseCombat) {
        this.specialFieldInCloseCombat = specialFieldInCloseCombat;
        saveUsers();
    }

    public void setSpecialFieldInSiege(SpecialCard specialFieldInSiege) {
        this.specialFieldInSiege = specialFieldInSiege;
        saveUsers();
    }

    public void setSpecialFieldInRanged(SpecialCard specialFieldInRanged) {
        this.specialFieldInRanged = specialFieldInRanged;
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

    public ArrayList<CommonCard> getCommonCardInBattleField() {
        return commonCardInBattleField;
    }

    public ArrayList<SpecialCard> getSpecialCardsCanPlay() {
        return specialCardsBattleField;
    }

    public ArrayList<CommonCard> getCommonCardsInDiscard() {
        return commonCardsInDiscard;
    }

    public ArrayList<SpecialCard> getSpecialCardsDiscard() {
        return specialCardsDiscard;
    }

    public ArrayList<CommonCard> getCloseCombatBattleField() {
        return closeCombatBattleField;
    }

    public ArrayList<CommonCard> getSiegeIsPlayed() {
        return siegeIsPlayed;
    }

    public ArrayList<CommonCard> getRangedIsPlayed() {
        return rangedIsPlayed;
    }

    public SpecialCard getSpecialFieldInCloseCombat() {
        return specialFieldInCloseCombat;
    }

    public SpecialCard getSpecialFieldInSiege() {
        return specialFieldInSiege;
    }

    public SpecialCard getSpecialFieldInRanged() {
        return specialFieldInRanged;
    }

    public void addCardToCommonCardsInDeck(CommonCard commonCard) {
        commonCardsInDeck.add(commonCard);
        saveUsers();
    }

    public void addCardToCommonCardsInDiscard(CommonCard commonCard) {
        commonCardsInDiscard.add(commonCard);
        saveUsers();
    }

    public void addCardToCommonCardsInBattleField(CommonCard commonCard) {
        commonCardInBattleField.add(commonCard);
        saveUsers();
    }

    public void addCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.add(specialCard);
        saveUsers();
    }

    public void addCardToSpecialCardsInDiscard(SpecialCard specialCard) {
        specialCardsDiscard.add(specialCard);
        saveUsers();
    }

    public void addCardToSpecialCardsInBattleField(SpecialCard specialCard) {
        specialCardsBattleField.add(specialCard);
        saveUsers();
    }

    public void addCardToCommonCardsInCloseCombat(CommonCard commonCard) {
        closeCombatBattleField.add(commonCard);
        saveUsers();
    }

    public void addCardToCommonCardsInSiege(CommonCard commonCard) {
        siegeIsPlayed.add(commonCard);
        saveUsers();
    }

    public void addCardToCommonCardsInRanged(CommonCard commonCard) {
        closeCombatBattleField.add(commonCard);
        saveUsers();
    }

    public void removeCardToCommonCardsInDeck(CommonCard commonCard) {
        commonCardsInDeck.remove(commonCard);
        saveUsers();
    }

    public void removeCardToCommonCardsInDiscard(CommonCard commonCard) {
        commonCardsInDiscard.remove(commonCard);
        saveUsers();
    }

    public void removeCardToCommonCardsInBattleField(CommonCard commonCard) {
        commonCardInBattleField.remove(commonCard);
        saveUsers();
    }

    public void removeCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.remove(specialCard);
        saveUsers();
    }

    public void removeCardToSpecialCardsInDiscard(SpecialCard specialCard) {
        specialCardsDiscard.remove(specialCard);
        saveUsers();
    }

    public void removeCardToSpecialCardsInBattleField(SpecialCard specialCard) {
        specialCardsBattleField.remove(specialCard);
        saveUsers();
    }

    public void removeCardToCommonCardsInCloseCombat(CommonCard commonCard) {
        closeCombatBattleField.remove(commonCard);
        saveUsers();
    }

    public void removeCardToCommonCardsInSiege(CommonCard commonCard) {
        siegeIsPlayed.remove(commonCard);
        saveUsers();
    }

    public void removeCardToCommonCardsInRanged(CommonCard commonCard) {
        closeCombatBattleField.remove(commonCard);
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

    public static void saveUsers() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(allUsers, writer);
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
            Type type = new TypeToken<ArrayList<User>>() {
            }.getType();
            ArrayList<User> loadedUsers = gson.fromJson(reader, type);
            allUsers.clear();
            allUsers.addAll(loadedUsers);
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

}