package Sample.CardEnums;

public enum Leader {
    KingBran("KingBran" , Faction.Skellige , "Units lose half of their strength in bad weather");
    ;
    private final String name;
    private final Faction faction;

    private final String ability;

    Leader(String name, Faction faction, String ability) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
    }

}
