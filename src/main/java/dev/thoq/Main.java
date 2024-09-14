package dev.thoq;

import dev.thoq.lib.gui.Builder;
import com.google.common.collect.ImmutableMap;

import javax.swing.*;
import java.util.Map;

public class Main {
    public static Map<String, Double> assignments = ImmutableMap.of();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Builder::BuildGUI);
    }
}