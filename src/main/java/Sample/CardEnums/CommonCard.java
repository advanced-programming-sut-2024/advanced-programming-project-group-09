package Sample.CardEnums;

import javafx.scene.image.Image;

public enum CommonCard {
    // Nilfgaard Cards
    Albrich("Albrich", Faction.Nilfgaard, "", 2, "Ranged", false, 1),

    ImperaBrigadeGuard("Impera Brigade Guard", Faction.Nilfgaard, "Tight Bond", 3, "Close Combat", false, 4, new Image()),

    StefanSkellen("Stefan Skellen", Faction.Nilfgaard, "Spy", 9, "Close Combat", false, 1), YoungEmissary("Young Emissary", Faction.Nilfgaard, "Tight Bond", 5, "Close Combat", false, 2),

    CahirMawrDyffrynAepCeallach("Cahir Mawr Dyffryn aep Ceallach", Faction.Nilfgaard, "", 6, "Close Combat", false, 1), VattierDeRideaux("Vattier de Rideaux", Faction.Nilfgaard, "Spy", 4, "Close Combat", false, 1),

    MennoCoehoorn("Menno Coehoorn", Faction.Nilfgaard, "Hero Medic", 10, "Close Combat", true, 1), Puttkammer("Puttkammer", Faction.Nilfgaard, "", 3, "Ranged", false, 1),

    BlackInfantryArcher("Black Infantry Archer", Faction.Nilfgaard, "", 10, "Ranged", false, 2), TiborEggebracht("Tibor Eggebracht", Faction.Nilfgaard, "Hero", 10, "Ranged", true, 1),

    RenualdAepMatsen("Renuald aep Matsen", Faction.Nilfgaard, "", 5, "Ranged", false, 1), FringillaVigo("Fringilla Vigo", Faction.Nilfgaard, "", 6, "Ranged", false, 1),

    RottenMangonel("Rotten Mangonel", Faction.Nilfgaard, "", 3, "Siege", false, 1), ZerrikanianFireScorpion("Zerrikanian Fire Scorpion", Faction.Nilfgaard, "", 5, "Siege", false, 1),

    SiegeEngineer("Siege Engineer", Faction.Nilfgaard, "", 6, "Siege", false, 1), MorvranVoorhis("Morvran Voorhis", Faction.Nilfgaard, "Hero", 10, "Siege", true, 1),

    Cynthia("Cynthia", Faction.Nilfgaard, "", 4, "Ranged", false, 1), EtolianAuxiliaryArchers("Etolian Auxiliary Archers", Faction.Nilfgaard, "Medic", 1, "Ranged", false, 2),

    Morteisen("Morteisen", Faction.Nilfgaard, "", 3, "Close Combat", false, 1), NausicaaCavalryRider("Nausicaa Cavalry Rider", Faction.Nilfgaard, "Tight Bond", 2, "Close Combat", false, 3),

    SiegeTechnician("Siege Technician", Faction.Nilfgaard, "Medic", 0, "Siege", false, 1), Sweers("Sweers", Faction.Nilfgaard, "", 2, "Ranged", false, 1),

    Vanhemar("Vanhemar", Faction.Nilfgaard, "", 4, "Ranged", false, 1),

    // Skellige Cards
    Berserker("Berserker", Faction.Skellige, "Increase Score By Mardroeme", 4, "Close Combat", false, 1), YoungBerserker("Young Berserker", Faction.Skellige, "Increase Score By Mardroeme", 2, "Ranged", false, 3),

    Decoy("Decoy", Faction.Skellige, "Decoy", 0, "All", false, 3), Svanrige("Svanrige", Faction.Skellige, "", 4, "Close Combat", false, 1),

    Udalryk("Udalryk", Faction.Skellige, "", 4, "Close Combat", false, 1), DonarAnHindar("Donar an Hindar", Faction.Skellige, "", 4, "Close Combat", false, 1),

    ClanAnCraite("Clan An Craite", Faction.Skellige, "Tight Bond", 6, "Close Combat", false, 3), MadmanLugos("Madman Lugos", Faction.Skellige, "", 6, "Close Combat", false, 1),

