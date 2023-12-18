package ait.chat;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client accepted" + (++count));
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();
            Thread.sleep(3000);
            String response = "#" + count + ", your message lenght is " + request.length() + "\n";

            writer.write(response);
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();

        }
    }
}
