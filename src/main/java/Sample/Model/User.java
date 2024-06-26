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

    public ArrayList<SpecialCard> getSpecialCardsBattleField() {
        return specialCardsBattleField;
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

    public void setSpecialFieldInCloseCombat(SpecialCard specialFieldInCloseCombat) {
        this.specialFieldInCloseCombat = specialFieldInCloseCombat;
    }

    public void setSpecialFieldInSiege(SpecialCard specialFieldInSiege) {
        this.specialFieldInSiege = specialFieldInSiege;
    }

    public void setSpecialFieldInRanged(SpecialCard specialFieldInRanged) {
        this.specialFieldInRanged = specialFieldInRanged;
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
    }

    public void addCardToCommonCardsInDiscard(CommonCard commonCard) {
        commonCardsInDiscard.add(commonCard);
    }

    public void addCardToCommonCardsInBattleField(CommonCard commonCard) {
        commonCardInBattleField.add(commonCard);
    }

    public void addCardToSpecialCardsInDeck(SpecialCard specialCard) {
        specialCardsInDeck.add(specialCard);
    }

    public void addCardToSpecialCardsInDiscard(SpecialCard specialCard) {
        specialCardsDiscard.add(specialCard);
    }

    public void addCardToSpecialCardsInBattleField(SpecialCard specialCard) {
        specialCardsBattleField.add(specialCard);
    }

    public void addCardToCommonCardsInCloseCombat(CommonCard commonCard) {
        closeCombatBattleField.add(commonCard);
    }

    public void addCardToCommonCardsInSiege(CommonCard commonCard) {
        siegeIsPlayed.add(commonCard);
    }

    public void addCardToCommonCardsInRanged(CommonCard commonCard) {
        closeCombatBattleField.add(commonCard);
    }

    public void removeCardToCommonCardsInDeck(CommonCard commonCard) {

    }

    public void removeCardToCommonCardsInDiscard(CommonCard commonCard) {

    }

    public void removeCardToCommonCardsInBattleField(CommonCard commonCard) {

    }

    public void removeCardToSpecialCardsInDeck(SpecialCard specialCard) {

    }

    public void removeCardToSpecialCardsInDiscard(SpecialCard specialCard) {

    }

    public void removeCardToSpecialCardsInBattleField(SpecialCard specialCard) {

    }

    public void removeCardToCommonCardsInCloseCombat(CommonCard commonCard) {

    }

    public void removeCardToCommonCardsInSiege(CommonCard commonCard) {

    }

    public void removeCardToCommonCardsInRanged(CommonCard commonCard) {

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