    Cerys("Cerys", Faction.Skellige, "Hero Muster", 10, "Close Combat", true, 1), Kambi("Kambi", Faction.Skellige, "Hero Transform", 11, "Close Combat", true, 1),

    BirnaBran("Birna Bran", Faction.Skellige, "Medic", 2, "Close Combat", false, 1), ClanDrummondShieldmaiden("Clan Drummond Shieldmaiden", Faction.Skellige, "Tight Bond Muster", 4, "Close Combat", false, 3),

    ClanDimunPirate("Clan Dimun Pirate", Faction.Skellige, "Scorch", 6, "Ranged", false, 1), ClanBrokvarArcher("Clan Brokvar Archer", Faction.Skellige, "", 6, "Ranged", false, 3),

    Ermion("Ermion", Faction.Skellige, "Hero Mardroeme", 8, "Ranged", true, 1), Hjalmar("Hjalmar", Faction.Skellige, "Hero", 10, "Ranged", true, 1),

    LightLongship("Light Longship", Faction.Skellige, "Muster", 4, "Ranged", false, 3), WarLongship("War Longship", Faction.Skellige, "Tight Bond", 6, "Siege", false, 3),

    DraigBonDhu("Draig Bon-Dhu", Faction.Skellige, "Commander's Horn", 2, "Siege", false, 1), Olaf("Olaf", Faction.Skellige, "Moral Boost", 12, "Agile", false, 1),

    // Scoia'tael Cards
    ElvenSkirmisher("Elven Skirmisher", Faction.Scoiatael, "Muster", 2, "Ranged", false, 3), Yaevinn("Yaevinn", Faction.Scoiatael, "", 6, "Agile", false, 1),

    CiaranAep("Ciaran aep", Faction.Scoiatael, "", 3, "Agile", false, 1), DennisCranmer("Dennis Cranmer", Faction.Scoiatael, "", 6, "Close Combat", false, 1),

    DolBlathannaScout("Dol Blathanna Scout", Faction.Scoiatael, "", 6, "Agile", false, 3), DolBlathannaArcher("Dol Blathanna Archer", Faction.Scoiatael, "", 4, "Ranged", false, 1),

    DwarvenSkirmisher("Dwarven Skirmisher", Faction.Scoiatael, "Muster", 3, "Close Combat", false, 3), HavekarHealer("Havekar Healer", Faction.Scoiatael, "Medic", 0, "Ranged", false, 3),

    HavekarSmuggler("Havekar Smuggler", Faction.Scoiatael, "Muster", 5, "Close Combat", false, 3), IdaEmeanAep("Ida Emean aep", Faction.Scoiatael, "", 6, "Ranged", false, 1),

    Riordain("Riordain", Faction.Scoiatael, "", 1, "Ranged", false, 1), Toruviel("Toruviel", Faction.Scoiatael, "", 2, "Ranged", false, 1),

    VriheddBrigadeRecruit("Vrihedd Brigade Recruit", Faction.Scoiatael, "", 4, "Ranged", false, 1), VriheddBrigadeVeteran("Vrihedd Brigade Veteran", Faction.Scoiatael, "", 5, "Agile", false, 2),

    Milva("Milva", Faction.Scoiatael, "Morale Boost", 10, "Ranged", false, 1), Seasenthessis("Seasenthessis", Faction.Scoiatael, "Hero", 10, "Ranged", true, 1),

    Schirru("Schirru", Faction.Scoiatael, "Scorch Siege", 8, "Siege", false, 1), Eithne("Eithne", Faction.Scoiatael, "Hero", 10, "Ranged", true, 1),

    IsengrimFaoiltiarna("Isengrim Faoiltiarna", Faction.Scoiatael, "Morale Boost", 10, "Close Combat", true, 1),

    // Northern Realms Cards
    Ballista("Ballista", Faction.NorthernRealms, "", 6, "Siege", false, 2), Catapult("Catapult", Faction.NorthernRealms, "Tight Bond", 8, "Siege", false, 2),

