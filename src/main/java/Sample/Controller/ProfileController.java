package Sample.Controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.util.regex.Matcher;

public class ProfileController {
    private static ProfileController controller;

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

    public void changeUsername(MouseEvent mouseEvent) {

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
    }

    public void showData(MouseEvent mouseEvent) {
    }

    public void goToAvatarMenu(MouseEvent mouseEvent) {
    }

    public void deleteAccount(MouseEvent mouseEvent) {
    }

    public void goToHelloMenu(MouseEvent mouseEvent) {
    }

    public void changeUserPass(MouseEvent mouseEvent) {
    }

    public void applyForChangingData(MouseEvent mouseEvent) {
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
}
