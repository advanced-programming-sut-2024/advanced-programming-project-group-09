package Sample.Controller.ChooseCard;

import Sample.CardEnums.CommonCard;
import Sample.CardEnums.SpecialCard;
import Sample.Controller.ApplicationController;
import Sample.Controller.LoginController;
import Sample.Enum.Commands;
import Sample.Model.User;
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

public class ChooseCardScoiaTaelController {
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
    public VBox scoiatael_yaevinnVboxInDeck;
    public ImageView scoreline_yaevinnInDeck;
    public VBox scoiatael_vrihedd_cadetVboxInDeck;
    public ImageView scoiatael_vrihedd_cadetInDeck;
    public VBox scoiatael_vrihedd_brigadeVboxInDeck;
    public ImageView scoiatael_vrihedd_brigadeInDeck;
    public Label scoiatael_vrihedd_brigadeRemainderInDeck;
    public VBox scoiatael_toruvielVboxInDeck;
    public ImageView scoiatael_toruvielInDeck;
    public VBox scoiatael_saskiaVboxInDeck;
    public ImageView scoiatael_saskiaInDeck;
    public VBox scoiatael_riordainVboxInDeck;
    public ImageView scoiatael_riordainInDeck;
    public VBox scoiatael_milvaVboxInDeck;
    public ImageView scoiatael_milvaInDeck;
    public VBox scoiatael_mahakamVboxInDeck;
    public ImageView scoiatael_mahakamInDeck;
    public Label scoiatael_mahakamRemainderInDeck;
    public VBox scoiatael_havekar_supportVboxInDeck;
    public ImageView scoiatael_havekar_supportInDeck;
    public Label scoiatael_havekar_supportRemainderInDeck;
    public VBox scoiatael_filavandrelVboxInDeck;
    public ImageView scoiatael_filavandrelInDeck;
    public Label scoiatael_filavandrelRemainderInDeck;
    public VBox scoiatael_elf_skirmisherVboxInDeck;
    public ImageView scoiatael_elf_skirmisherInDeck;
    public Label scoiatael_elf_skirmisherRemainderInDeck;
    public VBox scoiatael_dol_infantryVboxInDeck;
    public ImageView scoiatael_dol_infantryInDeck;
    public Label scoiatael_dol_infantryRemainderInDeck;
    public VBox scoiatael_dwarfVboxInDeck;
    public ImageView scoiatael_dwarfInDeck;
    public Label scoiatael_dwarfRemainderInDeck;
    public VBox scoiatael_isengrimVboxInDeck;
    public ImageView scoiatael_isengrimInDeck;
    public VBox scoiatael_iorvethVboxInDeck;
    public ImageView scoiatael_iorvethInDeck;
    public VBox scoiatael_idaVboxInDeck;
    public ImageView scoiatael_idaInDeck;
    public VBox scoiatael_eithneVboxInDeck;
    public ImageView scoiatael_eithneInDeck;
    public VBox scoiatael_dol_archerVboxInDeck;
    public ImageView scoiatael_dol_archerInDeck;
    public VBox scoiatael_ciaranVboxInDeck;
    public ImageView scoiatael_ciaranInDeck;
    public VBox scoiatael_dennisVboxInDeck;
    public ImageView scoiatael_dennisInDeck;
    public VBox scoiatael_barclayVboxInDeck;
    public ImageView scoiatael_barclayInDeck;
    public ImageView scoiatael_yaevinn;
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

