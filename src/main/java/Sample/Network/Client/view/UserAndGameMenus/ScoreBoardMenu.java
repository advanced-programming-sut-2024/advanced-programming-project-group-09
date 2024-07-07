package Sample.Network.Client.view.UserAndGameMenus;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import Sample.Network.Client.model.Gwent;
import Sample.Network.Client.model.Television.Television;
import Sample.Network.Client.model.User.User;
import Sample.Network.Client.view.Main;

import java.net.URL;
import java.util.ArrayList;

public class ScoreBoardMenu extends Application {
    public Pane rootPane;
    public TableView<ScoreBoardTable> table;
    public TableColumn<ScoreBoardTable, Circle> avatarColumn;
    public TableColumn<ScoreBoardTable, Integer> rankColumn;
    public TableColumn<ScoreBoardTable, String> usernameColumn;
    public TableColumn<ScoreBoardTable, Integer> highScoreColumn;
    public TableColumn<ScoreBoardTable, ImageView> connectionColumn;
    public TableColumn<ScoreBoardTable, ImageView> televisionColumn;
    public TableColumn<ScoreBoardTable, Button> selectColumn;
    private final ObservableList<ScoreBoardTable> rankingTable = FXCollections.observableArrayList();
    public TableColumn<ScoreBoardTable, String> lastSeenColumn;


    @Override
    public void start(Stage stage) throws Exception {
        rootPane = FXMLLoader.load(
                new URL(ScoreBoardMenu.class.getResource("/FXML/ScoreboardMenu.fxml").toExternalForm()));
        rootPane.setBackground(new Background(new BackgroundImage(new Image(
                ProfileMenu.class.getResource("/assets/backgrounds/profileMenu.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false))));
        Scene scene = new Scene(rootPane);
        scene.getStylesheets().add(ScoreBoardMenu.class.getResource("/CSS/scoreboardStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    public void initialize() {
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        avatarColumn.setCellValueFactory(new PropertyValueFactory<>("avatar"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        highScoreColumn.setCellValueFactory(new PropertyValueFactory<>("highScore"));
        connectionColumn.setCellValueFactory(new PropertyValueFactory<>("connectionMode"));
        televisionColumn.setCellValueFactory(new PropertyValueFactory<>("television"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));
        lastSeenColumn.setCellValueFactory(new PropertyValueFactory<>("lastSeen"));

        addUsers();
        makeTimeLineForUpdatingData();
    }

    private void makeTimeLineForUpdatingData() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> addUsers()));
        timeline.setCycleCount(-1);
        timeline.play();
    }

    private void addUsers() {
        rankingTable.clear();
        table.getItems().clear();
        ArrayList<User> ranking = Gwent.getInstance().getUserRankings();
        for (User user : ranking) {
            rankingTable.add(new ScoreBoardTable(user));
        }
        table.setItems(rankingTable);
    }

    public void openProfile(MouseEvent mouseEvent) {
        if (table.getSelectionModel().getSelectedItem() != null) {
//            ServerUser user = Gwent.getInstance().getUser(table.getSelectionModel().getSelectedItem().getUsername());
//            MenusUtils.createProfileShowPopUp(user, MainController.getCurrentUser().isFriend(user)).show(Main.mainStage);
            try {
                new Television().start(Main.mainStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        new MainMenu().start(Main.mainStage);
    }

    public void update(ActionEvent actionEvent) {
        addUsers();
    }
}
