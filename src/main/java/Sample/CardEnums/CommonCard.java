package Sample.CardEnums;

import javafx.scene.image.Image;

public enum CommonCard {
    // Nilfgaard Cards
    Albrich("Albrich", Faction.Nilfgaard, "", 2, "Ranged", false, 1, "Images/CardImages/nilfgaard_albrich.jpg", "Images/CardGameImages/nilfgaard_albrich.jpg"),
    ImperaBrigadeGuard("Impera Brigade Guard", Faction.Nilfgaard, "Tight Bond", 3, "Close Combat", false, 4, "Images/CardImages/nilfgaard_impera_brigade_guard.jpg", "Images/CardGameImages/nilfgaard_impera_brigade_guard.jpg"),
    StefanSkellen("Stefan Skellen", Faction.Nilfgaard, "Spy", 9, "Close Combat", false, 1, "Images/CardImages/nilfgaard_stefan_skellen.jpg", "Images/CardGameImages/nilfgaard_stefan_skellen.jpg"),
    YoungEmissary("Young Emissary", Faction.Nilfgaard, "Tight Bond", 5, "Close Combat", false, 2, "Images/CardImages/nilfgaard_young_emissary.jpg", "Images/CardGameImages/nilfgaard_young_emissary.jpg"),
    CahirMawrDyffrynAepCeallach("Cahir Mawr Dyffryn aep Ceallach", Faction.Nilfgaard, "", 6, "Close Combat", false, 1, "Images/CardImages/nilfgaard_cahir_mawr_dyffryn_aep_ceallach.jpg", "Images/CardGameImages/nilfgaard_cahir_mawr_dyffryn_aep_ceallach.jpg"),
    VattierDeRideaux("Vattier de Rideaux", Faction.Nilfgaard, "Spy", 4, "Close Combat", false, 1, "Images/CardImages/nilfgaard_vattier_de_rideaux.jpg", "Images/CardGameImages/nilfgaard_vattier_de_rideaux.jpg"),
    MennoCoehoorn("Menno Coehoorn", Faction.Nilfgaard, "Hero Medic", 10, "Close Combat", true, 1, "Images/CardImages/nilfgaard_menno_coehoorn.jpg", "Images/CardGameImages/nilfgaard_menno_coehoorn.jpg"),
    Puttkammer("Puttkammer", Faction.Nilfgaard, "", 3, "Ranged", false, 1, "Images/CardImages/nilfgaard_puttkammer.jpg", "Images/CardGameImages/nilfgaard_puttkammer.jpg"),
    BlackInfantryArcher("Black Infantry Archer", Faction.Nilfgaard, "", 10, "Ranged", false, 2, "Images/CardImages/nilfgaard_black_infantry_archer.jpg", "Images/CardGameImages/nilfgaard_black_infantry_archer.jpg"),
    TiborEggebracht("Tibor Eggebracht", Faction.Nilfgaard, "Hero", 10, "Ranged", true, 1, "Images/CardImages/nilfgaard_tibor_eggebracht.jpg", "Images/CardGameImages/nilfgaard_tibor_eggebracht.jpg"),
    RenualdAepMatsen("Renuald aep Matsen", Faction.Nilfgaard, "", 5, "Ranged", false, 1, "Images/CardImages/nilfgaard_renuald_aep_matsen.jpg", "Images/CardGameImages/nilfgaard_renuald_aep_matsen.jpg"),
    FringillaVigo("Fringilla Vigo", Faction.Nilfgaard, "", 6, "Ranged", false, 1, "Images/CardImages/nilfgaard_fringilla_vigo.jpg", "Images/CardGameImages/nilfgaard_fringilla_vigo.jpg"),
    RottenMangonel("Rotten Mangonel", Faction.Nilfgaard, "", 3, "Siege", false, 1, "Images/CardImages/nilfgaard_rotten_mangonel.jpg", "Images/CardGameImages/nilfgaard_rotten_mangonel.jpg"),
    ZerrikanianFireScorpion("Zerrikanian Fire Scorpion", Faction.Nilfgaard, "", 5, "Siege", false, 1, "Images/CardImages/nilfgaard_zerrikanian_fire_scorpion.jpg", "Images/CardGameImages/nilfgaard_zerrikanian_fire_scorpion.jpg"),
    SiegeEngineer("Siege Engineer", Faction.Nilfgaard, "", 6, "Siege", false, 1, "Images/CardImages/nilfgaard_siege_engineer.jpg", "Images/CardGameImages/nilfgaard_siege_engineer.jpg"),
    MorvranVoorhis("Morvran Voorhis", Faction.Nilfgaard, "Hero", 10, "Siege", true, 1, "Images/CardImages/nilfgaard_morvran_voorhis.jpg", "Images/CardGameImages/nilfgaard_morvran_voorhis.jpg"),
    Cynthia("Cynthia", Faction.Nilfgaard, "", 4, "Ranged", false, 1, "Images/CardImages/nilfgaard_cynthia.jpg", "Images/CardGameImages/nilfgaard_cynthia.jpg"),
    EtolianAuxiliaryArchers("Etolian Auxiliary Archers", Faction.Nilfgaard, "Medic", 1, "Ranged", false, 2, "Images/CardImages/nilfgaard_etolian_auxiliary_archers.jpg", "Images/CardGameImages/nilfgaard_etolian_auxiliary_archers.jpg"),
    Morteisen("Morteisen", Faction.Nilfgaard, "", 3, "Close Combat", false, 1, "Images/CardImages/nilfgaard_morteisen.jpg", "Images/CardGameImages/nilfgaard_morteisen.jpg"),
    NausicaaCavalryRider("Nausicaa Cavalry Rider", Faction.Nilfgaard, "Tight Bond", 2, "Close Combat", false, 3, "Images/CardImages/nilfgaard_nauzicaa_2.jpg", "Images/CardGameImages/nilfgaard_nauzicaa_2.jpg"),
    SiegeTechnician("Siege Technician", Faction.Nilfgaard, "Medic", 0, "Siege", false, 1, "Images/CardImages/nilfgaard_siege_technician.jpg", "Images/CardGameImages/nilfgaard_siege_technician.jpg"),
    Sweers("Sweers", Faction.Nilfgaard, "", 2, "Ranged", false, 1, "Images/CardImages/nilfgaard_sweers.jpg", "Images/CardGameImages/nilfgaard_sweers.jpg"),
    Vanhemar("Vanhemar", Faction.Nilfgaard, "", 4, "Ranged", false, 1, "Images/CardImages/nilfgaard_vanhemar.jpg", "Images/CardGameImages/nilfgaard_vanhemar.jpg"),
    HeavyZerrikanianFireScorpion("Heavy Zerrikanian Fire Scorpion", Faction.Nilfgaard, "", 10, "Siege", false, 1, "Images/CardImages/nilfgaard_heavy_zerri.jpg", "Images/CardGameImages/nilfgaard_heavy_zerri.jpg"),

