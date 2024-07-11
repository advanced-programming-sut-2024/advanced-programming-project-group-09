package Sample.Controller;

import Sample.View.LoginMenu;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecurityQuestionController {
    @FXML
    private TextField question1;
    @FXML
    private TextField question2;
    @FXML
    private TextField question3;


    public void goToLoginMenu() throws Exception {
        if (question1.getText().isEmpty() && question3.getText().isEmpty() && question2.getText().isEmpty()) {
            LoginController.showAlert("Security error", "You should answer one security question at least", "");
            return;
        }
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(ApplicationController.getStage());
    }
}
