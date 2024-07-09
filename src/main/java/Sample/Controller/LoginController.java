package Sample.Controller;

import Sample.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

        User.setUserLoginIn(userWhoLogin);
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(ApplicationController.getStage());
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

    public void setUsername(TextField username) {
        this.username = username;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }
}
