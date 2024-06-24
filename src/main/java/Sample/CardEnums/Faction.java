package Sample.CardEnums;

public enum Faction {
    Skellige("Skellige", "Draws 2 random cards from the graveyard at the start of the third round"),
    NorthernRealms("Northern Realms", "Draws a card from your deck whenever you win a round"),
    Nilfgaard("Nilfgaard", "Wins any round that ends in a draw"),
    Scoiatael("Scoia'tael", "Decide who takes the first turn in each round"),
    Monsters("Monsters", "Keep a random unit card on the battlefield after each round"),
    ;

    private final String factionName;
    private final String ability;

    Faction(String factionName, String ability) {
        this.factionName = factionName;
        this.ability = ability;
    }

    public String getFactionName() {
        return factionName;
    }

    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "factionName='" + factionName + '\'' +
                ", ability='" + ability + '\'' +
                '}';
    }
}