    DragonHunter("Dragon Hunter", Faction.NorthernRealms, "Tight Bond", 5, "Ranged", false, 3), DunBannerMedic("Dun Banner Medic", Faction.NorthernRealms, "Medic", 5, "Siege", false, 1),

    EsteradThyssen("Esterad Thyssen", Faction.NorthernRealms, "Hero", 10, "Close Combat", true, 1), JohnNatalis("John Natalis", Faction.NorthernRealms, "Hero", 10, "Close Combat", true, 1),

    KaedweniSiegeExpert("Kaedweni Siege Expert", Faction.NorthernRealms, "Moral Boost", 1, "Siege", false, 3), PhilippaEilhart("Philippa Eilhart", Faction.NorthernRealms, "Hero", 10, "Ranged", true, 1),

    PoorFuckingInfantry("Poor Fucking Infantry", Faction.NorthernRealms, "Tight Bond", 1, "Close Combat", false, 4), PrinceStennis("Prince Stennis", Faction.NorthernRealms, "Spy", 5, "Close Combat", false, 1),

    RedanianFootSoldier("Redanian Foot Soldier", Faction.NorthernRealms, "", 1, "Close Combat", false, 2), SabrinaGlevissing("Sabrina Glevissing", Faction.NorthernRealms, "", 4, "Ranged", false, 1),

    SiegeTower("Siege Tower", Faction.NorthernRealms, "", 6, "Siege", false, 1), SiegfriedOfDenesle("Siegfried of Denesle", Faction.NorthernRealms, "", 5, "Close Combat", false, 1),

    SigismundDijkstra("Sigismund Dijkstra", Faction.NorthernRealms, "Spy", 4, "Close Combat", false, 1), SileDeTansarville("Síle de Tansarville", Faction.NorthernRealms, "", 5, "Ranged", false, 1),

    Thaler("Thaler", Faction.NorthernRealms, "Spy", 1, "Siege", false, 1), VernonRoche("Vernon Roche", Faction.NorthernRealms, "Hero", 10, "Close Combat", true, 1),

    Ves("Ves", Faction.NorthernRealms, "", 5, "Close Combat", false, 1), YarpenZirgrin("Yarpen Zirgrin", Faction.NorthernRealms, "", 2, "Close Combat", false, 1),

    // Monsters Cards
    Draug("Draug", Faction.Monsters, "Hero", 10, "Close Combat", true, 1), Leshen("Leshen", Faction.Monsters, "Hero", 10, "Close Combat", true, 1),

    Kayran("Kayran", Faction.Monsters, "Morale Boost Hero", 8, "Agile", true, 1), Toad("Toad", Faction.Monsters, "Scorch Ranged", 7, "Ranged", false, 1),

    ArachasBehemoth("Arachas Behemoth", Faction.Monsters, "Muster", 6, "Siege", false, 1), CroneWeavess("Crone: Weavess", Faction.Monsters, "Muster", 6, "Close Combat", false, 1),

    CroneWhispess("Crone: Whispess", Faction.Monsters, "Muster", 6, "Close Combat", false, 1), EarthElemental("Earth Elemental", Faction.Monsters, "", 6, "Siege", false, 1),

    Fiend("Fiend", Faction.Monsters, "", 6, "Close Combat", false, 1), FireElemental("Fire Elemental", Faction.Monsters, "", 6, "Siege", false, 1),

    Forktail("Forktail", Faction.Monsters, "", 5, "Close Combat", false, 1), GraveHag("Grave Hag", Faction.Monsters, "", 5, "Ranged", false, 1),

    Griffin("Griffin", Faction.Monsters, "", 5, "Close Combat", false, 1), IceGiant("Ice Giant", Faction.Monsters, "", 5, "Siege", false, 1),

    PlagueMaiden("Plague Maiden", Faction.Monsters, "", 5, "Close Combat", false, 1), VampireKatakan("Vampire: Katakan", Faction.Monsters, "Muster", 5, "Close Combat", false, 1),

    Werewolf("Werewolf", Faction.Monsters, "", 5, "Close Combat", false, 1), Arachas("Arachas", Faction.Monsters, "Muster", 4, "Close Combat", false, 3),

