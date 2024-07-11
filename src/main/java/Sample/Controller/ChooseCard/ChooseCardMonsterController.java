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

public class ChooseCardMonsterController {
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
    public ImageView monsters_leshen;
    public ImageView monsters_draug;
    public ImageView monsters_imlerith;
    public ImageView monsters_kayran;
    public ImageView monsters_toad;
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
    public ImageView neutral_chort;
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
    public ImageView monsters_arachas_behemoth;
    public ImageView monsters_earth_elemental;
    public ImageView monsters_fiend;
    public ImageView monsters_fire_elemental;
    public ImageView monsters_forktail;
    public ImageView monsters_frightener;
    public ImageView monsters_gravehag;
    public ImageView monsters_frost_giant;
    public ImageView monsters_mighty_maiden;
    public ImageView monsters_katakan;
    public ImageView monsters_werewolf;
    public ImageView monsters_arachas;
    public ImageView monsters_bruxa;
    public ImageView monsters_ekkima;
    public ImageView monsters_fleder;
    public ImageView monsters_celaeno_harpy;
    public ImageView monsters_cockatrice;
    public ImageView monsters_endrega;
    public ImageView monsters_fogling;
    public ImageView monsters_gargoyle;
    public ImageView monsters_harpy;
    public ImageView monsters_nekker_1;
    public ImageView monsters_ghoul;
    public ImageView monsters_ghoul_2;
    public ImageView monsters_ghoul_1;
    public ImageView monsters_nekker_2;
    public ImageView monsters_nekker;
    public ImageView monsters_leshenInDeck;
    public ImageView monsters_ghoulInDeck;
    public ImageView monsters_ghoul_2InDeck;
    public ImageView monsters_ghoul_1InDeck;
    public ImageView monsters_nekker_2InDeck;
    public ImageView monsters_nekkerInDeck;
    public ImageView monsters_nekker_1InDeck;
    public ImageView monsters_harpyInDeck;
    public ImageView monsters_gargoyleInDeck;
    public ImageView monsters_foglingInDeck;
    public ImageView monsters_endregaInDeck;
    public ImageView monsters_cockatriceInDeck;
    public ImageView monsters_celaeno_harpyInDeck;
    public ImageView monsters_garkainInDeck;
    public ImageView monsters_flederInDeck;
    public ImageView monsters_ekkimaInDeck;
    public ImageView monsters_bruxaInDeck;
    public ImageView monsters_arachasInDeck;
    public ImageView monsters_werewolfInDeck;
    public ImageView monsters_katakanInDeck;
    public ImageView monsters_mighty_maidenInDeck;
    public ImageView monsters_frost_giantInDeck;
    public ImageView monsters_gravehagInDeck;
    public ImageView monsters_frightenerInDeck;
    public ImageView monsters_forktailInDeck;
    public ImageView monsters_fire_elementalInDeck;
    public ImageView monsters_fiendInDeck;
    public ImageView monsters_earth_elementalInDeck;
    public ImageView monsters_arachas_behemothInDeck;
    public ImageView monsters_toadInDeck;
    public ImageView monsters_kayranInDeck;
    public ImageView monsters_inheritsInDeck;
    public ImageView monsters_draugInDeck;
    public ImageView monsters_arachas_1InDeck;
    public ImageView monsters_garkain;
    public ImageView monsters_arachas_1;
    public ImageView monsters_arachas_2;
    public ImageView monsters_arachas_2InDeck;
    public ImageView monsters_poroniec;
    public ImageView monsters_poroniecInDeck;
    public ImageView monsters_wyvern;
    public ImageView monsters_wyvernInDeck;
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
    public VBox monsters_leshenVboxInDeck;
    public VBox monsters_draugVboxInDeck;
    public VBox monsters_imlerithVboxInDeck;
    public VBox monsters_kayranVboxInDeck;
    public VBox monsters_toadVboxInDeck;
    public VBox monsters_arachas_behemothVboxInDeck;
    public VBox monsters_arachas_1VboxInDeck;
    public VBox monsters_arachas_2VboxInDeck;
    public VBox monsters_earth_elementalVboxInDeck;
    public VBox monsters_fiendVboxInDeck;
    public VBox monsters_fire_elementalVboxInDeck;
    public VBox monsters_forktailVboxInDeck;
    public VBox monsters_frightenerVboxInDeck;
    public VBox monsters_gravehagVboxInDeck;
    public VBox monsters_frost_giantVboxInDeck;
    public VBox monsters_poroniecVboxInDeck;
    public VBox monsters_wyvernVboxInDeck;
    public VBox monsters_mighty_maidenVboxInDeck;
    public VBox monsters_katakanVboxInDeck;
    public VBox monsters_arachasVboxInDeck;
    public VBox monsters_bruxaVboxInDeck;
    public VBox monsters_ekkimaVboxInDeck;
    public VBox monsters_garkainVboxInDeck;
    public VBox monsters_flederVboxInDeck;
    public VBox monsters_celaeno_harpyVboxInDeck;
    public VBox monsters_cockatriceVboxInDeck;
    public VBox monsters_endregaVboxInDeck;
    public VBox monsters_foglingVboxInDeck;
    public VBox monsters_gargoyleVboxInDeck;
    public VBox monsters_harpyVboxInDeck;
    public VBox monsters_nekker_1VboxInDeck;
    public VBox monsters_nekkerVboxInDeck;
    public VBox monsters_nekker_2VboxInDeck;
    public VBox monsters_ghoul_1VboxInDeck;
    public VBox monsters_ghoul_2VboxInDeck;
    public VBox monsters_ghoulVboxInDeck;
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
    public VBox monsters_lessenVboxInCardCollection;
    public VBox monsters_draugVboxInCardCollection;
    public VBox monsters_imlerithVboxInCardCollection;
    public VBox monsters_kayranVboxInCardCollection;
    public VBox monsters_toadVboxInCardCollection;
    public VBox monsters_arachas_behemothVboxInCardCollection;
    public VBox monsters_earth_elementalVboxInCardCollection;
    public VBox monsters_fiendVboxInCardCollection;
    public VBox monsters_fire_elementalVboxInCardCollection;
    public VBox monsters_forktailVboxInCardCollection;
    public VBox monsters_frightenerVboxInCardCollection;
    public VBox monsters_gravehagVboxInCardCollection;
    public VBox monsters_frost_giantVboxInCardCollection;
    public VBox monsters_mighty_maidenVboxInCardCollection;
    public VBox monsters_katakanVboxInCardCollection;
    public VBox monsters_werewolfVboxInCardCollection;
    public VBox monsters_leshenVboxInCardCollection;
    public VBox monsters_arachasVboxInCardCollection;
    public VBox monsters_bruxaVboxInCardCollection;
    public VBox monsters_ekkimaVboxInCardCollection;
    public VBox monsters_flederVboxInCardCollection;
    public VBox monsters_garkainVboxInCardCollection;
    public VBox monsters_celaeno_harpyVboxInCardCollection;
    public VBox monsters_cockatriceVboxInCardCollection;
    public VBox monsters_arachas_1VboxInCardCollection;
    public VBox monsters_endregaVboxInCardCollection;
    public VBox monsters_arachas_2VboxInCardCollection;
    public VBox monsters_foglingVboxInCardCollection;
    public VBox monsters_wyvernVboxInCardCollection;
    public VBox monsters_gargoyleVboxInCardCollection;
    public VBox monsters_harpyVboxInCardCollection;
    public VBox monsters_nekker_1VboxInCardCollection;
    public VBox monsters_poroniecVboxInCardCollection;
    public VBox monsters_nekkerVboxInCardCollection;
    public VBox monsters_nekker_2VboxInCardCollection;
    public VBox monsters_ghoul_1InCardCollection;
    public VBox monsters_ghoul_2InCardCollection;
    public VBox monsters_ghoulVboxInCardCollection;
    public VBox neutral_mysterious_elfVboxInCardCollection;
    public VBox monsters_werewolfVboxInDeck;
    public VBox monsters_ghoul_1VboxInCardCollection;
    public VBox monsters_ghoul_2VboxInCardCollection;
    public Text leaderName;
    public Button uploadDeckButton;
    public Button changeFactionButton;
    public Button downloadDeckButton;
    public Text numberOfAllCards;
    public Text specialCards;
    public Text heroCards;
    public Button startGameButton;
    public Button backToLeaderMenu;
    public Label monsters_arachasRemainderInDeck;
    public Label monsters_arachasRemainderInCardCollection;
    ArrayList<VBox> imageViewsVboxesCardCollection = new ArrayList<>();
    ArrayList<VBox> imageViewsVboxesCardInDeck = new ArrayList<>();

