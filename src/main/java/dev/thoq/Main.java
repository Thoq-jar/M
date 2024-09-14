package dev.thoq;

import dev.thoq.lib.gui.Builder;
import com.google.common.collect.ImmutableMap;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Map;

public class Main {
    public static Map<String, BigDecimal> assignments = ImmutableMap.of();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Builder::BuildGUI);
    }
}