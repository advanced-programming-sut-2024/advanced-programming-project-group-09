package Sample.CardEnums;

public enum Leader {
    // Northern Realms Leaders
    SiegeMaster("Siege Master", Faction.NorthernRealms, "Plays an 'Impenetrable Fog' card."),
    SteelForged("Steel-Forged", Faction.NorthernRealms, "Removes all weather effects ('Impenetrable Fog,' 'Biting Frost,' and 'Torrential Rain') from the battlefield."),
    KingOfTemeria("King of Temeria", Faction.NorthernRealms, "Doubles the strength of siege cards in a row unless there is a 'Commander's Horn' card in that row."),
    LordCommanderOfTheNorth("Lord Commander of the North", Faction.NorthernRealms, "If there are more than 10 strength points worth of siege cards on the opponent's side, reduce their strength by half."),
    SonOfMedell("Son of Medell", Faction.NorthernRealms, "If there are more than 10 strength points worth of ranged cards on the opponent's side, reduce their strength by half."),

    // Nilfgaardian Empire Leaders
    WhiteFlame("White Flame", Faction.Nilfgaard, "Plays a 'Torrential Rain' card."),
    HisImperialMajesty("His Imperial Majesty", Faction.Nilfgaard, "Randomly look at three cards from the opponent's hand."),
    EmperorOfNilfgaard("Emperor of Nilfgaard", Faction.Nilfgaard, "Cancels the opponent's commander ability."),
    TheRelentless("The Relentless", Faction.Nilfgaard, "Takes one card from the opponent's discard pile (cannot be a Hero card)."),
    InvaderOfTheNorth("Invader of the North", Faction.Nilfgaard, "Takes one card from the opponent's discard pile and returns it to the opponent's deck."),

    // Monsters Leaders
    BringerOfDeath("Bringer of Death", Faction.Monsters, "Doubles the strength of close combat cards in a row unless there is a 'Commander's Horn' card in that row."),
    KingOfTheWildHunt("King of the Wild Hunt", Faction.Monsters, "Takes one card from your own discard pile (cannot be a Hero card)."),
    DestroyerOfWorlds("Destroyer of Worlds", Faction.Monsters, "Discard two cards from your hand and draw one new card from your deck."),
    CommanderOfTheRedRiders("Commander of the Red Riders", Faction.Monsters, "Plays a weather card from your hand."),
    TheTreacherous("The Treacherous", Faction.Monsters, "Doubles the strength of spy cards."),

    // Scoia'tael Leaders
    QueenOfDolBlathanna("Queen of Dol Blathanna", Faction.Scoiatael, "If there are more than 10 strength points worth of close combat cards on the opponent's side, reduce their strength by half."),
    TheBeautiful("The Beautiful", Faction.Scoiatael, "Doubles the strength of ranged combat cards in a row unless there is a 'Commander's Horn' card in that row."),
    DaisyOfTheValley("Daisy of the Valley", Faction.Scoiatael, "Randomly assign a new card to yourself from the discard pile."),
    PurebloodElf("Pureblood Elf", Faction.Scoiatael, "Plays a 'Biting Frost' card."),
    HopeOfTheAenSeidhe("Hope of the Aen Seidhe", Faction.Scoiatael, "If there are agile units in the row, the highest strength cards in that row are doubled."),

    // Skellige Leaders
    CrachAnCraite("Crach an Craite", Faction.Skellige, "Resurrect one non-Hero card from your discard pile."),
    KingBran("King Bran", Faction.Skellige, "Reduces the strength of all units on the battlefield by half but does not affect Hero cards.");

    private final String name;
    private final Faction faction;
    private final String ability;

    Leader(String name, Faction faction, String ability) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public Faction getFaction() {
        return faction;
    }

    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "name='" + name + '\'' +
                ", faction=" + faction +
                ", ability='" + ability + '\'' +
                '}';
    }
}
