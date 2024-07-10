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

public class ChooseCardSkelligeController {
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
    public VBox skellige_cerysVboxInCardCollection;
    public ImageView skellige_cerysInCardCollection;
    public VBox skellige_young_berserkerVboxInCardCollection;
    public ImageView skellige_young_berserkerInCardCollection;
    public VBox skellige_war_longshipVboxInCardCollection;
    public ImageView skellige_war_longshipInCardCollection;
    public VBox skellige_udalrykVboxInCardCollection;
    public ImageView skellige_udalrykInCardCollection;
    public VBox skellige_tordarrochVboxInCardCollection;
    public ImageView skellige_tordarrochInCardCollection;
    public VBox skellige_svanrigeVboxInCardCollection;
    public ImageView skellige_svanrigeInCardCollection;
    public VBox skellige_olafVboxInCardCollection;
    public ImageView skellige_olafInCardCollection;
    public VBox skellige_madmad_lugosVboxInCardCollection;
    public ImageView skellige_madmad_lugosInCardCollection;
    public VBox skellige_light_longshipVboxInCardCollection;
    public ImageView skellige_light_longshipInCardCollection;
    public VBox skellige_holgerVboxInCardCollection;
    public ImageView skellige_holgerInCardCollection;
    public VBox skellige_hjalmarVboxInCardCollection;
    public ImageView skellige_hjalmarInCardCollection;
    public VBox skellige_heymaeyVboxInCardCollection;
    public ImageView skellige_heymaeyInCardCollection;
    public VBox skellige_hemdallVboxInCardCollection;
    public ImageView skellige_hemdallInCardCollection;
    public VBox skellige_draigVboxInCardCollection;
    public ImageView skellige_draigInCardCollection;
    public VBox skellige_donarVboxInCardCollection;
    public ImageView skellige_donarInCardCollection;
    public VBox skellige_dimun_pirateVboxInCardCollection;
    public ImageView skellige_dimun_pirateInCardCollection;
    public VBox skellige_craite_warriorVboxInCardCollection;
    public ImageView skellige_craite_warriorInCardCollection;
    public VBox skellige_brokva_archerVboxInCardCollection;
    public ImageView skellige_brokva_archerInCardCollection;
    public VBox skellige_blueboyVboxInCardCollection;
    public ImageView skellige_blueboyInCardCollection;
    public VBox skellige_birnaVboxInCardCollection;
    public ImageView skellige_birnaInCardCollection;
    public VBox skellige_berserkerVboxInCardCollection;
    public ImageView skellige_berserkerInCardCollection;
    public VBox skellige_shield_maidenVboxInCardCollection;
    public ImageView skellige_shield_maiden;
    public Label skellige_shield_maidenRemainderInCardCollection;
    public VBox skellige_cerysVboxInDeck;
    public ImageView skellige_cerysInDeck;
    public VBox skellige_young_berserkerVboxInDeck;
    public ImageView skellige_young_berserkerInDeck;
    public VBox skellige_war_longshipVboxInDeck;
    public ImageView skellige_war_longshipInDeck;
    public VBox skellige_udalrykVboxInDeck;
    public ImageView skellige_udalrykInDeck;
    public VBox skellige_tordarrochVboxInDeck;
    public ImageView skellige_tordarrochInDeck;
    public VBox skellige_svanrigeVboxInDeck;
    public ImageView skellige_svanrigeInDeck;
    public VBox skellige_olafVboxInDeck;
    public ImageView skellige_olafInDeck;
    public VBox skellige_madmad_lugosVboxInDeck;
    public ImageView skellige_madmad_lugosInDeck;
    public VBox skellige_light_longshipVboxInDeck;
    public ImageView skellige_light_longshipInDeck;
    public VBox skellige_holgerVboxInDeck;
    public ImageView skellige_holgerInDeck;
    public VBox skellige_hjalmarVboxInDeck;
    public ImageView skellige_hjalmarInDeck;
    public VBox skellige_heymaeyVboxInDeck;
    public ImageView skellige_heymaeyInDeck;
    public VBox skellige_hemdallVboxInDeck;
    public ImageView skellige_hemdallInDeck;
    public VBox skellige_draigVboxInDeck;
    public ImageView skellige_draigInDeck;
    public VBox skellige_donarVboxInDeck;
    public ImageView skellige_donarInDeck;
    public VBox skellige_dimun_pirateVboxInDeck;
    public ImageView skellige_dimun_pirateInDeck;
    public VBox skellige_craite_warriorVboxInDeck;
    public ImageView skellige_craite_warriorInDeck;
    public VBox skellige_brokva_archerVboxInDeck;
    public ImageView skellige_brokva_archerInDeck;
    public VBox skellige_blueboyVboxInDeck;
    public ImageView skellige_blueboyInDeck;
    public VBox skellige_birnaVboxInDeck;
    public ImageView skellige_birnaInDeck;
    public VBox skellige_berserkerVboxInDeck;
    public ImageView skellige_berserkerInDeck;
    public VBox skellige_shield_maidenVboxInDeck;
    public ImageView skellige_shield_maidenInDeck;
    public Label skellige_shield_maidenRemainderInDeck;
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
        skellige_shield_maiden.setImage(CommonCard.ClanDrummondShieldmaiden.getImage());
        skellige_cerysInCardCollection.setImage(CommonCard.Cerys.getImage());
        skellige_young_berserkerInCardCollection.setImage(CommonCard.YoungBerserker.getImage());
        skellige_war_longshipInCardCollection.setImage(CommonCard.WarLongship.getImage());
        skellige_udalrykInCardCollection.setImage(CommonCard.Udalryk.getImage());
        skellige_tordarrochInCardCollection.setImage(CommonCard.ClanTordarrochArmorsmith.getImage());
        skellige_svanrigeInCardCollection.setImage(CommonCard.Svanrige.getImage());
        skellige_olafInCardCollection.setImage(CommonCard.Olaf.getImage());
        skellige_madmad_lugosInCardCollection.setImage(CommonCard.MadmanLugos.getImage());
        skellige_light_longshipInCardCollection.setImage(CommonCard.LightLongship.getImage());
        skellige_holgerInCardCollection.setImage(CommonCard.HolgerBlackhand.getImage());
        skellige_hjalmarInCardCollection.setImage(CommonCard.Hjalmar.getImage());
        skellige_heymaeyInCardCollection.setImage(CommonCard.ClanHeymaeySkald.getImage());
        skellige_hemdallInCardCollection.setImage(CommonCard.Hemdall.getImage());
        skellige_draigInCardCollection.setImage(CommonCard.DraigBonDhu.getImage());
        skellige_donarInCardCollection.setImage(CommonCard.DonarAnHindar.getImage());
        skellige_dimun_pirateInCardCollection.setImage(CommonCard.ClanDimunPirate.getImage());
        skellige_craite_warriorInCardCollection.setImage(CommonCard.ClanAnCraiteWarrior.getImage());
        skellige_brokva_archerInCardCollection.setImage(CommonCard.ClanBrokvarArcher.getImage());
        skellige_blueboyInCardCollection.setImage(CommonCard.BlueboyLugos.getImage());
        skellige_birnaInCardCollection.setImage(CommonCard.BirnaBran.getImage());
        skellige_berserkerInCardCollection.setImage(CommonCard.Berserker.getImage());

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
        skellige_shield_maidenInDeck.setImage(CommonCard.ClanDrummondShieldmaiden.getImage());
        skellige_cerysInDeck.setImage(CommonCard.Cerys.getImage());
        skellige_young_berserkerInDeck.setImage(CommonCard.YoungBerserker.getImage());
        skellige_war_longshipInDeck.setImage(CommonCard.WarLongship.getImage());
        skellige_udalrykInDeck.setImage(CommonCard.Udalryk.getImage());
        skellige_tordarrochInDeck.setImage(CommonCard.ClanTordarrochArmorsmith.getImage());
        skellige_svanrigeInDeck.setImage(CommonCard.Svanrige.getImage());
        skellige_olafInDeck.setImage(CommonCard.Olaf.getImage());
        skellige_madmad_lugosInDeck.setImage(CommonCard.MadmanLugos.getImage());
        skellige_light_longshipInDeck.setImage(CommonCard.LightLongship.getImage());
        skellige_holgerInDeck.setImage(CommonCard.HolgerBlackhand.getImage());
        skellige_hjalmarInDeck.setImage(CommonCard.Hjalmar.getImage());
        skellige_heymaeyInDeck.setImage(CommonCard.ClanHeymaeySkald.getImage());
        skellige_hemdallInDeck.setImage(CommonCard.Hemdall.getImage());
        skellige_draigInDeck.setImage(CommonCard.DraigBonDhu.getImage());
        skellige_donarInDeck.setImage(CommonCard.DonarAnHindar.getImage());
        skellige_dimun_pirateInDeck.setImage(CommonCard.ClanDimunPirate.getImage());
        skellige_craite_warriorInDeck.setImage(CommonCard.ClanAnCraiteWarrior.getImage());
        skellige_brokva_archerInDeck.setImage(CommonCard.ClanBrokvarArcher.getImage());
        skellige_blueboyInDeck.setImage(CommonCard.BlueboyLugos.getImage());
        skellige_birnaInDeck.setImage(CommonCard.BirnaBran.getImage());
        skellige_berserkerInDeck.setImage(CommonCard.Berserker.getImage());
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

