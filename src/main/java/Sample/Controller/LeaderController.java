package Sample.Controller;

import Sample.CardEnums.Faction;
import Sample.CardEnums.Leader;
import Sample.Model.User;
import Sample.View.FactionMenu;
import Sample.View.LoginMenu;
import Sample.View.MainMenu;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Objects;

public class LeaderController {
    @FXML
    private Label ability;
    @FXML
    private Label cardName;
    @FXML
    private Label faction;
    @FXML
    private Label sentence;
    @FXML
    private ImageView factionImage;
    @FXML
    private StackPane border1;
    @FXML
    private ImageView image1;
    @FXML
    private StackPane border2;
    @FXML
    private ImageView image2;
    @FXML
    private StackPane border3;
    @FXML
    private ImageView image3;
    @FXML
    private StackPane border4;
    @FXML
    private ImageView image4;
    @FXML
    private StackPane border5;
    @FXML
    private ImageView image5;
    private TranslateTransition translateTransition;
    private ScaleTransition scaleTransition;
    private Timeline timeline;

    public void initialize() {
        setWidthAndHeight();
        User user = User.getUserLoginIn();

        cardName.setText(user.getFactionLeader().getName());
        ability.setText(user.getFactionLeader().getAbility());

        Image factionMonster = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_monsters.png")));
        Image factionNilfgaardian = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_nilfgaard.png")));
        Image factionNorthern = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_realms.png")));
        Image factionScoiatael = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_scoiatael.png")));
        Image factionSkellige = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/Icons/deck_shield_skellige.png")));

        Image monsterLeader1 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_bronze.jpg")));
        Image monsterLeader2 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_copper.jpg")));
        Image monsterLeader3 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_gold.jpg")));
        Image monsterLeader4 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_silver.jpg")));
        Image monsterLeader5 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/monsters_eredin_the_treacherous.jpg")));

        Image nilfLeader1 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_bronze.jpg")));
        Image nilfLeader2 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_copper.jpg")));
        Image nilfLeader3 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_gold.jpg")));
        Image nilfLeader4 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_silver.jpg")));
        Image nilfLeader5 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/nilfgaard_emhyr_invader_of_the_north.jpg")));

        Image northernLeader1 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_bronze.jpg")));
        Image northernLeader2 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_copper.jpg")));
        Image northernLeader3 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_gold.jpg")));
        Image northernLeader4 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_silver.jpg")));
        Image northernLeader5 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/realms_foltest_son_of_medell.jpg")));

        Image scoiataelLeader1 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_bronze.jpg")));
        Image scoiataelLeader2 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_copper.jpg")));
        Image scoiataelLeader3 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_gold.jpg")));
        Image scoiataelLeader4 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_silver.jpg")));
        Image scoiataelLeader5 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/scoiatael_francesca_hope_of_the_aen_seidhe.jpg")));

        Image skelligeLeader2 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/skellige_crach_an_craite.jpg")));
        Image skelligeLeader4 = new Image(Objects.requireNonNull(LoginMenu.class.getResourceAsStream("Images/CardImages/skellige_king_bran.jpg")));

        if (user.getFactionSelected().equals(Faction.Monsters)) {
            sentence.setText(Faction.Monsters.getAbility());
            faction.setText(Faction.Monsters.getFactionName());
            factionImage.setImage(factionMonster);
            image1.setImage(monsterLeader1);
            image2.setImage(monsterLeader2);
            image3.setImage(monsterLeader3);
            image4.setImage(monsterLeader4);
            image5.setImage(monsterLeader5);
        } else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
            sentence.setText(Faction.Nilfgaard.getAbility());
            faction.setText(Faction.Nilfgaard.getFactionName());
            factionImage.setImage(factionNilfgaardian);
            image1.setImage(nilfLeader1);
            image2.setImage(nilfLeader2);
            image3.setImage(nilfLeader3);
            image4.setImage(nilfLeader4);
            image5.setImage(nilfLeader5);
        } else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
            sentence.setText(Faction.NorthernRealms.getAbility());
            faction.setText(Faction.NorthernRealms.getFactionName());
            factionImage.setImage(factionNorthern);
            image1.setImage(northernLeader1);
            image2.setImage(northernLeader2);
            image3.setImage(northernLeader3);
            image4.setImage(northernLeader4);
            image5.setImage(northernLeader5);
        } else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
            sentence.setText(Faction.Scoiatael.getAbility());
            faction.setText(Faction.Scoiatael.getFactionName());
            factionImage.setImage(factionScoiatael);
            image1.setImage(scoiataelLeader1);
            image2.setImage(scoiataelLeader2);
            image3.setImage(scoiataelLeader3);
            image4.setImage(scoiataelLeader4);
            image5.setImage(scoiataelLeader5);
        } else if (user.getFactionSelected().equals(Faction.Skellige)) {
            sentence.setText(Faction.Skellige.getAbility());
            faction.setText(Faction.Skellige.getFactionName());
            factionImage.setImage(factionSkellige);
            image2.setImage(skelligeLeader2);
            image4.setImage(skelligeLeader4);
        }
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.01), event -> checkFactionLeader())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void checkFactionLeader() {
        User user = User.getUserLoginIn();
        if (user.getFactionSelected().equals(Faction.Monsters)) {
            if (user.getFactionLeader().equals(Leader.KingOfTheWildHunt)) {
                addBorder(1);
            } else if (user.getFactionLeader().equals(Leader.CommanderOfTheRedRiders)) {
                addBorder(2);
            } else if (user.getFactionLeader().equals(Leader.DestroyerOfWorlds)) {
                addBorder(3);
            } else if (user.getFactionLeader().equals(Leader.BringerOfDeath)) {
                addBorder(4);
            } else if (user.getFactionLeader().equals(Leader.TheTreacherous)) {
                addBorder(5);
            }
        } else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
            if (user.getFactionLeader().equals(Leader.EmperorOfNilfgaard)) {
                addBorder(1);
            } else if (user.getFactionLeader().equals(Leader.HisImperialMajesty)) {
                addBorder(2);
            } else if (user.getFactionLeader().equals(Leader.TheRelentless)) {
                addBorder(3);
            } else if (user.getFactionLeader().equals(Leader.WhiteFlame)) {
                addBorder(4);
            } else if (user.getFactionLeader().equals(Leader.InvaderOfTheNorth)) {
                addBorder(5);
            }
        } else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
            if (user.getFactionLeader().equals(Leader.LordCommanderOfTheNorth)) {
                addBorder(1);
            } else if (user.getFactionLeader().equals(Leader.KingOfTemeria)) {
                addBorder(2);
            } else if (user.getFactionLeader().equals(Leader.SteelForged)) {
                addBorder(3);
            } else if (user.getFactionLeader().equals(Leader.SiegeMaster)) {
                addBorder(4);
            } else if (user.getFactionLeader().equals(Leader.SonOfMedell)) {
                addBorder(5);
            }
        } else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
            if (user.getFactionLeader().equals(Leader.PurebloodElf)) {
                addBorder(1);
            } else if (user.getFactionLeader().equals(Leader.DaisyOfTheValley)) {
                addBorder(2);
            } else if (user.getFactionLeader().equals(Leader.TheBeautiful)) {
                addBorder(3);
            } else if (user.getFactionLeader().equals(Leader.QueenOfDolBlathanna)) {
                addBorder(4);
            } else if (user.getFactionLeader().equals(Leader.HopeOfTheAenSeidhe)) {
                addBorder(5);
            }
        } else if (user.getFactionSelected().equals(Faction.Skellige)) {
            if (user.getFactionLeader().equals(Leader.CrachAnCraite)) {
                addBorder(2);
            } else if (user.getFactionLeader().equals(Leader.KingBran)) {
                addBorder(4);
            }
        }
    }

    private void addBorder(int i) {
        BorderStroke borderStroke = new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(8));
        Border border = new Border(borderStroke);
        if (i == 1) {
            border1.setBorder(border);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(null);
        } else if (i == 2) {
            border1.setBorder(null);
            border2.setBorder(border);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(null);
        } else if (i == 3) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(border);
            border4.setBorder(null);
            border5.setBorder(null);
        } else if (i == 4) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(border);
            border5.setBorder(null);
        } else if (i == 5) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(border);
        } else if (i == 0) {
            border1.setBorder(null);
            border2.setBorder(null);
            border3.setBorder(null);
            border4.setBorder(null);
            border5.setBorder(null);
        }
    }

    private void setWidthAndHeight() {
        image1.setFitHeight(260);
        image1.setFitWidth(130);
        image2.setFitHeight(260);
        image2.setFitWidth(130);
        image3.setFitHeight(260);
        image3.setFitWidth(130);
        image4.setFitHeight(260);
        image4.setFitWidth(130);
        image5.setFitHeight(260);
        image5.setFitWidth(130);
    }

    public void changeFaction() {
        timeline.stop();
        FactionMenu factionMenu = new FactionMenu();
        try {
            factionMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void focusOnImage(MouseEvent mouseEvent) {
        User user = User.getUserLoginIn();
        ImageView imageView = (ImageView) mouseEvent.getSource();
        String id = imageView.getId();
        switch (id) {
            case "image1" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) {
                    cardName.setText(Leader.KingOfTheWildHunt.getName());
                    ability.setText(Leader.KingOfTheWildHunt.getAbility());
                } else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
                    cardName.setText(Leader.EmperorOfNilfgaard.getName());
                    ability.setText(Leader.EmperorOfNilfgaard.getAbility());
                } else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
                    cardName.setText(Leader.LordCommanderOfTheNorth.getName());
                    ability.setText(Leader.LordCommanderOfTheNorth.getAbility());
                } else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
                    cardName.setText(Leader.PurebloodElf.getName());
                    ability.setText(Leader.PurebloodElf.getAbility());
                }
            }
            case "image2" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) {
                    cardName.setText(Leader.CommanderOfTheRedRiders.getName());
                    ability.setText(Leader.CommanderOfTheRedRiders.getAbility());
                } else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
                    cardName.setText(Leader.HisImperialMajesty.getName());
                    ability.setText(Leader.HisImperialMajesty.getAbility());
                } else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
                    cardName.setText(Leader.KingOfTemeria.getName());
                    ability.setText(Leader.KingOfTemeria.getAbility());
                } else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
                    cardName.setText(Leader.DaisyOfTheValley.getName());
                    ability.setText(Leader.DaisyOfTheValley.getAbility());
                } else if (user.getFactionSelected().equals(Faction.Skellige)) {
                    cardName.setText(Leader.CrachAnCraite.getName());
                    ability.setText(Leader.CrachAnCraite.getAbility());
                }
            }
            case "image3" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) {
                    cardName.setText(Leader.DestroyerOfWorlds.getName());
                    ability.setText(Leader.DestroyerOfWorlds.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
                    cardName.setText(Leader.TheRelentless.getName());
                    ability.setText(Leader.TheRelentless.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
                    cardName.setText(Leader.SteelForged.getName());
                    ability.setText(Leader.SteelForged.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
                    cardName.setText(Leader.TheBeautiful.getName());
                    ability.setText(Leader.TheBeautiful.getAbility());
                }
            }
            case "image4" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) {
                    cardName.setText(Leader.BringerOfDeath.getName());
                    ability.setText(Leader.BringerOfDeath.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
                    cardName.setText(Leader.WhiteFlame.getName());
                    ability.setText(Leader.WhiteFlame.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
                    cardName.setText(Leader.SiegeMaster.getName());
                    ability.setText(Leader.SiegeMaster.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
                    cardName.setText(Leader.QueenOfDolBlathanna.getName());
                    ability.setText(Leader.QueenOfDolBlathanna.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.Skellige)) {
                    cardName.setText(Leader.KingBran.getName());
                    ability.setText(Leader.KingBran.getAbility());
                }
            }
            case "image5" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) {
                    cardName.setText(Leader.TheTreacherous.getName());
                    ability.setText(Leader.TheTreacherous.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.Nilfgaard)) {
                    cardName.setText(Leader.InvaderOfTheNorth.getName());
                    ability.setText(Leader.InvaderOfTheNorth.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.NorthernRealms)) {
                    cardName.setText(Leader.SonOfMedell.getName());
                    ability.setText(Leader.SonOfMedell.getAbility());
                }
                else if (user.getFactionSelected().equals(Faction.Scoiatael)) {
                    cardName.setText(Leader.HopeOfTheAenSeidhe.getName());
                    ability.setText(Leader.HopeOfTheAenSeidhe.getAbility());
                }
            }
        }

        scaleTransition = new ScaleTransition(Duration.millis(500), imageView);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        translateTransition = new TranslateTransition(Duration.millis(500), imageView);
        translateTransition.setToX((imageView.getFitWidth() - imageView.getLayoutBounds().getWidth()) / 2);
        translateTransition.setToY((imageView.getFitHeight() - imageView.getLayoutBounds().getHeight()) / 2 + 50);
        translateTransition.play();
    }

    public void unFocus(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();

        cardName.setText(User.getUserLoginIn().getFactionLeader().getName());
        ability.setText(User.getUserLoginIn().getFactionLeader().getAbility());

        scaleTransition = new ScaleTransition(Duration.millis(500), imageView);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        translateTransition = new TranslateTransition(Duration.millis(500), imageView);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.play();
    }

    public void unFocusAfterChooseLeader(ImageView imageView) {
        cardName.setText(User.getUserLoginIn().getFactionLeader().getName());
        ability.setText(User.getUserLoginIn().getFactionLeader().getAbility());

        scaleTransition = new ScaleTransition(Duration.millis(500), imageView);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        translateTransition = new TranslateTransition(Duration.millis(500), imageView);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.play();
    }


    public void changeLeader(MouseEvent mouseEvent) {
        User user = User.getUserLoginIn();
        ImageView source = (ImageView) mouseEvent.getSource();
        String id = source.getId();

        switch (id) {
            case "image1" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.KingOfTheWildHunt);
                else if (user.getFactionSelected().equals(Faction.Nilfgaard))
                    user.setFactionLeader(Leader.EmperorOfNilfgaard);
                else if (user.getFactionSelected().equals(Faction.NorthernRealms))
                    user.setFactionLeader(Leader.LordCommanderOfTheNorth);
                else if (user.getFactionSelected().equals(Faction.Scoiatael))
                    user.setFactionLeader(Leader.PurebloodElf);
                unFocusAfterChooseLeader(image1);
            }
            case "image2" -> {
                if (user.getFactionSelected().equals(Faction.Monsters))
                    user.setFactionLeader(Leader.CommanderOfTheRedRiders);
                else if (user.getFactionSelected().equals(Faction.Nilfgaard))
                    user.setFactionLeader(Leader.HisImperialMajesty);
                else if (user.getFactionSelected().equals(Faction.NorthernRealms))
                    user.setFactionLeader(Leader.KingOfTemeria);
                else if (user.getFactionSelected().equals(Faction.Scoiatael))
                    user.setFactionLeader(Leader.DaisyOfTheValley);
                else if (user.getFactionSelected().equals(Faction.Skellige))
                    user.setFactionLeader(Leader.CrachAnCraite);
                unFocusAfterChooseLeader(image2);
            }
            case "image3" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.DestroyerOfWorlds);
                else if (user.getFactionSelected().equals(Faction.Nilfgaard))
                    user.setFactionLeader(Leader.TheRelentless);
                else if (user.getFactionSelected().equals(Faction.NorthernRealms))
                    user.setFactionLeader(Leader.SteelForged);
                else if (user.getFactionSelected().equals(Faction.Scoiatael))
                    user.setFactionLeader(Leader.TheBeautiful);
                unFocusAfterChooseLeader(image3);
            }
            case "image4" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.BringerOfDeath);
                else if (user.getFactionSelected().equals(Faction.Nilfgaard)) user.setFactionLeader(Leader.WhiteFlame);
                else if (user.getFactionSelected().equals(Faction.NorthernRealms))
                    user.setFactionLeader(Leader.SiegeMaster);
                else if (user.getFactionSelected().equals(Faction.Scoiatael))
                    user.setFactionLeader(Leader.QueenOfDolBlathanna);
                else if (user.getFactionSelected().equals(Faction.Skellige)) user.setFactionLeader(Leader.KingBran);
                unFocusAfterChooseLeader(image4);
            }
            case "image5" -> {
                if (user.getFactionSelected().equals(Faction.Monsters)) user.setFactionLeader(Leader.TheTreacherous);
                else if (user.getFactionSelected().equals(Faction.Nilfgaard))
                    user.setFactionLeader(Leader.InvaderOfTheNorth);
                else if (user.getFactionSelected().equals(Faction.NorthernRealms))
                    user.setFactionLeader(Leader.SonOfMedell);
                else if (user.getFactionSelected().equals(Faction.Scoiatael))
                    user.setFactionLeader(Leader.HopeOfTheAenSeidhe);
                unFocusAfterChooseLeader(image5);
            }
        }

    }

    public void backToMainMenu() throws Exception {
        timeline.stop();
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
    }
}

