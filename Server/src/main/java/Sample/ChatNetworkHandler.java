package Sample;

import Sample.Model.Chat;
import Sample.Model.Message;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatNetworkHandler {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 2000;

    public ChatNetworkHandler() {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String chatId, Message message) {
        String jsonMessage = new Gson().toJson(message);
        out.println("sendMessage~" + chatId + "~" + jsonMessage);
    }

    public Chat receiveChatUpdate() {
        try {
            String response = in.readLine();
            return new Gson().fromJson(response, Chat.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}