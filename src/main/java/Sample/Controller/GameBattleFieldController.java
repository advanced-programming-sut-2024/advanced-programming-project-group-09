package Sample.Controller;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;
import Sample.Model.GameBattleField;
import Sample.Model.User;

import java.util.Random;

public class GameBattleFieldController {
    static GameBattleFieldController instance;

    public GameBattleFieldController getInstance() {
        if (instance == null) instance = new GameBattleFieldController();
        return instance;
    }

    GameBattleField gameBattleField;

    public void cloneChosenDeckForUsingInGame() {

        User user1 = gameBattleField.getUser1();
        User user2 = gameBattleField.getUser2();

        for (CommonCard commonCard : user1.getCommonCardsInDeck()) {
            gameBattleField.getCommonCardInDeckUser1().add(commonCard);
        }
        for (CommonCard commonCard : user2.getCommonCardsInDeck()) {
            gameBattleField.getCommonCardInDeckUser2().add(commonCard);
        }
        for (SpecialCard specialCard : user1.getSpecialCardsInDeck()) {
            gameBattleField.getSpecialCardsDeckUser1().add(specialCard);
        }
        for (SpecialCard specialCard : user2.getSpecialCardsInDeck()) {
            gameBattleField.getSpecialCardsDeckUser2().add(specialCard);
        }
    }

    public void giveRandomInitialCards() {
        Random random = new Random();
        int specialCard = random.nextInt(1, 5);
        for (int i = 0; i < 10 - specialCard; i++) {
            gameBattleField.getCommonCardInBattleFieldUser1().add(gameBattleField.getCommonCardInDeckUser1().get(2 * i));
            gameBattleField.getCommonCardInBattleFieldUser2().add(gameBattleField.getCommonCardInDeckUser2().get(2 * i));
            gameBattleField.getCommonCardInDeckUser1().remove(gameBattleField.getCommonCardInDeckUser1().get(2 * i));
            gameBattleField.getCommonCardInDeckUser2().remove(gameBattleField.getCommonCardInDeckUser2().get(2 * i));
        }
        for (int i = 0; i < specialCard; i++) {
            gameBattleField.getSpecialCardsBattleFieldUser1().add(gameBattleField.getSpecialCardsDeckUser1().get(2 * i));
            gameBattleField.getSpecialCardsBattleFieldUser2().add(gameBattleField.getSpecialCardsDeckUser2().get(2 * i));
            gameBattleField.getSpecialCardsDeckUser1().remove(gameBattleField.getSpecialCardsDeckUser1().get(2 * i));
            gameBattleField.getSpecialCardsDeckUser2().remove(gameBattleField.getSpecialCardsDeckUser2().get(2 * i));
        }

    }

