package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        Thread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            System.exit(1);
        }

        String readData;
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
            while (clientConnected) {
                readData = ConsoleHelper.readString();
                if (readData.equalsIgnoreCase("exit"))
                    break;
                else {
                    if (shouldSendTextFromConsole()) {
                        sendTextMessage(readData);
                    }
                }
            }
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Please enter IP address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Please enter port: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Please enter username: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Couldn't send message");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            String ip = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(ip, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("There has been an issue creating socket");
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST)
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else
                    throw new IOException("Unexpected MessageType");
            }

    }

    protected void clientMainLoop() throws IOException, ClassNotFoundException {
        while (!isInterrupted()) {
            Message message = connection.receive();
            if (message.getType() == MessageType.TEXT)
                processIncomingMessage(message.getData());
            else if (message.getType() == MessageType.USER_ADDED)
                informAboutAddingNewUser(message.getData());
            else if (message.getType() == MessageType.USER_REMOVED)
                informAboutDeletingNewUser(message.getData());
            else
                throw new IOException("Unexpected MessageType");
        }

}

    protected void processIncomingMessage(String message) {
        ConsoleHelper.writeMessage(message);
    }

    protected void informAboutAddingNewUser(String userName) {
        ConsoleHelper.writeMessage(userName + " has joined the chat!");
    }

    protected void informAboutDeletingNewUser(String userName) {
        ConsoleHelper.writeMessage(userName + " has left the chat!");
    }

    protected void notifyConnectionStatusChanged(boolean clientConnected) {
        Client.this.clientConnected = clientConnected;
        synchronized (Client.this) {
            Client.this.notify();
        }
    }
}
}
