package Sample.CardEnums;

public enum SpecialCard {
    Mardroeme("Mardroeme", "Mardroeme", 3),
    CommandersHorn("Commander's Horn", "Double power", 3),
    Scorch("Scorch", "Destroy highest value", 2),
    Decoy("Decoy", "Decoy", 3),
    BitingFrost("Biting Frost", "Biting frost", 3),
    ImpenetrableFog("Impenetrable Fog", "Impenetrable fog", 3),
    TorrentialRain("Torrential Rain", "Torrential rain", 3),
    ;

    private final String cardName;
    private final String ability;
    private int count;

    SpecialCard(String cardName, String ability, int count) {
        this.cardName = cardName;
        this.ability = ability;
        this.count = count;
    }

    public String getCardName() {
        return cardName;
    }

    public String getAbility() {
        return ability;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void decreaseOneCount() {
        this.count--;
    }

    @Override
    public String toString() {
        return "SpecialCard{" +
                "cardName='" + cardName + '\'' +
                ", ability='" + ability + '\'' +
                ", count=" + count +
                '}';
    }
}