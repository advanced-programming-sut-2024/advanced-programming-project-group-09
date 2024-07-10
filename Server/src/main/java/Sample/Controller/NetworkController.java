package Sample.Controller;

import Sample.Client;
import Sample.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class NetworkController {
    static Timeline timeline;

    public static void createTimeLineForUpdateUsers() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(15), event -> {
            updateUsersFromServer();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public synchronized static void updateUsersFromServer() {
        String allUsersJson = getAllUsersInJson();
        System.out.println("all users json:" + allUsersJson);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        ArrayList<String> usersInJson = new Gson().fromJson(allUsersJson, type);
        User.getUsers().clear();
        for (String string : usersInJson) {
            User user = new Gson().fromJson(string, User.class);
            User.getUsers().add(user);
            System.out.println(user.getUsername());
        }
        System.out.println(usersInJson);

    }

    public static String getAllUsersInJson() {
        Client client = new Client();
        return client.tryToConnectToServer("getAllUsersJson");
    }
}
