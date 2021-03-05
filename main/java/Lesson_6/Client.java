package Lesson_6;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame {

    private static Socket socket;
    private static final String URL_SERVER = "localhost";
    private static final int PORT = 8998;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static JTextArea chat = new JTextArea();
    private static JTextField sayFieldText = new JTextField();
    private static JTextField nameFieldText = new JTextField();


    public static void main(String[] args) {


        Client frame = new Client();

        //setVisible  и так в самом конце находится. в конце метода майн, после создания окна
        frame.setVisible(true);
        try {
            connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void connection() throws IOException {

        while (true) {
            try {
                socket = new Socket(URL_SERVER, PORT);
                if (socket.isConnected()) {
                    chat.append("Server connected \n");
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            } catch (IOException io) {
                chat.append("Can not connected \n");
            }


        }
        chat.setText("Connected! Say Hello \n");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                while (true) {
                    String serverMess = in.readUTF();
                    if (serverMess.equals("/q")) {
                        closeConnection();
                        chat.append(" Connection closed. \n");
                        break;
                    }
                    chat.append(serverMess + "\n");
                }
            } catch (IOException ignored) {

            }
        }).start();
    }

    private void sendMessage() {
        if (!sayFieldText.getText().trim().isEmpty()) {
            try {
                String messageText = sayFieldText.getText();
                out.writeUTF(messageText);
                // out.writeUTF(nameFieldText.getText() + ": " + messageText);
                sayFieldText.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void closeConnection() {
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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Client() {

        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 600);
        setAlwaysOnTop(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        chat.setToolTipText("Окно чата");
        panel.add(chat, BorderLayout.CENTER);
        chat.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chat, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 57, 946, 406);
        panel.add(scrollPane);

        nameFieldText.setText("Name");
        panel.add(nameFieldText, BorderLayout.NORTH);

        //вторая панель для поля и кнопки
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        sayFieldText.setText("text");
        panel2.add(sayFieldText, BorderLayout.CENTER);

        JButton button1 = new JButton("send");
        panel2.add(button1, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.SOUTH);


        sayFieldText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            // событие на нажатие enter
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == 10) {
                    sendMessage();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        button1.addActionListener(arg0 -> sendMessage());

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {

                    out.writeUTF("Client closed chat window");

                } catch (IOException exception) {
                    //exception.printStackTrace();
                } finally {
                    closeConnection();
                }

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        add(panel);
    }
}
