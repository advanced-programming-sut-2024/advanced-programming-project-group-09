package Sample;

import java.io.*;
import java.net.*;

public class Client {
    public static int port = 1000;

//    public static void main(String[] args) {
//        Client client = new Client();
//        client.tryToConnectToServer("salam man erfanam");
//    }

    public String tryToConnectToServer(String cmd) {
        String response = "";
        try (Socket socket = new Socket("127.0.0.1", port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            writer.println(cmd);

            response = reader.readLine();
            System.out.println( response);
//            handleResponseForClient(response);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
        return response;
    }

    private void handleResponseForClient(String response) {
        // Handling response from server
    }


}