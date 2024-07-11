package Sample.database;

import Sample.Model.Chat;
import Sample.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

public class ChatManager {
    public static void load() {
        initializeChatFolder();
    }

    public static void initializeChatFolder() {
        File resourceDir = new File(Settings.CHAT_PATH);
        if (!resourceDir.exists()) resourceDir.mkdir();
        resourceDir = new File(Settings.GLOBAL_CHAT_PATH);
        if (!resourceDir.exists()) {
            try {
                new File(Settings.GLOBAL_CHAT_PATH).createNewFile();
                Gson gson = new GsonBuilder().serializeNulls().create();
                JsonObject mainObject = gson.toJsonTree(createGlobalChat()).getAsJsonObject();
                FileWriter fileWriter = new FileWriter(Settings.GLOBAL_CHAT_PATH);
                fileWriter.write(gson.toJson(mainObject));
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void updateChat(Chat chat) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject mainObject = gson.toJsonTree(chat).getAsJsonObject();
        try {
            String chatPath = Settings.GLOBAL_CHAT_PATH;
            File file = new File(chatPath);
            if (!file.exists()) file.createNewFile();
            FileWriter fileWriter = new FileWriter(chatPath);
            fileWriter.write(gson.toJson(mainObject));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Chat loadChat(String chatId) {
        String chatPath = Settings.GLOBAL_CHAT_PATH;
        Reader reader;
        try {
            reader = new FileReader(chatPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        if (jsonObject == null) return null;
        return gson.fromJson(jsonObject, Chat.class);
    }

    public static Chat createGlobalChat() {
        Collection<User> users = Database.getInstance().getUsers();
        ArrayList<String> chatParticipants = new ArrayList<>();
        for (User user : users) {
            chatParticipants.add(user.getUsername());
        }
        return new Chat("global", chatParticipants, "");
    }

    public static void notifyAllMembers(Chat chat) throws IOException {
        for (User user : Database.getInstance().getOnlineUsers()) {
            if (chat.getUsers().contains(user.getUsername())) {
                Socket socket = user.getSocket();
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                String output = new Gson().toJson(chat);
                dataOutputStream.writeUTF("chat_updated:" + output);
            }
        }
    }
}
