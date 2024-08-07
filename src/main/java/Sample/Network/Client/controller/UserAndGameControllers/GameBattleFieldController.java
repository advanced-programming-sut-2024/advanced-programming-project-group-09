package Sample.Network.Client.controller.UserAndGameControllers;

import Sample.Network.Client.CardEnums.CommonCard;
import Sample.Network.Client.CardEnums.SpecialCard;
import Sample.Network.Client.model.GameBattleField;
import Sample.Network.Client.model.Gwent;
import Sample.Network.Client.model.User.User;

import java.util.ArrayList;
import java.util.Comparator;
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

        User user1 = Gwent.getInstance().getUser(gameBattleField.getUser1().getUsername());
        User user2 = Gwent.getInstance().getUser(gameBattleField.getUser2().getUsername());

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
        int specialCard = random.nextInt(1, Math.min(Math.min(gameBattleField.getSpecialCardsDeckUser1().size(), gameBattleField.getSpecialCardsDeckUser2().size()), 5));

        for (int i = 0; i < 10 - specialCard; i++) {
            int randomIndex = random.nextInt(0, gameBattleField.getCommonCardInDeckUser1().size());
            int randomIndex2 = random.nextInt(0, gameBattleField.getCommonCardInDeckUser2().size());
            gameBattleField.getCommonCardInBattleFieldUser1().add(gameBattleField.getCommonCardInDeckUser1().get(randomIndex));
            gameBattleField.getCommonCardInBattleFieldUser2().add(gameBattleField.getCommonCardInDeckUser2().get(randomIndex2));
            gameBattleField.getCommonCardInDeckUser1().remove(randomIndex);
            gameBattleField.getCommonCardInDeckUser2().remove(randomIndex2);
        }


        for (int i = 0; i < specialCard; i++) {
            int randomIndex = random.nextInt(0, gameBattleField.getSpecialCardsDeckUser1().size());
            int randomIndex2 = random.nextInt(0, gameBattleField.getSpecialCardsDeckUser2().size());
            if (gameBattleField.getSpecialCardsDeckUser1().get(randomIndex) == SpecialCard.Decoy) {
                gameBattleField.getCommonCardInBattleFieldUser1().add(CommonCard.Decoy);
                System.out.println(20);
            }
            else {
                gameBattleField.getSpecialCardsBattleFieldUser1().add(gameBattleField.getSpecialCardsDeckUser1().get(randomIndex));
            }
            if (gameBattleField.getSpecialCardsDeckUser2().get(randomIndex) == SpecialCard.Decoy) {
                gameBattleField.getCommonCardInBattleFieldUser2().add(CommonCard.Decoy);
                System.out.println(10);
            }
            else {
                gameBattleField.getSpecialCardsBattleFieldUser2().add(gameBattleField.getSpecialCardsDeckUser2().get(randomIndex2));
            }
            gameBattleField.getSpecialCardsDeckUser1().remove(randomIndex);
            gameBattleField.getSpecialCardsDeckUser2().remove(randomIndex2);
        }
        sort();
    }

    public void sort() {
        sortCommonByScoreThenName(gameBattleField.getCommonCardInBattleFieldUser1());
        sortCommonByScoreThenName(gameBattleField.getCommonCardInBattleFieldUser2());
        sortCommonByScoreThenName(gameBattleField.getRangedIsPlayedUser1());
        sortCommonByScoreThenName(gameBattleField.getRangedIsPlayedUser2());
        sortCommonByScoreThenName(gameBattleField.getCloseCombatIsPlayedUser1());
        sortCommonByScoreThenName(gameBattleField.getCloseCombatIsPlayedUser2());
        sortCommonByScoreThenName(gameBattleField.getSiegeIsPlayedUser1());
        sortCommonByScoreThenName(gameBattleField.getSiegeIsPlayedUser2());
        sortSpecial(gameBattleField.getSpecialCardsBattleFieldUser1());
        sortSpecial(gameBattleField.getSpecialCardsBattleFieldUser2());
    }

    public void removeCommonCardRanged(CommonCard commonCard) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getRangedIsPlayedUser1().remove(commonCard);
            gameBattleField.getCommonCardsInDiscardUser1().add(commonCard);
            sort();
            return;
        }
        gameBattleField.getRangedIsPlayedUser2().remove(commonCard);
        gameBattleField.getCommonCardsInDiscardUser2().add(commonCard);
        sort();

    }


    public void removeCommonCardSiege(CommonCard commonCard) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getSiegeIsPlayedUser1().remove(commonCard);
            gameBattleField.getCommonCardsInDiscardUser1().add(commonCard);
            sort();
            return;
        }
        gameBattleField.getSiegeIsPlayedUser2().remove(commonCard);
        gameBattleField.getCommonCardsInDiscardUser2().add(commonCard);
        sort();

    }

    public void removeCommonCardCloseCombat(CommonCard commonCard) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCloseCombatIsPlayedUser1().remove(commonCard);
            gameBattleField.getCommonCardsInDiscardUser1().add(commonCard);
            sort();
            return;
        }
        gameBattleField.getCloseCombatIsPlayedUser2().remove(commonCard);
        gameBattleField.getCommonCardsInDiscardUser2().add(commonCard);
        sort();
    }

    public void putCommonCardRanged(CommonCard commonCard, boolean applySpyAbility) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (applySpyAbility) {

            if (userToPlay.getUsername().equals(gameBattleField.getUser2().getUsername())) {
                gameBattleField.getRangedIsPlayedUser1().add(commonCard);
                gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
                sort();
                return;
            }
            gameBattleField.getRangedIsPlayedUser2().add(commonCard);
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);

            sort();
            return;
        }
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getRangedIsPlayedUser1().add(commonCard);
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            sort();
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
        gameBattleField.getRangedIsPlayedUser2().add(commonCard);

        sort();

    }

    public void putCommonCardCloseCombat(CommonCard commonCard, boolean applySpyAbility) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (applySpyAbility) {

            if (userToPlay.getUsername().equals(gameBattleField.getUser2().getUsername())) {
                gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
                gameBattleField.getCloseCombatIsPlayedUser1().add(commonCard);
                sort();
                return;
            }
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            gameBattleField.getCloseCombatIsPlayedUser2().add(commonCard);
            sort();
            return;

        }
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            gameBattleField.getCloseCombatIsPlayedUser1().add(commonCard);
            sort();
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
        gameBattleField.getCloseCombatIsPlayedUser2().add(commonCard);
        sort();
    }

    public void putCommonCardSiege(CommonCard commonCard, boolean applySpyAbility) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (applySpyAbility) {
            if (userToPlay.getUsername().equals(gameBattleField.getUser2().getUsername())) {
                gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
                gameBattleField.getSiegeIsPlayedUser1().add(commonCard);
                sort();
                return;
            }
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            gameBattleField.getSiegeIsPlayedUser2().add(commonCard);
            sort();
            return;
        }
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
            gameBattleField.getSiegeIsPlayedUser1().add(commonCard);
            sort();
            return;
        }
        gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
        gameBattleField.getSiegeIsPlayedUser2().add(commonCard);
        sort();
    }


    public void putSpecialCardInSpecialFieldRanged(SpecialCard specialCard) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.setSpecialFieldInRangedUser1(specialCard);
            gameBattleField.getSpecialCardsBattleFieldUser1().remove(specialCard);
            sort();
            return;
        }
        gameBattleField.setSpecialFieldInRangedUser2(specialCard);
        gameBattleField.getSpecialCardsBattleFieldUser2().remove(specialCard);
        sort();
    }

    public void putSpecialCardInSpecialFieldSiege(SpecialCard specialCard) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.setSpecialFieldInSiegeUser1(specialCard);
            gameBattleField.getSpecialCardsBattleFieldUser1().remove(specialCard);
            sort();
            return;
        }
        gameBattleField.setSpecialFieldInSiegeUser2(specialCard);
        gameBattleField.getSpecialCardsBattleFieldUser2().remove(specialCard);
        sort();
    }

    public void putSpecialCardInSpecialFieldCloseCombat(SpecialCard specialCard) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.setSpecialFieldInCloseCombatUser1(specialCard);
            gameBattleField.getSpecialCardsBattleFieldUser1().remove(specialCard);
            sort();
            return;
        }
        gameBattleField.setSpecialFieldInCloseCombatUser2(specialCard);
        gameBattleField.getSpecialCardsBattleFieldUser2().remove(specialCard);
        sort();
    }

    public void putWeatherCardToSpecialFieldForWeatherCard(SpecialCard specialCard) {
        gameBattleField.getWeatherCards().add(specialCard);
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            gameBattleField.getSpecialCardsBattleFieldUser1().remove(specialCard);
            sort();
            return;
        }
        gameBattleField.getSpecialCardsBattleFieldUser2().remove(specialCard);
        sort();
    }

    public void removeWeatherCardToSpecialFieldForWeatherCard(SpecialCard specialCard) {
        gameBattleField.getWeatherCards().remove(specialCard);
    }

    public void spyAbility() {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            giveCardThroughSpyAbilityUser1();
            return;
        }
        giveCardThroughSpyAbilityUser2();
    }

    private void giveCardThroughSpyAbilityUser2() {
        Random random = new Random();
        int specialCard = random.nextInt(0, Math.min(gameBattleField.getSpecialCardsDeckUser2().size(), 3));

        for (int i = 0; i < 2 - specialCard; i++) {
            int randomIndex = random.nextInt(0, gameBattleField.getCommonCardInDeckUser2().size());
            gameBattleField.getCommonCardInBattleFieldUser2().add(gameBattleField.getCommonCardInDeckUser2().get(randomIndex));
            gameBattleField.getCommonCardInDeckUser2().remove(randomIndex);
        }

        for (int i = 0; i < specialCard; i++) {
            int randomIndex = random.nextInt(0, gameBattleField.getSpecialCardsDeckUser2().size());
            gameBattleField.getSpecialCardsBattleFieldUser2().add(gameBattleField.getSpecialCardsDeckUser2().get(randomIndex));
            gameBattleField.getSpecialCardsDeckUser2().remove(randomIndex);
        }
        sort();
    }

    private void giveCardThroughSpyAbilityUser1() {
        Random random = new Random();
        int specialCard = random.nextInt(0, Math.min(gameBattleField.getSpecialCardsDeckUser1().size(), 3));

        for (int i = 0; i < 2 - specialCard; i++) {
            int randomIndex = random.nextInt(0, gameBattleField.getCommonCardInDeckUser1().size());
            gameBattleField.getCommonCardInBattleFieldUser1().add(gameBattleField.getCommonCardInDeckUser1().get(randomIndex));
            gameBattleField.getCommonCardInDeckUser1().remove(randomIndex);
        }

        for (int i = 0; i < specialCard; i++) {
            int randomIndex = random.nextInt(0, gameBattleField.getSpecialCardsDeckUser1().size());
            gameBattleField.getSpecialCardsBattleFieldUser1().add(gameBattleField.getSpecialCardsDeckUser1().get(randomIndex));
            gameBattleField.getSpecialCardsDeckUser1().remove(randomIndex);
        }
        sort();
    }

    public void bondAbility(CommonCard cardPut) {
        User userToPlay = Gwent.getInstance().getUser(gameBattleField.getWhichUserTurn().getUsername());
        if (userToPlay.getUsername().equals(gameBattleField.getUser1().getUsername())) {
            for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser1().size(); i++) {
                CommonCard commonCard = gameBattleField.getCommonCardInBattleFieldUser1().get(i);
                String playField = commonCard.getPlayField();
                if ((commonCard.getCardName().equals(cardPut.getCardName()) || commonCard.getCardName().substring(0, 4).equals(cardPut.getCardName().substring(0, 4)))
                        && commonCard.getAbility().contains("Muster")) {
                    switch (playField) {
                        case "Close Combat" -> gameBattleField.getCloseCombatIsPlayedUser1().add(commonCard);
                        case "Ranged" -> gameBattleField.getRangedIsPlayedUser1().add(commonCard);
                        case "Siege" -> gameBattleField.getSiegeIsPlayedUser1().add(commonCard);
                    }
                    gameBattleField.getCommonCardInBattleFieldUser1().remove(commonCard);
                    i -= 1;
                }
            }
            for (int i = 0; i < gameBattleField.getCommonCardInDeckUser1().size(); i++) {
                CommonCard commonCard = gameBattleField.getCommonCardInDeckUser1().get(i);
                String playField = commonCard.getPlayField();
                if ((commonCard.getCardName().equals(cardPut.getCardName()) || commonCard.getCardName().substring(0, 4).equals(cardPut.getCardName().substring(0, 4)))
                        && commonCard.getAbility().contains("Muster")) {
                    switch (playField) {
                        case "Close Combat" -> gameBattleField.getCloseCombatIsPlayedUser1().add(commonCard);
                        case "Ranged" -> gameBattleField.getRangedIsPlayedUser1().add(commonCard);
                        case "Siege" -> gameBattleField.getSiegeIsPlayedUser1().add(commonCard);
                    }
                    gameBattleField.getCommonCardInDeckUser1().remove(commonCard);
                    i -= 1;
                }
            }
            return;
        }
        for (int i = 0; i < gameBattleField.getCommonCardInBattleFieldUser2().size(); i++) {
            CommonCard commonCard = gameBattleField.getCommonCardInBattleFieldUser2().get(i);
            String playField = commonCard.getPlayField();
            if ((commonCard.getCardName().equals(cardPut.getCardName()) || commonCard.getCardName().substring(0, 4).equals(cardPut.getCardName().substring(0, 4)))
                    && commonCard.getAbility().contains("Muster")) {
                switch (playField) {
                    case "Close Combat" -> gameBattleField.getCloseCombatIsPlayedUser2().add(commonCard);
                    case "Ranged" -> gameBattleField.getRangedIsPlayedUser2().add(commonCard);
                    case "Siege" -> gameBattleField.getSiegeIsPlayedUser2().add(commonCard);
                }
                gameBattleField.getCommonCardInBattleFieldUser2().remove(commonCard);
                i -= 1;
            }
        }
        for (int i = 0; i < gameBattleField.getCommonCardInDeckUser2().size(); i++) {
            CommonCard commonCard = gameBattleField.getCommonCardInDeckUser2().get(i);
            String playField = commonCard.getPlayField();
            if ((commonCard.getCardName().equals(cardPut.getCardName()) || commonCard.getCardName().substring(0, 4).equals(cardPut.getCardName().substring(0, 4)))
                    && commonCard.getAbility().contains("Muster")) {
                switch (playField) {
                    case "Close Combat" -> gameBattleField.getCloseCombatIsPlayedUser2().add(commonCard);
                    case "Ranged" -> gameBattleField.getRangedIsPlayedUser2().add(commonCard);
                    case "Siege" -> gameBattleField.getSiegeIsPlayedUser2().add(commonCard);
                }
                gameBattleField.getCommonCardInDeckUser2().remove(commonCard);
                i -= 1;
            }
        }
    }

    public void sortSpecial(ArrayList<SpecialCard> specialCards) {
        specialCards.sort(Comparator.comparing(SpecialCard::getCardName));
    }

    public void sortCommonByScoreThenName(ArrayList<CommonCard> commonCards) {
        commonCards.sort(Comparator.comparing(CommonCard::getScore).thenComparing(Comparator.comparing(CommonCard::getCardName)));
    }
}