package Sample.Network.Client.model.CardEnums;

import Sample.View.LoginMenu;
import javafx.scene.image.Image;

import java.util.Objects;

public enum Faction {
    Skellige("Skellige", "Draws 2 random cards from the graveyard at the start of the third round", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_skellige.png")))),
    NorthernRealms("Northern Realms", "Draws a card from your deck whenever you win a round", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_realms.png")))),
    Nilfgaard("Nilfgaard", "Wins any round that ends in a draw", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_nilfgaard.png")))),
    Scoiatael("Scoia'tael", "Decide who takes the first turn in each round", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_scoiatael.png")))),
    Monsters("Monsters", "Keep a random unit card on the battlefield after each round", new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_monsters.png")))),
    ;

    private final String factionName;
    private final String ability;
    private final Image image;
    Faction(String factionName, String ability, Image image) {
        this.factionName = factionName;
        this.ability = ability;
        this.image = image;
    }

    public String getFactionName() {
        return factionName;
    }

    public String getAbility() {
        return ability;
    }

    public Image getImagePath() {
        return image;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "factionName='" + factionName + '\'' +
                ", ability='" + ability + '\'' +
                '}';
    }
}
