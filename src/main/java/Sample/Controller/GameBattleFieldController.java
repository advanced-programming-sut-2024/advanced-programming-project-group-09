package Sample.Controller;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;
import Sample.Model.GameBattleField;
import Sample.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBattleFieldController {
//    static GameBattleFieldController instance;
//
//    public GameBattleFieldController getInstance() {
//        if (instance == null) instance = new GameBattleFieldController();
//        return instance;
//    }

    public GameBattleFieldController(GameBattleField gameBattleField) {
        this.gameBattleField = gameBattleField;
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
        List<Integer> usedIndexes = new ArrayList<>();

        for (int i = 0; i < 10 - specialCard; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(gameBattleField.getCommonCardInDeckUser1().size());
            } while (usedIndexes.contains(randomIndex));

            gameBattleField.getCommonCardInBattleFieldUser1().add(gameBattleField.getCommonCardInDeckUser1().get(randomIndex));
            gameBattleField.getCommonCardInBattleFieldUser2().add(gameBattleField.getCommonCardInDeckUser2().get(randomIndex));
            gameBattleField.getCommonCardInDeckUser1().remove(randomIndex);
            gameBattleField.getCommonCardInDeckUser2().remove(randomIndex);

            usedIndexes.add(randomIndex);
        }

        usedIndexes.clear();

        for (int i = 0; i < specialCard; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(gameBattleField.getSpecialCardsDeckUser1().size());
            } while (usedIndexes.contains(randomIndex));

            gameBattleField.getSpecialCardsBattleFieldUser1().add(gameBattleField.getSpecialCardsDeckUser1().get(randomIndex));
            gameBattleField.getSpecialCardsBattleFieldUser2().add(gameBattleField.getSpecialCardsDeckUser2().get(randomIndex));
            gameBattleField.getSpecialCardsDeckUser1().remove(randomIndex);
            gameBattleField.getSpecialCardsDeckUser2().remove(randomIndex);

            usedIndexes.add(randomIndex);
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
    public void putWeatherCardToSpecialFieldForWeatherCard(SpecialCard specialCard){

    }
}
