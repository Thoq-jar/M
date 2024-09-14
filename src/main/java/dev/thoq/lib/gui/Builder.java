package dev.thoq.lib.gui;

import dev.thoq.Main;
import dev.thoq.lib.Colors;
import dev.thoq.lib.Screen;
import dev.thoq.lib.gui.processor.InputProcessor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static java.lang.System.err;
import static java.lang.System.out;

public class Builder {
    public static JTextArea outputArea;
    public static JTextField inputField;
    public static JFrame window = new JFrame("M: Calculator");

    public static void BuildGUI() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 900);
        window.setLayout(new BorderLayout());
        window.getContentPane().setBackground(Colors.getBackgroundColor());

        URL resource = Main.class.getResource("/icon.png");
        if (resource == null) {
            err.println("Resource not found: icon.png");

            String relativePath = "icon.png";
            URL relativeResource = Main.class.getResource(relativePath);
            if (relativeResource == null) {
                err.println("Relative resource not found: " + relativePath);

                String absolutePath = "icon.png";
                File file = new File(absolutePath);
                out.println("Falling back to local icon...");
                if (!file.exists()) {
                    err.println("File does not exist at: " + absolutePath);
                } else {
                    try {
                        out.println("Fell back successfully!");
                        ImageIcon icon = new ImageIcon(file.toURI().toURL());
                        window.setIconImage(icon.getImage());
                    } catch (IOException e) {
                        err.println("Error loading icon: " + e.getMessage());
                    }
                }
            } else {
                ImageIcon icon = new ImageIcon(relativeResource);
                window.setIconImage(icon.getImage());
            }
        } else {
            ImageIcon icon = new ImageIcon(resource);
            window.setIconImage(icon.getImage());
        }

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Colors.getForegroundColor());
        outputArea.setCaretColor(Colors.getForegroundColor());

        JScrollPane scrollPane = new JScrollPane(outputArea);

        inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 24));
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