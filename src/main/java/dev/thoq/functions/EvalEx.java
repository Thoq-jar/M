package dev.thoq.functions;

import dev.thoq.handlers.InputHandler;
import dev.thoq.lib.Lib;

import static java.lang.System.out;

public class EvalEx {
  public static void evalEx(String expression) {
    try {
      double result = Lib.eval(expression);
      out.println(" " + result);
    } catch (Exception e) {
      out.println(" Error evaluating expression: " + e.getMessage());
      InputHandler.getEx();
    }
  }
}
