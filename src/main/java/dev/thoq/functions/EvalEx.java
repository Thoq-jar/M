package dev.thoq.functions;

import dev.thoq.handlers.InputHandler;
import dev.thoq.lib.Lib;
import dev.thoq.lib.Screen;

import java.math.BigDecimal;

public class EvalEx {
  public static void evalEx(String expression) {
    try {
      BigDecimal result = Lib.eval(expression);
      BigDecimal formattedResult = result.stripTrailingZeros();
      Screen.println(" " + formattedResult.toPlainString());
    } catch (Exception e) {
      Screen.println(" Error evaluating expression: " + e.getMessage());
      InputHandler.getEx();
    }
  }
}