package Sample.Network.Client.controller.UserAndGameControllers;

import Sample.Network.Client.model.Gwent;
import Sample.Network.Client.model.User.User;
import Sample.Network.Client.model.User.UserManager;
import Sample.Network.Client.view.UserAndGameMenus.MainMenu;
import Sample.Network.Client.view.UserAndGameMenus.RegisterMenu;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Sample.Network.Client.view.enums.messages.UserMessage.SignupAndLoginMessage;

import java.util.HashMap;

public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private boolean loggedInProperty = false;
    private User currentUser;

    @FXML
    public void initialize() {
        username.textProperty().addListener(((observableValue, s, t1) -> welcomeText.setText("Welcome " + username.getText())));
    }

    public SignupAndLoginMessage login(HashMap<String, String> inputs) {
        currentUser = Gwent.getInstance().getUser(inputs.get("username"));
        if (inputs.get("username").equals("") || inputs.get("password").equals(""))
            return SignupAndLoginMessage.EMPTY_FIELD;
        if (currentUser == null)
            return SignupAndLoginMessage.USER_DOES_NOT_EXIST;
        if (!currentUser.isPasswordCorrect(inputs.get("password"))) {
            return SignupAndLoginMessage.INCORRECT_PASSWORD;
        }
        String response = Gwent.getInstance().login(currentUser.getUsername(), inputs.get("password"));
        if (response.equals("400: Already logged in"))
            return SignupAndLoginMessage.ALREADY_LOGGED_IN;
        if (inputs.get("stayLoggedIn") != null) UserManager.setLoggedInUser(currentUser);
        loggedInProperty = true;
        return SignupAndLoginMessage.SUCCESS_PROCESS;
    }

    public void signIn() throws Exception {
        HashMap<String, String> inputs = new HashMap<>();
        inputs.put("username", username.getText());
        inputs.put("password", password.getText());
        showLoginResult(login(inputs));
    }

    private void showLoginResult(SignupAndLoginMessage loginMessage) throws Exception {
        switch (loginMessage) {
            case EMPTY_FIELD:
                showAlert("Login Failed", "Invalid credentials", "Please check your username and password.");
                break;
            case USER_DOES_NOT_EXIST:
                showAlert("Login Failed", "User not found", "The username you entered does not exist.");
                break;
            case INCORRECT_PASSWORD:
                showAlert("Login Failed", "Incorrect password", "The password you entered is incorrect.");
                break;
            case ALREADY_LOGGED_IN:
                showAlert("Login Failed", "User already logged in", "The user is already logged in.");
                break;
            case SUCCESS_PROCESS:
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(ApplicationController.getStage());
                break;
        }
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

    public boolean isLoggedInProperty() {
        return loggedInProperty;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
