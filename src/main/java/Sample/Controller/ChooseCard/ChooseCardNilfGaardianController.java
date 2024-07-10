package Sample.Controller.ChooseCard;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;
import Sample.Model.User;
import Sample.View.LoginMenu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

public class ChooseCardNilfGaardianController {
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
    public VBox nilfgaard_zerriVboxInCardCollection;
    public ImageView nilfgaard_zerri;
    public VBox nilfgaard_young_emissaryVboxInCardCollection;
    public ImageView nilfgaard_young_emissary;
    public VBox nilfgaard_vreemdeVboxInCardCollection;
    public ImageView nilfgaard_vreemde;
    public Label nilfgaard_young_emissaryRemainderInCardCollection;
    public VBox nilfgaard_vattierVboxInCardCollection;
    public ImageView nilfgaard_vattier;
    public VBox nilfgaard_vanhemarVboxInCardCollection;
    public ImageView nilfgaard_vanhemar;
    public VBox nilfgaard_tiborVboxInCardCollection;
    public VBox nilfgaard_sweersVboxInCardCollection;
    public VBox nilfgaard_stefanVboxInCardCollection;
    public VBox nilfgaard_siege_supportVboxInCardCollection;
    public VBox nilfgaard_siege_engineerVboxInCardCollection;
    public ImageView nilfgaard_tibor;
    public ImageView nilfgaard_sweers;
    public ImageView nilfgaard_stefan;
    public ImageView nilfgaard_siege_support;
    public ImageView nilfgaard_siege_engineer;
    public VBox nilfgaard_shilardVboxInCardCollection;
    public ImageView nilfgaard_shilard;
    public VBox nilfgaard_rottenVboxInCardCollection;
    public ImageView nilfgaard_rotten;
    public VBox nilfgaard_renualdVboxInCardCollection;
    public ImageView nilfgaard_renuald;
    public VBox nilfgaard_rainfarnVboxInCardCollection;
    public ImageView nilfgaard_rainfarn;
    public VBox nilfgaard_puttkammerVboxInCardCollection;
    public ImageView nilfgaard_puttkammer;
    public VBox nilfgaard_nauzicaa_2VboxInCardCollection;
    public ImageView nilfgaard_nauzicaa_2;
    public VBox nilfgaard_morteisenVboxInCardCollection;
    public VBox nilfgaard_moorvranVboxInCardCollection;
    public ImageView nilfgaard_moorvran;
    public ImageView nilfgaard_morteisen;
    public VBox nilfgaard_mennoVboxInCardCollection;
    public ImageView nilfgaard_menno;
    public VBox nilfgaard_imperal_brigadeVboxInCardCollection;
    public ImageView nilfgaard_imperal_brigade;
    public VBox nilfgaard_heavy_zerriVboxInCardCollection;
    public ImageView nilfgaard_heavy_zerri;
    public VBox nilfgaard_fringillaVboxInCardCollection;
    public ImageView nilfgaard_fringilla;
    public VBox nilfgaard_cynthiaVboxInCardCollection;
    public ImageView nilfgaard_cynthia;
    public VBox nilfgaard_cahirVboxInCardCollection;
    public ImageView nilfgaard_cahir;
    public VBox nilfgaard_black_archerVboxInCardCollection;
    public ImageView nilfgaard_black_archer;
    public Label nilfgaard_black_archerRemainderInCardCollection;
    public VBox nilfgaard_archer_supportVboxInCardCollection;
    public ImageView nilfgaard_archer_support;
    public Label nilfgaard_archer_supportRemainderInCardCollection;
    public VBox nilfgaard_albrichVboxInCardCollection;
    public ImageView nilfgaard_albrich;
    public VBox nilfgaard_PerriVboxInDeck;
    public ImageView nilfgaard_zerriInDeck;
    public VBox nilfgaard_young_emissaryVboxInDeck;
    public ImageView nilfgaard_young_emissaryInDeck;
    public Label nilfgaard_young_emissaryRemainderInDeck;
    public VBox nilfgaard_vreemdeVboxInDeck;
    public ImageView nilfgaard_vreemdeInDeck;
    public VBox nilfgaard_vattierVboxInDeck;
    public ImageView nilfgaard_vattierInDeck;
    public VBox nilfgaard_vanhemarVboxInDeck;
    public ImageView nilfgaard_vanhemarInDeck;
    public VBox nilfgaard_tiborVboxInDeck;
    public ImageView nilfgaard_tiborInDeck;
    public VBox nilfgaard_sweersVboxInDeck;
    public ImageView nilfgaard_sweersInDeck;
    public VBox nilfgaard_stefanVboxInDeck;
    public ImageView nilfgaard_stefanInDeck;
    public VBox nilfgaard_siege_supportVboxInDeck;
    public ImageView nilfgaard_siege_supportInDeck;
    public VBox nilfgaard_siege_engineerVboxInDeck;
    public ImageView nilfgaard_siege_engineerInDeck;
    public VBox nilfgaard_shilardVboxInDeck;
    public ImageView nilfgaard_shilardInDeck;
    public VBox nilfgaard_rottenVboxInDeck;
    public ImageView nilfgaard_rottenInDeck;
    public VBox nilfgaard_renualdVboxInDeck;
    public ImageView nilfgaard_renualdInDeck;
    public VBox nilfgaard_rainfarnVboxInDeck;
    public ImageView nilfgaard_rainfarnInDeck;
    public VBox nilfgaard_puttkammerVboxInDeck;
    public ImageView nilfgaard_puttkammerInDeck;
    public VBox nilfgaard_nauzicaa_2VboxInDeck;
    public ImageView nilfgaard_nauzicaa_2InDeck;
    public VBox nilfgaard_morteisenVboxInDeck;
    public ImageView nilfgaard_morteisenInDeck;
    public VBox nilfgaard_moorvranVboxInDeck;
    public ImageView nilfgaard_moorvranInDeck;
    public VBox nilfgaard_mennoVboxInDeck;
    public ImageView nilfgaard_mennoInDeck;
    public VBox nilfgaard_imperal_brigadeVboxInDeck;
    public ImageView nilfgaard_imperal_brigadeInDeck;
    public VBox nilfgaard_heavy_zerriVboxInDeck;
    public ImageView nilfgaard_heavy_zerriInDeck;
    public VBox nilfgaard_fringillaVboxInDeck;
    public ImageView nilfgaard_fringillaInDeck;
    public VBox nilfgaard_cynthiaVboxInDeck;
    public ImageView nilfgaard_cynthiaInDeck;
    public VBox nilfgaard_cahirVboxInDeck;
    public ImageView nilfgaard_cahirInDeck;
    public VBox nilfgaard_black_archerVboxInDeck;
    public ImageView nilfgaard_black_archerInDeck;
    public Label nilfgaard_black_archerRemainderInDeck;
    public VBox nilfgaard_archer_supportVboxInDeck;
    public ImageView nilfgaard_archer_supportInDeck;
    public Label nilfgaard_archer_supportRemainderInDeck;
    public VBox nilfgaard_albrichVboxInDeck;
    public ImageView nilfgaard_albrichInDeck;
    public VBox nilfgaard_zerriVboxInDeck;
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
        nilfgaard_zerri.setImage(CommonCard.ZerrikanianFireScorpion.getImage());
//        nilfgaard_young_emissary.setImage(CommonCard.YoungEmissary.getImage());
        nilfgaard_vattier.setImage(CommonCard.VattierDeRideaux.getImage());
        nilfgaard_vanhemar.setImage(CommonCard.Vanhemar.getImage());
        nilfgaard_tibor.setImage(CommonCard.TiborEggebracht.getImage());
        nilfgaard_sweers.setImage(CommonCard.Sweers.getImage());
        nilfgaard_stefan.setImage(CommonCard.StefanSkellen.getImage());
        nilfgaard_siege_support.setImage(CommonCard.SiegeTechnician.getImage());
        nilfgaard_siege_engineer.setImage(CommonCard.SiegeEngineer.getImage());
        nilfgaard_shilard.setImage(CommonCard.Shilard.getImage());
        nilfgaard_rotten.setImage(CommonCard.RottenMangonel.getImage());
        nilfgaard_renuald.setImage(CommonCard.RenualdAepMatsen.getImage());
        nilfgaard_rainfarn.setImage(CommonCard.RainFarn.getImage());
        nilfgaard_puttkammer.setImage(CommonCard.Puttkammer.getImage());
        nilfgaard_nauzicaa_2.setImage(CommonCard.NausicaaCavalryRider.getImage());
        nilfgaard_morteisen.setImage(CommonCard.MorvranVoorhis.getImage());
        nilfgaard_moorvran.setImage(CommonCard.MorvranVoorhis.getImage());
        nilfgaard_menno.setImage(CommonCard.MennoCoehoorn.getImage());
        nilfgaard_imperal_brigade.setImage(CommonCard.ImperaBrigadeGuard.getImage());
        nilfgaard_heavy_zerri.setImage(CommonCard.HeavyZerrikanianFireScorpion.getImage());
        nilfgaard_fringilla.setImage(CommonCard.FringillaVigo.getImage());
        nilfgaard_cynthia.setImage(CommonCard.Cynthia.getImage());
        nilfgaard_cahir.setImage(CommonCard.CahirMawrDyffrynAepCeallach.getImage());
        nilfgaard_black_archer.setImage(CommonCard.BlackInfantryArcher.getImage());
        nilfgaard_archer_support.setImage(CommonCard.EtolianAuxiliaryArchers.getImage());
        nilfgaard_albrich.setImage(CommonCard.Albrich.getImage());


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

