package Sample.Network.Client.controller.UserAndGameControllers;

import Sample.Network.Client.model.Gwent;
import Sample.Network.Client.model.User.User;
import Sample.View.MainMenu;
import Sample.View.RegisterMenu;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        // Assuming loadUsers is now handled server-side, we don't need to call it here.
    }

    public void signIn() throws Exception {
        String response = Gwent.getInstance().login(username.getText(), password.getText());
        if (response.startsWith("400")) {
            showAlert("Login Failed", "Invalid credentials", "Please check your username and password.");
            return;
        }

        User userWhoLogin = new Gson().fromJson(response, User.class);
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
}
