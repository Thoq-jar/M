package dev.thoq;

import dev.thoq.handlers.*;
import dev.thoq.lib.*;
import java.util.*;

public class Main {
  public static final Map<String, Double> assignments = new HashMap<>();
  public static void main(String[] args) {
    Lib.log("+---------------------+");
    Lib.log("+    M: Calculator    +");
    Lib.log("+  Dev Build (91424)  +");
    Lib.log("+---------------------+");
    Lib.log(" ");
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