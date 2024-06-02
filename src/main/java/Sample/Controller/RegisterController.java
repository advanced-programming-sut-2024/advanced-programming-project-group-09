package Sample.Controller;

import Sample.Enum.Commands;
import Sample.Model.User;
import Sample.View.LoginMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;

public class RegisterController {
    @FXML
    private Label helloText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField passwordConfirmation;
    @FXML
    private TextField nickname;
    @FXML
    private TextField email;

    public void initialize() {
        username.textProperty().addListener(((observableValue, s, t1) -> {
            helloText.setText("Hello " + username.getText());
        }));
    }

    public void register() throws Exception {
        if (Commands.UserName.getMatcher(username.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("Check Your username");
            alert.setContentText("Please enter a valid username");
            alert.show();
            return;
        }
        if (Commands.Password.getMatcher(password.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unacceptable password");
            alert.setHeaderText("Check Your password");
            alert.setContentText("Please enter a strong password");
            alert.show();
            return;
        }
        if (Commands.Nickname.getMatcher(nickname.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unacceptable nickname");
            alert.setHeaderText("Check Your nickname");
            alert.setContentText("Please enter a valid nickname");
            alert.show();
            return;
        }
        if (Commands.EMAIL.getMatcher(email.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unacceptable email");
            alert.setHeaderText("Check Your email");
            alert.setContentText("Please enter a valid email");
            alert.show();
            return;
        }
        if (User.getUserByUsername(username.getText()) != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate username");
            alert.setHeaderText("This username is already registered");
            alert.setContentText("Please enter another username or back to login Menu");
            alert.show();
            return;
        }
        if (!password.getText().equals(passwordConfirmation.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error password");
            alert.setHeaderText("Check Your confirmation password");
            alert.setContentText("Your password does not match with confirmation password");
            alert.show();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Create account");
        alert.setHeaderText("Account successfully created");
        alert.show();
        User newUser = new User(username.getText(), password.getText(), email.getText(), nickname.getText());
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(ApplicationController.getStage());
    }

    public void backToLoginMenu(MouseEvent mouseEvent) throws Exception {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(ApplicationController.getStage());
    }
}
