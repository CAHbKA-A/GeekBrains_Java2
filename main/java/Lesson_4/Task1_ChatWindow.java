package Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Task1_ChatWindow extends JFrame {

    public static void main(String[] args) {
        Task1_ChatWindow frame = new Task1_ChatWindow();

        //setVisible  и так в самом конце находится. в конце метода майн, после создания окна
        frame.setVisible(true);
    }



    public Task1_ChatWindow() {

        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 600);
        setAlwaysOnTop(true);




        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextArea chat = new JTextArea();
        chat.setText("Say Hello");
        chat.setToolTipText("Окно чата");
        panel.add(chat, BorderLayout.CENTER);
        chat.setEditable(false);


        JScrollPane scrollPane = new JScrollPane(chat, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 57, 946, 406);
        panel.add(scrollPane);


        JTextField nameFieldText = new JTextField();
        nameFieldText.setText("Enter your name");
        panel.add(nameFieldText, BorderLayout.NORTH);

        //вторая падель для поля и кнопки
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JTextField sayFieldText = new JTextField();
        sayFieldText.setText("text");
        panel2.add(sayFieldText, BorderLayout.CENTER);


        JButton button1 = new JButton("send");
        panel2.add(button1, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.SOUTH);


        //TODO TimeDateStamp

        // событие на нажатие enter

        sayFieldText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            // событие на нажатие кнопки
            @Override
            public void keyPressed(KeyEvent e) {
                //TODO вынести в функцию
                StringBuilder sb = new StringBuilder();
                if ((e.getKeyCode() == 10) && (!sayFieldText.getText().equals(""))) {
                    sb.append(chat.getText())
                            .append(" \n " + nameFieldText.getText() + ":")
                            .append(sayFieldText.getText());
                    sayFieldText.setText("");
                    chat.setText(sb.toString());
                    sayFieldText.setText("");
                }
            }


            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        button1.addActionListener(arg0 -> {
            //TODO вынести в функцию
            StringBuilder sb = new StringBuilder();
            if (!sayFieldText.getText().equals("")) {
                sb.append(chat.getText())
                        .append(" \n ").append(nameFieldText.getText()).append(":")
                        .append(sayFieldText.getText());
                sayFieldText.setText("");
                chat.setText(sb.toString());
                sayFieldText.setText("");
            }
        });


        add(panel);


    }


}