    Gargoyle("Gargoyle", Faction.Monsters, "Muster", 2, "Ranged", false, 1), VampireBruxa("Vampire: Bruxa", Faction.Monsters, "Muster", 4, "Close Combat", false, 1),

    VampireEkimmara("Vampire: Ekimmara", Faction.Monsters, "Muster", 4, "Close Combat", false, 1), VampireFleder("Vampire: Fleder", Faction.Monsters, "Muster", 4, "Close Combat", false, 1),

    VampireGarkain("Vampire: Garkain", Faction.Monsters, "Muster", 4, "Close Combat", false, 1), Cockatrice("Cockatrice", Faction.Monsters, "", 2, "Ranged", false, 1),

    Endrega("Endrega", Faction.Monsters, "", 2, "Ranged", false, 1), Foglet("Foglet", Faction.Monsters, "", 2, "Close Combat", false, 1),

    Harpy("Harpy", Faction.Monsters, "", 2, "Agile", false, 1), Nekker("Nekker", Faction.Monsters, "Muster", 2, "Close Combat", false, 3),

    Wyvern("Wyvern", Faction.Monsters, "", 2, "Ranged", false, 1), Ghoul("Ghoul", Faction.Monsters, "Muster", 1, "Close Combat", false, 3),

    Imlerith("Imlerith", Faction.Monsters, "Muster", 10, "Close Combat", true, 1), // Neutral Cards

    Dandelion("Dandelion", Faction.Monsters, "Commander's Horn", 2, "Close Combat", false, 1), EmielRegis("Emiel Regis", null, "", 5, "Close Combat", false, 1),

    GaunterODimm("Gaunter O’Dimm", null, "Muster", 2, "Siege", false, 1), GaunterODimmDarkness("Gaunter O’Dimm Darkness", null, "Muster", 4, "Ranged", false, 3),

    MysteriousElf("Mysterious Elf", null, "Spy Hero", 0, "Close Combat", true, 1), OlgierdVonEverc("Olgierd Von Everc", null, "Moral Boost", 6, "Agile", false, 1),

    TrissMerigold("Triss Merigold", null, "Hero", 7, "Close Combat", true, 1), Villentretenmerth("Villentretenmerth", null, "Scorch Close Combat", 7, "Close Combat", false, 1),

    YenneferOfVengerberg("Yennefer of Vengerberg", null, "Medic Hero", 7, "Ranged", true, 1), ZoltanChivay("Zoltan Chivay", null, "", 5, "Close Combat", false, 1),

    Botchling("Poroniec", Faction.Monsters, "", 4, "Close Combat", false, 1), Geralt("Geralt", null, "", 15, "Close Combat", true, 1), Assire("Assire", Faction.Nilfgaard, "", 6, "Close Combat", true, 1), RainFarn("RainFar", Faction.Nilfgaard, "", 4, "Close Combat", true, 1), Shilard("NilfGaardian", Faction.Nilfgaard, "", 7, "Close Combat", false, 1), Stripes("Stripes", Faction.Nilfgaard,"" ,4 ,"Close Combat" ,false ,1 );
    private final String cardName;
    private final Faction faction;
    private final String ability;
    private int score;
    private final String playField;
    private final boolean isHero;
    private int count;
    private Image image;

    CommonCard(String cardName, Faction faction, String ability, int score, String playField, boolean isHero, int count) {
        this.cardName = cardName;
        this.faction = faction;
        this.ability = ability;
        this.score = score;
        this.playField = playField;
        this.isHero = isHero;
        this.count = count;
    }

    public String getCardName() {
        return cardName;
    }

    public Faction getFaction() {
        return faction;
    }

    public String getAbility() {
        return ability;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayField() {
        return playField;
    }

    public boolean isHero() {
        return isHero;
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
        return "CommonCard{" + "cardName='" + cardName + '\'' + ", faction=" + faction + ", ability='" + ability + '\'' + ", score=" + score + ", playField='" + playField + '\'' + ", isHero=" + isHero + ", count=" + count + '}';
    }
    }
