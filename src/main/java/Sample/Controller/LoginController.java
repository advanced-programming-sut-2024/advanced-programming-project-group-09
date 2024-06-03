package Sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Sample.Model.User;
import Sample.View.MainMenu;
import Sample.View.RegisterMenu;

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
    }

    public void signIn() throws Exception {
        User userWhoLogin = User.getUserByUsername(username.getText());
        if (userWhoLogin == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("Check Your username");
            alert.setContentText("You have not registered yet");
            alert.show();
            return;
        }
        if (!userWhoLogin.getPassword().equals(password.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid password");
            alert.setHeaderText("Check Your password");
            alert.setContentText("Your password is incorrect");
            alert.show();
            return;
        }
        User.setUserLoginIn(userWhoLogin);
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
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


