package Sample.CardEnums;

import Sample.View.LoginMenu;

import java.io.InputStream;
import java.util.Objects;

public enum Leader {
    // Northern Realms Leaders
    SiegeMaster("Siege Master", Faction.NorthernRealms, "Plays an 'Impenetrable Fog' card.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_silver.jpg"))),
    SteelForged("Steel-Forged", Faction.NorthernRealms, "Removes all weather effects ('Impenetrable Fog,' 'Biting Frost,' and 'Torrential Rain') from the battlefield.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_gold.jpg"))),
    KingOfTemeria("King of Temeria", Faction.NorthernRealms, "Doubles the strength of siege cards in a row unless there is a 'Commander's Horn' card in that row.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_copper.jpg"))),
    LordCommanderOfTheNorth("Lord Commander of the North", Faction.NorthernRealms, "If there are more than 10 strength points worth of siege cards on the opponent's side, reduce their strength by half.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_bronze.jpg"))),
    SonOfMedell("Son of Medell", Faction.NorthernRealms, "If there are more than 10 strength points worth of ranged cards on the opponent's side, reduce their strength by half.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_son_of_medell.jpg"))),

    // Nilfgaardian Empire Leaders
    WhiteFlame("White Flame", Faction.Nilfgaard, "Plays a 'Torrential Rain' card.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_silver.jpg"))),
    HisImperialMajesty("His Imperial Majesty", Faction.Nilfgaard, "Randomly look at three cards from the opponent's hand.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_copper.jpg"))),
    EmperorOfNilfgaard("Emperor of Nilfgaard", Faction.Nilfgaard, "Cancels the opponent's commander ability.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_bronze.jpg"))),
    TheRelentless("The Relentless", Faction.Nilfgaard, "Takes one card from the opponent's discard pile (cannot be a Hero card).", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_gold.jpg"))),
    InvaderOfTheNorth("Invader of the North", Faction.Nilfgaard, "Takes one card from the opponent's discard pile and returns it to the opponent's deck.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_invader_of_the_north.jpg"))),

    // Monsters Leaders
    BringerOfDeath("Bringer of Death", Faction.Monsters, "Doubles the strength of close combat cards in a row unless there is a 'Commander's Horn' card in that row.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_gold.jpg"))),
    KingOfTheWildHunt("King of the Wild Hunt", Faction.Monsters, "Takes one card from your own discard pile (cannot be a Hero card).", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_bronze.jpg"))),
    DestroyerOfWorlds("Destroyer of Worlds", Faction.Monsters, "Discard two cards from your hand and draw one new card from your deck.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_gold.jpg"))),
    CommanderOfTheRedRiders("Commander of the Red Riders", Faction.Monsters, "Plays a weather card from your hand.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_copper.jpg"))),
    TheTreacherous("The Treacherous", Faction.Monsters, "Doubles the strength of spy cards.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_the_treacherous.jpg"))),

    // Scoia'tael Leaders
    QueenOfDolBlathanna("Queen of Dol Blathanna", Faction.Scoiatael, "If there are more than 10 strength points worth of close combat cards on the opponent's side, reduce their strength by half.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_silver.jpg"))),
    TheBeautiful("The Beautiful", Faction.Scoiatael, "Doubles the strength of ranged combat cards in a row unless there is a 'Commander's Horn' card in that row.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_gold.jpg"))),
    DaisyOfTheValley("Daisy of the Valley", Faction.Scoiatael, "Randomly assign a new card to yourself from the discard pile.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_copper.jpg"))),
    PurebloodElf("Pureblood Elf", Faction.Scoiatael, "Plays a 'Biting Frost' card.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_bronze.jpg"))),
    HopeOfTheAenSeidhe("Hope of the Aen Seidhe", Faction.Scoiatael, "If there are agile units in the row, the highest strength cards in that row are doubled.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_hope_of_the_aen_seidhe.jpg"))),

    // Skellige Leaders
    CrachAnCraite("Crach an Craite", Faction.Skellige, "Resurrect one non-Hero card from your discard pile.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/skellige_crach_an_craite.jpg"))),
    KingBran("King Bran", Faction.Skellige, "Reduces the strength of all units on the battlefield by half but does not affect Hero cards.", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/skellige_king_bran.jpg")));

    private final String name;
    private final Faction faction;
    private final String ability;
    private final InputStream imagePath;

    Leader(String name, Faction faction, String ability, InputStream imagePath) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
        this.imagePath = imagePath;
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

    public InputStream getImagePath() {
        return imagePath;
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
