package Sample.Controller;

import Sample.Enum.Commands;
import Sample.Model.User;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RegisterControllerTest {
    private RegisterController registerController;
    private TextField username;
    private PasswordField password;
    private TextField email;
    private TextField nickname;
    private TextField showPassword;
    private PasswordField passwordConfirmation;

    @Mock
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        registerController = new RegisterController();
        username = new TextField();
        password = new PasswordField();
        email = new TextField();
        nickname = new TextField();
        showPassword = new TextField();
        passwordConfirmation = new PasswordField();

        registerController.setUsername(username);
        registerController.setPassword(password);
        registerController.setEmail(email);
        registerController.setNickname(nickname);
        registerController.setShowPassword(showPassword);
        registerController.setPasswordConfirmation(passwordConfirmation);

        User.loadUsers();  // Assuming this method initializes some mock data
    }

    @Test
    public void testRegisterInvalidUsername() throws Exception {
        username.setText("invalidUser");
        password.setText("password");
        email.setText("test@test.com");
        nickname.setText("nickname");
        passwordConfirmation.setText("password");

        registerController.register();

        // Check that no user is created
        assertNull(User.getUserByUsername(username.getText()));
    }

    @Test
    public void testRegisterInvalidPassword() throws Exception {
        username.setText("validUsername");
        password.setText("short");
        email.setText("test@test.com");
        nickname.setText("nickname");
        passwordConfirmation.setText("short");

        registerController.register();

        // Check that no user is created
        assertNull(User.getUserByUsername(username.getText()));
    }

    @Test
    public void testRegisterPasswordsDoNotMatch() throws Exception {
        username.setText("validUsername");
        password.setText("password123");
        email.setText("test@test.com");
        nickname.setText("nickname");
        passwordConfirmation.setText("differentPassword");

        registerController.register();

        // Check that no user is created
        assertNull(User.getUserByUsername(username.getText()));
    }

    @Test
    public void testRegisterSuccess() throws Exception {
        username.setText("validUsername");
        password.setText("Password123!");
        email.setText("test@test.com");
        nickname.setText("nickname");
        passwordConfirmation.setText("Password123!");

        registerController.register();

        // Check that the user is created
        User createdUser = User.getUserByUsername(username.getText());
        assert createdUser != null;
        assertEquals("validUsername", createdUser.getUsername());
        assertEquals("Password123!", createdUser.getPassword());
        assertEquals("test@test.com", createdUser.getEmail());
        assertEquals("nickname", createdUser.getNickname());
    }

    @Test
    public void testGenerateRandomPassword() {
        registerController.generateRandomPassword();

        // Check that a random password is generated
        String generatedPassword = password.getText();
        assertEquals(generatedPassword, showPassword.getText());
        assertNotNull(Commands.Password.getMatcher(generatedPassword));
    }
}