    // Skellige Cards
    Berserker("Berserker", Faction.Skellige, "Increase Score By Mardroeme", 4, "Close Combat", false, 1, "Images/CardImages/skellige_berserker.jpg", "Images/CardGameImages/skellige_berserker.jpg"),
    YoungBerserker("Young Berserker", Faction.Skellige, "Increase Score By Mardroeme", 2, "Ranged", false, 3, "Images/CardImages/skellige_young_berserker.jpg", "Images/CardGameImages/skellige_young_berserker.jpg"),
    Decoy("Decoy", Faction.Skellige, "Decoy", 0, "All", false, 3, "Images/CardImages/skellige_decoy.jpg", "Images/CardGameImages/skellige_decoy.jpg"),
    Svanrige("Svanrige", Faction.Skellige, "", 4, "Close Combat", false, 1, "Images/CardImages/skellige_svanrige.jpg", "Images/CardGameImages/skellige_svanrige.jpg"),
    Udalryk("Udalryk", Faction.Skellige, "", 4, "Close Combat", false, 1, "Images/CardImages/skellige_udalryk.jpg", "Images/CardGameImages/skellige_udalryk.jpg"),
    DonarAnHindar("Donar an Hindar", Faction.Skellige, "", 4, "Close Combat", false, 1, "Images/CardImages/skellige_donar_an_hindar.jpg", "Images/CardGameImages/skellige_donar_an_hindar.jpg"),
    ClanAnCraite("Clan An Craite", Faction.Skellige, "Tight Bond", 6, "Close Combat", false, 3, "Images/CardImages/skellige_clan_an_craite.jpg", "Images/CardGameImages/skellige_clan_an_craite.jpg"),
    MadmanLugos("Madman Lugos", Faction.Skellige, "", 6, "Close Combat", false, 1, "Images/CardImages/skellige_madman_lugos.jpg", "Images/CardGameImages/skellige_madman_lugos.jpg"),
    Cerys("Cerys", Faction.Skellige, "Hero Muster", 10, "Close Combat", true, 1, "Images/CardImages/skellige_cerys.jpg", "Images/CardGameImages/skellige_cerys.jpg"),
    Kambi("Kambi", Faction.Skellige, "Hero Transform", 11, "Close Combat", true, 1, "Images/CardImages/skellige_kambi.jpg", "Images/CardGameImages/skellige_kambi.jpg"),
    BirnaBran("Birna Bran", Faction.Skellige, "Medic", 2, "Close Combat", false, 1, "Images/CardImages/skellige_birna_bran.jpg", "Images/CardGameImages/skellige_birna_bran.jpg"),
    ClanDrummondShieldmaiden("Clan Drummond Shieldmaiden", Faction.Skellige, "Tight Bond Muster", 4, "Close Combat", false, 3, "Images/CardImages/skellige_clan_drummond_shieldmaiden.jpg", "Images/CardGameImages/skellige_clan_drummond_shieldmaiden.jpg"),
    ClanDimunPirate("Clan Dimun Pirate", Faction.Skellige, "Scorch", 6, "Ranged", false, 1, "Images/CardImages/skellige_clan_dimun_pirate.jpg", "Images/CardGameImages/skellige_clan_dimun_pirate.jpg"),
    ClanBrokvarArcher("Clan Brokvar Archer", Faction.Skellige, "", 6, "Ranged", false, 3, "Images/CardImages/skellige_brokva_archer.jpg", "Images/CardGameImages/skellige_brokva_archer.jpg"),
    Ermion("Ermion", Faction.Skellige, "Hero Mardroeme", 8, "Ranged", true, 1, "Images/CardImages/skellige_ermion.jpg", "Images/CardGameImages/skellige_ermion.jpg"),
    Hjalmar("Hjalmar", Faction.Skellige, "Hero", 10, "Ranged", true, 1, "Images/CardImages/skellige_hjalmar.jpg", "Images/CardGameImages/skellige_hjalmar.jpg"),
    LightLongship("Light Longship", Faction.Skellige, "Muster", 4, "Ranged", false, 3, "Images/CardImages/skellige_light_longship.jpg", "Images/CardGameImages/skellige_light_longship.jpg"),
    WarLongship("War Longship", Faction.Skellige, "Tight Bond", 6, "Siege", false, 3, "Images/CardImages/skellige_war_longship.jpg", "Images/CardGameImages/skellige_war_longship.jpg"),
    DraigBonDhu("Draig Bon-Dhu", Faction.Skellige, "Commander's Horn", 2, "Siege", false, 1, "Images/CardImages/skellige_draig.jpg", "Images/CardGameImages/skellige_draig.jpg"),
    Olaf("Olaf", Faction.Skellige, "Moral Boost", 12, "Agile", false, 1, "Images/CardImages/skellige_olaf.jpg", "Images/CardGameImages/skellige_olaf.jpg"),
    BlueboyLugos("Blueboy Lugos", Faction.Skellige, "", 6, "Close Combat", false, 1, "Images/CardImages/skellige_blueboy.jpg", "Images/CardGameImages/skellige_blueboy.jpg"),
    ClanAnCraiteWarrior("Clan an Craite Warrior", Faction.Skellige, "Tight Bond", 6, "Close Combat", false, 3, "Images/CardImages/skellige_craite_warrior.jpg", "Images/CardGameImages/skellige_craite_warrior.jpg"),
    Hemdall("Hemdall", Faction.Skellige, "", 11, "Close Combat", false, 1, "Images/CardImages/skellige_hemdall.jpg", "Images/CardGameImages/skellige_hemdall.jpg"),
    ClanHeymaeySkald("Clan Heymaey Skald", Faction.Skellige, "", 4, "Close Combat", false, 1, "Images/CardImages/skellige_heymaey.jpg", "Images/CardGameImages/skellige_heymaey.jpg"),
    HolgerBlackhand("Holger Blackhand", Faction.Skellige, "", 4, "Siege", false, 1, "Images/CardImages/skellige_holger.jpg", "Images/CardGameImages/skellige_holger.jpg"),
    ClanTordarrochArmorsmith("Clan Tordarroch Armorsmith", Faction.Skellige, "", 4, "Close Combat", false, 1, "Images/CardImages/skellige_tordarroch.jpg", "Images/CardGameImages/skellige_tordarroch.jpg"),
    TransformedVildkaarl("Transformed Vildkaarl", Faction.Skellige, "", 14, "Close Combat", false, 1, "Images/CardImages/skellige_vildkaarl.jpg", "Images/CardGameImages/skellige_vildkaarl.jpg"),
    TransformedYoungVildkaarl("Transformed Young Vildkaarl", Faction.Skellige, "Tight Bond", 8, "Ranged", false, 3, "Images/CardImages/skellige_young_vildkaarl.jpg", "Images/CardGameImages/skellige_young_vildkaarl.jpg"),

