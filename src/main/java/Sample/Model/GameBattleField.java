package Sample.Model;

import Sample.CardEnums.SpecialCard;

import java.util.ArrayList;

public class GameBattleField {
    private final User user1;
    private final User user2;
    private final ArrayList<SpecialCard> weatherCards = new ArrayList<>();

    public GameBattleField(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
