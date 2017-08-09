package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Input server port: ");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server started...");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Something wrong, Server socket closed.");
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Couldn't send the message");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null)
                System.out.println("New connection: " + socket.getRemoteSocketAddress());

            String userName = null;
            try (Connection connection = new Connection(socket)) {

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("There was an issue with data transfer to a remote address");
            }

            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            System.out.println("Remote connection has been closed");


        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME && !answer.getData().isEmpty()
                        && !connectionMap.containsKey(answer.getData())) {
                    connectionMap.put(answer.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return answer.getData();
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT,
                            userName + ": " + message.getData()));
                } else {
                    System.out.println("Current message is not of type TEXT");
                }
            }
        }
    }
}