    // Scoia'tael Cards
    ElvenSkirmisher("Elven Skirmisher", Faction.Scoiatael, "Muster", 2, "Ranged", false, 3, "Images/CardImages/scoiatael_elven_skirmisher.jpg", "Images/CardGameImages/scoiatael_elven_skirmisher.jpg"),
    Yaevinn("Yaevinn", Faction.Scoiatael, "", 6, "Agile", false, 1, "Images/CardImages/scoiatael_yaevinn.jpg", "Images/CardGameImages/scoiatael_yaevinn.jpg"),
    CiaranAep("Ciaran aep", Faction.Scoiatael, "", 3, "Agile", false, 1, "Images/CardImages/scoiatael_ciaran_aep.jpg", "Images/CardGameImages/scoiatael_ciaran_aep.jpg"),
    DennisCranmer("Dennis Cranmer", Faction.Scoiatael, "", 6, "Close Combat", false, 1, "Images/CardImages/scoiatael_dennis_cranmer.jpg", "Images/CardGameImages/scoiatael_dennis_cranmer.jpg"),
    DolBlathannaScout("Dol Blathanna Scout", Faction.Scoiatael, "", 6, "Agile", false, 3, "Images/CardImages/scoiatael_dol_infantry.jpg", "Images/CardGameImages/scoiatael_dol_infantry.jpg"),
    DolBlathannaArcher("Dol Blathanna Archer", Faction.Scoiatael, "", 4, "Ranged", false, 1, "Images/CardImages/scoiatael_dol_archer.jpg", "Images/CardGameImages/scoiatael_dol_archer.jpg"),
    DwarvenSkirmisher("Dwarven Skirmisher", Faction.Scoiatael, "Muster", 3, "Close Combat", false, 3, "Images/CardImages/scoiatael_dwarf.jpg", "Images/CardGameImages/scoiatael_dwarf.jpg"),
    HavekarHealer("Havekar Healer", Faction.Scoiatael, "Medic", 0, "Ranged", false, 3, "Images/CardImages/scoiatael_havekar_nurse.jpg", "Images/CardGameImages/scoiatael_havekar_nurse.jpg"),
    HavekarSmuggler("Havekar Smuggler", Faction.Scoiatael, "Muster", 5, "Close Combat", false, 3, "Images/CardImages/scoiatael_havekar_smuggler.jpg", "Images/CardGameImages/scoiatael_havekar_smuggler.jpg"),
    IdaEmeanAep("Ida Emean aep", Faction.Scoiatael, "", 6, "Ranged", false, 1, "Images/CardImages/scoiatael_ida_emean_aep.jpg", "Images/CardGameImages/scoiatael_ida_emean_aep.jpg"),
    Riordain("Riordain", Faction.Scoiatael, "", 1, "Ranged", false, 1, "Images/CardImages/scoiatael_riordain.jpg", "Images/CardGameImages/scoiatael_riordain.jpg"),
    Toruviel("Toruviel", Faction.Scoiatael, "", 2, "Ranged", false, 1, "Images/CardImages/scoiatael_toruviel.jpg", "Images/CardGameImages/scoiatael_toruviel.jpg"),
    VriheddBrigadeRecruit("Vrihedd Brigade Recruit", Faction.Scoiatael, "", 4, "Ranged", false, 1, "Images/CardImages/scoiatael_vrihedd_cadet.jpg", "Images/CardGameImages/scoiatael_vrihedd_cadet.jpg"),
    VriheddBrigadeVeteran("Vrihedd Brigade Veteran", Faction.Scoiatael, "", 5, "Agile", false, 2, "Images/CardImages/scoiatael_vrihedd_brigade.jpg", "Images/CardGameImages/scoiatael_vrihedd_brigade.jpg"),
    Milva("Milva", Faction.Scoiatael, "Morale Boost", 10, "Ranged", false, 1, "Images/CardImages/scoiatael_milva.jpg", "Images/CardGameImages/scoiatael_milva.jpg"),
    Seasenthessis("Seasenthessis", Faction.Scoiatael, "Hero", 10, "Ranged", true, 1, "Images/CardImages/scoiatael_seasenthessis.jpg", "Images/CardGameImages/scoiatael_seasenthessis.jpg"),
    Schirru("Schirru", Faction.Scoiatael, "Scorch Siege", 8, "Siege", false, 1, "Images/CardImages/scoiatael_schirru.jpg", "Images/CardGameImages/scoiatael_schirru.jpg"),
    Eithne("Eithne", Faction.Scoiatael, "Hero", 10, "Ranged", true, 1, "Images/CardImages/scoiatael_eithne.jpg", "Images/CardGameImages/scoiatael_eithne.jpg"),
    IsengrimFaoiltiarna("Isengrim Faoiltiarna", Faction.Scoiatael, "Morale Boost", 10, "Close Combat", true, 1, "Images/CardImages/scoiatael_isengrim_faoiltiarna.jpg", "Images/CardGameImages/scoiatael_isengrim_faoiltiarna.jpg"),
    BarclayEls("Barclay Els", Faction.Scoiatael, "", 6, "Ranged", false, 1, "Images/CardImages/scoiatael_barclay.jpg", "Images/CardGameImages/scoiatael_barclay.jpg"),
    FilavandrelAenFidhail("Filavandrel aén Fidháil", Faction.Scoiatael, "", 6, "Ranged", false, 1, "Images/CardImages/scoiatael_filavandrel.jpg", "Images/CardGameImages/scoiatael_filavandrel.jpg"),