        nilfgaard_zerriInDeck.setImage(CommonCard.ZerrikanianFireScorpion.getImage());
        nilfgaard_vattierInDeck.setImage(CommonCard.VattierDeRideaux.getImage());
        nilfgaard_vanhemarInDeck.setImage(CommonCard.Vanhemar.getImage());
        nilfgaard_tiborInDeck.setImage(CommonCard.TiborEggebracht.getImage());
        nilfgaard_sweersInDeck.setImage(CommonCard.Sweers.getImage());
        nilfgaard_stefanInDeck.setImage(CommonCard.StefanSkellen.getImage());
        nilfgaard_siege_supportInDeck.setImage(CommonCard.SiegeTechnician.getImage());
        nilfgaard_siege_engineerInDeck.setImage(CommonCard.SiegeEngineer.getImage());
        nilfgaard_shilardInDeck.setImage(CommonCard.Shilard.getImage());
        nilfgaard_rottenInDeck.setImage(CommonCard.RottenMangonel.getImage());
        nilfgaard_renualdInDeck.setImage(CommonCard.RenualdAepMatsen.getImage());
        nilfgaard_rainfarnInDeck.setImage(CommonCard.RainFarn.getImage());
        nilfgaard_puttkammerInDeck.setImage(CommonCard.Puttkammer.getImage());
        nilfgaard_nauzicaa_2InDeck.setImage(CommonCard.NausicaaCavalryRider.getImage());
        nilfgaard_morteisenInDeck.setImage(CommonCard.MorvranVoorhis.getImage());
        nilfgaard_moorvranInDeck.setImage(CommonCard.MorvranVoorhis.getImage());
        nilfgaard_mennoInDeck.setImage(CommonCard.MennoCoehoorn.getImage());
        nilfgaard_imperal_brigadeInDeck.setImage(CommonCard.ImperaBrigadeGuard.getImage());
        nilfgaard_heavy_zerriInDeck.setImage(CommonCard.HeavyZerrikanianFireScorpion.getImage());
        nilfgaard_fringillaInDeck.setImage(CommonCard.FringillaVigo.getImage());
        nilfgaard_cynthiaInDeck.setImage(CommonCard.Cynthia.getImage());
        nilfgaard_cahirInDeck.setImage(CommonCard.CahirMawrDyffrynAepCeallach.getImage());
        nilfgaard_black_archerInDeck.setImage(CommonCard.BlackInfantryArcher.getImage());
        nilfgaard_archer_supportInDeck.setImage(CommonCard.EtolianAuxiliaryArchers.getImage());
        nilfgaard_albrichInDeck.setImage(CommonCard.Albrich.getImage());


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