    public void removeCommonCardRanged(CommonCard commonCard) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            gameBattleField.getRangedIsPlayedUser1().remove(commonCard);
            gameBattleField.getCommonCardsInDiscardUser1().add(commonCard);
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
        gameBattleField.getRangedIsPlayedUser2().remove(commonCard);
        gameBattleField.getCommonCardsInDiscardUser2().add(commonCard);

    }


    public void removeCommonCardSiege(CommonCard commonCard) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            gameBattleField.getSiegeIsPlayedUser1().remove(commonCard);
            gameBattleField.getCommonCardsInDiscardUser1().add(commonCard);
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
        gameBattleField.getSiegeIsPlayedUser2().remove(commonCard);
        gameBattleField.getCommonCardsInDiscardUser2().add(commonCard);

    }

    public void removeCommonCardCloseCombat(CommonCard commonCard) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            gameBattleField.getCloseCombatIsPlayedUser1().remove(commonCard);
            gameBattleField.getCommonCardsInDiscardUser1().add(commonCard);
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
        gameBattleField.getCloseCombatIsPlayedUser2().remove(commonCard);
        gameBattleField.getCommonCardsInDiscardUser2().add(commonCard);
    }

    public void putCommonCardRanged(CommonCard commonCard, boolean applySpyAbility) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (applySpyAbility) {

            if (userToPlay.getUsername().equals(gameBattleField.getUser2().getUsername())) {
                gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
                gameBattleField.getRangedIsPlayedUser1().add(commonCard);
                gameBattleField.getCommonCardInDeckUser1().remove(commonCard);
                return;
            }
            gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
            gameBattleField.getRangedIsPlayedUser2().add(commonCard);
            gameBattleField.getCommonCardInDeckUser2().remove(commonCard);

            return;
        }
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
            gameBattleField.getRangedIsPlayedUser1().add(commonCard);
            gameBattleField.getCommonCardInDeckUser1().remove(commonCard);
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
        gameBattleField.getRangedIsPlayedUser2().add(commonCard);
        gameBattleField.getCommonCardInDeckUser2().remove(commonCard);

        return;
    }

    public void putCommonCardCloseCombat(CommonCard commonCard, boolean applySpyAbility) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (applySpyAbility) {

            if (userToPlay.getUsername().equals(gameBattleField.getUser2().getUsername())) {
                gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
                gameBattleField.getCloseCombatIsPlayedUser1().add(commonCard);
                gameBattleField.getCommonCardInDeckUser1().remove(commonCard);
                return;
            }
            gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
            gameBattleField.getCloseCombatIsPlayedUser2().add(commonCard);
            gameBattleField.getCommonCardInDeckUser2().remove(commonCard);
            return;

        }
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
            gameBattleField.getCloseCombatIsPlayedUser1().add(commonCard);
            gameBattleField.getCommonCardInDeckUser1().remove(commonCard);
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
        gameBattleField.getCloseCombatIsPlayedUser2().add(commonCard);
        gameBattleField.getCommonCardInDeckUser2().remove(commonCard);
    }

    public void putCommonCardSiege(CommonCard commonCard, boolean applySpyAbility) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (applySpyAbility) {
            if (userToPlay.getUsername().equals(gameBattleField.getUser2().getUsername())) {
                gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
                gameBattleField.getSiegeIsPlayedUser1().add(commonCard);
                gameBattleField.getCommonCardInDeckUser1().remove(commonCard);
                return;
            }
            gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
            gameBattleField.getSiegeIsPlayedUser2().add(commonCard);
            gameBattleField.getCommonCardInDeckUser2().remove(commonCard);
            return;
        }
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().add(commonCard);
            gameBattleField.getSiegeIsPlayedUser1().add(commonCard);
            gameBattleField.getCommonCardInDeckUser1().remove(commonCard);
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().add(commonCard);
        gameBattleField.getSiegeIsPlayedUser2().add(commonCard);
        gameBattleField.getCommonCardInDeckUser2().remove(commonCard);
    }


    public void putSpecialCardInSpecialFieldRanged(SpecialCard specialCard) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.setSpecialFieldInRangedUser1(specialCard);
            gameBattleField.getSpecialCardsDeckUser1().remove(specialCard);
            return;
        }
        gameBattleField.setSpecialFieldInRangedUser2(specialCard);
        gameBattleField.getSpecialCardsDeckUser2().remove(specialCard);
    }

    public void putSpecialCardInSpecialFieldSiege(SpecialCard specialCard) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.setSpecialFieldInSiegeUser1(specialCard);
            gameBattleField.getSpecialCardsDeckUser1().remove(specialCard);
            return;
        }
        gameBattleField.setSpecialFieldInSiegeUser2(specialCard);
        gameBattleField.getSpecialCardsDeckUser2().remove(specialCard);
    }

    public void putSpecialCardInSpecialFieldCloseCombat(SpecialCard specialCard) {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.setSpecialFieldInCloseCombatUser1(specialCard);
            gameBattleField.getSpecialCardsDeckUser1().remove(specialCard);
            return;
        }
        gameBattleField.setSpecialFieldInCloseCombatUser2(specialCard);
        gameBattleField.getSpecialCardsDeckUser2().remove(specialCard);
    }

    public void putWeatherCardToSpecialFieldForWeatherCard(SpecialCard specialCard) {

    }

    public void passRound() {
        User userToPlay = gameBattleField.getWhichUserTurn();
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.setPassedUser1(true);
            return;
        }
        gameBattleField.setPassedUser2(true);
    }
}
