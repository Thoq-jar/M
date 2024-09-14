package dev.thoq.handlers;

import dev.thoq.Main;
import dev.thoq.functions.Classify;
import dev.thoq.functions.EvalEx;
import dev.thoq.functions.Help;
import dev.thoq.lib.Lib;

import static java.lang.System.out;

public class Handlers {
  public static void classifyHandler(String inputNum) {
    try {
      double number = Double.parseDouble(inputNum);
      String result = Classify.classify(number);
      out.println(result);
      InputHandler.getEx();
    } catch (NumberFormatException e) {
      out.println(" Invalid number format.");
      InputHandler.getEx();
    }
  }

  public static void evalExHandler(String expression) {
    EvalEx.evalEx(expression);
    InputHandler.getEx();
  }

  public static void algExHandler(String inputEx) {
    try {
      String[] parts = inputEx.split(",");
      StringBuilder expression = new StringBuilder();

      for (String part : parts) {
        part = part.trim();
        if (part.contains("=")) {
          String[] assignment = part.split("=");
          Main.assignments.put(assignment[0].trim(), Double.parseDouble(assignment[1].trim()));
        } else {
          expression.append(part).append(" ");
        }
      }

      String expr = expression.toString().trim();
      double result = Lib.eval(expr);
      out.println(" " + result);
    } catch (Exception e) {
      out.println(" Error evaluating algebraic expression: " + e.getMessage());
    }
    InputHandler.getEx();
  }

  public static void sqrtHandler(String inputEx) {
    try {
      double number = Double.parseDouble(inputEx);
      double result = Math.sqrt(number);
      out.println(" " + result);
    } catch (Exception e) {
      out.println(" Error calculating square root: " + e.getMessage());
    }
    InputHandler.getEx();
  }

  public static void helpHandler(String input) {
    if (!input.isEmpty()) {
      out.println(" The 'help' command doesn't take arguments!");
    }
    Help.helpMenu();
    InputHandler.getEx();
  }

  public static void exitHandler() {
    System.exit(0);
  }

}
