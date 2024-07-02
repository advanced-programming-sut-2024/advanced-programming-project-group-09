package Sample.Model;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;

import java.util.ArrayList;

public class GameBattleField {
    private final User user1;
    private final ArrayList<CommonCard> commonCardInBattleFieldUser1 = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsBattleFieldUser1 = new ArrayList<>();
    private final ArrayList<CommonCard> commonCardInDeckUser1 = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsDeckUser1 = new ArrayList<>();
    private final ArrayList<CommonCard> commonCardsInDiscardUser1 = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsDiscardUser1 = new ArrayList<>();
    private final ArrayList<CommonCard> closeCombatIsPlayedUser1 = new ArrayList<>();
    private final ArrayList<CommonCard> siegeIsPlayedUser1 = new ArrayList<>();
    private final ArrayList<CommonCard> rangedIsPlayedUser1 = new ArrayList<>();
    private SpecialCard specialFieldInCloseCombatUser1 = null;
    private SpecialCard specialFieldInSiegeUser1 = null;
    private SpecialCard specialFieldInRangedUser1 = null;

    private final User user2;
    private final ArrayList<CommonCard> commonCardInBattleFieldUser2 = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsBattleFieldUser2 = new ArrayList<>();
    private final ArrayList<CommonCard> commonCardInDeckUser2 = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsDeckUser2 = new ArrayList<>();
    private final ArrayList<CommonCard> commonCardsInDiscardUser2 = new ArrayList<>();
    private final ArrayList<SpecialCard> specialCardsDiscardUser2 = new ArrayList<>();
    private final ArrayList<CommonCard> closeCombatIsPlayedUser2 = new ArrayList<>();
    private final ArrayList<CommonCard> siegeIsPlayedUser2 = new ArrayList<>();
    private final ArrayList<CommonCard> rangedIsPlayedUser2 = new ArrayList<>();
    private SpecialCard specialFieldInCloseCombatUser2 = null;
    private SpecialCard specialFieldInSiegeUser2 = null;
    private SpecialCard specialFieldInRangedUser2 = null;
    private User whichUserTurn;
    private final ArrayList<SpecialCard> weatherCards = new ArrayList<>();

    public GameBattleField(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        whichUserTurn = user1;
    }

    public User getUser1() {
        return user1;
    }

    public ArrayList<CommonCard> getCommonCardInBattleFieldUser1() {
        return commonCardInBattleFieldUser1;
    }

    public ArrayList<SpecialCard> getSpecialCardsBattleFieldUser1() {
        return specialCardsBattleFieldUser1;
    }

    public ArrayList<CommonCard> getCommonCardInDeckUser1() {
        return commonCardInDeckUser1;
    }

    public ArrayList<SpecialCard> getSpecialCardsDeckUser1() {
        return specialCardsDeckUser1;
    }

    public ArrayList<CommonCard> getCommonCardInDeckUser2() {
        return commonCardInDeckUser2;
    }

    public ArrayList<SpecialCard> getSpecialCardsDeckUser2() {
        return specialCardsDeckUser2;
    }

    public ArrayList<CommonCard> getCloseCombatIsPlayedUser1() {
        return closeCombatIsPlayedUser1;
    }

    public ArrayList<CommonCard> getCommonCardsInDiscardUser1() {
        return commonCardsInDiscardUser1;
    }

    public ArrayList<SpecialCard> getSpecialCardsDiscardUser1() {
        return specialCardsDiscardUser1;
    }

    public ArrayList<CommonCard> getSiegeIsPlayedUser1() {
        return siegeIsPlayedUser1;
    }

    public ArrayList<CommonCard> getRangedIsPlayedUser1() {
        return rangedIsPlayedUser1;
    }

    public SpecialCard getSpecialFieldInCloseCombatUser1() {
        return specialFieldInCloseCombatUser1;
    }

    public void setSpecialFieldInCloseCombatUser1(SpecialCard specialFieldInCloseCombatUser1) {
        this.specialFieldInCloseCombatUser1 = specialFieldInCloseCombatUser1;
    }

    public SpecialCard getSpecialFieldInSiegeUser1() {
        return specialFieldInSiegeUser1;
    }

    public void setSpecialFieldInSiegeUser1(SpecialCard specialFieldInSiegeUser1) {
        this.specialFieldInSiegeUser1 = specialFieldInSiegeUser1;
    }

    public SpecialCard getSpecialFieldInRangedUser1() {
        return specialFieldInRangedUser1;
    }

    public void setSpecialFieldInRangedUser1(SpecialCard specialFieldInRangedUser1) {
        this.specialFieldInRangedUser1 = specialFieldInRangedUser1;
    }

    public User getUser2() {
        return user2;
    }

    public ArrayList<CommonCard> getCommonCardInBattleFieldUser2() {
        return commonCardInBattleFieldUser2;
    }

    public ArrayList<SpecialCard> getSpecialCardsBattleFieldUser2() {
        return specialCardsBattleFieldUser2;
    }

    public ArrayList<CommonCard> getCloseCombatIsPlayedUser2() {
        return closeCombatIsPlayedUser2;
    }

    public ArrayList<CommonCard> getCommonCardsInDiscardUser2() {
        return commonCardsInDiscardUser2;
    }

    public ArrayList<SpecialCard> getSpecialCardsDiscardUser2() {
        return specialCardsDiscardUser2;
    }

    public ArrayList<CommonCard> getSiegeIsPlayedUser2() {
        return siegeIsPlayedUser2;
    }

    public ArrayList<CommonCard> getRangedIsPlayedUser2() {
        return rangedIsPlayedUser2;
    }

    public SpecialCard getSpecialFieldInCloseCombatUser2() {
        return specialFieldInCloseCombatUser2;
    }

    public void setSpecialFieldInCloseCombatUser2(SpecialCard specialFieldInCloseCombatUser2) {
        this.specialFieldInCloseCombatUser2 = specialFieldInCloseCombatUser2;
    }

    public SpecialCard getSpecialFieldInSiegeUser2() {
        return specialFieldInSiegeUser2;
    }

    public void setSpecialFieldInSiegeUser2(SpecialCard specialFieldInSiegeUser2) {
        this.specialFieldInSiegeUser2 = specialFieldInSiegeUser2;
    }

    public SpecialCard getSpecialFieldInRangedUser2() {
        return specialFieldInRangedUser2;
    }

    public void setSpecialFieldInRangedUser2(SpecialCard specialFieldInRangedUser2) {
        this.specialFieldInRangedUser2 = specialFieldInRangedUser2;
    }

    public User getWhichUserTurn() {
        return whichUserTurn;
    }

    public void setWhichUserTurn(User whichUserTurn) {
        this.whichUserTurn = whichUserTurn;
    }

    public ArrayList<SpecialCard> getWeatherCards() {
        return weatherCards;
    }

    public void ChangeTurn() {
        if (whichUserTurn.equals(user1)) whichUserTurn = user2;
        else whichUserTurn = user1;
    }

}
