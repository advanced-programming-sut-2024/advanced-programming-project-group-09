package Sample.CardEnums;

import Sample.View.LoginMenu;

import java.io.InputStream;
import java.util.Objects;

public enum Faction {
    Skellige("Skellige", "Draws 2 random cards from the graveyard at the start of the third round", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/skellige_crach_an_craite.jpg"))),
    NorthernRealms("Northern Realms", "Draws a card from your deck whenever you win a round", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_realms.png"))),
    Nilfgaard("Nilfgaard", "Wins any round that ends in a draw", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_nilfgaard.png"))),
    Scoiatael("Scoia'tael", "Decide who takes the first turn in each round", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_scoiatael.png"))),
    Monsters("Monsters", "Keep a random unit card on the battlefield after each round", Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_monsters.png"))),
    ;

    private final String factionName;
    private final String ability;
    private final InputStream imagePath;
    Faction(String factionName, String ability, InputStream imagePath) {
        this.factionName = factionName;
        this.ability = ability;
        this.imagePath = imagePath;
    }

    public String getFactionName() {
        return factionName;
    }

    public String getAbility() {
        return ability;
    }

    public InputStream getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "factionName='" + factionName + '\'' +
                ", ability='" + ability + '\'' +
                '}';
    }
}
