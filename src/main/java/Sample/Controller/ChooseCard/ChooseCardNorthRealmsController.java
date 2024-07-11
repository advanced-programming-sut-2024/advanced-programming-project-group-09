package Sample.Controller.ChooseCard;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;
import Sample.Controller.ApplicationController;
import Sample.Controller.LoginController;
import Sample.Model.User;
import Sample.View.GameMenu;
import Sample.View.LoginMenu;
import Sample.View.MainMenu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChooseCardNorthRealmsController {
    public Pane cardCollectionPane;
    public ImageView commanderHorn;
    public ImageView decoy;
    public ImageView mardroem;
    public ImageView scorchImage;
    public ImageView bitingFrostImage;
    public ImageView clearWeatherImage;
    public ImageView impenetrableFog;
    public ImageView skelligeStorm;
    public ImageView torrentialRain;
    public ImageView neutral_ciri;
    public ImageView neutral_geralt;
    public ImageView neutral_triss;
    public ImageView neutral_trissInDeck;
    public GridPane gridPaneCardCollection;
    public Label commandersHornRemainderInCardCollection;
    public Label decoyRemainderInCardCollection;
    public Label torrentialRainRemainderInCardCollection;
    public Label skelligeStormRemainderInCardCollection;
    public Label impenetrableFrogRemainderInCardCollection;
    public Label clearWeatherRemainderInCardCollection;
    public Label bitingFrostRemainderInCardCollection;
    public Label schorchRemainderInCardCollection;
    public Label mardroemRemainderInCardCollection;
    public VBox decoyVboxInCardCollection;
    public VBox commandersHornVboxInCardCollection;
    public VBox commandersHornVboxInDeck;
    public ImageView special_hornInDeck;
    public Label commandersHornRemainderInDeck;
    public VBox decoyVboxInDeck;
    public ImageView special_decoyInDeck;
    public Label decoyRemainderInDeck;
    public ImageView special_mardroemeInDeck;
    public Label mardroemRemainderInDeck;
    public ImageView special_scorchInDeck;
    public Label schorchRemainderInDeck;
    public ImageView weather_frostInDeck;
    public Label bitingFrostRemainderInDeck;
    public ImageView weather_clearInDeck;
    public Label clearWeatherRemainderInDeck;
    public ImageView weather_fogInDeck;
    public Label impenetrableFrogRemainderInDeck;
    public ImageView weather_stormInDeck;
    public Label skelligeStormRemainderInDeck;
    public ImageView weather_rainInDeck;
    public Label torrentialRainRemainderInDeck;
    public GridPane gridPaneInDeck;
    public Pane inDeckCardPane;
    public ImageView neutral_ciriInDeck;
    public ImageView neutral_geraltInDeck;
    public ImageView neutral_zoltan;
    public ImageView neutral_yennefer;
    public ImageView neutral_villen;
    public ImageView neutral_vesemir;
    public ImageView neutral_olgierd;
    public ImageView neutral_mysterious_elfInCardCollection;
    public ImageView neutral_gaunter_odimm_darkness;
    public ImageView neutral_gaunter_odimm;
    public ImageView neutral_emiel;
    public ImageView neutral_dandelion;
    public Label neutral_gaunter_odimm_darknessRemainderInCardCollection;
    public Label neutral_gaunter_odimm_darknessRemainderInDeck;
    public ImageView neutral_zoltanInDeck;
    public ImageView neutral_yenneferInDeck;
    public ImageView neutral_villenInDeck;
    public ImageView neutral_vesemirInDeck;
    public ImageView neutral_olgierdInDeck;
    public ImageView neutral_mysterious_elfInDeck;
    public ImageView neutral_gaunter_odimm_darknessInDeck;
    public ImageView neutral_gaunter_odimmInDeck;
    public ImageView neutral_emielInDeck;
    public ImageView neutral_chortInDeck;
    public ImageView neutral_dandelionInDeck;
    public VBox mardroemVboxInDeck;
    public VBox mardroemVboxInCardCollection;
    public VBox schorchVboxInDeck;
    public VBox bitingFrostVboxInDeck;
    public VBox clearWeatherVboxInDeck;
    public VBox impenetrableFrogVboxInDeck;
    public VBox skelligeStormVboxInDeck;
    public VBox torrentialRainVboxInDeck;
    public VBox neutral_cirVboxInDeck;
    public VBox neutral_geraltVboxInDeck;
    public VBox neutral_ciriVboxInDeck;
    public VBox neutral_zoltanVboxInDeck;
    public VBox neutral_yenneferVboxInDeck;
    public VBox neutral_villenVboxInDeck;
    public VBox neutral_vesemirVboxInDeck;
    public VBox neutral_olgierdVboxInDeck;
    public VBox neutral_mysterious_elfVboxInDeck;
    public VBox neutral_gaunter_odimm_darknessVboxInDeck;
    public VBox neutral_gaunter_odimmVboxInDeck;
    public VBox neutral_emielVboxInDeck;
    public VBox neutral_chordVboxInDeck;
    public VBox neutral_dandelionVboxInDeck;
    public VBox neutral_chortVboxInDeck;
    public VBox neutral_trissVboxInDeck;
    public VBox schorchVboxInCardCollection;
    public VBox bitingFrostVboxInCardCollection;
    public VBox clearWeatherVboxInCardCollection;
    public VBox impenetrableFrogVboxInCardCollection;
    public VBox skelligeStormVboxInCardCollection;
    public VBox torrentialRainVboxInCardCollection;
    public VBox neutral_ciriVboxInCardCollection;
    public VBox neutral_geraltVboxInCardCollection;
    public VBox neutral_zoltanVboxInCardCollection;
    public VBox neutral_yenneferVboxInCardCollection;
    public VBox neutral_villenVboxInCardCollection;
    public VBox neutral_vesemirVboxInCardCollection;
    public VBox neutral_olgierdVboxInDecInCardCollection;
    public VBox neutral_olgierdVboxInCardCollection;
    public VBox neutral_gaunter_odimm_darknessVboxInCardCollection;
    public VBox neutral_gaunter_odimmVboxInCardCollection;
    public VBox neutral_emielVboxInCardCollection;
    public VBox neutral_trissVboxInCardCollection;
    public VBox neutral_chortVboxInCardCollection;
    public VBox neutral_dandelionVboxInCardCollection;
    public Text leaderName;
    public Button uploadDeckButton;
    public Button changeFactionButton;
    public Button downloadDeckButton;
    public Text numberOfAllCards;
    public Text specialCards;
    public Text heroCards;
    public Button startGameButton;
    public Button backToLeaderMenu;
    public VBox realms_yarpenVboxInCardCollection;
    public ImageView realms_yarpenInCardCollection;
    public VBox realms_vesVboxInCardCollection;
    public ImageView realms_vesInCardCollection;
    public VBox realms_vernonVboxInCardCollection;
    public ImageView realms_vernonInCardCollection;
    public VBox realms_kaedwen_siegeVboxInCardCollection;
    public ImageView realms_kaedwen_siegeInCardCollection;
    public Label realms_kaedwen_siegeRemainderInCardCollection;
    public VBox realms_thalerVboxInCardCollection;
    public ImageView realms_thalerInCardCollection;
    public VBox realms_stennisVboxInCardCollection;
    public ImageView realms_stennisInCardCollection;
    public VBox realms_siegfriedVboxInCardCollection;
    public ImageView realms_siegfriedInCardCollection;
    public VBox realms_siege_towerVboxInCardCollection;
    public ImageView realms_siege_towerInCardCollection;
    public VBox realms_sheldonVboxInCardCollection;
    public ImageView realms_sheldonInCardCollection;
    public VBox realms_shealaVboxInCardCollection;
    public ImageView realms_shealaInCardCollection;
    public VBox realms_sabrinaVboxInCardCollection;
    public ImageView realms_sabrinaInCardCollection;
    public VBox realms_philippaVboxInCardCollection;
    public ImageView realms_philippaInCardCollection;
    public VBox realms_natalisVboxInCardCollection;
    public ImageView realms_natalisInCardCollection;
    public VBox realms_keiraVboxInCardCollection;
    public ImageView realms_keiraInCardCollection;
    public VBox realms_dijkstraVboxInCardCollection;
    public ImageView realms_dijkstraInCardCollection;
    public VBox realms_dethmoldVboxInCardCollection;
    public ImageView realms_dethmoldInCardCollection;
    public VBox realms_crinfridVboxInCardCollection;
    public ImageView realms_crinfridInCardCollection;
    public VBox realms_catapult_1VboxInCardCollection;
    public ImageView realms_catapult_1InCardCollection;
    public VBox realms_banner_nurseVboxInCardCollection;
    public ImageView realms_banner_nurseInCardCollection;
    public VBox realms_ballistaVboxInCardCollection;
    public ImageView realms_ballistaInCardCollection;
    public VBox realms_yarpenVboxInDeck;
    public ImageView realms_yarpenInDeck;
    public VBox realms_vesVboxInDeck;
    public ImageView realms_vesInDeck;
    public VBox realms_vernonVboxInDeck;
    public ImageView realms_vernonInDeck;
    public VBox realms_trebuchetVboxInDeck;
    public ImageView realms_trebuchet;
    public Label realms_trebuchetRemainderInDeck;
    public VBox realms_redaniaVboxInDeck;
    public ImageView realms_redania;
    public Label realms_redaniaRemainderInDeck;
    public VBox realms_thalerVboxInDeck;
    public ImageView realms_thalerInDeck;
    public VBox realms_stennisVboxInDeck;
    public ImageView realms_stennisInDeck;
    public VBox realms_siegfriedVboxInDeck;
    public ImageView realms_siegfriedInDeck;
    public VBox realms_siege_towerVboxInDeck;
    public ImageView realms_siege_towerInDeck;
    public VBox realms_sheldonVboxInDeck;
    public ImageView realms_sheldonInDeck;
    public VBox realms_shealaVboxInDeck;
    public ImageView realms_shealaInDeck;
    public VBox realms_sabrinaVboxInDeck;
    public ImageView realms_sabrinaInDeck;
    public VBox realms_philippaVboxInDeck;
    public ImageView realms_philippaInDeck;
    public VBox realms_natalisVboxInDeck;
    public ImageView realms_natalisInDeck;
    public VBox realms_keiraVboxInDeck;
    public ImageView realms_keiraInDeck;
    public VBox realms_dijkstraVboxInDeck;
    public ImageView realms_dijkstraInDeck;
    public VBox realms_dethmoldVboxInDeck;
    public ImageView realms_dethmoldInDeck;
    public VBox realms_crinfridVboxInDeck;
    public ImageView realms_crinfridInDeck;
    public VBox realms_catapult_1VboxInDeck;
    public ImageView realms_catapult_1InDeck;
    public VBox realms_banner_nurseVboxInDeck;
    public ImageView realms_banner_nurseInDeck;
    public VBox realms_ballistaVboxInDeck;
    public ImageView realms_ballistaInDeck;
    public VBox realms_kaedwen_siegeVboxInDeck;
    public ImageView realms_kaedwen_siegeInDeck;
    public Label realms_kaedwen_siegeRemainderInDeck;
    public Label realms_catapult_1RemainderInCardCollection;
    public Label realms_catapult_1RemainderInDeck;
    public Label realms_crinfridRemainderInDeck;
    public Label realms_crinfridRemainderInCardCollection;
    ArrayList<VBox> imageViewsVboxesCardCollection = new ArrayList<>();
    ArrayList<VBox> imageViewsVboxesCardInDeck = new ArrayList<>();
    ArrayList<VBox> specialCardVboxesInDeck = new ArrayList<>();
    ArrayList<VBox> heroCardsVboxes = new ArrayList<>();
    @FXML
    private VBox neutral_mysterious_elfVboxInCardCollection;
    private VBox monsters_draugVboxInDeck;
    private VBox monsters_imlerithVboxInDeck;
    private VBox monsters_leshenVboxInDeck;
    private VBox monsters_kayranVboxInDeck;

    public void initialize() {
        User.getUserLoginIn().getCommonCardsInDeck().clear();
        User.getUserLoginIn().getSpecialCardsInDeck().clear();
        createHeroCardList();
        createSpecialCardList();
        setImagesForCardCollection();
        setImagesForCardsInDeck();
        imageViewsVboxesCardCollection = createListOfVBoxesForCardCollection();
        imageViewsVboxesCardInDeck = createListOfVBoxesForCardInDeck();
        setAllCardImages();
        createTimelineForUpdating();
    }

    private void setAllCardImages() {
        outer:
        for (int row = 0; row < (imageViewsVboxesCardCollection.size() / 3) + 1; row++) {
            for (int column = 0; column < 3; column++) {
                if (3 * row + column >= imageViewsVboxesCardCollection.size()) break;
                gridPaneCardCollection.add(imageViewsVboxesCardCollection.get(3 * row + column), column, row);
            }
        }
        for (int row = 0; row < (imageViewsVboxesCardInDeck.size() / 3) + 1; row++) {
            for (int column = 0; column < 3; column++) {
                if (3 * row + column >= imageViewsVboxesCardInDeck.size()) break;
                gridPaneInDeck.add(imageViewsVboxesCardInDeck.get(3 * row + column), column, row);
            }
        }
    }

    private void createTimelineForUpdating() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), event -> {
            updateNumberOfSpecialCards();
            updateNumberOfAllCards();
            updateNumberOfHeroes();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    private ArrayList<VBox> createListOfVBoxesForCardInDeck() {
        ArrayList<VBox> imageViews = new ArrayList<>();
        for (Node child : inDeckCardPane.getChildren()) {
            if (child instanceof VBox) {
                imageViews.add((VBox) child);
                System.out.println(child);
                child.setVisible(false);
            }
            if (child instanceof StackPane) child = ((StackPane) child).getChildren().getFirst();
        }
        return imageViews;
    }

    private void setImagesForCardCollection() {
// TODO : NEUTRAL  -> SHOULD BE COPIED FOR ALL DECK
        commanderHorn.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_horn.jpg"))));
        decoy.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_decoy.jpg"))));
        mardroem.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_mardroeme.jpg"))));
        scorchImage.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_scorch.jpg"))));
        bitingFrostImage.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_frost.jpg"))));
        impenetrableFog.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_fog.jpg"))));
        clearWeatherImage.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_clear.jpg"))));
        skelligeStorm.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_storm.jpg"))));
        torrentialRain.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_rain.jpg"))));
        neutral_ciri.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_ciri.jpg"))));
        neutral_geralt.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_geralt.jpg"))));
        neutral_triss.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_triss.jpg"))));
        neutral_zoltan.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_zoltan.jpg"))));
        neutral_yennefer.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_yennefer.jpg"))));
        neutral_villen.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_villen.jpg"))));
        neutral_vesemir.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_vesemir.jpg"))));
        neutral_olgierd.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_olgierd.jpg"))));
        neutral_mysterious_elfInCardCollection.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_mysterious_elf.jpg"))));
        neutral_gaunter_odimm_darkness.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_gaunter_odimm_darkness.jpg"))));
        neutral_gaunter_odimm.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_gaunter_odimm.jpg"))));
        neutral_emiel.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_emiel.jpg"))));
        neutral_dandelion.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_dandelion.jpg"))));
//        neutral_chort.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_chort.jpg"))));
// TODO : NEUTRAL  -> SHOULD BE COPIED FOR ALL DECK
        realms_yarpenInCardCollection.setImage(CommonCard.YarpenZirgrin.getImage());
        realms_vesInCardCollection.setImage(CommonCard.Ves.getImage());
        realms_vernonInCardCollection.setImage(CommonCard.VernonRoche.getImage());
        realms_kaedwen_siegeInCardCollection.setImage(CommonCard.KaedweniSiegeExpert.getImage());
        realms_thalerInCardCollection.setImage(CommonCard.Thaler.getImage());
        realms_stennisInCardCollection.setImage(CommonCard.PrinceStennis.getImage());
        realms_siegfriedInCardCollection.setImage(CommonCard.SiegfriedOfDenesle.getImage());
        realms_siege_towerInCardCollection.setImage(CommonCard.SiegeTower.getImage());
        realms_sheldonInCardCollection.setImage(CommonCard.SheldonSkaggs.getImage());
        realms_shealaInCardCollection.setImage(CommonCard.SileDeTansarville.getImage());
        realms_sabrinaInCardCollection.setImage(CommonCard.SabrinaGlevissing.getImage());
        realms_natalisInCardCollection.setImage(CommonCard.JohnNatalis.getImage());
        neutral_mysterious_elfInCardCollection.setImage(CommonCard.MysteriousElf.getImage());
        realms_dijkstraInCardCollection.setImage(CommonCard.SigismundDijkstra.getImage());
        realms_dethmoldInCardCollection.setImage(CommonCard.Dethmold.getImage());
        realms_crinfridInCardCollection.setImage(CommonCard.CrinfridReaversDragonHunter.getImage());
        realms_catapult_1InCardCollection.setImage(CommonCard.Catapult.getImage());
        realms_banner_nurseInCardCollection.setImage(CommonCard.DunBannerMedic.getImage());
        realms_ballistaInCardCollection.setImage(CommonCard.Ballista.getImage());
        realms_keiraInCardCollection.setImage(CommonCard.KeiraMetz.getImage());
        realms_philippaInCardCollection.setImage(CommonCard.PhilippaEilhart.getImage());

    }

    private void setImagesForCardsInDeck() {
// TODO : NEUTRAL  -> SHOULD BE COPIED FOR ALL DECK
        special_hornInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_horn.jpg"))));
        special_decoyInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_decoy.jpg"))));
        special_mardroemeInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_mardroeme.jpg"))));
        special_scorchInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/special_scorch.jpg"))));
        weather_frostInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_frost.jpg"))));
        weather_fogInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_fog.jpg"))));
        weather_clearInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_clear.jpg"))));
        weather_stormInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_storm.jpg"))));
        weather_rainInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/weather_rain.jpg"))));
        neutral_ciriInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_ciri.jpg"))));
        neutral_geraltInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_geralt.jpg"))));
        neutral_trissInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_triss.jpg"))));
        neutral_zoltanInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_zoltan.jpg"))));
        neutral_yenneferInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_yennefer.jpg"))));
        neutral_villenInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_villen.jpg"))));
        neutral_vesemirInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_vesemir.jpg"))));
        neutral_olgierdInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_olgierd.jpg"))));
        neutral_mysterious_elfInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_mysterious_elf.jpg"))));
        neutral_gaunter_odimm_darknessInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_gaunter_odimm_darkness.jpg"))));
        neutral_gaunter_odimmInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_gaunter_odimm.jpg"))));
        neutral_emielInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_emiel.jpg"))));
        neutral_dandelionInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_dandelion.jpg"))));
//        neutral_chortInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/neutral_chort.jpg"))));

// TODO : NEUTRAL  -> SHOULD BE COPIED FOR ALL DECK
        realms_keiraInDeck.setImage(CommonCard.KeiraMetz.getImage());
        realms_yarpenInDeck.setImage(CommonCard.YarpenZirgrin.getImage());
        realms_vesInDeck.setImage(CommonCard.Ves.getImage());
        realms_vernonInDeck.setImage(CommonCard.VernonRoche.getImage());
        realms_kaedwen_siegeInDeck.setImage(CommonCard.KaedweniSiegeExpert.getImage());
        realms_thalerInDeck.setImage(CommonCard.Thaler.getImage());
        realms_stennisInDeck.setImage(CommonCard.PrinceStennis.getImage());
        realms_siegfriedInDeck.setImage(CommonCard.SiegfriedOfDenesle.getImage());
        realms_siege_towerInDeck.setImage(CommonCard.SiegeTower.getImage());
        realms_sheldonInDeck.setImage(CommonCard.SheldonSkaggs.getImage());
        realms_shealaInDeck.setImage(CommonCard.SileDeTansarville.getImage());
        realms_sabrinaInDeck.setImage(CommonCard.SabrinaGlevissing.getImage());
        realms_natalisInDeck.setImage(CommonCard.JohnNatalis.getImage());
        neutral_mysterious_elfInDeck.setImage(CommonCard.MysteriousElf.getImage());
        realms_dijkstraInDeck.setImage(CommonCard.SigismundDijkstra.getImage());
        realms_dethmoldInDeck.setImage(CommonCard.Dethmold.getImage());
        realms_crinfridInDeck.setImage(CommonCard.CrinfridReaversDragonHunter.getImage());
        realms_catapult_1InDeck.setImage(CommonCard.Catapult.getImage());
        realms_banner_nurseInDeck.setImage(CommonCard.DunBannerMedic.getImage());
        realms_ballistaInDeck.setImage(CommonCard.Ballista.getImage());
        realms_philippaInDeck.setImage(CommonCard.PhilippaEilhart.getImage());

    }

    public void createSpecialCardList() {
        specialCardVboxesInDeck.add(decoyVboxInDeck);
        specialCardVboxesInDeck.add(commandersHornVboxInDeck);
        specialCardVboxesInDeck.add(mardroemVboxInDeck);
        specialCardVboxesInDeck.add(bitingFrostVboxInDeck);
        specialCardVboxesInDeck.add(clearWeatherVboxInDeck);
        specialCardVboxesInDeck.add(impenetrableFrogVboxInDeck);
        specialCardVboxesInDeck.add(skelligeStormVboxInDeck);
        specialCardVboxesInDeck.add(torrentialRainVboxInDeck);
        specialCardVboxesInDeck.add(schorchVboxInDeck);

    }

    public void createHeroCardList() {
        heroCardsVboxes.add(neutral_ciriVboxInDeck);
        heroCardsVboxes.add(neutral_geraltVboxInDeck);
        heroCardsVboxes.add(monsters_draugVboxInDeck);
        heroCardsVboxes.add(monsters_imlerithVboxInDeck);
        heroCardsVboxes.add(monsters_leshenVboxInDeck);
        heroCardsVboxes.add(monsters_kayranVboxInDeck);
        heroCardsVboxes.add(neutral_trissVboxInDeck);
        heroCardsVboxes.add(neutral_yenneferVboxInDeck);
        heroCardsVboxes.add(neutral_mysterious_elfVboxInDeck);

    }

    private void updateNumberOfHeroes() {
        int heroCard = 0;
        for (VBox child : imageViewsVboxesCardInDeck) {
            if (child.isVisible() && heroCardsVboxes.contains(child)) {
                if (child.getChildren().size() == 1) heroCard++;
                else {
                    for (Node node : child.getChildren()) {
                        if (node instanceof Label) {
                            heroCard += Integer.parseInt(((Label) node).getText().substring(0, 1));
                        }
                    }
                }
            }
        }
        heroCards.setText("Hero Cards:  " + heroCard);
    }

    public void updateNumberOfSpecialCards() {
        int specialCard = 0;
        for (VBox child : imageViewsVboxesCardInDeck) {
            if (child.isVisible() && specialCardVboxesInDeck.contains(child)) {
                if (!(child.getChildren().getFirst() instanceof StackPane)) specialCard++;
                else {
                    for (Node node2 : child.getChildren()) {
                        StackPane stackPane = (StackPane) node2;
                        for (Node node : stackPane.getChildren()) {
                            if (node instanceof Label) {
                                specialCard += Integer.parseInt(((Label) node).getText().substring(0, 1));
                            }
                        }

                    }
                }
            }
        }
        specialCards.setText("Special Cards: " + specialCard + "/10");
    }

    public void updateNumberOfAllCards() {
        updateNumberOfSpecialCards();
        int allCards = 0;
        for (VBox child : imageViewsVboxesCardInDeck) {
            if (child.isVisible()) {
                if (!(child.getChildren().getFirst() instanceof StackPane)) allCards++;
                else {
                    for (Node node2 : child.getChildren()) {
                        StackPane stackPane = (StackPane) node2;
                        for (Node node : stackPane.getChildren()) {
                            if (node instanceof Label) {
                                allCards += Integer.parseInt(((Label) node).getText().substring(0, 1));
                            }
                        }

                    }
                }
            }
        }
        numberOfAllCards.setText("Number of Unit Cards: " + allCards + "/22");
    }


    private ArrayList<VBox> createListOfVBoxesForCardCollection() {
        ArrayList<VBox> imageViews = new ArrayList<>();


        for (Node child : cardCollectionPane.getChildren()) {
            if (child instanceof VBox) {
                imageViews.add((VBox) child);
            }
        }
        return imageViews;
    }


    public void decoyUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(decoyRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int decoyInDeck = Integer.parseInt(decoyRemainderInDeck.getText().substring(0, 1));
            if (decoyInDeck == 1) {
                decoyVboxInDeck.setVisible(false);
            }
            decoyInDeck--;
            decoyRemainderInDeck.setText(decoyInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int decoyInCardCollection = Integer.parseInt(decoyRemainderInCardCollection.getText().substring(0, 1));
            if (decoyInCardCollection == 0) {
                decoyVboxInCardCollection.setVisible(true);
            }
            decoyInCardCollection++;
            decoyRemainderInCardCollection.setText(decoyInCardCollection + "X");
        }
        decoyRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void decoySelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(decoyRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int decoyInCardCollection = Integer.parseInt(decoyRemainderInCardCollection.getText().substring(0, 1));
            if (decoyInCardCollection == 1) {
                decoyVboxInCardCollection.setVisible(false);
            }
            decoyInCardCollection--;
            decoyRemainderInCardCollection.setText(decoyInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int decoyInDeck = Integer.parseInt(decoyRemainderInDeck.getText().substring(0, 1));
            if (decoyInDeck == 0) {
                decoyVboxInDeck.setVisible(true);
            }
            decoyInDeck++;
            decoyRemainderInDeck.setText(decoyInDeck + "X");
        }
        decoyRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void commandersHornUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(commandersHornRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0) {
//            deleteOneCommandersHornFromDeck();
            int commandersHornInDeck = Integer.parseInt(commandersHornRemainderInDeck.getText().substring(0, 1));
            if (commandersHornInDeck == 1) {
                commandersHornVboxInDeck.setVisible(false);
            }
            commandersHornInDeck--;
            commandersHornRemainderInDeck.setText(commandersHornInDeck + "X");

        }
//        addOneCommandersHornToCardCollection();
        {
            int commandersHornInCardCollection = Integer.parseInt(commandersHornRemainderInCardCollection.getText().substring(0, 1));
            if (commandersHornInCardCollection == 0) {
                commandersHornVboxInCardCollection.setVisible(true);
            }
            commandersHornInCardCollection++;
            commandersHornRemainderInCardCollection.setText(commandersHornInCardCollection + "X");
        }
        commandersHornRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void commandersHornSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(commandersHornRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneCommandersHornFromCardCollection();
            {
                int commandersHornInCardCollection = Integer.parseInt(commandersHornRemainderInCardCollection.getText().substring(0, 1));
                if (commandersHornInCardCollection == 1) {
                    commandersHornVboxInCardCollection.setVisible(false);
                }
                commandersHornInCardCollection--;
                commandersHornRemainderInCardCollection.setText(commandersHornInCardCollection + "X");
            }
        }
//        addOneCommandersHornToDeck();
        {
            int commandersHornInDeck = Integer.parseInt(commandersHornRemainderInDeck.getText().substring(0, 1));
            if (commandersHornInDeck == 0) {
                commandersHornVboxInDeck.setVisible(true);
            }
            commandersHornInDeck++;
            commandersHornRemainderInDeck.setText(commandersHornInDeck + "X");
        }
        commandersHornRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void mardroemUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(mardroemRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int mardroemInDeck = Integer.parseInt(mardroemRemainderInDeck.getText().substring(0, 1));
            if (mardroemInDeck == 1) {
                mardroemVboxInDeck.setVisible(false);
            }
            mardroemInDeck--;
            mardroemRemainderInDeck.setText(mardroemInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int mardroemInCardCollection = Integer.parseInt(mardroemRemainderInCardCollection.getText().substring(0, 1));
            if (mardroemInCardCollection == 0) {
                mardroemVboxInCardCollection.setVisible(true);
            }
            mardroemInCardCollection++;
            mardroemRemainderInCardCollection.setText(mardroemInCardCollection + "X");
        }
        mardroemRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void mardroemSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(mardroemRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int mardroemInCardCollection = Integer.parseInt(mardroemRemainderInCardCollection.getText().substring(0, 1));
            if (mardroemInCardCollection == 1) {
                mardroemVboxInCardCollection.setVisible(false);
            }
            mardroemInCardCollection--;
            mardroemRemainderInCardCollection.setText(mardroemInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int mardroemInDeck = Integer.parseInt(mardroemRemainderInDeck.getText().substring(0, 1));
            if (mardroemInDeck == 0) {
                mardroemVboxInDeck.setVisible(true);
            }
            mardroemInDeck++;
            mardroemRemainderInDeck.setText(mardroemInDeck + "X");
        }
        mardroemRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void schorchUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(schorchRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int schorchInDeck = Integer.parseInt(schorchRemainderInDeck.getText().substring(0, 1));
            if (schorchInDeck == 1) {
                schorchVboxInDeck.setVisible(false);
            }
            schorchInDeck--;
            schorchRemainderInDeck.setText(schorchInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int schorchInCardCollection = Integer.parseInt(schorchRemainderInCardCollection.getText().substring(0, 1));
            if (schorchInCardCollection == 0) {
                schorchVboxInCardCollection.setVisible(true);
            }
            schorchInCardCollection++;
            schorchRemainderInCardCollection.setText(schorchInCardCollection + "X");
        }
        schorchRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void neutral_gaunter_odimm_darknessSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(neutral_gaunter_odimm_darknessRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int neutral_gaunter_odimm_darknessInCardCollection = Integer.parseInt(neutral_gaunter_odimm_darknessRemainderInCardCollection.getText().substring(0, 1));
            if (neutral_gaunter_odimm_darknessInCardCollection == 1) {
                neutral_gaunter_odimm_darknessVboxInCardCollection.setVisible(false);
            }
            neutral_gaunter_odimm_darknessInCardCollection--;
            neutral_gaunter_odimm_darknessRemainderInCardCollection.setText(neutral_gaunter_odimm_darknessInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int neutral_gaunter_odimm_darknessInDeck = Integer.parseInt(neutral_gaunter_odimm_darknessRemainderInDeck.getText().substring(0, 1));
            if (neutral_gaunter_odimm_darknessInDeck == 0) {
                neutral_gaunter_odimm_darknessVboxInDeck.setVisible(true);
            }
            neutral_gaunter_odimm_darknessInDeck++;
            neutral_gaunter_odimm_darknessRemainderInDeck.setText(neutral_gaunter_odimm_darknessInDeck + "X");

        }
        neutral_gaunter_odimm_darknessRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void neutral_gaunter_odimm_darknessUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(neutral_gaunter_odimm_darknessRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int neutral_gaunter_odimm_darknessInDeck = Integer.parseInt(neutral_gaunter_odimm_darknessRemainderInDeck.getText().substring(0, 1));
            if (neutral_gaunter_odimm_darknessInDeck == 1) {
                neutral_gaunter_odimm_darknessVboxInDeck.setVisible(false);
            }
            neutral_gaunter_odimm_darknessInDeck--;
            neutral_gaunter_odimm_darknessRemainderInDeck.setText(neutral_gaunter_odimm_darknessInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int neutral_gaunter_odimm_darknessInCardCollection = Integer.parseInt(neutral_gaunter_odimm_darknessRemainderInCardCollection.getText().substring(0, 1));
            if (neutral_gaunter_odimm_darknessInCardCollection == 0) {
                neutral_gaunter_odimm_darknessVboxInCardCollection.setVisible(true);
            }
            neutral_gaunter_odimm_darknessInCardCollection++;
            neutral_gaunter_odimm_darknessRemainderInCardCollection.setText(neutral_gaunter_odimm_darknessInCardCollection + "X");
        }
        neutral_gaunter_odimm_darknessRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void schorchSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(schorchRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int schorchInCardCollection = Integer.parseInt(schorchRemainderInCardCollection.getText().substring(0, 1));
            if (schorchInCardCollection == 1) {
                schorchVboxInCardCollection.setVisible(false);
            }
            schorchInCardCollection--;
            schorchRemainderInCardCollection.setText(schorchInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int schorchInDeck = Integer.parseInt(schorchRemainderInDeck.getText().substring(0, 1));
            if (schorchInDeck == 0) {
                schorchVboxInDeck.setVisible(true);
            }
            schorchInDeck++;
            schorchRemainderInDeck.setText(schorchInDeck + "X");
        }
        schorchRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void bitingFrostUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(bitingFrostRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int bitingFrostInDeck = Integer.parseInt(bitingFrostRemainderInDeck.getText().substring(0, 1));
            if (bitingFrostInDeck == 1) {
                bitingFrostVboxInDeck.setVisible(false);
            }
            bitingFrostInDeck--;
            bitingFrostRemainderInDeck.setText(bitingFrostInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int bitingFrostInCardCollection = Integer.parseInt(bitingFrostRemainderInCardCollection.getText().substring(0, 1));
            if (bitingFrostInCardCollection == 0) {
                bitingFrostVboxInCardCollection.setVisible(true);
            }
            bitingFrostInCardCollection++;
            bitingFrostRemainderInCardCollection.setText(bitingFrostInCardCollection + "X");
        }
        bitingFrostRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void bitingFrostSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(bitingFrostRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int bitingFrostInCardCollection = Integer.parseInt(bitingFrostRemainderInCardCollection.getText().substring(0, 1));
            if (bitingFrostInCardCollection == 1) {
                bitingFrostVboxInCardCollection.setVisible(false);
            }
            bitingFrostInCardCollection--;
            bitingFrostRemainderInCardCollection.setText(bitingFrostInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int bitingFrostInDeck = Integer.parseInt(bitingFrostRemainderInDeck.getText().substring(0, 1));
            if (bitingFrostInDeck == 0) {
                bitingFrostVboxInDeck.setVisible(true);
            }
            bitingFrostInDeck++;
            bitingFrostRemainderInDeck.setText(bitingFrostInDeck + "X");
        }
        bitingFrostRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void clearWeatherUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(clearWeatherRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int clearWeatherInDeck = Integer.parseInt(clearWeatherRemainderInDeck.getText().substring(0, 1));
            if (clearWeatherInDeck == 1) {
                clearWeatherVboxInDeck.setVisible(false);
            }
            clearWeatherInDeck--;
            clearWeatherRemainderInDeck.setText(clearWeatherInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int clearWeatherInCardCollection = Integer.parseInt(clearWeatherRemainderInCardCollection.getText().substring(0, 1));
            if (clearWeatherInCardCollection == 0) {
                clearWeatherVboxInCardCollection.setVisible(true);
            }
            clearWeatherInCardCollection++;
            clearWeatherRemainderInCardCollection.setText(clearWeatherInCardCollection + "X");
        }
        clearWeatherRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void clearWeatherSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(clearWeatherRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int clearWeatherInCardCollection = Integer.parseInt(clearWeatherRemainderInCardCollection.getText().substring(0, 1));
            if (clearWeatherInCardCollection == 1) {
                clearWeatherVboxInCardCollection.setVisible(false);
            }
            clearWeatherInCardCollection--;
            clearWeatherRemainderInCardCollection.setText(clearWeatherInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int clearWeatherInDeck = Integer.parseInt(clearWeatherRemainderInDeck.getText().substring(0, 1));
            if (clearWeatherInDeck == 0) {
                clearWeatherVboxInDeck.setVisible(true);
            }
            clearWeatherInDeck++;
            clearWeatherRemainderInDeck.setText(clearWeatherInDeck + "X");
        }
        clearWeatherRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void impenetrableFrogUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(impenetrableFrogRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int impenetrableFrogInDeck = Integer.parseInt(impenetrableFrogRemainderInDeck.getText().substring(0, 1));
            if (impenetrableFrogInDeck == 1) {
                impenetrableFrogVboxInDeck.setVisible(false);
            }
            impenetrableFrogInDeck--;
            impenetrableFrogRemainderInDeck.setText(impenetrableFrogInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int impenetrableFrogInCardCollection = Integer.parseInt(impenetrableFrogRemainderInCardCollection.getText().substring(0, 1));
            if (impenetrableFrogInCardCollection == 0) {
                impenetrableFrogVboxInCardCollection.setVisible(true);
            }
            impenetrableFrogInCardCollection++;
            impenetrableFrogRemainderInCardCollection.setText(impenetrableFrogInCardCollection + "X");
        }
        impenetrableFrogRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void impenetrableFrogSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(impenetrableFrogRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int impenetrableFrogInCardCollection = Integer.parseInt(impenetrableFrogRemainderInCardCollection.getText().substring(0, 1));
            if (impenetrableFrogInCardCollection == 1) {
                impenetrableFrogVboxInCardCollection.setVisible(false);
            }
            impenetrableFrogInCardCollection--;
            impenetrableFrogRemainderInCardCollection.setText(impenetrableFrogInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int impenetrableFrogInDeck = Integer.parseInt(impenetrableFrogRemainderInDeck.getText().substring(0, 1));
            if (impenetrableFrogInDeck == 0) {
                impenetrableFrogVboxInDeck.setVisible(true);
            }
            impenetrableFrogInDeck++;
            impenetrableFrogRemainderInDeck.setText(impenetrableFrogInDeck + "X");
        }
        impenetrableFrogRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void skelligeStromUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(skelligeStormRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int skelligeStormInDeck = Integer.parseInt(skelligeStormRemainderInDeck.getText().substring(0, 1));
            if (skelligeStormInDeck == 1) {
                skelligeStormVboxInDeck.setVisible(false);
            }
            skelligeStormInDeck--;
            skelligeStormRemainderInDeck.setText(skelligeStormInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int skelligeStormInCardCollection = Integer.parseInt(skelligeStormRemainderInCardCollection.getText().substring(0, 1));
            if (skelligeStormInCardCollection == 0) {
                skelligeStormVboxInCardCollection.setVisible(true);
            }
            skelligeStormInCardCollection++;
            skelligeStormRemainderInCardCollection.setText(skelligeStormInCardCollection + "X");
        }
        skelligeStormRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void skelligeStormSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(skelligeStormRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int skelligeStormInCardCollection = Integer.parseInt(skelligeStormRemainderInCardCollection.getText().substring(0, 1));
            if (skelligeStormInCardCollection == 1) {
                skelligeStormVboxInCardCollection.setVisible(false);
            }
            skelligeStormInCardCollection--;
            skelligeStormRemainderInCardCollection.setText(skelligeStormInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int skelligeStormInDeck = Integer.parseInt(skelligeStormRemainderInDeck.getText().substring(0, 1));
            if (skelligeStormInDeck == 0) {
                skelligeStormVboxInDeck.setVisible(true);
            }
            skelligeStormInDeck++;
            skelligeStormRemainderInDeck.setText(skelligeStormInDeck + "X");
        }
        skelligeStormRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void torrentialRainUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(torrentialRainRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int torrentialRainInDeck = Integer.parseInt(torrentialRainRemainderInDeck.getText().substring(0, 1));
            if (torrentialRainInDeck == 1) {
                torrentialRainVboxInDeck.setVisible(false);
            }
            torrentialRainInDeck--;
            torrentialRainRemainderInDeck.setText(torrentialRainInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int torrentialRainInCardCollection = Integer.parseInt(torrentialRainRemainderInCardCollection.getText().substring(0, 1));
            if (torrentialRainInCardCollection == 0) {
                torrentialRainVboxInCardCollection.setVisible(true);
            }
            torrentialRainInCardCollection++;
            torrentialRainRemainderInCardCollection.setText(torrentialRainInCardCollection + "X");
        }
        torrentialRainRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void torrentialRainSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(torrentialRainRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int torrentialRainInCardCollection = Integer.parseInt(torrentialRainRemainderInCardCollection.getText().substring(0, 1));
            if (torrentialRainInCardCollection == 1) {
                torrentialRainVboxInCardCollection.setVisible(false);
            }
            torrentialRainInCardCollection--;
            torrentialRainRemainderInCardCollection.setText(torrentialRainInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int torrentialRainInDeck = Integer.parseInt(torrentialRainRemainderInDeck.getText().substring(0, 1));
            if (torrentialRainInDeck == 0) {
                torrentialRainVboxInDeck.setVisible(true);
            }
            torrentialRainInDeck++;
            torrentialRainRemainderInDeck.setText(torrentialRainInDeck + "X");
        }
        torrentialRainRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void realms_kaedwen_siegeUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(realms_kaedwen_siegeRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int realms_kaedwen_siegeInDeck = Integer.parseInt(realms_kaedwen_siegeRemainderInDeck.getText().substring(0, 1));
            if (realms_kaedwen_siegeInDeck == 1) {
                realms_kaedwen_siegeVboxInDeck.setVisible(false);
            }
            realms_kaedwen_siegeInDeck--;
            realms_kaedwen_siegeRemainderInDeck.setText(realms_kaedwen_siegeInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int realms_kaedwen_siegeInCardCollection = Integer.parseInt(realms_kaedwen_siegeRemainderInCardCollection.getText().substring(0, 1));
            if (realms_kaedwen_siegeInCardCollection == 0) {
                realms_kaedwen_siegeVboxInCardCollection.setVisible(true);
            }
            realms_kaedwen_siegeInCardCollection++;
            realms_kaedwen_siegeRemainderInCardCollection.setText(realms_kaedwen_siegeInCardCollection + "X");
        }
        realms_kaedwen_siegeRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void realms_kaedwen_siegeSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(realms_kaedwen_siegeRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int realms_kaedwen_siegeInCardCollection = Integer.parseInt(realms_kaedwen_siegeRemainderInCardCollection.getText().substring(0, 1));
            if (realms_kaedwen_siegeInCardCollection == 1) {
                realms_kaedwen_siegeVboxInCardCollection.setVisible(false);
            }
            realms_kaedwen_siegeInCardCollection--;
            realms_kaedwen_siegeRemainderInCardCollection.setText(realms_kaedwen_siegeInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int realms_kaedwen_siegeInDeck = Integer.parseInt(realms_kaedwen_siegeRemainderInDeck.getText().substring(0, 1));
            if (realms_kaedwen_siegeInDeck == 0) {
                realms_kaedwen_siegeVboxInDeck.setVisible(true);
            }
            realms_kaedwen_siegeInDeck++;
            realms_kaedwen_siegeRemainderInDeck.setText(realms_kaedwen_siegeInDeck + "X");
        }
        realms_kaedwen_siegeRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void realms_catapult_1Unselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(realms_catapult_1RemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int realms_catapult_1InDeck = Integer.parseInt(realms_catapult_1RemainderInDeck.getText().substring(0, 1));
            if (realms_catapult_1InDeck == 1) {
                realms_catapult_1VboxInDeck.setVisible(false);
            }
            realms_catapult_1InDeck--;
            realms_catapult_1RemainderInDeck.setText(realms_catapult_1InDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int realms_catapult_1InCardCollection = Integer.parseInt(realms_catapult_1RemainderInCardCollection.getText().substring(0, 1));
            if (realms_catapult_1InCardCollection == 0) {
                realms_catapult_1VboxInCardCollection.setVisible(true);
            }
            realms_catapult_1InCardCollection++;
            realms_catapult_1RemainderInCardCollection.setText(realms_catapult_1InCardCollection + "X");
        }
        realms_catapult_1RemainderInDeck.setText(remainingInDeck + "X");
    }


    public void realms_catapult_1Selected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(realms_catapult_1RemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int realms_catapult_1InCardCollection = Integer.parseInt(realms_catapult_1RemainderInCardCollection.getText().substring(0, 1));
            if (realms_catapult_1InCardCollection == 1) {
                realms_catapult_1VboxInCardCollection.setVisible(false);
            }
            realms_catapult_1InCardCollection--;
            realms_catapult_1RemainderInCardCollection.setText(realms_catapult_1InCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int realms_catapult_1InDeck = Integer.parseInt(realms_catapult_1RemainderInDeck.getText().substring(0, 1));
            if (realms_catapult_1InDeck == 0) {
                realms_catapult_1VboxInDeck.setVisible(true);
            }
            realms_catapult_1InDeck++;
            realms_catapult_1RemainderInDeck.setText(realms_catapult_1InDeck + "X");
        }
        realms_catapult_1RemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void realms_crinfridUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(realms_crinfridRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int realms_crinfridInDeck = Integer.parseInt(realms_crinfridRemainderInDeck.getText().substring(0, 1));
            if (realms_crinfridInDeck == 1) {
                realms_crinfridVboxInDeck.setVisible(false);
            }
            realms_crinfridInDeck--;
            realms_crinfridRemainderInDeck.setText(realms_crinfridInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int realms_crinfridInCardCollection = Integer.parseInt(realms_crinfridRemainderInCardCollection.getText().substring(0, 1));
            if (realms_crinfridInCardCollection == 0) {
                realms_crinfridVboxInCardCollection.setVisible(true);
            }
            realms_crinfridInCardCollection++;
            realms_crinfridRemainderInCardCollection.setText(realms_crinfridInCardCollection + "X");
        }
        realms_crinfridRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void realms_crinfridSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(realms_crinfridRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int realms_crinfridInCardCollection = Integer.parseInt(realms_crinfridRemainderInCardCollection.getText().substring(0, 1));
            if (realms_crinfridInCardCollection == 1) {
                realms_crinfridVboxInCardCollection.setVisible(false);
            }
            realms_crinfridInCardCollection--;
            realms_crinfridRemainderInCardCollection.setText(realms_crinfridInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int realms_crinfridInDeck = Integer.parseInt(realms_crinfridRemainderInDeck.getText().substring(0, 1));
            if (realms_crinfridInDeck == 0) {
                realms_crinfridVboxInDeck.setVisible(true);
            }
            realms_crinfridInDeck++;
            realms_crinfridRemainderInDeck.setText(realms_crinfridInDeck + "X");
        }
        realms_crinfridRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void neutral_ciriUnselected(MouseEvent mouseEvent) {
        neutral_ciriVboxInCardCollection.setVisible(true);
        neutral_ciriVboxInDeck.setVisible(false);
    }


    public void neutral_ciriSelected(MouseEvent mouseEvent) {
        neutral_ciriVboxInCardCollection.setVisible(false);
        neutral_ciriVboxInDeck.setVisible(true);
    }

    public void neutral_geraltUnselected(MouseEvent mouseEvent) {
        neutral_geraltVboxInCardCollection.setVisible(true);
        neutral_geraltVboxInDeck.setVisible(false);
    }


    public void neutral_geraltSelected(MouseEvent mouseEvent) {
        neutral_geraltVboxInCardCollection.setVisible(false);
        neutral_geraltVboxInDeck.setVisible(true);
    }

    public void neutral_trissUnselected(MouseEvent mouseEvent) {
        neutral_trissVboxInCardCollection.setVisible(true);
        neutral_trissVboxInDeck.setVisible(false);
    }


    public void neutral_trissSelected(MouseEvent mouseEvent) {
        neutral_trissVboxInCardCollection.setVisible(false);
        neutral_trissVboxInDeck.setVisible(true);
    }


    public void neutral_yenneferUnselected(MouseEvent mouseEvent) {
        neutral_yenneferVboxInCardCollection.setVisible(true);
        neutral_yenneferVboxInDeck.setVisible(false);
    }


    public void neutral_yenneferSelected(MouseEvent mouseEvent) {
        neutral_yenneferVboxInCardCollection.setVisible(false);
        neutral_yenneferVboxInDeck.setVisible(true);
    }

    public void neutral_villenUnselected(MouseEvent mouseEvent) {
        neutral_villenVboxInCardCollection.setVisible(true);
        neutral_villenVboxInDeck.setVisible(false);
    }


    public void neutral_villenSelected(MouseEvent mouseEvent) {
        neutral_villenVboxInCardCollection.setVisible(false);
        neutral_villenVboxInDeck.setVisible(true);
    }

    public void neutral_vesemirUnselected(MouseEvent mouseEvent) {
        neutral_vesemirVboxInCardCollection.setVisible(true);
        neutral_vesemirVboxInDeck.setVisible(false);
    }


    public void neutral_vesemirSelected(MouseEvent mouseEvent) {
        neutral_vesemirVboxInCardCollection.setVisible(false);
        neutral_vesemirVboxInDeck.setVisible(true);
    }

    public void neutral_olgierdUnselected(MouseEvent mouseEvent) {
        neutral_olgierdVboxInCardCollection.setVisible(true);
        neutral_olgierdVboxInDeck.setVisible(false);
    }


    public void neutral_olgierdSelected(MouseEvent mouseEvent) {
        neutral_olgierdVboxInCardCollection.setVisible(false);
        neutral_olgierdVboxInDeck.setVisible(true);
    }

    public void neutral_mysteriousUnselected(MouseEvent mouseEvent) {
        neutral_mysterious_elfVboxInCardCollection.setVisible(true);
        neutral_mysterious_elfVboxInDeck.setVisible(false);
    }

    public void neutral_mysteriousSelected(MouseEvent mouseEvent) {
        neutral_mysterious_elfVboxInCardCollection.setVisible(false);
        neutral_mysterious_elfVboxInDeck.setVisible(true);
    }


    public void neutral_gaunter_odimmSelected(MouseEvent mouseEvent) {
        neutral_gaunter_odimmVboxInCardCollection.setVisible(false);
        neutral_gaunter_odimmVboxInDeck.setVisible(true);
    }

    public void neutral_gaunter_odimmUnselected(MouseEvent mouseEvent) {
        neutral_gaunter_odimmVboxInCardCollection.setVisible(true);
        neutral_gaunter_odimmVboxInDeck.setVisible(false);
    }

    public void neutral_emielSelected(MouseEvent mouseEvent) {
        neutral_emielVboxInCardCollection.setVisible(false);
        neutral_emielVboxInDeck.setVisible(true);
    }

    public void neutral_emielUnselected(MouseEvent mouseEvent) {
        neutral_emielVboxInCardCollection.setVisible(true);
        neutral_emielVboxInDeck.setVisible(false);
    }

    public void neutral_dandelionSelected(MouseEvent mouseEvent) {
        neutral_dandelionVboxInCardCollection.setVisible(false);
        neutral_dandelionVboxInDeck.setVisible(true);
    }

    public void neutral_dandelionUnselected(MouseEvent mouseEvent) {
        neutral_dandelionVboxInCardCollection.setVisible(true);
        neutral_dandelionVboxInDeck.setVisible(false);
    }

    public void neutral_zoltanSelected(MouseEvent mouseEvent) {
        neutral_zoltanVboxInCardCollection.setVisible(false);
        neutral_zoltanVboxInDeck.setVisible(true);
    }

    public void neutral_zoltanUnselected(MouseEvent mouseEvent) {
        neutral_zoltanVboxInCardCollection.setVisible(true);
        neutral_zoltanVboxInDeck.setVisible(false);
    }


    public void neutral_mysterious_elfSelected(MouseEvent mouseEvent) {
        neutral_mysterious_elfVboxInCardCollection.setVisible(false);
        neutral_mysterious_elfVboxInDeck.setVisible(true);
    }

    public void neutral_mysterious_elfUnselected(MouseEvent mouseEvent) {
        neutral_mysterious_elfVboxInCardCollection.setVisible(true);
        neutral_mysterious_elfVboxInDeck.setVisible(false);
    }


    public void realms_yarpenUnselected(MouseEvent mouseEvent) {
        realms_yarpenVboxInCardCollection.setVisible(true);
        realms_yarpenVboxInDeck.setVisible(false);
    }


    public void realms_yarpenSelected(MouseEvent mouseEvent) {
        realms_yarpenVboxInCardCollection.setVisible(false);
        realms_yarpenVboxInDeck.setVisible(true);
    }

    public void realms_vesUnselected(MouseEvent mouseEvent) {
        realms_vesVboxInCardCollection.setVisible(true);
        realms_vesVboxInDeck.setVisible(false);
    }


    public void realms_vesSelected(MouseEvent mouseEvent) {
        realms_vesVboxInCardCollection.setVisible(false);
        realms_vesVboxInDeck.setVisible(true);
    }

    public void realms_vernonUnselected(MouseEvent mouseEvent) {
        realms_vernonVboxInCardCollection.setVisible(true);
        realms_vernonVboxInDeck.setVisible(false);
    }


    public void realms_vernonSelected(MouseEvent mouseEvent) {
        realms_vernonVboxInCardCollection.setVisible(false);
        realms_vernonVboxInDeck.setVisible(true);
    }

//    public void realms_trebuchetUnselected(MouseEvent mouseEvent) {
//        realms_trebuchetVboxInCardCollection.setVisible(true);
//        realms_trebuchetVboxInDeck.setVisible(false);
//    }
//
//
//    public void realms_trebuchetSelected(MouseEvent mouseEvent) {
//        realms_trebuchetVboxInCardCollection.setVisible(false);
//        realms_trebuchetVboxInDeck.setVisible(true);
//    }

    public void realms_thalerUnselected(MouseEvent mouseEvent) {
        realms_thalerVboxInCardCollection.setVisible(true);
        realms_thalerVboxInDeck.setVisible(false);
    }


    public void realms_thalerSelected(MouseEvent mouseEvent) {
        realms_thalerVboxInCardCollection.setVisible(false);
        realms_thalerVboxInDeck.setVisible(true);
    }

    public void realms_stennisUnselected(MouseEvent mouseEvent) {
        realms_stennisVboxInCardCollection.setVisible(true);
        realms_stennisVboxInDeck.setVisible(false);
    }


    public void realms_stennisSelected(MouseEvent mouseEvent) {
        realms_stennisVboxInCardCollection.setVisible(false);
        realms_stennisVboxInDeck.setVisible(true);
    }

    public void realms_siegfriedUnselected(MouseEvent mouseEvent) {
        realms_siegfriedVboxInCardCollection.setVisible(true);
        realms_siegfriedVboxInDeck.setVisible(false);
    }


    public void realms_siegfriedSelected(MouseEvent mouseEvent) {
        realms_siegfriedVboxInCardCollection.setVisible(false);
        realms_siegfriedVboxInDeck.setVisible(true);
    }

    public void realms_siege_towerUnselected(MouseEvent mouseEvent) {
        realms_siege_towerVboxInCardCollection.setVisible(true);
        realms_siege_towerVboxInDeck.setVisible(false);
    }


    public void realms_siege_towerSelected(MouseEvent mouseEvent) {
        realms_siege_towerVboxInCardCollection.setVisible(false);
        realms_siege_towerVboxInDeck.setVisible(true);
    }

    public void realms_sheldonUnselected(MouseEvent mouseEvent) {
        realms_sheldonVboxInCardCollection.setVisible(true);
        realms_sheldonVboxInDeck.setVisible(false);
    }


    public void realms_sheldonSelected(MouseEvent mouseEvent) {
        realms_sheldonVboxInCardCollection.setVisible(false);
        realms_sheldonVboxInDeck.setVisible(true);
    }

    public void realms_sabrinaUnselected(MouseEvent mouseEvent) {
        realms_sabrinaVboxInCardCollection.setVisible(true);
        realms_sabrinaVboxInDeck.setVisible(false);
    }


    public void realms_sabrinaSelected(MouseEvent mouseEvent) {
        realms_sabrinaVboxInCardCollection.setVisible(false);
        realms_sabrinaVboxInDeck.setVisible(true);
    }

    public void realms_philippaUnselected(MouseEvent mouseEvent) {
        realms_philippaVboxInCardCollection.setVisible(true);
        realms_philippaVboxInDeck.setVisible(false);
    }


    public void realms_philippaSelected(MouseEvent mouseEvent) {
        realms_philippaVboxInCardCollection.setVisible(false);
        realms_philippaVboxInDeck.setVisible(true);
    }

    public void realms_natalisUnselected(MouseEvent mouseEvent) {
        realms_natalisVboxInCardCollection.setVisible(true);
        realms_natalisVboxInDeck.setVisible(false);
    }


    public void realms_natalisSelected(MouseEvent mouseEvent) {
        realms_natalisVboxInCardCollection.setVisible(false);
        realms_natalisVboxInDeck.setVisible(true);
    }

    public void realms_keiraUnselected(MouseEvent mouseEvent) {
        realms_keiraVboxInCardCollection.setVisible(true);
        realms_keiraVboxInDeck.setVisible(false);
    }


    public void realms_keiraSelected(MouseEvent mouseEvent) {
        realms_keiraVboxInCardCollection.setVisible(false);
        realms_keiraVboxInDeck.setVisible(true);
    }

    public void realms_dijkstraUnselected(MouseEvent mouseEvent) {
        realms_dijkstraVboxInCardCollection.setVisible(true);
        realms_dijkstraVboxInDeck.setVisible(false);
    }


    public void realms_dijkstraSelected(MouseEvent mouseEvent) {
        realms_dijkstraVboxInCardCollection.setVisible(false);
        realms_dijkstraVboxInDeck.setVisible(true);
    }

    public void realms_dethmoldUnselected(MouseEvent mouseEvent) {
        realms_dethmoldVboxInCardCollection.setVisible(true);
        realms_dethmoldVboxInDeck.setVisible(false);
    }


    public void realms_dethmoldSelected(MouseEvent mouseEvent) {
        realms_dethmoldVboxInCardCollection.setVisible(false);
        realms_dethmoldVboxInDeck.setVisible(true);
    }



    public void realms_banner_nurseUnselected(MouseEvent mouseEvent) {
        realms_banner_nurseVboxInCardCollection.setVisible(true);
        realms_banner_nurseVboxInDeck.setVisible(false);
    }


    public void realms_banner_nurseSelected(MouseEvent mouseEvent) {
        realms_banner_nurseVboxInCardCollection.setVisible(false);
        realms_banner_nurseVboxInDeck.setVisible(true);
    }

//    public void realms_crinfridUnselected(MouseEvent mouseEvent) {
//        realms_crinfridVboxInCardCollection.setVisible(true);
//        realms_crinfridVboxInDeck.setVisible(false);
//    }
//
//
//    public void realms_crinfridSelected(MouseEvent mouseEvent) {
//        realms_crinfridVboxInCardCollection.setVisible(false);
//        realms_crinfridVboxInDeck.setVisible(true);
//    }

    public void realms_ballistaUnselected(MouseEvent mouseEvent) {
        realms_ballistaVboxInCardCollection.setVisible(true);
        realms_ballistaVboxInDeck.setVisible(false);
    }


    public void realms_ballistaSelected(MouseEvent mouseEvent) {
        realms_ballistaVboxInCardCollection.setVisible(false);
        realms_ballistaVboxInDeck.setVisible(true);
    }

    public void realms_shealaUnselected(MouseEvent mouseEvent) {
        realms_shealaVboxInCardCollection.setVisible(true);
        realms_shealaVboxInDeck.setVisible(false);
    }


    public void realms_shealaSelected(MouseEvent mouseEvent) {
        realms_shealaVboxInCardCollection.setVisible(false);
        realms_shealaVboxInDeck.setVisible(true);
    }

    public SpecialCard getSpecialCardByIdAddress(String address) {
        return ChooseCardMonsterController.getSpecialCardByIdAddress(address);
    }

    public CommonCard getCommonCardByIdAddress(String address) {
        return ChooseCardMonsterController.getCommonCardByIdAddress(address);
    }

    public void done(MouseEvent mouseEvent) throws Exception {
        User user = User.getUserLoginIn();  // TODO : change this to current user
        if (checkEnoughSelection()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            LoginController.showAlert("Not enough selection", "You should select at most 10 special cards and at least 22 common cards", "");
            return;
        }

        for (VBox child : imageViewsVboxesCardInDeck) {
            if (child.isVisible()) {
                if (!(child.getChildren().getFirst() instanceof StackPane)) {
                    if (child.getChildren().getFirst().getId() == null || getCommonCardByIdAddress(child.getChildren().getFirst().getId()) == null) {
                        System.out.println("Debug address1: " + child);
                        System.out.println("id:" + child.getId());
                        return;
                    }
                    user.getCommonCardsInDeck().add(getCommonCardByIdAddress(child.getChildren().getFirst().getId()));

                } else {
                    if (specialCardVboxesInDeck.contains(child)) continue;
                    StackPane stackPane = (StackPane) child.getChildren().getFirst();
                    if (stackPane.getChildren().getFirst().getId() == null || getCommonCardByIdAddress(stackPane.getChildren().getFirst().getId()) == null) {
                        System.out.println("Debug address2: " + child);
                        System.out.println("id:" + child.getId());
                        return;
                    }
                    Label label = (Label) stackPane.getChildren().get(1);
                    for (int i = 0; i < Integer.parseInt(label.getText().substring(0, 1)); i++) {
                        user.getCommonCardsInDeck().add(getCommonCardByIdAddress(stackPane.getChildren().getFirst().getId()));
                    }
                }
            }
        }
        for (VBox child : specialCardVboxesInDeck) {
            if (child.isVisible()) {
                StackPane stackPane = (StackPane) child.getChildren().getFirst();
                if (stackPane.getChildren().getFirst().getId() == null || getSpecialCardByIdAddress(stackPane.getChildren().getFirst().getId()) == null) {
                    System.out.println("DEBUG the address: " + stackPane.getChildren().getFirst().getId());
                    return;
                }
                Label label = (Label) stackPane.getChildren().get(1);
                for (int i = 0; i < Integer.parseInt(label.getText().substring(0, 1)); i++) {

                    user.getSpecialCardsInDeck().add(getSpecialCardByIdAddress(stackPane.getChildren().getFirst().getId()));
                }
            }
        }
        printDeck(user);
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
    }

    private boolean checkEnoughSelection() {
        return check10SelectionOfSpecialCard() || check22SelectionOfCommonCard();
    }

    private void printDeck(User user) {
        System.out.println("userrrr:" + User.getUserLoginIn());
        System.out.println("First common cards: siuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu!!");
        for (CommonCard commonCard : user.getCommonCardsInDeck()) {
            System.out.println("common card in deck:" + commonCard.getCardName());
        }
        System.out.println("now Special cards:   siuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        for (SpecialCard specialCard : user.getSpecialCardsInDeck()) {
            System.out.println("special card: " + specialCard.getCardName());
        }
    }

    // 22 ta bardashte check kon
    // max 10 special
    // choose card for other factions

    public void loadCurrentSelectedDeckForUser() {
    }

    public boolean check22SelectionOfCommonCard() {
        String regex = "Number of Unit Cards: (?<allCards>\\d+)/22";
        Matcher matcher = getCommandMatcher(regex, numberOfAllCards);
        int allCards = Integer.parseInt(matcher.group("allCards"));
        String regex2 = "Special Cards: (?<specialCards>\\d+)/10";
        Matcher matcher2 = getCommandMatcher(regex2, specialCards);
        int numOfSpecialCards = Integer.parseInt(matcher2.group("specialCards"));
        int commonCards = allCards - numOfSpecialCards;
        return commonCards < 22;
    }

    public boolean check10SelectionOfSpecialCard() {
        String regex = "Special Cards: (?<specialCards>\\d+)/10";
        Matcher matcher = getCommandMatcher(regex, specialCards);
        int numOfSpecialCards = Integer.parseInt(matcher.group("specialCards"));
        return numOfSpecialCards > 10;
    }

    private Matcher getCommandMatcher(String regex, Text text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.getText());
        if (matcher.matches()) return matcher;
        return null;
    }

    public void startGame(MouseEvent mouseEvent) throws Exception {
        User user = User.getUserLoginIn();  // TODO : change this to current user
        if (checkEnoughSelection()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            LoginController.showAlert("Not enough selection", "You should select at most 10 special cards and at least 22 common cards", "");
            return;
        }

        for (VBox child : imageViewsVboxesCardInDeck) {
            if (child.isVisible()) {
                if (!(child.getChildren().getFirst() instanceof StackPane)) {
                    if (child.getChildren().getFirst().getId() == null || getCommonCardByIdAddress(child.getChildren().getFirst().getId()) == null) {
                        System.out.println("Debug address1: " + child);
                        System.out.println("id:" + child.getId());
                        return;
                    }
                    user.getCommonCardsInDeck().add(getCommonCardByIdAddress(child.getChildren().getFirst().getId()));

                } else {
                    if (specialCardVboxesInDeck.contains(child)) continue;
                    StackPane stackPane = (StackPane) child.getChildren().getFirst();
                    if (stackPane.getChildren().getFirst().getId() == null || getCommonCardByIdAddress(stackPane.getChildren().getFirst().getId()) == null) {
                        System.out.println("Debug address2: " + child);
                        System.out.println("id:" + child.getId());
                        return;
                    }
                    Label label = (Label) stackPane.getChildren().get(1);
                    for (int i = 0; i < Integer.parseInt(label.getText().substring(0, 1)); i++) {
                        user.getCommonCardsInDeck().add(getCommonCardByIdAddress(stackPane.getChildren().getFirst().getId()));
                    }
                }
            }
        }
        for (VBox child : specialCardVboxesInDeck) {
            if (child.isVisible()) {
                StackPane stackPane = (StackPane) child.getChildren().getFirst();
                if (stackPane.getChildren().getFirst().getId() == null || getSpecialCardByIdAddress(stackPane.getChildren().getFirst().getId()) == null) {
                    System.out.println("DEBUG the address: " + stackPane.getChildren().getFirst().getId());
                    return;
                }
                Label label = (Label) stackPane.getChildren().get(1);
                for (int i = 0; i < Integer.parseInt(label.getText().substring(0, 1)); i++) {

                    user.getSpecialCardsInDeck().add(getSpecialCardByIdAddress(stackPane.getChildren().getFirst().getId()));
                }
            }
        }
        GameMenu gameMenu = new GameMenu();
        gameMenu.start(ApplicationController.getStage());
    }
}