    // Northern Realms Cards
    Ballista("Ballista", Faction.NorthernRealms, "", 6, "Siege", false, 2, "Images/CardImages/realms_ballista.jpg", "Images/CardGameImages/realms_ballista.jpg"),
    Catapult("Catapult", Faction.NorthernRealms, "Tight Bond", 8, "Siege", false, 2, "Images/CardImages/realms_catapult.jpg", "Images/CardGameImages/realms_catapult.jpg"),
    DragonHunter("Dragon Hunter", Faction.NorthernRealms, "Tight Bond", 5, "Ranged", false, 3, "Images/CardImages/realms_crinfrid.jpg", "Images/CardGameImages/realms_crinfrid.jpg"),
    DunBannerMedic("Dun Banner Medic", Faction.NorthernRealms, "Medic", 5, "Siege", false, 1, "Images/CardImages/realms_banner_nurse.jpg", "Images/CardGameImages/realms_banner_nurse.jpg"),
    EsteradThyssen("Esterad Thyssen", Faction.NorthernRealms, "Hero", 10, "Close Combat", true, 1, "Images/CardImages/realms_esterad_thyssen.jpg", "Images/CardGameImages/realms_esterad_thyssen.jpg"),
    JohnNatalis("John Natalis", Faction.NorthernRealms, "Hero", 10, "Close Combat", true, 1, "Images/CardImages/realms_john_natalis.jpg", "Images/CardGameImages/realms_john_natalis.jpg"),
    KaedweniSiegeExpert("Kaedweni Siege Expert", Faction.NorthernRealms, "Moral Boost", 1, "Siege", false, 3, "Images/CardImages/realms_kaedweni_siege_expert.jpg", "Images/CardGameImages/realms_kaedweni_siege_expert.jpg"),
    PhilippaEilhart("Philippa Eilhart", Faction.NorthernRealms, "Hero", 10, "Ranged", true, 1, "Images/CardImages/realms_philippa_eilhart.jpg", "Images/CardGameImages/realms_philippa_eilhart.jpg"),
    PoorFuckingInfantry("Poor Fucking Infantry", Faction.NorthernRealms, "Tight Bond", 1, "Close Combat", false, 4, "Images/CardImages/realms_poor_fucking_infantry.jpg", "Images/CardGameImages/realms_poor_fucking_infantry.jpg"),
    PrinceStennis("Prince Stennis", Faction.NorthernRealms, "Spy", 5, "Close Combat", false, 1, "Images/CardImages/realms_prince_stennis.jpg", "Images/CardGameImages/realms_prince_stennis.jpg"),
    RedanianFootSoldier("Redanian Foot Soldier", Faction.NorthernRealms, "", 1, "Close Combat", false, 2, "Images/CardImages/realms_redania.jpg", "Images/CardGameImages/realms_redania.jpg"),
    SabrinaGlevissing("Sabrina Glevissing", Faction.NorthernRealms, "", 4, "Ranged", false, 1, "Images/CardImages/realms_sabrina_glevissing.jpg", "Images/CardGameImages/realms_sabrina_glevissing.jpg"),
    SiegeTower("Siege Tower", Faction.NorthernRealms, "", 6, "Siege", false, 1, "Images/CardImages/realms_siege_tower.jpg", "Images/CardGameImages/realms_siege_tower.jpg"),
    SiegfriedOfDenesle("Siegfried of Denesle", Faction.NorthernRealms, "", 5, "Close Combat", false, 1, "Images/CardImages/realms_siegfried_of_denesle.jpg", "Images/CardGameImages/realms_siegfried_of_denesle.jpg"),
    SigismundDijkstra("Sigismund Dijkstra", Faction.NorthernRealms, "Spy", 4, "Close Combat", false, 1, "Images/CardImages/realms_sigismund_dijkstra.jpg", "Images/CardGameImages/realms_sigismund_dijkstra.jpg"),
    SileDeTansarville("Sile de Tansarville", Faction.NorthernRealms, "", 5, "Ranged", false, 1, "Images/CardImages/realms_sheala.jpg", "Images/CardGameImages/realms_sheala.jpg"),
    Thaler("Thaler", Faction.NorthernRealms, "Spy", 1, "Siege", false, 1, "Images/CardImages/realms_thaler.jpg", "Images/CardGameImages/realms_thaler.jpg"),
    VernonRoche("Vernon Roche", Faction.NorthernRealms, "Hero", 10, "Close Combat", true, 1, "Images/CardImages/realms_vernon_roche.jpg", "Images/CardGameImages/realms_vernon_roche.jpg"),
    Ves("Ves", Faction.NorthernRealms, "", 5, "Close Combat", false, 1, "Images/CardImages/realms_ves.jpg", "Images/CardGameImages/realms_ves.jpg"),
    YarpenZirgrin("Yarpen Zirgrin", Faction.NorthernRealms, "", 2, "Close Combat", false, 1, "Images/CardImages/realms_yarpen_zirgrin.jpg", "Images/CardGameImages/realms_yarpen_zirgrin.jpg"),
    CrinfridReaversDragonHunter("Crinfrid Reavers Dragon Hunter", Faction.NorthernRealms, "Tight Bond", 5, "Ranged", false, 3, "Images/CardImages/realms_crinfrid.jpg", "Images/CardGameImages/realms_crinfrid.jpg"),
    Dethmold("Dethmold", Faction.NorthernRealms, "", 6, "Ranged", false, 1, "Images/CardImages/realms_dethmold.jpg", "Images/CardGameImages/realms_dethmold.jpg"),
    BlueStripesCommando("Blue Stripes Commando", Faction.NorthernRealms, "Tight Bond", 4, "Close Combat", false, 4, "Images/CardImages/realms_blue_stripes.jpg", "Images/CardGameImages/realms_blue_stripes.jpg"),
    KeiraMetz("Keira Metz", Faction.NorthernRealms, "", 5, "Ranged", false, 1, "Images/CardImages/realms_keira.jpg", "Images/CardGameImages/realms_keira.jpg"),
    SheldonSkaggs("Sheldon Skaggs", Faction.NorthernRealms, "", 4, "Ranged", false, 1, "Images/CardImages/realms_sheldon.jpg", "Images/CardGameImages/realms_sheldon.jpg"),

