package Sample.CardEnums;

public enum Faction {
    Skellige("Skellige", "Two random cards from the graveyard are placed on the battle field at third round"),
    ;
    private final String factionName;
    private final String ability;
    Faction(String factionName, String ability) {
        this.factionName = factionName;
        this.ability = ability;
    }
}
