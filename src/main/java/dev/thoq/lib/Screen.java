package dev.thoq.lib;

import dev.thoq.lib.gui.Builder;

import java.util.Arrays;

public class Screen {
  public static String banner = """
        __  __     _
       |  ||  |   | |    __ _ _ __   __ _
       | |||| |   | |   / _` | '_ | / _` |
       | |  | |   | |__| (_| | | | | (_| |
       |_|  |_|   |_____|__,_|_| |_||__, |
                                     |___/
      """;

  public static void print(String output) {
    Builder.outputArea.append(output);
  }

  public static void println(String output) {
    Builder.outputArea.append(output + "\n");
  }

  public static void printWelcome() {
    for (String s : Arrays.asList(banner, " M: Calculator", " Dev Build (91024)", " ", " Welcome to M!", " For help, enter 'help []'", ""))
      Screen.println(s);
  }

  public static void clear() {
    print("");
    println("");
    Builder.outputArea.setText("");
    printWelcome();
  }
}
