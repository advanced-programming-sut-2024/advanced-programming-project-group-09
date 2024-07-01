package Sample.CardEnums;

import Sample.View.LoginMenu;
import javafx.scene.image.Image;

import java.util.Objects;

public enum SpecialCard {
    Mardroeme("Mardroeme", "Mardroeme", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_mardroeme.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_mardroeme.jpg")))),
    CommandersHorn("Commander's Horn", "Double power", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_horn.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_horn.jpg")))),
    Scorch("Scorch", "Destroy highest value", 2, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_mardroeme.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_mardroeme.jpg")))),
    Decoy("Decoy", "Decoy", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_decoy.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_decoy.jpg")))),
    BitingFrost("Biting Frost", "Biting frost", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_frost.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/weather_frost.jpg")))),
    ImpenetrableFog("Impenetrable Fog", "Impenetrable fog", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_fog.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_fog.jpg")))),
    TorrentialRain("Torrential Rain", "Torrential rain", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_rain.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_rain.jpg")))),
    ;

    private final String cardName;
    private final String ability;
    private int count;
    private final Image image;
    private final Image imageForGame;

    SpecialCard(String cardName, String ability, int count, Image image, Image imageForGame) {
        this.cardName = cardName;
        this.ability = ability;
        this.count = count;
        this.image = image;
        this.imageForGame = imageForGame;
    }

    public String getCardName() {
        return cardName;
    }

    public String getAbility() {
        return ability;
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

    public Image getImage() {
        return image;
    }

    public Image getImageForGame() {
        return imageForGame;
    }

    @Override
    public String toString() {
        return "SpecialCard{" +
                "cardName='" + cardName + '\'' +
                ", ability='" + ability + '\'' +
                ", count=" + count +
                '}';
    }
}