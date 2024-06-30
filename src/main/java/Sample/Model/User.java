package Sample.Model;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.Faction;
import Sample.CardEnums.Leader;
import Sample.CardEnums.SpecialCard;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


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

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
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

    public static User getUserLoginIn() {
        return userLoginIn;
    }

    public static void setUserLoginIn(User userLoginIn) {
        User.userLoginIn = userLoginIn;
    }

    public void setFactionLeader(Leader factionLeader) {
        this.factionLeader = factionLeader;
    }

    public Leader getFactionLeader() {
        return factionLeader;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
    }

    public HashMap<String, String> getSecurityQuestionsAndAnswers() {
        return securityQuestionsAndAnswers;
    }

    public void setFactionSelected(Faction factionSelected) {
        this.factionSelected = factionSelected;
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
    }

    public void addCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.add(specialCard);
    }

    public void removeCardToCommonCardsInDeck(CommonCard commonCard) {

    }

    public void removeCardToSpecialCardsInDeck(SpecialCard specialCard) {

    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
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
    }

    public GameBattleField getLastGameBattleField() {
        return lastGameBattleField;
    }

    public void setLastGameBattleField(GameBattleField lastGameBattleField) {
        this.lastGameBattleField = lastGameBattleField;
    }

    public ArrayList<GameBattleField> getAllGameBattleField() {
        return allGameBattleField;
    }

    public void addToAllGameBattleField(GameBattleField gameBattleField) {
        allGameBattleField.add(gameBattleField);
    }

    public void saveUserData(String filePath) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User loadUserData(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, User.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