    public void backToLeaderMenu(MouseEvent mouseEvent) {
        saveDeckForUser();
    }

    private void saveDeckForUser() {
        for (VBox vBox : imageViewsVboxesCardInDeck) {
            if (vBox.isVisible()) System.out.println(vBox.getId());
        }
    }

    public SpecialCard getSpecialCardByIdAddress(String address) {
        return ChooseCardMonsterController.getSpecialCardByIdAddress(address);
    }

    public CommonCard getCommonCardByIdAddress(String address) {
        return ChooseCardMonsterController.getCommonCardByIdAddress(address);
    }

    public void done(MouseEvent mouseEvent) {
        User user = User.getUserForTest();  // TODO : change this to current user
        if (!checkEnoughSelection()) {
            System.out.println("not enough selection");
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
    }

    private boolean checkEnoughSelection() {
        return check10SelectionOfSpecialCard() && check22SelectionOfCommonCard();
    }

    private void printDeck(User user) {
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
        return allCards < 22;
    }

    public boolean check10SelectionOfSpecialCard() {
        String regex = "Special Cards: (?<specialCards>\\d+)/10";
        Matcher matcher = getCommandMatcher(regex, specialCards);
        int numOfSpecialCards = Integer.parseInt(matcher.group("specialCards"));
        return numOfSpecialCards < 10;
    }

    private Matcher getCommandMatcher(String regex, Text text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.getText());
        if (matcher.matches()) return matcher;
        return null;
    }

