package Sample.Controller;

import Sample.Model.User;
import Sample.View.MainMenu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.testfx.framework.junit5.ApplicationTest;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.any;
import static org.mockito.Mockito.doNothing;

public class LoginControllerTest {

    private LoginController loginController;
    private TextField username;
    private PasswordField password;

    @Mock
    private MainMenu mainMenu;

    @BeforeEach
    public void setUp() {
        loginController = new LoginController();
        username = new TextField();
        password = new PasswordField();
        loginController.setUsername(username);
        loginController.setPassword(password);
        loginController.initialize();
    }

    @Test
    public void testSignInInvalidUsername() throws Exception {
        username.setText("invalidUser");
        password.setText("password");

        loginController.signIn();

        // Check that no user is logged in
        Assertions.assertNull(User.getUserLoginIn());
        // Optionally check for the alert message
    }

    @Test
    public void testSignInInvalidPassword() throws Exception {
        User user = new User("testUser", "password123", "erfan@yahoo.com", "erfan");

        username.setText("testUser");
        password.setText("wrongPassword");

        loginController.signIn();

        // Check that no user is logged in
        Assertions.assertNull(User.getUserLoginIn());
        // Optionally check for the alert message
    }

    @Test
    public void testSignInSuccess() throws Exception {
        User user = new User("testUser", "password123", "erfan@yahoo.com", "erfan");

        username.setText("testUser");
        password.setText("password123");

        // Mock MainMenu start method to prevent actual GUI initialization
        doNothing().when(mainMenu).start((Stage) any());

        loginController.signIn();

        // Check that the correct user is logged in
        Assertions.assertEquals(user, User.getUserLoginIn());
    }
}