package Sample.CardEnums;

import Sample.View.LoginMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Objects;

public enum Leader {
    // Northern Realms Leaders
    SiegeMaster("Siege Master", Faction.NorthernRealms, "Plays an 'Impenetrable Fog' card.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_silver.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/realms_foltest_silver.jpg")))),
    SteelForged("Steel-Forged", Faction.NorthernRealms, "Removes all weather effects ('Impenetrable Fog,' 'Biting Frost,' and 'Torrential Rain') from the battlefield.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_gold.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/realms_foltest_gold.jpg")))),
    KingOfTemeria("King of Temeria", Faction.NorthernRealms, "Doubles the strength of siege cards in a row unless there is a 'Commander's Horn' card in that row.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_copper.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/realms_foltest_copper.jpg")))),
    LordCommanderOfTheNorth("Lord Commander of the North", Faction.NorthernRealms, "If there are more than 10 strength points worth of siege cards on the opponent's side, reduce their strength by half.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_bronze.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/realms_foltest_bronze.jpg")))),
    SonOfMedell("Son of Medell", Faction.NorthernRealms, "If there are more than 10 strength points worth of ranged cards on the opponent's side, reduce their strength by half.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_son_of_medell.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/realms_foltest_son_of_medell.jpg")))),

    // Nilfgaardian Empire Leaders
    WhiteFlame("White Flame", Faction.Nilfgaard, "Plays a 'Torrential Rain' card.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_silver.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_silver.jpg")))),
    HisImperialMajesty("His Imperial Majesty", Faction.Nilfgaard, "Randomly look at three cards from the opponent's hand.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_copper.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/nilfgaard_emhyr_copper.jpg")))),
    EmperorOfNilfgaard("Emperor of Nilfgaard", Faction.Nilfgaard, "Cancels the opponent's commander ability.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_bronze.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/nilfgaard_emhyr_bronze.jpg")))),
    TheRelentless("The Relentless", Faction.Nilfgaard, "Takes one card from the opponent's discard pile (cannot be a Hero card).", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_gold.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/nilfgaard_emhyr_gold.jpg")))),
    InvaderOfTheNorth("Invader of the North", Faction.Nilfgaard, "Takes one card from the opponent's discard pile and returns it to the opponent's deck.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_invader_of_the_north.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/nilfgaard_emhyr_invader_of_the_north.jpg")))),

    // Monsters Leaders
    BringerOfDeath("Bringer of Death", Faction.Monsters, "Doubles the strength of close combat cards in a row unless there is a 'Commander's Horn' card in that row.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_silver.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/monsters_eredin_silver.jpg")))),
    KingOfTheWildHunt("King of the Wild Hunt", Faction.Monsters, "Takes one card from your own discard pile (cannot be a Hero card).", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_bronze.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/monsters_eredin_bronze.jpg")))),
    DestroyerOfWorlds("Destroyer of Worlds", Faction.Monsters, "Discard two cards from your hand and draw one new card from your deck.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_gold.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/monsters_eredin_gold.jpg")))),
    CommanderOfTheRedRiders("Commander of the Red Riders", Faction.Monsters, "Plays a weather card from your hand.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_copper.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/monsters_eredin_copper.jpg")))),
    TheTreacherous("The Treacherous", Faction.Monsters, "Doubles the strength of spy cards.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_the_treacherous.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/monsters_eredin_the_treacherous.jpg")))),

    // Scoia'tael Leaders
    QueenOfDolBlathanna("Queen of Dol Blathanna", Faction.Scoiatael, "If there are more than 10 strength points worth of close combat cards on the opponent's side, reduce their strength by half.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_silver.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/scoiatael_francesca_silver.jpg")))),
    TheBeautiful("The Beautiful", Faction.Scoiatael, "Doubles the strength of ranged combat cards in a row unless there is a 'Commander's Horn' card in that row.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_gold.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/scoiatael_francesca_gold.jpg")))),
    DaisyOfTheValley("Daisy of the Valley", Faction.Scoiatael, "Randomly assign a new card to yourself from the discard pile.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_copper.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/scoiatael_francesca_copper.jpg")))),
    PurebloodElf("Pureblood Elf", Faction.Scoiatael, "Plays a 'Biting Frost' card.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_bronze.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/scoiatael_francesca_bronze.jpg")))),
    HopeOfTheAenSeidhe("Hope of the Aen Seidhe", Faction.Scoiatael, "If there are agile units in the row, the highest strength cards in that row are doubled.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_hope_of_the_aen_seidhe.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/scoiatael_francesca_hope_of_the_aen_seidhe.jpg")))),

    // Skellige Leaders
    CrachAnCraite("Crach an Craite", Faction.Skellige, "Resurrect one non-Hero card from your discard pile.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/skellige_crach_an_craite.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/skellige_crach_an_craite.jpg")))),
    KingBran("King Bran", Faction.Skellige, "Reduces the strength of all units on the battlefield by half but does not affect Hero cards.", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/skellige_king_bran.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/skellige_king_bran.jpg"))));

    private final String name;
    private final Faction faction;
    private final String ability;
    private final Image image;
    private final Image imageForGame;

    Leader(String name, Faction faction, String ability, Image image, Image imageForGame) {
        this.name = name;
        this.faction = faction;
        this.ability = ability;
        this.image = image;
        this.imageForGame = imageForGame;
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

    public Image getImage() {
        return image;
    }

    public Image getImageForGame() {
        return imageForGame;
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
