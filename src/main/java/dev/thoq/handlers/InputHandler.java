package dev.thoq.handlers;

import static java.lang.System.out;
import java.util.Scanner;

public class InputHandler {
  private static final Scanner scanner = new Scanner(System.in);
  public static void getEx() {
    out.print(" M Repl > ");
    String inputEx = scanner.nextLine().trim();
    String[] parts = inputEx.split(" ", 2);

    if (inputEx.isEmpty()) {
      getEx();
      return;
    }

    String command = parts[0];

    if (command.isEmpty()) {
      out.println(" Command cannot be empty. Please enter a valid command.");
      getEx();
      return;
    }

    if (parts.length > 1 && parts[1].startsWith("[") && parts[1].endsWith("]")) {
      String expression = parts[1].substring(1, parts[1].length() - 1).trim();
      CmdProcessor.evl(command, expression);
    } else {
      out.println(" Invalid input format. Please use: command [args]");
      getEx();
    }
  }
}
