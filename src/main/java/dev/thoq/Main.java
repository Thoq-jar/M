package dev.thoq;

import dev.thoq.lib.gui.Builder;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<String, Double> assignments = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Builder::BuildGUI);
    }
}