    ArrayList<VBox> specialCardVboxesInDeck = new ArrayList<>();
    ArrayList<VBox> heroCardsVboxes = new ArrayList<>();

    public static ChooseCardMonsterController instance;

    public static ChooseCardMonsterController getInstance() {
        if (instance == null) {
            instance = new ChooseCardMonsterController();
        }
        return instance;
    }


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


        monsters_arachas.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas.jpg"))));


        monsters_arachas_behemoth.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas_behemoth.jpg"))));
//        monsters_arachas_1.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas_1.jpg"))));
//        monsters_arachas_2.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas_2.jpg"))));
        monsters_bruxa.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_bruxa.jpg"))));
        monsters_poroniec.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_poroniec.jpg"))));
        monsters_celaeno_harpy.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_celaeno_harpy.jpg"))));
        monsters_cockatrice.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_cockatrice.jpg"))));
        monsters_draug.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_draug.jpg"))));
        monsters_earth_elemental.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_earth_elemental.jpg"))));
        monsters_ekkima.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ekkima.jpg"))));
        monsters_endrega.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_endrega.jpg"))));
        monsters_fiend.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fiend.jpg"))));
        monsters_fire_elemental.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fire_elemental.jpg"))));
        monsters_fleder.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fleder.jpg"))));
        monsters_fogling.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fogling.jpg"))));
        monsters_forktail.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_forktail.jpg"))));
        monsters_frightener.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_frightener.jpg"))));
        monsters_frost_giant.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_frost_giant.jpg"))));
        monsters_gargoyle.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_gargoyle.jpg"))));
        monsters_garkain.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_garkain.jpg"))));
        monsters_ghoul.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ghoul.jpg"))));
        monsters_ghoul_1.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ghoul_1.jpg"))));
        monsters_ghoul_2.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ghoul_2.jpg"))));
        monsters_gravehag.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_gravehag.jpg"))));
        monsters_harpy.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_harpy.jpg"))));
        monsters_imlerith.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_imlerith.jpg"))));
        monsters_katakan.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_katakan.jpg"))));
        monsters_kayran.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_kayran.jpg"))));
        monsters_leshen.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_leshen.jpg"))));
        monsters_mighty_maiden.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_mighty_maiden.jpg"))));
        monsters_nekker.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_nekker.jpg"))));
        monsters_nekker_1.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_nekker_1.jpg"))));
        monsters_nekker_2.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_nekker_2.jpg"))));
        monsters_toad.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_toad.jpg"))));
        monsters_werewolf.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_werewolf.jpg"))));
        monsters_wyvern.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_wyvern.jpg"))));
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


