package Sample;

import Sample.CardEnums.SpecialCard;
import Sample.Controller.RegisterController;
import Sample.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Server {
    // commands[1] = destination username | commands[2] = origin username
    public ArrayList<String> messageToSendClientsInQueue = new ArrayList<>();
    public static ArrayList<String> allUsersInJson = new ArrayList<>();
    private static Server instance;
    public static ArrayList<Client> clients = new ArrayList<>();

    public static HashMap<ServerThread, String> serverThreadStringHashMap = new HashMap<>();


    public static Server getInstance() {
        if (instance == null) instance = new Server();
        return instance;
    }


    private static RegisterController registerController;

    public static void main(String[] args) {
        User user = new User("alex", "123", "", "alexa021");
        User user2 = new User("ali", "123", "", "ali90");
        allUsersInJson.add(new Gson().toJson(user));
        allUsersInJson.add(new Gson().toJson(user2));
        registerController = RegisterController.getInstance();
        allUsersInJson.add(new Gson().toJson(new User("mmd", "Ali123!", "a@gmail.com", "reza")));
        int port = Client.port; // Port number the server will listen on
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                ServerThread serverThread = new ServerThread(socket);
//                serverThreadStringHashMap.put(serverThread, "");
                serverThread.start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public synchronized String handleCommand(String cmd) throws Exception {
        String[] commands = cmd.split("~");
        // notice : commands[0] command kari ke bayad anjam she ro moshakhas mikone az 1 be bad parametr.
// handel two duplicate connection
        System.out.println("commands[0]: " + commands[0]);
        switch (commands[0]) {
            case "getAllClientsJson": {
                return new Gson().toJson(clients);
            }

            case "uploadClientsOnServer": {
                Type type = new TypeToken<ArrayList<Client>>() {
                }.getType();
                ArrayList<Client> clients1 = new Gson().fromJson(commands[1], type);
                clients.clear();
                clients.addAll(clients1);
                return "done";
            }
            case "getAllUsersJson": {
                System.out.println("getAllUsersJson called");
                Type type = new TypeToken<ArrayList<String>>() {
                }.getType();
                return new Gson().toJson(allUsersInJson, type);
            }
            case "addNewUser": {
                System.out.println("addNewUser called");
                allUsersInJson.add(commands[1]);
                return "done";
            }
            case "UpdateUsersInServer": {
                System.out.println("UpdateUsersInServer called");
                allUsersInJson.clear();
                Type type = new TypeToken<ArrayList<String>>() {
                }.getType();
                allUsersInJson = new Gson().fromJson(commands[1], type);
                return "done";
            }
            case "sendArrayListCard": {
                Type type = new TypeToken<ArrayList<SpecialCard>>() {
                }.getType();
                ArrayList<SpecialCard> specialCards = new Gson().fromJson(commands[1], type);
                return "done";
            }
            case "sendFriendReq": { // i wanne be friend with cr7| so cr7= commands[1] and me=commands[2]
                User cr7 = User.getUserByUsername(commands[2]);
                User me = User.getUserByUsername(commands[1]);
                assert me != null;
                assert cr7 != null;
                sendFreindReq(cr7, me);
                return "done";
            }
            case "updateLastFriendReqFromServerForMe": {
                String userWhoWantsNewUpdateOfFriendReqsName = commands[1];
                for (String s : messageToSendClientsInQueue) {
                    String[] datas = s.split("~");
                    for (String data : datas) {
                        System.out.println("data: " + data);
                    }
                    if (datas[1].equals(userWhoWantsNewUpdateOfFriendReqsName)) {
                        String nameOfTheUserThatSentFriendReq = datas[2];
                        messageToSendClientsInQueue.remove(s);
                        System.out.println(s + " deleted");
                        return nameOfTheUserThatSentFriendReq;
                    }
                }
                return "No new Friend Req!";
            }
        }
        return "";
    }

    private void sendFreindReq(User me, User cr7) {
        String message = "sendFriendReq~" + cr7.getUsername() + "~" + me.getUsername();
        messageToSendClientsInQueue.add(message);

    }
}
