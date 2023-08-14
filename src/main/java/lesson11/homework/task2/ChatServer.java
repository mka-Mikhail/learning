package lesson11.homework.task2;

import lombok.Getter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer {
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.startServer();
    }

    private void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                ClientHandler client = new ClientHandler(this, socket);
                new Thread(client).start();
                clients.add(client);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendToAllMsg(String msg, ClientHandler sender) {
        for (ClientHandler c : clients) {
            if (sender != c) {
                c.sendMsg(msg);
            }
        }
    }
}

class ClientHandler implements Runnable {
    private ChatServer chatServer;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Клиент отправил сообщение: " + msg);
                chatServer.sendToAllMsg(msg, this);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMsg(String msg) {
        out.println(msg);
    }
}
