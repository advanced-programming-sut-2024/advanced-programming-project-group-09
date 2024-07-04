package Sample.Network.Server.database;

import Sample.Network.Server.model.ServerUser;
import com.google.gson.*;

import java.io.*;
import java.util.Collection;

public class UserManager {
    public static void initialize() {
        File resourceDir = new File(Settings.DATABASE_PATH);
        if (!resourceDir.exists())
            resourceDir.mkdir();
        resourceDir = new File(Settings.USERS_PATH);
        if (!resourceDir.exists()) {
            try {
                new File(Settings.USERS_PATH).createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void load(Database database) {
        initialize();
        Reader reader;
        try {
            reader = new FileReader(Settings.USERS_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        if (jsonObject == null)
            return;
        JsonArray usersArray = jsonObject.getAsJsonArray("users");
        for (JsonElement element : usersArray)
            database.addUser(gson.fromJson(element, ServerUser.class));
    }

    public static void updateAllUsers(Collection<ServerUser> serverUsers) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject mainObject = new JsonObject();
        JsonArray usersArray = new JsonArray();
        for (ServerUser serverUser : serverUsers)
            usersArray.add(gson.toJsonTree(serverUser).getAsJsonObject());
        mainObject.add("serverUsers", usersArray);
        try {
            FileWriter fileWriter = new FileWriter(Settings.USERS_PATH);
            fileWriter.write(gson.toJson(mainObject));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
