package dev.thoq.lib.gui;

import dev.thoq.lib.Colors;
import dev.thoq.lib.Screen;
import dev.thoq.lib.gui.processor.InputProcessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static java.lang.System.err;

public class Builder {
    public static JTextArea outputArea;
    public static JTextField inputField;
    public static JFrame window = new JFrame("M: Calculator");

    public static void BuildGUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 900);
        window.setLayout(new BorderLayout());
        window.getContentPane().setBackground(Colors.getBackgroundColor());

        try {
            URI iconUri = new URI("https://i.imgur.com/2RAnqlV.png");
            URL iconUrl = iconUri.toURL();
            ImageIcon icon = new ImageIcon(iconUrl);
            window.setIconImage(icon.getImage());
        } catch (URISyntaxException e) {
            err.println("Invalid URI: " + e.getMessage());
            Screen.println("Invalid URI: " + e.getMessage());
        } catch (IOException e) {
            err.println("Error loading icon: " + e.getMessage());
            Screen.println("Error loading icon: " + e.getMessage());
        }

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.BOLD, 24));
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Colors.getForegroundColor());
        outputArea.setCaretColor(Colors.getForegroundColor());

        JScrollPane scrollPane = new JScrollPane(outputArea);

        inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.BOLD, 24));
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(Colors.getForegroundColor());
        inputField.setCaretColor(Colors.getForegroundColor());

        window.add(scrollPane, BorderLayout.CENTER);
        window.add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(e -> {
            String inputEx = inputField.getText().trim();
            inputField.setText("");
            InputProcessor.processInput(inputEx);
        });

        Screen.printWelcome();
        show();
    }

    public static void show() {
        window.setVisible(true);
    }
}