    public void skellige_shield_maidenUnselected(MouseEvent mouseEvent) {
        int remainingInDeck = Integer.parseInt(skellige_shield_maidenRemainderInDeck.getText().substring(0, 1));
        if (remainingInDeck == 0) return;
        remainingInDeck--;
        if (remainingInDeck == 0) {
//            deleteOneCommandersHornFromDeck();
            int skellige_shield_maidenInDeck = Integer.parseInt(skellige_shield_maidenRemainderInDeck.getText().substring(0, 1));
            if (skellige_shield_maidenInDeck == 1) {
                skellige_shield_maidenVboxInDeck.setVisible(false);
            }
            skellige_shield_maidenInDeck--;
            skellige_shield_maidenRemainderInDeck.setText(skellige_shield_maidenInDeck + "X");

        }
//        addOneCommandersHornToCardCollection();
        {
            int skellige_shield_maidenInCardCollection = Integer.parseInt(skellige_shield_maidenRemainderInCardCollection.getText().substring(0, 1));
            if (skellige_shield_maidenInCardCollection == 0) {
                skellige_shield_maidenVboxInCardCollection.setVisible(true);
            }
            skellige_shield_maidenInCardCollection++;
            skellige_shield_maidenRemainderInCardCollection.setText(skellige_shield_maidenInCardCollection + "X");
        }
        skellige_shield_maidenRemainderInDeck.setText(remainingInDeck + "X");
    }