    // Monsters Cards
    Draug("Draug", Faction.Monsters, "Hero", 10, "Close Combat", true, 1, "Images/CardImages/monsters_draug.jpg", "Images/CardGameImages/monsters_draug.jpg"),
    Leshen("Leshen", Faction.Monsters, "Hero", 10, "Close Combat", true, 1, "Images/CardImages/monsters_leshen.jpg", "Images/CardGameImages/monsters_leshen.jpg"),
    Kayran("Kayran", Faction.Monsters, "Morale Boost Hero", 8, "Agile", true, 1, "Images/CardImages/monsters_kayran.jpg", "Images/CardGameImages/monsters_kayran.jpg"),
    Toad("Toad", Faction.Monsters, "Scorch Ranged", 7, "Ranged", false, 1, "Images/CardImages/monsters_toad.jpg", "Images/CardGameImages/monsters_toad.jpg"),
    ArachasBehemoth("Arachas Behemoth", Faction.Monsters, "Muster", 6, "Siege", false, 1, "Images/CardImages/monsters_arachas_behemoth.jpg", "Images/CardGameImages/monsters_arachas_behemoth.jpg"),
    CroneWeavess("Crone: Weavess", Faction.Monsters, "Muster", 6, "Close Combat", false, 1, "Images/CardImages/monsters_crone_weavess.jpg", "Images/CardGameImages/monsters_crone_weavess.jpg"),
    CroneWhispess("Crone: Whispess", Faction.Monsters, "Muster", 6, "Close Combat", false, 1, "Images/CardImages/monsters_crone_whispess.jpg", "Images/CardGameImages/monsters_crone_whispess.jpg"),
    EarthElemental("Earth Elemental", Faction.Monsters, "", 6, "Siege", false, 1, "Images/CardImages/monsters_earth_elemental.jpg", "Images/CardGameImages/monsters_earth_elemental.jpg"),
    Fiend("Fiend", Faction.Monsters, "", 6, "Close Combat", false, 1, "Images/CardImages/monsters_fiend.jpg", "Images/CardGameImages/monsters_fiend.jpg"),
    FireElemental("Fire Elemental", Faction.Monsters, "", 6, "Siege", false, 1, "Images/CardImages/monsters_fire_elemental.jpg", "Images/CardGameImages/monsters_fire_elemental.jpg"),
    Forktail("Forktail", Faction.Monsters, "", 5, "Close Combat", false, 1, "Images/CardImages/monsters_forktail.jpg", "Images/CardGameImages/monsters_forktail.jpg"),
    GraveHag("Grave Hag", Faction.Monsters, "", 5, "Ranged", false, 1, "Images/CardImages/monsters_grave_hag.jpg", "Images/CardGameImages/monsters_grave_hag.jpg"),
    Griffin("Griffin", Faction.Monsters, "", 5, "Close Combat", false, 1, "Images/CardImages/monsters_griffin.jpg", "Images/CardGameImages/monsters_griffin.jpg"),
    IceGiant("Ice Giant", Faction.Monsters, "", 5, "Siege", false, 1, "Images/CardImages/monsters_ice_giant.jpg", "Images/CardGameImages/monsters_ice_giant.jpg"),
    PlagueMaiden("Plague Maiden", Faction.Monsters, "", 5, "Close Combat", false, 1, "Images/CardImages/monsters_plague_maiden.jpg", "Images/CardGameImages/monsters_plague_maiden.jpg"),
    VampireKatakan("Vampire: Katakan", Faction.Monsters, "Muster", 5, "Close Combat", false, 1, "Images/CardImages/monsters_vampire_katakan.jpg", "Images/CardGameImages/monsters_vampire_katakan.jpg"),
    Werewolf("Werewolf", Faction.Monsters, "", 5, "Close Combat", false, 1, "Images/CardImages/monsters_werewolf.jpg", "Images/CardGameImages/monsters_werewolf.jpg"),
    Arachas("Arachas", Faction.Monsters, "Muster", 4, "Close Combat", false, 3, "Images/CardImages/monsters_arachas.jpg", "Images/CardGameImages/monsters_arachas.jpg"),
    Gargoyle("Gargoyle", Faction.Monsters, "Muster", 2, "Ranged", false, 1, "Images/CardImages/monsters_gargoyle.jpg", "Images/CardGameImages/monsters_gargoyle.jpg"),
    VampireBruxa("Vampire: Bruxa", Faction.Monsters, "Muster", 4, "Close Combat", false, 1, "Images/CardImages/monsters_vampire_bruxa.jpg", "Images/CardGameImages/monsters_vampire_bruxa.jpg"),
    VampireEkimmara("Vampire: Ekimmara", Faction.Monsters, "Muster", 4, "Close Combat", false, 1, "Images/CardImages/monsters_vampire_ekimmara.jpg", "Images/CardGameImages/monsters_vampire_ekimmara.jpg"),
    VampireFleder("Vampire: Fleder", Faction.Monsters, "Muster", 4, "Close Combat", false, 1, "Images/CardImages/monsters_vampire_fleder.jpg", "Images/CardGameImages/monsters_vampire_fleder.jpg"),
    VampireGarkain("Vampire: Garkain", Faction.Monsters, "Muster", 4, "Close Combat", false, 1, "Images/CardImages/monsters_vampire_garkain.jpg", "Images/CardGameImages/monsters_vampire_garkain.jpg"),
    Cockatrice("Cockatrice", Faction.Monsters, "", 2, "Ranged", false, 1, "Images/CardImages/monsters_cockatrice.jpg", "Images/CardGameImages/monsters_cockatrice.jpg"),
    Endrega("Endrega", Faction.Monsters, "", 2, "Ranged", false, 1, "Images/CardImages/monsters_endrega.jpg", "Images/CardGameImages/monsters_endrega.jpg"),
    Foglet("Foglet", Faction.Monsters, "", 2, "Close Combat", false, 1, "Images/CardImages/monsters_foglet.jpg", "Images/CardGameImages/monsters_foglet.jpg"),
    Harpy("Harpy", Faction.Monsters, "", 2, "Agile", false, 1, "Images/CardImages/monsters_harpy.jpg", "Images/CardGameImages/monsters_harpy.jpg"),
    Nekker("Nekker", Faction.Monsters, "Muster", 2, "Close Combat", false, 3, "Images/CardImages/monsters_nekker.jpg", "Images/CardGameImages/monsters_nekker.jpg"),
    Wyvern("Wyvern", Faction.Monsters, "", 2, "Ranged", false, 1, "Images/CardImages/monsters_wyvern.jpg", "Images/CardGameImages/monsters_wyvern.jpg"),
    Ghoul("Ghoul", Faction.Monsters, "Muster", 1, "Close Combat", false, 3, "Images/CardImages/monsters_ghoul.jpg", "Images/CardGameImages/monsters_ghoul.jpg"),
    Imlerith("Imlerith", Faction.Monsters, "Muster", 10, "Close Combat", true, 1, "Images/CardImages/monsters_imlerith.jpg", "Images/CardGameImages/monsters_imlerith.jpg"),
    CelaenoHarpy("Celaeno Harpy", Faction.Monsters, "", 2, "Ranged", false, 1, "Images/CardImages/monsters_celaeno_harpy.jpg", "Images/CardGameImages/monsters_celaeno_harpy.jpg"),
    Frightener("Frightener", Faction.Monsters, "", 5, "Close Combat", false, 1, "Images/CardImages/monsters_frightener.jpg", "Images/CardGameImages/monsters_frightener.jpg"),
    CroneBrewess("Crone: Brewess", Faction.Monsters, "Muster", 6, "Close Combat", false, 1, "Images/CardImages/monsters_crone_brewess.jpg", "Images/CardGameImages/monsters_crone_brewess.jpg"),

