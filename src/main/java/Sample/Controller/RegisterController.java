package Sample.Controller;

import Sample.Enum.Commands;
import Sample.Model.User;
import Sample.View.LoginMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.security.SecureRandom;
import java.util.Random;

public class RegisterController {
    @FXML
    private ImageView hideOrRevealPasswordImage;
    @FXML
    private Label helloText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField showPassword;
    @FXML
    private PasswordField passwordConfirmation;
    @FXML
    private TextField nickname;
    @FXML
    private TextField email;

    public void initialize() {
        setPasswordShowImage("Images/HidePassword.png");
        username.textProperty().addListener(((observableValue, s, t1) -> {
            helloText.setText("Hello " + username.getText());
        }));
    }

    private void setPasswordShowImage(String name) {
        Image image = new Image(String.valueOf(LoginMenu.class.getResource(name)));
        hideOrRevealPasswordImage.setImage(image);
        hideOrRevealPasswordImage.setClip(new Circle(15, 15, 15));
    }

    private int createRandomNumber() {
        int min = 0;
        int max = 10000;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void register() throws Exception {
        if (Commands.UserName.getMatcher(username.getText()) == null) {
            showAlert("Invalid username", "Check Your username", "Please enter a valid username");
            return;
        }
        if (!showPassword.getText().isEmpty()) password.setText(showPassword.getText());
        if (Commands.Password.getMatcher(password.getText()) == null) {
            showPasswordErrors(password.getText());
            return;
        }
        if (Commands.Nickname.getMatcher(nickname.getText()) == null) {
            showAlert("Unacceptable nickname", "Check Your nickname", "Please enter a valid nickname");
            return;
        }
        if (Commands.EMAIL.getMatcher(email.getText()) == null) {
            showAlert("Unacceptable email", "Check Your email", "Please enter a valid email");
            return;
        }
        if (!password.getText().equals(passwordConfirmation.getText())) {
            showAlert("Error password", "Check Your confirmation password", "Your password does not match with confirmation password");
            password.setText("");
            showPassword.setText("");
            passwordConfirmation.setText("");
            return;
        }
        if (User.getUserByUsername(username.getText()) != null) {
            showAlert("Duplicate username", "This username is already registered", "Back to login Menu or set new username");
            changeUsername(username.getText());
            return;
        }

        User newUser = new User(username.getText(), password.getText(), email.getText(), nickname.getText());
        User.saveUsers();

        showAlert("Create account", "Account successfully created", "");

        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(ApplicationController.getStage());
    }

    private void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    private void changeUsername(String oldUsername) {
        String newUsername = oldUsername + createRandomNumber();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Change username");
        alert.setHeaderText("Your new Username is " + newUsername);
        alert.setContentText("Are you willing to do this?");
        alert.showAndWait();
        if (alert.getResult().getButtonData().isCancelButton()) return;
        username.setText(newUsername);
        helloText.setText("Hello " + username.getText());
    }

    private void showPasswordErrors(String password) {
        if (Commands.PasswordLength.getMatcher(password) == null) {
            showAlert("Unacceptable password", "Your password is too short and must contain at least 8 characters", "Please enter a strong password");
            return;
        }
        if (Commands.PasswordLowerCaseUsed.getMatcher(password) == null) {
            showAlert("Unacceptable password", "Your password must contain lowercase characters", "Please enter a strong password");
            return;
        }
        if (Commands.PasswordUpperCaseUsed.getMatcher(password) == null) {
            showAlert("Unacceptable password", "Your password must contain Uppercase characters", "Please enter a strong password");
            return;
        }
        if (Commands.PasswordNumberUsed.getMatcher(password) == null) {
            showAlert("Unacceptable password", "Your password must contain numbers", "Please enter a strong password");
            return;
        }
        if (Commands.PasswordSpecialCharacterUsed.getMatcher(password) == null) {
            showAlert("Unacceptable password", "Your password must contain special characters", "Please enter a strong password");
        }
    }

    public void generateRandomPassword() {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&";
        int passwordLength = 10;

        SecureRandom random = new SecureRandom();
        StringBuilder newPassword = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            newPassword.append(allowedCharacters.charAt(randomIndex));
        }

        if (Commands.Password.getMatcher(newPassword.toString()) != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Random password");
            alert.setHeaderText("Your password is " + newPassword);
            alert.setContentText("Do you want to choose this password?");
            alert.showAndWait();
            if (alert.getResult().getButtonData().isCancelButton()) return;
            password.setText(newPassword.toString());
            showPassword.setText(newPassword.toString());
        } else {
            generateRandomPassword();
        }
    }

    public void setPasswordImage() {
        String url = hideOrRevealPasswordImage.getImage().getUrl();
        if (url.contains("Hide")) {
            setPasswordShowImage("Images/RevealPassword.png");
            showPassword.setText(password.getText());
            showPassword.setVisible(true);
            password.setVisible(false);
        } else if (url.contains("Reveal")) {
            setPasswordShowImage("Images/HidePassword.png");
            password.setText(showPassword.getText());
            password.setVisible(true);
            showPassword.setVisible(false);
        }
    }

    public void backToLoginMenu() throws Exception {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(ApplicationController.getStage());
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public void setShowPassword(TextField showPassword) {
        this.showPassword = showPassword;
    }

    public void setPasswordConfirmation(PasswordField passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public void setNickname(TextField nickname) {
        this.nickname = nickname;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }
}
