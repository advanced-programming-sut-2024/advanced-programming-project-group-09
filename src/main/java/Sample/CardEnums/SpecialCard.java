package Sample.CardEnums;

public enum SpecialCard {
    ;
    private final String cardName;
    private final String ability;

    int count;

    SpecialCard(String cardName, String ability, int count) {
        this.cardName = cardName;
        this.ability = ability;
        this.count = count;
    }
}
