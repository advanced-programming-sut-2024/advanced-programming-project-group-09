package Sample.Network.Client.model.User;

import Sample.Model.User;
import Sample.Network.Client.Connection;
import Sample.Network.Client.Request;
import Sample.Network.Client.utils.Pair;
import com.google.gson.Gson;
import Sample.Network.Client.utils.PasswordConverter;
import java.util.HashMap;

public class ClientUser extends User {
    private Pair passwordRecovery;

    public ClientUser(String username, String password, String email, String nickname) {
        super(username, password, email, nickname);
        setPassword(password);
    }

    @Override
    public void setPassword(String newPass) {
        super.setPassword(PasswordConverter.encodePassword(newPass));
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("setPassword");
        request.addParameter("username", getUsername());
        request.addParameter("password", getPassword());
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("ServerUser doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getPasswordRecoveryQuestion() {
        return passwordRecovery.x;
    }

    public boolean isRecoveryPasswordCorrect(String recoveryAnswer) {
        return passwordRecovery.y.equals(recoveryAnswer);
    }

    public void changeUsername(String username) {
        super.setUsername(username);
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("username");
        request.addParameter("username", getUsername());
        request.addParameter("new_username", username);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("ServerUser doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void changeNickname(String nickname) {
        super.setNickname(nickname);
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("nickname");
        request.addParameter("username", getUsername());
        request.addParameter("nickname", nickname);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("ServerUser doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void changeEmail(String email) {
        super.setEmail(email);
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("email");
        request.addParameter("username", getUsername());
        request.addParameter("email", email);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("ServerUser doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setPasswordRecovery(Pair passwordRecovery) {
        this.passwordRecovery = passwordRecovery;
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("password_recovery");
        request.addParameter("username", getUsername());
        request.addParameter("recovery", new Gson().toJson(passwordRecovery));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("ServerUser doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void setAvatarPath(String avatarPath) {
        super.setAvatarPath(avatarPath);
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("set_avatar");
        request.addParameter("username", getUsername());
        request.addParameter("avatar_path", avatarPath);
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("ServerUser doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getHighScore() {
        return (int) getMaxScore();
    }

    public void setHighScore(int highScore) {
        setMaxScore(highScore);
        Request request = new Request();
        request.setType("user_change");
        request.setCommand("highscore");
        request.addParameter("username", getUsername());
        request.addParameter("highscore", String.valueOf(highScore));
        String result = Connection.getInstance().sendRequest(request);
        if (result.startsWith("400")) {
            try {
                throw new Exception("ServerUser doesn't exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

/*    public void updateLists() {
        ClientUser user = (ClientUser) Stronghold.getInstance().getUser(getUsername());
        setFriends(user.getFriends());
        setSenders(user.getSenders());
    }
*/
}
