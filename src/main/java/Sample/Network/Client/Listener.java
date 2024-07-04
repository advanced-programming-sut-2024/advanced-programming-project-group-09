package Sample.Network.Client;

import com.google.gson.Gson;
import javafx.application.Platform;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Sample.Network.Client.controller.ChatControllers.ChatController;
import Sample.Network.Client.model.chatRoom.Chat;
import Sample.Network.Client.view.ChatMenus.MainChatMenuController;

public class Listener extends Thread {
    private final DataInputStream dataInputStream;
    private static final LinkedBlockingQueue<String> lastContent = new LinkedBlockingQueue<>();

    private enum InputRegex {
        CHAT_UPDATE("chat_updated:(?<request>.+)");
        private final String regex;

        InputRegex(String regex) {
            this.regex = regex;
        }

        public static InputRegex getRegex(String data) {
            for (InputRegex inputRegex : InputRegex.values()) {
                if (data.matches(inputRegex.regex)) return inputRegex;
            }
            return null;
        }
    }

    public Listener(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                String data = dataInputStream.readUTF();
                InputRegex input = InputRegex.getRegex(data);
                if (input == null) {
                    lastContent.put(data);
                    continue;
                }
                switch (input) {
                    case CHAT_UPDATE:
                        chatUpdate(data);
                        break;
                }
            }
        } catch (SocketException socketException) {
            return;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void chatUpdate(String input) {
        Pattern pattern = Pattern.compile(InputRegex.CHAT_UPDATE.regex);
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        String requestStr = matcher.group("request");
        Chat chat = new Gson().fromJson(requestStr, Chat.class);
        if (ChatController.currentMenu != null) {
            MainChatMenuController menu = ChatController.currentMenu;
            if (menu.getController().getCurrentChat().getChatId().equals(chat.getChatId())) {
                Platform.runLater(() -> {
                    try {
                        menu.loadChat(chat);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }

    public static String consumeLastInput() throws InterruptedException {
        return lastContent.take();
    }
}