        monsters_arachasInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas.jpg"))));
        monsters_arachas_behemothInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas_behemoth.jpg"))));
        monsters_bruxaInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_bruxa.jpg"))));
//        monsters_arachas_1InDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas_1.jpg"))));
//        monsters_arachas_2InDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_arachas_2.jpg"))));
        monsters_bruxaInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_bruxa.jpg"))));
        monsters_celaeno_harpyInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_celaeno_harpy.jpg"))));
        monsters_cockatriceInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_cockatrice.jpg"))));
        monsters_draugInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_draug.jpg"))));
        monsters_earth_elementalInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_earth_elemental.jpg"))));
        monsters_ekkimaInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ekkima.jpg"))));
        monsters_endregaInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_endrega.jpg"))));
        monsters_fiendInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fiend.jpg"))));
        monsters_fire_elementalInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fire_elemental.jpg"))));
        monsters_flederInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fleder.jpg"))));
        monsters_foglingInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_fogling.jpg"))));
        monsters_forktailInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_forktail.jpg"))));
        monsters_frightenerInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_frightener.jpg"))));
        monsters_frost_giantInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_frost_giant.jpg"))));
        monsters_gargoyleInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_gargoyle.jpg"))));
        monsters_garkainInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_garkain.jpg"))));
        monsters_ghoulInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ghoul.jpg"))));
        monsters_ghoul_1InDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ghoul_1.jpg"))));
        monsters_ghoul_2InDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_ghoul_2.jpg"))));
        monsters_gravehagInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_gravehag.jpg"))));
        monsters_harpyInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_harpy.jpg"))));
        monsters_inheritsInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_imlerith.jpg"))));
        monsters_katakanInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_katakan.jpg"))));
        monsters_kayranInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_kayran.jpg"))));
        monsters_leshenInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_leshen.jpg"))));
        monsters_mighty_maidenInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_mighty_maiden.jpg"))));
        monsters_nekkerInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_nekker.jpg"))));
        monsters_nekker_1InDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_nekker_1.jpg"))));
        monsters_nekker_2InDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_nekker_2.jpg"))));
        monsters_poroniecInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_poroniec.jpg"))));
        monsters_toadInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_toad.jpg"))));
        monsters_werewolfInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_werewolf.jpg"))));
        monsters_wyvernInDeck.setImage(new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_wyvern.jpg"))));

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


    public void monsters_leshenUnselected(MouseEvent mouseEvent) {
        monsters_leshenVboxInCardCollection.setVisible(true);
        monsters_leshenVboxInDeck.setVisible(false);
    }


    public void monsters_leshenSelected(MouseEvent mouseEvent) {
        monsters_leshenVboxInCardCollection.setVisible(false);
        monsters_leshenVboxInDeck.setVisible(true);
    }

    public void monsters_draugUnselected(MouseEvent mouseEvent) {
        monsters_draugVboxInCardCollection.setVisible(true);
        monsters_draugVboxInDeck.setVisible(false);
    }


    public void monsters_draugSelected(MouseEvent mouseEvent) {
        monsters_draugVboxInCardCollection.setVisible(false);
        monsters_draugVboxInDeck.setVisible(true);
    }

    public void monsters_imlerithUnselected(MouseEvent mouseEvent) {
        monsters_imlerithVboxInCardCollection.setVisible(true);
        monsters_imlerithVboxInDeck.setVisible(false);
    }


    public void monsters_imlerithSelected(MouseEvent mouseEvent) {
        monsters_imlerithVboxInCardCollection.setVisible(false);
        monsters_imlerithVboxInDeck.setVisible(true);
    }


    public void monsters_kayranUnselected(MouseEvent mouseEvent) {
        monsters_kayranVboxInCardCollection.setVisible(true);
        monsters_kayranVboxInDeck.setVisible(false);
    }


    public void monsters_kayranSelected(MouseEvent mouseEvent) {
        monsters_kayranVboxInCardCollection.setVisible(false);
        monsters_kayranVboxInDeck.setVisible(true);
    }

    public void monsters_toadUnselected(MouseEvent mouseEvent) {
        monsters_toadVboxInCardCollection.setVisible(true);
        monsters_toadVboxInDeck.setVisible(false);
    }


    public void monsters_toadSelected(MouseEvent mouseEvent) {
        monsters_toadVboxInCardCollection.setVisible(false);
        monsters_toadVboxInDeck.setVisible(true);
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


//
//    public void neutral_chortSelected(MouseEvent mouseEvent) {
//        neutral_chortVboxInCardCollection.setVisible(false);
//        neutral_chortVboxInDeck.setVisible(true);
//    }
//
//    public void neutral_chortUnselected(MouseEvent mouseEvent) {
//        neutral_chortVboxInCardCollection.setVisible(true);
//        neutral_chortVboxInDeck.setVisible(false);
//    }

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


    public void monsters_earth_elementalSelected(MouseEvent mouseEvent) {
        monsters_earth_elementalVboxInCardCollection.setVisible(false);
        monsters_earth_elementalVboxInDeck.setVisible(true);
    }

    public void monsters_earth_elementalUnselected(MouseEvent mouseEvent) {
        monsters_earth_elementalVboxInCardCollection.setVisible(true);
        monsters_earth_elementalVboxInDeck.setVisible(false);
    }

    public void monsters_fiendSelected(MouseEvent mouseEvent) {
        monsters_fiendVboxInCardCollection.setVisible(false);
        monsters_fiendVboxInDeck.setVisible(true);
    }

    public void monsters_fiendUnselected(MouseEvent mouseEvent) {
        monsters_fiendVboxInCardCollection.setVisible(true);
        monsters_fiendVboxInDeck.setVisible(false);
    }

    public void monsters_fire_elementalSelected(MouseEvent mouseEvent) {
        monsters_fire_elementalVboxInCardCollection.setVisible(false);
        monsters_fire_elementalVboxInDeck.setVisible(true);
    }

    public void monsters_fire_elementalUnselected(MouseEvent mouseEvent) {
        monsters_fire_elementalVboxInCardCollection.setVisible(true);
        monsters_fire_elementalVboxInDeck.setVisible(false);
    }

    public void monsters_forktailSelected(MouseEvent mouseEvent) {
        monsters_forktailVboxInCardCollection.setVisible(false);
        monsters_forktailVboxInDeck.setVisible(true);
    }

    public void monsters_forktailUnselected(MouseEvent mouseEvent) {
        monsters_forktailVboxInCardCollection.setVisible(true);
        monsters_forktailVboxInDeck.setVisible(false);
    }

    public void monsters_frightenerSelected(MouseEvent mouseEvent) {
        monsters_frightenerVboxInCardCollection.setVisible(false);
        monsters_frightenerVboxInDeck.setVisible(true);
    }

    public void monsters_frightenerUnselected(MouseEvent mouseEvent) {
        monsters_frightenerVboxInCardCollection.setVisible(true);
        monsters_frightenerVboxInDeck.setVisible(false);
    }

    public void monsters_gravehagSelected(MouseEvent mouseEvent) {
        monsters_gravehagVboxInCardCollection.setVisible(false);
        monsters_gravehagVboxInDeck.setVisible(true);
    }

    public void monsters_gravehagUnselected(MouseEvent mouseEvent) {
        monsters_gravehagVboxInCardCollection.setVisible(true);
        monsters_gravehagVboxInDeck.setVisible(false);
    }

    public void monsters_frost_giantSelected(MouseEvent mouseEvent) {
        monsters_frost_giantVboxInCardCollection.setVisible(false);
        monsters_frost_giantVboxInDeck.setVisible(true);
    }

    public void monsters_frost_giantUnselected(MouseEvent mouseEvent) {
        monsters_frost_giantVboxInCardCollection.setVisible(true);
        monsters_frost_giantVboxInDeck.setVisible(false);
    }

    public void monsters_mighty_maidenSelected(MouseEvent mouseEvent) {
        monsters_mighty_maidenVboxInCardCollection.setVisible(false);
        monsters_mighty_maidenVboxInDeck.setVisible(true);
    }

    public void monsters_mighty_maidenUnselected(MouseEvent mouseEvent) {
        monsters_mighty_maidenVboxInCardCollection.setVisible(true);
        monsters_mighty_maidenVboxInDeck.setVisible(false);
    }

    public void monsters_katakanSelected(MouseEvent mouseEvent) {
        monsters_katakanVboxInCardCollection.setVisible(false);
        monsters_katakanVboxInDeck.setVisible(true);
    }

    public void monsters_katakanUnselected(MouseEvent mouseEvent) {
        monsters_katakanVboxInCardCollection.setVisible(true);
        monsters_katakanVboxInDeck.setVisible(false);
    }

    public void monsters_werewolfSelected(MouseEvent mouseEvent) {
        monsters_werewolfVboxInCardCollection.setVisible(false);
        monsters_werewolfVboxInDeck.setVisible(true);
    }

    public void monsters_werewolfUnselected(MouseEvent mouseEvent) {
        monsters_werewolfVboxInCardCollection.setVisible(true);
        monsters_werewolfVboxInDeck.setVisible(false);
    }

    public void monsters_arachasSelected(MouseEvent mouseEvent) {
        monsters_arachasVboxInCardCollection.setVisible(false);
        monsters_arachasVboxInDeck.setVisible(true);
    }

    public void monsters_arachasUnselected(MouseEvent mouseEvent) {
        monsters_arachasVboxInCardCollection.setVisible(true);
        monsters_arachasVboxInDeck.setVisible(false);
    }

    public void monsters_arachas_1Selected(MouseEvent mouseEvent) {
        monsters_arachas_1VboxInCardCollection.setVisible(false);
        monsters_arachas_1VboxInDeck.setVisible(true);
    }

    public void monsters_arachas_1Unselected(MouseEvent mouseEvent) {
        monsters_arachas_1VboxInCardCollection.setVisible(true);
        monsters_arachas_1VboxInDeck.setVisible(false);
    }

    public void monsters_arachas_2Selected(MouseEvent mouseEvent) {
        monsters_arachas_2VboxInCardCollection.setVisible(false);
        monsters_arachas_2VboxInDeck.setVisible(true);
    }

    public void monsters_arachas_2Unselected(MouseEvent mouseEvent) {
        monsters_arachas_2VboxInCardCollection.setVisible(true);
        monsters_arachas_2VboxInDeck.setVisible(false);
    }


    public void monsters_bruxaSelected(MouseEvent mouseEvent) {
        monsters_bruxaVboxInCardCollection.setVisible(false);
        monsters_bruxaVboxInDeck.setVisible(true);
    }

    public void monsters_bruxaUnselected(MouseEvent mouseEvent) {
        monsters_bruxaVboxInCardCollection.setVisible(true);
        monsters_bruxaVboxInDeck.setVisible(false);
    }

    public void monsters_ekkimaSelected(MouseEvent mouseEvent) {
        monsters_ekkimaVboxInCardCollection.setVisible(false);
        monsters_ekkimaVboxInDeck.setVisible(true);
    }

    public void monsters_ekkimaUnselected(MouseEvent mouseEvent) {
        monsters_ekkimaVboxInCardCollection.setVisible(true);
        monsters_ekkimaVboxInDeck.setVisible(false);
    }

    public void monsters_flederSelected(MouseEvent mouseEvent) {
        monsters_flederVboxInCardCollection.setVisible(false);
        monsters_flederVboxInDeck.setVisible(true);
    }

    public void monsters_flederUnselected(MouseEvent mouseEvent) {
        monsters_flederVboxInCardCollection.setVisible(true);
        monsters_flederVboxInDeck.setVisible(false);
    }

    public void monsters_garkainSelected(MouseEvent mouseEvent) {
        monsters_garkainVboxInCardCollection.setVisible(false);
        monsters_garkainVboxInDeck.setVisible(true);
    }

    public void monsters_garkainUnselected(MouseEvent mouseEvent) {
        monsters_garkainVboxInCardCollection.setVisible(true);
        monsters_garkainVboxInDeck.setVisible(false);
    }

    public void monsters_celaeno_harpySelected(MouseEvent mouseEvent) {
        monsters_celaeno_harpyVboxInCardCollection.setVisible(false);
        monsters_celaeno_harpyVboxInDeck.setVisible(true);
    }

    public void monsters_celaeno_harpyUnselected(MouseEvent mouseEvent) {
        monsters_celaeno_harpyVboxInCardCollection.setVisible(true);
        monsters_celaeno_harpyVboxInDeck.setVisible(false);
    }

    public void monsters_cockatriceSelected(MouseEvent mouseEvent) {
        monsters_cockatriceVboxInCardCollection.setVisible(false);
        monsters_cockatriceVboxInDeck.setVisible(true);
    }

    public void monsters_cockatriceUnselected(MouseEvent mouseEvent) {
        monsters_cockatriceVboxInCardCollection.setVisible(true);
        monsters_cockatriceVboxInDeck.setVisible(false);
    }

    public void monsters_endregaSelected(MouseEvent mouseEvent) {
        monsters_endregaVboxInCardCollection.setVisible(false);
        monsters_endregaVboxInDeck.setVisible(true);
    }

    public void monsters_endregaUnselected(MouseEvent mouseEvent) {
        monsters_endregaVboxInCardCollection.setVisible(true);
        monsters_endregaVboxInDeck.setVisible(false);
    }

    public void monsters_foglingSelected(MouseEvent mouseEvent) {
        monsters_foglingVboxInCardCollection.setVisible(false);
        monsters_foglingVboxInDeck.setVisible(true);
    }

    public void monsters_foglingUnselected(MouseEvent mouseEvent) {
        monsters_foglingVboxInCardCollection.setVisible(true);
        monsters_foglingVboxInDeck.setVisible(false);
    }

    public void monsters_gargoyleSelected(MouseEvent mouseEvent) {
        monsters_gargoyleVboxInCardCollection.setVisible(false);
        monsters_gargoyleVboxInDeck.setVisible(true);
    }

    public void monsters_gargoyleUnselected(MouseEvent mouseEvent) {
        monsters_gargoyleVboxInCardCollection.setVisible(true);
        monsters_gargoyleVboxInDeck.setVisible(false);
    }

    public void monsters_harpySelected(MouseEvent mouseEvent) {
        monsters_harpyVboxInCardCollection.setVisible(false);
        monsters_harpyVboxInDeck.setVisible(true);
    }

    public void monsters_harpyUnselected(MouseEvent mouseEvent) {
        monsters_harpyVboxInCardCollection.setVisible(true);
        monsters_harpyVboxInDeck.setVisible(false);
    }

    public void monsters_wyvernSelected(MouseEvent mouseEvent) {
        monsters_wyvernVboxInCardCollection.setVisible(false);
        monsters_wyvernVboxInDeck.setVisible(true);
    }

    public void monsters_wyvernUnselected(MouseEvent mouseEvent) {
        monsters_wyvernVboxInCardCollection.setVisible(true);
        monsters_wyvernVboxInDeck.setVisible(false);
    }


    public void monsters_ghoulSelected(MouseEvent mouseEvent) {
        monsters_ghoulVboxInCardCollection.setVisible(false);
        monsters_ghoulVboxInDeck.setVisible(true);
    }

    public void monsters_ghoulUnselected(MouseEvent mouseEvent) {
        monsters_ghoulVboxInCardCollection.setVisible(true);
        monsters_ghoulVboxInDeck.setVisible(false);
    }

    public void monsters_ghoul_1Selected(MouseEvent mouseEvent) {
        monsters_ghoul_1VboxInCardCollection.setVisible(false);
        monsters_ghoul_1VboxInDeck.setVisible(true);
    }

    public void monsters_ghoul_1Unselected(MouseEvent mouseEvent) {
        monsters_ghoul_1VboxInCardCollection.setVisible(true);
        monsters_ghoul_1VboxInDeck.setVisible(false);
    }

    public void monsters_ghoul_2Selected(MouseEvent mouseEvent) {
        monsters_ghoul_2VboxInCardCollection.setVisible(false);
        monsters_ghoul_2VboxInDeck.setVisible(true);
    }

    public void monsters_ghoul_2Unselected(MouseEvent mouseEvent) {
        monsters_ghoul_2VboxInCardCollection.setVisible(true);
        monsters_ghoul_2VboxInDeck.setVisible(false);
    }

    public void monsters_nekkerSelected(MouseEvent mouseEvent) {
        monsters_nekkerVboxInCardCollection.setVisible(false);
        monsters_nekkerVboxInDeck.setVisible(true);
    }

    public void monsters_nekkerUnselected(MouseEvent mouseEvent) {
        monsters_nekkerVboxInCardCollection.setVisible(true);
        monsters_nekkerVboxInDeck.setVisible(false);
    }

    public void monsters_nekker_1Selected(MouseEvent mouseEvent) {
        monsters_nekker_1VboxInCardCollection.setVisible(false);
        monsters_nekker_1VboxInDeck.setVisible(true);
    }

    public void monsters_nekker_1Unselected(MouseEvent mouseEvent) {
        monsters_nekker_1VboxInCardCollection.setVisible(true);
        monsters_nekker_1VboxInDeck.setVisible(false);
    }

    public void monsters_nekker_2Selected(MouseEvent mouseEvent) {
        monsters_nekker_2VboxInCardCollection.setVisible(false);
        monsters_nekker_2VboxInDeck.setVisible(true);
    }

    public void monsters_nekker_2Unselected(MouseEvent mouseEvent) {
        monsters_nekker_2VboxInCardCollection.setVisible(true);
        monsters_nekker_2VboxInDeck.setVisible(false);
    }

    public void monsters_arachas_behemothSelected(MouseEvent mouseEvent) {
        monsters_arachas_behemothVboxInCardCollection.setVisible(false);
        monsters_arachas_behemothVboxInDeck.setVisible(true);
    }

    public void monsters_arachas_behemothUnselected(MouseEvent mouseEvent) {
        monsters_arachas_behemothVboxInCardCollection.setVisible(true);
        monsters_arachas_behemothVboxInDeck.setVisible(false);
    }

    public void monsters_poroniecSelected(MouseEvent mouseEvent) {
        monsters_poroniecVboxInCardCollection.setVisible(false);
        monsters_poroniecVboxInDeck.setVisible(true);
    }

    public void monsters_poroniecUnselected(MouseEvent mouseEvent) {
        monsters_poroniecVboxInCardCollection.setVisible(true);
        monsters_poroniecVboxInDeck.setVisible(false);
    }

    public void backToLeaderMenu(MouseEvent mouseEvent) {
        saveDeckForUser();
    }

    private void saveDeckForUser() {
        for (VBox vBox : imageViewsVboxesCardInDeck) {
            if (vBox.isVisible()) System.out.println(vBox.getId());
        }
    }

    public static SpecialCard getSpecialCardByIdAddress(String address) {
        System.out.println("special before:" + address);
        if (address.contains("InDeck")) address = address.split("InDeck")[0];
        System.out.println("special after:" + address);
        switch (address) {
            case "special_decoy":
                return SpecialCard.Decoy;
            case "special_horn":
                return SpecialCard.CommandersHorn;
            case "special_mardroeme":
                return SpecialCard.Mardroeme;
            case "special_scorch":
                return SpecialCard.Scorch;
            case "weather_clear":
                return SpecialCard.ClearWeather;
            case "weather_fog":
                return SpecialCard.ImpenetrableFog;
            case "weather_frost":
                return SpecialCard.BitingFrost;
            case "weather_rain":
                return SpecialCard.TorrentialRain;
            case "weather_storm":
                return SpecialCard.SkelligeStorm;
        }
        return null;
    }

    public static CommonCard getCommonCardByIdAddress(String address) {
        System.out.println("address before: " + address);
        if (address.contains("InDeck")) address = address.split("InDeck")[0];
        System.out.println("address after: " + address);
        switch (address) {
            case "neutral_ciri":
                return CommonCard.Ciri;
            case "neutral_vesemir":
                return CommonCard.Ves;
            case "monsters_arachas":
                return CommonCard.Arachas;
            case "monsters_arachas_1":
                return CommonCard.Arachas;
            case "monsters_arachas_2":
                return CommonCard.Arachas;
            case "monsters_arachas_behemoth":
                return CommonCard.ArachasBehemoth;
            case "monsters_bruxa":
                return CommonCard.VampireBruxa;
            case "monsters_witch_velen_1":
                return CommonCard.CroneWeavess;
            case "monsters_celaeno_harpy":
                return CommonCard.Harpy;
            case "monsters_cockatrice":
                return CommonCard.Cockatrice;
            case "monsters_draug":
                return CommonCard.Draug;
            case "monsters_earth_elemental":
                return CommonCard.EarthElemental;
            case "monsters_ekkima":
                return CommonCard.VampireEkimmara;
            case "monsters_endrega":
                return CommonCard.Endrega;
            case "monsters_fiend":
                return CommonCard.Fiend;
            case "monsters_fire_elemental":
                return CommonCard.FireElemental;
            case "monsters_fleder":
                return CommonCard.VampireFleder;
            case "monsters_fogling":
                return CommonCard.Foglet;
            case "monsters_forktail":
                return CommonCard.Forktail;
            case "monsters_frightener":
                return CommonCard.Forktail; // Note : there is no card with name frightener !
            case "monsters_frost_giant":
                return CommonCard.IceGiant;
            case "monsters_gargoyle":
                return CommonCard.Gargoyle; // Note : there is no card with name gargoyle !
            case "monsters_garkain":
                return CommonCard.VampireGarkain;
            case "monsters_ghoul":
                return CommonCard.Ghoul;
            case "monsters_ghoul_1":
                return CommonCard.Ghoul;
            case "monsters_ghoul_2":
                return CommonCard.Ghoul;
            case "monsters_gravehag":
                return CommonCard.GraveHag;
            case "monsters_gryffin":
                return CommonCard.Griffin;
            case "monsters_harpy":
                return CommonCard.Harpy;
            case "monsters_imlerith":
                return CommonCard.Imlerith;
            case "monsters_katakan":
                return CommonCard.VampireKatakan;
            case "monsters_kayran":
                return CommonCard.Kayran;
            case "monsters_leshen":
                return CommonCard.Leshen;
            case "monsters_mighty_maiden", "skellige_shield_maiden_2", "skellige_shield_maiden_1", "skellige_shield_maiden":
                return CommonCard.PlagueMaiden;
            case "monsters_nekker":
                return CommonCard.Nekker;
            case "monsters_nekker_1":
                return CommonCard.Nekker;
            case "monsters_nekker_2":
                return CommonCard.Nekker;
            case "monsters_poroniec":
                return CommonCard.Botchling;
            case "monsters_toad":
                return CommonCard.Toad;
            case "monsters_werewolf":
                return CommonCard.Werewolf;
            case "monsters_witch_velen":
                return CommonCard.CroneWeavess;
            case "monsters_witch_velen_2":
                return CommonCard.CroneWeavess;
            case "monsters_wyvern":
                return CommonCard.Wyvern;
            case "neutral_dandelion":
                return CommonCard.Dandelion;
            case "neutral_emiel":
                return CommonCard.EmielRegis;
            case "neutral_gaunter_odimm":
                return CommonCard.GaunterODimm;
            case "neutral_gaunter_odimm_darkness":
                return CommonCard.GaunterODimmDarkness;
            case "neutral_geralt":
                return CommonCard.Geralt;
            case "neutral_mysterious_elf":
                return CommonCard.MysteriousElf;
            case "neutral_olgierd":
                return CommonCard.OlgierdVonEverc;
            case "neutral_triss":
                return CommonCard.TrissMerigold;
            case "neutral_villen":
                return CommonCard.Villentretenmerth;
            case "neutral_yennefer":
                return CommonCard.YenneferOfVengerberg;
            case "neutral_zoltan":
                return CommonCard.ZoltanChivay;
            case "nilfgaard_albrich":
                return CommonCard.Albrich;
            case "nilfgaard_archer_support":
                return CommonCard.BlackInfantryArcher;
            case "nilfgaard_archer_support_1":
                return CommonCard.BlackInfantryArcher;
            case "nilfgaard_assire":
                return CommonCard.Assire;
            case "nilfgaard_cahir":
                return CommonCard.CahirMawrDyffrynAepCeallach;
            case "nilfgaard_cynthia":
                return CommonCard.Cynthia;
            case "nilfgaard_fringilla":
                return CommonCard.FringillaVigo;
            case "nilfgaard_heavy_zerri":
                return CommonCard.ZerrikanianFireScorpion;
            case "nilfgaard_imperal_brigade":
                return CommonCard.ImperaBrigadeGuard;
//            case "nilfgaard_letho":
//                return CommonCard.Letho;
            case "nilfgaard_menno":
                return CommonCard.TrissMerigold;
            case "nilfgaard_moorvran":
                return CommonCard.MorvranVoorhis;
            case "nilfgaard_morteisen":
                return CommonCard.Morteisen;
            case "nilfgaard_nauzicaa_2":
                return CommonCard.NausicaaCavalryRider;
            case "nilfgaard_puttkammer":
                return CommonCard.Puttkammer;
            case "nilfgaard_rainfarn":
                return CommonCard.RainFarn;
            case "nilfgaard_renuald":
                return CommonCard.RenualdAepMatsen;
            case "nilfgaard_rotten":
                return CommonCard.RottenMangonel;
            case "nilfgaard_shilard":
                return CommonCard.Shilard;
            case "nilfgaard_siege_engineer":
                return CommonCard.SiegeEngineer;
            case "nilfgaard_siege_support":
                return CommonCard.SiegeEngineer;
            case "nilfgaard_stefan":
                return CommonCard.StefanSkellen;
            case "nilfgaard_sweers":
                return CommonCard.Sweers;
            case "nilfgaard_tibor":
                return CommonCard.TiborEggebracht;
            case "nilfgaard_vanhemar":
                return CommonCard.Vanhemar;
            case "nilfgaard_vattier":
                return CommonCard.VattierDeRideaux;
            case "nilfgaard_young_emissary":
                return CommonCard.YoungEmissary;
            case "nilfgaard_young_emissary_1":
                return CommonCard.YoungEmissary;
            case "nilfgaard_zerri":
                return CommonCard.ZerrikanianFireScorpion;
            case "realms_ballista":
                return CommonCard.Ballista;
            case "realms_kaedwen_siege":
                return CommonCard.KaedweniSiegeExpert;
            case "realms_banner_nubrse":
                return CommonCard.DunBannerMedic;
            case "realms_blue_stripes":
                return CommonCard.BlueStripesCommando;
            case "realms_crinfrid":
                return CommonCard.CrinfridReaversDragonHunter;
            case "realms_dethmold":
                return CommonCard.Dethmold;
            case "realms_dijkstra":
                return CommonCard.SigismundDijkstra;
            case "realms_esterad", "realms_esterad_1", "realms_esterad_2":
                return CommonCard.EsteradThyssen;
            case "realms_keira":
                return CommonCard.ImperaBrigadeGuard;
            case "nilfgaard_letho":
                return CommonCard.MennoCoehoorn;
            case "realms_natalis":
                return CommonCard.JohnNatalis;
            case "realms_philippa":
                return CommonCard.PhilippaEilhart;
            case "realms_poor_infantry":
                return CommonCard.PoorFuckingInfantry;
            case "realms_redania", "realms_redania_1":
                return CommonCard.RedanianFootSoldier;
            case "realms_sabrina":
                return CommonCard.SabrinaGlevissing;
            case "realms_sheala":
                return CommonCard.SileDeTansarville;
            case "realms_sheldon":
                return CommonCard.SheldonSkaggs;
            case "realms_siege_tower":
                return CommonCard.SiegeTower;
            case "realms_siegfried":
                return CommonCard.SiegeTechnician;
            case "realms_stennis":
                return CommonCard.PrinceStennis;
            case "realms_thaler":
                return CommonCard.Thaler;
            case "realms_trebuchet", "realms_trebuchet_1":
                return CommonCard.Trebuchet;
            case "realms_vernon":
                return CommonCard.VernonRoche;
            case "realms_ves":
                return CommonCard.Ves;
            case "realms_yarpen":
                return CommonCard.YarpenZirgrin;
            case "scoiatael_barclay":
                return CommonCard.BarclayEls;
            case "scoiatael_ciaran":
                return CommonCard.CiaranAep;
            case "scoiatael_dennis":
                return CommonCard.DennisCranmer;
            case "scoiatael_dol_archer":
                return CommonCard.DolBlathannaArcher;
            case "scoiatael_dol_infantry_2", "scoiatael_dol_infantry_1", "scoiatael_dol_infantry":
                return CommonCard.PoorFuckingInfantry;
            case "scoiatael_dwarf", "scoiatael_dwarf_1", "scoiatael_dwarf_2":
                return CommonCard.DwarvenSkirmisher;
            case "scoiatael_eithne":
                return CommonCard.Eithne;
            case "scoiatael_elf_skirmisher_2", "scoiatael_elf_skirmisher_1", "scoiatael_elf_skirmisher":
                return CommonCard.ElvenSkirmisher;
            case "scoiatael_filavandrel":
                return CommonCard.FilavandrelAenFidhail;
            case "scoiatael_havekar_nurse", "scoiatael_havekar_nurse_1", "scoiatael_havekar_nurse_2":
                return CommonCard.HavekarHealer;
            case "scoiatael_ida":
                return CommonCard.IdaEmeanAep;
            case "scoiatael_havekar_support", "scoiatael_havekar_support_1", "scoiatael_havekar_suppor_2":
                return CommonCard.HavekarSmuggler;
            case "scoiatael_iorveth":
                return CommonCard.IsengrimFaoiltiarna;
            case "scoiatael_isengrim":
                return CommonCard.IsengrimFaoiltiarna;
            case "scoiatael_mahakam":
                return CommonCard.MahakamDefender;
            case "scoiatael_milva":
                return CommonCard.Milva;
            case "scoiatael_riordain":
                return CommonCard.Riordain;
            case "scoiatael_saskia":
                return CommonCard.Saskia;
            case "scoiatael_schirru":
                return CommonCard.Schirru;
            case "scoiatael_toruviel":
                return CommonCard.Toruviel;
            case "scoiatael_vrihedd_brigade_1", "scoiatael_vrihedd_brigade":
                return CommonCard.VriheddBrigadeRecruit;
            case "scoiatael_vrihedd_cadet":
                return CommonCard.VriheddBrigadeVeteran;
            case "skellige_berserker", "skellige_young_berserker":
                return CommonCard.Berserker;
            case "skellige_birna":
                return CommonCard.BirnaBran;
            case "skellige_blueboy":
                return CommonCard.BlueboyLugos;
            case "skellige_brokva_archer":
                return CommonCard.ClanBrokvarArcher;
            case "skellige_craite_warrior":
                return CommonCard.ClanAnCraite;
            case "skellige_dimun_pirate":
                return CommonCard.ClanDimunPirate;
            case "skellige_donar":
                return CommonCard.DonarAnHindar;
            case "skellige_draig":
                return CommonCard.DraigBonDhu;
            case "skellige_ermion":
                return CommonCard.Ermion;
            case "skellige_hemdall":
                return CommonCard.Hemdall;
            case "skellige_heymaey":
                return CommonCard.ClanHeymaeySkald;
            case "skellige_hjalmar":
                return CommonCard.Hjalmar;
            case "skellige_holger":
                return CommonCard.HolgerBlackhand;
            case "skellige_cerys":
                return CommonCard.Cerys;
            case "skellige_kambi":
                return CommonCard.Kambi;
            case "skellige_light_longship", "skellige_war_longship":
                return CommonCard.LightLongship;
            case "skellige_madmad_lugos":
                return CommonCard.MadmanLugos;
            case "skellige_olaf":
                return CommonCard.Olaf;
            case "skellige_svanrige":
                return CommonCard.Svanrige;
            case "skellige_tordarroch":
                return CommonCard.ClanTordarrochArmorsmith;
            case "skellige_udalryk":
                return CommonCard.Udalryk;
            case "skellige_vildkaarl", "skellige_young_vildkaarl":
                return CommonCard.TransformedVildkaarl;

            default:
                try {
                    throw new Exception("Debug thiiiiissss in getAddress method: " + address);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public void done(MouseEvent mouseEvent) throws Exception {
        User user = User.getUserForTest();  // TODO : change this to current user
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
        GameMenu gameMenu = new GameMenu();
        gameMenu.start(ApplicationController.getStage());
    }
}


