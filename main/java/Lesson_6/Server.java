package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Server {
    private static ServerSocket serverSocket;
    private static Socket socket = null;
    private static final short PORT = 8998;
    private static Date timeNow;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server socket created");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    String serverMessage = sc.nextLine();
                    if (!serverMessage.trim().isEmpty()) {
                        try {
                            if (serverMessage.equalsIgnoreCase("/q")) {
                                out.writeUTF(getTime() + ": SERVER CLOSED Buy!");
                                System.out.println("server closed");
                                closeConnection(socket, out, in);
                                break;
                            }
                            out.writeUTF(getTime() + ": SERVER: " + serverMessage);
                        } catch (IOException e) {
                            //  e.printStackTrace();
                        }
                    }
                }
            }).start();

            while (true) {
                String massage = in.readUTF();
                if (massage.equalsIgnoreCase("/q")) {
                    System.out.println("Client disconnected");
                    closeConnection(socket, out, in);
                    break;
                }
                System.out.println(massage);
                out.writeUTF(getTime() + ": " + massage);
            }

        } catch (IOException ignored) {
        }

    }

    public static void closeConnection(Socket s, DataOutputStream out, DataInputStream in) {
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeNow = Calendar.getInstance().getTime();
        return timeFormat.format(timeNow);
    }
}