    // Neutral Cards
    Dandelion("Dandelion", Faction.Monsters, "Commander's Horn", 2, "Close Combat", false, 1, "Images/CardImages/neutral_dandelion.jpg", "Images/CardGameImages/neutral_dandelion.jpg"),
    EmielRegis("Emiel Regis", null, "", 5, "Close Combat", false, 1, "Images/CardImages/neutral_emiel_regis.jpg", "Images/CardGameImages/neutral_emiel_regis.jpg"),
    GaunterODimm("Gaunter O’Dimm", null, "Muster", 2, "Siege", false, 1, "Images/CardImages/neutral_gaunter_o_dimm.jpg", "Images/CardGameImages/neutral_gaunter_o_dimm.jpg"),
    GaunterODimmDarkness("Gaunter O’Dimm Darkness", null, "Muster", 4, "Ranged", false, 3, "Images/CardImages/neutral_gaunter_o_dimm_darkness.jpg", "Images/CardGameImages/neutral_gaunter_o_dimm_darkness.jpg"),
    MysteriousElf("Mysterious Elf", null, "Spy Hero", 0, "Close Combat", true, 1, "Images/CardImages/neutral_mysterious_elf.jpg", "Images/CardGameImages/neutral_mysterious_elf.jpg"),
    OlgierdVonEverc("Olgierd Von Everc", null, "Moral Boost", 6, "Agile", false, 1, "Images/CardImages/neutral_olgierd_von_everc.jpg", "Images/CardGameImages/neutral_olgierd_von_everc.jpg"),
    TrissMerigold("Triss Merigold", null, "Hero", 7, "Close Combat", true, 1, "Images/CardImages/neutral_triss_merigold.jpg", "Images/CardGameImages/neutral_triss_merigold.jpg"),
    Villentretenmerth("Villentretenmerth", null, "Scorch Close Combat", 7, "Close Combat", false, 1, "Images/CardImages/neutral_villentretenmerth.jpg", "Images/CardGameImages/neutral_villentretenmerth.jpg"),
    YenneferOfVengerberg("Yennefer of Vengerberg", null, "Medic Hero", 7, "Ranged", true, 1, "Images/CardImages/neutral_yennefer_of_vengerberg.jpg", "Images/CardGameImages/neutral_yennefer_of_vengerberg.jpg"),
    ZoltanChivay("Zoltan Chivay", null, "", 5, "Close Combat", false, 1, "Images/CardImages/neutral_zoltan_chivay.jpg", "Images/CardGameImages/neutral_zoltan_chivay.jpg"),
    Botchling("Poroniec", Faction.Monsters, "", 4, "Close Combat", false, 1, "Images/CardImages/neutral_botchling.jpg", "Images/CardGameImages/neutral_botchling.jpg"),
    Geralt("Geralt", null, "", 15, "Close Combat", true, 1, "Images/CardImages/neutral_geralt.jpg", "Images/CardGameImages/neutral_geralt.jpg"),
    Assire("Assire", Faction.Nilfgaard, "", 6, "Close Combat", true, 1, "Images/CardImages/nilfgaard_assire.jpg", "Images/CardGameImages/nilfgaard_assire.jpg"),
    RainFarn("RainFar", Faction.Nilfgaard, "", 4, "Close Combat", true, 1, "Images/CardImages/nilfgaard_rainfarn.jpg", "Images/CardGameImages/nilfgaard_rainfarn.jpg"),
    Shilard("NilfGaardian", Faction.Nilfgaard, "", 7, "Close Combat", false, 1, "Images/CardImages/nilfgaard_shilard.jpg", "Images/CardGameImages/nilfgaard_shilard.jpg"),
    Stripes("Stripes", Faction.Nilfgaard, "", 4, "Close Combat", false, 1, "Images/CardImages/nilfgaard_stripes.jpg", "Images/CardGameImages/nilfgaard_stripes.jpg");
    private final String cardName;
    private final Faction faction;
    private final String ability;
    private int score;
    private final String playField;
    private final boolean isHero;
    private int count;
    private final String imagePath;
    private final String imageForGamePath;
    CommonCard(String cardName, Faction faction, String ability, int score, String playField, boolean isHero, int count, String imagePath, String imageForGamePath) {
        this.cardName = cardName;
        this.faction = faction;
        this.ability = ability;
        this.score = score;
        this.playField = playField;
        this.isHero = isHero;
        this.count = count;
        this.imagePath = imagePath;
        this.imageForGamePath = imageForGamePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public String getImageForGamePath() {
        return imageForGamePath;
    }

    @Override
    public String toString() {
        return "CommonCard{" + "cardName='" + cardName + '\'' + ", faction=" + faction + ", ability='" + ability + '\'' + ", score=" + score + ", playField='" + playField + '\'' + ", isHero=" + isHero + ", count=" + count + '}';
    }
    }
