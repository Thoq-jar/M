package dev.thoq.functions;

import dev.thoq.handlers.InputHandler;
import dev.thoq.lib.Lib;
import dev.thoq.lib.Screen;

public class EvalEx {
  public static void evalEx(String expression) {
    try {
      double result = Lib.eval(expression);
      Screen.println(" " + result);
    } catch (Exception e) {
      Screen.println(" Error evaluating expression: " + e.getMessage());
      InputHandler.getEx();
    }
  }
}
