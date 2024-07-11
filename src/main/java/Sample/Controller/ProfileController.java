package Sample.Controller;

import Sample.Enum.Commands;
import Sample.Model.GameBattleField;
import Sample.Model.User;
import Sample.View.MainMenu;
import Sample.View.RegisterMenu;
import Sample.View.ScoreBoardMenu;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Comparator;
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("change data");
            alert.setHeaderText("change account's info successfully!");
            alert.show();
            alert.setOnCloseRequest(dialogEvent -> {
                hideChangerFields();
            });
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
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("Check Your username");
            alert.setContentText("Please enter a valid username");
            alert.show();
            return true;
        }
        if (Commands.Password.getMatcher(newPasswordTextField.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unacceptable password");
            alert.setHeaderText("Check Your password");
            alert.setContentText("Please enter a strong password");
            alert.show();
            return true;
        }
        if (!newPasswordTextField.getText().equals(newPasswordConfirmationTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error password");
            alert.setHeaderText("Check Your confirmation password");
            alert.setContentText("Your password does not match with confirmation password");
            alert.showAndWait();
            newPasswordTextField.setText("");
            newPasswordConfirmationTextField.setText("");
            return true;
        }
        if (Commands.Nickname.getMatcher(newNicknameTextField.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unacceptable nickname");
            alert.setHeaderText("Check Your nickname");
            alert.setContentText("Please enter a valid nickname");
            alert.show();
            return true;
        }
        if (Commands.EMAIL.getMatcher(newEmailTextField.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Unacceptable email");
            alert.setHeaderText("Check Your email");
            alert.setContentText("Please enter a valid email");
            alert.show();
            return true;
        }
        if (newPasswordTextField.getText().equals(User.getUserLoginIn().getPassword())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error password");
            alert.setContentText("You've already used this password use new pass!");
            alert.show();
            newPasswordTextField.setText("");
            newPasswordConfirmationTextField.setText("");
            return true;
        }
        if (newEmailTextField.getText().equals(User.getUserLoginIn().getEmail())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Email");
            alert.setContentText("You've already used this Email use new Email!");
            alert.show();
            newEmailTextField.setText("");
            return true;
        }
        if (newNicknameTextField.getText().equals(User.getUserLoginIn().getNickname())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Nickname");
            alert.setContentText("You've already used this Nickname use new Nickname!");
            alert.show();
            newNicknameTextField.setText("");
            return true;
        }

        if (User.getUserByUsername(newUsernameTextField.getText()) != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate username");
            alert.setHeaderText("This username is already registered");
            alert.setContentText("Back to login Menu or set new username");
            alert.showAndWait();
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

    public static void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void showGameHistory1(ActionEvent event) {
        StringBuilder massage = new StringBuilder();
        User user = User.getUserLoginIn();
        GameBattleField gameBattleField = user.getAllGameBattleField().get(0);
        boolean isWinner = false;
        if (gameBattleField.getUser1().getUsername().equals(user.getUsername())) {
            if (gameBattleField.getHealthUser1() > gameBattleField.getHealthUser2()) isWinner = true;
            if (gameBattleField.getHealthUser2() < 0) isWinner = true;
            String Health = String.valueOf(gameBattleField.getHealthUser1());
            String isWinnerString = "WON";
            if (!isWinner) isWinnerString = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinnerString + " the game number " + 1 + "with health: " + Health + "\n");
        } else {
            if (gameBattleField.getHealthUser2() > gameBattleField.getHealthUser1()) isWinner = true;
            if (gameBattleField.getHealthUser1() < 0) isWinner = true;
            String Health = String.valueOf(gameBattleField.getHealthUser2());
            String isWinnerString = "WON";
            if (!isWinner) isWinnerString = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinnerString + " the game number " + 1 + "with health: " + Health + "\n");

        }
        showAlert("history", "game history info", massage.toString());
    }

    public void showGameHistory2(ActionEvent event) {

        StringBuilder massage = new StringBuilder();
        User user = User.getUserLoginIn();


        GameBattleField gameBattleField = user.getAllGameBattleField().get(0);
        boolean isWinner = false;
        if (gameBattleField.getUser1().getUsername().equals(user.getUsername())) {
            if (gameBattleField.getHealthUser1() > gameBattleField.getHealthUser2()) isWinner = true;
            if (gameBattleField.getHealthUser2() < 0) isWinner = true;
            String Health = String.valueOf(gameBattleField.getHealthUser1());
            String isWinnerString = "WON";
            if (!isWinner) isWinnerString = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinnerString + " the game number " + 1 + "with health: " + Health + "\n");
        } else {
            if (gameBattleField.getHealthUser2() > gameBattleField.getHealthUser1()) isWinner = true;
            if (gameBattleField.getHealthUser1() < 0) isWinner = true;
            String Health = String.valueOf(gameBattleField.getHealthUser2());
            String isWinnerString = "WON";
            if (!isWinner) isWinnerString = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinnerString + " the game number " + 1 + "with health: " + Health + "\n");
        }
        GameBattleField gameBattleField2 = user.getAllGameBattleField().get(0);
        boolean isWinner2 = false;
        if (gameBattleField2.getUser1().getUsername().equals(user.getUsername())) {
            if (gameBattleField2.getHealthUser1() > gameBattleField2.getHealthUser2()) isWinner2 = true;
            if (gameBattleField2.getHealthUser2() < 0) isWinner2 = true;
            String Health = String.valueOf(gameBattleField2.getHealthUser1());
            String isWinner2String = "WON";
            if (!isWinner2) isWinner2String = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinner2String + " the game number " + 1 + "with health: " + Health + "\n");
        } else {
            if (gameBattleField2.getHealthUser2() > gameBattleField2.getHealthUser1()) isWinner2 = true;
            if (gameBattleField2.getHealthUser1() < 0) isWinner2 = true;
            String Health = String.valueOf(gameBattleField2.getHealthUser2());
            String isWinner2String = "WON";
            if (!isWinner2) isWinner2String = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinner2String + " the game number " + 1 + "with health: " + Health + "\n");
        }
        showAlert("history", "game history info", massage.toString());

    }

    public void showGameHistory3(ActionEvent event) {
        StringBuilder massage = new StringBuilder();
        User user = User.getUserLoginIn();


        GameBattleField gameBattleField = user.getAllGameBattleField().get(0);
        boolean isWinner = false;
        if (gameBattleField.getUser1().getUsername().equals(user.getUsername())) {
            if (gameBattleField.getHealthUser1() > gameBattleField.getHealthUser2()) isWinner = true;
            if (gameBattleField.getHealthUser2() < 0) isWinner = true;
            String Health = String.valueOf(gameBattleField.getHealthUser1());
            String isWinnerString = "WON";
            if (!isWinner) isWinnerString = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinnerString + " the game number " + 1 + "with health: " + Health + "\n");
        } else {
            if (gameBattleField.getHealthUser2() > gameBattleField.getHealthUser1()) isWinner = true;
            if (gameBattleField.getHealthUser1() < 0) isWinner = true;
            String Health = String.valueOf(gameBattleField.getHealthUser2());
            String isWinnerString = "WON";
            if (!isWinner) isWinnerString = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinnerString + " the game number " + 1 + "with health: " + Health + "\n");
        }
        GameBattleField gameBattleField2 = user.getAllGameBattleField().get(0);
        boolean isWinner2 = false;
        if (gameBattleField2.getUser1().getUsername().equals(user.getUsername())) {
            if (gameBattleField2.getHealthUser1() > gameBattleField2.getHealthUser2()) isWinner2 = true;
            if (gameBattleField2.getHealthUser2() < 0) isWinner2 = true;
            String Health = String.valueOf(gameBattleField2.getHealthUser1());
            String isWinner2String = "WON";
            if (!isWinner2) isWinner2String = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinner2String + " the game number " + 1 + "with health: " + Health + "\n");
        } else {
            if (gameBattleField2.getHealthUser2() > gameBattleField2.getHealthUser1()) isWinner2 = true;
            if (gameBattleField2.getHealthUser1() < 0) isWinner2 = true;
            String Health = String.valueOf(gameBattleField2.getHealthUser2());
            String isWinner2String = "WON";
            if (!isWinner2) isWinner2String = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinner2String + " the game number " + 1 + "with health: " + Health + "\n");
        }
        GameBattleField gameBattleField3 = user.getAllGameBattleField().get(0);
        boolean isWinner3 = false;
        if (gameBattleField3.getUser1().getUsername().equals(user.getUsername())) {
            if (gameBattleField3.getHealthUser1() > gameBattleField3.getHealthUser2()) isWinner3 = true;
            if (gameBattleField3.getHealthUser2() < 0) isWinner3 = true;
            String Health = String.valueOf(gameBattleField3.getHealthUser1());
            String isWinner3String = "WON";
            if (!isWinner3) isWinner3String = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinner3String + " the game number " + 1 + "with health: " + Health + "\n");
        } else {
            if (gameBattleField3.getHealthUser2() > gameBattleField3.getHealthUser1()) isWinner3 = true;
            if (gameBattleField3.getHealthUser1() < 0) isWinner3 = true;
            String Health = String.valueOf(gameBattleField3.getHealthUser2());
            String isWinner3String = "WON";
            if (!isWinner3) isWinner3String = "Lost";
            massage.append("user with name: " + user.getUsername() + " " + isWinner3String + " the game number " + 1 + "with health: " + Health + "\n");
        }
        showAlert("history", "game history info", massage.toString());
    }

    public void showGameHistory4(ActionEvent event) {
        showGameHistory3(null);
    }

    public void showGameHistory5(ActionEvent event) {
        showGameHistory3(null);
    }

    public void goToScoreboard(MouseEvent mouseEvent) {
        ScoreBoardMenu scoreboardMenu = new ScoreBoardMenu();
        try {
            scoreboardMenu.start(ApplicationController.getStage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ranking(MouseEvent mouseEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        User.getUsers().sort(Comparator.comparing(User::getMaxScore));
        for (User user : User.getUsers()) {
            stringBuilder.append(user.getUsername() + "with score : " + user.getMaxScore());
        }
        showAlert("rank", "ranking", stringBuilder.toString());
    }
}