    public void skellige_shield_maidenSelected(MouseEvent mouseEvent) {
        int remainingInCardSelection = Integer.parseInt(skellige_shield_maidenRemainderInCardCollection.getText().substring(0, 1));
        if (remainingInCardSelection == 0) return;
        remainingInCardSelection--;
        if (remainingInCardSelection == 0) {
//            deleteOneCommandersHornFromCardCollection();
            {
                int skellige_shield_maidenInCardCollection = Integer.parseInt(skellige_shield_maidenRemainderInCardCollection.getText().substring(0, 1));
                if (skellige_shield_maidenInCardCollection == 1) {
                    skellige_shield_maidenVboxInCardCollection.setVisible(false);
                }
                skellige_shield_maidenInCardCollection--;
                skellige_shield_maidenRemainderInCardCollection.setText(skellige_shield_maidenInCardCollection + "X");
            }
        }
//        addOneCommandersHornToDeck();
        {
            int skellige_shield_maidenInDeck = Integer.parseInt(skellige_shield_maidenRemainderInDeck.getText().substring(0, 1));
            if (skellige_shield_maidenInDeck == 0) {
                skellige_shield_maidenVboxInDeck.setVisible(true);
            }
            skellige_shield_maidenInDeck++;
            skellige_shield_maidenRemainderInDeck.setText(skellige_shield_maidenInDeck + "X");
        }
        skellige_shield_maidenRemainderInCardCollection.setText(remainingInCardSelection + "X");
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

    public void skellige_cerysSelected(MouseEvent mouseEvent) {
        skellige_cerysVboxInCardCollection.setVisible(false);
        skellige_cerysVboxInDeck.setVisible(true);
    }

    public void skellige_cerysUnselected(MouseEvent mouseEvent) {
        skellige_cerysVboxInCardCollection.setVisible(true);
        skellige_cerysVboxInDeck.setVisible(false);
    }

    public void skellige_war_longshipSelected(MouseEvent mouseEvent) {
        skellige_war_longshipVboxInCardCollection.setVisible(false);
        skellige_war_longshipVboxInDeck.setVisible(true);
    }

    public void skellige_war_longshipUnselected(MouseEvent mouseEvent) {
        skellige_war_longshipVboxInCardCollection.setVisible(true);
        skellige_war_longshipVboxInDeck.setVisible(false);
    }

    public void skellige_young_berserkerSelected(MouseEvent mouseEvent) {
        skellige_young_berserkerVboxInCardCollection.setVisible(false);
        skellige_young_berserkerVboxInDeck.setVisible(true);
    }

    public void skellige_young_berserkerUnselected(MouseEvent mouseEvent) {
        skellige_young_berserkerVboxInCardCollection.setVisible(true);
        skellige_young_berserkerVboxInDeck.setVisible(false);
    }

    public void skellige_udalrykSelected(MouseEvent mouseEvent) {
        skellige_udalrykVboxInCardCollection.setVisible(false);
        skellige_udalrykVboxInDeck.setVisible(true);
    }

    public void skellige_udalrykUnselected(MouseEvent mouseEvent) {
        skellige_udalrykVboxInCardCollection.setVisible(true);
        skellige_udalrykVboxInDeck.setVisible(false);
    }

    public void skellige_tordarrochSelected(MouseEvent mouseEvent) {
        skellige_tordarrochVboxInCardCollection.setVisible(false);
        skellige_tordarrochVboxInDeck.setVisible(true);
    }

    public void skellige_tordarrochUnselected(MouseEvent mouseEvent) {
        skellige_tordarrochVboxInCardCollection.setVisible(true);
        skellige_tordarrochVboxInDeck.setVisible(false);
    }

    public void skellige_svanrigeSelected(MouseEvent mouseEvent) {
        skellige_svanrigeVboxInCardCollection.setVisible(false);
        skellige_svanrigeVboxInDeck.setVisible(true);
    }

    public void skellige_svanrigeUnselected(MouseEvent mouseEvent) {
        skellige_svanrigeVboxInCardCollection.setVisible(true);
        skellige_svanrigeVboxInDeck.setVisible(false);
    }

    public void skellige_olafSelected(MouseEvent mouseEvent) {
        skellige_olafVboxInCardCollection.setVisible(false);
        skellige_olafVboxInDeck.setVisible(true);
    }

    public void skellige_olafUnselected(MouseEvent mouseEvent) {
        skellige_olafVboxInCardCollection.setVisible(true);
        skellige_olafVboxInDeck.setVisible(false);
    }

    public void skellige_madmad_lugosSelected(MouseEvent mouseEvent) {
        skellige_madmad_lugosVboxInCardCollection.setVisible(false);
        skellige_madmad_lugosVboxInDeck.setVisible(true);
    }

    public void skellige_madmad_lugosUnselected(MouseEvent mouseEvent) {
        skellige_madmad_lugosVboxInCardCollection.setVisible(true);
        skellige_madmad_lugosVboxInDeck.setVisible(false);
    }

    public void skellige_light_longshipSelected(MouseEvent mouseEvent) {
        skellige_light_longshipVboxInCardCollection.setVisible(false);
        skellige_light_longshipVboxInDeck.setVisible(true);
    }

    public void skellige_light_longshipUnselected(MouseEvent mouseEvent) {
        skellige_light_longshipVboxInCardCollection.setVisible(true);
        skellige_light_longshipVboxInDeck.setVisible(false);
    }

    public void skellige_holgerSelected(MouseEvent mouseEvent) {
        skellige_holgerVboxInCardCollection.setVisible(false);
        skellige_holgerVboxInDeck.setVisible(true);
    }

    public void skellige_holgerUnselected(MouseEvent mouseEvent) {
        skellige_holgerVboxInCardCollection.setVisible(true);
        skellige_holgerVboxInDeck.setVisible(false);
    }

    public void skellige_hjalmarSelected(MouseEvent mouseEvent) {
        skellige_hjalmarVboxInCardCollection.setVisible(false);
        skellige_hjalmarVboxInDeck.setVisible(true);
    }

    public void skellige_hjalmarUnselected(MouseEvent mouseEvent) {
        skellige_hjalmarVboxInCardCollection.setVisible(true);
        skellige_hjalmarVboxInDeck.setVisible(false);
    }

    public void skellige_heymaeySelected(MouseEvent mouseEvent) {
        skellige_heymaeyVboxInCardCollection.setVisible(false);
        skellige_heymaeyVboxInDeck.setVisible(true);
    }

    public void skellige_heymaeyUnselected(MouseEvent mouseEvent) {
        skellige_heymaeyVboxInCardCollection.setVisible(true);
        skellige_heymaeyVboxInDeck.setVisible(false);
    }

    public void skellige_hemdallSelected(MouseEvent mouseEvent) {
        skellige_hemdallVboxInCardCollection.setVisible(false);
        skellige_hemdallVboxInDeck.setVisible(true);
    }

    public void skellige_hemdallUnselected(MouseEvent mouseEvent) {
        skellige_hemdallVboxInCardCollection.setVisible(true);
        skellige_hemdallVboxInDeck.setVisible(false);
    }

    public void skellige_draigSelected(MouseEvent mouseEvent) {
        skellige_draigVboxInCardCollection.setVisible(false);
        skellige_draigVboxInDeck.setVisible(true);
    }

    public void skellige_draigUnselected(MouseEvent mouseEvent) {
        skellige_draigVboxInCardCollection.setVisible(true);
        skellige_draigVboxInDeck.setVisible(false);
    }

    public void skellige_donarSelected(MouseEvent mouseEvent) {
        skellige_donarVboxInCardCollection.setVisible(false);
        skellige_donarVboxInDeck.setVisible(true);
    }

    public void skellige_donarUnselected(MouseEvent mouseEvent) {
        skellige_donarVboxInCardCollection.setVisible(true);
        skellige_donarVboxInDeck.setVisible(false);
    }

    public void skellige_dimun_pirateSelected(MouseEvent mouseEvent) {
        skellige_dimun_pirateVboxInCardCollection.setVisible(false);
        skellige_dimun_pirateVboxInDeck.setVisible(true);
    }

    public void skellige_dimun_pirateUnselected(MouseEvent mouseEvent) {
        skellige_dimun_pirateVboxInCardCollection.setVisible(true);
        skellige_dimun_pirateVboxInDeck.setVisible(false);
    }

    public void skellige_craite_warriorSelected(MouseEvent mouseEvent) {
        skellige_craite_warriorVboxInCardCollection.setVisible(false);
        skellige_craite_warriorVboxInDeck.setVisible(true);
    }

    public void skellige_craite_warriorUnselected(MouseEvent mouseEvent) {
        skellige_craite_warriorVboxInCardCollection.setVisible(true);
        skellige_craite_warriorVboxInDeck.setVisible(false);
    }

    public void skellige_brokva_archerSelected(MouseEvent mouseEvent) {
        skellige_brokva_archerVboxInCardCollection.setVisible(false);
        skellige_brokva_archerVboxInDeck.setVisible(true);
    }

    public void skellige_brokva_archerUnselected(MouseEvent mouseEvent) {
        skellige_brokva_archerVboxInCardCollection.setVisible(true);
        skellige_brokva_archerVboxInDeck.setVisible(false);
    }

    public void skellige_blueboySelected(MouseEvent mouseEvent) {
        skellige_blueboyVboxInCardCollection.setVisible(false);
        skellige_blueboyVboxInDeck.setVisible(true);
    }

    public void skellige_blueboyUnselected(MouseEvent mouseEvent) {
        skellige_blueboyVboxInCardCollection.setVisible(true);
        skellige_blueboyVboxInDeck.setVisible(false);
    }

    public void skellige_birnaSelected(MouseEvent mouseEvent) {
        skellige_birnaVboxInCardCollection.setVisible(false);
        skellige_birnaVboxInDeck.setVisible(true);
    }

    public void skellige_birnaUnselected(MouseEvent mouseEvent) {
        skellige_birnaVboxInCardCollection.setVisible(true);
        skellige_birnaVboxInDeck.setVisible(false);
    }

    public void skellige_berserkerSelected(MouseEvent mouseEvent) {
        skellige_berserkerVboxInCardCollection.setVisible(false);
        skellige_berserkerVboxInDeck.setVisible(true);
    }

    public void skellige_berserkerUnselected(MouseEvent mouseEvent) {
        skellige_berserkerVboxInCardCollection.setVisible(true);
        skellige_berserkerVboxInDeck.setVisible(false);
    }


    public SpecialCard getSpecialCardByIdAddress(String address) {
        return ChooseCardMonsterController.getSpecialCardByIdAddress(address);
    }

    public CommonCard getCommonCardByIdAddress(String address) {
        return ChooseCardMonsterController.getCommonCardByIdAddress(address);
    }

    public void done(MouseEvent mouseEvent) {
        User user = User.getUserForTest();  // TODO : change this to current user
        if (checkEnoughSelection()) {
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
        return !check10SelectionOfSpecialCardValidation() || !check22SelectionOfCommonCardValidation();
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

    public boolean check22SelectionOfCommonCardValidation() {
        String regex = "Number of Unit Cards: (?<allCards>\\d+)/22";
        Matcher matcher = getCommandMatcher(regex, numberOfAllCards);
        int allCards = Integer.parseInt(matcher.group("allCards"));
        return allCards >= 22;
    }

    public boolean check10SelectionOfSpecialCardValidation() {
        String regex = "Special Cards: (?<specialCards>\\d+)/10";
        Matcher matcher = getCommandMatcher(regex, specialCards);
        int numOfSpecialCards = Integer.parseInt(matcher.group("specialCards"));
        return numOfSpecialCards >= 10;
    }

    private Matcher getCommandMatcher(String regex, Text text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.getText());
        if (matcher.matches()) return matcher;
        return null;
    }


}