    public void nilfgaard_young_emissaryUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(nilfgaard_young_emissaryRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int nilfgaard_young_emissaryInDeck = Integer.parseInt(nilfgaard_young_emissaryRemainderInDeck.getText().substring(0, 1));
            if (nilfgaard_young_emissaryInDeck == 1) {
                nilfgaard_young_emissaryVboxInDeck.setVisible(false);
            }
            nilfgaard_young_emissaryInDeck--;
            nilfgaard_young_emissaryRemainderInDeck.setText(nilfgaard_young_emissaryInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int nilfgaard_young_emissaryInCardCollection = Integer.parseInt(nilfgaard_young_emissaryRemainderInCardCollection.getText().substring(0, 1));
            if (nilfgaard_young_emissaryInCardCollection == 0) {
                nilfgaard_young_emissaryVboxInCardCollection.setVisible(true);
            }
            nilfgaard_young_emissaryInCardCollection++;
            nilfgaard_young_emissaryRemainderInCardCollection.setText(nilfgaard_young_emissaryInCardCollection + "X");
        }
        nilfgaard_young_emissaryRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void nilfgaard_young_emissarySelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(nilfgaard_young_emissaryRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int nilfgaard_young_emissaryInCardCollection = Integer.parseInt(nilfgaard_young_emissaryRemainderInCardCollection.getText().substring(0, 1));
            if (nilfgaard_young_emissaryInCardCollection == 1) {
                nilfgaard_young_emissaryVboxInCardCollection.setVisible(false);
            }
            nilfgaard_young_emissaryInCardCollection--;
            nilfgaard_young_emissaryRemainderInCardCollection.setText(nilfgaard_young_emissaryInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {

            int nilfgaard_young_emissaryInDeck = Integer.parseInt(nilfgaard_young_emissaryRemainderInDeck.getText().substring(0, 1));
            if (nilfgaard_young_emissaryInDeck == 0) {
                nilfgaard_young_emissaryVboxInDeck.setVisible(true);
            }
            nilfgaard_young_emissaryInDeck++;
            nilfgaard_young_emissaryRemainderInDeck.setText(nilfgaard_young_emissaryInDeck + "X");
        }
        nilfgaard_young_emissaryRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void nilfgaard_archer_supportUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(nilfgaard_archer_supportRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int nilfgaard_archer_supportInDeck = Integer.parseInt(nilfgaard_archer_supportRemainderInDeck.getText().substring(0, 1));
            if (nilfgaard_archer_supportInDeck == 1) {
                nilfgaard_archer_supportVboxInDeck.setVisible(false);
            }
            nilfgaard_archer_supportInDeck--;
            nilfgaard_archer_supportRemainderInDeck.setText(nilfgaard_archer_supportInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int nilfgaard_archer_supportInCardCollection = Integer.parseInt(nilfgaard_archer_supportRemainderInCardCollection.getText().substring(0, 1));
            if (nilfgaard_archer_supportInCardCollection == 0) {
                nilfgaard_archer_supportVboxInCardCollection.setVisible(true);
            }
            nilfgaard_archer_supportInCardCollection++;
            nilfgaard_archer_supportRemainderInCardCollection.setText(nilfgaard_archer_supportInCardCollection + "X");
        }
        nilfgaard_archer_supportRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void nilfgaard_archer_supportSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(nilfgaard_archer_supportRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int nilfgaard_archer_supportInCardCollection = Integer.parseInt(nilfgaard_archer_supportRemainderInCardCollection.getText().substring(0, 1));
            if (nilfgaard_archer_supportInCardCollection == 1) {
                nilfgaard_archer_supportVboxInCardCollection.setVisible(false);
            }
            nilfgaard_archer_supportInCardCollection--;
            nilfgaard_archer_supportRemainderInCardCollection.setText(nilfgaard_archer_supportInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int nilfgaard_archer_supportInDeck = Integer.parseInt(nilfgaard_archer_supportRemainderInDeck.getText().substring(0, 1));
            if (nilfgaard_archer_supportInDeck == 0) {
                nilfgaard_archer_supportVboxInDeck.setVisible(true);
            }
            nilfgaard_archer_supportInDeck++;
            nilfgaard_archer_supportRemainderInDeck.setText(nilfgaard_archer_supportInDeck + "X");
        }
        nilfgaard_archer_supportRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void nilfgaard_black_archerUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(nilfgaard_black_archerRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int nilfgaard_black_archerInDeck = Integer.parseInt(nilfgaard_black_archerRemainderInDeck.getText().substring(0, 1));
            if (nilfgaard_black_archerInDeck == 1) {
                nilfgaard_black_archerVboxInDeck.setVisible(false);
            }
            nilfgaard_black_archerInDeck--;
            nilfgaard_black_archerRemainderInDeck.setText(nilfgaard_black_archerInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int nilfgaard_black_archerInCardCollection = Integer.parseInt(nilfgaard_black_archerRemainderInCardCollection.getText().substring(0, 1));
            if (nilfgaard_black_archerInCardCollection == 0) {
                nilfgaard_black_archerVboxInCardCollection.setVisible(true);
            }
            nilfgaard_black_archerInCardCollection++;
            nilfgaard_black_archerRemainderInCardCollection.setText(nilfgaard_black_archerInCardCollection + "X");
        }
        nilfgaard_black_archerRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void nilfgaard_black_archerSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(nilfgaard_black_archerRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int nilfgaard_black_archerInCardCollection = Integer.parseInt(nilfgaard_black_archerRemainderInCardCollection.getText().substring(0, 1));
            if (nilfgaard_black_archerInCardCollection == 1) {
                nilfgaard_black_archerVboxInCardCollection.setVisible(false);
            }
            nilfgaard_black_archerInCardCollection--;
            nilfgaard_black_archerRemainderInCardCollection.setText(nilfgaard_black_archerInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int nilfgaard_black_archerInDeck = Integer.parseInt(nilfgaard_black_archerRemainderInDeck.getText().substring(0, 1));
            if (nilfgaard_black_archerInDeck == 0) {
                nilfgaard_black_archerVboxInDeck.setVisible(true);
            }
            nilfgaard_black_archerInDeck++;
            nilfgaard_black_archerRemainderInDeck.setText(nilfgaard_black_archerInDeck + "X");
        }
        nilfgaard_black_archerRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }


    public void nilfgaard_zerriSelected(MouseEvent mouseEvent) {
        nilfgaard_zerriVboxInCardCollection.setVisible(false);
        nilfgaard_zerriVboxInDeck.setVisible(true);
    }

    public void nilfgaard_zerriUnselected(MouseEvent mouseEvent) {
        nilfgaard_zerriVboxInCardCollection.setVisible(true);
        nilfgaard_zerriVboxInDeck.setVisible(false);
    }

    public void nilfgaard_vreemdeSelected(MouseEvent mouseEvent) {
        nilfgaard_vreemdeVboxInCardCollection.setVisible(false);
        nilfgaard_vreemdeVboxInDeck.setVisible(true);
    }

    public void nilfgaard_rainfarnUnselected(MouseEvent mouseEvent) {
        nilfgaard_rainfarnVboxInCardCollection.setVisible(true);
        nilfgaard_rainfarnVboxInDeck.setVisible(false);
    }

    public void nilfgaard_rainfarnSelected(MouseEvent mouseEvent) {
        nilfgaard_rainfarnVboxInCardCollection.setVisible(false);
        nilfgaard_rainfarnVboxInDeck.setVisible(true);
    }

    public void nilfgaard_renualdUnselected(MouseEvent mouseEvent) {
        nilfgaard_renualdVboxInCardCollection.setVisible(true);
        nilfgaard_renualdVboxInDeck.setVisible(false);
    }

    public void nilfgaard_renualdSelected(MouseEvent mouseEvent) {
        nilfgaard_renualdVboxInCardCollection.setVisible(false);
        nilfgaard_renualdVboxInDeck.setVisible(true);
    }

    public void nilfgaard_rottenUnselected(MouseEvent mouseEvent) {
        nilfgaard_rottenVboxInCardCollection.setVisible(true);
        nilfgaard_rottenVboxInDeck.setVisible(false);
    }

    public void nilfgaard_rottenSelected(MouseEvent mouseEvent) {
        nilfgaard_rottenVboxInCardCollection.setVisible(false);
        nilfgaard_rottenVboxInDeck.setVisible(true);
    }

    public void nilfgaard_shilardUnselected(MouseEvent mouseEvent) {
        nilfgaard_shilardVboxInCardCollection.setVisible(true);
        nilfgaard_shilardVboxInDeck.setVisible(false);
    }

    public void nilfgaard_shilardSelected(MouseEvent mouseEvent) {
        nilfgaard_shilardVboxInCardCollection.setVisible(false);
        nilfgaard_shilardVboxInDeck.setVisible(true);
    }

    public void nilfgaard_siege_engineerUnselected(MouseEvent mouseEvent) {
        nilfgaard_siege_engineerVboxInCardCollection.setVisible(true);
        nilfgaard_siege_engineerVboxInDeck.setVisible(false);
    }

    public void nilfgaard_siege_engineerSelected(MouseEvent mouseEvent) {
        nilfgaard_siege_engineerVboxInCardCollection.setVisible(false);
        nilfgaard_siege_engineerVboxInDeck.setVisible(true);
    }

    public void nilfgaard_siege_supportUnselected(MouseEvent mouseEvent) {
        nilfgaard_siege_supportVboxInCardCollection.setVisible(true);
        nilfgaard_siege_supportVboxInDeck.setVisible(false);
    }

    public void nilfgaard_siege_supportSelected(MouseEvent mouseEvent) {
        nilfgaard_siege_supportVboxInCardCollection.setVisible(false);
        nilfgaard_siege_supportVboxInDeck.setVisible(true);
    }

    public void nilfgaard_vreemdeUnselected(MouseEvent mouseEvent) {
        nilfgaard_vreemdeVboxInCardCollection.setVisible(true);
        nilfgaard_vreemdeVboxInDeck.setVisible(false);
    }

    public void nilfgaard_stefanSelected(MouseEvent mouseEvent) {
        nilfgaard_stefanVboxInCardCollection.setVisible(false);
        nilfgaard_stefanVboxInDeck.setVisible(true);
    }

    public void nilfgaard_stefanUnselected(MouseEvent mouseEvent) {
        nilfgaard_stefanVboxInCardCollection.setVisible(true);
        nilfgaard_stefanVboxInDeck.setVisible(false);
    }

    public void nilfgaard_sweersSelected(MouseEvent mouseEvent) {
        nilfgaard_sweersVboxInCardCollection.setVisible(false);
        nilfgaard_sweersVboxInDeck.setVisible(true);
    }

    public void nilfgaard_sweersUnselected(MouseEvent mouseEvent) {
        nilfgaard_sweersVboxInCardCollection.setVisible(true);
        nilfgaard_sweersVboxInDeck.setVisible(false);
    }

    public void nilfgaard_tiborSelected(MouseEvent mouseEvent) {
        nilfgaard_tiborVboxInCardCollection.setVisible(false);
        nilfgaard_tiborVboxInDeck.setVisible(true);
    }

    public void nilfgaard_tiborUnselected(MouseEvent mouseEvent) {
        nilfgaard_tiborVboxInCardCollection.setVisible(true);
        nilfgaard_tiborVboxInDeck.setVisible(false);
    }

    public void nilfgaard_vanhemarSelected(MouseEvent mouseEvent) {
        nilfgaard_vanhemarVboxInCardCollection.setVisible(false);
        nilfgaard_vanhemarVboxInDeck.setVisible(true);
    }

    public void nilfgaard_vanhemarUnselected(MouseEvent mouseEvent) {
        nilfgaard_vanhemarVboxInCardCollection.setVisible(true);
        nilfgaard_vanhemarVboxInDeck.setVisible(false);
    }

    public void nilfgaard_albrichSelected(MouseEvent mouseEvent) {
        nilfgaard_albrichVboxInCardCollection.setVisible(false);
        nilfgaard_albrichVboxInDeck.setVisible(true);
    }

    public void nilfgaard_albrichUnselected(MouseEvent mouseEvent) {
        nilfgaard_albrichVboxInCardCollection.setVisible(true);
        nilfgaard_albrichVboxInDeck.setVisible(false);
    }

    public void nilfgaard_vattierSelected(MouseEvent mouseEvent) {
        nilfgaard_vattierVboxInCardCollection.setVisible(false);
        nilfgaard_vattierVboxInDeck.setVisible(true);
    }

    public void nilfgaard_vattierUnselected(MouseEvent mouseEvent) {
        nilfgaard_vattierVboxInCardCollection.setVisible(true);
        nilfgaard_vattierVboxInDeck.setVisible(false);
    }

    public void nilfgaard_cahirSelected(MouseEvent mouseEvent) {
        nilfgaard_cahirVboxInCardCollection.setVisible(false);
        nilfgaard_cahirVboxInDeck.setVisible(true);
    }

    public void nilfgaard_cahirUnselected(MouseEvent mouseEvent) {
        nilfgaard_cahirVboxInCardCollection.setVisible(true);
        nilfgaard_cahirVboxInDeck.setVisible(false);
    }

    public void nilfgaard_cynthiaSelected(MouseEvent mouseEvent) {
        nilfgaard_cynthiaVboxInCardCollection.setVisible(false);
        nilfgaard_cynthiaVboxInDeck.setVisible(true);
    }

    public void nilfgaard_cynthiaUnselected(MouseEvent mouseEvent) {
        nilfgaard_cynthiaVboxInCardCollection.setVisible(true);
        nilfgaard_cynthiaVboxInDeck.setVisible(false);
    }

    public void nilfgaard_fringillaSelected(MouseEvent mouseEvent) {
        nilfgaard_fringillaVboxInCardCollection.setVisible(false);
        nilfgaard_fringillaVboxInDeck.setVisible(true);
    }

    public void nilfgaard_fringillaUnselected(MouseEvent mouseEvent) {
        nilfgaard_fringillaVboxInCardCollection.setVisible(true);
        nilfgaard_fringillaVboxInDeck.setVisible(false);
    }

    public void nilfgaard_heavy_zerriSelected(MouseEvent mouseEvent) {
        nilfgaard_heavy_zerriVboxInCardCollection.setVisible(false);
        nilfgaard_heavy_zerriVboxInDeck.setVisible(true);
    }

    public void nilfgaard_heavy_zerriUnselected(MouseEvent mouseEvent) {
        nilfgaard_heavy_zerriVboxInCardCollection.setVisible(true);
        nilfgaard_heavy_zerriVboxInDeck.setVisible(false);
    }

    public void nilfgaard_imperal_brigadeSelected(MouseEvent mouseEvent) {
        nilfgaard_imperal_brigadeVboxInCardCollection.setVisible(false);
        nilfgaard_imperal_brigadeVboxInDeck.setVisible(true);
    }

    public void nilfgaard_imperal_brigadeUnselected(MouseEvent mouseEvent) {
        nilfgaard_imperal_brigadeVboxInCardCollection.setVisible(true);
        nilfgaard_imperal_brigadeVboxInDeck.setVisible(false);
    }


    public void nilfgaard_mennoSelected(MouseEvent mouseEvent) {
        nilfgaard_mennoVboxInCardCollection.setVisible(false);
        nilfgaard_mennoVboxInDeck.setVisible(true);
    }

    public void nilfgaard_mennoUnselected(MouseEvent mouseEvent) {
        nilfgaard_mennoVboxInCardCollection.setVisible(true);
        nilfgaard_mennoVboxInDeck.setVisible(false);
    }

    public void nilfgaard_moorvranSelected(MouseEvent mouseEvent) {
        nilfgaard_moorvranVboxInCardCollection.setVisible(false);
        nilfgaard_moorvranVboxInDeck.setVisible(true);
    }

    public void nilfgaard_moorvranUnselected(MouseEvent mouseEvent) {
        nilfgaard_moorvranVboxInCardCollection.setVisible(true);
        nilfgaard_moorvranVboxInDeck.setVisible(false);
    }

    public void nilfgaard_morteisenSelected(MouseEvent mouseEvent) {
        nilfgaard_morteisenVboxInCardCollection.setVisible(false);
        nilfgaard_morteisenVboxInDeck.setVisible(true);
    }

    public void nilfgaard_morteisenUnselected(MouseEvent mouseEvent) {
        nilfgaard_morteisenVboxInCardCollection.setVisible(true);
        nilfgaard_morteisenVboxInDeck.setVisible(false);
    }

    public void nilfgaard_nauzicaa_2Selected(MouseEvent mouseEvent) {
        nilfgaard_nauzicaa_2VboxInCardCollection.setVisible(false);
        nilfgaard_nauzicaa_2VboxInDeck.setVisible(true);
    }

    public void nilfgaard_nauzicaa_2Unselected(MouseEvent mouseEvent) {
        nilfgaard_nauzicaa_2VboxInCardCollection.setVisible(true);
        nilfgaard_nauzicaa_2VboxInDeck.setVisible(false);
    }

    public void nilfgaard_puttkammerSelected(MouseEvent mouseEvent) {
        nilfgaard_puttkammerVboxInCardCollection.setVisible(false);
        nilfgaard_puttkammerVboxInDeck.setVisible(true);
    }

    public void nilfgaard_puttkammerUnselected(MouseEvent mouseEvent) {
        nilfgaard_puttkammerVboxInCardCollection.setVisible(true);
        nilfgaard_puttkammerVboxInDeck.setVisible(false);
    }

}