    public VBox scoiatael_yaevinnVbox;
    public ImageView scoreline_yaevinn;
    public VBox scoiatael_vrihedd_cadetVbox;
    public ImageView scoiatael_vrihedd_cadet;
    public VBox scoiatael_vrihedd_brigadeVboxInCardCollection;
    public ImageView scoiatael_vrihedd_brigade;
    public Label scoiatael_vrihedd_brigadeRemainderInCardCollection;
    public VBox scoiatael_toruvielVbox;
    public ImageView scoiatael_toruviel;
    public VBox scoiatael_saskiaVbox;
    public ImageView scoiatael_saskia;
    public VBox scoiatael_riordainVbox;
    public ImageView scoiatael_riordain;
    public VBox scoiatael_milvaVbox;
    public ImageView scoiatael_milva;
    public VBox scoiatael_mahakamVboxInCardCollection;
    public ImageView scoiatael_mahakam;
    public Label scoiatael_mahakamRemainderInCardCollection;
    public VBox scoiatael_havekar_supportVboxInCardCollection;
    public ImageView scoiatael_havekar_support;
    public Label scoiatael_havekar_supportRemainderInCardCollection;
    public VBox scoiatael_filavandrelVboxInCardCollection;
    public ImageView scoiatael_filavandrel;
    public Label scoiatael_filavandrelRemainderInCardCollection;
    public VBox scoiatael_elf_skirmisherVboxInCardCollection;
    public ImageView scoiatael_elf_skirmisher;
    public Label scoiatael_elf_skirmisherRemainderInCardCollection;
    public VBox scoiatael_dol_infantryVboxInCardCollection;
    public ImageView scoiatael_dol_infantry;
    public Label scoiatael_dol_infantryRemainderInCardCollection;
    public VBox scoiatael_dwarfVboxInCardCollection;
    public ImageView scoiatael_dwarf;
    public Label scoiatael_dwarfRemainderInCardCollection;
    public VBox scoiatael_isengrimVbox;
    public ImageView scoiatael_isengrim;
    public VBox scoiatael_iorvethVbox;
    public ImageView scoiatael_iorveth;
    public VBox scoiatael_idaVbox;
    public ImageView scoiatael_ida;
    public VBox scoiatael_eithneVbox;
    public ImageView scoiatael_eithne;
    public VBox scoiatael_dol_archerVbox;
    public ImageView scoiatael_dol_archer;
    public VBox scoiatael_ciaranVbox;
    public ImageView scoiatael_ciaran;
    public VBox scoiatael_dennisVbox;
    public ImageView scoiatael_dennis;
    public VBox scoiatael_barclayVbox;
    public ImageView scoiatael_barclay;

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
        scoiatael_eithne.setImage(CommonCard.Eithne.getImage());
        scoiatael_isengrim.setImage(CommonCard.IsengrimFaoiltiarna.getImage());
        scoiatael_barclay.setImage(CommonCard.BarclayEls.getImage());
        scoiatael_dennis.setImage(CommonCard.DennisCranmer.getImage());
        scoiatael_ciaran.setImage(CommonCard.CiaranAep.getImage());
        scoiatael_dol_archer.setImage(CommonCard.DolBlathannaArcher.getImage());
        scoiatael_ida.setImage(CommonCard.IdaEmeanAep.getImage());
//        scoiatael_iorveth.setImage(CommonCard.io);
        scoiatael_isengrim.setImage(CommonCard.IsengrimFaoiltiarna.getImage());
        scoiatael_dwarf.setImage(CommonCard.DwarvenSkirmisher.getImage());
        scoiatael_dol_infantry.setImage(CommonCard.DolBlathannaScout.getImage());
        scoiatael_elf_skirmisher.setImage(CommonCard.ElvenSkirmisher.getImage());
        scoiatael_filavandrel.setImage(CommonCard.FilavandrelAenFidhail.getImage());
        scoiatael_havekar_support.setImage(CommonCard.HavekarHealer.getImage());
        scoiatael_mahakam.setImage(CommonCard.MahakamDefender.getImage());
        scoiatael_riordain.setImage(CommonCard.Riordain.getImage());
        scoiatael_saskia.setImage(CommonCard.Saskia.getImage());
        scoiatael_toruviel.setImage(CommonCard.Toruviel.getImage());
        scoiatael_vrihedd_brigade.setImage(CommonCard.VriheddBrigadeVeteran.getImage());
        scoiatael_vrihedd_cadet.setImage(CommonCard.VriheddBrigadeRecruit.getImage());

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
        scoiatael_isengrimInDeck.setImage(CommonCard.IsengrimFaoiltiarna.getImage());
        scoiatael_eithneInDeck.setImage(CommonCard.Eithne.getImage());
        scoiatael_barclayInDeck.setImage(CommonCard.BarclayEls.getImage());
        scoiatael_dennisInDeck.setImage(CommonCard.DennisCranmer.getImage());
        scoiatael_ciaranInDeck.setImage(CommonCard.CiaranAep.getImage());
        scoiatael_dol_archerInDeck.setImage(CommonCard.DolBlathannaArcher.getImage());
        scoiatael_idaInDeck.setImage(CommonCard.IdaEmeanAep.getImage());
//        scoiatael_iorveth.setImage(CommonCard.io);
        scoiatael_isengrimInDeck.setImage(CommonCard.IsengrimFaoiltiarna.getImage());
        scoiatael_dwarfInDeck.setImage(CommonCard.DwarvenSkirmisher.getImage());
        scoiatael_dol_infantryInDeck.setImage(CommonCard.DolBlathannaScout.getImage());
        scoiatael_elf_skirmisherInDeck.setImage(CommonCard.ElvenSkirmisher.getImage());
        scoiatael_filavandrelInDeck.setImage(CommonCard.FilavandrelAenFidhail.getImage());
        scoiatael_havekar_supportInDeck.setImage(CommonCard.HavekarHealer.getImage());
        scoiatael_mahakamInDeck.setImage(CommonCard.MahakamDefender.getImage());
        scoiatael_riordainInDeck.setImage(CommonCard.Riordain.getImage());
        scoiatael_saskiaInDeck.setImage(CommonCard.Saskia.getImage());
        scoiatael_toruvielInDeck.setImage(CommonCard.Toruviel.getImage());
        scoiatael_vrihedd_brigadeInDeck.setImage(CommonCard.VriheddBrigadeVeteran.getImage());
        scoiatael_vrihedd_cadetInDeck.setImage(CommonCard.VriheddBrigadeRecruit.getImage());

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

