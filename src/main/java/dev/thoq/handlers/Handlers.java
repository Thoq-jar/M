package dev.thoq.handlers;

import dev.thoq.Main;
import dev.thoq.functions.Classify;
import dev.thoq.functions.EvalEx;
import dev.thoq.functions.Help;
import dev.thoq.lib.Lib;
import dev.thoq.lib.Screen;

import java.text.DecimalFormat;
import java.util.Objects;

import static java.lang.System.exit;

public class Handlers {
  public static void classifyHandler(String inputNum) {
    try {
      double number = Double.parseDouble(inputNum);
      String result = Classify.classify(number);
      Screen.println(result);
    } catch (NumberFormatException e) {
      Screen.println(" Invalid number format.");
    }
  }

  public static void evalExHandler(String expression) {
    EvalEx.evalEx(expression);
  }

  public static void clearHandler(String input) {
    Screen.clear();
    if (!Objects.equals(input, "")) Screen.println("Command 'clear' doesnt take any arguments.");
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
      Screen.println(" " + result);
    } catch (Exception e) {
      Screen.println(" Error evaluating algebraic expression: " + e.getMessage());
    }
  }

  public static void sqrtHandler(String inputEx) {
    try {
      double number = Double.parseDouble(inputEx);
      double result = Math.sqrt(number);
      Screen.println(" " + result);
    } catch (Exception e) {
      Screen.println(" Error calculating square root: " + e.getMessage());
    }
  }

  public static void sciNotHandler(String inputEx) {
    try {
      double number = Double.parseDouble(inputEx);

      DecimalFormat df = new DecimalFormat("#.##");
      String formattedResult = df.format(number);

      Screen.println(" " + formattedResult);
    } catch (NumberFormatException e) {
      Screen.println(" Error parsing number: " + e.getMessage());
    } catch (Exception e) {
      Screen.println(" Error calculating: " + e.getMessage());
    }
  }

  public static void helpHandler(String input) {
    Help.helpMenu(input);
  }

  public static void exitHandler() { exit(0); }
}