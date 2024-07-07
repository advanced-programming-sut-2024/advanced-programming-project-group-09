package Sample.Network.Client.model.CardEnums;

import Sample.View.LoginMenu;
import javafx.scene.image.Image;

import java.util.Objects;

public enum SpecialCard {
    ClearWeather("Clear Weather", "Clear Weather", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_clear.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/weather_clear.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_weather_clearpng.png")))),
    SkelligeStorm("Skellige Storm", "Skellige Storm", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_storm.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/weather_storm.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_weather_storm.png")))),
    Mardroeme("Mardroeme", "Mardroeme", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_mardroeme.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_mardroeme.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_special_mardroeme.png")))),
    CommandersHorn("Commander's Horn", "Double power", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_horn.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_horn.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_special_horn.png")))),
    Scorch("Scorch", "Destroy highest value", 2, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_mardroeme.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_mardroeme.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_special_scorch.png")))),
    Decoy("Decoy", "Decoy", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_decoy.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/special_decoy.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_special_decoy.png")))),
    BitingFrost("Biting Frost", "Biting frost", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_frost.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardGameImages/weather_frost.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_weather_frost.png")))),
    ImpenetrableFog("Impenetrable Fog", "Impenetrable fog", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_fog.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_fog.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_weather_fog.png")))),
    TorrentialRain("Torrential Rain", "Torrential rain", 3, new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_rain.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_rain.jpg"))), new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/card_weather_rain.png")))),
    ;

    private final String cardName;
    private final String ability;
    private int count;
    private final Image image;
    private final Image imageForGame;
    private final Image imageForPower;

    SpecialCard(String cardName, String ability, int count, Image image, Image imageForGame, Image imageForPower) {
        this.cardName = cardName;
        this.ability = ability;
        this.count = count;
        this.image = image;
        this.imageForGame = imageForGame;
        this.imageForPower = imageForPower;
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

    public Image getImageForPower() {
        return imageForPower;
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