    public void scoiatael_elf_skirmisherUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(scoiatael_elf_skirmisherRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int scoiatael_elf_skirmisherInDeck = Integer.parseInt(scoiatael_elf_skirmisherRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_elf_skirmisherInDeck == 1) {
                scoiatael_elf_skirmisherVboxInDeck.setVisible(false);
            }
            scoiatael_elf_skirmisherInDeck--;
            scoiatael_elf_skirmisherRemainderInDeck.setText(scoiatael_elf_skirmisherInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int scoiatael_elf_skirmisherInCardCollection = Integer.parseInt(scoiatael_elf_skirmisherRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_elf_skirmisherInCardCollection == 0) {
                scoiatael_elf_skirmisherVboxInCardCollection.setVisible(true);
            }
            scoiatael_elf_skirmisherInCardCollection++;
            scoiatael_elf_skirmisherRemainderInCardCollection.setText(scoiatael_elf_skirmisherInCardCollection + "X");
        }
        scoiatael_elf_skirmisherRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void scoiatael_elf_skirmisherSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(scoiatael_elf_skirmisherRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int scoiatael_elf_skirmisherInCardCollection = Integer.parseInt(scoiatael_elf_skirmisherRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_elf_skirmisherInCardCollection == 1) {
                scoiatael_elf_skirmisherVboxInCardCollection.setVisible(false);
            }
            scoiatael_elf_skirmisherInCardCollection--;
            scoiatael_elf_skirmisherRemainderInCardCollection.setText(scoiatael_elf_skirmisherInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int scoiatael_elf_skirmisherInDeck = Integer.parseInt(scoiatael_elf_skirmisherRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_elf_skirmisherInDeck == 0) {
                scoiatael_elf_skirmisherVboxInDeck.setVisible(true);
            }
            scoiatael_elf_skirmisherInDeck++;
            scoiatael_elf_skirmisherRemainderInDeck.setText(scoiatael_elf_skirmisherInDeck + "X");
        }
        scoiatael_elf_skirmisherRemainderInCardCollection.setText(remainingInCardSelection + "X");
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


    public void scoiatael_mahakamUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(scoiatael_mahakamRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int scoiatael_mahakamInDeck = Integer.parseInt(scoiatael_mahakamRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_mahakamInDeck == 1) {
                scoiatael_mahakamVboxInDeck.setVisible(false);
            }
            scoiatael_mahakamInDeck--;
            scoiatael_mahakamRemainderInDeck.setText(scoiatael_mahakamInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int scoiatael_mahakamInCardCollection = Integer.parseInt(scoiatael_mahakamRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_mahakamInCardCollection == 0) {
                scoiatael_mahakamVboxInCardCollection.setVisible(true);
            }
            scoiatael_mahakamInCardCollection++;
            scoiatael_mahakamRemainderInCardCollection.setText(scoiatael_mahakamInCardCollection + "X");
        }
        scoiatael_mahakamRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void scoiatael_mahakamSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(scoiatael_mahakamRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int scoiatael_mahakamInCardCollection = Integer.parseInt(scoiatael_mahakamRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_mahakamInCardCollection == 1) {
                scoiatael_mahakamVboxInCardCollection.setVisible(false);
            }
            scoiatael_mahakamInCardCollection--;
            scoiatael_mahakamRemainderInCardCollection.setText(scoiatael_mahakamInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int scoiatael_mahakamInDeck = Integer.parseInt(scoiatael_mahakamRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_mahakamInDeck == 0) {
                scoiatael_mahakamVboxInDeck.setVisible(true);
            }
            scoiatael_mahakamInDeck++;
            scoiatael_mahakamRemainderInDeck.setText(scoiatael_mahakamInDeck + "X");
        }
        scoiatael_mahakamRemainderInCardCollection.setText(remainingInCardSelection + "X");
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

    public void scoiatael_dwarfUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(scoiatael_dwarfRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int scoiatael_dwarfInDeck = Integer.parseInt(scoiatael_dwarfRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_dwarfInDeck == 1) {
                scoiatael_dwarfVboxInDeck.setVisible(false);
            }
            scoiatael_dwarfInDeck--;
            scoiatael_dwarfRemainderInDeck.setText(scoiatael_dwarfInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int scoiatael_dwarfInCardCollection = Integer.parseInt(scoiatael_dwarfRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_dwarfInCardCollection == 0) {
                scoiatael_dwarfVboxInCardCollection.setVisible(true);
            }
            scoiatael_dwarfInCardCollection++;
            scoiatael_dwarfRemainderInCardCollection.setText(scoiatael_dwarfInCardCollection + "X");
        }
        scoiatael_dwarfRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void scoiatael_dwarfSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(scoiatael_dwarfRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int scoiatael_dwarfInCardCollection = Integer.parseInt(scoiatael_dwarfRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_dwarfInCardCollection == 1) {
                scoiatael_dwarfVboxInCardCollection.setVisible(false);
            }
            scoiatael_dwarfInCardCollection--;
            scoiatael_dwarfRemainderInCardCollection.setText(scoiatael_dwarfInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int scoiatael_dwarfInDeck = Integer.parseInt(scoiatael_dwarfRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_dwarfInDeck == 0) {
                scoiatael_dwarfVboxInDeck.setVisible(true);
            }
            scoiatael_dwarfInDeck++;
            scoiatael_dwarfRemainderInDeck.setText(scoiatael_dwarfInDeck + "X");
        }
        scoiatael_dwarfRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void scoiatael_filavandrelUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(scoiatael_filavandrelRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int scoiatael_filavandrelInDeck = Integer.parseInt(scoiatael_filavandrelRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_filavandrelInDeck == 1) {
                scoiatael_filavandrelVboxInDeck.setVisible(false);
            }
            scoiatael_filavandrelInDeck--;
            scoiatael_filavandrelRemainderInDeck.setText(scoiatael_filavandrelInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int scoiatael_filavandrelInCardCollection = Integer.parseInt(scoiatael_filavandrelRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_filavandrelInCardCollection == 0) {
                scoiatael_filavandrelVboxInCardCollection.setVisible(true);
            }
            scoiatael_filavandrelInCardCollection++;
            scoiatael_filavandrelRemainderInCardCollection.setText(scoiatael_filavandrelInCardCollection + "X");
        }
        scoiatael_filavandrelRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void scoiatael_filavandrelSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(scoiatael_filavandrelRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int scoiatael_filavandrelInCardCollection = Integer.parseInt(scoiatael_filavandrelRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_filavandrelInCardCollection == 1) {
                scoiatael_filavandrelVboxInCardCollection.setVisible(false);
            }
            scoiatael_filavandrelInCardCollection--;
            scoiatael_filavandrelRemainderInCardCollection.setText(scoiatael_filavandrelInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int scoiatael_filavandrelInDeck = Integer.parseInt(scoiatael_filavandrelRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_filavandrelInDeck == 0) {
                scoiatael_filavandrelVboxInDeck.setVisible(true);
            }
            scoiatael_filavandrelInDeck++;
            scoiatael_filavandrelRemainderInDeck.setText(scoiatael_filavandrelInDeck + "X");
        }
        scoiatael_filavandrelRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void scoiatael_havekar_supportUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(scoiatael_havekar_supportRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int scoiatael_havekar_supportInDeck = Integer.parseInt(scoiatael_havekar_supportRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_havekar_supportInDeck == 1) {
                scoiatael_havekar_supportVboxInDeck.setVisible(false);
            }
            scoiatael_havekar_supportInDeck--;
            scoiatael_havekar_supportRemainderInDeck.setText(scoiatael_havekar_supportInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int scoiatael_havekar_supportInCardCollection = Integer.parseInt(scoiatael_havekar_supportRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_havekar_supportInCardCollection == 0) {
                scoiatael_havekar_supportVboxInCardCollection.setVisible(true);
            }
            scoiatael_havekar_supportInCardCollection++;
            scoiatael_havekar_supportRemainderInCardCollection.setText(scoiatael_havekar_supportInCardCollection + "X");
        }
        scoiatael_havekar_supportRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void scoiatael_havekar_supportSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(scoiatael_havekar_supportRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int scoiatael_havekar_supportInCardCollection = Integer.parseInt(scoiatael_havekar_supportRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_havekar_supportInCardCollection == 1) {
                scoiatael_havekar_supportVboxInCardCollection.setVisible(false);
            }
            scoiatael_havekar_supportInCardCollection--;
            scoiatael_havekar_supportRemainderInCardCollection.setText(scoiatael_havekar_supportInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int scoiatael_havekar_supportInDeck = Integer.parseInt(scoiatael_havekar_supportRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_havekar_supportInDeck == 0) {
                scoiatael_havekar_supportVboxInDeck.setVisible(true);
            }
            scoiatael_havekar_supportInDeck++;
            scoiatael_havekar_supportRemainderInDeck.setText(scoiatael_havekar_supportInDeck + "X");
        }
        scoiatael_havekar_supportRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void scoiatael_vrihedd_brigadeUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(scoiatael_vrihedd_brigadeRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int scoiatael_vrihedd_brigadeInDeck = Integer.parseInt(scoiatael_vrihedd_brigadeRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_vrihedd_brigadeInDeck == 1) {
                scoiatael_vrihedd_brigadeVboxInDeck.setVisible(false);
            }
            scoiatael_vrihedd_brigadeInDeck--;
            scoiatael_vrihedd_brigadeRemainderInDeck.setText(scoiatael_vrihedd_brigadeInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int scoiatael_vrihedd_brigadeInCardCollection = Integer.parseInt(scoiatael_vrihedd_brigadeRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_vrihedd_brigadeInCardCollection == 0) {
                scoiatael_vrihedd_brigadeVboxInCardCollection.setVisible(true);
            }
            scoiatael_vrihedd_brigadeInCardCollection++;
            scoiatael_vrihedd_brigadeRemainderInCardCollection.setText(scoiatael_vrihedd_brigadeInCardCollection + "X");
        }
        scoiatael_vrihedd_brigadeRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void scoiatael_dol_infantrySelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(scoiatael_dol_infantryRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int scoiatael_dol_infantryInCardCollection = Integer.parseInt(scoiatael_dol_infantryRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_dol_infantryInCardCollection == 1) {
                scoiatael_dol_infantryVboxInCardCollection.setVisible(false);
            }
            scoiatael_dol_infantryInCardCollection--;
            scoiatael_dol_infantryRemainderInCardCollection.setText(scoiatael_dol_infantryInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int scoiatael_dol_infantryInDeck = Integer.parseInt(scoiatael_dol_infantryRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_dol_infantryInDeck == 0) {
                scoiatael_dol_infantryVboxInDeck.setVisible(true);
            }
            scoiatael_dol_infantryInDeck++;
            scoiatael_dol_infantryRemainderInDeck.setText(scoiatael_dol_infantryInDeck + "X");
        }
        scoiatael_dol_infantryRemainderInCardCollection.setText(remainingInCardSelection + "X");
    }

    public void scoiatael_dol_infantryUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(scoiatael_dol_infantryRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0)
//            deleteOneDecoyFromDeck();
        {
            int scoiatael_dol_infantryInDeck = Integer.parseInt(scoiatael_dol_infantryRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_dol_infantryInDeck == 1) {
                scoiatael_dol_infantryVboxInDeck.setVisible(false);
            }
            scoiatael_dol_infantryInDeck--;
            scoiatael_dol_infantryRemainderInDeck.setText(scoiatael_dol_infantryInDeck + "X");

        }
//        addOneDecoyToCardCollection();
        {
            int scoiatael_dol_infantryInCardCollection = Integer.parseInt(scoiatael_dol_infantryRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_dol_infantryInCardCollection == 0) {
                scoiatael_dol_infantryVboxInCardCollection.setVisible(true);
            }
            scoiatael_dol_infantryInCardCollection++;
            scoiatael_dol_infantryRemainderInCardCollection.setText(scoiatael_dol_infantryInCardCollection + "X");
        }
        scoiatael_dol_infantryRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void scoiatael_vrihedd_brigadeSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(scoiatael_vrihedd_brigadeRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneDecoyFromCardCollection();
            int scoiatael_vrihedd_brigadeInCardCollection = Integer.parseInt(scoiatael_vrihedd_brigadeRemainderInCardCollection.getText().substring(0, 1));
            if (scoiatael_vrihedd_brigadeInCardCollection == 1) {
                scoiatael_vrihedd_brigadeVboxInCardCollection.setVisible(false);
            }
            scoiatael_vrihedd_brigadeInCardCollection--;
            scoiatael_vrihedd_brigadeRemainderInCardCollection.setText(scoiatael_vrihedd_brigadeInCardCollection + "X");

        }
//        addOneDecoyToDeck();
        {
            int scoiatael_vrihedd_brigadeInDeck = Integer.parseInt(scoiatael_vrihedd_brigadeRemainderInDeck.getText().substring(0, 1));
            if (scoiatael_vrihedd_brigadeInDeck == 0) {
                scoiatael_vrihedd_brigadeVboxInDeck.setVisible(true);
            }
            scoiatael_vrihedd_brigadeInDeck++;
            scoiatael_vrihedd_brigadeRemainderInDeck.setText(scoiatael_vrihedd_brigadeInDeck + "X");
        }
        scoiatael_vrihedd_brigadeRemainderInCardCollection.setText(remainingInCardSelection + "X");
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

    public void scoiatael_vrihedd_cadetSelected(MouseEvent mouseEvent) {
        scoiatael_vrihedd_cadetVbox.setVisible(false);
        scoiatael_vrihedd_cadetVboxInDeck.setVisible(true);
    }

    public void scoiatael_vrihedd_cadetUnselected(MouseEvent mouseEvent) {
        scoiatael_vrihedd_cadetVbox.setVisible(true);
        scoiatael_vrihedd_cadetVboxInDeck.setVisible(false);
    }

    public void scoiatael_toruvielSelected(MouseEvent mouseEvent) {
        scoiatael_toruvielVbox.setVisible(false);
        scoiatael_toruvielVboxInDeck.setVisible(true);
    }

    public void scoiatael_toruvielUnselected(MouseEvent mouseEvent) {
        scoiatael_toruvielVbox.setVisible(true);
        scoiatael_toruvielVboxInDeck.setVisible(false);
    }

    public void scoiatael_milvaSelected(MouseEvent mouseEvent) {
        scoiatael_milvaVbox.setVisible(false);
        scoiatael_milvaVboxInDeck.setVisible(true);
    }

    public void scoiatael_milvaUnselected(MouseEvent mouseEvent) {
        scoiatael_milvaVbox.setVisible(true);
        scoiatael_milvaVboxInDeck.setVisible(false);
    }

    public void scoiatael_saskiaSelected(MouseEvent mouseEvent) {
        scoiatael_saskiaVbox.setVisible(false);
        scoiatael_saskiaVboxInDeck.setVisible(true);
    }

    public void scoiatael_saskiaUnselected(MouseEvent mouseEvent) {
        scoiatael_saskiaVbox.setVisible(true);
        scoiatael_saskiaVboxInDeck.setVisible(false);
    }

    public void scoiatael_riordainSelected(MouseEvent mouseEvent) {
        scoiatael_riordainVbox.setVisible(false);
        scoiatael_riordainVboxInDeck.setVisible(true);
    }

    public void scoiatael_riordainUnselected(MouseEvent mouseEvent) {
        scoiatael_riordainVbox.setVisible(true);
        scoiatael_riordainVboxInDeck.setVisible(false);
    }


    public void scoiatael_isengrimUnselected(MouseEvent mouseEvent) {
        scoiatael_isengrimVbox.setVisible(true);
        scoiatael_isengrimVboxInDeck.setVisible(false);
    }

    public void scoiatael_isengrimSelected(MouseEvent mouseEvent) {
        scoiatael_isengrimVbox.setVisible(false);
        scoiatael_isengrimVboxInDeck.setVisible(true);
    }

    public void scoiatael_iorvethUnselected(MouseEvent mouseEvent) {
        scoiatael_iorvethVbox.setVisible(true);
        scoiatael_iorvethVboxInDeck.setVisible(false);
    }

    public void scoiatael_iorvethSelected(MouseEvent mouseEvent) {
        scoiatael_iorvethVbox.setVisible(false);
        scoiatael_iorvethVboxInDeck.setVisible(true);
    }

    public void scoiatael_idaUnselected(MouseEvent mouseEvent) {
        scoiatael_idaVbox.setVisible(true);
        scoiatael_idaVboxInDeck.setVisible(false);
    }

    public void scoiatael_idaSelected(MouseEvent mouseEvent) {
        scoiatael_idaVbox.setVisible(false);
        scoiatael_idaVboxInDeck.setVisible(true);
    }

    public void scoiatael_eithneUnselected(MouseEvent mouseEvent) {
        scoiatael_eithneVbox.setVisible(true);
        scoiatael_eithneVboxInDeck.setVisible(false);
    }

    public void scoiatael_eithneSelected(MouseEvent mouseEvent) {
        scoiatael_eithneVbox.setVisible(false);
        scoiatael_eithneVboxInDeck.setVisible(true);
    }

    public void scoiatael_dol_archerUnselected(MouseEvent mouseEvent) {
        scoiatael_dol_archerVbox.setVisible(true);
        scoiatael_dol_archerVboxInDeck.setVisible(false);
    }

    public void scoiatael_dol_archerSelected(MouseEvent mouseEvent) {
        scoiatael_dol_archerVbox.setVisible(false);
        scoiatael_dol_archerVboxInDeck.setVisible(true);
    }

    public void scoiatael_ciaranUnselected(MouseEvent mouseEvent) {
        scoiatael_ciaranVbox.setVisible(true);
        scoiatael_ciaranVboxInDeck.setVisible(false);
    }

    public void scoiatael_ciaranSelected(MouseEvent mouseEvent) {
        scoiatael_ciaranVbox.setVisible(false);
        scoiatael_ciaranVboxInDeck.setVisible(true);
    }

    public void scoiatael_dennisUnselected(MouseEvent mouseEvent) {
        scoiatael_dennisVbox.setVisible(true);
        scoiatael_dennisVboxInDeck.setVisible(false);
    }

    public void scoiatael_dennisSelected(MouseEvent mouseEvent) {
        scoiatael_dennisVbox.setVisible(false);
        scoiatael_dennisVboxInDeck.setVisible(true);
    }


    public void scoiatael_barclayUnselected(MouseEvent mouseEvent) {
        scoiatael_barclayVbox.setVisible(true);
        scoiatael_barclayVboxInDeck.setVisible(false);
    }

    public void scoiatael_barclaySelected(MouseEvent mouseEvent) {
        scoiatael_barclayVbox.setVisible(false);
        scoiatael_barclayVboxInDeck.setVisible(true);
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
    public void done(MouseEvent mouseEvent) throws Exception {
        User user = User.getUserForTest();  // TODO : change this to current user
        if (!checkEnoughSelection()) {
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
        return numOfSpecialCards < 10;
    }

    private Matcher getCommandMatcher(String regex, Text text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.getText());
        if (matcher.matches()) return matcher;
        return null;
    }
}
