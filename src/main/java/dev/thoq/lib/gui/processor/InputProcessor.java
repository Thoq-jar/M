package dev.thoq.lib.gui.processor;

import dev.thoq.handlers.CmdProcessor;
import dev.thoq.lib.Screen;

public class InputProcessor {
  public static void processInput(String inputEx) {
    String[] parts = inputEx.split(" ", 2);
    if (inputEx.isEmpty()) return;

    String command = parts[0];

    if (command.isEmpty()) {
      Screen.println(" Command cannot be empty. Please enter a valid command.");
      return;
    }

    if (parts.length > 1 && parts[1].startsWith("[") && parts[1].endsWith("]")) {
      String expression = parts[1].substring(1, parts[1].length() - 1).trim();
      CmdProcessor.evl(command, expression);
    } else if (command.equals("exit") || command.equals("quit") || command.equals("clear") || command.equals("help") || command.equals("pi->gen")) {
      CmdProcessor.evl(command, "");
    } else {
      Screen.println(" Invalid input format. Please use: command |args|");
    }
  }
}
