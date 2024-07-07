package Sample.Network.Client.controller.UserAndGameControllers;

import Sample.Network.Client.model.Gwent;
import Sample.Network.Client.model.User.User;
import Sample.Enum.Commands;
import Sample.View.MainMenu;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class ProfileController {
    private static ProfileController controller;
    public TextField newUsernameTextField;
    public TextField newPasswordTextField;
    public TextField newNicknameTextField;
    public TextField newEmailTextField;
    public Button doneButton;
    public TextField newPasswordConfirmationTextField;

    public static ProfileController getInstance() {
        if (controller == null) {
            controller = new ProfileController();
        }
        return controller;
    }

    public void enterMenu(MouseEvent mouseEvent) {

    }

    public void exitMenu(MouseEvent mouseEvent) {

    }

    public void showCurrentMenu(MouseEvent mouseEvent) {
    }


    public void changeNickName(MouseEvent mouseEvent) {

    }

    public void changeEmail(MouseEvent mouseEvent) {

    }

    public void changePassword(MouseEvent mouseEvent) {

    }

    public void displayUserInfo() {
        // Display user's current information

    }

    public void displayGameHistory(MouseEvent mouseEvent) {
        // Validate number and display last n games

    }

    public void goToMainMenu(MouseEvent mouseEvent) {
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void showData(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String message = "";
        User currentUser = User.getUserLoginIn();
        message += "username : " + currentUser.getUsername();
        message += "\nnickname : " + currentUser.getNickname();
        message += "\nmaxScore : " + currentUser.getMaxScore();
        message += "\nrank : " + currentUser.getRank();
        message += "\ngames Played : " + currentUser.getGamesPlayed();
        message += "\nwins : " + currentUser.getLoses();
        message += "\nloses : " + currentUser.getWins();
        message += "\ndraws : " + currentUser.getDraws();
        alert.setTitle("user info");
        alert.setContentText(message);
        alert.show();
    }

    public void goToAvatarMenu(MouseEvent mouseEvent) {
    }


    public void goToHelloMenu(MouseEvent mouseEvent) {
    }

    public void changeUserPass(MouseEvent mouseEvent) {
        emptyChangerFields();
        if (doneButton.isVisible()) {
            hideChangerFields();
            return;
        }

        doneButton.setVisible(true);
        newEmailTextField.setVisible(true);
        newNicknameTextField.setVisible(true);
        newUsernameTextField.setVisible(true);
        newPasswordTextField.setVisible(true);
        newPasswordConfirmationTextField.setVisible(true);

        doneButton.setOnMouseClicked(mouseEvent1 -> {
            if (checkNewDataInValidation()) return;
            User.getUserLoginIn().setPassword(newPasswordTextField.getText());
            User.getUserLoginIn().setEmail(newEmailTextField.getText());
            User.getUserLoginIn().setNickname(newNicknameTextField.getText());
            User.getUserLoginIn().setUsername(newUsernameTextField.getText());
            showAlert("change data", "change account's info successfully!", "");
            hideChangerFields();
        });
    }

    private void emptyChangerFields() {
        newUsernameTextField.setText("");
        newNicknameTextField.setText("");
        newEmailTextField.setText("");
        newPasswordConfirmationTextField.setText("");
        newPasswordTextField.setText("");
    }

    private void hideChangerFields() {
        doneButton.setVisible(false);
        newEmailTextField.setVisible(false);
        newNicknameTextField.setVisible(false);
        newUsernameTextField.setVisible(false);
        newPasswordTextField.setVisible(false);
        newPasswordConfirmationTextField.setVisible(false);
    }

    private boolean checkNewDataInValidation() {
        if (Commands.UserName.getMatcher(newUsernameTextField.getText()) == null) {
            showAlert("Invalid username", "Check Your username", "Please enter a valid username");
            return true;
        }
        if (Commands.Password.getMatcher(newPasswordTextField.getText()) == null) {
            showAlert("Unacceptable password", "Check Your password", "Please enter a strong password");
            return true;
        }
        if (!newPasswordTextField.getText().equals(newPasswordConfirmationTextField.getText())) {
            showAlert("Error password", "Check Your confirmation password", "Your password does not match with confirmation password");
            newPasswordTextField.setText("");
            newPasswordConfirmationTextField.setText("");
            return true;
        }
        if (Commands.Nickname.getMatcher(newNicknameTextField.getText()) == null) {
            showAlert("Unacceptable nickname", "Check Your nickname", "Please enter a valid nickname");
            return true;
        }
        if (Commands.EMAIL.getMatcher(newEmailTextField.getText()) == null) {
            showAlert("Unacceptable email", "Check Your email", "Please enter a valid email");
            return true;
        }
        if (newPasswordTextField.getText().equals(User.getUserLoginIn().getPassword())) {
            showAlert("Error password", "You've already used this password use new pass!", "");
            newPasswordTextField.setText("");
            newPasswordConfirmationTextField.setText("");
            return true;
        }
        if (newEmailTextField.getText().equals(User.getUserLoginIn().getEmail())) {
            showAlert("Error Email", "You've already used this Email use new Email!", "");
            newEmailTextField.setText("");
            return true;
        }
        if (newNicknameTextField.getText().equals(User.getUserLoginIn().getNickname())) {
            showAlert("Error Nickname", "You've already used this Nickname use new Nickname!", "");
            newNicknameTextField.setText("");
            return true;
        }

        if (Gwent.getInstance().userExists(newUsernameTextField.getText())) {
            showAlert("Duplicate username", "This username is already registered", "Back to login Menu or set new username");
            changeUsername(newUsernameTextField.getText()); // Suggest new username
            return true;
        }
        return false;
    }

    private int createRandomNumber() {
        int min = 0;
        int max = 10000;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private void changeUsername(String oldUsername) {
        String newUsername = oldUsername + createRandomNumber();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Change username");
        alert.setHeaderText("I suggest new username for you: " + newUsername);
        alert.setContentText("Are you willing to do this?");
        alert.showAndWait();
        if (alert.getResult().getButtonData().isCancelButton()) return;
        newUsernameTextField.setText(newUsername);
    }

    public void confirmChangingData(MouseEvent mouseEvent) {
    }

    public void showGameHistory(ActionEvent event) {
    }

    public void showGameHistory1(ActionEvent event) {
    }

    public void showGameHistory2(ActionEvent event) {
    }

    public void showGameHistory3(ActionEvent event) {
    }

    public void showGameHistory4(ActionEvent event) {
    }

    public void showGameHistory5(ActionEvent event) {
    }

    private void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
