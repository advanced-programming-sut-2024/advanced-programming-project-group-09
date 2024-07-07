package Sample.Network.Client.controller.ChatControllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Sample.Network.Client.model.User.User;
import Sample.Network.Client.model.chatRoom.Chat;
import Sample.Network.Client.model.chatRoom.Message;
import Sample.Network.Client.Connection;
import Sample.Network.Client.Request;
import Sample.Network.Client.view.ChatMenus.MainChatMenuController;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ChatController {
    private Chat currentChat;
    private final User currentUser;
    public ChatController(User currentUser){
        this.currentUser = currentUser;
    }
    public static MainChatMenuController currentMenu;

    public void setCurrentChat(Chat chat) {
        currentChat = chat;
    }

    public Chat getCurrentChat() {
        return currentChat;
    }

    public void addMessage(Message msg){
        currentChat.addMessage(msg);
    }

    public String getCurrentUsername() {
        return currentUser.getUsername();
    }

    public Chat getGlobalChat() {
        Request request = new Request();
        request.setType("chat");
        request.setCommand("get_global_chat");
        String in = Connection.getInstance().sendRequest(request);
        return new Gson().fromJson(in, Chat.class);
    }

    public ArrayList<Chat> loadRoomChats(){
        Request request = new Request();
        request.setType("chat");
        request.setCommand("get_room_chats");
        return getChats(request);
    }
    public ArrayList<Chat> loadPrivateChats(){
        Request request = new Request();
        request.setType("chat");
        request.setCommand("get_private_chats");
        return getChats(request);
    }

    private ArrayList<Chat> getChats(Request request) {
        String result = Connection.getInstance().sendRequest(request);
        Type arrayListType = new TypeToken<ArrayList<Chat>>() {
        }.getType();
        return new Gson().fromJson(result, arrayListType);
    }
}
