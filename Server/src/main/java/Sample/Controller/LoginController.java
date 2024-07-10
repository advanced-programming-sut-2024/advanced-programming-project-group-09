package Sample.Controller;

import Sample.Client;
import Sample.Model.User;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Sample.View.MainMenu;
import Sample.View.RegisterMenu;

import java.util.ArrayList;

public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void initialize() {
        username.textProperty().addListener(((observableValue, s, t1) -> welcomeText.setText("Welcome " + username.getText())));
        User.loadUsers();
    }

    public void signIn() throws Exception {
        User userWhoLogin = User.getUserByUsername(username.getText());
        if (userWhoLogin == null) {
            showAlert("Invalid username", "Check Your username", "You have not registered yet");
            return;
        }

        if (!userWhoLogin.getPassword().equals(password.getText())) {
            showAlert("Invalid password", "Check Your password", "Your password is incorrect");
            return;
        }
        NetworkController.updateUsersFromServer();
        for (User user : User.getUsers()) {
            if (user.getUsername().equals(userWhoLogin.getUsername()) && user.getIsOnline()) {
                showAlert("Already online", "logout first", "You're already online and logged in server!");
                return;
            }
        }
        loginInServer(userWhoLogin);


        User.setUserLoginIn(userWhoLogin);
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
    }

    private void loginInServer(User userWhoLogin) {
        NetworkController.updateUsersFromServer();
//        NetworkController.timeline.pause();
        userWhoLogin.setIsOnline(true);
        System.out.println("user who login:" + userWhoLogin.getUsername());
        ArrayList<String> allUserInJson = new ArrayList<>();
        for (User user : User.getUsers()) {
            System.out.println(user.getIsOnline());
            allUserInJson.add(new Gson().toJson(user));
            System.out.println(new Gson().toJson(user));
            System.out.println(user.getIsOnline());
        }
        new Client().tryToConnectToServer("UpdateUsersInServer~" + new Gson().toJson(allUserInJson));
//        NetworkController.timeline.play();
        System.out.println(userWhoLogin.getIsOnline());
    }

    private void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void reset() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you Sure?");
        alert.showAndWait();
        if (alert.getResult().getButtonData().isCancelButton()) return;
        username.setText("");
        password.setText("");
    }

    public void goToRegisterMenu() throws Exception {
        RegisterMenu registerMenu = new RegisterMenu();
        registerMenu.start(ApplicationController.getStage());
    }
}
