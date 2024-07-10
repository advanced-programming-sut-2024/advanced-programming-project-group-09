package Sample;

import Sample.Controller.RegisterController;
import Sample.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static ArrayList<String> allUsersInJson = new ArrayList<>();
    private static Server instance;

    public static Server getInstance() {
        if (instance == null) instance = new Server();
        return instance;
    }

    private static RegisterController registerController;

    public static void main(String[] args) {
        User user = new User("alex", "123", "", "");
        allUsersInJson.add(new Gson().toJson(user));
        registerController = RegisterController.getInstance();
        allUsersInJson.add(new Gson().toJson(new User("ali", "Ali123123!", "a@gmail.com", "reza")));
        allUsersInJson.add(new Gson().toJson(new User("mmd", "Ali123123!", "a@gmail.com", "reza")));
        int port = Client.port; // Port number the server will listen on
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public synchronized String handleCommand(String cmd) throws Exception {
        String[] commands = cmd.split("~");
        // TODO : commands[0] command kari ke bayad anjam she ro moshakhas mikone az 1 be bad parametr.
// handel two duplicate connection
        System.out.println(commands[0]);
        switch (commands[0]) {
            case "getAllUsersJson": {
                System.out.println("getAllUsersJson called");
                Type type = new TypeToken<ArrayList<String>>() {
                }.getType();
                return new Gson().toJson(allUsersInJson, type);
            }
            case "addNewUser": {
                System.out.println("addNewUser called");
                allUsersInJson.add(commands[1]);
                return "";
            }
            case "UpdateUsersInServer": {
                System.out.println("UpdateUsersInServer called");
                allUsersInJson.clear();
                Type type = new TypeToken<ArrayList<String>>() {
                }.getType();
                allUsersInJson = new Gson().fromJson(commands[1], type);
                return "";
            }
//            case "register":
//                // registerController.registerByNetwork(commands);
//                break;
//            case "login":
//                // Handle login
//                break;
        }
        return null;
    }
}
