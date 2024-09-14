package dev.thoq;

import dev.thoq.handlers.*;
import dev.thoq.lib.*;
import java.util.*;

public class Main {
  public static final Map<String, Double> assignments = new HashMap<>();
  private static final String BANNER = """
      +---------------------+
      +    M: Calculator    +
      +  Dev Build (91424)  +
      +---------------------+
      """;

  public static void main(String[] args) {
    Lib.log(BANNER);
    Lib.log(" Welcome to M!");
    Lib.log(" For help, enter help []");
    try {
      InputHandler.getEx();
    } catch (Exception e) {
      Lib.log("\n Goodbye!");
      Handlers.exitHandler();
    }
  }
}